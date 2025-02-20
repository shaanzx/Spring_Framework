package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.ItemDto;

import java.util.List;

public interface ItemService {

    boolean saveItem(ItemDto itemDto);

    boolean updateItem(ItemDto itemDto);

    boolean deleteItem(int itemCode);

    List<ItemDto> getAllItems();
}
