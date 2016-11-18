package flexbox.box;

public class BoxType3 extends Box{
    float multiplier = 0.16f;
    
    public BoxType3(int width, int height, int length, 
            int grade, int quantity,
            boolean sealableTops){
        super(width, height, length, grade, quantity, sealableTops);
        setType(3);
        setColour(2);
        setReinforcements(false, false);
    }

    public float getTypeMultiplier() {
        return multiplier;
    }
    
}
