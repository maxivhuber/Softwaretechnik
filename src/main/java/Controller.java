import calc.Gewichte;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Controller {


    public void initialize() {
        choice_init.getItems().addAll("Währung", "Gewichte", "Zeit");
        choice_init.setValue("Währung");
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
    private Label label_ergebnis;

    public void selectEinheit() {
        String option = choice_init.getValue();
        choice_first.setDisable(false);
        button_cf.setDisable(false);
        choice_init.setDisable(true);
        button_ci.setDisable(true);

        switch (option) {
            case "Währung":
                genWährung();
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
        textfield_value.setPromptText("Eingabe in "+choice_second.getValue());

    }

    public void selectZiel() {
        choice_second.setDisable(true);
        button_cs.setDisable(true);
        textfield_value.setDisable(false);
        button_calc.setDisable(false);
    }

    private void genWährung() {
        String währung[] = {"USD", "EUR", "JPY", "DKK"};
        choice_first.getItems().setAll(Arrays.asList(währung));
        choice_second.getItems().setAll(Arrays.asList(währung));
        choice_first.setValue("USD");
        choice_second.setValue("USD");
    }

    private void genGewichte() {
        String gewichte[] = {"t", "kg", "g", "mg"};
        choice_first.getItems().setAll(Arrays.asList(gewichte));
        choice_second.getItems().setAll(Arrays.asList(gewichte));
        choice_first.setValue("t");
        choice_second.setValue("t");
    }

    private void genZeit() {
        String zeiten[] = {"m", "d", "h", "min"};
        choice_first.getItems().setAll(Arrays.asList(zeiten));
        choice_second.getItems().setAll(Arrays.asList(zeiten));
        choice_first.setValue("m");
        choice_second.setValue("m");

    }

    public void calc() {
        if (checkInput(textfield_value.getText().trim())) {
            textfield_value.setDisable(true);
            button_calc.setDisable(true);

            String option = choice_init.getValue();
            String val1 = choice_first.getValue();
            String val2 = choice_second.getValue();
            String val3 = textfield_value.getText();

            switch (option) {
                case "Währung":
                    //Wie Gewichte
                    break;
                case "Gewichte":
                    Gewichte a = new Gewichte(val1,val2,Double.parseDouble(val3));
                    label_ergebnis.setText(a.getErgebnis().toString());
                    break;
                case "Zeit":
                    //Wie Gewichte
                    break;
            }
        } else {
            textfield_value.setText("");
        }
        textfield_value.setText("");
        choice_init.setDisable(false);
        button_ci.setDisable(false);

    }

    public void update() {


    }

    public boolean checkInput(String value) {
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
}

