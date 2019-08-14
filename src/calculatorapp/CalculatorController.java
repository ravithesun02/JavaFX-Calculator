/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ravi
 */
class Test
{
    
     public long calculate(long num1,long num2,String operate)
    {
        switch(operate)
        {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if(num2==0)
                    return 0;
                return num1/num2;
            default:
                break;
        }
        return 0;
    }
      public double calculate(double num1,double num2,String operate)
    {
        switch(operate)
        {
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                if(num2==0)
                    return 0;
                return num1/num2;
            default:
                break;
        }
        return 0;
    }
}
public class CalculatorController implements Initializable {

    Test t1=new Test();
    @FXML
    private Label label;
    private String operator="";
    private boolean flag=true;
   // private boolean dot=false;
    private long num1=0;
    @FXML
    public void numbers(ActionEvent e)
    {
        if(flag==true)
        {
            label.setText("");
            flag=false;
        }
        String val=((Button)e.getSource()).getText();
        label.setText(label.getText()+val);
    }
    @FXML
    public void operators(ActionEvent e)
    {
        String val=((Button)e.getSource()).getText();
        if(!val.equals("="))
        {
            if(!operator.isEmpty())
                return;
            operator=val;
           // if(dot==true)
                
            num1=Long.parseLong(label.getText());
            label.setText("");
        }
        else
        {
            if(operator.isEmpty())
                return;
            long num2=Long.parseLong(label.getText());
            long output=t1.calculate(num1,num2,operator);
            label.setText(String.valueOf(output));
            operator="";
            flag=true;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
