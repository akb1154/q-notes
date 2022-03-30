import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JFrame;


public class _P extends JFrame{

	private int _z;

	public _P () throws IOException {
		File f = new File ("../../../../ignore/log_P.log");
		f.createNewFile();
		PrintStream ps = new PrintStream (f, "utf-8");
		System.setErr(ps);
		setSize(900, 900);
		setDefaultCloseOperation(3);
		setName("×-—·—-×");
		setVisible(true);
		_z = 0; 
	}

	@Override
	public void paint(Graphics g) {
		double _x=0, _y;
		System.err.printf("Color values:\n z |    x    |    y    \n———|—————————|—————————\n");
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				_z %= 256;
				_x = x * (256/getWidth()*0x100);
				_y = y * (256/getWidth());
				g.setColor(new Color (((_z%256)*0x10000)+(int)(_x+_y)%0x1000000));
				System.err.printf ("%2x | %3.4f | %3.4f \n", _z, _x, _y);
				g.drawLine(x, y, x, y);
			}
		}

		_z++;	
		try {
			Thread.sleep(125);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		_P __ = new _P(); 
	
		while (true) __.repaint();
	}
}