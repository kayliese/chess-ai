public class Board {
	private Square[][] board;
	public Board() //initializes board
	{
		board = new Square[8][8];
		board[0][0] = new Square(0,0);
		board[0][1] = new Square(0,1);
		board[0][2] = new Square(0,2);
		board[0][3] = new Square(0,3);
		board[0][4] = new Square(0,4);
		board[0][5] = new Square(0,5);
		board[0][6] = new Square(0,6);
		board[0][7] = new Square(0,7);
		
		board[1][0] = new Square(1,0);
		board[1][1] = new Square(1,1);
		board[1][2] = new Square(1,2);
		board[1][3] = new Square(1,3);
		board[1][4] = new Square(1,4);
		board[1][5] = new Square(1,5);
		board[1][6] = new Square(1,6);
		board[1][7] = new Square(1,7);
		
		board[2][0] = new Square(2,0);
		board[2][1] = new Square(2,1);
		board[2][2] = new Square(2,2);
		board[2][3] = new Square(2,3);
		board[2][4] = new Square(2,4);
		board[2][5] = new Square(2,5);
		board[2][6] = new Square(2,6);
		board[2][7] = new Square(2,7);
		
		board[3][0] = new Square(3,0);
		board[3][1] = new Square(3,1);
		board[3][2] = new Square(3,2);
		board[3][3] = new Square(3,3);
		board[3][4] = new Square(3,4);
		board[3][5] = new Square(3,5);
		board[3][6] = new Square(3,6);
		board[3][7] = new Square(3,7);
		
		board[4][0] = new Square(4,0);
		board[4][1] = new Square(4,1);
		board[4][2] = new Square(4,2);
		board[4][3] = new Square(4,3);
		board[4][4] = new Square(4,4);
		board[4][5] = new Square(4,5);
		board[4][6] = new Square(4,6);
		board[4][7] = new Square(4,7);
		
		board[5][0] = new Square(5,0);
		board[5][1] = new Square(5,1);
		board[5][2] = new Square(5,2);
		board[5][3] = new Square(5,3);
		board[5][4] = new Square(5,4);
		board[5][5] = new Square(5,5);
		board[5][6] = new Square(5,6);
		board[5][7] = new Square(5,7);
		
		board[6][0] = new Square(6,0);
		board[6][1] = new Square(6,1);
		board[6][2] = new Square(6,2);
		board[6][3] = new Square(6,3);
		board[6][4] = new Square(6,4);
		board[6][5] = new Square(6,5);
		board[6][6] = new Square(6,6);
		board[6][7] = new Square(6,7);
		
		board[7][0] = new Square(7,0);
		board[7][1] = new Square(7,1);
		board[7][2] = new Square(7,2);
		board[7][3] = new Square(7,3);
		board[7][4] = new Square(7,4);
		board[7][5] = new Square(7,5);
		board[7][6] = new Square(7,6);
		board[7][7] = new Square(7,7);
		
		placePieces();
	}
	public Board(Square[][] b)
	{
		board = new Square[8][8];
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				board[i][j] = new Square(i,j,b[i][j].getPiece(),b[i][j].getPiece().getColor(),b[i][j].getHasMoved());
			}
		}
	}
	public Board(Board b)
	{
		this(b.getArr());
	}
	public void placePieces() //places pieces for the start of the game
	{
		board[0][0].initSetPiece(new Rook("black"));
		board[0][1].initSetPiece(new Knight("black"));
		board[0][2].initSetPiece(new Bishop("black"));
		board[0][3].initSetPiece(new Queen("black"));
		board[0][4].initSetPiece(new King("black"));
		board[0][5].initSetPiece(new Bishop("black"));
		board[0][6].initSetPiece(new Knight("black"));
		board[0][7].initSetPiece(new Rook("black"));

		board[1][0].initSetPiece(new Pawn("black"));
		board[1][1].initSetPiece(new Pawn("black"));
		board[1][2].initSetPiece(new Pawn("black"));
		board[1][3].initSetPiece(new Pawn("black"));
		board[1][4].initSetPiece(new Pawn("black"));
		board[1][5].initSetPiece(new Pawn("black"));
		board[1][6].initSetPiece(new Pawn("black"));
		board[1][7].initSetPiece(new Pawn("black"));

		
		board[6][0].initSetPiece(new Pawn("white"));
		board[6][1].initSetPiece(new Pawn("white"));
		board[6][2].initSetPiece(new Pawn("white"));
		board[6][3].initSetPiece(new Pawn("white"));
		board[6][4].initSetPiece(new Pawn("white"));
		board[6][5].initSetPiece(new Pawn("white"));
		board[6][6].initSetPiece(new Pawn("white"));
		board[6][7].initSetPiece(new Pawn("white"));

		board[7][0].initSetPiece(new Rook("white"));
		board[7][1].initSetPiece(new Knight("white"));
		board[7][2].initSetPiece(new Bishop("white"));
		board[7][3].initSetPiece(new Queen("white"));
		board[7][4].initSetPiece(new King("white"));
		board[7][5].initSetPiece(new Bishop("white"));
		board[7][6].initSetPiece(new Knight("white"));
		board[7][7].initSetPiece(new Rook("white"));
	}
	public void printBoard() //prints board in console
	{
		int x = 0;
		System.out.println("  0 1 2 3 4 5 6 7");
		for(Square[] i: board)
		{
			System.out.print(x + " ");
			for(Square j: i)
			{
				j.print();
				System.out.print(" ");
			}
			System.out.println("");
			x++;
		}
	}
	public boolean move(int[] oldCord, int[] newCord, String color) //moves piece from oldCord to newCord, if valid. Returns true if successful
	{
		Square oldPos = board[oldCord[0]][oldCord[1]];
		Square newPos = board[newCord[0]][newCord[1]];
		Piece piece = oldPos.getPiece();
		if(!piece.getColor().equals(color) && !(piece instanceof None))
			return false;
		//castling
		if(piece instanceof King && !inCheck(color) && !oldPos.getHasMoved() && oldPos.getCol() == 4 && Math.abs(newPos.getCol()-4) == 2 && (oldPos.getRow() == 0 || oldPos.getRow() == 7))
		{
			int backRow = -1;
			if(color.equals("black"))
				backRow = 0;
			else
				backRow = 7;
			Board temp2 = new Board(board);
			if(newPos.getCol() == 6 && getSquare(backRow,7).getPiece() instanceof Rook && !getSquare(backRow,7).getHasMoved())
			{
				int[] n = {backRow,5};
				if(temp2.move(oldCord, n, color))
				{
					if(temp2.move(n, newCord, color))
					{
						newPos.setPiece(new King(color));
						oldPos.setPiece(new None());
						getRight(oldPos).setPiece(new Rook(color));
						getSquare(backRow,7).setPiece(new None());
						return true;
					}
				}
			}
			else if(newPos.getCol() == 2 && getSquare(backRow, 0).getPiece() instanceof Rook && !getSquare(backRow,0).getHasMoved())
			{
				int[] u = {backRow,3};
				int[] rookPos = {backRow,0};
				int[] x = {backRow,1};
				if(temp2.move(oldCord, u, color))
				{
					if(temp2.move(u, newCord, color))
					{
						if(temp2.move(rookPos, x, color))
						{
							newPos.setPiece(new King(color));
							oldPos.setPiece(new None());
							getLeft(oldPos).setPiece(new Rook(color));
							getSquare(backRow,0).setPiece(new None());
							return true;
						}
					}
				}
			}
		}
		if(piece.moveIsValid(oldPos,newPos,this) && !piece.sameTeam(newPos))
		{
			//promotion
			if(piece instanceof Pawn && piece.getColor().equals("white") && newPos.getRow()==0)
			{
				newPos.setPiece(new Queen("white"));
				oldPos.setPiece(new None());
				return true;
			}
			else if(piece instanceof Pawn && piece.getColor().equals("black") && newPos.getRow()==7)
			{
				newPos.setPiece(new Queen("black"));
				oldPos.setPiece(new None());
				return true;
			}
			//makes the move
			else
			{
				Board temp = new Board(board);
				temp.getSquare(newPos.getRow(), newPos.getCol()).setPiece(piece);
				temp.getSquare(oldPos.getRow(), oldPos.getCol()).setPiece(new None());
				if(!temp.inCheck(color))
				{
					newPos.setPiece(piece);
					oldPos.setPiece(new None());
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public boolean inCheck(String color) //checks if color is in check
	{
		String oppColor = "white";
		if(color.equals("white"))
			oppColor = "black";
		Square kingPos = getKingPos(color);
		Square[] controlledSquares = getAllControlledSquares(oppColor);
		
		for(Square i: controlledSquares)
		{
			if(i.getRow() == kingPos.getRow() && i.getCol() == kingPos.getCol())
				return true;
		}
		return false;
	}
	
	public boolean checkMate(String color) //checks if color is in checkmate
	{
		Square[][] validMoves = getAllLegalMoves(color);
		return validMoves.length == 0;
	}
	
	public Square[][] getAllLegalMoves(String color) //returns 2d array -> {{oldPos,newPos},{oldPos,newPos},...}
	{
		ArrayList<Square[]> allLegalMoves = new ArrayList<Square[]>();
		for(int i = 0; i < getSize(); i++)
		{
			for(int j = 0; j < getSize(); j++)
			{
				if(!getSquare(i, j).getPiece().getColor().equals(color))
					continue;
				Square[] legalMoves = getLegalMoves(getSquare(i,j));
				for(int k = 0; k < legalMoves.length; k++)
				{
					Square[] arr = {getSquare(i, j),legalMoves[k]};
					allLegalMoves.add(arr);
				}
			}
		}
		Square[][] arr = new Square[allLegalMoves.size()][2];
		arr = (Square[][]) allLegalMoves.toArray(arr);
		return arr;
	}
	
	public Square[] getLegalMoves(Square oldPos) //returns all legal moves that oldPos has
	{
		ArrayList<Square> legalMoves = new ArrayList<Square>();
		int[] newCord = new int[2];
		for(int i = 0; i < getSize(); i++)
		{
			for(int j = 0; j < getSize(); j++)
			{
				newCord[0] = i;
				newCord[1] = j;
				Board temp = new Board(board);
				if(temp.move(oldPos.convert(), newCord, oldPos.getPiece().getColor()))
					legalMoves.add(getSquare(i,j));
			}
		}
		Square[] arr = new Square[legalMoves.size()];
		arr = (Square[]) legalMoves.toArray(arr);
		return arr;
	}
	
	public Square[] getAllControlledSquares(String color) //returns all squares controlled by color (capturable squares by [color] pieces)
	{
		ArrayList<Square> list = new ArrayList<Square>();
		for(int i = 0; i < getSize(); i++)
		{
			for(int j = 0; j < getSize(); j++)
			{
				Square pos = getSquare(i,j);
				if(!pos.getPiece().getColor().equals(color) || pos.getPiece() instanceof None)
					continue;
				Square[] controlled = getControlledSquares(pos);
				for(Square c: controlled)
				{
					list.add(c);
				}
			}
		}
		Square[] arr = new Square[list.size()];
		arr = (Square[]) list.toArray(arr);
		return arr;
	}
	
	public Square[] getControlledSquares(Square pos) //returns squares which the piece on Square pos controls
	{
		ArrayList<Square> list = new ArrayList<Square>();
		Piece piece = pos.getPiece();
		for(int i = 0; i < getSize(); i++)
		{
			for(int j = 0; j < getSize(); j++)
			{
				if(piece.captureIsValid(pos, getSquare(i,j), this))
					list.add(getSquare(i,j));
			}
		}
		Square[] arr = new Square[list.size()];
		arr = (Square[]) list.toArray(arr);
		return arr;
	}
	public Square[] getSpace(String color) //returns the color's squares it controls on the opposite side of board
	{
		Square[] control = getAllControlledSquares(color);
		ArrayList<Square> list = new ArrayList<Square>();
		for(Square i: control)
		{
			if(!i.getSide().equals(color))
				list.add(i);
		}
		Square[] arr = new Square[list.size()];
		arr = (Square[]) list.toArray(arr);
		return arr;
	}
	
	
	///////// GETTERS / SETTERS ///////////
	

	public int getSize()
	{
		return board.length;
	}
	public Square getSquare(int row, int col)
	{
		return board[row][col];
	}
	public Square getAbove(Square pos)
	{
		if(pos.getRow() == 0)
			return new Square(-1,-1);
		return board[pos.getRow()-1][pos.getCol()];
	}
	public Square getBelow(Square pos)
	{
		if(pos.getRow() == getSize() - 1)
			return new Square(-1,-1);
		return board[pos.getRow()+1][pos.getCol()];
	}
	public Square getLeft(Square pos)
	{
		if(pos.getCol() == 0)
			return new Square(-1,-1);
		return board[pos.getRow()][pos.getCol()-1];
	}
	public Square getRight(Square pos)
	{
		if(pos.getCol() == getSize()-1)
			return new Square(-1,-1);
		return board[pos.getRow()][pos.getCol()+1];
	}
	
	public Square getUpperRight(Square pos)
	{
		if(pos.getRow() == 0 || pos.getCol() == getSize()-1)
			return new Square(-1,-1);
		return board[pos.getRow()-1][pos.getCol()+1];
	}
	public Square getUpperLeft(Square pos)
	{
		if(pos.getRow() == 0 || pos.getCol() == 0)
			return new Square(-1,-1);
		return board[pos.getRow()-1][pos.getCol()-1];
	}
	public Square getLowerRight(Square pos)
	{
		if(pos.getRow() == getSize()-1 || pos.getCol() == getSize()-1)
			return new Square(-1,-1);
		return board[pos.getRow()+1][pos.getCol()+1];
	}
	public Square getLowerLeft(Square pos)
	{
		if(pos.getRow() == getSize()-1 || pos.getCol() == 0)
			return new Square(-1,-1);
		return board[pos.getRow()+1][pos.getCol()-1];
	}
	
	public Square[] getSurrounding(Square pos)
	{
		Square[] s = new Square[8];
		s[0] = getAbove(pos);
		s[1] = getUpperRight(pos);
		s[2] = getRight(pos);
		s[3] = getLowerRight(pos);
		s[4] = getBelow(pos);
		s[5] = getLowerLeft(pos);
		s[6] = getLeft(pos);
		s[7] = getUpperLeft(pos);
		return s;
	}
	
	public Square getKingPos(String color)
	{
		for(int i = 0; i < getSize(); i++)
		{
			for(int j = 0; j < getSize(); j++)
			{
				if(getSquare(i,j).getPiece() instanceof King && getSquare(i,j).getPiece().getColor() == color)
					return getSquare(i,j);
			}
		}
		return new Square(-10,-10);
	}
	
	public Square[][] getArr()
	{
		return board;
	}
}
