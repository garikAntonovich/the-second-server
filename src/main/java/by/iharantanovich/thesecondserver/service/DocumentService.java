package by.iharantanovich.thesecondserver.service;

import by.iharantanovich.thesecondserver.model.ExtractedData;
import by.iharantanovich.thesecondserver.model.Statistic;

import java.util.List;

public interface DocumentService {

    void saveOrUpdate(List<ExtractedData> extractedDataList);

    Statistic getStatistic();
}
