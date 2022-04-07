package com.github.pocketkid2.collisionsimulator;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseEventHandler implements MouseMotionListener, MouseListener, MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		PhysicsEngine.mouseWheelScrolled(e.getUnitsToScroll());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		PhysicsEngine.mouseClicked(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		PhysicsEngine.mousePressed(e.getButton(), e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		PhysicsEngine.mouseReleased(e.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		PhysicsEngine.mouseEntered(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		PhysicsEngine.mouseExited(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		PhysicsEngine.mouseDragged(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		PhysicsEngine.mouseMoved(e.getX(), e.getY());
	}

}
