package by.iharantanovich.thesecondserver.dao;

import by.iharantanovich.thesecondserver.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
