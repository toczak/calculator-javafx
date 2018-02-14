package pl.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controllerApp {

    @FXML
    private TextField resultField;

    private double numberOne, numberTwo;
    private Double result;
    private String operator;
    private boolean statusOperator = true;

    public void initialize() {
        setResultField("0");
    }

    @FXML
    private void processNumber(ActionEvent event) {
        checkNull();
        String value = ((Button) event.getSource()).getText();
        setResultField(getResultField() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        if (!getResultField().equals("") || !getResultField().trim().isEmpty() || getResultField().length() != 0) {
            if (statusOperator) {
                operator = ((Button) event.getSource()).getText();
                numberOne = Double.parseDouble(getResultField());
                statusOperator = false;
                setResultField("");
            } else {
                numberTwo = Double.parseDouble(getResultField());
                result = modelApp.calculate(numberOne, numberTwo, operator);
                if (modelApp.checkInteger(result)) {
                    Integer value = result.intValue();
                    setResultField(String.valueOf(value));
                } else {
                    setResultField(String.valueOf(result));
                }
                statusOperator = true;
            }
        }
    }

    @FXML
    private void putDot() {
        String value = getResultField();
        if (modelApp.checkDot(value)) {
            setResultField(value + ".");
        }
    }

    @FXML
    private void backspace() {
        String resultString = getResultField();
        if ((resultString.length() > 0)) {
            resultString = resultString.substring(0, resultString.length() - 1);
            setResultField(resultString);
        }
    }

    @FXML
    private void clearMemory() {
        setResultField("");
        numberOne = 0;
        numberTwo = 0;
    }

    private String getResultField() {
        return resultField.getText();
    }

    private void setResultField(String result) {
        resultField.setText(result);
    }

    private void checkNull() {
        if ((getResultField().equals("0")) || (getResultField() == null)) {
            setResultField("");
        }
    }
}
