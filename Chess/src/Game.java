import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

//controls the main game logic
public class Game {
	// main menu
	private static Board board;
	public static void main(String [] args) throws IOException, ClassNotFoundException
	{

		board = new Board();
		board.printBoard();
		Visual v = new Visual(board);
		v.drawBoard();
		Bot pruneBot = new PruneBot("black");

		while(!board.checkMate("white") && !board.checkMate("black"))
		{
			Square[] controlled = board.getAllControlledSquares("white");
			for(Square i: controlled)
				System.out.println(i.printPos());
			if(!board.checkMate("white")) // White's turn 
			{
				if(board.inCheck("white"))
					System.out.println("White is in check.");
				turn("white");
			}
			else
				System.out.println("Game over. " + "Black" + " wins.");
			board.printBoard();
			v.redrawBoard(board);
			if(!board.checkMate("black")) //Black's turn
			{
				if(board.inCheck("black"))
					System.out.println("Black is in check.");
				long startTime = System.currentTimeMillis();
				botTurn(pruneBot);
				long endTime = System.currentTimeMillis();
				System.out.println("bot move took " + (endTime - startTime)/1000 + " seconds");
			}
			else
				System.out.println("Game over. " + "White" + " wins.");
			board.printBoard();
			v.redrawBoard(board);
		}
	}
	
	public static boolean gameOver(Board board, String color)
	{
		if(board.checkMate(color))
			return true;
		return false;
	}
	public static void turn(String color)
	{
		System.out.println(color + "'s turn.");
		int[][] move = ClickListener.getInput();
		int[] oldCord = move[0];
		int[] newCord = move[1];
		boolean success = board.move(oldCord,newCord,color);
		if(!success)
		{
			System.out.println("Invalid move.");
			turn(color);
		}
	}
	public static void botTurn(Bot bot)
	{
		System.out.println(bot.getColor() + "'s turn. [bot]");
		int[][] move = bot.getMove(board);
		int[] oldCord = move[0];
		int[] newCord = move[1];
		boolean success = board.move(oldCord,newCord,bot.getColor());
		if(!success)
		{
			System.out.println("Invalid move.");
			botTurn(bot);
		}
	}
}
