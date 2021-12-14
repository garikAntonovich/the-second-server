package by.iharantanovich.thesecondserver.model;

public class ReceivedData {

    private String docNum;
    private String docDate;
    private String docGUID;
    private String operType;
    private Double amountOut;
    private InfData infPay;
    private BankData bankPay;
    private InfData infRcp;
    private BankData bankRcp;
    private String purpose;

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

    public InfData getInfPay() {
        return infPay;
    }

    public void setInfPay(InfData infPay) {
        this.infPay = infPay;
    }

    public BankData getBankPay() {
        return bankPay;
    }

    public void setBankPay(BankData bankPay) {
        this.bankPay = bankPay;
    }

    public InfData getInfRcp() {
        return infRcp;
    }

    public void setInfRcp(InfData infRcp) {
        this.infRcp = infRcp;
    }

    public BankData getBankRcp() {
        return bankRcp;
    }

    public void setBankRcp(BankData bankRcp) {
        this.bankRcp = bankRcp;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "ReceivedData{" +
                "docNum=" + docNum +
                ", docDate='" + docDate + '\'' +
                ", docGUID='" + docGUID + '\'' +
                ", operType='" + operType + '\'' +
                ", amountOut=" + amountOut +
                ", infPay=" + infPay +
                ", bankPay=" + bankPay +
                ", infRcp=" + infRcp +
                ", bankRcp=" + bankRcp +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
