package lk.ijse.z13_spring_boot.controller;

import lk.ijse.z13_spring_boot.dto.ItemDTO;
import lk.ijse.z13_spring_boot.service.impl.ItemServiceImpl;
import lk.ijse.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @PostMapping(path = "save")
    public ResponseUtil getItem(@RequestBody ItemDTO itemDTO) {
        itemServiceImpl.save(itemDTO);
        return new ResponseUtil(201, "Item is Saved!", null);
    }

    @GetMapping(path = "getAll")
    public ResponseUtil getItems() {
        return new ResponseUtil(200, "Success", itemServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    public ResponseUtil getItemById(@PathVariable int id) {
        return new ResponseUtil(200, "Success", itemServiceImpl.getById(id));
    }

    @PutMapping(path = "update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        itemServiceImpl.update(itemDTO);
        return new ResponseUtil(200, "Item is Updated!", null);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteItem(@PathVariable int id) {
        itemServiceImpl.delete(id);
        return new ResponseUtil(200, "Item is Deleted!", null);
    }
}
