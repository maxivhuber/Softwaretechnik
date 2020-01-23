package calc;

import Update.JsonClasses.Update;
import com.google.gson.Gson;
import static Update.RestController.readData;

public class Waerung {
    public Waerung(String start,String ziel,Double value) {
        this.start =start;
        this.ziel = ziel;
        this.value =value;
        this.ergebnis = 0.0;
        String json = readData();
        this.data = new Gson().fromJson(json,Update.class);
        converter(value);
        calculator();
    }

    String start;
    String ziel;
    Double value;
    Double ergebnis;
    Update data;

    private void converter(Double value) { //Basis ist Dollar

        switch (start) {
            case "USD":
                break;
            case "EUR":
                double a = (Double.parseDouble(data.getRates().getEUR())*100);
                a = Math.abs(a-100);
                a += 100;
                setValue((value * a) / 100);
                break;
            case "JPY":
                double b = (Double.parseDouble(data.getRates().getJPY())*100);
                b = Math.abs(b-100);
                b += 100;
                setValue((value * b) / 100);
                break;
            case "DKK":
                double c = (Double.parseDouble(data.getRates().getDKK())*100);
                c = Math.abs(c-100);
                c += 100;
                setValue((value * c) / 100);
                break;
        }
    }

    private void calculator(){
        switch (ziel) {
            case "USD":
                setErgebnis(value);
                break;
            case "EUR":
                setErgebnis(value * Double.parseDouble(data.getRates().getEUR()));
                break;
            case "JPY":
                setErgebnis(value * Double.parseDouble(data.getRates().getJPY()));
                break;
            case "DKK":
                setErgebnis(value * Double.parseDouble(data.getRates().getDKK()));
                break;
        }

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

