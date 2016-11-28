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
    private float orderSum = 0;
    
    public Box tempBox;
    
    private static final int EXCEPTION = 0;
    public static final int MIN_HEIGHT = 10;
    public static final int MAX_HEIGHT = 400;
    public static final int MIN_LENGTH = 10;
    public static final int MAX_LENGTH = 400;
    public static final int MIN_WIDTH = 10;
    public static final int MAX_WIDTH = 400;
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 500;
    
    /**
     * This constructor does not require parameters.
     */
    public Order() { 
    }
    
    public int getWidth(){
        try {
            int value = Integer.valueOf(gui.WidthInput.getText());
            if (value < MIN_WIDTH || value > MAX_WIDTH) gui.wrongInput("Width", MIN_WIDTH, MAX_WIDTH);
            else return value;
        } catch (java.lang.NumberFormatException e) {
            //TODO POPUP
        }
        return EXCEPTION;
    }
    
    public int getLength(){
        try {
            int value = Integer.valueOf(gui.LengthInput.getText());
            if (value < MIN_LENGTH || value > MAX_LENGTH) gui.wrongInput("Length", MIN_LENGTH, MAX_LENGTH);
            else return value;
        } catch (java.lang.NumberFormatException e) {
            //TODO POPUP
        }
        return EXCEPTION;
    }
    
    public int getHeight(){
        try {
            int value = Integer.valueOf(gui.HeightInput.getText());
            if (value < MIN_HEIGHT || value > MAX_HEIGHT) gui.wrongInput("Height", MIN_HEIGHT, MAX_HEIGHT);
            else return value;
        } catch (java.lang.NumberFormatException e) {
            //TODO POPUP
        }
        return EXCEPTION;
    }
    
    public int getQuantity(){
        try {
            int value = Integer.valueOf(gui.QuantityInput.getText());
            if (value < MIN_QUANTITY || value > MAX_QUANTITY) gui.wrongInput("Quantity", MIN_QUANTITY, MAX_QUANTITY);
            else return value;
        } catch (java.lang.NumberFormatException e) {
            gui.emptyFieldError("Quantity");
        }
        return EXCEPTION;
    }
    
    private int getColour(){
        int colour;
        if (gui.ColourRadio1.isSelected()){
            colour = 1;
        }
        else if (gui.ColourRadio2.isSelected()) {
            colour = 2;
        }
        else colour = 3;
        return colour;
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
    private int calculateType(int colour, boolean bottom, boolean corners){   
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

    public void addTempBox(boolean AddToOrder){
        int width = getWidth();
        int height = getHeight();
        int length = getLength();
        int quantity = getQuantity();
        boolean sealable = gui.SealableCheckbox.isSelected();
        int grade = gui.GradeSlider.getValue();
        boolean bottom = gui.BottomCheckbox.isSelected();
        boolean corners = gui.CornerCheckbox.isSelected();
        int colour = getColour();
        int type = calculateType(colour, bottom, corners);
        
        if (width!=EXCEPTION && height!=EXCEPTION && length!=EXCEPTION && quantity!=EXCEPTION){
            switch (type){
                case 1:
                    tempBox = new BoxType1(width, height, length, grade, quantity, sealable);
                    break;
                case 2:
                    tempBox = new BoxType2(width, height, length, grade, quantity, sealable);
                    break;
                case 3:
                    tempBox = new BoxType3(width, height, length, grade, quantity, sealable);
                    break;
                case 4:
                    tempBox = new BoxType4(width, height, length, grade, quantity, sealable);
                    break;
                case 5:
                    tempBox = new BoxType5(width, height, length, grade, quantity, sealable);
                    break;
            }
            tempBox.calculatePricePerBox();
            gui.PriceLabel.setText(String.valueOf("£" + tempBox.calculateTotalPriceOfBoxes()));
            if (AddToOrder) gui.confirmBox();
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
        boxList.add(tempBox);
        
        //Gets last element of the box ArrayList.
        Box newBox = tempBox;
        
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
            newBox.calculatePricePerBox(), 
            newBox.calculateTotalPriceOfBoxes()});
        
        //Increase orders total by the currently added boxes price.
        orderSum += newBox.calculateTotalPriceOfBoxes();
        //Update it.
        updateOrderTotal();
    }
    
    /**
     * Removes box element from order. 
     * Throws an exception if no box is selected.
     */
    public void removeFromOrderList(){
        try {
            boolean confirm = gui.confirmRemove();
            
            Box newBox = boxList.get(gui.OrderTable.getSelectedRow());
            //Gets currently selected boxes.
            if (confirm) {
               //Decreases order sum.
                orderSum -= newBox.calculateTotalPriceOfBoxes();

                //Removes from ArrayList
                boxList.remove(gui.OrderTable.getSelectedRow());

                //Removes from GUI Order List.
                DefaultTableModel model = (DefaultTableModel) gui.OrderTable.getModel();
                model.removeRow(gui.OrderTable.getSelectedRow());
                System.out.print(gui.OrderTable.getSelectedRow());

                //Updates order total sum
                updateOrderTotal(); 
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException exception){
            System.out.print("No Items Selected");
            //TODO: Exception handling
        }
    }
}