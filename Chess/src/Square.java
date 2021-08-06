public class Square {
	private Piece piece;
	private int row;
	private int col;
	private boolean hasMoved;
	public Square(int row, int col)
	{
		piece = new None();
		this.row = row;
		this.col = col;
		hasMoved = false;
	}
	public Square(int row, int col, Piece piece, String color, boolean hasMoved)
	{
		this.row = row;
		this.col = col;
		this.hasMoved = hasMoved;
		if(piece instanceof Rook)
			this.piece = new Rook(color);
		else if(piece instanceof Knight)
			this.piece = new Knight(color);
		else if(piece instanceof Bishop)
			this.piece = new Bishop(color);
		else if(piece instanceof Queen)
			this.piece = new Queen(color);
		else if(piece instanceof King)
			this.piece = new King(color);
		else if(piece instanceof Pawn)
			this.piece = new Pawn(color);
		else if(piece instanceof None)
			this.piece = new None();
	}
	
	public boolean isAttacked(Board board)
	{
		String oppColor = "white";
		if(getPiece().getColor().equals("white"))
			oppColor = "black";
		for(int i = 0; i < board.getSize(); i++)
		{
			for(int j = 0; j < board.getSize(); j++)
			{
				Board temp = new Board(board.getArr());
				if(temp.move(board.getSquare(i,j).convert(), convert(), oppColor))
					return true;
			}
		}
		return false;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	public void setPiece(Piece piece)
	{
		this.piece = piece;
		hasMoved = true;
	}
	public void initSetPiece(Piece piece)
	{
		this.piece = piece;
	}
	public void print()
	{
		System.out.print(getPiece().getIcon());
	}
	public String printPos()
	{
		return "[" + row + "," + col + "]";
	}
	public int getRow()
	{
		return row;
	}
	public int getCol()
	{
		return col;
	}
	public boolean getHasMoved()
	{
		return hasMoved;
	}
	public int[] convert()
	{
		int[] arr = {row,col};
		return arr;
	}
	public String getSide()
	{
		if(row > 3)
			return "white";
		else
			return "black";
	}
}
