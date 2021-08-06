// Empty square 
public class None extends Piece {
	public None()
	{
		
	}
	public String getIcon()
	{
		return "-";
	}
	public boolean moveIsValid(Square oldPos, Square newPos, Board board)
	{
		return false;
	}
	public String getName()
	{
		return "none";
	}
}
