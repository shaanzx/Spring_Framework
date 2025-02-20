package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.ItemDto;
import lk.ijse.springBoot.entity.Item;
import lk.ijse.springBoot.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;
    public boolean saveItem(ItemDto itemDto) {
            try {
                itemRepo.save(new Item(
                        itemDto.getItemCode(),
                        itemDto.getDescription(),
                        itemDto.getUnitPrice(),
                        itemDto.getQtyOnHand()
                ));
                return true;
            } catch (Exception e) {
                throw new RuntimeException("Error saving item: " + e.getMessage());
            }
    }

    public boolean updateItem(ItemDto itemDto) {
        try {
            Optional<Item> optionalItem = itemRepo.findById(itemDto.getItemCode());
            if (optionalItem.isPresent()) {
                Item item = optionalItem.get();
                item.setDescription(itemDto.getDescription());
                item.setUnitPrice(itemDto.getUnitPrice());
                item.setQtyOnHand(itemDto.getQtyOnHand());
                itemRepo.save(item);
                return true;
            } else {
                throw new RuntimeException("Item not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating item: " + e.getMessage());
        }
    }

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

    public List<ItemDto> getAllItems() {
        try {
            List<Item> items = itemRepo.findAll();
            List<ItemDto> itemDtos = new ArrayList<>();
            for (Item item : items) {
                itemDtos.add(new ItemDto(
                        item.getItemCode(),
                        item.getDescription(),
                        item.getUnitPrice(),
                        item.getQtyOnHand()
                ));
            }
            return itemDtos;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving items: " + e.getMessage());
        }
    }
}
