package by.iharantanovich.thesecondserver.controller;

import by.iharantanovich.thesecondserver.model.ReceivedData;
import by.iharantanovich.thesecondserver.model.OrganizationData;
import by.iharantanovich.thesecondserver.model.Statistic;
import by.iharantanovich.thesecondserver.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/transfer")
    public ResponseEntity<List<ReceivedData>> getData(@RequestBody List<ReceivedData> extractedDataList) {
        documentService.saveOrUpdate(extractedDataList);
        documentService.createAndWriteExcel();
        return new ResponseEntity<>(extractedDataList, HttpStatus.OK);
    }

    @GetMapping("/statistic")
    public Statistic getStatistic() {
        return documentService.getStatistic();
    }

    @GetMapping(value = { "/organizations", "/organizations/{name}" })
    @ResponseBody
    public List<OrganizationData> getOrganizationData(@PathVariable(required = false) String name) {
        return documentService.getOrganizationData(name);
    }
}
