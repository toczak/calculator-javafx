package pl.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controllerApp {

    @FXML    private TextField resultField;

    private modelApp Model = new modelApp();
    public double numberOne,numberTwo;
    private String operator;
    private boolean status = true;

    public void initialize() {
        setResultField("0");
    }

    @FXML
    private void processNumber(ActionEvent event) {
        checkNull();
        String value=((Button)event.getSource()).getText();
        setResultField(getResultField() + value);
    }

    @FXML
    private void processOperator(ActionEvent event){
        if(status){
            operator=((Button)event.getSource()).getText();
            numberOne = Double.parseDouble(getResultField());
            System.out.println(numberOne + " " + status);
            System.out.println(modelApp.checkInteger((Double) numberOne));
            status=false;
            setResultField("");
        }
        else {
            numberTwo = Double.parseDouble(getResultField());
            System.out.println(numberTwo + " " + status);
            setResultField(String.valueOf(modelApp.calculate(numberOne,numberTwo,operator)));
            status=true;
        }
    }

    @FXML
    private void putDot(){
        String value= getResultField();
        if(checkDot(value)) {
            setResultField(value + ".");
        }
    }

    private String getResultField() {
        return resultField.getText();
    }

    private void setResultField(String result)
    {
        resultField.setText(result);
    }

    private void checkNull() {
        if ((resultField.getText().equals("0")) || (resultField.getText() == null)) {
            resultField.setText("");
        }
    }

    private boolean checkDot(String number) {
        if (number.indexOf(".")==-1)
            return true;
        else return false;
    }



}
