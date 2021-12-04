package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.entity.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> getAllOrganizations();

    void saveOrganization(Organization organization);
}
