package flexbox;

import layout.FlexBoxGUI;

/**
 *
 * @author Markus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FlexBoxGUI frameTest = new FlexBoxGUI();
        frameTest.setVisible(true);
 
        Order order = new Order();
        order.test();
        // Create new object order as an example test
    }
}
