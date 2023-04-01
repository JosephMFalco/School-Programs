/*
Name: Joseph Falco
Program name: TipTaxTotal
Program funtion: Create GUI to take user input to calculate the tip, tax and total for a meal
Date: 3/26/23
*/


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class TipTaxTotal extends Application {
   
   public static void main(String[] args) {
      
      launch(args);
      
   }
   
   public double charge;
   
   @Override
   public void start(Stage primaryStage)
   {
      
      //set title for stage
      primaryStage.setTitle("Tip, Tax, and Total");
      
      //create label and input field for food charge
      Label messageLabel = new Label("Food Charge");
      TextField enterCharge = new TextField();
      HBox charge = new HBox(10, messageLabel, enterCharge);
      
      //create label and input field for tip percent
      Label tipLabel = new Label("Tip percent");
      TextField enterTip = new TextField();
      HBox tip = new HBox(10, tipLabel, enterTip);
      
      //create label and input field for tax percent
      Label taxLabel = new Label("Tax percent");
      TextField enterTax = new TextField();
      HBox tax = new HBox(10, taxLabel, enterTax);
      
      //create calculation button
      Button calculate = new Button("Calculate");
      Label resultLabel = new Label();
      
      //create Vbox to store all boxes and button
      VBox root = new VBox(10, charge, tip, tax, calculate, resultLabel);
      
      //create an action event for when calculate button is press
      calculate.setOnAction(new EventHandler<ActionEvent>() {
         
         @Override
         public void handle(ActionEvent event) {
            
            try {
               
               double charge = Double.parseDouble(enterCharge.getText());
               double tip = Double.parseDouble(enterTip.getText());
               double tax = Double.parseDouble(enterTax.getText());
               double tipAmount = charge * (tip / 100);
               double taxAmount = charge * (tax / 100);
               double total = charge + tipAmount + taxAmount;
               
               resultLabel.setText(String.format("Total: $%.2f \nTip: $%.2f \nTax: $%.2f", total, tipAmount, taxAmount));
               
            }
            
            catch (NumberFormatException e) {
            
               resultLabel.setText("Please enter valid numbers for all fields");
            
            }
         
         }
      
      });
      
      Scene scene = new Scene(root);
      
      primaryStage.setScene(scene);
      primaryStage.setWidth(400);
      primaryStage.setHeight(300);
      
      primaryStage.show();
   }

}