import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;

/**
 * SOSCanvas class
 * @author Alkým Önen
 * @version 04/04/2018
 */
public class SOSCanvas extends JPanel implements SquareGrid
{
   
   private int gridDimension;
   private char[][] cellContents;
   
   public SOSCanvas( SOS game)
   {
      gridDimension = game.getDimension();
      cellContents = new char[ gridDimension][ gridDimension];
      
      updateCellContents( game);
   }
   
   /**
    * Takes content information from SOS instance
    * @param game SOS instance
    */
   public void updateCellContents( SOS game)
   {
      int r;
      int c;
      
      for ( r = 0; r < gridDimension; r++ )
      {
         for ( c = 0; c < gridDimension; c++ )
         {
            cellContents[r][c] = game.getCellContents( r, c);
         }
      }
   }
   
   /**
    * Paints the grid and contents of SOS instance
    * @param g Graphics
    */
   @Override
   public void paintComponent( Graphics g)
   {
      int r;
      int c;
      
      super.paintComponent( g);
      
      for ( r = 0; r < gridDimension * SQUARE_SIZE; r = r + SQUARE_SIZE )
      {
         for ( c = 0; c < gridDimension * SQUARE_SIZE; c = c + SQUARE_SIZE )
         {
            g.drawRect( c, r, SQUARE_SIZE, SQUARE_SIZE);
         }
      }
      
      for ( r = 0; r < cellContents.length; r++)
      {
         for ( c = 0; c < cellContents[r].length; c++)
         {
            g.drawString( cellContents[r][c] + "", (SQUARE_SIZE / 2) + (c * SQUARE_SIZE), (SQUARE_SIZE / 2) + (r * SQUARE_SIZE));
         }
      }
   }
}