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
@RequestMapping(value = "api/v1/item", produces = "application/json")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<Response> saveItem(@RequestBody ItemDto itemDto) {
        try {
            boolean isSaved = itemService.saveItem(itemDto);
            if (isSaved) {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(new Response("Item saved successfully", HttpStatus.CREATED));
            }
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new Response("Failed to save item", HttpStatus.BAD_REQUEST));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("Error saving item: " + e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateItem(@RequestBody ItemDto itemDto) {
        try {
            boolean isUpdated = itemService.updateItem(itemDto);
            if (isUpdated) {
                return ResponseEntity
                        .ok(new Response("Item updated successfully", HttpStatus.OK));
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new Response("Item not found", HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("Error updating item: " + e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response> deleteItem(@PathVariable int id) {
        try {
            boolean isDeleted = itemService.deleteItem(id);
            if (isDeleted) {
                return ResponseEntity
                        .ok(new Response("Item deleted successfully", HttpStatus.OK));
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new Response("Item not found", HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("Error deleting item: " + e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Response> getAllItems() {
        try {
            List<ItemDto> items = itemService.getAllItems();
            return ResponseEntity
                    .ok(new Response("Items retrieved successfully", HttpStatus.OK, items));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("Error retrieving items: " + e.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }
}