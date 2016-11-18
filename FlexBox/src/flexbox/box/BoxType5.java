package flexbox.box;

public class BoxType5 extends Box{
    float multiplier = 0.4f;
    
    public BoxType5(int width, int height, int length, 
            int grade, int quantity,
            boolean sealableTops){
        super(width, height, length, grade, quantity, sealableTops);
        setType(5);
        setColour(2);
        setReinforcements(true, true);
    }

    public float getTypeMultiplier() {
        return multiplier;
    }
    
}
