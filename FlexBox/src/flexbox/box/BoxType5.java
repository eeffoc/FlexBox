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
    public float getBoxExtrasMultiplier() {
        return 1.4f;
    }
    
    @Override
    public boolean isReinforcedCorners(){
        return true;
    }
}