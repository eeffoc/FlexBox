package flexbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Markus
 */
public class Order {
    private int orderID;
    private float totalPriceOfOrder = 0f;
    private List<Box> boxList;
    
    public Order(){
        
    }
    
    public void test(){
        makeTestOrder();
        for (Box boxInList : boxList) {
            boxInList.setBoxType(getTypeOfBox(boxInList));
            setBoxPrice(boxInList);
            if(boxInList.getBoxType() == 0){
                System.out.println("We cannot manufacture boxes with these selected criterias");
            } else {
                System.out.println("Type: " + boxInList.getBoxType()
                + "\nWidth (cm): " + boxInList.getBoxWidth()
                + "\nHeight (cm): " + boxInList.getBoxHeight()
                + "\nLength (cm): " + boxInList.getBoxLength()
                + "\nGrade of card: " + boxInList.getGradeOfCard()
                + "\nColour print: " + boxInList.getColourPrint()
                + "\nQuantity: " + boxInList.getQuantity()
                + "\nReinforced bottom: " + boxInList.getReinforcedBottom()
                + "\nReinforced corners: " + boxInList.getReinforcedCorners()
                + "\nSealable tops: " + boxInList.getSealableTops()
                + "\nPrice per box: £" + String.format("%.2f", boxInList.getPricePerBox())
                + "\nSubtotal: £" + String.format("%.2f", boxInList.getTotalPrice())
                + "\n\n");
            }
        }
        getOrderTotalCost();
        System.out.println("Total order cost is £" + String.format("%.2f", totalPriceOfOrder)
        + " for order number " + orderID + ".");
    }
    
    public void makeTestOrder(){ //TODO: change this when out of testing phase
        Random rand = new Random();
        orderID = rand.nextInt(9999) + 1000;
        boxList = new ArrayList<>();
        //TODO: Change hard-coded 1 to a variable of box amount
        for(int i = 0; i < 3; i++){ //Create objects of class Box per order + add to List
            boxList.add(new Box(160,260,110,3,0,18,false,false,true)); //TODO: Pull data from GUI when user enters data
        }
    }
    
    public void getOrderTotalCost(){
        for (Box boxInList : boxList) {
            //Create objects of class Box per order + add to List
            totalPriceOfOrder += boxInList.getTotalPrice();
        }
    }
    
    public int getTypeOfBox(Box box){
        switch (box.getColourPrint()){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                if (!box.getReinforcedBottom() && !box.getReinforcedCorners()){
                    return 3;
                } else if (box.getReinforcedBottom() && !box.getReinforcedCorners()){
                    return 4;
                } else if (box.getReinforcedBottom() && box.getReinforcedCorners()){
                    return 5;
                }  else {
                    return 0; //Type of Box not available
                }
            }
        return 0; //Type of Box not available (or error occured)
    }
    
    public void setBoxPrice(Box box){
        float areaOfBoxMetreSquared = (2 * (box.getBoxLength() * box.getBoxWidth()) +
                2 * (box.getBoxLength() * box.getBoxHeight()) + 2 * (box.getBoxWidth() * box.getBoxHeight()))
                / 10000f; // Change from cm2 to m2
        float additionalCost = 1f; //This is a multipler thus starts at 1
        
        if(box.getColourPrint() == 1) additionalCost += 0.13;
        if(box.getColourPrint() == 2) additionalCost += 0.16;
        if(box.getReinforcedBottom()) additionalCost += 0.14;
        if(box.getReinforcedCorners()) additionalCost += 0.1;
        if(box.getSealableTops()) additionalCost += 0.08;
        
        float costPerMetreSquared = 0f;
        switch(box.getGradeOfCard()){
            case 1:
                costPerMetreSquared = 0.5f;
                break;
            case 2:
                costPerMetreSquared = 0.6f;
                break;
            case 3:
                costPerMetreSquared = 0.72f;
                break;
            case 4:
                costPerMetreSquared = 0.9f;
                break;
            case 5:
                costPerMetreSquared = 1.4f;
                break;
        }
        
        box.setPricePerBox((areaOfBoxMetreSquared * costPerMetreSquared) * additionalCost);
        box.setTotalPrice(box.getPricePerBox() * box.getQuantity());
    }
}