/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout;
import java.awt.event.KeyEvent;

/**
 *
 * @author Markus
 */
public class FlexBoxGUI extends javax.swing.JFrame {

    /**
     * Creates new form FlexBoxGUI
     */
    
    private int col = 0;
    private boolean bottom = false;
    private boolean corners = false;
    private int grade = 1;
    private boolean sealableTop = false;
    private double price = 0;
    private int quantity = 0;
    
    public FlexBoxGUI() {
        initComponents();
        AddNewItem.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ColourButtons = new javax.swing.ButtonGroup();
        AddNewItem = new javax.swing.JFrame();
        GradeSlider = new javax.swing.JSlider();
        ColourRadio0 = new javax.swing.JRadioButton();
        ColourRadio2 = new javax.swing.JRadioButton();
        ColourRadio1 = new javax.swing.JRadioButton();
        SealableCheckbox = new javax.swing.JCheckBox();
        BottomCheckbox = new javax.swing.JCheckBox();
        CornerCheckbox = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        QuantityInput = new javax.swing.JEditorPane();
        WidthInput = new javax.swing.JEditorPane();
        LengthInput = new javax.swing.JEditorPane();
        HeightInput = new javax.swing.JEditorPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TotalPriceLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        Label_Main = new javax.swing.JLabel();
        Label_CurrOrd = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_CurrOrd = new javax.swing.JList<>();
        Label_Total = new javax.swing.JLabel();
        Label_TotalSum = new javax.swing.JLabel();
        Button_AddBox = new javax.swing.JButton();
        Button_CheckOut = new javax.swing.JButton();

        AddNewItem.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        AddNewItem.setTitle("Add New Item");
        AddNewItem.setMaximumSize(new java.awt.Dimension(720, 450));
        AddNewItem.setMinimumSize(new java.awt.Dimension(720, 450));
        AddNewItem.setPreferredSize(new java.awt.Dimension(720, 450));
        AddNewItem.setResizable(false);
        AddNewItem.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                AddNewItemWindowClosing(evt);
            }
        });
        AddNewItem.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradeSlider.setMajorTickSpacing(1);
        GradeSlider.setMaximum(5);
        GradeSlider.setMinimum(1);
        GradeSlider.setMinorTickSpacing(1);
        GradeSlider.setPaintLabels(true);
        GradeSlider.setSnapToTicks(true);
        GradeSlider.setValue(1);
        AddNewItem.getContentPane().add(GradeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, 30));

        ColourButtons.add(ColourRadio0);
        ColourRadio0.setText("No colour");
        ColourRadio0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColourRadio0ActionPerformed(evt);
            }
        });
        AddNewItem.getContentPane().add(ColourRadio0, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        ColourButtons.add(ColourRadio2);
        ColourRadio2.setText("Two Coloured");
        ColourRadio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColourRadio2ActionPerformed(evt);
            }
        });
        AddNewItem.getContentPane().add(ColourRadio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        ColourButtons.add(ColourRadio1);
        ColourRadio1.setText("Single Coloured");
        ColourRadio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColourRadio1ActionPerformed(evt);
            }
        });
        AddNewItem.getContentPane().add(ColourRadio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        SealableCheckbox.setText("Sealable");
        AddNewItem.getContentPane().add(SealableCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 100, -1, -1));

        BottomCheckbox.setText("Reinforced");
        BottomCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottomCheckboxActionPerformed(evt);
            }
        });
        AddNewItem.getContentPane().add(BottomCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 100, -1, -1));

        CornerCheckbox.setText("Reinforced");
        CornerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CornerCheckboxActionPerformed(evt);
            }
        });
        AddNewItem.getContentPane().add(CornerCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 100, -1, -1));
        AddNewItem.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 720, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        AddNewItem.getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 720, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grade");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddNewItem.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Colour");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddNewItem.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 135, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bottom");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddNewItem.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 50, 125, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Corners");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddNewItem.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 125, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Top");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddNewItem.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 50, 125, 20));

        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CancelButtonMousePressed(evt);
            }
        });
        AddNewItem.getContentPane().add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 140, 40));

        QuantityInput.setText("1");
        QuantityInput.setAutoscrolls(false);
        QuantityInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QuantityInputKeyTyped(evt);
            }
        });
        AddNewItem.getContentPane().add(QuantityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 60, 20));

        WidthInput.setText("0");
        WidthInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                WidthInputKeyTyped(evt);
            }
        });
        AddNewItem.getContentPane().add(WidthInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 60, 20));

        LengthInput.setText("0");
        LengthInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LengthInputKeyTyped(evt);
            }
        });
        AddNewItem.getContentPane().add(LengthInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 60, 20));

        HeightInput.setText("0");
        HeightInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HeightInputKeyTyped(evt);
            }
        });
        AddNewItem.getContentPane().add(HeightInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 60, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Quantity:");
        jLabel8.setPreferredSize(new java.awt.Dimension(62, 15));
        AddNewItem.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 80, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Width:");
        AddNewItem.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 80, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Length:");
        AddNewItem.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 80, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Height:");
        AddNewItem.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 80, -1));

        AddButton.setText("Add To Cart");
        AddNewItem.getContentPane().add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 140, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Box Selection");
        jLabel11.setMaximumSize(new java.awt.Dimension(140, 17));
        jLabel11.setMinimumSize(new java.awt.Dimension(140, 17));
        jLabel11.setPreferredSize(new java.awt.Dimension(140, 17));
        AddNewItem.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        TotalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalPriceLabel.setText("£0.00");
        AddNewItem.getContentPane().add(TotalPriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 80, 20));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total Price:");
        AddNewItem.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 240, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Price:");
        AddNewItem.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 240, -1));

        PriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceLabel.setText("£0.00");
        AddNewItem.getContentPane().add(PriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 80, 20));
        AddNewItem.getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 720, 10));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlexBox");
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(736, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(736, 550));

        Label_Main.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Label_Main.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Main.setText("FlexBox");

        Label_CurrOrd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Label_CurrOrd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_CurrOrd.setText("Current Order:");
        Label_CurrOrd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        List_CurrOrd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(List_CurrOrd);

        Label_Total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Label_Total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Total.setText("Total:");

        Label_TotalSum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Label_TotalSum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Label_TotalSum.setText("£0.00");

        Button_AddBox.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Button_AddBox.setText("Add To Order");
        Button_AddBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Button_AddBoxMouseDragged(evt);
            }
        });
        Button_AddBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_AddBoxMouseClicked(evt);
            }
        });

        Button_CheckOut.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Button_CheckOut.setText("Check out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(Label_CurrOrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_TotalSum, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(65, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_CheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_AddBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Label_Main)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_CurrOrd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Total)
                    .addComponent(Label_TotalSum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_AddBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_CheckOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("Desktop application for placing orders");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AddBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_AddBoxMouseClicked
        AddNewItem.setVisible(true);
        this.setVisible(false);
        GradeSlider.setMinimum(1);
        GradeSlider.setMaximum(3);
        GradeSlider.setValue(1);
        BottomCheckbox.setEnabled(false);
        CornerCheckbox.setEnabled(false);
        ColourRadio0.setSelected(true);
    }//GEN-LAST:event_Button_AddBoxMouseClicked

    private void Button_AddBoxMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_AddBoxMouseDragged
        AddNewItem.setVisible(true);
        this.setVisible(false);
        GradeSlider.setMinimum(1);
        GradeSlider.setMaximum(3);
        GradeSlider.setValue(1);
        BottomCheckbox.setEnabled(false);
        CornerCheckbox.setEnabled(false);
        ColourRadio0.setSelected(true);
    }//GEN-LAST:event_Button_AddBoxMouseDragged

    private void AddNewItemWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_AddNewItemWindowClosing
        this.setVisible(true);
    }//GEN-LAST:event_AddNewItemWindowClosing

    private void CancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMousePressed
        this.setVisible(true);
        AddNewItem.setVisible(false);
    }//GEN-LAST:event_CancelButtonMousePressed

    private void ColourRadio0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColourRadio0ActionPerformed
        if (ColourRadio0.isSelected()){
            GradeSlider.setMinimum(1);
            GradeSlider.setMaximum(3);
            GradeSlider.setValue(1);
            BottomCheckbox.setEnabled(false);
            CornerCheckbox.setEnabled(false);
            BottomCheckbox.setSelected(false);
            CornerCheckbox.setSelected(false);  
        }
    }//GEN-LAST:event_ColourRadio0ActionPerformed

    private void ColourRadio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColourRadio1ActionPerformed
        if (ColourRadio1.isSelected()){
            GradeSlider.setMinimum(2);
            GradeSlider.setMaximum(4);
            GradeSlider.setValue(2);
            BottomCheckbox.setEnabled(false);
            CornerCheckbox.setEnabled(false);
            BottomCheckbox.setSelected(false);
            CornerCheckbox.setSelected(false);
        }
    }//GEN-LAST:event_ColourRadio1ActionPerformed

    private void ColourRadio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColourRadio2ActionPerformed
        if (ColourRadio2.isSelected()){
            GradeSlider.setMinimum(2);
            GradeSlider.setMaximum(5);
            GradeSlider.setValue(2);
            BottomCheckbox.setEnabled(true);
            CornerCheckbox.setEnabled(true);
            BottomCheckbox.setSelected(true);
            CornerCheckbox.setSelected(false);
        }
    }//GEN-LAST:event_ColourRadio2ActionPerformed

    private void CornerCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CornerCheckboxActionPerformed
        if (CornerCheckbox.isSelected()){
            GradeSlider.setMinimum(3);
            GradeSlider.setValue(3);
        }
        else {
            GradeSlider.setMinimum(2);
            GradeSlider.setValue(2);
        }
    }//GEN-LAST:event_CornerCheckboxActionPerformed

    private void BottomCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottomCheckboxActionPerformed
        BottomCheckbox.setSelected(true); 
    }//GEN-LAST:event_BottomCheckboxActionPerformed

    private void WidthInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WidthInputKeyTyped
        char c = evt.getKeyChar();
        isNumberInput(c, evt);
    }//GEN-LAST:event_WidthInputKeyTyped

    private void LengthInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LengthInputKeyTyped
        char c = evt.getKeyChar();
        isNumberInput(c, evt);
    }//GEN-LAST:event_LengthInputKeyTyped

    private void HeightInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HeightInputKeyTyped
        char c = evt.getKeyChar();
        isNumberInput(c, evt);
    }//GEN-LAST:event_HeightInputKeyTyped

    private void QuantityInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuantityInputKeyTyped
        char c = evt.getKeyChar();
        isNumberInput(c, evt);
    }//GEN-LAST:event_QuantityInputKeyTyped

    private void isNumberInput(char c, java.awt.event.KeyEvent evt){
        if (!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlexBoxGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlexBoxGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlexBoxGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlexBoxGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlexBoxGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JFrame AddNewItem;
    private javax.swing.JCheckBox BottomCheckbox;
    private javax.swing.JButton Button_AddBox;
    private javax.swing.JButton Button_CheckOut;
    private javax.swing.JButton CancelButton;
    private javax.swing.ButtonGroup ColourButtons;
    private javax.swing.JRadioButton ColourRadio0;
    private javax.swing.JRadioButton ColourRadio1;
    private javax.swing.JRadioButton ColourRadio2;
    private javax.swing.JCheckBox CornerCheckbox;
    private javax.swing.JSlider GradeSlider;
    private javax.swing.JEditorPane HeightInput;
    private javax.swing.JLabel Label_CurrOrd;
    private javax.swing.JLabel Label_Main;
    private javax.swing.JLabel Label_Total;
    private javax.swing.JLabel Label_TotalSum;
    private javax.swing.JEditorPane LengthInput;
    private javax.swing.JList<String> List_CurrOrd;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JEditorPane QuantityInput;
    private javax.swing.JCheckBox SealableCheckbox;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.JEditorPane WidthInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
