package calc;

public class Gewichte {

    public Gewichte(String start,String ziel,Double value){
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


    private void converter(double value){   //Umwandeln in gramm
        switch (start) {
            case "t":
                setValue(value * 1000000);
                break;
            case "kg":
                setValue(value * 1000);
                break;
            case "g":
                break;
            case "mg":
                setValue(value / 1000);
                break;
        }
    }
    private void calculator() { //Wir von gramm aus um
        switch (ziel) {
            case "t":
                setErgebnis(value / 1000000);
                break;
            case "kg":
                setErgebnis(value / 1000);
                break;
            case "g":
                setErgebnis(value);
                break;
            case "mg":
                setErgebnis(value * 1000);
                break;
        }
    }


    public void setValue(Double value) {
        this.value = value;
    }

    public void setErgebnis(Double ergebnis) {
        this.ergebnis = ergebnis;
    }

    public Double getErgebnis() {
        return ergebnis;
    }
}
