package tp2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Draw extends JFrame {
	Point[] pointList;
	public Draw(Polygon p) {
		pointList = p.getPointList();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		JPanel panel;
		add(panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
				
				g2.setColor(Color.BLACK);
				for(int i = 0; i < pointList.length; i++){
					g2.drawLine((int)pointList[i].getX(),(int) pointList[i].getY(), (int)pointList[(i+1)%pointList.length].getX(), (int) pointList[(i+1)%pointList.length].getY());
				}
			}
		});
		pack();
		setVisible(true);
	}

}
