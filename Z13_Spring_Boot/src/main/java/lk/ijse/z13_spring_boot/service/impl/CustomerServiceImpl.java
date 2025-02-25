package lk.ijse.z13_spring_boot.service.impl;

import lk.ijse.z13_spring_boot.dto.CustomerDTO;
import lk.ijse.z13_spring_boot.entity.Customer;
import lk.ijse.z13_spring_boot.repo.CustomerRepo;
import lk.ijse.z13_spring_boot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CustomerDTO customerDTO) {
//        Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
//
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer already exists");
        }
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public List<CustomerDTO> getAll() {
//        return customerRepo.findAll().stream()
//                .map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()))
//                .collect(Collectors.toList());
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public CustomerDTO getById(int id) {
        Optional<Customer> optionalCustomer = customerRepo.findById(id);
        if (optionalCustomer.isPresent()) {
            return modelMapper.map(optionalCustomer.get(), CustomerDTO.class);
        }
        throw new RuntimeException("Customer not found");
    }

    @Override
    public void update(CustomerDTO customerDTO) {
//        Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getId());
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            customer.setName(customerDTO.getName());
//            customer.setAddress(customerDTO.getAddress());
//            customerRepo.save(customer);
        if (customerRepo.existsById(customerDTO.getId())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
//            return true;
        }
        throw new RuntimeException("Customer does not exist");
    }

    @Override
    public void delete(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        }
        throw new RuntimeException("Customer does not exist");
    }
}