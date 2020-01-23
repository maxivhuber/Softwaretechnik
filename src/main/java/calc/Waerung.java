package calc;

import Update.JsonClasses.Update;
import com.google.gson.Gson;
import static Update.RestController.readData;

public class Waerung {
    public Waerung(String start,String ziel,Double value) {
        this.start =start;
        this.value =value;
        this.ergebnis = 0.0;
        String json = readData();
        this.data = new Gson().fromJson(json,Update.class);
        calculator(value);
    }

    private String start;
    private Double value;
    private Double ergebnis;
    private Update data;

    private void calculator(Double value) {

        switch (start) {
            case "USD":
                break;
            case "EUR":
                double a = (1/Double.parseDouble(data.getRates().getEUR()));
                setErgebnis(value * a);
                break;
            case "JPY":
                double b = (1/Double.parseDouble(data.getRates().getJPY()));
                setErgebnis(value * b);
                break;
            case "DKK":
                double c = (Double.parseDouble(data.getRates().getDKK()));
                setErgebnis(value * c);
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

