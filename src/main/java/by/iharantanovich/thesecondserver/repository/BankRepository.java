package by.iharantanovich.thesecondserver.repository;

import by.iharantanovich.thesecondserver.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByBicPay(String bicPay);
}
