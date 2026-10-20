/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author rahaf
 */
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class Orderframe extends javax.swing.JFrame {

    // Customer information received from Frame 1


    // Total price
    private double total = 0.0;

    // 2D Array
    private String[][] foodData = {

        {"Burgers", "Classic Burger", "4.50"},
        {"Burgers", "Chicken Burger", "5.00"},
        {"Burgers", "Cheese Burger", "5.50"},

        {"Pizza", "Margherita", "5.00"},
        {"Pizza", "Chicken Pizza", "6.00"},
        {"Pizza", "Pepperoni Pizza", "6.50"},

        {"Sandwiches", "Chicken Sandwich", "4.00"},
        {"Sandwiches", "Tuna Sandwich", "4.50"},
        {"Sandwiches", "Club Sandwich", "5.00"},

        {"Desserts", "Cheesecake", "3.00"},
        {"Desserts", "Brownie", "2.50"},
        {"Desserts", "Ice Cream", "2.00"},

        {"Drinks", "Cola", "1.50"},
        {"Drinks", "Orange Juice", "2.00"},
        {"Drinks", "Water", "1.00"} };
    public  String customername="";
        public  String phonenumber="";


    /**
     * Creates new form Orderframe
     */
    
    public Orderframe() {
        initComponents();
       
        // Display customer information
        lblcustomer.setText("Customer: " + customername);
        lblphone.setText("Phone: " + phonenumber);

        
        // Add categories
        cmbcategory.removeAllItems();
        cmbcategory.addItem("Burgers");
        cmbcategory.addItem("Pizza");
        cmbcategory.addItem("Sandwiches");
        cmbcategory.addItem("Desserts");
        cmbcategory.addItem("Drinks");

        // Load food items
        loadItems();
    }
    // LOAD ITEMS

    private void loadItems() {

        cmbitem.removeAllItems();
        String category = cmbcategory.getSelectedItem().toString();

        for (int i = 0; i < foodData.length; i++) {
            if (foodData[i][0].equals(category)) {
                cmbitem.addItem(foodData[i][1]);
            }
        }

        updatePrice();
    }
    // GET PRICE FROM 2DA
   

    private double getOriginalPrice() {
        String category =cmbcategory.getSelectedItem().toString();
        String item =cmbitem.getSelectedItem().toString();
        for (int i = 0; i < foodData.length; i++) {
            if (foodData[i][0].equals(category)
                    && foodData[i][1].equals(item)) {

                return Double.parseDouble(foodData[i][2]);
            }
        }

        return 0.0;
    }

    // GET FINAL PRICE 

    private double getFinalPrice() {
        double price = getOriginalPrice();
        if (rbsmall.isSelected()) {
            price = price;
        } else if (rbmedium.isSelected()) {
            price = price + 0.50;
        } else if (rblarge.isSelected()) {
            price = price + 1.00;
        }
        return price;
    }

    // UPDATE PRICE
    private void updatePrice() {
        if (cmbitem.getSelectedItem() != null) {
            double price = getFinalPrice();
            txtprice.setText(
                String.format("%.2f", price)
            );
        }
    }

    // VALIDATION
    private boolean validateInput() {
        if (cmbitem.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,"Please select a food item.","Validation Error",JOptionPane.WARNING_MESSAGE);

            return false;
        }

        if (!rbsmall.isSelected()
                && !rbmedium.isSelected()
                && !rblarge.isSelected()) {

            JOptionPane.showMessageDialog(this,"Please select a size.", "Validation Error", JOptionPane.WARNING_MESSAGE);

            return false;
        }

        return true;
    }

    // CREATE ORDER SUMMARY

    private void updateSummary() {
        String category = cmbcategory.getSelectedItem().toString();

        String item =cmbitem.getSelectedItem().toString();
String size = "";
        if (rbsmall.isSelected()) {
            size = "Small";
        } else if (rbmedium.isSelected()) {
            size = "Medium";
        } else if (rblarge.isSelected()) {
            size = "Large";
        }
        String notes = txtnotes.getText();
        double price = getFinalPrice();


        txtSummary.setText("");

        txtSummary.append("===ORDER SUMMARY===\n\n" + "Customer Name: " + customername + "\n" 
        +"Phone Number: " + phonenumber + "\n" + "Category: " + category + "\n"+"Food Item: " + item + "\n"
        
        +"Size: "+ size + "\n" +"Special Notes: "+ notes + "\n"+"Price: $" + String.format("%.2f", price) + "\n" 
           + "-----------------------------------\n"  + "Total: $"+ String.format("%.2f", total) + "\n"  );
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbcategory = new javax.swing.JComboBox<>();
        cmbitem = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbsmall = new javax.swing.JRadioButton();
        rbmedium = new javax.swing.JRadioButton();
        rblarge = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnotes = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lblcustomer = new javax.swing.JLabel();
        lblphone = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSummary = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("     Add Order     ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Urdu Typesetting", 0, 18)); // NOI18N
        jLabel1.setText("Food Ordering");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Food Selection");

        jLabel3.setText("Category:");

        jLabel4.setText("Food Item:");

        cmbcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcategoryActionPerformed(evt);
            }
        });

        cmbitem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbitemActionPerformed(evt);
            }
        });

        jLabel5.setText("Price:");

        jLabel6.setText("Size:");

        buttonGroup1.add(rbsmall);
        rbsmall.setSelected(true);
        rbsmall.setText("Small");
        rbsmall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbsmallActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbmedium);
        rbmedium.setText("Medium");
        rbmedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmediumActionPerformed(evt);
            }
        });

        buttonGroup1.add(rblarge);
        rblarge.setText("Large");
        rblarge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rblargeActionPerformed(evt);
            }
        });

        jLabel7.setText("Special Instructions:");

        txtnotes.setColumns(20);
        txtnotes.setRows(5);
        jScrollPane1.setViewportView(txtnotes);

        jButton2.setText(" Calculate Total  ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("   Show Order    ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Urdu Typesetting", 0, 18)); // NOI18N
        jLabel9.setText("Order Summary");

        txtSummary.setColumns(20);
        txtSummary.setRows(5);
        jScrollPane2.setViewportView(txtSummary);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblcustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2))
                            .addComponent(lblphone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(30, 30, 30)
                                .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbsmall)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbmedium)))
                                        .addGap(23, 23, 23)
                                        .addComponent(rblarge))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jButton3)
                                .addGap(29, 29, 29)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addGap(16, 16, 16)
                .addComponent(lblcustomer)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblphone)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbitem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rbsmall)
                            .addComponent(rbmedium)
                            .addComponent(rblarge))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton4))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if (!validateInput()) {
            return;
        }

        double price = getFinalPrice();

        total = total + price;

        JOptionPane.showMessageDialog(
            this,
            "Order added successfully!",
            "Success",
            JOptionPane.INFORMATION_MESSAGE
        );

        updateSummary();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            if (total == 0) {

            if (!validateInput()) {
                return;
            }
            total = getFinalPrice();
        }
        JOptionPane.showMessageDialog(
            this,
            "Total Price: $"
            + String.format("%.2f", total),
            "Total",
            JOptionPane.INFORMATION_MESSAGE
        );

        updateSummary();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rbmediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmediumActionPerformed
        // TODO add your handling code here:
        updatePrice();
    }//GEN-LAST:event_rbmediumActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          if (!validateInput()) {
            return;
        }

        updateSummary();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         txtprice.setText("");
        txtnotes.setText("");
        txtSummary.setText("");

        cmbcategory.setSelectedIndex(0);

        rbsmall.setSelected(true);

        total = 0.0;

        updatePrice();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          int answer = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to exit?",
            "Exit",
            JOptionPane.YES_NO_OPTION
        );

        if (answer == JOptionPane.YES_OPTION) {

            System.exit(0);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void rbsmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbsmallActionPerformed
        // TODO add your handling code here:
        updatePrice();
    }//GEN-LAST:event_rbsmallActionPerformed

    private void rblargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rblargeActionPerformed
        // TODO add your handling code here:
        updatePrice();
    }//GEN-LAST:event_rblargeActionPerformed

    private void cmbcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcategoryActionPerformed
        // TODO add your handling code here:
        if (cmbcategory.getSelectedItem() != null) {
            loadItems();
    }//GEN-LAST:event_cmbcategoryActionPerformed
    }
    private void cmbitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbitemActionPerformed
        // TODO add your handling code here:
        if (cmbitem.getSelectedItem() != null) {

            updatePrice();
    }//GEN-LAST:event_cmbitemActionPerformed
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
            java.util.logging.Logger.getLogger(orderframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orderframe().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbcategory;
    private javax.swing.JComboBox<String> cmbitem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcustomer;
    private javax.swing.JLabel lblphone;
    private javax.swing.JRadioButton rblarge;
    private javax.swing.JRadioButton rbmedium;
    private javax.swing.JRadioButton rbsmall;
    private javax.swing.JTextArea txtSummary;
    private javax.swing.JTextArea txtnotes;
    private javax.swing.JTextField txtprice;
    // End of variables declaration//GEN-END:variables
}
