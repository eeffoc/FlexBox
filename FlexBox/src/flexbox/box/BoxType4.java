package flexbox.box;

public class BoxType4 extends BoxType3{

    protected final boolean reinforcedBottom;
    
    public BoxType4(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, grade, quantity, sealableTops);
        
        this.type = 4;
        this.reinforcedBottom = true;
    }
    
    @Override
    public float getBoxExtrasMultiplier() {
        return 1.3f;
    }
    
    @Override
    public boolean isReinforcedBottom(){
        return true;
    }
}