package by.iharantanovich.thesecondserver.controller;

import by.iharantanovich.thesecondserver.entity.Organization;
import by.iharantanovich.thesecondserver.model.ExtractedData;
import by.iharantanovich.thesecondserver.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/org")
    public List<Organization> showAllOrganizations() {
        List<Organization> allOrganizations = organizationService.getAllOrganizations();
        return allOrganizations;
    }

    @PostMapping("/organ")
    public Organization addNewOrganization(@RequestBody Organization organization) {
        organizationService.saveOrganization(organization);
        return organization;
    }

    @PostMapping("/post")
    public ResponseEntity<List<ExtractedData>> getData(@RequestBody List<ExtractedData> extractedDataList) {
        System.out.println(extractedDataList);
        return new ResponseEntity<>(extractedDataList, HttpStatus.OK);
    }
}
