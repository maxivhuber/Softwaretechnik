package calc;

public class Zeit {
    public Zeit(String start,String ziel,Double value){
        this.start =start;
        this.ziel = ziel;
        this.value =value;
        converter(value);
        calculator();
    }

    String start;
    String ziel;
    Double value;
    Double ergebnis;

    private void converter(double value){

    }

    private void calculator() {

    }

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
