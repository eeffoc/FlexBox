package flexbox;

/**
 *
 * @author Markus
 */
public class Box {
    private int boxType, boxWidth, boxHeight, boxLength, gradeOfCard, colourPrint, quantity;
    private float pricePerBox, totalPrice;
    private boolean reinforcedBottom, reinforcedCorners, sealableTops;
    
    public Box(){
        
    }
    
    public Box(int newBoxWidth, int newBoxHeight, int newBoxLength, 
            int newGradeOfCard, int newColourPrint, int newQuantity, 
            boolean newReinforcedBottom, boolean newReinforcedCorners, 
            boolean newSealableTops){
        
        this.boxWidth = newBoxWidth;
        this.boxHeight = newBoxHeight;
        this.boxLength = newBoxLength;
        this.gradeOfCard = newGradeOfCard;
        this.colourPrint = newColourPrint;
        this.quantity = newQuantity;
        this.reinforcedBottom = newReinforcedBottom;
        this.reinforcedCorners = newReinforcedCorners;
        this.sealableTops = newSealableTops;
    }
    
    public void setBoxType(int newBoxType){
        this.boxType = newBoxType;
    }
    
    public int getBoxType(){
        return boxType;
    }
    
    public void setBoxWidth(int newBoxWidth){
        this.boxWidth = newBoxWidth;
    }
    
    public int getBoxWidth(){
        return boxWidth;
    }
    
    public void setBoxHeight(int newBoxHeight){
        this.boxHeight = newBoxHeight;
    }
    
    public int getBoxHeight(){
        return boxHeight;
    }
    
    public void setBoxLength(int newBoxLength){
        this.boxLength = newBoxLength;
    }
    
    public int getBoxLength(){
        return boxLength;
    }
    
    public void setGradeOfCard(int newGradeOfCard){
        this.gradeOfCard = newGradeOfCard;
    }
    
    public int getGradeOfCard(){
        return gradeOfCard;
    }
    
    public void setColourPrint(int newColourPrint){
        this.colourPrint = newColourPrint;
    }
    
    public int getColourPrint(){
        return colourPrint;
    }
    
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setPricePerBox(float newPricePerBox){
        this.pricePerBox = newPricePerBox;
    }
    
    public float getPricePerBox(){
        return pricePerBox;
    }
    
    public void setTotalPrice(float newTotalPrice){
        this.totalPrice = newTotalPrice;
    }
    
    public float getTotalPrice(){
        return totalPrice;
    }
    
    public void setReinforcedBottom(boolean newReinforcedBottom){
        this.reinforcedBottom = newReinforcedBottom;
    }
    
    public boolean getReinforcedBottom(){
        return reinforcedBottom;
    }
    
    public void setReinforcedCorners(boolean newReinforcedCorners){
        this.reinforcedCorners = newReinforcedCorners;
    }
    
    public boolean getReinforcedCorners(){
        return reinforcedCorners;
    }
    
    public void setSealableTops(boolean newSealableTops){
        this.sealableTops = newSealableTops;
    }
    
    public boolean getSealableTops(){
        return sealableTops;
    }
}