/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.prism.paint.Color;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javax.swing.Timer;

/**
 * FXML Controller class
 *
 * @author AVAJANG
 */
public class Hanoi_GuiController implements Initializable {

    @FXML
    private Pane container_C;
    @FXML
    private Pane container_B;
    @FXML
    private Pane container_A;

    private AnimationTimer timer;
    private Disk[] disks;
    private LinkedList<Pane> movesToSolve;
    private static final int DELAY = 1000;
    private HanoiClass hn;
    private int n;
    private int t;

    private Container containers[];
    @FXML
    private ComboBox<Integer> numberOfDisk;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numberOfDisk.getItems().add(1);
        numberOfDisk.getItems().add(2);
        numberOfDisk.getItems().add(3);
        numberOfDisk.getItems().add(4);
        numberOfDisk.getItems().add(5);
        numberOfDisk.getItems().add(6);
        numberOfDisk.getItems().add(7);
        hn = new HanoiClass();
        hn.setN(n);
        t = 0;

    }

    @FXML
    private void continue_h(ActionEvent event) {
        timer.stop();
        if (hn.getMovesToSolve().isEmpty()) {
            System.out.println("man khali hastam!");

        }
        if (!movesToSolve.isEmpty()) {
            moveDisk(movesToSolve.removeFirst(), movesToSolve.removeFirst());

        }

    }

    public void setText(int n) {
        this.n = n;
        start();

    }

    public void moveDisk(Pane a, Pane b) {
        if (a.getChildren().size() != 0) {
            System.out.println(a.getChildren().size() - 1);
            Label temp = new Label();
            temp = (Label) a.getChildren().get(a.getChildren().size() - 1);
            if (b.getChildren().size() != 0) {
                temp.setLayoutY(b.getChildren().get(b.getChildren().size() - 1).getLayoutY() - 40);
            } else {
                temp.setLayoutY(360);
            }
            System.out.println(temp.getLayoutY());
            b.getChildren().add(b.getChildren().size(), temp);
            System.out.println(b.getChildren().size());
        }
    }

    @FXML
    private void ok_number(ActionEvent event) {
        n = this.numberOfDisk.getValue();
        if (t != 0) {
            disks = null;
            container_A.getChildren().clear();
            container_B.getChildren().clear();
            container_C.getChildren().clear();
            hn = null;
        }
        start();
        hn = new HanoiClass();
        hn.setN(n);
        hn.exHanoi(n, container_A, container_B, container_C);
        movesToSolve = hn.getMovesToSolve();
    }

    @FXML
    private void animation__btn(ActionEvent event) throws InterruptedException {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                timer.start();
                if (!movesToSolve.isEmpty()) {
                    moveDisk(movesToSolve.removeFirst(), movesToSolve.removeFirst());
                    
                } else {
                    timer.stop();
                }
            }
        };
        
        timer.start();

    }

    private class AnimationListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent ae) {
            timer.start();
            if (!movesToSolve.isEmpty()) {
                moveDisk(movesToSolve.removeFirst(), movesToSolve.removeFirst());
            }
            timer.stop();
        }

    }

    private void start() {
        t = 1;
        disks = new Disk[3*n];
        this.containers = new Container[3];
        containers[0] = new Container();
        containers[1] = new Container();
        containers[2] = new Container();
        containers[0].setBox(container_A);
        containers[1].setBox(container_A);
        containers[2].setBox(container_A);

        int a = 0, b = 0, c = 0;
        for (int i = 0; i < 3 * n; i++) {
            if (i % 3 == 0) {
                this.disks[i] = new Disk(i + 1 + "");
                disks[i].setStyle("-fx-background-color :#8a2dbc");
                disks[i].setPrefHeight(40);
                disks[i].setPrefWidth(250 - 10 * i);
                Font font = new Font(16);
                disks[i].setFont(font);
                disks[i].setLayoutX(5 * i);
                disks[i].setLayoutY(400 - 40 * (a + 1));
                disks[i].setAlignment(Pos.CENTER);
                this.container_A.getChildren().add(disks[i]);
                a++;
            } else if (i % 3 == 1) {
                this.disks[i] = new Disk(i + 1 + "");
                disks[i].setStyle("-fx-background-color :#faff00");
                disks[i].setPrefHeight(40);
                disks[i].setPrefWidth(250 - 10 * i);
                Font font = new Font(16);
                disks[i].setFont(font);
                disks[i].setLayoutX(5 * i);
                disks[i].setLayoutY(400 - 40 * (b + 1));
                disks[i].setAlignment(Pos.CENTER);
                this.container_B.getChildren().add(disks[i]);
                b++;

            } else if (i % 3 == 2) {
                this.disks[i] = new Disk(i + 1 + "");
                disks[i].setStyle("-fx-background-color :#f95473");
                disks[i].setPrefHeight(40);
                disks[i].setPrefWidth(250 - 10 * i);
                Font font = new Font(16);
                disks[i].setFont(font);
                disks[i].setLayoutX(5 * i);
                disks[i].setLayoutY(400 - 40 * (c + 1));
                disks[i].setAlignment(Pos.CENTER);
                this.container_C.getChildren().add(disks[i]);
                c++;

            }

        }

    }

}
