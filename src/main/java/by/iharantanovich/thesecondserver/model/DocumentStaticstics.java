package by.iharantanovich.thesecondserver.model;

public class DocumentStaticstics {

    private Integer quantityOfDocuments;
    private Double averageAmount;

    public DocumentStaticstics() {
    }

    public DocumentStaticstics(Integer quantityOfDocuments, Double averageAmount) {
        this.quantityOfDocuments = quantityOfDocuments;
        this.averageAmount = averageAmount;
    }

    public Integer getQuantityOfDocuments() {
        return quantityOfDocuments;
    }

    public void setQuantityOfDocuments(Integer quantityOfDocuments) {
        this.quantityOfDocuments = quantityOfDocuments;
    }

    public Double getAverageAmount() {
        return averageAmount;
    }

    public void setAverageAmount(Double averageAmount) {
        this.averageAmount = averageAmount;
    }
}
