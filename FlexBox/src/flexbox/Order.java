package flexbox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import flexbox.box.*;
import java.awt.PopupMenu;

public class Order{
    ArrayList<Box> boxList = new ArrayList<Box>();
    
    layout.FlexBoxGUI gui = new layout.FlexBoxGUI(this);
    
    
    public Order() { 
        
    }
    
    public void setPriceLabel() {
        double price = calculatePrice();
        String formattedPrice = "£" + price;
        gui.PriceLabel.setText(formattedPrice);
    }
    
    private int getTheType(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        
        int colour = (int) values.get(1);
        boolean corners = hasThickCorners();
        boolean bottom = hasThickBottom();
        
        int sum = colour;
        if (bottom) sum+=10;
        if (corners) sum+=100;
        
        switch (sum) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                if (sum < 100) return 4; else return 5;   
        }
    }
    
    public boolean hasThickCorners(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (boolean) values.get(2);  
    }
    
    public boolean hasThickBottom(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (boolean) values.get(3);  
    }
    
    public int getCurrentBoxLength(){
        int value = fetchDimensionData(5);
        return value;
    }
    
    public int getCurrentBoxWidth(){
        int value = fetchDimensionData(6);
        return value;
    }
    
    public int getCurrentBoxHeight(){
        int value = fetchDimensionData(7);
        return value;
    }
    
    public int getCurrentBoxQuantity(){
        int value = fetchDimensionData(8);
        return value;
    }
    
    public int getCurrentBoxGrade(){
        int value = fetchDimensionData(0);
        return value;
    }
    
    public boolean isCurrentBoxSealable(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (boolean) values.get(4);   
    }
    
    private int fetchDimensionData(int field) {
        ArrayList values = new ArrayList();
        try {
            gui.getChoiceValues(values);
            return (int) values.get(field);
        }
        catch (java.lang.NumberFormatException e ){
            gui.emptyFieldError();
            return 0;
        }
    }
    
    public double calculatePrice() {
        double price = 0;
        
        double length = getCurrentBoxLength();
        double width = getCurrentBoxWidth();
        double height = getCurrentBoxHeight();
        double quantity = getCurrentBoxQuantity();
        double surfaceArea = (2 * width * length + 2 * length * height + 2 * width * height) / 10000;
        
        boolean sealable = isCurrentBoxSealable();
       
        switch ((int) getCurrentBoxGrade()){
            case 1:
                price = surfaceArea * 0.5;
                break;
            case 2:
                price = surfaceArea * 0.6;
                break;
            case 3:
                price = surfaceArea * 0.72;
                break;
            case 4:
                price = surfaceArea * 0.9;
                break;
            case 5:
                price = surfaceArea * 1.4;
                break;
        }
        
        double priceIncreasePercentage = 1;
        if (sealable){
            priceIncreasePercentage += 0.08;
        }
        
        
        switch ((int) getTheType()){
            case 2:
                priceIncreasePercentage += 0.13;
                break;
            case 3:
                priceIncreasePercentage += 0.16;
                break;
            case 4:
                priceIncreasePercentage += 0.30;
                break;
            case 5:
                priceIncreasePercentage += 0.40;
                break;
            default:
                priceIncreasePercentage += 0;
                break;
        }
        
        price = priceIncreasePercentage * price * quantity;
        return Double.valueOf(new DecimalFormat("#0.00").format(price));
    }

    public void addBoxToOrder(){
        int width = getCurrentBoxWidth();
        int height = getCurrentBoxHeight();
        int length = getCurrentBoxLength();
        int quantity = getCurrentBoxQuantity();
        int grade = getCurrentBoxGrade();
        boolean sealable = isCurrentBoxSealable();
        
        switch (getTheType()){
            case 1:
                boxList.add(new BoxType1(width, height, length, grade, quantity, sealable));
                addToOrderList();
            case 2:
                boxList.add(new BoxType2(width, height, length, grade, quantity, sealable));
                addToOrderList();
                break;
            case 3:
                boxList.add(new BoxType3(width, height, length, grade, quantity, sealable));
                addToOrderList();
                break;
            case 4:
                boxList.add(new BoxType4(width, height, length, grade, quantity, sealable));
                addToOrderList();
                break;
            case 5:
                boxList.add(new BoxType5(width, height, length, grade, quantity, sealable));
                addToOrderList();
                break;
        }
    }
    
    public void addToOrderList(){
        Box newBox = boxList.get(boxList.size() - 1);
        String formattedDescription = "" + newBox.getQuantity() + " Boxes|";
        if (newBox.getSealableTops()) formattedDescription += "Sealable|";
        formattedDescription +=  
                  "W: " + newBox.getWidth() + "cm|"
                + "L: " + newBox.getLength() + "cm|" 
                + "H: " + newBox.getHeight() + "cm|"
                + "Grade: " + newBox.getGrade() + "|";
        if (newBox.getColour() == 0) formattedDescription += "No";
        else formattedDescription += newBox.getColour();
        formattedDescription += " Colour(s)|";
        if (newBox.getReinforcedBottom()) formattedDescription += "\nReinforced Bottoms|";
        if (newBox.getReinforcedCorners()) formattedDescription += "Reinforced Corners|";
        formattedDescription += "Total: £" 
                + newBox.getTotalPrice()
                + " (£" + newBox.getPricePerBox()
                + "ppi).";
        gui.orderBoxList.add(formattedDescription);
    }
    
    public void removeFromOrderList(){
        int a[] = gui.orderBoxList.getSelectedIndexes();
        for (int i = 0; i < a.length; i++){
            gui.orderBoxList.remove(a[i]);
            boxList.remove(a[i]);
        }
    }
}