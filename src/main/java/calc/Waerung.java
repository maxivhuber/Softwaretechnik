package calc;
import Update.JsonClasses.*;
import com.google.gson.Gson;
import static Update.RestController.readData;

public class Waerung extends Einheit {

    public Waerung(String start,String ziel,Double value) {
        this.start =start;
        this.value =value;
        this.ergebnis = 0.0;
        String json = readData();
        this.data = new Gson().fromJson(json,Update.class);
        calculator();
    }

    private Update data;

    public void calculator() {
        switch (start) {
            case "USD":
                setErgebnis(value);
            case "EUR":
                double a = (1/Double.parseDouble(data.getRates().getEUR()));
                setErgebnis(value * a);
                break;
            case "JPY":
                double b = (1/Double.parseDouble(data.getRates().getJPY()));
                setErgebnis(value * b);
                break;
            case "DKK":
                double c = (1/Double.parseDouble(data.getRates().getDKK()));
                setErgebnis(value * c);
                break;
        }
    }
}

