import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class Window extends JFrame{
  private Panneau pan = new Panneau();
  private JButton bouton = new JButton("Go");
  private JButton bouton2 = new JButton("Stop");
  private JPanel container = new JPanel();
  private JLabel label = new JLabel("Choix de la forme");
  private boolean backX, backY;
  private int x, y;
  private Thread t;  
  @SuppressWarnings("rawtypes")
  private JComboBox combo = new JComboBox();
  private String strTest = "none";
  
  @SuppressWarnings("unchecked")
  public Window(){
    this.setTitle("Please rename for me");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
 
    container.setLayout(new BorderLayout());
    container.add(pan, BorderLayout.CENTER);
    
    bouton.addActionListener(new BoutonListener());     
    bouton2.addActionListener(new Bouton2Listener());
    bouton2.setEnabled(false);    
    JPanel south = new JPanel();
    south.add(bouton);
    south.add(bouton2);
    container.add(south, BorderLayout.SOUTH);
    combo.addItem("TEST");
    combo.addActionListener(new FormeListener());
    
    JPanel top = new JPanel();
    top.add(label);
    top.add(combo);    
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true);          
  }

  private void go(){
    JPanel yolo = new JPanel();
    JLabel l = new JLabel("coucou");
    yolo.add(l); 
    container.add(yolo);
    this.setContentPane(container);
  }
 
  //Classe écoutant notre bouton
  public class BoutonListener implements ActionListener{
     public void actionPerformed(ActionEvent arg0) {
      t = new Thread(new PlayAnimation());
      t.start();
      bouton.setEnabled(false);
      bouton2.setEnabled(true); 
    }
  }
  
  class Bouton2Listener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      bouton.setEnabled(true);
      bouton2.setEnabled(false);
    }  
  }  
  
  class PlayAnimation implements Runnable{
    public void run() {
      go();    
    }  
  }
    
  class FormeListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      pan.setName(combo.getSelectedItem().toString());
    }  
  }    
}