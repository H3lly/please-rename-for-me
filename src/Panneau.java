import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class Panneau extends JPanel {
  private int posX = -50;
  private int posY = -50;
  private String name = "none";
  
  private void draw(Graphics g){      
    if(this.name.equals("TEST")){
      System.out.println("COUCOU");
    }
  }

  public void setName(String name){
    this.name = name;
  }
  
  public int getPosX() {
    return posX;
  }
 
  public void setPosX(int posX) {
    this.posX = posX;
  }
 
  public int getPosY() {
    return posY;
  }
 
  public void setPosY(int posY) {
    this.posY = posY;
  }
}