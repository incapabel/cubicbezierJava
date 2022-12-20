package bezierSpline;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Main {
	public static void main(String[] args) {
		CubicBezier cubicBezier = new CubicBezier();
		
		cubicBezier.setPointOne(10, 10);
		cubicBezier.setPointTwo(110, 400);
		cubicBezier.setPointThree(310, 400);
		cubicBezier.setPointFour(410, 10);
		
		JFrame window = new JFrame();
		window.setLayout(new BorderLayout());
		JPanel sliderPanel = new JPanel();
		JSlider progress = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		sliderPanel.add(progress);
		
		progress.setMajorTickSpacing(20);
		progress.setPaintTicks(true);
		progress.setPaintLabels(true);
		
		cubicBezier.setCurve(progress);
		  
        // setting closing operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // setting size of the pop window
        window.setBounds(20, 20, 700, 700);
		
		cubicBezier.setSize(500, 500);
  
        // setting canvas for draw
        window.getContentPane().add(cubicBezier, BorderLayout.CENTER);
        window.getContentPane().add(sliderPanel, BorderLayout.NORTH);
  
        // set visibility
        window.setVisible(true);
	}
}
