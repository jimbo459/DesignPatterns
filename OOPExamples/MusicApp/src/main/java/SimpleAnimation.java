import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {

	int x = 70;
	int y = 70;

	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel2 drawPanel = new MyDrawPanel2();

		frame.getContentPane().add(drawPanel);
		frame.setSize(450, 450);
		frame.setVisible(true);

		for (int i = 0; i < 180; i++) {
			x++;
			y++;

			drawPanel.repaint();

			try {
				Thread.sleep(50);
			} catch (Exception ex) {
			}
		}
	}

		class MyDrawPanel2 extends JPanel {
			public void paintComponent(Graphics g) {
				g.setColor(Color.BLACK);
				g.fillRect(0,0, this.getWidth(), this.getHeight());

				g.setColor(Color.green);
				g.fillOval(x,y,40,40);
			}
		}

}
