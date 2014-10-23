package ch01.ex01_05;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class Watch extends Frame {

	private static final int FRAME_WIDTH = 150;
	private static final int FRAME_HEIGHT = 100;
	private static final int FRAME_LOCATION_X = 200;
	private static final int FRAME_LOCATION_Y = 200;
	private static final int WATCH_LOCATION_X = 50;
	private static final int WATCH_LOCATION_Y = 80;

	public void paint(Graphics g) {
		Calendar now = Calendar.getInstance();
		int h = now.get(Calendar.HOUR_OF_DAY);
		int m = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);
		g.drawString(h + ":" + m + ":" + s, WATCH_LOCATION_X, WATCH_LOCATION_Y);
	}

	public static void main(String[] args) {
		Watch watch = new Watch();
		watch.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		watch.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		watch.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		MenuBar mb = new MenuBar();
		watch.setMenuBar(mb);
		Menu propertyMenu = mb.add(new Menu("property", true));
		propertyMenu.add("閉じる");
		propertyMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					watch.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		watch.setVisible(true);
	}

}