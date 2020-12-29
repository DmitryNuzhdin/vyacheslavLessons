package orm;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsumerRepo extends CrudRepository<Consumer, Long> {
    List<Consumer> findByName(String name);
}
