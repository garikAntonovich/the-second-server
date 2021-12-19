package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.entity.Account;
import by.iharantanovich.thesecondserver.entity.Bank;
import by.iharantanovich.thesecondserver.entity.Document;
import by.iharantanovich.thesecondserver.entity.Organization;
import by.iharantanovich.thesecondserver.model.DocumentStaticstics;
import by.iharantanovich.thesecondserver.model.OrganizationStatistics;
import by.iharantanovich.thesecondserver.model.ReceivedData;
import by.iharantanovich.thesecondserver.repository.AccountRepository;
import by.iharantanovich.thesecondserver.repository.BankRepository;
import by.iharantanovich.thesecondserver.repository.DocumentRepository;
import by.iharantanovich.thesecondserver.repository.OrganizationRepository;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    protected BankRepository bankRepository;
    protected AccountRepository accountRepository;
    protected OrganizationRepository organizationRepository;
    protected DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(BankRepository bankRepository, AccountRepository accountRepository, OrganizationRepository organizationRepository,
                               DocumentRepository documentRepository) {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
        this.organizationRepository = organizationRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public void saveOrUpdate(List<ReceivedData> receivedDataList) {

        for (ReceivedData receivedData : receivedDataList) {

            Bank bankPayer = new Bank(receivedData.getBankPay().getBicPay());
            Bank bankRecipient = new Bank((receivedData.getBankRcp().getBicPay()));

            Account accountPayer = new Account(receivedData.getBankPay().getBsPay(), receivedData.getBankPay().getBsKsPay());
            Account accountRecipient = new Account(receivedData.getBankRcp().getBsPay(), receivedData.getBankRcp().getBsKsPay());

            Organization payer = new Organization(receivedData.getInfPay().getInnPay(), receivedData.getInfPay().getKppPay(),
                    receivedData.getInfPay().getCnamePay());
            Organization recipient = new Organization(receivedData.getInfRcp().getInnPay(), receivedData.getInfRcp().getKppPay(),
                    receivedData.getInfRcp().getCnamePay());

            Document document = new Document(receivedData.getDocNum(), receivedData.getDocDate(), receivedData.getDocGUID(),
                    receivedData.getOperType(), receivedData.getAmountOut());

            if (documentRepository.findByDocNum(document.getDocNum()) != null) {
                document = documentRepository.findByDocNum(document.getDocNum());
            }

            if (bankRepository.findByBicPay(bankPayer.getBicPay()) == null) {
                payer.setBank(bankPayer);
            } else {
                payer.setBank(bankRepository.findByBicPay(bankPayer.getBicPay()));
            }

            if (bankRepository.findByBicPay(bankRecipient.getBicPay()) == null) {
                recipient.setBank(bankRecipient);
            } else {
                recipient.setBank(bankRepository.findByBicPay(bankRecipient.getBicPay()));
            }

            if (accountRepository.findByBsPay(accountPayer.getBsPay()) == null) {
                document.setPayerAccount(accountPayer);
            } else {
                document.setPayerAccount(accountRepository.findByBsPay(accountPayer.getBsPay()));
            }

            if (accountRepository.findByBsPay(accountRecipient.getBsPay()) == null) {
                document.setRecipientAccount(accountRecipient);
            } else {
                document.setRecipientAccount(accountRepository.findByBsPay(accountRecipient.getBsPay()));
            }

            if (organizationRepository.findByInnPayAndKppPay(payer.getInnPay(), payer.getKppPay()) == null) {
                if (organizationRepository.findByCnamePay(payer.getCnamePay()) == null) {
                    document.setPayer(payer);
                } else {
                    document.setPayer(organizationRepository.findByCnamePay(payer.getCnamePay()));
                }
            } else {
                document.setPayer(organizationRepository.findByInnPayAndKppPay(payer.getInnPay(), payer.getKppPay()));
            }

            if (organizationRepository.findByInnPayAndKppPay(recipient.getInnPay(), recipient.getKppPay()) == null) {
                if (organizationRepository.findByCnamePay(recipient.getCnamePay()) == null) {
                    document.setRecipient(recipient);
                } else {
                    document.setRecipient(organizationRepository.findByCnamePay(recipient.getCnamePay()));
                }
            } else {
                document.setRecipient(organizationRepository.findByInnPayAndKppPay(recipient.getInnPay(), recipient.getKppPay()));
            }

            documentRepository.save(document);
        }
    }

    @Override
    public DocumentStaticstics getDocumentStatistics() {

        List<Document> documents = documentRepository.findAll();

        double amount = 0;
        for (Document document : documents) {
            amount += document.getAmountOut();
        }

        int quantityOfDocuments = documents.size();
        double averageAmount = amount / quantityOfDocuments;

        return new DocumentStaticstics(quantityOfDocuments, averageAmount);
    }

    @Override
    public List<OrganizationStatistics> getOrganizationStatistics(String organizationName) {

        OrganizationStatistics organizationStatistics;
        List<OrganizationStatistics> organizationStatisticsList = new ArrayList<>();
        List<Organization> organizationList = organizationRepository.findAll();

        for (Organization organization : organizationList) {
            String name = organization.getCnamePay();

            if (organizationName != null) {
                if (!name.equals(organizationName))
                    continue;
            }

            int quantityOfDocPayer = documentRepository.findAllByPayerId(organization.getId()).size();
            int quantityOfDocRecipient = documentRepository.findAllByRecipientId(organization.getId()).size();
            organizationStatistics = new OrganizationStatistics(name, quantityOfDocPayer, quantityOfDocRecipient);
            organizationStatisticsList.add(organizationStatistics);

            if (organizationName != null) {
                break;
            }
        }

        return organizationStatisticsList;
    }

    @Override
    public void writeExcel() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Documents");

        int rownum = 0;
        Row row = sheet.createRow(rownum);

        row.createCell(0, CellType.STRING).setCellValue("Номер документа");
        row.createCell(1, CellType.STRING).setCellValue("Дата документа");
        row.createCell(2, CellType.STRING).setCellValue("Сумма документа");
        row.createCell(3, CellType.STRING).setCellValue("Наименование плательщика");
        row.createCell(4, CellType.STRING).setCellValue("БИК банка плательщика");
        row.createCell(5, CellType.STRING).setCellValue("Наименование получателя");
        row.createCell(6, CellType.STRING).setCellValue("БИК банка получателя");

        for (int index = 0; index < documentRepository.findAll().size(); index++) {
            rownum++;
            row = sheet.createRow(rownum);
            row.createCell(0, CellType.STRING).setCellValue(documentRepository.findAll().get(index).getDocNum());
            row.createCell(1, CellType.STRING).setCellValue(documentRepository.findAll().get(index).getDocDate());
            row.createCell(2, CellType.NUMERIC).setCellValue(documentRepository.findAll().get(index).getAmountOut());
            row.createCell(3, CellType.STRING).setCellValue(documentRepository.findAll().get(index).getPayer().getCnamePay());
            row.createCell(4, CellType.STRING).setCellValue(documentRepository.findAll().get(index).getPayer().getBank().getBicPay());
            row.createCell(5, CellType.STRING).setCellValue(documentRepository.findAll().get(index).getRecipient().getCnamePay());
            row.createCell(6, CellType.STRING).setCellValue(documentRepository.findAll().get(index).getRecipient().getBank().getBicPay());
        }

        File file = new File("C:/workspace/the-second-server/src/main/resources/documents.xlsx");
        file.getParentFile().mkdirs();

        try {
            workbook.write(new FileOutputStream(file));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
