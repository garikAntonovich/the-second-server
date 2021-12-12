package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20)
    private String bicPay;

    public Bank() {
    }

    public Bank(String bicPay) {
        this.bicPay = bicPay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBicPay() {
        return bicPay;
    }

    public void setBicPay(String bicPay) {
        this.bicPay = bicPay;
    }
}
