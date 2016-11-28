package flexbox.box;

public class BoxType1 extends Box{
    
    public BoxType1(int width, int height, int length, int grade, int quantity,
                    boolean sealableTops){
        
        super(width, height, length, grade, quantity, sealableTops);
        
        this.type = 1;
    }

    @Override
    public float getBoxExtrasMultiplier() {
        return 1.0f;
    }
}
