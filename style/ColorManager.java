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
		private static Color buttonBg = new Color(230, 230, 230);
		private static Color buttonText = Color.black;
		private static Color text = new Color(51, 51, 51);
		private static Color textFieldBg = Color.white;
		public static Color textAreaBg = textFieldBg;
	}
	
	class DarkColors {
		private static Color background = new Color(35, 39, 42);
		private static Color buttonBg = new Color(44, 47, 51);
		private static Color buttonText = Color.white;
		private static Color text = new Color(240, 240, 240);
		private static Color textFieldBg = new Color(64, 67, 71);
		public static Color textAreaBg = textFieldBg;
	}
	

	private ArrayList<JFrame> windows = new ArrayList<JFrame>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	private ArrayList<JTextArea> textAreas = new ArrayList<JTextArea>();

	
	public void initialiseWindow(JFrame window) {
		window.getContentPane().setBackground(LightColors.background);
		windows.add(window);
	}
	
	
	public void initialiseButton(JButton button) {
		
		button.setBackground(LightColors.buttonBg);
		buttons.add(button);
	}
	
	
	public void initialiseLabel(JLabel label) {
		label.setForeground(LightColors.text);
		labels.add(label);
	}
	
	
	public void initialiseTextField(JTextField textField) {
		textField.setBackground(LightColors.textFieldBg);
		textFields.add(textField);
	}
	
	
	public void initialiseTextArea(JTextArea textArea) {
		textArea.setBackground(LightColors.textAreaBg);
		textAreas.add(textArea);
	}
	
	
	public void ToggleMode() {
		mode = (mode == ColorMode.LIGHT) ? ColorMode.DARK : ColorMode.LIGHT;
		boolean isLightMode = (mode == ColorMode.LIGHT);
		
		Color background = isLightMode ? LightColors.background : DarkColors.background;
		Color button = isLightMode ? LightColors.buttonBg : DarkColors.buttonBg;
		Color buttonTxt = isLightMode ? LightColors.buttonText : DarkColors.buttonText;
		Color text = isLightMode ? LightColors.text : DarkColors.text;
		Color textFieldBg = isLightMode ? LightColors.textFieldBg : DarkColors.textFieldBg;
		Color textAreaBg = isLightMode ? LightColors.textAreaBg : DarkColors.textAreaBg;

		updateWindows(background);
		updateButtons(button, buttonTxt);
		updateLabels(text);
		updateTextFields(textFieldBg, text);
		updateTextArea(textAreaBg, text);
	}


	private void updateWindows(Color background) {
		for (JFrame window : windows) {
			window.getContentPane().setBackground(background);
		}
	}
	
	private void updateButtons(Color background, Color text) {
		for (JButton button : buttons) {
			button.setBackground(background);
			button.setForeground(text);
		}
	}
	
	private void updateLabels(Color text) {
		for (JLabel label : labels) {
			label.setForeground(text);
		}
	}
	
	private void updateTextFields(Color background, Color text) {
		for (JTextField textField : textFields) {
			textField.setBackground(background);
			textField.setForeground(text);
		}
	}
	
	private void updateTextArea(Color background, Color text) {
		for (JTextArea textArea : textAreas) {
			textArea.setBackground(background);
			textArea.setForeground(text);
		}
	}
}