package flexbox.box;

public class BoxType2 extends Box{
    
    public BoxType2(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, 1, grade, 1, quantity, sealableTops, false, false);
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
}