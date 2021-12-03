package by.iharantanovich.thesecondserver.model;

public class InfData {

    private String innPay;
    private String kppPay;
    private String cNamePay;

    public String getInnPay() {
        return innPay;
    }

    public void setInnPay(String innPay) {
        this.innPay = innPay;
    }

    public String getKppPay() {
        return kppPay;
    }

    public void setKppPay(String kppPay) {
        this.kppPay = kppPay;
    }

    public String getcNamePay() {
        return cNamePay;
    }

    public void setcNamePay(String cNamePay) {
        this.cNamePay = cNamePay;
    }

    @Override
    public String toString() {
        return "InfData{" +
                "innPay='" + innPay + '\'' +
                ", kppPay='" + kppPay + '\'' +
                ", cNamePay='" + cNamePay + '\'' +
                '}';
    }
}
