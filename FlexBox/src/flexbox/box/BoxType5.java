package flexbox.box;

public class BoxType5 extends BoxType4{
    
    protected final boolean reinforcedCorners;
    
    public BoxType5(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, grade, quantity, sealableTops);
        
        this.type = 5;
        this.reinforcedCorners = true;
    }

    @Override
    public double calculatePricePerBox() {
        double price;
        price = getBoxSizeInMeters() * getGradeMultiplier();
        double multiplier = 1.4;
        if (this.sealableTops) multiplier += 0.08;
        price *= multiplier;
        this.setPricePerBox(price);
        return price;
    }
    
    @Override
    public double calculateTotalPrice(){
        double totalPrice = calculatePricePerBox() * this.getQuantity();
        this.setTotalPrice(totalPrice);
        return totalPrice;
    }
    
    @Override
    public boolean isReinforcedCorners(){
        return true;
    }
}