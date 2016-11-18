package flexbox.box;

public class BoxType2 extends Box{
    float multiplier = 0.13f;
    
    public BoxType2(int width, int height, int length, 
            int grade, int quantity,
            boolean sealableTops){
        super(width, height, length, grade, quantity, sealableTops);
        setType(2);
        setColour(1);
        setReinforcements(false, false);
    }

    public float getTypeMultiplier() {
        return multiplier;
    }
    
}
