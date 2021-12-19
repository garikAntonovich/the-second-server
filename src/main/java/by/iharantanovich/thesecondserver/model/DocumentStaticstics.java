package by.iharantanovich.thesecondserver.model;

public class DocumentStaticstics {

    private int quantityOfDocuments;
    private double averageAmount;

    public DocumentStaticstics(int quantityOfDocuments, double averageAmount) {
        this.quantityOfDocuments = quantityOfDocuments;
        this.averageAmount = averageAmount;
    }

    public int getQuantityOfDocuments() {
        return quantityOfDocuments;
    }

    public double getAverageAmount() {
        return averageAmount;
    }
}
