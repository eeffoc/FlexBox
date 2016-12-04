package flexbox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import flexbox.box.*;
import java.io.IOException;
import java.io.PrintWriter;
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
    
    /**
     * Temporal Box object for storing on the go data and fetching price calculations
    */
    public Box tempBox;
    
    /*Exception value if the user input is empty - it gets treated as 0
     and stops any further execution*/
    private static final int EXCEPTION = 0; 
    /*Static fields to define the limits of the software*/
    /**
     * Minimum user input value for height field.
     */
    public static final int MIN_HEIGHT = 10;
    /**
     * Maximum user input value for height field.
     */
    public static final int MAX_HEIGHT = 400;
    /**
     * Minimum user input value for length field.
     */
    public static final int MIN_LENGTH = 10;
    /**
     * Maximum user input value for length field.
     */
    public static final int MAX_LENGTH = 400;
    /**
     * Minimum user input value for width field.
     */
    public static final int MIN_WIDTH = 10;
    /**
     * Maximum user input value for width field.
     */
    public static final int MAX_WIDTH = 400;
    /**
     * Minimum user input value for quantity field.
     */
    public static final int MIN_QUANTITY = 1;
    /**
     * Maximum user input value for quantity field.
     */
    public static final int MAX_QUANTITY = 500;
    
    public boolean isEditing = false;
    
    /**
     * This constructor does not require parameters.
     */
    public Order() { 
    }
    
    /**
     * Gets the width of the boxes user wants to add to order
     * @return The width of the boxes, or 0 if the input was empty
     */
    public int getWidth(){
        try {
            //Gets value from GUI
            int value = Integer.valueOf(gui.WidthInput.getText());
            
            /*Checks if the value is in specified range 
                and throws an error if not.
            */
            if (value < MIN_WIDTH || value > MAX_WIDTH)
                gui.wrongInput("Width", MIN_WIDTH, MAX_WIDTH);
            else return value; //Returns width if everything went well.
        } catch (java.lang.NumberFormatException e) {
            gui.emptyFieldError("Width");
        }
        return EXCEPTION; //Returns EXCEPTION (0) if the input was bad.
    }
    
    /**
     * Gets the length of the boxes user wants to add to order
     * @return The length of the boxes, or 0 if the input was empty
     */
    public int getLength(){
        try {
            //Gets value from GUI
            int value = Integer.valueOf(gui.LengthInput.getText());
            
            /*Checks if the value is in specified range 
                and throws an error if not.*/
            if (value < MIN_LENGTH || value > MAX_LENGTH) 
                gui.wrongInput("Length", MIN_LENGTH, MAX_LENGTH);
            else return value; //Returns length if everything went well.
        } catch (java.lang.NumberFormatException e) {
            gui.emptyFieldError("Length");
        }
        return EXCEPTION; //Returns EXCEPTION (0) if the input was bad.
    }
    
    /**
     * Gets the height of the boxes user wants to add to order
     * @return The height of the boxes, or 0 if the input was empty
     */
    public int getHeight(){
        try {
            //Gets value from GUI
            int value = Integer.valueOf(gui.HeightInput.getText());
            
            /*Checks if the value is in specified range 
                and throws an error if not.*/
            if (value < MIN_HEIGHT || value > MAX_HEIGHT) 
                gui.wrongInput("Height", MIN_HEIGHT, MAX_HEIGHT);
            else return value; //Returns height if everything went well.
        } catch (java.lang.NumberFormatException e) {
            gui.emptyFieldError("Height");
        }
        return EXCEPTION; //Returns EXCEPTION (0) if the input was bad.
    }
    
    /**
     * Gets the quantity of the boxes user wants to add to order
     * @return The quantity of the boxes, or 0 if the input was empty
     */
    public int getQuantity(){
        try {
            //Gets value from GUI
            int value = Integer.valueOf(gui.QuantityInput.getText());
            
            /*Checks if the value is in specified range 
                and throws an error if not.*/
            if (value < MIN_QUANTITY || value > MAX_QUANTITY) 
                gui.wrongInput("Quantity", MIN_QUANTITY, MAX_QUANTITY);
            else return value; //Returns height if everything went well.
        } catch (java.lang.NumberFormatException e) {
            gui.emptyFieldError("Quantity");
        }
        return EXCEPTION; //Returns EXCEPTION (0) if the input was bad.
    }
    
    /**
     * Gets the colour of the boxes user wants to add to order
     * @return The colour of the boxes
     */
    private int getColour(){
        int colour;
        //Depending on which radio button is selected in gui.
        if (gui.ColourRadio0.isSelected()){
            colour = 0;
        }
        else if (gui.ColourRadio1.isSelected()) {
            colour = 1;
        }
        else colour = 2;
        return colour;
    }
    
    /**
     * Calculates the type of the box(-es).
     * <p>
     * Dependant on the color of the boxes, whether it has reinforced bottom
     * and/or reinforced corners - returns the type using a mathematical 
     * approach.
     * <p>
     * Approach used creates the sum variable and sets it as 0. Depending on the
     * color user has selected - 0/1/2 is added to this variable. If user wants
     * reinforced bottom - 10 is added to this value. If user wants reinforced 
     * corners - 100 is added to this value. By knowing this total value it is
     * very easy to work out the type.
     * <p>
     * No Illegal value handling is needed because the GUI prevents wrong 
     * input choices.
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

    /**
     * Creates a temporal box object to store and retrieve values for user
     * manipulation and to update the total cost label.
     * <p>
     * If user clicks calculate
     * button - only the price label will be changed. If user clicks add to order
     * and proceeds - the temporal box will also be added to order. This is
     * done by passing a true or false value to this method.
     * 
     * @param AddToOrder Whether the object should be added to the order list
     * or whether only the price label should be changed.
     */
    public void addTempBox(boolean AddToOrder){
        /*Gets the values of the boxes from methods inside this class
            with input validation.
        */
        int width = getWidth();
        int height = getHeight();
        int length = getLength();
        int quantity = getQuantity();
        
        /*Grabs the values directly from GUI. 
            These values don't need any validation */
        boolean sealable = gui.SealableCheckbox.isSelected();
        int grade = gui.GradeSlider.getValue();
        boolean bottom = gui.BottomCheckbox.isSelected();
        boolean corners = gui.CornerCheckbox.isSelected();
        
        /*This colour value is grabbed from a method 
            in this class without validation*/
        int colour = getColour();
        
        //Calls the method to calculate the type depending on the user input.
        int type = calculateType(colour, bottom, corners);    
        
        //Checks if there are any bad fields and creates a temp object.
        if (width!=EXCEPTION && height!=EXCEPTION && length!=EXCEPTION && 
                quantity!=EXCEPTION){
            switch (type){
                case 1:
                    tempBox = new BoxType1(width, height, length, grade, 
                            quantity, sealable);
                    break;
                case 2:
                    tempBox = new BoxType2(width, height, length, grade, 
                            quantity, sealable);
                    break;
                case 3:
                    tempBox = new BoxType3(width, height, length, grade, 
                            quantity, sealable);
                    break;
                case 4:
                    tempBox = new BoxType4(width, height, length, grade, 
                            quantity, sealable);
                    break;
                case 5:
                    tempBox = new BoxType5(width, height, length, grade, 
                            quantity, sealable);
                    break;
                    
            }
            //Calls a method in box class to calculate the price
            tempBox.calculatePricePerBox(); 
            /*Sets the text price label as total price. Can be easily changed to
                price per item.*/
            gui.PriceLabel.setText(floatTo2dpCurrency(
                    tempBox.calculateTotalPriceOfBoxes()));
            
            //If intended to add to order - throws a confirmation popup.
            if (AddToOrder) gui.confirmBox(); 
        }
    }
    
    /**
     * Updates the order total label.
     */
    private void updateOrderTotal(){
        //Updates it in GUI.
        gui.Label_TotalSum.setText(floatTo2dpCurrency(orderSum));
    }
    
    /**
     * Adds the newly created box to order list and displays it in the GUI.
     * <p>
     * This method is called after the user has confirmed that he wants to add
     * the boxes specified by himself to his order.
     */
    public void addToOrderList(){
        //Adds to the array which holds all the boxes in the order.
        boxList.add(tempBox);
        
        if (isEditing){
            //Decreases order sum.
            orderSum -= tempBox.calculateTotalPriceOfBoxes();
 
            //Removes from ArrayList because that element will be edited
            boxList.remove(gui.OrderTable.getSelectedRow());
 
            //Removes from GUI Order List.
            DefaultTableModel model = (DefaultTableModel) gui.OrderTable.getModel();
            model.removeRow(gui.OrderTable.getSelectedRow());
            //Updates order total sum
            updateOrderTotal();
            isEditing = false;
        }

        /*
            Gets the table model from the table in the GUI.
            This is used for inserting newly added boxes into the order list.
        */
        DefaultTableModel model = (DefaultTableModel) gui.OrderTable.getModel();
        
        //For converting colour numbers to string
        String colours;
        switch (tempBox.getColour()){
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
        model.addRow(new Object[]{tempBox.getQuantity(), 
            tempBox.getGrade(), tempBox.getWidth(), tempBox.getLength(), 
            tempBox.getHeight(), colours, tempBox.isReinforcedBottom(), 
            tempBox.isReinforcedCorners(), tempBox.isBoxSealable(), 
            floatTo2dpCurrency(tempBox.calculatePricePerBox()), 
            floatTo2dpCurrency(tempBox.calculateTotalPriceOfBoxes())});
        
        //Increase orders total by the currently added boxes price.
        orderSum += tempBox.calculateTotalPriceOfBoxes();
        //Update it.
        updateOrderTotal();
    }
    
    /**
     * Removes box element from order.
     * Throws an exception if no box is selected.
     */
    public void removeFromOrderList(){
        try {          
            //Geta row (boxes) the user has selected if any
            Box newBox = boxList.get(gui.OrderTable.getSelectedRow());
            
            /*Shows a confirmation dialog if the user really wants to remove
                selected boxes.*/
            boolean confirm = gui.confirmRemove();
            
            //If the user confirms deletion
            if (confirm) {
               //Decreases order sum.
                orderSum -= newBox.calculateTotalPriceOfBoxes();

                //Removes from the main ArrayList
                boxList.remove(gui.OrderTable.getSelectedRow());

                //Removes from GUI Order List.
                DefaultTableModel model = 
                        (DefaultTableModel) gui.OrderTable.getModel();
                model.removeRow(gui.OrderTable.getSelectedRow());
                //Updates order total sum
                updateOrderTotal(); 
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException exception){
            //Throws an exception if nothing is selected
            gui.nothingSelectedError();
        }
    }

    /**
     * Allows user to edit selected items (boxes) that he has added to the 
     * order.
     * @return Value depending if the user has selected anything or not.
     */
    public boolean canEditSelected() {
        try {
            //Tries to get the selected boxes
            tempBox = boxList.get(gui.OrderTable.getSelectedRow());
            
            return true;
        }
        catch (java.lang.ArrayIndexOutOfBoundsException exception){
            //Throws an exception if nothing has been selected
            gui.nothingSelectedError();
        }
        return false;
    }
    
    /**
     * When editing selected box(-es) - set's the "Add New Box" window values
     * to the old values.
     */
    public void setEditableValues(){
            //Get values from the temporal box object.
            int width = tempBox.getWidth();
            int height = tempBox.getHeight();
            int length = tempBox.getLength();
            int quantity = tempBox.getQuantity();
            boolean sealable = tempBox.isBoxSealable();
            int grade = tempBox.getGrade();
            boolean bottom = tempBox.isReinforcedBottom();
            boolean corners = tempBox.isReinforcedCorners();
            int colour = tempBox.getColour();
            int type = tempBox.getType();
            float totalPrice = tempBox.calculateTotalPriceOfBoxes();
            
            //Updates it.
            gui.updateAddNewBoxValues(width, height, length, quantity, 
                    sealable, grade, bottom, corners, colour, type, totalPrice);
    }
    
    /**
     * Calculates how many boxes are in a order in total.
     * @return amount of boxes in order
     */
    public int orderTotalBoxes(){
        int numBoxes = 0;
        //Loops through all the elements in order list.
        for (Box box : boxList){
            numBoxes += box.getQuantity();
        }
        return numBoxes;
    }
    
    /**
     * Getter for returning the total sum of the order.
     * @return the total of the whole order.
     */
    public float getOrdTotal(){
        return orderSum;
    }
    
    /**
     * Takes in a float and returns a String which is formatted
     * to two decimal places with a pound symbol (£).
     * @param value float to be converted.
     * @return converted float with a £ in front (GBP).
     */
    public String floatTo2dpCurrency(float value){
        String convertedFloat = "£" + String.format("%.2f", value); 
        return convertedFloat;
    }
    
    /**
     * Exports order to file.
     */
    public void exportOrder(){
        try{
            //Checks if the order is not empty
            if (boxList.size() > 0) {
                //Creates new PrintWriter.
                PrintWriter writer = new PrintWriter("Order.txt", "UTF-8");
                //Asks the user to confirm he wants to export to file
                if (gui.writeToFile()){
                    /*Top of object will be formatted to show the total price
                        and the total of number of boxes.*/
                    writer.println("Invoice for order\n");
                    writer.println("Total cost: " + floatTo2dpCurrency(orderSum));
                    writer.println("Total number of boxes: " + 
                            orderTotalBoxes());
                    writer.println("*************************************");
                    writer.println("*************************************\n\n");
                    /*New ID field for users refference, 
                        other than that - no purpose.*/
                    int id = 1;
                    //Loops through the whole order and writes to file.
                    for (Box box : boxList){
                        writer.println("ID:" + id);
                        writer.println("Quantity:" + box.getQuantity());
                        writer.println("*************Properites*************");
                        writer.println("Width:" + box.getWidth());
                        writer.println("Length:" + box.getLength());
                        writer.println("Height:" + box.getHeight());
                        writer.println("Grade:" + box.getGrade());
                        writer.println("Colour:" + box.getColour());
                        writer.println("Reinforced Bottoms:" + 
                                box.isReinforcedBottom());
                        writer.println("Reinforced Corners:" + 
                                box.isReinforcedCorners());
                        writer.println("Sealable boxes:" + box.isBoxSealable());
                        writer.println("****************Cost****************");
                        writer.println("Price Per Item: " + 
                                floatTo2dpCurrency(box.getPricePerBox()));
                        writer.println("Total: " + 
                                floatTo2dpCurrency(box.getTotalPrice()));
                        writer.println(" ");
                        writer.println(" ");
                        id++;
                    }
                    writer.close(); //Closes the file.
                    //Shows a popup that everything went right.
                    gui.popupSuccess(); 
                }
            }
            //Shows a popup if there are no elements in the users order.
            else gui.popupNoItems(); 
        } catch (IOException e) {
           /*Throws an exception if something goes really bad and the system 
                can't write to file for some reason.*/
           gui.popupError(); 
        }
    }
}