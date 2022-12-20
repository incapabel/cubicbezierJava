package bezierSpline;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class CubicBezier extends JComponent {
	private int x = 10;
	private int y = 10;
	
	private int point1x;
	private int point1y;
	
	private int point2x;
	private int point2y;
	
	private int point3x;
	private int point3y;
	
	private int point4x;
	private int point4y;
	
	private int size = 10;
	
	private boolean curve = true;
	
	public void setPointOne(int x, int y) {
		point1x = x;
		point1y = y;
	}
	
	public void setPointTwo(int x, int y) {
		point2x = x;
		point2y = y;
	}
	
	public void setPointThree(int x, int y) {
		point3x = x;
		point3y = y;
	}
	
	public void setPointFour(int x, int y) {
		point4x = x;
		point4y = y;
	}
    
	@Override
    public void paint(Graphics g) {
		g.setColor(Color.red);
        g.fillRoundRect(x, y, size, size, 25, 25);
		g.setColor(Color.black);
    	g.fillRoundRect(point1x, point1y, size, size, 25, 25);
    	g.fillRoundRect(point2x, point2y, size, size, 25, 25);
    	g.fillRoundRect(point3x, point3y, size, size, 25, 25);
    	g.fillRoundRect(point4x, point4y, size, size, 52, 25);
    }
    
    public void createCurve() {
    	curve = true;
    }
    
    public void setCurve(JSlider slider) {
    	slider.addChangeListener(e -> {
        	calculate(((double) slider.getValue()) / 100);
    	});
    }
    
    private void calculate(double t) {
    	if(!curve) {
    		return;
    	}
    	
    	// P(t) = P1 * (1 - t)^3 + 3 * P2 * (1 - t)^2 * t + 3 * P3 * (1 - t) * t^2 + P4 * t^3
    	double minT = 1 - t;
    	double _x = point1x * Math.pow(minT, 3) + 3 * point2x * Math.pow(minT, 2) * t + 3 * point3x * minT * Math.pow(t, 2) + point4x * Math.pow(t, 3);
    	double _y = point1y * Math.pow(minT, 3) + 3 * point2y * Math.pow(minT, 2) * t + 3 * point3y * minT * Math.pow(t, 2) + point4y * Math.pow(t, 3);
    	
    	x = (int) _x;
    	y = (int) _y;
    	
    	repaint();
    }
}



