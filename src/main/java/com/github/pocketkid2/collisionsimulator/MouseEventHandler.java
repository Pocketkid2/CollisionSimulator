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
		System.out.println("Mouse pressed at " + e.getXOnScreen() + ", " + e.getYOnScreen());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released at " + e.getXOnScreen() + ", " + e.getYOnScreen());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered at " + e.getXOnScreen() + ", " + e.getYOnScreen());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited at " + e.getXOnScreen() + ", " + e.getYOnScreen());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged at " + e.getXOnScreen() + ", " + e.getYOnScreen());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		PhysicsEngine.mouseMoved(e.getX(), e.getY());
	}

}
