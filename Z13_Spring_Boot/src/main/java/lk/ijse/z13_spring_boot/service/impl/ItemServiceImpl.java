package lk.ijse.z13_spring_boot.service.impl;

import lk.ijse.z13_spring_boot.dto.ItemDTO;
import lk.ijse.z13_spring_boot.entity.Item;
import lk.ijse.z13_spring_boot.repo.ItemRepo;
import lk.ijse.z13_spring_boot.service.ItemService;
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
    public void save(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException("Item already exists");
        }
//        Item item = new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty());
//        itemRepo.save(item);
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public List<ItemDTO> getAll() {
//        return itemRepo.findAll().stream()
//                .map(item -> new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getQty()))
//                .collect(Collectors.toList());
        return modelMapper.map(itemRepo.findAll(), new TypeToken<List<ItemDTO>>() {
        }.getType());
    }

    @Override
    public ItemDTO getById(int id) {
        Optional<Item> optionalItem = itemRepo.findById(id);
        if (optionalItem.isPresent()) {
            return modelMapper.map(optionalItem.get(), ItemDTO.class);
        }
        throw new RuntimeException("Customer not found");
    }

    @Override
    public void update(ItemDTO itemDTO) {
//        Optional<Item> optionalItem = itemRepo.findById(itemDTO.getId());
//        if (optionalItem.isPresent()) {
//            Item item = optionalItem.get();
//            item.setName(itemDTO.getName());
//            item.setPrice(itemDTO.getPrice());
//            item.setQty(itemDTO.getQty());
        if (itemRepo.existsById(itemDTO.getId())) {
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
        }
        throw new RuntimeException("Item does not exist");
    }

    @Override
    public void delete(int id) {
        if (itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
        }
        throw new RuntimeException("Item does not exist");
    }
}
