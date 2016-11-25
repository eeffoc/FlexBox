package flexbox.box;

public class BoxType1 extends Box{
    
    public BoxType1(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, grade, quantity, sealableTops);
        
        this.type = 1;
    }

    @Override
    public double calculatePricePerBox() {
        double price;
        price = getBoxSizeInMeters() * getGradeMultiplier();
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
