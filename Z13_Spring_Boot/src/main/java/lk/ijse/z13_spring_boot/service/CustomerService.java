package lk.ijse.z13_spring_boot.service;

import lk.ijse.z13_spring_boot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void save(CustomerDTO customerDTO);

    List<CustomerDTO> getAll();

    CustomerDTO getById(int id);

    void update(CustomerDTO customerDTO);

    void delete(int id);
}
