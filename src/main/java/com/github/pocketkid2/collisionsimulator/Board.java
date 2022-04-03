package com.github.pocketkid2.collisionsimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Board extends JPanel {

	private Timer timer;

	private List<Ball> balls;

	public Board() {
		setBackground(Color.WHITE);
		balls = new ArrayList<Ball>();
		balls.add(new Ball(640, 360, 1.0D, 20.0D, Color.BLACK));
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 100, 5);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBalls(g);
	}

	private void drawBalls(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);

		for (Ball b : balls) {
			b.draw(g2d);
		}
	}

	private void tick() {
		// TODO Auto-generated method stub

	}

	public class ScheduleTask extends TimerTask {

		@Override
		public void run() {
			tick();
			repaint();
		}

	}

}
