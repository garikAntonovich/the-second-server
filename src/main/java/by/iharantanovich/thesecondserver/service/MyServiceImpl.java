package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.dao.AccountRepository;
import by.iharantanovich.thesecondserver.dao.BankRepository;
import by.iharantanovich.thesecondserver.dao.DocumentRepository;
import by.iharantanovich.thesecondserver.dao.OrganizationRepository;
import by.iharantanovich.thesecondserver.entity.Account;
import by.iharantanovich.thesecondserver.entity.Bank;
import by.iharantanovich.thesecondserver.entity.Document;
import by.iharantanovich.thesecondserver.entity.Organization;
import by.iharantanovich.thesecondserver.model.ExtractedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {

    protected DocumentRepository documentRepository;
    protected OrganizationRepository organizationRepository;
    protected AccountRepository accountRepository;
    protected BankRepository bankRepository;

    @Autowired
    public MyServiceImpl(DocumentRepository documentRepository, OrganizationRepository organizationRepository,
                         AccountRepository accountRepository, BankRepository bankRepository) {
        this.documentRepository = documentRepository;
        this.organizationRepository = organizationRepository;
        this.accountRepository = accountRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public void saveData(List<ExtractedData> extractedDataList) {
        Document document;
        Organization organization;
        Account account;
        Bank bank;
        for (int i = 0; i < extractedDataList.size(); i++) {
            document = new Document();
            organization = new Organization();
            account = new Account();
            bank = new Bank();

            document.setDocNum(extractedDataList.get(i).getDocNum());
            document.setDocDate(extractedDataList.get(i).getDocDate());
            document.setDocGUID(extractedDataList.get(i).getDocGUID());
            document.setOperType(extractedDataList.get(i).getOperType());
            document.setAmountOut(extractedDataList.get(i).getAmountOut());


            organization.setInnPay(extractedDataList.get(i).getInfPay().getInnPay());
            organization.setKppPay(extractedDataList.get(i).getInfPay().getKppPay());
            organization.setCnamePay(extractedDataList.get(i).getInfPay().getcNamePay());

            organization.setInnPay(extractedDataList.get(i).getInfRcp().getInnPay());
            organization.setKppPay(extractedDataList.get(i).getInfRcp().getKppPay());
            organization.setCnamePay(extractedDataList.get(i).getInfRcp().getcNamePay());
            organizationRepository.save(organization);

            bank.setBicPay(extractedDataList.get(i).getBankPay().getBicPay());

            bank.setBicPay(extractedDataList.get(i).getBankRcp().getBicPay());
            bankRepository.save(bank);

            account.setBsPay(extractedDataList.get(i).getBankPay().getBsPay());
            account.setBsKsPay(extractedDataList.get(i).getBankPay().getBsKsPay());

            account.setBsPay(extractedDataList.get(i).getBankRcp().getBsPay());
            account.setBsKsPay(extractedDataList.get(i).getBankRcp().getBsKsPay());
            account.setBank(bank);
            account.setOrganization(organization);
            accountRepository.save(account);

            document.setPayer(organization);
            document.setRecipient(organization);
            document.setPayerAccount(account);
            document.setRecipientAccount(account);
            documentRepository.save(document);
        }
    }
}
