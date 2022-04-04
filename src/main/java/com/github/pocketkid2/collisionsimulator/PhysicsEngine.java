package com.github.pocketkid2.collisionsimulator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

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

	private static List<Ball> balls = new ArrayList<Ball>();

	private static Tool currentTool = Tool.NONE;
	private static JLabel statusLabel = null;

	public static List<Ball> getBalls() {
		return balls;
	}

	public static Tool getCurrentTool() {
		return currentTool;
	}

	public static void setCurrentTool(Tool t) {
		System.out.println("Changing to tool " + t.toString());
		currentTool = t;
		if (statusLabel != null) {
			statusLabel.setText("Current Tool: " + t.getName());
			statusLabel.repaint();
		}
	}

	public static void setStatusLabel(JLabel l) {
		statusLabel = l;
	}
}
