package GameDev.GameWindow;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
	private JFrame frame;

	private String title;

	private int width;

	private int height;

	private Canvas canvas;

	public GameWindow(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

	}

	public void BuildGameWindow()
	{
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));

		frame.add(canvas);
		frame.pack();
	}

	public int getWidth() { return width; }

	public int getHeight() { return height; }

	public Canvas getCanvas() { return canvas; }

	public JFrame getFrame() { return frame; }
}