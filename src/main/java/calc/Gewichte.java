package calc;

public class Gewichte extends Einheit {

    public Gewichte(String start,String ziel,Double value){
    this.start =start;
    this.ziel = ziel;
    this.value =value;
    this.ergebnis = 0.0;
    converter(value);
    calculator();
    }

    private String ziel;

    public void converter(double value){   //Umwandeln in gramm
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

    public void calculator() { //Wir von gramm aus um
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


}
