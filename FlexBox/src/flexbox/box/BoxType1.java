package flexbox.box;

public class BoxType1 extends Box{
    
    public BoxType1(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, 1, grade, 0, quantity, sealableTops, false, false);
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
