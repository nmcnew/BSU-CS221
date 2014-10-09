package polypainter;

import java.awt.Graphics;

public class OvalThing extends PaintableThing {

	public OvalThing(int anchorX, int anchorY, int width, int height) {
		super(anchorX, anchorY, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(baseColor);
		g.drawOval(x, y, w, h);

	}

}
