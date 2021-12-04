package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "CName_PAY")
    private String cNamePay;

    @Column(name = "INN_PAY")
    private String innPay;

    @Column(name = "KPP_PAY")
    private String kppPay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_id")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "banks_id")
    private Bank bank;

    public Organization() {
    }

    public Organization(String cNamePay, String innPay, String kppPay) {
        this.cNamePay = cNamePay;
        this.innPay = innPay;
        this.kppPay = kppPay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcNamePay() {
        return cNamePay;
    }

    public void setcNamePay(String cNamePay) {
        this.cNamePay = cNamePay;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
