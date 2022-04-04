package com.github.pocketkid2.collisionsimulator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball {

	public enum PhysicsState {
		// The ball is being rendered on the screen but has not been placed yet
		UNPLACED,
		// The ball is being controlled completely by the physics engine
		FREE,
		// The ball is being controlled by the mouse
		MOUSE_CONTROL;
	}

	// Position
	private double x, y;
	// Velocity
	private double v_x, v_y;

	// Density
	private double d;
	// Radius
	private double r;

	// Color
	private Color c;
	// Physics State
	private PhysicsState s;

	public Ball(double x0, double y0, double density, double radius, Color color) {
		x = x0;
		y = y0;
		d = density;
		r = radius;
		c = color;
		s = PhysicsState.UNPLACED;
	}

	public void draw(Graphics2D g) {
		Ellipse2D e = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g.setColor(c);
		g.fill(e);
	}

	public double getMass() {
		// Area times density
		return Math.PI * r * r * d;
	}

	public void move() {
		x += v_x;
		y += v_y;
	}

	public boolean collidesWithBall(Ball b) {
		double dist = Math.sqrt(Math.pow(x - b.x, 2) + Math.pow(y - b.y, 2));
		return dist <= r + b.r;
	}

}
