package flexbox.box;

public abstract class Box {
    //Values of the simplest box
    protected int width, height, length, type, grade, quantity;
    protected float pricePerBox, totalPrice;
    protected boolean sealableTops;
    
    //Abstract methods
    public abstract float getBoxExtrasMultiplier();
    
    /**
     * Box constructor. Gets values and sets as variables.
     *  @param width Width of a Box.
     *  @param height Height of a Box.
     *  @param length Length of a Box.
     *  @param grade Grade of a Box.
     *  @param quantity  Quantity of Boxes.
     *  @param sealableTops Whether the top of the box should be Sealable.
     */
    public Box(int width, int height, int length, int grade,
            int quantity, boolean sealableTops){
        this.width = width;
        this.height = height;
        this.length = length;
        this.grade = grade;
        this.quantity = quantity;
        this.sealableTops = sealableTops;
    }
    
    /**
     * Calculates box area in meters.
     * @return Area of box in meters.
     */
    public float getBoxSizeInMeters(){
        float area, areaInMeters;
        area = ((2.0f * length * width) + (2.0f * length * height) + (2.0f * width * height));
        areaInMeters = squareCentimetersToSquareMeters(area);
        return areaInMeters;
    }
    
    /**
     * Takes square Centimeters - returns Square Meters.
     * @param cmSquared Square Centimeters to be converted to square meters.
     * @return Square meters.
     */
    public float squareCentimetersToSquareMeters(float cmSquared){
        return cmSquared / 10000.0f;
    }
    
    /**
     * Calculates how much the price should be increased (multiplied) by based
     * on grade cost per m2.
     * @return Amount the price should be multiplied by.
     */
    public float getGradeMultiplier(){
        float gradeMultiplier = 0.0f;
        
        switch (grade){
            case 1:
                gradeMultiplier = 0.5f;
                break;
            case 2:
                gradeMultiplier = 0.6f;
                break;
            case 3:
                gradeMultiplier = 0.72f;
                break;
            case 4:
                gradeMultiplier = 0.9f;
                break;
            case 5:
                gradeMultiplier = 1.4f;
                break;
            default:
                break;
        }
        return gradeMultiplier;
    }
    
    /**
     * Checks if box has sealable tops
     * @return multiplier for sealable tops when box is sealable
     */
    public float getPriceSealable(){
        float sealablePrice = 0.0f;
        if (this.sealableTops) sealablePrice = 0.08f;
        return sealablePrice;
    }
    
    /**
     * Calculates the price for a box
     * @return total cost of one box
     */
    public float calculatePricePerBox(){
        float boxPricePerMetreSquared, boxTotalCost, boxExtrasMultiplier;
        
        boxPricePerMetreSquared = getBoxSizeInMeters() * getGradeMultiplier();
        boxExtrasMultiplier = getBoxExtrasMultiplier() + getPriceSealable();
        boxTotalCost = boxPricePerMetreSquared * boxExtrasMultiplier;
        
        //This is required to round a float to 2 decimal places
        //and still save it as a float instead of a string
        //When not rounding and having a quantity of higher than 1 you will
        //have a different sum than actual PPI * quantity
        double roundedBoxTotalCost = Math.round(boxTotalCost*100.0) / 100.0;
        
        //Casting double to a float
        setPricePerBox((float)roundedBoxTotalCost);
        return (float)roundedBoxTotalCost;
    }
    
    /**
     * Calculates total cost of boxes ordered of this type
     * @return cost of all boxes ordered with these specifications
     */
    public float calculateTotalPriceOfBoxes(){
        float totalCost = this.quantity * this.pricePerBox;
        
        setTotalPrice(totalCost);
        return totalCost;
    }

    //SETTERS
    protected void setWidth(int width){
        this.width = width;
    }
    
    protected void setHeight(int height){
        this.height = height;
    }
    
    protected void setLength(int length){
        this.length = length;
    }
    
    protected void setType(int type){
        this.type = type;
    }
    
    protected void setGrade(int grade){
        this.grade = grade;
    }
    
    protected void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    protected void setPricePerBox(float pricePerBox){
        this.pricePerBox = pricePerBox;
    }
    
    protected void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
    }
    
    protected void setSealable(boolean sealable){
        this.sealableTops = sealable;
    }
    
    //GETTERS
    public int getWidth(){
        return this.width;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getType(){
        return this.type;
    }
    
    public int getGrade(){
        return this.grade;
    }
    
    public int getColour(){
        return 0;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public float getPricePerBox(){
        return this.pricePerBox;
    }
    
    public float getTotalPrice(){
        return this.totalPrice;
    }
    
    public boolean isBoxSealable(){
        return this.sealableTops;
    }
    
    public boolean isReinforcedBottom(){
        return false;
    }
    
    public boolean isReinforcedCorners(){
        return false;
    }
}
