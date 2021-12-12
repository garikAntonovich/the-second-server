package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.model.ExtractedData;
import by.iharantanovich.thesecondserver.repository.AccountRepository;
import by.iharantanovich.thesecondserver.repository.BankRepository;
import by.iharantanovich.thesecondserver.repository.DocumentRepository;
import by.iharantanovich.thesecondserver.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        }
    }
}
