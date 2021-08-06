public class Knight extends Piece {
	public Knight()
	{
		this("white");
	}
	public Knight(String color)
	{
		super(color,3);
	}
	public boolean moveIsValid(Square oldPos, Square newPos, Board board)
	{
		if(!(newPos.getPiece() instanceof None) && newPos.getPiece().getColor().equals(getColor()))
			return false;
		if(Math.abs(newPos.getRow() - oldPos.getRow()) == 2) //moving up 2
			return Math.abs(newPos.getCol() - oldPos.getCol()) == 1;
		else if(Math.abs(newPos.getRow() - oldPos.getRow()) == 1) //moving up 1
			return Math.abs(newPos.getCol() - oldPos.getCol()) == 2;
		else
			return false;
	}
	public String getIcon()
	{
		if(getColor().equals("white"))
			return "N";
		else
			return "n";
	}
	public String getName()
	{
		return "knight";
	}
}
