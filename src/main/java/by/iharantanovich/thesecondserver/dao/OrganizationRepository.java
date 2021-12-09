package by.iharantanovich.thesecondserver.dao;

import by.iharantanovich.thesecondserver.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
