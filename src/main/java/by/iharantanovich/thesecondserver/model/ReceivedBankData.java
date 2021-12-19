package by.iharantanovich.thesecondserver.model;

public class BankData {

    private String bsPay;
    private String bicPay;
    private String bsKsPay;

    public String getBsPay() {
        return bsPay;
    }

    public void setBsPay(String bsPay) {
        this.bsPay = bsPay;
    }

    public String getBicPay() {
        return bicPay;
    }

    public void setBicPay(String bicPay) {
        this.bicPay = bicPay;
    }

    public String getBsKsPay() {
        return bsKsPay;
    }

    public void setBsKsPay(String bsKsPay) {
        this.bsKsPay = bsKsPay;
    }

    @Override
    public String toString() {
        return "BankData{" +
                "bsPay='" + bsPay + '\'' +
                ", bicPay='" + bicPay + '\'' +
                ", bsKsPay='" + bsKsPay + '\'' +
                '}';
    }
}
