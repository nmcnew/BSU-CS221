package polypainter;

import java.awt.Graphics;

public class LineThing extends PaintableThing {

	public LineThing(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
		// TODO Auto-generated constructor stub
		
		
	}

	/* (non-Javadoc)
	 * @see polypainter.PaintableThing#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(baseColor);
		g.drawLine(x, y, w, h);
	}

}
