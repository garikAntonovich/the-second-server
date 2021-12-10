package by.iharantanovich.thesecondserver.controller;

import by.iharantanovich.thesecondserver.model.ExtractedData;
import by.iharantanovich.thesecondserver.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private MyService myService;

    @PostMapping("/transfer")
    public ResponseEntity<List<ExtractedData>> getData(@RequestBody List<ExtractedData> extractedDataList) {
        myService.saveData(extractedDataList);
        return new ResponseEntity<>(extractedDataList, HttpStatus.OK);
    }
}
