package com.github.pocketkid2.collisionsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application extends JFrame {

	public Application() {
		initUI();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Application app = new Application();
			app.setVisible(true);
		});
	}

	private void initUI() {
		add(new Board());
		setSize(1280, 720);
		setTitle("Bouncy Balls");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
