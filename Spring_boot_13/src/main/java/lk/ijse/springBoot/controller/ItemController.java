package lk.ijse.springBoot.controller;

import lk.ijse.springBoot.dto.ItemDto;
import lk.ijse.springBoot.service.ItemService;
import lk.ijse.springBoot.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/item")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveItem(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response("Item saved successfully", HttpStatus.CREATED));
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateItem(@RequestBody ItemDto itemDto) {
        itemService.updateItem(itemDto);
        return ResponseEntity
                .ok(new Response("Item updated successfully", HttpStatus.OK));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok(new Response("Item deleted successfully", HttpStatus.OK));
    }

    @GetMapping("/get")
    public ResponseEntity<Response> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity
                .ok(new Response("Items retrieved successfully", HttpStatus.OK, items));
    }
}