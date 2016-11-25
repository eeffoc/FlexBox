package flexbox.box;

public abstract class Box {
    //Values of the simplest box
    protected int width, height, length;
    protected int type, grade, quantity;
    protected double pricePerBox, totalPrice;
    protected boolean sealableTops;
    
    //Abstract methods
    public abstract double calculatePricePerBox();
    public abstract double calculateTotalPrice();
    
    /**
     * Box constructor. Gets values and sets as variables.
     *  @param width Width of a Box.
     *  @param height Height of a Box.
     *  @param length Length of a Box.
     *  @param type Type of a Box.
     *  @param grade Grade of a Box.
     *  @param colour Colour of the Box.
     *  @param quantity  Quantity of Boxes.
     *  @param sealableTops Whether the top of the box should be Sealable.
     *  @param reinforcedBottom Whether the box has reinforced Bottom.
     *  @param reinforcedCorners Whether the box has reinforced Corners.
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
        float gradeMultiplier = 0f;
        
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
    
    protected void setPricePerBox(double pricePerBox){
        this.pricePerBox = pricePerBox;
    }
    
    protected void setTotalPrice(double totalPrice){
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
        return false;
    }
    
    public boolean isReinforcedCorners(){
        return false;
    }
}
