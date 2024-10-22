package style;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/*
 * Singleton class that controls the colors of all windows.
 * Allows for easily changing to light/dark mode.
 */
public class ColorManager {
	// Boilerplate to make this a singleton
	private static ColorManager INSTANCE;
	
	public static ColorManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ColorManager();
		}
		
		return INSTANCE;
	}
	
	
	private ColorMode mode = ColorMode.LIGHT;
	
	
	class LightColors {
		private static Color background = Color.white;
		private static Color buttonBg = Color.white;
		private static Color buttonTxt = Color.black;
	}
	
	class DarkColors {
		private static Color background = new Color(35, 39, 42);
		private static Color buttonBg = new Color(44, 47, 51);
		private static Color buttonTxt = Color.white;
	}
	
	
	
	private ArrayList<JFrame> windows = new ArrayList<JFrame>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	private ArrayList<JTextArea> textAreas = new ArrayList<JTextArea>();
	private ArrayList<JScrollPane> scrollPanes = new ArrayList<JScrollPane>();

	
	public void initialiseWindow(JFrame window) {
		window.getContentPane().setBackground(LightColors.background);
		windows.add(window);
	}
	
	
	public void initialiseButton(JButton button) {
		
		button.setBackground(LightColors.buttonBg);
		buttons.add(button);
	}
	
	
	public void ToggleMode() {		
		mode = (mode == ColorMode.LIGHT) ? ColorMode.DARK : ColorMode.LIGHT;
		
		Color background = (mode == ColorMode.LIGHT) ? LightColors.background : DarkColors.background;
		Color button = (mode == ColorMode.LIGHT) ? LightColors.buttonBg : DarkColors.buttonBg;
		Color buttonTxt = (mode == ColorMode.LIGHT) ? LightColors.buttonTxt : DarkColors.buttonTxt;

		updateWindows(background);
		updateButtons(button, buttonTxt);
	}


	private void updateWindows(Color color) {
		for (JFrame window : windows) {
			window.getContentPane().setBackground(color);
		}
	}
	
	private void updateButtons(Color background, Color text) {
		for (JButton button : buttons) {
			button.setBackground(background);
			button.setForeground(text);
		}
	}
}