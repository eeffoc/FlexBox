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
    List<Box> boxList;

    public Order(int newOrderTotal, int newTotalBoxesOrdered){
        this.orderTotal = newOrderTotal;
        this.totalBoxesOrdered = newTotalBoxesOrdered;
    }
    
    public Order(){
        
    }
    
    public void test(){
        makeTestOrder();
        for (Box boxInList : boxList) {
            System.out.println("Type: " + getTypeOfBox(boxInList)
            + "\nWidth (cm): " + boxInList.boxWidth 
            + "\nHeight (cm): " + boxInList.boxHeight 
            + "\nLength (cm): " + boxInList.boxLength 
            + "\nGrade of card: " + boxInList.gradeOfCard 
            + "\nColour print: " + boxInList.colourPrint 
            + "\nQuantity: " + boxInList.quantity
            + "\nReinforced bottom: " + boxInList.reinforcedBottom
            + "\nReinforced corners: " + boxInList.reinforcedCorners
            + "\nSealable tops: " + boxInList.sealableTops
            + "\nPrice: " + boxInList.totalPrice);
        }
    }
    
    public void makeTestOrder(){ //TODO: change this when out of testing phase
         boxList = new ArrayList<Box>();
        //TODO: Change hard-coded 1 to a variable of box amount
        for(int i = 0; i < 1; i++){ //Create objects of class Box per order + add to List
        boxList.add(new Box(160,60,40,1,0,20,false,false,false)); //TODO: Pull data from GUI when user enters data
        }
    }
    
    public int getTypeOfBox(Box box){
        switch (box.colourPrint){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                if (!box.reinforcedBottom && !box.reinforcedCorners){
                    return 3;
                } else if (box.reinforcedBottom && !box.reinforcedCorners){
                    return 4;
                } else {
                    return 5;
                }  
            }
        
        return 0; //Error
        
    }
}


