package by.iharantanovich.thesecondserver.model;

public class OrganizationStatistics {

    private String name;
    private int quantityOfDocPayer;
    private int quantityOfDocRecipient;

    public OrganizationStatistics() {
    }

    public OrganizationStatistics(String name, int quantityOfDocPayer, int quantityOfDocRecipient) {
        this.name = name;
        this.quantityOfDocPayer = quantityOfDocPayer;
        this.quantityOfDocRecipient = quantityOfDocRecipient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantityOfDocPayer() {
        return quantityOfDocPayer;
    }

    public void setQuantityOfDocPayer(Integer quantityOfDocPayer) {
        this.quantityOfDocPayer = quantityOfDocPayer;
    }

    public Integer getQuantityOfDocRecipient() {
        return quantityOfDocRecipient;
    }

    public void setQuantityOfDocRecipient(Integer quantityOfDocRecipient) {
        this.quantityOfDocRecipient = quantityOfDocRecipient;
    }
}
