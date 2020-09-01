/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author AVAJANG
 */
public class FXMLDocumentController implements Initializable {

    private int n;
    @FXML
    private TextField input;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void start(ActionEvent event) throws IOException {
        if (this.input.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "عدد مورد نظر را وارد کنید.");
        } else {
            try {
                n = Integer.parseInt(this.input.getText());
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("Hanoi_Gui.fxml"));
                try {
                    Loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(Hanoi_GuiController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Hanoi_GuiController hno = Loader.getController();
                hno.setText(n);

                Parent p = Loader.getRoot();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(new Scene(p));
                window.show();
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }

        }
    }

}
