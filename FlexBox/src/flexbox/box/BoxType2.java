package flexbox.box;

public class BoxType2 extends BoxType1{
    
    protected final int colour;
    
    public BoxType2(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, grade, quantity, sealableTops);
        
        this.type = 2;
        this.colour = 1;
    }

    @Override
    public double calculatePricePerBox() {
        double price;
        price = getBoxSizeInMeters() * getGradeMultiplier();
        double multiplier = 1.13;
        if (this.sealableTops) multiplier += 0.08;
        price *= multiplier;
        this.setPricePerBox(price);
        return price;
    }
    
    @Override
    public double calculateTotalPrice(){
        double totalPrice = this.pricePerBox * this.quantity;
        this.setTotalPrice(totalPrice);
        return totalPrice;
    }
    
    @Override
    public int getColour(){
        return this.colour;
    }
}