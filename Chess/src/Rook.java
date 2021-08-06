public class Rook extends Piece {
	public Rook()
	{
		this("white");
	}
	public Rook(String color)
	{
		super(color,5);
		setValue(5);
	}
	public String getIcon()
	{
		if(getColor().equals("white"))
			return "R";
		else
			return "r";
	}
	public String getName()
	{
		return "rook";
	}
	public boolean moveIsValid(Square oldPos, Square newPos, Board board)
	{
		if(!(newPos.getPiece() instanceof None) && newPos.getPiece().getColor().equals(this.getColor()))
			return false;
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
