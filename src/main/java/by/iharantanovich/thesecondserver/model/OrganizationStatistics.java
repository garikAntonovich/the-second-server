package by.iharantanovich.thesecondserver.model;

public class OrganizationStatistics {

    private String name;
    private int quantityOfDocPayer;
    private int quantityOfDocRecipient;

    public OrganizationStatistics(String name, int quantityOfDocPayer, int quantityOfDocRecipient) {
        this.name = name;
        this.quantityOfDocPayer = quantityOfDocPayer;
        this.quantityOfDocRecipient = quantityOfDocRecipient;
    }

    public String getName() {
        return name;
    }

    public int getQuantityOfDocPayer() {
        return quantityOfDocPayer;
    }

    public int getQuantityOfDocRecipient() {
        return quantityOfDocRecipient;
    }
}
