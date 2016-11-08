/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexbox.box;

/**
 *
 * @author Markus
 */
public class BoxType4 extends BoxType3{
    
    @Override
    public float getAddtionalCostMultipler() {
        return 1.3f + getSealableTopsAdditionalCost();
    }
    
}
