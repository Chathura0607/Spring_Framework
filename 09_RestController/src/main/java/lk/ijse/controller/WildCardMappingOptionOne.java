package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class WildCardMappingOptionOne {
    //one/test/1/hello
    //one/test//hello (not found)
    //one/test/asv/hello
    @GetMapping("test/*/hello")
    public String test() {
        return "Get Mapping Option One";
    }

    @GetMapping("test/*/*")
    public String test2() {
        return "Get Mapping Option One";
    }
}
