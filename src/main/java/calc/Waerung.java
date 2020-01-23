package calc;

import Update.JsonClasses.*;
import com.google.gson.Gson;

import static Update.RestController.readData;

public class Waerung extends Einheit {

    public Waerung(String start, String ziel, Double value) {
        this.start = start;
        this.ziel = ziel;
        this.value = value;
        this.ergebnis = 0.0;
        String json = readData();
        this.data = new Gson().fromJson(json, Update.class);
        converter();
        calculator();
    }

    private Update data;

    public void converter() { //Basis Dollar
        switch (start) {
            case "USD":
                setValue(value);
            case "EUR":
                double a = (1 / Double.parseDouble(data.getRates().getEUR()));
                setValue(value * a);
                break;
            case "JPY":
                double b = (1 / Double.parseDouble(data.getRates().getJPY()));
                setValue(value * b);
                break;
            case "DKK":
                double c = (1 / Double.parseDouble(data.getRates().getDKK()));
                setValue(value * c);
                break;
        }

    }

    public void calculator() {
        switch (ziel) {
            case "USD":
                setErgebnis(value);
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
}

