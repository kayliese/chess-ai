public class Piece {
	private int value;
	private String color;
	public Piece()
	{
		this("white",0);
	}
	public Piece(String color, int value) //initializes piece
	{
		this.value = value;
		this.color = color;
	}
	public int getValue()
	{
		return value;
	}
	public void setValue(int j)
	{
		value = j;
	}
	public String getIcon()
	{
		return "N";
	}
	public String getColor()
	{
		return color;
	}
	
	public boolean moveIsValid(Square oldPos, Square newPos, Board board) //returns whether move is legal or not
	{
		System.out.println("called parent");
		return false;
	}
	
	public boolean captureIsValid(Square oldPos, Square newPos, Board board) //returns whether the piece at newPos could capture another piece at newPos
	{
		return moveIsValid(oldPos, newPos, board);
	}
	public boolean sameTeam(Square newPos) //returns true if the newPos has a piece of the same color
	{
		if(!(newPos.getPiece() instanceof None))
		{
			if(newPos.getPiece().getColor().equals(getColor()))
				return true;
		}
		return false;
	}
	public String getName()
	{
		return "parent";
	}
}
