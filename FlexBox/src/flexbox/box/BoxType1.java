package flexbox.box;

public class BoxType1 extends Box{
    float multiplier = 0f;
    
    public BoxType1(int width, 
                    int height, 
                    int length, 
                    int grade, 
                    int quantity,
                    boolean sealableTops){
        super(width, height, length, grade, quantity, sealableTops);
        setType(1);
        setColour(0);
        setReinforcements(false, false);
    }

    public float getTypeMultiplier() {
        return multiplier;
    }
    
}
