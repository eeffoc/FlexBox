package flexbox.box;

public class BoxType4 extends Box{
    float multiplier = 0.3f;
    
    public BoxType4(int width, int height, int length, 
            int grade, int quantity,
            boolean sealableTops){
        super(width, height, length, grade, quantity, sealableTops);
        setType(4);
        setColour(2);
        setReinforcements(true, false);
    }

    public float getTypeMultiplier() {
        return multiplier;
    }
    
}
