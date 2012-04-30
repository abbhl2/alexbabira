package AIModule;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import AIModule.Game;

public class GameFrame extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JLabel[][] slots;
	private Game game;
	private ImageIcon playerIcon;
	private ImageIcon OpponentIcon;
	private ImageIcon WinIcon;
	private GameLogic logic;

	public GameFrame(Game game, GameLogic logic) throws HeadlessException {
		super("Connect 4");

		java.net.URL url1 = getClass().getResource("ball_yellow.gif");
		WinIcon = new ImageIcon(url1);
		java.net.URL url2 = getClass().getResource("ball_green.gif");
		playerIcon = new ImageIcon(url2);
		java.net.URL url3 = getClass().getResource("ball_blue.gif");
		OpponentIcon = new ImageIcon(url3);

		this.setResizable(false);
		this.logic = logic;
		this.game = game;

		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1024, 768);

		JPanel mainPanel = (JPanel) this.getContentPane();
		mainPanel.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 7));
		slots = new JLabel[7][6];
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {

				JLabel jl = new JLabel();

				jl.setOpaque(true);

				jl.setVisible(true);
				slots[column][row] = jl;

				slots[column][row]
						.setHorizontalAlignment(SwingConstants.CENTER);
				slots[column][row].setBorder(new LineBorder(Color.black));
				panel.add(slots[column][row]);
			}
		}

		mainPanel.add(panel, BorderLayout.CENTER);

		this.setContentPane(mainPanel);
		addListeners();
		
		this.setVisible(true);
		showInitialMessage();
	}

	public void addListeners() {
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {
				slots[column][row].addMouseListener(new LabelListener(slots,
						 logic,this));
			}
		}
	}
	
	
	public void clearBoard() {
		for (int row = 5; row >= 0; row--) {
			for (int column = 0; column < 7; column++) {
				slots[column][row].setIcon(null);
				slots[column][row].updateUI();
			}
		}
	}

	public void DrawPlayerIcon(int row, int column) {

		slots[column][row].setIcon(playerIcon);

	}

	public void DrawOpponentIcon(int row, int column) {

		slots[column][row].setIcon(OpponentIcon);
	}

	public void KillGame(String Player) {
		JOptionPane.showMessageDialog(this, "Player: " + Player
				+ " has disconnected the game will be discontinued", null,
				JOptionPane.ERROR_MESSAGE);
		killFrame();
	}

	public void PrintError(String msg) {
		JOptionPane.showMessageDialog(this, msg);
		killFrame();
	}

	public void DrawWinTrajectory(String Winposition) {
		String[] parse = Winposition.split("\t");
		System.out.println("The win string is: " + Winposition);
		for (int i = 0; i < parse.length; i += 2) {
			slots[Integer.parseInt(parse[i])][Integer.parseInt(parse[i + 1])]
					.setIcon(WinIcon);
		}
	}

	public void killFrame() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	public void showDrawMessage() {
		JOptionPane.showMessageDialog(this, "Its a draw!!!!!");
		killFrame();
	}

	public int showWinMessage() {
		Object[] options = { "Play Again", "Quit" };
		return  JOptionPane.showOptionDialog(this,
				"Congrats you have won the game",
				"Connect 4", JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);


	}

	public void showInitialMessage() {
		JOptionPane.showMessageDialog(this, "Welcome to Connect 4 , you may make your first move\nThe computer " +
				"player will follow, currently.. \nHe thinks 5 moves ahead");
	
	}
	
	public int showLooseMessage() {
		Object[] options = { "Play Again", "I Give Up!" };
		return  JOptionPane.showOptionDialog(this,
				"You Lost: Better luck next time",
				"Connect 4", JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
	}

	public ImageIcon getPlayerIcon() {
		return playerIcon;
	}

	public void setPlayerIcon(ImageIcon playerIcon) {
		this.playerIcon = playerIcon;
	}

	public ImageIcon getOpponentIcon() {
		return OpponentIcon;
	}

	public void setOpponentIcon(ImageIcon opponentIcon) {
		OpponentIcon = opponentIcon;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
