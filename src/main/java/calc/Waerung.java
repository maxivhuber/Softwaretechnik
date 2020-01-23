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
                setValue(value * Double.parseDouble(data.getRates().getEUR()));
                break;
            case "JPY":
                break;
            case "DKK":

                break;
        }
    }
    private void calculator(){

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

