package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20)
    private String innPay;

    @Column(length = 20)
    private String kppPay;

    private String cnamePay;

    public Organization() {
    }

    public Organization(String innPay, String kppPay, String cnamePay) {
        this.innPay = innPay;
        this.kppPay = kppPay;
        this.cnamePay = cnamePay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getCnamePay() {
        return cnamePay;
    }

    public void setCnamePay(String cnamePay) {
        this.cnamePay = cnamePay;
    }
}
