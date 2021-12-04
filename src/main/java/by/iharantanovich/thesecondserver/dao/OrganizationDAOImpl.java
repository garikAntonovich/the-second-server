package by.iharantanovich.thesecondserver.dao;

import by.iharantanovich.thesecondserver.entity.Organization;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Organization> getAllOrganizations() {

        Session session = entityManager.unwrap(Session.class);

        Query<Organization> query = session.createQuery("from Organization", Organization.class);
        List<Organization> allOrganizations = query.getResultList();
        return allOrganizations;
    }

    @Override
    public void saveOrganizations(Organization organization) {

        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(organization);
    }
}
