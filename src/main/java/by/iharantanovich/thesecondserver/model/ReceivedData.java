package by.iharantanovich.thesecondserver.model;

public class ReceivedData {

    private String docNum;
    private String docDate;
    private String docGUID;
    private String operType;
    private Double amountOut;
    private ReceivedInfData infPay;
    private ReceivedBankData bankPay;
    private ReceivedInfData infRcp;
    private ReceivedBankData bankRcp;
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

    public ReceivedInfData getInfPay() {
        return infPay;
    }

    public void setInfPay(ReceivedInfData infPay) {
        this.infPay = infPay;
    }

    public ReceivedBankData getBankPay() {
        return bankPay;
    }

    public void setBankPay(ReceivedBankData bankPay) {
        this.bankPay = bankPay;
    }

    public ReceivedInfData getInfRcp() {
        return infRcp;
    }

    public void setInfRcp(ReceivedInfData infRcp) {
        this.infRcp = infRcp;
    }

    public ReceivedBankData getBankRcp() {
        return bankRcp;
    }

    public void setBankRcp(ReceivedBankData bankRcp) {
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
