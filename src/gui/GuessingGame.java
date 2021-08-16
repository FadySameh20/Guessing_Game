package gui;

import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

public class GuessingGame extends javax.swing.JFrame {
    
    private int num;
    private int attempts;

    public GuessingGame() {
        initComponents();
        this.setLocationRelativeTo(null);
        initiate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        guessLabel = new javax.swing.JLabel();
        attemptsLabel = new javax.swing.JLabel();
        attemptsTextField = new javax.swing.JTextField();
        guessButton = new javax.swing.JButton();
        guessTextField = new javax.swing.JTextField();
        resultLabel = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 153));
        titleLabel.setText("Guessing Game");
        getContentPane().add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        guessLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        guessLabel.setText("Your guess (1-10): ");
        getContentPane().add(guessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, -1, 30));

        attemptsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attemptsLabel.setText("Attempts");
        getContentPane().add(attemptsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 59, -1, -1));
        getContentPane().add(attemptsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 53, 30, -1));

        guessButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        guessButton.setText("Guess");
        guessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });
        getContentPane().add(guessButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 70, 30));
        getContentPane().add(guessTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 53, 30, -1));

        resultLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(resultLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 240, 70, 31));

        restartButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        restartButton.setText("Restart");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 265, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initiate() {
        Random rand = new Random();
        num = rand.nextInt(10) + 1;
        attempts = 3;
        attemptsTextField.setText(Integer.toString(attempts));
        guessTextField.setText("");
        guessButton.setEnabled(true);
        guessTextField.setEditable(true);
        resultLabel.setText("");
        attemptsTextField.setEditable(false);
    }
    
    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessButtonActionPerformed
        
        int guess;
        try{
            guess = Integer.parseInt(guessTextField.getText());
            while(guess < 1 || guess > 10) {
                JOptionPane.showMessageDialog(this, "Your guess must be between 1 and 10 inclusive.");
                return;
            }
            checkGuess(guess);
        } catch(Exception e) {
           JOptionPane.showMessageDialog(this, "Invalid input !");
        }
        guessTextField.setText("");
    }//GEN-LAST:event_guessButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        initiate();
    }//GEN-LAST:event_restartButtonActionPerformed

    public void checkGuess(int guess) {
        if(guess == num){
            resultLabel.setText("Correct !");
            resultLabel.setForeground(Color.green);
            guessButton.setEnabled(false);
            guessTextField.setEditable(false);
            return;
        } else if(guess < num) {
            JOptionPane.showMessageDialog(this, "Your guess is below the generated random number.");
        } else {
            JOptionPane.showMessageDialog(this, "Your guess is above the generated random number.");
        }
        if(attempts != 1) {
            attempts = attempts - 1;
            attemptsTextField.setText(Integer.toString(attempts));
        } else {
            attemptsTextField.setText(Integer.toString(attempts-1));
            resultLabel.setText("You lost !");
            resultLabel.setForeground(Color.red);
            guessButton.setEnabled(false);
            guessTextField.setEditable(false);
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
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuessingGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptsLabel;
    private javax.swing.JTextField attemptsTextField;
    private javax.swing.JLabel background;
    private javax.swing.JButton guessButton;
    private javax.swing.JLabel guessLabel;
    private javax.swing.JTextField guessTextField;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
