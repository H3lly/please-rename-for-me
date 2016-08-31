import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {
  private int compteur = 0;
  private JLabel label = new JLabel("coucou");

  public Window() {
    this.setTitle("No name");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public Window(String name, int width, int height) {
    JPanel pan = new JPanel();
    this.setContentPane(pan);               
    JButton bOuvrir = new JButton("Ouvrir");

    pan.add(bOuvrir);
    bOuvrir.addActionListener(this);
    
    pan.add(label, BorderLayout.NORTH);
    this.setTitle(name);
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent arg0) {  
    this.compteur++;
    label.setText("Vous avez cliqué " + this.compteur + " fois");

  }

}
