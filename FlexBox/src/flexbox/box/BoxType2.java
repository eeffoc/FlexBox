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
    public float getBoxExtrasMultiplier() {
        return 1.13f;
    }
    
    @Override
    public int getColour(){
        return this.colour;
    }
}