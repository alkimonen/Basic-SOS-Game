import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * SOSGUIPanel class
 * @author Alkým Önen
 * @version 04/04/2018
 */
public class SOSGUIPanel extends JPanel implements SquareGrid
{
   
   private int dimension;
   private String player1;
   private String player2;
   private JLabel playerLabel1;
   private JLabel playerLabel2;
   
   /*
   private JRadioButton sButton;
   private JRadioButton oButton;
   private ButtonGroup radioButtons;
   private JPanel buttonPanel;
   */
   
   private JPanel statusPanel;
   
   private SOS sosGame;
   private SOSCanvas gameTable;
   
   public SOSGUIPanel( int dimension, String player1, String player2)
   {
      this.dimension = dimension;
      this.player1 = player1;
      this.player2 = player2;
      
      sosGame = new SOS( dimension);
      gameTable = new SOSCanvas( sosGame);
      
      playerLabel1 = new JLabel( player1 + ": " + sosGame.getPlayerScore1());
      playerLabel2 = new JLabel( player2 + ": " + sosGame.getPlayerScore2());
      
      playerLabel1.setOpaque( true);
      playerLabel2.setOpaque( true);
      
      /*
      buttonPanel = new JPanel();
      
      sButton = new JRadioButton( "S", true);
      oButton = new JRadioButton( "O");
      
      radioButtons = new ButtonGroup();
      radioButtons.add( sButton);
      radioButtons.add( oButton);
      
      buttonPanel.add( sButton);
      buttonPanel.add( oButton);
      */
      
      statusPanel = new JPanel();
      statusPanel.setLayout( new BorderLayout());
      statusPanel.add( playerLabel1, BorderLayout.WEST);
      statusPanel.add( playerLabel2, BorderLayout.EAST);
      
      /*
      statusPanel.add( buttonPanel, BorderLayout.CENTER);
      */
      
      setLayout( new BorderLayout());
      this.add( gameTable, BorderLayout.CENTER);
      add( statusPanel, BorderLayout.SOUTH);
      
      showTurn();
      
      addMouseListener( new GridMouseListener());
   }
   
   /**
    * Changes the background color of player names according to player turn
    */
   public void showTurn()
   {
      if ( sosGame.getTurn() == 1 )
      {
         playerLabel1.setBackground( Color.GREEN);
         playerLabel2.setBackground( Color.WHITE);
      }
      else if ( sosGame.getTurn() == 2 )
      {
         playerLabel1.setBackground( Color.WHITE);
         playerLabel2.setBackground( Color.GREEN);
      }
   }
   
   /**
    * Updates the scores of players
    */
   public void updateScores()
   {
      playerLabel1.setText( player1 + ": " + sosGame.getPlayerScore1());
      playerLabel2.setText( player2 + ": " + sosGame.getPlayerScore2());
   }
   
   class GridMouseListener implements MouseListener
   {
      /**
       * Writes S or O to grid and prints it
       * @param event Mouse click
       */
      public void mousePressed( MouseEvent event)
      {
         int r;
         int c;
         String winMessage;
         
         if ( event.getX() < dimension * SQUARE_SIZE && event.getY() < dimension * SQUARE_SIZE )
         {
            c = ( event.getX() / SQUARE_SIZE ) + 1;
            r = ( event.getY() / SQUARE_SIZE ) + 1;
            
            if ( event.getButton() == MouseEvent.BUTTON1 )
            {
               sosGame.play( 's', r, c);
            }
            else if ( event.getButton() == MouseEvent.BUTTON3 )
            {
               sosGame.play( 'o', r, c);
            }
            /* radio buttons
             * 
                if ( sButton.isSelected())
                   sosGame.play( 's', r, c);
                else if ( oButton.isSelected())
                   sosGame.play( 'o', r, c);
               */
            
            showTurn();
            updateScores();
            gameTable.updateCellContents( sosGame);
            gameTable.repaint();
         }
         
         if ( sosGame.isGameOver() )
         {
            if ( sosGame.getPlayerScore1() > sosGame.getPlayerScore2() )
               winMessage = player1 + " wins!";
            else if ( sosGame.getPlayerScore1() < sosGame.getPlayerScore2() )
               winMessage = player2 + " wins!";
            else
               winMessage = "Row!";
            
            JOptionPane.showMessageDialog( null, winMessage, "Game over", JOptionPane.INFORMATION_MESSAGE);
            System.exit( 0);
         }
      }
      
      // Do-nothing methods
      public void mouseReleased( MouseEvent event) {}
      public void mouseClicked( MouseEvent event) {}
      public void mouseEntered( MouseEvent event) {}
      public void mouseExited( MouseEvent event) {}
   }
}