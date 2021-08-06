//parent class for bot
public class Bot {
	private String color;
	public Bot(String color)
	{
		this.color = color;
	}
	
	public int scoreBoard(Board board) //returns positive if black is winning, negative if losing
	{
		if(board.checkMate("white"))
		{
			System.out.println("scoreBoard returning 1000 on board:");
			board.printBoard();
			return 1000;
		}
		else if(board.checkMate("black"))
		{
			System.out.println("scoreBoard returning -1000 on board:");
			board.printBoard();
			return -1000;
		}
		int whiteSum = 0;
		int blackSum = 0;
		for(int i = 0; i < board.getSize(); i++)
		{
			for(int j = 0; j < board.getSize(); j++)
			{
				if(!(board.getSquare(i, j).getPiece() instanceof None))
				{
					if(board.getSquare(i, j).getPiece().getColor().equals("white"))
						whiteSum += board.getSquare(i, j).getPiece().getValue();
					else if(board.getSquare(i, j).getPiece().getColor().equals("black"))
						blackSum += board.getSquare(i, j).getPiece().getValue();
				}
			}
		}
		return blackSum - whiteSum;
	}
	
	public int[] controlScore(Board board) //returns {total squares controlled, opposing squares controlled}
	{
		int sum = 0;
		int space = 0;
		for(int i = 0; i < board.getSize(); i++)
		{
			for(int j = 0; j < board.getSize(); j++)
			{
				if(!(board.getSquare(i,j).getPiece() instanceof None))
				{
					Square[] moves = board.getLegalMoves(board.getSquare(i, j));
					if(board.getSquare(i,j).getPiece().getColor().equals(color))
					{
						sum += moves.length;
						for(Square k: moves)
						{
							if(!k.getSide().equals(color))
								space++;
						}
					}
				}
			}
		}
		int[] arr = {sum,space};
		return arr;
	}
	
	public Square[][] sort(Square[][] moves, Board board) //returns possible moves ordered from most likely to least likely
	{
		int[] prio = new int[moves.length];
		for(int j = 0; j < moves.length; j++)
		{
			Square i = moves[j][0];
			if(i.isAttacked(board))
			{
				if(i.getPiece() instanceof Pawn)
					prio[j] = 4;
				else
					prio[j] = 5;
			}
			else
			{
				if(i.getPiece() instanceof Pawn)
					prio[j] = 2;
				else
					prio[j] = 3;
			}
		}
		for(int i = 0; i < prio.length-1; i++)
		{
			int max_idx = i;
			for(int j = i+1; j < prio.length; j++)
			{
				if(prio[j] > prio[max_idx])
					max_idx = j;
				else if(prio[j] == prio[max_idx])
					if(color.equals("black") && moves[j][0].getRow() > moves[max_idx][0].getRow())
						max_idx = j;
					else if(color.equals("white") && moves[j][0].getRow() < moves[max_idx][0].getRow())
						max_idx = j;
			}
			int temp1 = prio[max_idx];
			prio[max_idx] = prio[i];
			prio[i] = temp1;
			Square[] temp2 = moves[max_idx];
			moves[max_idx] = moves[i];
			moves[i] = temp2;
		}
		System.out.println("ordered moves: ");
		for(int i = 0; i < moves.length; i++)
		{
			System.out.println(i + ": " + moves[i][0].getPiece().getIcon() + moves[i][0].printPos() + "->" + moves[i][1].printPos());
		}
		return moves;
	}
	public String getColor()
	{
		return color;
	}
	public int[][] getMove(Board board)
	{
		return null;
	}
}
