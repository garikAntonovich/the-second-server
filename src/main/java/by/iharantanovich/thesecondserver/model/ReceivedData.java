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

    public String getDocDate() {
        return docDate;
    }

    public String getDocGUID() {
        return docGUID;
    }

    public String getOperType() {
        return operType;
    }

    public Double getAmountOut() {
        return amountOut;
    }

    public ReceivedInfData getInfPay() {
        return infPay;
    }

    public ReceivedBankData getBankPay() {
        return bankPay;
    }

    public ReceivedInfData getInfRcp() {
        return infRcp;
    }

    public ReceivedBankData getBankRcp() {
        return bankRcp;
    }

    public String getPurpose() {
        return purpose;
    }
}
