package lk.ijse.z13_spring_boot.controller;

import lk.ijse.z13_spring_boot.dto.CustomerDTO;
import lk.ijse.z13_spring_boot.service.impl.CustomerServiceImpl;
import lk.ijse.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping(path = "save")
    public ResponseUtil getCustomer(@RequestBody CustomerDTO customerDTO) {
        customerServiceImpl.save(customerDTO);
        return new ResponseUtil(200, "Customer is saved", null);
    }

    @GetMapping(path = "getAll")
//    public List<CustomerDTO> getCustomers() {
//        return customerService.getAll();
//}
    public ResponseUtil getCustomers() {
        return new ResponseUtil(200, "Success", customerServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    public ResponseUtil getCustomerById(@PathVariable int id) {
        return new ResponseUtil(200, "Success", customerServiceImpl.getById(id));
    }

    @PutMapping(path = "update")
//    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) {
//        return customerService.update(customerDTO);

    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
//        boolean res = customerServiceImpl.update(customerDTO);
        customerServiceImpl.update(customerDTO);
        return new ResponseUtil(200, "Customer is updated", null);
    }


    @DeleteMapping(path = "delete/{id}")
//    public boolean deleteCustomer(@PathVariable int id) {
//        return customerService.delete(id);
//    }
    public ResponseUtil deleteCustomer(@PathVariable int id) {
        customerServiceImpl.delete(id);
        return new ResponseUtil(200, "Customer is deleted", null);
    }
}