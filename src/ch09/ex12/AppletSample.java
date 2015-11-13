package ch09.ex12;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

// 断念

public class AppletSample extends Applet {
	public void paint(Graphics g) {
		g.setColor(Color.red);

		System.out.println("hogehoge");

		Dimension size = getSize();
		g.fillRect(0, 0, size.width - 1, size.height - 1);
	}
}
