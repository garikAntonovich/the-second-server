package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.model.ReceivedData;
import by.iharantanovich.thesecondserver.model.OrganizationStatistics;
import by.iharantanovich.thesecondserver.model.DocumentStaticstics;

import java.util.List;

public interface DocumentService {

    void saveOrUpdate(List<ReceivedData> receivedData);

    DocumentStaticstics getDocumentStatistics();

    List<OrganizationStatistics> getOrganizationStatistics(String organizationName);

    void writeExcel();
}
