package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.entity.Account;
import by.iharantanovich.thesecondserver.entity.Bank;
import by.iharantanovich.thesecondserver.entity.Document;
import by.iharantanovich.thesecondserver.entity.Organization;
import by.iharantanovich.thesecondserver.model.ExtractedData;
import by.iharantanovich.thesecondserver.model.OrganizationData;
import by.iharantanovich.thesecondserver.model.Statistic;
import by.iharantanovich.thesecondserver.repository.AccountRepository;
import by.iharantanovich.thesecondserver.repository.BankRepository;
import by.iharantanovich.thesecondserver.repository.DocumentRepository;
import by.iharantanovich.thesecondserver.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveOrUpdate(List<ExtractedData> extractedDataList) {

        for (ExtractedData extractedData : extractedDataList) {

            Bank bankPayer = new Bank(extractedData.getBankPay().getBicPay());
            Bank bankRecipient = new Bank((extractedData.getBankRcp().getBicPay()));

            Account accountPayer = new Account(extractedData.getBankPay().getBsPay(), extractedData.getBankPay().getBsKsPay());
            Account accountRecipient = new Account(extractedData.getBankRcp().getBsPay(), extractedData.getBankRcp().getBsKsPay());

            Organization payer = new Organization(extractedData.getInfPay().getInnPay(), extractedData.getInfPay().getKppPay(),
                    extractedData.getInfPay().getcNamePay());
            Organization recipient = new Organization(extractedData.getInfRcp().getInnPay(), extractedData.getInfRcp().getKppPay(),
                    extractedData.getInfRcp().getcNamePay());

            Document document = new Document(extractedData.getDocNum(), extractedData.getDocDate(), extractedData.getDocGUID(),
                    extractedData.getOperType(), extractedData.getAmountOut());

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
    public Statistic getStatistic() {
        double averageAmount = 0;
        for (Document document : documentRepository.findAll()) {
            averageAmount += document.getAmountOut();
        }
        return new Statistic(documentRepository.findAll().size(), averageAmount / documentRepository.findAll().size());
    }

    @Override
    public List<OrganizationData> getOrganizationData(String organizationName) {

        List<OrganizationData> organizationDataList = new ArrayList<>();
        OrganizationData organizationData;

        for (Organization organization : organizationRepository.findAll()) {

            organizationData = new OrganizationData();

            if (organizationName != null) {
                organizationData.setName(organizationRepository.findByCnamePay(organizationName).getCnamePay());
            } else {
                organizationData.setName(organization.getCnamePay());
            }

            organizationData.setQuantityOfDocPayer(documentRepository.findAllByPayerId(organizationRepository.
                    findByCnamePay(organizationData.getName()).getId()).size());
            organizationData.setQuantityOfDocRecipient(documentRepository.findAllByRecipientId(organizationRepository.
                    findByCnamePay(organizationData.getName()).getId()).size());

            organizationDataList.add(organizationData);

            if (organizationName != null) {
                break;
            }
        }

        return organizationDataList;
    }
}
