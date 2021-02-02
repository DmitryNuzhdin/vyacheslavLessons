package webAppExample;

import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<RecordEntity, String> {
    long countByValue(String value);
}
