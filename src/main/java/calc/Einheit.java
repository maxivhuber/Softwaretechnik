package calc;

public abstract class Einheit {

    public String start;
    public Double value;
    public Double ergebnis;


    public abstract void calculator();


    public void setValue(Double value) {
        this.value = value;
    }

    public Double getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(Double ergebnis) {
        this.ergebnis = ergebnis;
    }
}
