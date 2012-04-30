package AIModule;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelListener implements MouseListener {

	private JLabel[][] Labels;
	
	
	private ImageIcon playerIcon;
	private ImageIcon OpponentIcon;
	private ImageIcon WinIcon;
	private GameLogic logic;
	private GameFrame gframe;
	
	
	public LabelListener(JLabel[][] labels,GameLogic logic, GameFrame frame) {
		super();
		Labels = labels;
	
		gframe=frame;

		this.logic=logic;
		java.net.URL url1 = getClass().getResource("ball_yellow.gif");
		WinIcon = new ImageIcon(url1);
		java.net.URL url2 = getClass().getResource("ball_green.gif");
		playerIcon = new ImageIcon(url2);
		java.net.URL url3 = getClass().getResource("ball_blue.gif");
		OpponentIcon = new ImageIcon(url3);
	
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
		int currentCol=-1;
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {
				if (Labels[column][row] == (JLabel)arg0.getSource()) {
					currentCol = column;
				}
			}

		}
		int row =gframe.getGame().makeMove(1,currentCol);
		if (row!=-1)
		{
			
			Labels[currentCol][row].setIcon(playerIcon);
			int opcol =logic.determineMove(gframe.getGame(), 2);
			int oprow=gframe.getGame().makeMove(2,opcol);
			
			//System.out.println(opcol+":col, row:"+ oprow);
			Labels[opcol][oprow].setIcon(OpponentIcon);
			
			
			if (gframe.getGame().hasWon()!=-1)
			{
				String[] winpos = gframe.getGame().getWinPositions().split("\t");
				//System.out.println("The win string is: " + winpos);
				for (int i = 0; i < winpos.length; i += 2) {
					Labels[Integer.parseInt(winpos[i])][Integer.parseInt(winpos[i + 1])]
							.setIcon(WinIcon);
				}
				
				int choice =-1;
				if (gframe.getGame().hasWon()==1)
				{
					choice=gframe.showWinMessage();
				}
				else
				{
					choice=gframe.showLooseMessage();
				}
				
				if (choice==0)
				{
					gframe.clearBoard();
					gframe.setGame(new Game());
				}
				else
				{
					gframe.killFrame();
				}
				
				
			}
		}
		
	


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}



}
