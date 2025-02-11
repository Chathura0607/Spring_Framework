package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("json")
public class JSONController {
//    @PostMapping
//    public String test1() {
//        return "test1";
//    }

    @PostMapping
    public String test1(@RequestBody CustomerDTO customerDTO) {
        return customerDTO.getFirstName();
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO test2() {
        return new CustomerDTO("Achini", "Pramodhya", 22);
    }

    @GetMapping(path = "data" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<CustomerDTO> test3() {
        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();
        customerDTOs.add(new CustomerDTO("Achini", "Pramodhya", 22));
        customerDTOs.add(new CustomerDTO("Kamal", "Wageesha", 23));
        customerDTOs.add(new CustomerDTO("Nimal", "Sampath", 24));
        ArrayList<CustomerDTO> list = new ArrayList<>();
        return customerDTOs;
    }
}