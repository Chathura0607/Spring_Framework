package lk.ijse.z13_spring_boot.service;

import lk.ijse.z13_spring_boot.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void save(ItemDTO itemDTO);

    List<ItemDTO> getAll();

    ItemDTO getById(int id);

    void update(ItemDTO itemDTO);

    void delete(int id);
}
