/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * reads all players names and scores
 * in a jText component.<br>
 * This is all laid out within a JPanel.
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class HighScore extends javax.swing.JPanel {

    /**
     * Creates new form HighScores
     */
    public HighScore() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        highScore = new javax.swing.JTextArea();
        showScore = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        highScore.setColumns(20);
        highScore.setRows(5);
        jScrollPane1.setViewportView(highScore);

        add(jScrollPane1);
        jScrollPane1.setBounds(23, 51, 350, 227);

        showScore.setText("Show Score");
        showScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showScoreActionPerformed(evt);
            }
        });
        add(showScore);
        showScore.setBounds(110, 20, 160, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menuBackground.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);
    }// </editor-fold>//GEN-END:initComponents
     /**
      * shows contents read from text file when clicked.<br>
      * Text file contents presented in jText component
      * @param evt 
      */
    private void showScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showScoreActionPerformed
        String file_name = "sample.txt";
        try {
           /**
            * reads contents from file and displays them in JPanel
            */
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            
            int i;
            for(i= 0; i<aryLines.length; i++){
                highScore.append(aryLines[i] + System.lineSeparator());
            }    } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showScoreActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea highScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showScore;
    // End of variables declaration//GEN-END:variables
}
