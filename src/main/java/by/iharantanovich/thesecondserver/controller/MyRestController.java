package by.iharantanovich.thesecondserver.controller;

import by.iharantanovich.thesecondserver.model.ExtractedData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @PostMapping("/post")
    public ResponseEntity<List<ExtractedData>> getData(@RequestBody List<ExtractedData> extractedDataList) {
        System.out.println(extractedDataList);
        return new ResponseEntity<>(extractedDataList, HttpStatus.OK);
    }
}
