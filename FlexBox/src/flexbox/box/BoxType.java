/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexbox.box;

/**
 *
 * @author Markus
 */
public abstract class BoxType {
    protected int boxType, boxWidth, boxHeight, boxLength, gradeOfCard, boxColour, quantityOfBox;
    protected float pricePerBox, totalPrice;
    protected boolean sealableTops;
    
    public abstract float getAddtionalCostMultipler();
    
    public float getSealableTopsAdditionalCost(){
        if (sealableTops) return 0.08f;
        else return 0;
    }
    
    public float getCostPerMetreSquared(){
        float areaOfBoxMetreSquared = (2 * (boxLength * boxWidth) +
                2 * (boxLength * boxHeight) + 2 * (boxWidth * boxHeight))
                / 10000f; // Change from cm2 to m2
        return areaOfBoxMetreSquared;
    }
}
