package by.iharantanovich.thesecondserver.dao;

import by.iharantanovich.thesecondserver.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
