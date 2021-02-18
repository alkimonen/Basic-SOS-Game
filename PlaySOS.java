import javax.swing.*;

/**
 * Play class of SOS game
 * @author Alkým Önen
 * @version 04/04/2018
 */
public class PlaySOS implements SquareGrid
{
   public static void main( String[] args)
   {
      JFrame frame;
      int dimension;
      String playerName1;
      String playerName2;
      
      frame = new JFrame();
      
      playerName1 = JOptionPane.showInputDialog( "Player 1: ");
      playerName2 = JOptionPane.showInputDialog( "Player 2: ");
      dimension = Integer.parseInt( JOptionPane.showInputDialog( "Grid dimension: "));
      
      frame.add( new SOSGUIPanel( dimension, playerName1, playerName2));
      
      frame.setSize( dimension * SQUARE_SIZE + 18, dimension * SQUARE_SIZE + 80);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      frame.setVisible( true);
   }
}