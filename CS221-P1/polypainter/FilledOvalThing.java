package polypainter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Random;

public class FilledOvalThing extends OvalThing {

	private Color fillColor;
	public FilledOvalThing(int anchorX, int anchorY, int width, int height) {
		super(anchorX, anchorY, width, height);
		Random rand = new Random();
		this.fillColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Stroke prev = g2d.getStroke();
		g2d.setStroke(new BasicStroke(25));
		g2d.drawOval(x, y, w, h);
		g2d.fillOval(x, y, w, h);
		
	}
}
