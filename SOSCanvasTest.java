import cs101.sosgame.SOS;
import javax.swing.*;

/**
 * Test class of SOSCanvas
 * @author Alkým Önen
 * @version 04/04/2018
 */
public class SOSCanvasTest implements SquareGrid
{
   public static void main( String[] args)
   {
      JFrame frame;
      JPanel sosGrid;
      SOS sosGame;
      
      sosGame = new SOS( 5);
      sosGame.play( 's', 2, 4);
      sosGame.play( 'o', 3, 4);
      sosGame.play( 's', 4, 4);
      
      frame = new JFrame();
      sosGrid = new SOSCanvas( sosGame);
      
      sosGame.play( 'o', 1, 1);
      sosGame.play( 's', 5, 5);
      
      frame.add(sosGrid);
      
      frame.setSize( 300, 300);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      frame.setVisible( true);
   }
}