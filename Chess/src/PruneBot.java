public class PruneBot extends Bot {
	private int initDepth = 2;
	private int calls = 0;
	public PruneBot(String color)
	{
		super(color);
	}
	
	public int[][] getMove(Board board)
	{
		System.out.println("calculating...");
		ArrayList<Integer> tiedBoardIndexes = new ArrayList<Integer>();
		calls = 0;
		Square[][] possibleMoves = null;
		possibleMoves = sort(board.getAllLegalMoves(getColor()),board);
		Board[] possibleBoards = new Board[possibleMoves.length];
		for(int i = 0; i < possibleMoves.length; i++)
		{
			possibleBoards[i] = new Board(board.getArr());
			possibleBoards[i].move(possibleMoves[i][0].convert(),possibleMoves[i][1].convert(), getColor());
		}
		int maxEval = -100;
		int index = -1;
		for(int i = 0; i < possibleBoards.length; i++)
		{
			int eval = minimax(possibleBoards[i], false, -10000, 10000, initDepth);
			if(possibleBoards[i].getSquare(2,7).getPiece() instanceof Knight || possibleBoards[i].getSquare(6,5).getPiece() instanceof Knight)
			{
				possibleBoards[i].printBoard();
				System.out.println("materialScore: " + eval);
			}
			if(eval > maxEval)
			{
				tiedBoardIndexes.clear();
				maxEval = eval;
				index = i;
				tiedBoardIndexes.add(i);
			}
			else if(eval == maxEval)
			{
				tiedBoardIndexes.add(i);
			}
		}
		if(tiedBoardIndexes.size() > 1)
		{
			int greatestControl = -100;
			int greatestSpace = -100;
			index = 0;
			for(int i: tiedBoardIndexes)
			{
				int eval = possibleBoards[i].getAllControlledSquares(getColor()).length;
				int space = possibleBoards[i].getSpace(getColor()).length;
				System.out.println("Move: ");
				possibleBoards[i].printBoard();
				System.out.println("controlScore: " + eval);
				if(eval > greatestControl)
				{
					greatestControl = eval;
					index = i;
					greatestSpace = space;
				}
				else if(eval == greatestControl)
				{
					if(space > greatestSpace)
					{
						greatestSpace = space;
						index = i;
					}
				}
			}
		}
		System.out.println("decided index: " + index);
		int[][] decision = {possibleMoves[index][0].convert(),possibleMoves[index][1].convert()};
		return decision;
	}
	// The minimax function takes a board, initial alpha, initial beta, depth, and botsTurn as parameters
	// and computes a number that describes how advantageous for the AI a particular board is. 
	private int minimax(Board board, boolean botsTurn, int alpha, int beta, int depth)
	{
		calls++;
		System.out.println(calls);
		if(depth == 0 || board.checkMate("white") || board.checkMate("black"))
		{
			return scoreBoard(board);
		}
		
		String botColor = "";
		String playerColor = "";
		if(getColor().equals("black"))
		{
			botColor = "black";
			playerColor = "white";
		}
		else if(getColor().equals("white"))
		{
			botColor = "white";
			playerColor = "black";
		}
		
		Square[][] possibleMoves = null;
		possibleMoves = board.getAllLegalMoves(botColor);
		Board[] possibleBoards = new Board[possibleMoves.length];
		for(int i = 0; i < possibleMoves.length; i++)
		{
			possibleBoards[i] = new Board(board.getArr());
			possibleBoards[i].move(possibleMoves[i][0].convert(),possibleMoves[i][1].convert(), botColor);
		}
		
		Square[][] playerPossibleMoves = null;
		playerPossibleMoves = board.getAllLegalMoves(playerColor);
		Board[] playerPossibleBoards = new Board[playerPossibleMoves.length];
		for(int i = 0; i < playerPossibleMoves.length; i++)
		{
			playerPossibleBoards[i] = new Board(board.getArr());
			playerPossibleBoards[i].move(playerPossibleMoves[i][0].convert(),playerPossibleMoves[i][1].convert(), playerColor);
		}
		
		
		if(botsTurn)
		{
			int maxEval = -10000;
			for(Board i: possibleBoards)
			{
				int eval = minimax(i, false, alpha, beta, depth-1);
				if(eval > maxEval)
					maxEval = eval;
				if(eval > alpha)
					alpha = eval;
				if(beta <= alpha)
					break;
			}
			return maxEval;
		}
		else
		{
			int minEval = 10000;
			for(Board i: playerPossibleBoards)
			{
				int eval =  minimax(i, true, alpha, beta, depth-1);
				if(eval < minEval)
					minEval = eval;
				if(eval < beta)
					beta = eval;
				if(beta <= alpha)
					break;
			}
			return minEval;
		}
	}
}
