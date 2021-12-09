package by.iharantanovich.thesecondserver.dao;

import by.iharantanovich.thesecondserver.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
