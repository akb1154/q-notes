
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class nall {

	private JFrame frame;

	public static void main (String[] args) {
		new nall();
	}

	public nall() {
		frame = new JFrame();
		JPanel p = new JPanel() {
			@Override
			public void paint (Graphics g) {
				int RGB = (int) (System.currentTimeMillis()%0x1000000);
				int tRGB = 0;
				for (int x=0; x < this.getWidth(); x++) {
					for (int y=0; y < this.getHeight(); x++) {
						tRGB = (int)(0-Math.abs(Math.sin(x+x*y)*RGB));
						g.setColor(new Color ((tRGB%0x1000000)));
						g.drawLine(x, y, x, y);
						System.err.printf("0x%x, ", (tRGB%0x1000000));
					}
					System.err.printf("0x0A\n");
				}
			}
		};
		frame.setSize(300, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.add(p);
	}

}