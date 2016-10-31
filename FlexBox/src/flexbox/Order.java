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
            boxInList.boxType = getTypeOfBox(boxInList);
            setBoxPrice(boxInList);
            System.out.println("Type: " + boxInList.boxType
            + "\nWidth (cm): " + boxInList.boxWidth 
            + "\nHeight (cm): " + boxInList.boxHeight 
            + "\nLength (cm): " + boxInList.boxLength 
            + "\nGrade of card: " + boxInList.gradeOfCard 
            + "\nColour print: " + boxInList.colourPrint 
            + "\nQuantity: " + boxInList.quantity
            + "\nReinforced bottom: " + boxInList.reinforcedBottom
            + "\nReinforced corners: " + boxInList.reinforcedCorners
            + "\nSealable tops: " + boxInList.sealableTops
            + "\nTotal Price: £" + boxInList.totalPrice
            + "\nPrice per box: £" + boxInList.pricePerBox);
        }
    }
    
    public void makeTestOrder(){ //TODO: change this when out of testing phase
         boxList = new ArrayList<Box>();
        //TODO: Change hard-coded 1 to a variable of box amount
        for(int i = 0; i < 1; i++){ //Create objects of class Box per order + add to List
        boxList.add(new Box(150,260,110,3,2,5,true,false,true)); //TODO: Pull data from GUI when user enters data
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
    
    public void setBoxPrice(Box box){
        float areaOfBoxMetreSquared = (2 * (box.boxLength * box.boxWidth) +
                2 * (box.boxLength * box.boxHeight) + 2 * (box.boxWidth * box.boxHeight))
                / 10000f; // Change from cm2 to m2
        float additionalCost = 1f; //This is a multipler thus starts at 1
        
        if(box.colourPrint == 1) additionalCost += 0.13;
        if(box.colourPrint == 2) additionalCost += 0.16;
        if(box.reinforcedBottom) additionalCost += 0.14;
        if(box.reinforcedCorners) additionalCost += 0.1;
        if(box.sealableTops) additionalCost += 0.08;
        
        float costPerMetreSquared = 0f;
        switch(box.gradeOfCard){
            case 1:
                costPerMetreSquared = 0.5f;
                break;
            case 2:
                costPerMetreSquared = 0.6f;
                break;
            case 3:
                costPerMetreSquared = 0.72f;
                break;
            case 4:
                costPerMetreSquared = 0.9f;
                break;
            case 5:
                costPerMetreSquared = 1.4f;
                break;
        }
        
        box.pricePerBox = (areaOfBoxMetreSquared * costPerMetreSquared) * additionalCost;
        box.totalPrice = box.pricePerBox * box.quantity;
    }
}


