package by.iharantanovich.thesecondserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "BIC_PAY")
    private String bicPay;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocDate")
    private String docDate;

    @Column(name = "DocGUID")
    private String docGUID;

    @Column(name = "OperType")
    private String operType;

    @Column(name = "AmountOut")
    private Double amountOut;

    public Bank() {
    }

    public Bank(String bicPay, String docNum, String docDate, String docGUID, String operType, Double amountOut) {
        this.bicPay = bicPay;
        this.docNum = docNum;
        this.docDate = docDate;
        this.docGUID = docGUID;
        this.operType = operType;
        this.amountOut = amountOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBicPay() {
        return bicPay;
    }

    public void setBicPay(String bicPay) {
        this.bicPay = bicPay;
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

    public Double getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(Double amountOut) {
        this.amountOut = amountOut;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bicPay='" + bicPay + '\'' +
                ", docNum='" + docNum + '\'' +
                ", docDate='" + docDate + '\'' +
                ", docGUID='" + docGUID + '\'' +
                ", operType='" + operType + '\'' +
                ", amountOut=" + amountOut +
                '}';
    }
}
