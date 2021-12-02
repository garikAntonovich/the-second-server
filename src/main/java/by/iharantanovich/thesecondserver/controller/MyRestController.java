package by.iharantanovich.thesecondserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @PostMapping("/post")
    public ResponseEntity<List<Object>> getData(@RequestBody List<Object> objectList) {
        System.out.println(objectList);
        return new ResponseEntity<>(objectList, HttpStatus.OK);
    }
}
