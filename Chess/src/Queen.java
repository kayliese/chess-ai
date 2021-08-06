public class Queen extends Piece {
	public Queen()
	{
		this("white");
	}
	public Queen(String color)
	{
		super(color,9);
	}
	public String getIcon()
	{
		if(getColor().equals("white"))
			return "Q";
		else
			return "q";
	}
	public String getName()
	{
		return "queen";
	}
	public boolean moveIsValid(Square oldPos, Square newPos, Board board)
	{
		if(!(newPos.getPiece() instanceof None) && newPos.getPiece().getColor().equals(this.getColor()))
			return false;
		if(Math.abs(oldPos.getRow() - newPos.getRow()) == Math.abs(oldPos.getCol() - newPos.getCol()))
		{
			int j = 0;
			int k = 0;
			//bishop movement 
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
		//rook movement 
		else
		{
			if(oldPos.getRow() == newPos.getRow()) //moving sideways
			{
				if(oldPos.getCol() > newPos.getCol()) //moving left
				{
					for(int i = oldPos.getCol()-1; i > newPos.getCol(); i--)
					{
						Piece piece = board.getSquare(oldPos.getRow(),i).getPiece();
						if(!(piece instanceof None))
							return false;
					}
					return true;
				}
				else //moving right
				{
					
					for(int i = oldPos.getCol()+1; i < newPos.getCol(); i++)
					{
						Piece piece = board.getSquare(oldPos.getRow(),i).getPiece();
						if(!(piece instanceof None))
							return false;
					}
					return true;
				}
			}
			else if(oldPos.getCol() == newPos.getCol()) //moving vertical
			{
				
				if(oldPos.getRow() < newPos.getRow()) //moving down
				{
					for(int i = oldPos.getRow()+1; i < newPos.getRow(); i++)
					{
						Piece piece = board.getSquare(i,oldPos.getCol()).getPiece();
						if(!(piece instanceof None))
							return false;
					}
					return true;
				}
				else //moving up
				{
					for(int i = oldPos.getRow()-1; i > newPos.getRow(); i--)
					{
						Piece piece = board.getSquare(i,oldPos.getCol()).getPiece();
						if(!(piece instanceof None))
							return false;
					}
					return true;
				}
			}
			else
				return false;
		}
	}
}
