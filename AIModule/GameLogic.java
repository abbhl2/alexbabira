package AIModule;

public class GameLogic {
	// private Game game;
	private  int maxDepth = 5;
	private static final int invalidScore = 1000000;
	private static final int maxScore = 100;
	boolean useEvaluationFunction = true;
	



	public GameLogic() {
		super();
		
	}

	public int minimax(Game game, int player) {
		return minimax(game, player, -invalidScore, invalidScore, 0);
	}

	public int minimax(Game game, int player, int alpha, int beta, int depth) {

		// Check if there's a current winner
		int winner = game.hasWon();
		if (winner == 2)
			return maxScore *1/(depth+1);
		else if (winner == 1)
			return -maxScore *1/(depth+1);

		

		if (depth >= maxDepth) {
			if (useEvaluationFunction)
				return game.getScore();
			else
				return 0;
		}

		if (player == 2) {
			for (int move = 0; move < game.width; ++move)
				if (game.canMove(move)) {
					game.makeMove(2, move);
					int score = minimax(game, 1, alpha, beta, depth + 1);
					game.undo(move, 2);
					if (score > alpha)
						alpha = score;
					if (alpha >= beta)
						return alpha;
				}
			return alpha;
		}

		else if (player == 1) {
			for (int move = 0; move < game.width; ++move)
				if (game.canMove(move)) {
					game.makeMove(1, move);
					int score = minimax(game, 2, alpha, beta, depth + 1);
					game.undo(move, 1);
					if (score < beta)
						beta = score;
					if (alpha >= beta)
						return beta;
				}
			return beta;
		} else
			
			return 0;
	}

	public int determineMove(Game game, int player) {
		
		if (player == 2) {

			int maxScore = -invalidScore;
			int maxMove = 0;
			for (int move = 0; move < game.width; ++move)
				if (game.canMove(move)) {
					game.makeMove(2, move);
					int score = minimax(game, 1);
					//System.out.println("score is :" + score);
					
					if (score >= maxScore) {
						maxScore = score;
						maxMove = move;
					}
					game.undo(move, 2);
				}
			
			return maxMove;
		}

		else if (player == 1) {
			
			int minScore = invalidScore;
			int minMove = 0;
			for (int move = 0; move < game.width; ++move) {
				if (game.canMove(move)) {
					game.makeMove(1, move);
					int score = minimax(game, 2);

					

					if (score < minScore) {
						minScore = score;
						minMove = move;
					}
					game.undo(move, 1);
				}
				
			}
			
			return minMove;
		} else
			
			return 0;
	}

}
