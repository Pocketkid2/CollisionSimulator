package com.github.pocketkid2.collisionsimulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.github.pocketkid2.collisionsimulator.PhysicsEngine.Tool;

public class Application extends JFrame {

	private static final int ICON_SIZE = 32;

	private static final int STATUS_BAR_SIZE = 24;

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
		createMenuBar();
		createToolBar();
		createStatusBar();
		add(new Board());
		setSize(1280, 720);
		setTitle("Bouncy Balls");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void createMenuBar() {
		var menuBar = new JMenuBar();
		var fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	private void createToolBar() {
		var toolbar = new JToolBar();

		var infoToolIcon = resize(ICON_SIZE, ICON_SIZE, new ImageIcon("src/main/resources/info-tool.png"));
		var infoToolButton = new JButton(infoToolIcon);
		infoToolButton.setToolTipText("Info Tool - Click a ball to see it's info");
		infoToolButton.addActionListener(e -> {
			PhysicsEngine.setCurrentTool(Tool.INFO);
		});
		toolbar.add(infoToolButton);

		var addToolIcon = resize(ICON_SIZE, ICON_SIZE, new ImageIcon("src/main/resources/add-tool.png"));
		var addToolButton = new JButton(addToolIcon);
		addToolButton.setToolTipText("Add Tool - Click to place a ball, scroll to change it's size");
		addToolButton.addActionListener(e -> {
			PhysicsEngine.setCurrentTool(Tool.ADD);
		});
		toolbar.add(addToolButton);

		var moveToolIcon = resize(ICON_SIZE, ICON_SIZE, new ImageIcon("src/main/resources/move-tool.png"));
		var moveToolButton = new JButton(moveToolIcon);
		moveToolButton.setToolTipText("Move Tool - Click and drag a ball to move it somewhere");
		moveToolButton.addActionListener(e -> {
			PhysicsEngine.setCurrentTool(Tool.MOVE);
		});
		toolbar.add(moveToolButton);

		var impulseToolIcon = resize(ICON_SIZE, ICON_SIZE, new ImageIcon("src/main/resources/impulse-tool.png"));
		var impulseToolButton = new JButton(impulseToolIcon);
		impulseToolButton.setToolTipText("Impulse Tool - Click and drag on a ball to create an impulse vector, release to activate, right click to cancel");
		impulseToolButton.addActionListener(e -> {
			PhysicsEngine.setCurrentTool(Tool.IMPULSE);
		});
		toolbar.add(impulseToolButton);

		add(toolbar, BorderLayout.NORTH);
	}

	private void createStatusBar() {
		var statusBar = new JPanel();
		statusBar.setPreferredSize(new Dimension(getWidth(), STATUS_BAR_SIZE));
		statusBar.setLayout(new BorderLayout());
		add(statusBar, BorderLayout.SOUTH);

		var toolLabel = new JLabel("");
		toolLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		statusBar.add(toolLabel, BorderLayout.LINE_START);
		PhysicsEngine.setToolLabel(toolLabel);

		var ballLabel = new JLabel("");
		ballLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		statusBar.add(ballLabel, BorderLayout.LINE_END);
		PhysicsEngine.setBallLabel(ballLabel);
	}

	private ImageIcon resize(int width, int height, ImageIcon old) {
		Image img1 = old.getImage();
		Image img2 = img1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(img2);
	}

}
