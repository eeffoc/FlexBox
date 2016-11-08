package flexbox;

import java.util.ArrayList;


public class Order {
//    ArrayList<Box> boxList = new ArrayList<Box>( );
//    private float totalPriceOfOrder = 0f;
    
    public Order(){
        
    }
        
//    public void getOrderTotalCost(){
//        for (Box boxInList : boxList) {
//            //Create objects of class Box per order + add to List
//            totalPriceOfOrder += boxInList.getTotalPrice();
//        }
//    }
    
    public static int calculateBoxType (int colour, boolean reinforcedCorners, boolean reinforcedBottom){
        int sum = colour;
        if (reinforcedCorners) sum+=10;
        if (reinforcedBottom) sum+=100;
        
        switch (sum) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                if (sum < 100) return 3; else return 4;   
        }
    }
    
//    public float calculateBoxPrice(int grade, int type, boolean sealedTop, int width, int height, int length){
//        
//    }
    
//    public int getTypeOfBox(Box box){
//        switch (box.getColourPrint()){
//            case 0:
//                return 1;
//            case 1:
//                return 2;
//            case 2:
//                if (!box.getReinforcedBottom() && !box.getReinforcedCorners()){
//                    return 3;
//                } else if (box.getReinforcedBottom() && !box.getReinforcedCorners()){
//                    return 4;
//                } else if (box.getReinforcedBottom() && box.getReinforcedCorners()){
//                    return 5;
//                }  else {
//                    return 0; //Type of Box not available
//                }
//            }
//        return 0; //Type of Box not available (or error occured)
//    }
    
//    public void setBoxPrice(Box box){
//        float areaOfBoxMetreSquared = (2 * (box.getBoxLength() * box.getBoxWidth()) +
//                2 * (box.getBoxLength() * box.getBoxHeight()) + 2 * (box.getBoxWidth() * box.getBoxHeight()))
//                / 10000f; // Change from cm2 to m2
//        float additionalCost = 1f; //This is a multipler thus starts at 1
//        
//        if(box.getColourPrint() == 1) additionalCost += 0.13;
//        if(box.getColourPrint() == 2) additionalCost += 0.16;
//        if(box.getReinforcedBottom()) additionalCost += 0.14;
//        if(box.getReinforcedCorners()) additionalCost += 0.1;
//        if(box.getSealableTops()) additionalCost += 0.08;
//        
//        float costPerMetreSquared = 0f;
//        switch(box.getGradeOfCard()){
//            case 1:
//                costPerMetreSquared = 0.5f;
//                break;
//            case 2:
//                costPerMetreSquared = 0.6f;
//                break;
//            case 3:
//                costPerMetreSquared = 0.72f;
//                break;
//            case 4:
//                costPerMetreSquared = 0.9f;
//                break;
//            case 5:
//                costPerMetreSquared = 1.4f;
//                break;
//        }
//        
//        box.setPricePerBox((areaOfBoxMetreSquared * costPerMetreSquared) * additionalCost);
//        box.setTotalPrice(box.getPricePerBox() * box.getQuantity());
//    }
}