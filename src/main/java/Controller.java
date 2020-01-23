import calc.Gewichte;
import calc.Waerung;
import calc.Zeit;
import com.google.gson.internal.JavaVersion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.Arrays;

import static Update.RestController.checkAge;

public class Controller {


    public void initialize() {
        choice_init.getItems().addAll("Waehrung", "Gewichte", "Zeit");
        choice_init.setValue("Waehrung");
    }

    @FXML
    private ChoiceBox<String> choice_init;

    @FXML
    private ChoiceBox<String> choice_first;

    @FXML
    private ChoiceBox<String> choice_second;

    @FXML
    private Button button_ci;

    @FXML
    private Button button_cf;

    @FXML
    private Button button_cs;

    @FXML
    private TextField textfield_value;

    @FXML
    private Button button_calc;

    @FXML
    private Button button_clear;

    @FXML
    private Label label_ergebnis;

    public void selectEinheit() {
        String option = choice_init.getValue();
        choice_first.setDisable(false);
        button_cf.setDisable(false);
        choice_init.setDisable(true);
        button_ci.setDisable(true);

        switch (option) {
            case "Waehrung":
                genWaehrung();
                break;
            case "Gewichte":
                genGewichte();
                break;
            case "Zeit":
                genZeit();
                break;
        }
    }

    public void selectStart() {
        String option = choice_init.getValue();
        choice_second.setDisable(false);
        button_cs.setDisable(false);
        choice_first.setDisable(true);
        button_cf.setDisable(true);
        textfield_value.setPromptText("Eingabe in " + choice_first.getValue());

    }

    public void selectZiel() {
        choice_second.setDisable(true);
        button_cs.setDisable(true);
        textfield_value.setDisable(false);
        button_calc.setDisable(false);
    }

    public void calculateResult() {
        if (checkInput(textfield_value.getText().trim())) {
            textfield_value.setDisable(true);
            button_calc.setDisable(true);
            String option = choice_init.getValue();
            String val1 = choice_first.getValue();
            String val2 = choice_second.getValue();
            String val3 = textfield_value.getText();

            switch (option) {
                case "Waehrung":
                    checkAge();
                    Waerung a = new Waerung(val1, val2, Double.parseDouble(val3));
                    DecimalFormat df = new DecimalFormat("#.####");
                    String formatted = df.format(a.getErgebnis());
                    label_ergebnis.setText(formatted + " " + val2);
                    clear();
                    break;
                case "Gewichte":
                    Gewichte b = new Gewichte(val1, val2, Double.parseDouble(val3));
                    DecimalFormat df1 = new DecimalFormat("#.##");
                    String formatted1 = df1.format(b.getErgebnis());
                    label_ergebnis.setText(b.getErgebnis().toString() + " " + val2);
                    clear();
                    break;
                case "Zeit":
                    Zeit c = new Zeit(val1, val2, Double.parseDouble(val3));
                    DecimalFormat df2 = new DecimalFormat("#.##");
                    String formatted2 = df2.format(c.getErgebnis());
                    label_ergebnis.setText(c.getErgebnis().toString() + " " + val2);
                    clear();
                    break;
            }
        } else {
            textfield_value.setText("");

        }
    }

    private boolean checkInput(String value) {
        if (value.isEmpty()) {
            return false;
        }
        try {
            double d = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void clear() {
        textfield_value.setText("");
        textfield_value.setPromptText("");
        choice_init.setDisable(false);
        button_ci.setDisable(false);
        choice_first.setDisable(true);
        choice_first.getItems().setAll("");
        choice_second.setDisable(true);
        choice_second.getItems().setAll("");
        button_cf.setDisable(true);
        button_cs.setDisable(true);
    }

    private void genWaehrung() {
        String[] waehrung = {"USD", "EUR", "JPY", "DKK"};
        choice_first.getItems().setAll(Arrays.asList(waehrung));
        choice_second.getItems().setAll(Arrays.asList(waehrung));
        choice_first.setValue("USD");
        choice_second.setValue("USD");
    }

    private void genGewichte() {
        String[] gewichte = {"t", "kg", "g", "mg"};
        choice_first.getItems().setAll(Arrays.asList(gewichte));
        choice_second.getItems().setAll(Arrays.asList(gewichte));
        choice_first.setValue("t");
        choice_second.setValue("t");
    }

    private void genZeit() {
        String[] zeiten = {"m", "d", "h", "min"};
        choice_first.getItems().setAll(Arrays.asList(zeiten));
        choice_second.getItems().setAll(Arrays.asList(zeiten));
        choice_first.setValue("m");
        choice_second.setValue("m");

    }


}

