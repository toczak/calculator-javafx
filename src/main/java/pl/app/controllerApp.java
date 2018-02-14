package pl.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controllerApp {

    @FXML
    private TextField resultField;

    //private modelApp Model = new modelApp();
    public double numberOne, numberTwo;
    public Double result;
    private String operator;
    private boolean status = true;

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
            if (status) {
                operator = ((Button) event.getSource()).getText();
                numberOne = Double.parseDouble(getResultField());
                status = false;
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
                status = true;
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

    private String getResultField() {
        return resultField.getText();
    }

    private void setResultField(String result) {
        resultField.setText(result);
    }

    private void checkNull() {
        if ((resultField.getText().equals("0")) || (resultField.getText() == null)) {
            resultField.setText("");
        }
    }


}
