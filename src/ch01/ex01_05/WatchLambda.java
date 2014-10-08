package ch01.ex01_05;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class WatchLambda extends Frame {

	private static final int FRAME_WIDTH = 80;
	private static final int FRAME_HEIGHT = 80;
	private static final int FRAME_LOCATION_X = 200;
	private static final int FRAME_LOCATION_Y = 200;
	private static final int WATCH_LOCATION_X = 50;
	private static final int WATCH_LOCATION_Y = 50;

	public void paint(Graphics g) {
		Calendar now = Calendar.getInstance();
		int h = now.get(Calendar.HOUR_OF_DAY);
		int m = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);
		g.drawString(h + ":" + m + ":" + s, WATCH_LOCATION_X, WATCH_LOCATION_Y);
	}

	public static void main(String[] args) {
		WatchLambda watch = new WatchLambda();
		watch.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		watch.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);

		watch.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		new Thread(() -> {
			watch.repaint();
			try {
				Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
			}).start();

		watch.setVisible(true);
	}

}