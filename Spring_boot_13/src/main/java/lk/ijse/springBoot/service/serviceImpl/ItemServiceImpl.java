package lk.ijse.springBoot.service.serviceImpl;

import lk.ijse.springBoot.dto.ItemDto;
import lk.ijse.springBoot.entity.Item;
import lk.ijse.springBoot.repository.ItemRepo;
import lk.ijse.springBoot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveItem(ItemDto itemDto) {
            try {
                itemRepo.save(modelMapper.map(itemDto, Item.class));
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error saving item: " + e.getMessage());
            }
    }

    @Override
    public boolean updateItem(ItemDto itemDto) {
        try {
            Optional<Item> optionalCustomer = itemRepo.findById(itemDto.getItemCode());
            if (optionalCustomer.isPresent()) {
                Item item = optionalCustomer.get();
                modelMapper.map(itemDto,item);
                itemRepo.save(item);
                return true;
            } else {
                throw new RuntimeException("Item not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating item: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteItem(int itemCode) {
        try {
            Optional<Item> optionalItem = itemRepo.findById(itemCode);
            if (optionalItem.isPresent()) {
                itemRepo.deleteById(itemCode);
                return true;
            } else {
                throw new RuntimeException("Item not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting item: " + e.getMessage());
        }
    }

    @Override
    public List<ItemDto> getAllItems() {
        try {
            return modelMapper.map(itemRepo.findAll(),new TypeToken<List<ItemDto>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving items: " + e.getMessage());
        }
    }
}
