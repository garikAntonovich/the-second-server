package by.iharantanovich.thesecondserver.repository;

import by.iharantanovich.thesecondserver.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document findByDocNum(String docNum);

    List<Document> findAllByPayerId(long id);

    List<Document> findAllByRecipientId(long id);
}
