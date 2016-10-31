/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexbox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Markus
 */
public class Order {
    public int orderTotal, totalBoxesOrdered;

    public Order(int newOrderTotal, int newTotalBoxesOrdered){
        this.orderTotal = newOrderTotal;
        this.totalBoxesOrdered = newTotalBoxesOrdered;
    }
    
    public void makeTestOrder(){ //TODO: change this when out of testing phase
        List<Box> boxList = new ArrayList<Box>();
        //TODO: Change hard-coded 10 to a variable of box amount
        for(int i = 0; i < 10; i++){ //Create objects of class Box per order + add to List
        boxList.add(new Box(0,0,0,0,0,0,false,false)); //TODO: Pull data from GUI when user enters data
        }
    }
}


