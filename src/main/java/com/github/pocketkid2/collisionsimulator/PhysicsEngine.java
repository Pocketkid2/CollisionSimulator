package com.github.pocketkid2.collisionsimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;

import com.github.pocketkid2.collisionsimulator.Ball.PhysicsState;

public class PhysicsEngine {

	public enum Tool {
		NONE("None"),
		INFO("Info"),
		ADD("Add"),
		MOVE("Move"),
		IMPULSE("Impulse");

		private String name;

		Tool(String n) {
			name = n;
		}

		public String getName() {
			return name;
		}
	}

	private static Tool currentTool = Tool.NONE;
	private static JLabel toolLabel = null;
	private static JLabel ballLabel = null;

	private static Ball ballOnCursor = new Ball(-50, -50);

	private static List<Ball> balls = new ArrayList<Ball>(Collections.singleton(ballOnCursor));

	public static List<Ball> getBalls() {
		return balls;
	}

	public static Tool getCurrentTool() {
		return currentTool;
	}

	public static void setCurrentTool(Tool t) {
		System.out.println("Changing to tool " + t.toString());
		currentTool = t;
		updateToolLabelText("Current Tool: " + t.getName());
	}

	public static void updateToolLabelText(String s) {
		if (toolLabel != null) {
			toolLabel.setText(s);
			toolLabel.repaint();
		}
	}

	public static void updateBallLabelText(String s) {
		if (ballLabel != null) {
			ballLabel.setText(s);
			ballLabel.repaint();
		}
	}

	public static void setToolLabel(JLabel l) {
		toolLabel = l;
	}

	public static void setBallLabel(JLabel l) {
		ballLabel = l;
	}

	public static void mouseMoved(int x, int y) {
		switch (currentTool) {
		case ADD:
			if (ballOnCursor != null) {
				ballOnCursor.forceMoveTo(x, y);
			}
			break;
		case IMPULSE:
			break;
		case INFO:
			break;
		case MOVE:
			break;
		case NONE:
			break;
		default:
			break;

		}
	}

	public static void mouseClicked(int x, int y) {
		switch (currentTool) {
		case ADD:
			if (ballOnCursor != null) {
				ballOnCursor.setState(PhysicsState.FREE);
				Ball b = new Ball(x, y);
				b.setRadius(ballOnCursor.getRadius());
				ballOnCursor = b;
				balls.add(b);
			}
			break;
		case IMPULSE:
			break;
		case INFO:
			break;
		case MOVE:
			break;
		case NONE:
			break;
		default:
			break;

		}
	}

	public static void mouseWheelScrolled(int unitsToScroll) {
		switch (currentTool) {
		case ADD:
			if (ballOnCursor != null) {
				double newRadius = ballOnCursor.getRadius() + unitsToScroll;
				if (newRadius >= Ball.MAX_RADIUS) {
					newRadius = Ball.MAX_RADIUS;
				} else if (newRadius <= Ball.MIN_RADIUS) {
					newRadius = Ball.MIN_RADIUS;
				}
				ballOnCursor.setRadius(newRadius);
				updateBallLabelText("Radius: " + newRadius);
			}
			break;
		case IMPULSE:
			break;
		case INFO:
			break;
		case MOVE:
			break;
		case NONE:
			break;
		default:
			break;

		}
	}
}
