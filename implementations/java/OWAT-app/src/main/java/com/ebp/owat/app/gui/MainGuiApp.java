package com.ebp.owat.app.gui;

import com.ebp.owat.app.config.Globals;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Main class for the GUI.
 * <p>
 * Partially generated using Intellij.
 * Guides:
 * https://stackoverflow.com/questions/12775170/how-do-i-create-a-new-swing-app-in-intellij-idea-community-edition
 * https://stackoverflow.com/questions/3899525/how-to-use-gui-form-created-in-itellij-idea
 */
public class MainGuiApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainGuiApp.class);

	private JPanel mainPanel;
	private JTabbedPane modeSelect;
	private JPanel scramblePanel;
	private JPanel deScramblePanel;
	private JPanel infoPanel;
	private JTextPane infoPane;
	private JLabel inputsScrambleTitle;
	private JLabel outputsScrambleTitle;
	private JTabbedPane inputModeScramble;
	private JTextArea textScrambleTestArea;
	private JTextField inputScrambleDataFile;
	private JButton chooseScrambleDataFileButton;
	private JTextField outputScrambledDataFile;
	private JButton chooseScrambledDataOutputFileButton;
	private JTextField oututKeyFile;
	private JButton chooseKeyOutputFileButton;
	private JPanel enterScrambleDataPanel;
	private JPanel enterScrambleFilePanel;
	private JButton scrambleGoButton;
	private JProgressBar scrambleProgressBar;

	private static final String TITLE_FORMAT = "%s v%s %s";

	private static final String appTitle = String.format(
		TITLE_FORMAT,
		Globals.getProp(Globals.PropertyKey.APP_NAME_PROP_KEY),
		Globals.getProp(Globals.PropertyKey.APP_VERSION_PROP_KEY),
		Globals.getProp(Globals.PropertyKey.APP_VERSION_NAME_PROP_KEY)
	);

	public static void main(String[] args) {
		LOGGER.info("Starting GUI.");
		JFrame frame = new JFrame(appTitle);
		frame.setContentPane(new MainGuiApp().mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		mainPanel.setMinimumSize(new Dimension(500, 500));
		mainPanel.setName("");
		mainPanel.setPreferredSize(new Dimension(500, 500));
		modeSelect = new JTabbedPane();
		mainPanel.add(modeSelect, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		scramblePanel = new JPanel();
		scramblePanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
		scramblePanel.setMaximumSize(new Dimension(-1, -1));
		scramblePanel.setMinimumSize(new Dimension(-1, -1));
		scramblePanel.setPreferredSize(new Dimension(-1, -1));
		modeSelect.addTab("Scramble", null, scramblePanel, "Scramble some data");
		final JSplitPane splitPane1 = new JSplitPane();
		scramblePanel.add(splitPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
		enterScrambleDataPanel = new JPanel();
		enterScrambleDataPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
		splitPane1.setLeftComponent(enterScrambleDataPanel);
		inputsScrambleTitle = new JLabel();
		Font inputsScrambleTitleFont = this.$$$getFont$$$(null, Font.BOLD, 20, inputsScrambleTitle.getFont());
		if (inputsScrambleTitleFont != null) inputsScrambleTitle.setFont(inputsScrambleTitleFont);
		inputsScrambleTitle.setText("Inputs");
		enterScrambleDataPanel.add(inputsScrambleTitle, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		inputModeScramble = new JTabbedPane();
		enterScrambleDataPanel.add(inputModeScramble, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 200), null, 0, false));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		panel1.setMaximumSize(new Dimension(-1, -1));
		panel1.setMinimumSize(new Dimension(-1, -1));
		panel1.setPreferredSize(new Dimension(-1, -1));
		inputModeScramble.addTab("Enter Text", null, panel1, "This is to enter your own data to be scrambled.");
		textScrambleTestArea = new JTextArea();
		textScrambleTestArea.setLineWrap(true);
		panel1.add(textScrambleTestArea, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
		inputModeScramble.addTab("File", null, panel2, "This is to specify a file to be scrambled.");
		inputScrambleDataFile = new JTextField();
		panel2.add(inputScrambleDataFile, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel2.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		chooseScrambleDataFileButton = new JButton();
		chooseScrambleDataFileButton.setText("Choose File");
		panel2.add(chooseScrambleDataFileButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		enterScrambleFilePanel = new JPanel();
		enterScrambleFilePanel.setLayout(new GridLayoutManager(8, 1, new Insets(0, 0, 0, 0), -1, -1));
		splitPane1.setRightComponent(enterScrambleFilePanel);
		outputsScrambleTitle = new JLabel();
		Font outputsScrambleTitleFont = this.$$$getFont$$$(null, Font.BOLD, 20, outputsScrambleTitle.getFont());
		if (outputsScrambleTitleFont != null) outputsScrambleTitle.setFont(outputsScrambleTitleFont);
		outputsScrambleTitle.setText("Outputs");
		enterScrambleFilePanel.add(outputsScrambleTitle, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer2 = new Spacer();
		enterScrambleFilePanel.add(spacer2, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		final JLabel label1 = new JLabel();
		label1.setText("Scrambled data file:");
		enterScrambleFilePanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		outputScrambledDataFile = new JTextField();
		enterScrambleFilePanel.add(outputScrambledDataFile, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		chooseScrambledDataOutputFileButton = new JButton();
		chooseScrambledDataOutputFileButton.setText("Choose File");
		enterScrambleFilePanel.add(chooseScrambledDataOutputFileButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label2 = new JLabel();
		label2.setText("Key file:");
		enterScrambleFilePanel.add(label2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		oututKeyFile = new JTextField();
		enterScrambleFilePanel.add(oututKeyFile, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		chooseKeyOutputFileButton = new JButton();
		chooseKeyOutputFileButton.setText("Choose File");
		enterScrambleFilePanel.add(chooseKeyOutputFileButton, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		scramblePanel.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(-1, 55), new Dimension(-1, 55), new Dimension(-1, 55), 0, false));
		scrambleGoButton = new JButton();
		scrambleGoButton.setEnabled(false);
		scrambleGoButton.setText("Go");
		panel3.add(scrambleGoButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		scrambleProgressBar = new JProgressBar();
		panel3.add(scrambleProgressBar, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 50), new Dimension(-1, 50), new Dimension(-1, 50), 0, false));
		deScramblePanel = new JPanel();
		deScramblePanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		modeSelect.addTab("Descramble", null, deScramblePanel, "Descramble previously scrambled data");
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		infoPanel.setToolTipText("Info about this program");
		modeSelect.addTab("*Info*", null, infoPanel, "Information about this program");
		infoPane = new JTextPane();
		infoPane.setText("OWAT-J\n\nJava implementation of the OWAT protocol.");
		infoPanel.add(infoPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
		if (currentFont == null) return null;
		String resultName;
		if (fontName == null) {
			resultName = currentFont.getName();
		} else {
			Font testFont = new Font(fontName, Font.PLAIN, 10);
			if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
				resultName = fontName;
			} else {
				resultName = currentFont.getName();
			}
		}
		return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return mainPanel;
	}
}
