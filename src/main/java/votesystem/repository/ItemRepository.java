package votesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import votesystem.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
