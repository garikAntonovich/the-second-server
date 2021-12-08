package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocDate")
    private String docDate;

    @Column(name = "DocGUID")
    private String docGUID;

    @Column(name = "OperType")
    private String operType;

    @Column(name = "AmountOut")
    private double amountOut;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id")
    private Organization payerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    private Organization recipientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_account_id")
    private Account payerAccountId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_account_id")
    private Account recipientAccountId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocGUID() {
        return docGUID;
    }

    public void setDocGUID(String docGUID) {
        this.docGUID = docGUID;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public double getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(double amountOut) {
        this.amountOut = amountOut;
    }

    public Organization getPayerId() {
        return payerId;
    }

    public void setPayerId(Organization payerId) {
        this.payerId = payerId;
    }

    public Organization getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Organization recipientId) {
        this.recipientId = recipientId;
    }

    public Account getPayerAccountId() {
        return payerAccountId;
    }

    public void setPayerAccountId(Account payerAccountId) {
        this.payerAccountId = payerAccountId;
    }

    public Account getRecipientAccountId() {
        return recipientAccountId;
    }

    public void setRecipientAccountId(Account recipientAccountId) {
        this.recipientAccountId = recipientAccountId;
    }
}
