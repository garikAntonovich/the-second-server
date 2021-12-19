package by.iharantanovich.thesecondserver.model;

public class OrganizationData {

    private String name;
    private Integer quantityOfDocPayer;
    private Integer quantityOfDocRecipient;

    public OrganizationData() {
    }

    public OrganizationData(String name, Integer quantityOfDocPayer, Integer quantityOfDocRecipient) {
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
