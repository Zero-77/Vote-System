package votesystem.service;

import org.springframework.data.domain.Page;
import votesystem.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    void saveItem(Item item);
    Item getItemById(int id);
    void deleteItemById(int id);
    Page<Item> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
