import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter {
	private static int x1 = -1;
	private static int y1 = -1;
	private static int x2 = -1;
	private static int y2 = -1;
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("clicked");
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + ", " + y);
		if(x1 == -1 && y1 == -1)
		{
			x1 = x;
			y1 = y;
		}
		else if(x2 == -1 && y2 == -1)
		{
			x2 = x;
			y2 = y;
		}
	}
	public static int[][] getInput() //waits for 2 clicks in row, returns the positions of the clicks
	{
		while(y2 == -1)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}
		}
		int[][] arr = {{y1/Visual.getSquareSize(),x1/Visual.getSquareSize()},{y2/Visual.getSquareSize(),x2/Visual.getSquareSize()}};
		x1 = -1;
		y1 = -1;
		x2 = -1;
		y2 = -1;
		return arr;
	}
}
