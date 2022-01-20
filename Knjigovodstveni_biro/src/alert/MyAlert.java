/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alert;

import javafx.scene.control.Alert;

/**
 *
 * @author Tijana Lakic
 */
public class MyAlert{
    
    public static void display(String title,String message,String type){
        Alert alert;
        if(type.equals("error")){
          alert=new Alert(Alert.AlertType.ERROR);
        }
        else{
            alert=new Alert(Alert.AlertType.INFORMATION);
        }
        
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}
