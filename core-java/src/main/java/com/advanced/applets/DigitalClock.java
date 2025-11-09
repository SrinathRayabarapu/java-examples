/*
package com.advanced.applets;

import java.applet.Applet;
import java.awt.*;
import java.util.Date;

public class DigitalClock extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	Font f = new Font("TimesRoman", Font.BOLD, 24);
	Date d;
	Thread runner;

	public void init() {
		resize(330, 100);
	}

	public void paint(Graphics g) {
		g.setFont(f);
		g.drawString(d.toString(), 10, 50);
	}

	public void start() {
		while (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}

	public void run() {
		while (true) {
			d = new Date();
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			;
		}
	}
}*/
