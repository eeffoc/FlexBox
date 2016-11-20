package flexbox.box;

public abstract class Box {
    //Values of a box
    protected int width, height, length;
    protected int type, grade, colour, quantity;
    protected double pricePerBox, totalPrice;
    protected boolean sealableTops, reinforcedBottom, reinforcedCorners;
    
    //Methods from child class
    public abstract double calculatePricePerBox();
    public abstract double calculateTotalPrice();
    
    /**
     * Box constructor. Gets values and sets as variables.
     *  @param width Width of a Box.
     *  @param height Height of a Box.
     *  @param length Length of a Box.
     *  @param type Type of a Box.
     *  @param grade Grade of a Box.
     *  @param colour Color of the Box.
     *  @param quantity  Quantity of Boxes.
     *  @param sealableTops Whether the top of the box should be Sealable.
     *  @param reinforcedBottom Whether the box has reinforced Bottom.
     *  @param reinforcedCorners Whether the box has reinforced Corners.
     */
    public Box(int width, int height, int length, int type, int grade,
               int colour, int quantity, boolean sealableTops,
               boolean reinforcedBottom, boolean reinforcedCorners){
        this.width = width;
        this.height = height;
        this.length = length;
        
        this.type = type;
        this.grade = grade;
        this.colour = colour;
        this.quantity = quantity;
        this.sealableTops = sealableTops;
        this.reinforcedBottom = reinforcedBottom;
        this.reinforcedCorners = reinforcedCorners;
    }
    
    /**
     * Calculates box area in meters.
     * @return Area of box in meters.
     */
    public double getBoxSizeInMeters(){
        double area, areaInMeters;
        area = (2 * length * width + 2 * length * height + 2 * width * height);
        areaInMeters = squareCentimetersToSquareMeters(area);
        return areaInMeters;
    }
    
    /**
     * Takes square Centimeters - returns Square Meters.
     * @param cmSquared Square Centimeters to be converted to square meters.
     * @return Square meters.
     */
    public double squareCentimetersToSquareMeters(double cmSquared){
        return cmSquared / 10000;
    }
    
    /**
     * Calculates how much the price should be increased (multiplied) by.
     * @return Amount the price should be multiplied by.
     */
    public float getGradeMultiplier(){
        switch (grade){
            case 2:
                return 0.6f;
            case 3:
                return 0.72f;
            case 4:
                return 0.9f;
            case 5:
                return 1.4f;
            default:
                return 0.5f;
        }
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
    
    protected void setColour(int colour){
        this.colour = colour;
    }
    
    protected void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    protected void setPricePerBox(double pricePerBox){
        this.pricePerBox = pricePerBox;
    }
    
    protected void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }
    
    protected void setSealable(boolean sealable){
        this.sealableTops = sealable;
    }
    
    protected void setReinforcedBottom(boolean bottom){
        this.reinforcedBottom = bottom;
    }
    
    protected void setReinforcedCorners(boolean corners){
        this.reinforcedCorners = corners;
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
        return this.colour;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public double getPricePerBox(){
        return this.pricePerBox;
    }
    
    public double getTotalPrice(){
        return this.totalPrice;
    }
    
    public boolean isBoxSealable(){
        return this.sealableTops;
    }
    
    public boolean isReinforcedBottom(){
        return this.reinforcedBottom;
    }
    
    public boolean isReinforcedCorners(){
        return this.reinforcedCorners;
    }
}
