/*
Name: Joseph Falco
Program name: ConRegSys_Falco
Program funtion: Create GUI to calculate the the users total registration fee for a conference
Date: 3/28/23
*/


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;


public class ConRegSys_Falco extends Application {
   
   //fields
   ComboBox<String> feeCombo;
   CheckBox dinnerCB;
   CheckBox commerceCB;
   CheckBox webCB;
   CheckBox programmingCB;
   CheckBox securityCB;
   Label totalLabel;
   
   public static void main(String[] args) {
      
      launch(args);
   
   }
   
   @Override
   public void start(Stage primaryStage) {
      
      primaryStage.setTitle("Conference Registration Fees");
      
      feeCombo = new ComboBox<>();
      feeCombo.getItems().addAll("Student Fee: $495.00", "Regular Fee: $895.00");
      
      dinnerCB = new CheckBox("Opening Night Dinner: $30.00");
      commerceCB = new CheckBox("Intro to E-commerce: $295.00");
      webCB = new CheckBox("The Future of the Web: $295.00");
      programmingCB = new CheckBox("Advanced Java Programming: $395.00");
      securityCB = new CheckBox("Network Security: $395.00");
      
      Button totalBtn = new Button("Finish");
      totalBtn.setOnAction(new TotalButtonHandler());
      
      totalLabel = new Label("$0.00");
      
      VBox checkBoxVBox = new VBox(10, feeCombo, dinnerCB, commerceCB, webCB, programmingCB, securityCB);
      
      VBox mainVBox = new VBox(10, checkBoxVBox, totalBtn, totalLabel);
      mainVBox.setAlignment(Pos.CENTER);
      mainVBox.setPadding(new Insets(10));

      Scene scene = new Scene(mainVBox);
      primaryStage.setScene(scene);
      primaryStage.setWidth(400);
      primaryStage.setHeight(300);
      
      primaryStage.show();   
   }
     
   class TotalButtonHandler implements EventHandler<ActionEvent> {
   
      @Override
      public void handle(ActionEvent event) {
      
         double result = 0.0;
         
         if(feeCombo.getValue().equals("Student Fee: $495.00"))
            result += 495.00;
         
         if(feeCombo.getValue().equals("Regular Fee: $895.00"))
            result += 895.00;
         
         if(dinnerCB.isSelected())
            result += 30.00;
         
         if(commerceCB.isSelected())
            result += 295.00;
            
         if(webCB.isSelected())
            result += 295.00;
         
         if(programmingCB.isSelected())
            result += 395.00;
         
         if(securityCB.isSelected())
            result += 395.00;
            
         totalLabel.setText(String.format("$%,.2f", result));
      
      }
   
   }

}