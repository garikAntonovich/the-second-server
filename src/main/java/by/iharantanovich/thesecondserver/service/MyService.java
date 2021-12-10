package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.model.ExtractedData;

import java.util.List;

public interface MyService {

    void saveData(List<ExtractedData> extractedDataList);
}
