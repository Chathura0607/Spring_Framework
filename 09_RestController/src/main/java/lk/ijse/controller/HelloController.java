package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("hello")

public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping
    public String post() {
        return "Post Mapping";
    }

    @PutMapping
    public String put() {
        return "Put Mapping";
    }

    @DeleteMapping
    public String delete() {
        return "Delete Mapping";
    }

    @PatchMapping
    public String patch() {
        return "Patch Mapping";
    }

}
