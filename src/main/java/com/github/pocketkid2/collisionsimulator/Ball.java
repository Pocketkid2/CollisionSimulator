package com.github.pocketkid2.collisionsimulator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ball {

	public static final double MIN_RADIUS = 5.0D;
	public static final double MAX_RADIUS = 120.0D;
	private static final double DEFAULT_RADIUS = 30.0D;

	private static final double DEFAULT_DENSITY = 1.0D;
	private static final Color DEFAULT_COLOR = getColorForRadius(DEFAULT_RADIUS);

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

	// Physics State
	private PhysicsState s;

	public Ball(double x0, double y0) {
		this(x0, y0, DEFAULT_DENSITY, DEFAULT_RADIUS, DEFAULT_COLOR);
	}

	public Ball(double x0, double y0, double density, double radius, Color color) {
		x = x0;
		y = y0;
		d = density;
		r = radius;
		s = PhysicsState.UNPLACED;
	}

	public void draw(Graphics2D g) {
		Ellipse2D e = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
		g.setColor(Ball.getColorForRadius(r));
		g.fill(e);
	}

	public double getMass() {
		// Area times density
		return Math.PI * r * r * d;
	}

	public boolean collidesWithBall(Ball b) {
		double dist = Math.sqrt(Math.pow(x - b.x, 2) + Math.pow(y - b.y, 2));
		return dist <= r + b.r;
	}

	public PhysicsState getState() {
		return s;
	}

	public void setState(PhysicsState state) {
		s = state;
	}

	public double getRadius() {
		return r;
	}

	public void setRadius(double radius) {
		r = radius;
	}

	public static final Color getColorForRadius(double r) {
		float h = hueFunction(r), s = 1.0F, b = 1.0F;
		return Color.getHSBColor(h, s, b);
	}

	public void forceMoveTo(double x0, double y0) {
		x = x0;
		y = y0;
		switch (s) {
		case FREE:
			break;
		case MOUSE_CONTROL:
			v_x = x0 - x;
			v_y = y0 - y;
			break;
		case UNPLACED:
			break;
		default:
			break;

		}
	}

	/**
	 * Returns the hue (between 0 and 1) as a function of r the radius (between the
	 * min and max)
	 *
	 * The reason why we want this is because we don't want the default linear hue
	 * scale
	 *
	 * @param r
	 * @return
	 */
	private static float hueFunction(double r) {
		float hue = (float) (MAX_RADIUS / 2 + MAX_RADIUS / 2 * Math.cos(r / (MAX_RADIUS / 8 * Math.PI)));
		return (float) (hue / MAX_RADIUS);
	}

}
