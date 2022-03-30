import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;


public class _P extends JFrame{

	private int z;

	public _P () {
		setSize(900, 900);
		setDefaultCloseOperation(3);
		setName("×-—·—-×");
		z = 0; 
	}

	@Override
	public void paint(Graphics g) {
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				g.setColor(new Color (((z%256)*0x10000)+((x%256)*0x100)+((y%256))));
				g.drawLine(x, y, x, y);
			}
		}

		z++;	
		try {
			Thread.sleep(125);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		_P __ = new _P(); 
	
		while (true) __.repaint();
	}
}