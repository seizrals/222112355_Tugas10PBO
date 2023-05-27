/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication16;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS TUF
 */
public class MainFrame extends javax.swing.JFrame {

    private long karakterCount =0;
    private long barisCount =0;
    private long vokalCount =0;
    private long konsonanCount =0;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void countChar (String content){
        karakterCount = content.chars()
                .filter(c -> c != ' ' && c != '\n')
                .count();
        
        barisCount = contentTextArea.getLineCount();
        
        vokalCount = content.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "AIUEOaiueo".contains(ch.toString()))
                .count();
        
        konsonanCount = content.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> Character.isLetter(ch) && 
                        !"AEIOUaeiou".contains(ch.toString()))
                .count();
    }
    
    private void showCount(){
        karakterTextField.setText(Long.toString(karakterCount));
        barisTextField.setText(Long.toString(barisCount));
        vokalTextField.setText(Long.toString(vokalCount));
        konsonanTextField.setText(Long.toString(konsonanCount));
    }
 
        private void saveCount(){
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "");
        prosesButtonActionPerformed(event);
        
        String filePath = "output.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write content to the file
            writer.write("Hasil Proses Teks");
            writer.newLine();
            
            writer.write("=================");
            writer.newLine();
            
            
            writer.write("Jumlah Karakter (diluar Spasi): " + Long.toString(karakterCount));
            writer.newLine();
            
            writer.write("Jumlah Baris: " + Long.toString(barisCount));
            writer.newLine();
            
            writer.write("Jumlah Huruf Vokal: " + Long.toString(vokalCount));
            writer.newLine();
            
            writer.write("Jumlah Huruf Konsonan: " + Long.toString(konsonanCount));
            writer.newLine();

            writer.flush();
            
            JOptionPane.showMessageDialog(this, "Berhasil disimpan!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    private void openFileModel(){
        JFileChooser choose = new JFileChooser();
        int returnValue = choose.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectFile = choose.getSelectedFile();
            if (selectFile != null) {
                String fileName = selectFile.getName();
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (!extension.equalsIgnoreCase("txt")) {
                    // The selected file is a .txt file
                    JOptionPane.showMessageDialog(null, "Format file salah!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // The selected file is not a .txt file
                    try {
                        FileReader reader = new FileReader(selectFile);
                        BufferedReader br = new BufferedReader(reader, 16384);

                        String str = "";
                        String strRead = "";
                        while ((strRead = br.readLine()) != null) {
                            str = str + strRead + '\n';
                        }
                        str = str.substring(0, str.length()-1);
                        contentTextArea.setText(str);
                        br.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Terjadi Error!.", "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        contentTextArea = new javax.swing.JTextArea();
        prosesButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        saveProsesButton = new javax.swing.JButton();
        karakterLabel = new javax.swing.JLabel();
        barisLabel = new javax.swing.JLabel();
        vokalLabel = new javax.swing.JLabel();
        konsonanLabel = new javax.swing.JLabel();
        karakterTextField = new javax.swing.JTextField();
        barisTextField = new javax.swing.JTextField();
        vokalTextField = new javax.swing.JTextField();
        konsonanTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentTextArea.setColumns(20);
        contentTextArea.setRows(5);
        contentTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contentTextAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(contentTextArea);

        prosesButton.setText("Proses Text");
        prosesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Text Area");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        saveProsesButton.setText("Save Proses Text (*.txt)");
        saveProsesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProsesButtonActionPerformed(evt);
            }
        });

        karakterLabel.setText("Jumlah Karakter (diluar spasi) :");

        barisLabel.setText("Jumlah Baris :");

        vokalLabel.setText("Jumlah Huruf Vokal :");

        konsonanLabel.setText("Jumlah Huruf Konsonan :");

        barisTextField.setMinimumSize(new java.awt.Dimension(77, 22));

        jMenu1.setText("File");

        openMenuItem.setText("Open (*.txt)");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openMenuItem);

        saveMenuItem.setText("Save (*.txt)");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prosesButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveProsesButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(karakterLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(barisLabel)
                                .addGap(100, 100, 100)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barisTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(karakterTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vokalLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(konsonanLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vokalTextField)
                            .addComponent(konsonanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosesButton)
                    .addComponent(clearButton)
                    .addComponent(saveProsesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(karakterLabel)
                    .addComponent(vokalLabel)
                    .addComponent(karakterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vokalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barisLabel)
                    .addComponent(konsonanLabel)
                    .addComponent(barisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(konsonanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        openFileModel();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        saveCount();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void contentTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contentTextAreaMouseClicked
        // TODO add your handling code here:
        contentTextArea.setFocusable(true);
    }//GEN-LAST:event_contentTextAreaMouseClicked

    private void prosesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesButtonActionPerformed
        // TODO add your handling code here:
        String content = contentTextArea.getText();

        countChar(content);
        showCount();
    }//GEN-LAST:event_prosesButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        contentTextArea.setText("");
        karakterTextField.setText("");
        barisTextField.setText("");
        vokalTextField.setText("");
        konsonanTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveProsesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProsesButtonActionPerformed
        // TODO add your handling code here:
        saveCount();
    }//GEN-LAST:event_saveProsesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barisLabel;
    private javax.swing.JTextField barisTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextArea contentTextArea;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel karakterLabel;
    private javax.swing.JTextField karakterTextField;
    private javax.swing.JLabel konsonanLabel;
    private javax.swing.JTextField konsonanTextField;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JButton prosesButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton saveProsesButton;
    private javax.swing.JLabel vokalLabel;
    private javax.swing.JTextField vokalTextField;
    // End of variables declaration//GEN-END:variables
}
