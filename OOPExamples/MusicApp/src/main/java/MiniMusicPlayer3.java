import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {

	static JFrame frame = new JFrame("My First Music Video");
	static MyDrawPanel drawPanel;

	public static void main(String[] args) {
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}

	public void setUpGui() {
		drawPanel = new MyDrawPanel();
		frame.setContentPane(drawPanel);
		frame.setBounds(30,30,300,300);
		frame.setVisible(true);
	}

	public void go() {
		setUpGui();

		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(drawPanel, new int[] {127});
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			int noteValue = 0;
			int instrument = 110;

			for (int i = 45; i<240;i+=4) {

				noteValue = i;
				track.add(makeEvent(144,1,noteValue,instrument,i));
				track.add(makeEvent(176,1,127,0,i));
				track.add(makeEvent(128,1,noteValue,instrument,i+2));
			}

			sequencer.setSequence(seq);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception ex) {ex.printStackTrace();}
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		} catch (Exception e) {}

		return event;
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener {
		boolean msg = false;

		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			if (msg) {

				int red = (int)(Math.random() * 250);
				int green = (int)(Math.random() * 250);
				int blue = (int)(Math.random() * 250);

				g.setColor(new Color(red,green,blue));

				int height = (int)((Math.random() * 120) + 10);
				int width = (int)((Math.random() * 120) + 10);

				int x = (int)((Math.random() * 40) + 10);
				int y = (int)((Math.random() * 40) + 10);

				g.fillRect(x,y,width,height);
				msg = false;
			}

		}

	}




}
