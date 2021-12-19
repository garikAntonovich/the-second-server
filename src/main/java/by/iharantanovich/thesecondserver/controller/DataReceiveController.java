package by.iharantanovich.thesecondserver.controller;

import by.iharantanovich.thesecondserver.model.ReceivedData;
import by.iharantanovich.thesecondserver.model.OrganizationStatistics;
import by.iharantanovich.thesecondserver.model.DocumentStaticstics;
import by.iharantanovich.thesecondserver.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataReceiveController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/transfer")
    public ResponseEntity<List<ReceivedData>> getData(@RequestBody List<ReceivedData> extractedDataList) {
        documentService.saveOrUpdate(extractedDataList);
        documentService.writeExcel();
        return new ResponseEntity<>(extractedDataList, HttpStatus.OK);
    }

    @GetMapping("/statistic")
    public DocumentStaticstics getDocumentStatistics() {
        return documentService.getDocumentStatistics();
    }

    @GetMapping(value = { "/organizations", "/organizations/{name}" })
    @ResponseBody
    public List<OrganizationStatistics> getOrganizationStatistics(@PathVariable(required = false) String name) {
        return documentService.getOrganizationStatistics(name);
    }
}
