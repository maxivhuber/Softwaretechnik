package calc;

public class Zeit extends Einheit {

    public Zeit(String start,String ziel,Double value){
        this.start =start;
        this.ziel = ziel;
        this.value =value;
        this.ergebnis = 0.0;
        converter(value);
        calculator();
    }

    private String ziel;

    public void converter(double value){ //Basis min
        switch (start) {
            case "m":
                setValue(((value * 30)*24)*60);
                break;
            case "d":
                setValue((value * 24)*60);
                break;
            case "h":
                setValue(value*60);
                break;
            case "min":
                break;
        }
    }

    public void calculator() {
        switch (ziel) {
            case "m":
            setErgebnis(((value / 60)/24)/30);
                break;
            case "d":
                setErgebnis((value / 60)/24);
                break;
            case "h":
               setErgebnis(value / 60);
                break;
            case "min": setErgebnis(value);
                break;
        }

    }

}
