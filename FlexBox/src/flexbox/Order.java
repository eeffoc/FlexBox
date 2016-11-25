package flexbox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import flexbox.box.*;
import javax.swing.table.DefaultTableModel;

/**
 * Provides all the methods for calculating the prices "On the go" for boxes 
 * and handles the GUI input/output.
 * <p>
 * Adds Boxes that the user wants to order to a 
 * ArrayList for easy handling.
 */
public class Order{
    /*New Array to hold all the boxes user wants to order.*/
    ArrayList<Box> boxList = new ArrayList<Box>();
    
    /*New Instance of Order GUI*/
    layout.FlexBoxGUI gui = new layout.FlexBoxGUI(this);
    
    /*The total of the order*/
    private double orderSum = 0.00;
    
    /**
     * This constructor does not require parameters.
     */
    public Order() { 
        
    }
    
    /**
     * Sets the price label of boxes that the user currently wants to add to
     * his current order.
     *  @param price The value to which to set the price label to.
     */
    public void setPriceLabel(double price) {
        gui.PriceLabel.setText("£" + price);
    }
    
    /**
     * Calculates the type of the box(-es).
     * <p>
     * Creates an ArrayList to hold ALL the values of the box(-es) user wants
     * to add to his order and uses a mathematical approach to get the type.
     * <p>
     * Dependant on the color of the boxes, whether it has reinforced bottom
     * and/or reinforced corners - returns the type.
     * <p>
     * Approach used creates the sum variable and sets it as 0. Depending on the
     * color user has selected - 0/1/2 is added to this variable. If user wants
     * reinforced bottom - 10 is added to this value. If user wants reinforced 
     * corners - 100 is added to this value. By knowing this total value it is
     * very easy to work out the type.
     * <p>
     * No Illegal value handling is needed because the GUI prevents wrong 
     * choices.
     *  @return The type of the box(-es) the user wants to add to his order
     */
    private int getTheType(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        
        //Get's the values from what the user has currently selected
        int colour = getCurrentBoxColor();
        boolean corners = hasReinforcedCorners();
        boolean bottom = hasReinforcedBottom();
        
        //See JavaDoc of this method
        int sum = colour;
        if (bottom) sum+=10;
        if (corners) sum+=100;
        
        //Dependant on the sum - returns the type
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
    
    /**
     * Returns the color from the currently selected options of a box.
     *  @return Color type
     */
    public int getCurrentBoxColor(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (int) values.get(1);
    }
    
    /**
     * Returns whether the user has selected reinforced corners in the
     * selected options of a box.
     *  @return If the selected box/boxes needs to have reinforced Corners.
     */
    public boolean hasReinforcedCorners(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (boolean) values.get(2);  
    }
    
    /**
     * Returns whether the user has selected reinforced bottom in the
     * selected options of a box.
     *  @return If the selected box/boxes needs to have reinforced Bottom.
     */
    public boolean hasReinforcedBottom(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (boolean) values.get(3);  
    }
    
    /**
     * Fetches the length from the currently selected box options.
     *  @return Length of Box.
     */
    public int getCurrentBoxLength(){
        int value = fetchDimensionData(5);
        return value;
    }
    
    /**
     * Fetches the width from the currently selected box options.
     *  @return Width of Box.
     */
    public int getCurrentBoxWidth(){
        int value = fetchDimensionData(6);
        return value;
    }
    
    /**
     * Fetches the height from the currently selected box options.
     *  @return Height of Box.
     */
    public int getCurrentBoxHeight(){
        int value = fetchDimensionData(7);
        return value;
    }
    
    /**
     * Fetches the quantity from the currently selected box options.
     *  @return Quantity of Boxes.
     */
    public int getCurrentBoxQuantity(){
        int value = fetchDimensionData(8);
        return value;
    }
    
    /**
     * Fetches the grade from the currently selected box options.
     *  @return Grade of Box.
     */
    public int getCurrentBoxGrade(){
        int value = fetchDimensionData(0);
        return value;
    }
    
    /**
     * Fetches the sealable option from the currently selected box options.
     *  @return Is box Sealable.
     */
    public boolean isCurrentBoxSealable(){
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (boolean) values.get(4);   
    }
    
    /**
     * Gets specific value from a specific field of an (current box options) 
     * ArrayList.
     *  @param field the index to get the value from.
     *  @return Value of a specific field.
     */
    private int fetchDimensionData(int field) {
        ArrayList values = new ArrayList();
        gui.getChoiceValues(values);
        return (int) values.get(field);
    }
    
    /**
     * Calculates the surface area of a box and returns it in square meters.
     *  @param width Width of a box (Centimetres).
     *  @param length Length of a box (Centimetres).
     *  @param height Height of a box (Centimetres).
     *  @return Box Surface Area in square meters.
     */
    private double calculateSurfaceArea(double width, double length, double height){
        double area = (2 * width * length + 2 * length * height + 2 * width * height) / 10000;
        return area;
    }
    
    /**
     * Returns the total price (price of single box multiplied by quantity) 
     * calculated by the users current selection of box properties.
     * @return The total price of the current items.
     */
    public double calculatePrice() {
        double price = 0;
        
        //Gets current variables
        double length = getCurrentBoxLength();
        double width = getCurrentBoxWidth();
        double height = getCurrentBoxHeight();
        double quantity = getCurrentBoxQuantity();
        
        //Stores surface area in square meters.
        double surfaceArea = calculateSurfaceArea(width, length, height);
        
        //Stores whether the current box is sealable.
        boolean sealable = isCurrentBoxSealable();
        
        //Depending on the grade of the box we calculate the base price.
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
        
        /*
            Start of calculation on how much the price should increase dependent
            whether the box is sealable or not
        */
        
        //Percentage divided by 100 (easier to read)
        double priceIncreasePercentage = 1; 
        if (sealable){
            priceIncreasePercentage += 0.08;
        }
        
        /*
            Price increase dependant on the type of the box.
            Increases the price of the boxes by set percentage.
            The set percentage is manually calculated.
        */
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
            default: //Box is Type 1
                priceIncreasePercentage += 0;
                break;
        }
        
        price = priceIncreasePercentage * price * quantity; //Calculates total.
        
        //Formats it to 2 decimal places and returns it.
        return Double.valueOf(new DecimalFormat("#0.00").format(price));
    }

    /**
     * Throws an exception if one of the input fields could not be
     * evaluated (are empty).
     *  @return is user input correct
     */
    public boolean isInputValid(){
        ArrayList values = new ArrayList();
        try {
            gui.getChoiceValues(values);
            return true;
        }
        catch (java.lang.NumberFormatException e ){
            gui.emptyFieldError();
            return false;
        }
    }
    
    /**
     *  Adds current box to ArrayList.
     */
    public void addBoxToOrder(){
        //Gets current box values.
        int width = getCurrentBoxWidth();
        int height = getCurrentBoxHeight();
        int length = getCurrentBoxLength();
        int quantity = getCurrentBoxQuantity();
        int grade = getCurrentBoxGrade();
        boolean sealable = isCurrentBoxSealable();
        
        //Depending on the type of box - a new class object is created.
        switch (getTheType()){
            case 1:
                boxList.add(new BoxType1(width, height, length, grade, quantity, sealable));
                addToOrderList();
                break;
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
    
    /**
     * Updates the order total label.
     */
    private void updateOrderTotal(){
        DecimalFormat round = new DecimalFormat("#.##");
        gui.Label_TotalSum.setText("£" + round.format(orderSum));
    }
    
    /**
     * Adds the newly created box to order list and displays it in the GUI.
     */
    public void addToOrderList(){
        //New Decimal Format for rounding.
        DecimalFormat round = new DecimalFormat("#.##");
        
        //Gets last element of the box ArrayList.
        Box newBox = boxList.get(boxList.size() - 1);
        
        /*
            Gets the table model from the table in the GUI.
            This is used for inserting newly added boxes into the order list.
        */
        DefaultTableModel model = (DefaultTableModel) gui.OrderTable.getModel();
        
        //For converting colour numbers to string
        String colours;
        switch (newBox.getColour()){
            case 1:
                colours = "Single";
                break;
            case 2:
                colours = "Double";
                break;
            default:
                colours = "No";
                break;
        }
        
        //Add created box to GUI Order table.
        model.addRow(new Object[]{newBox.getQuantity(), 
            newBox.getGrade(), newBox.getWidth(), newBox.getLength(), 
            newBox.getHeight(), colours, newBox.isReinforcedBottom(), 
            newBox.isReinforcedCorners(), newBox.isBoxSealable(), 
            round.format(newBox.calculatePricePerBox()), 
            round.format(newBox.calculateTotalPrice())});
        
        //Increase orders total by the currently added boxes price.
        orderSum += newBox.calculateTotalPrice();
        //Update it.
        updateOrderTotal();
    }
    
    /**
     * Removes box element from order. 
     * Throws an exception if no box is selected.
     */
    public void removeFromOrderList(){
        try {
            //Gets currently selected boxes.
            Box newBox = boxList.get(gui.OrderTable.getSelectedRow());
            //Decreases order sum.
            orderSum -= newBox.calculateTotalPrice();

            //Removes from ArrayList
            boxList.remove(gui.OrderTable.getSelectedRow());
            
            //Removes from GUI Order List.
            DefaultTableModel model = (DefaultTableModel) gui.OrderTable.getModel();
            model.removeRow(gui.OrderTable.getSelectedRow());
            System.out.print(gui.OrderTable.getSelectedRow());
            
            //Updates order total sum
            updateOrderTotal();
        }
        catch (java.lang.ArrayIndexOutOfBoundsException exception){
            System.out.print("No Items Selected");
            //TODO: Exception handling
        }
    }
}