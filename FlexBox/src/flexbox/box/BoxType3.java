package flexbox.box;

public class BoxType3 extends BoxType1{
    
    protected final int colour;
    
    public BoxType3(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, grade, quantity, sealableTops);
        
        this.type = 3;
        this.colour = 2;
        
    }
     
    @Override
    public float getBoxExtrasMultiplier() {
        return 1.16f;
    }
    
    @Override
    public int getColour(){
        return this.colour;
    }
}