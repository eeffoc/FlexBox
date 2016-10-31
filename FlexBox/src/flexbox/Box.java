/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexbox;

/**
 *
 * @author Markus
 */
public class Box {
    public int boxType, boxWidth, boxHeight, boxLength, gradeOfCard, colourPrint, quantity;
    public float pricePerBox, totalPrice;
    public boolean reinforcedBottom, reinforcedCorners, sealableTops;
    
    public Box(){
        
    }
    
    public Box(int newBoxWidth, int newBoxHeight, int newBoxLength, 
            int newGradeOfCard, int newColourPrint, int newQuantity, 
            boolean newReinforcedBottom, boolean newReinforcedCorners, 
            boolean newSealableTops){
        this.boxType = 0; //Box Type unknown at this moment
        this.boxWidth = newBoxWidth;
        this.boxHeight = newBoxHeight;
        this.boxLength = newBoxLength;
        this.gradeOfCard = newGradeOfCard;
        this.colourPrint = newColourPrint;
        this.quantity = newQuantity;
        this.reinforcedBottom = newReinforcedBottom;
        this.reinforcedCorners = newReinforcedCorners;
        this.sealableTops = newSealableTops;
        this.pricePerBox = 0f;//Price of box(es) is unknown at this moment
        this.totalPrice = 0f; //Price of box(es) is unknown at this moment
    }
    
    public void setBoxType(int newBoxType){
        this.boxType = newBoxType;
    }
}
