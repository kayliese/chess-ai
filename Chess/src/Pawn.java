public class Pawn extends Piece {
	public Pawn()
	{
		this("white");
	}
	public Pawn(String color)
	{
		super(color,1);
	}
	public String getIcon()
	{
		if(getColor().equals("white"))
			return "P";
		else
			return "p";
	}
	public String getName()
	{
		return "pawn";
	}
	
	public boolean moveIsValid(Square oldPos, Square newPos, Board board)
	{
		if(getColor().equals("white") && newPos.getRow() > oldPos.getRow())
			return false;
		if(getColor().equals("black") && newPos.getRow() < oldPos.getRow())
			return false;
		if(newPos.getPiece() instanceof None && newPos.getCol() == oldPos.getCol())
		{
			if(!oldPos.getHasMoved() && Math.abs(newPos.getRow() - oldPos.getRow()) == 2)
				if(getColor().equals("white") && board.getBelow(newPos).getPiece() instanceof None)
					return true;
				else if(getColor().equals("black") && board.getAbove(newPos).getPiece() instanceof None)
					return true;
			if(Math.abs(newPos.getRow() - oldPos.getRow()) == 1)
				return true;
			return false;
		}
		else if(!(newPos.getPiece() instanceof None) && !newPos.getPiece().getColor().equals(getColor()))
			return Math.abs(oldPos.getRow() - newPos.getRow()) == 1 && Math.abs(oldPos.getCol() - newPos.getCol()) == 1;
		return false;
	}
	public boolean captureIsValid(Square oldPos, Square newPos, Board board)
	{
		if(getColor().equals("white") && newPos.getRow() > oldPos.getRow())
			return false;
		if(getColor().equals("black") && newPos.getRow() < oldPos.getRow())
			return false;
		return Math.abs(oldPos.getRow() - newPos.getRow()) == 1 && Math.abs(oldPos.getCol() - newPos.getCol()) == 1;
	}
}
