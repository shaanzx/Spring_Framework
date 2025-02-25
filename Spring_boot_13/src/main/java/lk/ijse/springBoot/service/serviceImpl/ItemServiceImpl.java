package lk.ijse.springBoot.service.serviceImpl;

import lk.ijse.springBoot.dto.ItemDTO;
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
    public void saveItem(ItemDTO itemDto) {
           if (itemRepo.existsById(itemDto.getItemCode())) {
                throw new RuntimeException("Item already exists");
            }
           itemRepo.save(modelMapper.map(itemDto, Item.class));
    }

    @Override
    public void updateItem(ItemDTO itemDto) {

            Optional<Item> optionalCustomer = itemRepo.findById(itemDto.getItemCode());
            if (optionalCustomer.isPresent()) {
                Item item = optionalCustomer.get();
                modelMapper.map(itemDto,item);
                itemRepo.save(item);
            } else {
                throw new RuntimeException("Item not found");
            }
    }

    @Override
    public void deleteItem(int itemCode) {

            Optional<Item> optionalItem = itemRepo.findById(String.valueOf(itemCode));
            if (optionalItem.isPresent()) {
                itemRepo.deleteById(String.valueOf(itemCode));
            } else {
                throw new RuntimeException("Item not found");
            }
    }

    @Override
    public List<ItemDTO> getAllItems() {
            return modelMapper.map(itemRepo.findAll(),new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
