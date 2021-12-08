package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "INN_PAY")
    private String innPay;

    @Column(name = "KPP_PAY")
    private String kppPay;

    @Column(name = "CName_PAY")
    private String cnamePay;

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
