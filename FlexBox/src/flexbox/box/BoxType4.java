package flexbox.box;

public class BoxType4 extends Box{
    
    public BoxType4(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, 4, grade, 2, quantity, sealableTops, true, false);
    }

    @Override
    public double calculatePricePerBox() {
        double price;
        price = getBoxSizeInMeters() * getGradeMultiplier();
        double multiplier = 1.3;
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
}