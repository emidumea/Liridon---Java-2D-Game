package GameDev.Input;


import GameDev.Game;
import GameDev.GameStates.Gamestate;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener
{
	private Game game;
	private boolean LMBPressed;
	private boolean RMBPressed;
	public int mouseX = 0;
	public int mouseY = 0;


	public MouseInput(Game game)
	{
		this.game = game;
	}
	public void moveX(int val)
	{
		this.mouseX +=val;
	}
	public int getMouseX(){return this.mouseX;}

	public void moveY(int val)
	{
		this.mouseY +=val;
	}
	public int getMouseY(){return this.mouseY;}


	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Gamestate.state)
		{
			case MENU:
				game.getMenu().mouseClicked(e);
				break;
			case PLAYING:
				game.getPlaying().mouseClicked(e);
				break;
			default:
				break;
		}

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			LMBPressed = true;
		//	System.out.println(e.getX()+", "+e.getY());
		}
		else if (e.getButton() == MouseEvent.BUTTON3)
		{	RMBPressed = true;
		//	System.out.println(e.getX()+", "+e.getY());
		}

	//	System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON1) {
			LMBPressed = false;
		}
		if(e.getButton()==MouseEvent.BUTTON3){
			RMBPressed = false;
		}
	//	System.out.println("released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		//mouseX=e.getX();
		//mouseY=e.getY();
		//game.setPos(e.getX(),e.getY());
		//System.out.println("move");
	}
}
/*
import GameDev.Utils.Coordinate;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class handle mouse events.

public class MouseInput implements MouseListener, MouseMotionListener {
	private static MouseInput instance;
	private final Coordinate<Integer> position;
	private boolean isLeftMousePreviousPressed;
	private boolean isRightMousePreviousPressed;
	private boolean isLeftMousePressed;
	private boolean isRightMousePressed;

	public MouseInput(){
		position = new Coordinate<>(0,0);
		isRightMousePressed = false;
		isRightMousePreviousPressed = false;
		isLeftMousePreviousPressed= false;
		isLeftMousePressed = false;
	}

	public static MouseInput get(){
		if (instance == null) {
			instance = new MouseInput();
		}
		return instance;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("mouse clic");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getModifiersEx()) {
			case InputEvent.BUTTON1_DOWN_MASK -> {
				isLeftMousePressed = true;
				System.out.println("mouse clic");
			}
			case InputEvent.BUTTON2_DOWN_MASK -> {

			}
			case InputEvent.BUTTON3_DOWN_MASK -> {
				isRightMousePressed = true;
				System.out.println("mouse clic");
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isLeftMousePreviousPressed = isLeftMousePressed;
		isRightMousePreviousPressed = isRightMousePressed;
		isRightMousePressed = false;
		isLeftMousePressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		position.setX(e.getX());
		position.setY(e.getY());
	}

	public boolean isLeftMousePressed() {
		return isLeftMousePressed;
	}

	public boolean isLeftMousePreviousPressed() {
		return isLeftMousePreviousPressed;
	}

	public boolean isRightMousePressed() {
		return isRightMousePressed;
	}

	public boolean isRightMousePreviousPressed() {
		return isRightMousePreviousPressed;
	}

	public Coordinate<Integer> getPosition() {
		return position;
	}

	public void reset(){
		isLeftMousePressed = false;
		isRightMousePressed = false;
	}
}*/