package by.iharantanovich.thesecondserver.dao;

import by.iharantanovich.thesecondserver.entity.Organization;

import java.util.List;

public interface OrganizationDAO {

    List<Organization> getAllOrganizations();

    void saveOrganizations(Organization organization);
}
