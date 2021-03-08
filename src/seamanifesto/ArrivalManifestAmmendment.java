/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;
import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
/**
 *
 * @author nibba
 */
public class ArrivalManifestAmmendment extends javax.swing.JFrame {

    /**
     * Creates new form NewArrivalManifest
     */
    public ArrivalManifestAmmendment() {
        
        JSONParser jparser = new JSONParser();
        
        try {
            Object obj = jparser.parse(new FileReader(
                    getClass().getResource("/schemas/SAA.json").getFile()));
            
            this.samSchema = (JSONObject) obj;

        } catch (IOException | ParseException e) {
        }
        initComponents();
        generateForm();
    }
    
    private String getDesc(JSONObject prop){
        return (String) prop.getOrDefault("description", "No description");
    }
    
    private String getType(JSONObject prop){
        return (String) prop.get("type");
    }
    
    private boolean hasKey(JSONObject prop, String key){
        return prop.containsKey(key);
    }
    
    private double[] getRange(JSONObject prop){
        double[] range = new double[2];
        try{
            Double min = (Double) prop.get("minimum");
            Double max = (Double) prop.get("maximum");
            range[0] = min;
            range[1] = max;
        }catch(Exception e){
            System.out.println(prop);
        }finally{
            return range;
        }
    }
    
    private void generateFields(JSONObject group){
        
        JSONObject groupProps = (JSONObject) group.get("properties");
        
        for(Iterator iterator = groupProps.keySet().iterator(); iterator.hasNext();){
            String key = (String) iterator.next();

            JPanel field = new JPanel(new GridLayout());
            
            JLabel name = new JLabel(key);
            name.setToolTipText(getDesc((JSONObject) groupProps.get(key)));

            field.add(name);

            if(getType((JSONObject) groupProps.get(key)).equals("string")){
                JTextField entry = new JTextField();
                entry.setAlignmentX(RIGHT_ALIGNMENT);
                entry.setText("0");
                field.add(entry);
            }

            if(getType((JSONObject) groupProps.get(key)).equals("number")){
                
                double[] range = getRange((JSONObject) groupProps.get(key));
                
                JPanel comboPanel = new JPanel(new GridLayout(1, 2));
                
                if((int)range[1] == 2147483647)
                    range[1] = 99999999;
                
                JSlider slider = new JSlider((int)range[0], (int)range[1]);
                slider.setPaintLabels(true);
                slider.setAlignmentX(CENTER_ALIGNMENT);
                
                JLabel val = new JLabel("0");
                val.setAlignmentX(CENTER_ALIGNMENT);

                comboPanel.add(val);
                comboPanel.add(slider);
                field.add(comboPanel);
                
                slider.addChangeListener((ChangeEvent e) -> {
                    val.setText(""+((JSlider)e.getSource()).getValue());
                });
            }
            
            if(getType((JSONObject) groupProps.get(key)).equals("object")){
                JLabel objLabel = new JLabel("<><><><><><><><><><><><><><><>");
                formPanel.add(objLabel);
                generateFields((JSONObject) groupProps.get(key));
            }
            
            if(getType((JSONObject) groupProps.get(key)).equals("array")){
                JSONObject arrayField = (JSONObject) groupProps.get(key);
                generateFields((JSONObject) arrayField.get("items"));
            }
            
            field.setAlignmentX(CENTER_ALIGNMENT);
            name.setAlignmentX(LEFT_ALIGNMENT);

            formPanel.add(field);
        }
    }
    
    
    private void generateForm(){
        this.descLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.descLabel.setText((String) this.samSchema.get("description"));
        
        JSONObject reqProps = (JSONObject) this.samSchema.get("properties");
        
        for(Iterator iterator = reqProps.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();

            formPanel.add(new JSeparator());
            generateFields((JSONObject) reqProps.get(key));
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldPane = new javax.swing.JScrollPane();
        formPanel = new javax.swing.JPanel();
        descLabel = new javax.swing.JLabel();
        addEntryButton = new javax.swing.JButton();
        removeEntryButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fieldPane.setToolTipText("");

        formPanel.setLayout(new javax.swing.BoxLayout(formPanel, javax.swing.BoxLayout.Y_AXIS));

        descLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descLabel.setText("Description");
        descLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        formPanel.add(descLabel);

        fieldPane.setViewportView(formPanel);

        addEntryButton.setText("Add Entry");
        addEntryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryButtonActionPerformed(evt);
            }
        });

        removeEntryButton.setText("Remove Entry");

        continueButton.setText("Continue");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        titleLabel.setText("Arrival Manifest Ammendment");

        titleLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titleLabel.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fieldPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(removeEntryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPane, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addEntryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(removeEntryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(continueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEntryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEntryButtonActionPerformed

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Please fill up all the entries", "Human fault", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_continueButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ArrivalManifestAmmendment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArrivalManifestAmmendment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArrivalManifestAmmendment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArrivalManifestAmmendment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArrivalManifestAmmendment().setVisible(true);
            }
        });
    }

    private JSONObject samSchema;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEntryButton;
    private javax.swing.JButton continueButton;
    private javax.swing.JLabel descLabel;
    private javax.swing.JScrollPane fieldPane;
    private javax.swing.JPanel formPanel;
    private javax.swing.JButton removeEntryButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}