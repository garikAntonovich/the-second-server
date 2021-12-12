package by.iharantanovich.thesecondserver.repository;

import by.iharantanovich.thesecondserver.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findByInnPayAndKppPay(String innPay, String kppPay);
    Organization findByCnamePay(String cnamePay);
}
