package flexbox.box;

public abstract class Box {
    protected int type, width, height, length, grade, colour, quantity;
    protected float pricePerBox, totalPrice;
    protected boolean sealableTops, reinforcedBottom, reinforcedCorners;
    
    public abstract float getTypeMultiplier();
    
    public Box(int width, 
               int height, 
               int length, 
               int grade, 
               int quantity, 
               boolean sealableTops){
        
        this.width = width;
        this.height = height;
        this.length = length;
        this.grade = grade;
        this.quantity = quantity;
        this.sealableTops = sealableTops;
        
        this.pricePerBox = getBoxSizeInMeters() * getGradeMultiplier() * getBoxMultiplier();
        this.totalPrice = this.pricePerBox * this.quantity;
    }
    
    public float getBoxMultiplier(){
        float multiplier = 1.0f;
        multiplier += getSealableTopsMultiplier();
        multiplier += getTypeMultiplier();
        return multiplier;
    }
    
    private float getSealableTopsMultiplier(){
        if (sealableTops) return 0.08f;
        else return 0;
    }
    
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
    
    public float getBoxSizeInMeters(){
        float area = (2 * (length * width) +
                2 * (length * height) + 2 * (width * height))
                / 10000f; // Change from cm2 to m2
        return area;
    }

    protected void setType(int type){
        this.type = type;
    }
    
    public int getType(){
        return type;
    }
    
    protected void setColour(int colour){
        this.colour = colour;
    }
    
    public int getColour(){
        return colour;
    }
    
    protected void setReinforcements(boolean bottom, boolean corners){
        this.reinforcedBottom = bottom;
        this.reinforcedCorners = corners;
    }
    
    public boolean getReinforcedBottom(){
        return this.reinforcedBottom;
    }
    
    public boolean getReinforcedCorners(){
        return this.reinforcedCorners;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public int getGrade(){
        return this.grade;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public boolean getSealableTops(){
        return this.sealableTops;
    }
    
    public float getPricePerBox(){
        return this.pricePerBox;
    }
    
    public float getTotalPrice(){
        return this.totalPrice;
    }

}
