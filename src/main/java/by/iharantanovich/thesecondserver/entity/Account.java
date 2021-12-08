package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "BS_PAY")
    private String bsPay;

    @Column(name = "BS_KS_PAY")
    private String bsKsPay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private Bank bankId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organizationId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }
}
