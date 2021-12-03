package by.iharantanovich.thesecondserver.model;

import org.springframework.stereotype.Component;

@Component
public class ExtractedData {

    private Integer docNumEx;
    private String docDateEx;
    private String docGUIDEx;
    private String operTypeEx;
    private Double amountOutEx;
    private InfData infPayEx;
    private BankData bankPayEx;
    private InfData infRcpEx;
    private BankData bankRcpEx;
    private String purposeEx;

    public Integer getDocNumEx() {
        return docNumEx;
    }

    public void setDocNumEx(Integer docNumEx) {
        this.docNumEx = docNumEx;
    }

    public String getDocDateEx() {
        return docDateEx;
    }

    public void setDocDateEx(String docDateEx) {
        this.docDateEx = docDateEx;
    }

    public String getDocGUIDEx() {
        return docGUIDEx;
    }

    public void setDocGUIDEx(String docGUIDEx) {
        this.docGUIDEx = docGUIDEx;
    }

    public String getOperTypeEx() {
        return operTypeEx;
    }

    public void setOperTypeEx(String operTypeEx) {
        this.operTypeEx = operTypeEx;
    }

    public Double getAmountOutEx() {
        return amountOutEx;
    }

    public void setAmountOutEx(Double amountOutEx) {
        this.amountOutEx = amountOutEx;
    }

    public InfData getInfPayEx() {
        return infPayEx;
    }

    public void setInfPayEx(InfData infPayEx) {
        this.infPayEx = infPayEx;
    }

    public BankData getBankPayEx() {
        return bankPayEx;
    }

    public void setBankPayEx(BankData bankPayEx) {
        this.bankPayEx = bankPayEx;
    }

    public InfData getInfRcpEx() {
        return infRcpEx;
    }

    public void setInfRcpEx(InfData infRcpEx) {
        this.infRcpEx = infRcpEx;
    }

    public BankData getBankRcpEx() {
        return bankRcpEx;
    }

    public void setBankRcpEx(BankData bankRcpEx) {
        this.bankRcpEx = bankRcpEx;
    }

    public String getPurposeEx() {
        return purposeEx;
    }

    public void setPurposeEx(String purposeEx) {
        this.purposeEx = purposeEx;
    }

    @Override
    public String toString() {
        return "ExtractedData{" +
                "docNumEx=" + docNumEx +
                ", docDateEx='" + docDateEx + '\'' +
                ", docGUIDEx='" + docGUIDEx + '\'' +
                ", operTypeEx='" + operTypeEx + '\'' +
                ", amountOutEx=" + amountOutEx +
                ", infPayEx=" + infPayEx +
                ", bankPayEx=" + bankPayEx +
                ", infRcpEx=" + infRcpEx +
                ", bankRcpEx=" + bankRcpEx +
                ", purposeEx='" + purposeEx + '\'' +
                '}';
    }
}
