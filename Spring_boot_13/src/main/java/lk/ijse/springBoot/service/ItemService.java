package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.ItemDto;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDto itemDto);

    void updateItem(ItemDto itemDto);

    void deleteItem(int itemCode);

    List<ItemDto> getAllItems();
}
