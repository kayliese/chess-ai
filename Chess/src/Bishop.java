public class Bishop extends Piece {
	public Bishop()
	{
		this("white");
	}
	public Bishop(String color)
	{
		super(color,3);
	}
	public String getIcon()
	{
		if(getColor().equals("white"))
			return "B";
		else
			return "b";
	}
	public String getName()
	{
		return "bishop";
	}
	public boolean moveIsValid(Square oldPos, Square newPos, Board board)
	{
		int j = 0;
		int k = 0;
		if(!(newPos.getPiece() instanceof None) && newPos.getPiece().getColor().equals(this.getColor()))
			return false;
		if(Math.abs(oldPos.getRow() - newPos.getRow()) == Math.abs(oldPos.getCol() - newPos.getCol()))
		{
			if(newPos.getRow() < oldPos.getRow()) //moving upwards
			{
				if(newPos.getCol() < oldPos.getCol()) //moving upper left
					k = -1;
				else //moving upper right
					k = 1;
				j = oldPos.getCol() + k;
				for(int i = oldPos.getRow()-1; i > newPos.getRow(); i--)
				{
					if(!(board.getSquare(i, j).getPiece() instanceof None))
						return false;
					j = j + k;
				}
				return true;
			}
			else //moving downwards
			{
				if(newPos.getCol() < oldPos.getCol()) //moving lower left
					k = -1;
				else //moving lower right
					k = 1;
				j = oldPos.getCol() + k;
				for(int i = oldPos.getRow()+1; i < newPos.getRow(); i++)
				{
					if(!(board.getSquare(i, j).getPiece() instanceof None))
						return false;
					j = j + k;
				}
			}
			return true;
		}
		return false;
	}
}
