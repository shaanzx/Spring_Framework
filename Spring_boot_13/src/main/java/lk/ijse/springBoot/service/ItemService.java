package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDTO itemDto);

    void updateItem(ItemDTO itemDto);

    void deleteItem(int itemCode);

    List<ItemDTO> getAllItems();
}
