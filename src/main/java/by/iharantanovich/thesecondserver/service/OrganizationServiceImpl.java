package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.dao.OrganizationDAO;
import by.iharantanovich.thesecondserver.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDAO organizationDAO;


    @Override
    @Transactional
    public List<Organization> getAllOrganizations() {
        return organizationDAO.getAllOrganizations();
    }

    @Override
    @Transactional
    public void saveOrganization(Organization organization) {
        organizationDAO.saveOrganizations(organization);
    }
}
