import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException; 

import javax.imageio.ImageIO;

public class Visual extends JPanel {
	private static int squareSize = 85;
	private static int windowSize = squareSize*8;
	private static int addedHeight = 22;
	private static Board board;
	private static JFrame frame;

	
	public Visual(Board board)
	{
		this.board =  board;
	}
	public void drawBoard() //creates window
	{


		frame = new JFrame();
		frame.setSize(windowSize,windowSize+addedHeight);
		frame.getContentPane().add(new Visual(board));
		frame.getContentPane().addMouseListener(new ClickListener());
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) //draws graphics
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				Square s = board.getSquare(i, j);
				Piece piece = s.getPiece();
				String color = "";
				if(piece instanceof None)
					color = "none";
				else
					color = piece.getColor();
				BufferedImage img = getImage(piece.getName(),color,getTileColor(i,j));
				g.drawImage(img, j*squareSize, i*squareSize, squareSize, squareSize, this);
			}
		}
	}
	public void redrawBoard(Board board)
	{
		board = this.board;
		frame.repaint();
	}
	public BufferedImage getImage(String piece, String color, String tileColor) //retrieves specific images
	{
		BufferedImage img = null;
		String str = "Chess/" + "images/" + piece + "_" + color + "_" + tileColor + ".png";
		try
		{
			img = ImageIO.read(new File(str));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.print(str);
		}
		return img;
	}
	
	public String getTileColor(int row, int col)
	{
		if(col % 2 == 0)
		{
			if(row % 2 == 0)
				return "light";
			else
				return "dark";
		}
		else
		{
			if(row % 2 == 0)
				return "dark";
			else
				return "light";
		}
	}
	public static int getSquareSize()
	{
		return squareSize;
	}
}

