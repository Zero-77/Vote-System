package votesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import votesystem.model.Item;
import votesystem.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

//實踐投票項目item
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(Item item) {
        this.itemRepository.save(item);
    }

    @Override
    public Item getItemById(int id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException("Item not found id : " + id);
        }
        return item;
    }

    @Override
    public void deleteItemById(int id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public Page<Item> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.itemRepository.findAll(pageable);
    }
}
