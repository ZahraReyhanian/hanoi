
import java.util.LinkedList;
import java.util.Stack;
import javafx.scene.layout.Pane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AVAJANG
 */
public class HanoiClass {

    private int n;
    private LinkedList<Pane> movesToSolve;

    public HanoiClass() {

        movesToSolve = new LinkedList<Pane>();
    }

    public void hanoi(int n, Pane A, Pane B, Pane C) {
        if (n >= 1) {
            hanoi(n - 1, A, C, B);
            move(A, C);
            movesToSolve.addLast(A);
            movesToSolve.addLast(C);
            hanoi(n - 1, B, A, C);
        }
    }

    public void move(Pane a, Pane b) {
    }

    public void exHanoi(int n, Pane a, Pane b, Pane c) {
        if (n == 1) {
            move(c, b);

            movesToSolve.addLast(c);
            movesToSolve.addLast(b);
            move(a, c);

            movesToSolve.addLast(a);
            movesToSolve.addLast(c);
            hanoi(2, b, a, c);
        } else {
            exHanoi(n - 1, a, b, c);
            hanoi(3 * n - 2, c, a, b);
            move(a, c);

            movesToSolve.addLast(a);
            movesToSolve.addLast(c);
            hanoi(3 * n - 1, b, a, c);
        }
    }

    public LinkedList<Pane> getMovesToSolve() {
        return movesToSolve;
    }

    public void setN(int n) {
        this.n = n;
    }
}
