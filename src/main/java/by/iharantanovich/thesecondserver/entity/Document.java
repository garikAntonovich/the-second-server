package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String docNum;
    private String docDate;
    private String docGUID;
    private String operType;
    private Double amountOut;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id")
    private Organization payer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id")
    private Organization recipient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_account_id")
    private Account payerAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_account_id")
    private Account recipientAccount;

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

    public Organization getPayer() {
        return payer;
    }

    public void setPayer(Organization payer) {
        this.payer = payer;
    }

    public Organization getRecipient() {
        return recipient;
    }

    public void setRecipient(Organization recipient) {
        this.recipient = recipient;
    }

    public Account getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(Account payerAccount) {
        this.payerAccount = payerAccount;
    }

    public Account getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(Account recipientAccount) {
        this.recipientAccount = recipientAccount;
    }
}
