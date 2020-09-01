
import java.util.ArrayList;
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
public class Container {
    private Pane box;
    private ArrayList disks;
    
    public Container(){
        this.box = new Pane();
        disks = new ArrayList<Disk>();
    }
    public Container(Pane box){
        this.box = new Pane();
        this.box=box;
        disks = new ArrayList<Disk>();
    }
    
    public void setBox(Pane box){
        this.box = box;
    }
    
    public Pane getBox(){
        return box;
    }
    
    public ArrayList<Disk> getDisk(){
    return this.disks;
    }
}
