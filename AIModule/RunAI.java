package AIModule;

public class RunAI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Game gm = new Game();
		GameLogic gl = new GameLogic();

		new GameFrame(gm, gl);
	}

}
