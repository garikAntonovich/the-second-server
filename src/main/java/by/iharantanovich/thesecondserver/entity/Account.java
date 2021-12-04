package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "BS_PAY")
    private String bsPay;

    @Column(name = "BS_KS_PAY")
    private String bsKsPay;

    public Account() {
    }

    public Account(String bsPay, String bsKsPay) {
        this.bsPay = bsPay;
        this.bsKsPay = bsKsPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBsPay() {
        return bsPay;
    }

    public void setBsPay(String bsPay) {
        this.bsPay = bsPay;
    }

    public String getBsKsPay() {
        return bsKsPay;
    }

    public void setBsKsPay(String bsKsPay) {
        this.bsKsPay = bsKsPay;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", bsPay='" + bsPay + '\'' +
                ", bsKsPay='" + bsKsPay + '\'' +
                '}';
    }
}
