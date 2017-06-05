import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class MainForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainFormEvent event;
	private MainMenu mainmenu;
	private JScrollPane scrPane;
	private JButton bat0;
	private JButton bat1;
	private JButton bat2;
	private JButton bat3;
	private JButton bat4;
	private JButton bat5;
	private JButton bat6;
	private JButton bat7;
	private JButton bat8;
	private JButton bat9;
	private JButton batDut;
	private JButton batPer;
	private JButton batPls;
	private JButton batMin;
	private JButton batMul;
	private JButton batDiv;
	private JButton batUnd;
	private JButton batClr;
	private JButton batStG;
	private JButton batEnG;
	private JButton batSqr;
	private JButton batSqR;
	private JButton batRes;
	private JTextField textArea;
	private JPanel PnlMain;

	public MainForm() {
		init();
	}

	private void init() {
		int width = 325;
		int height = 245;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dimension.width / 2) - (width / 2);
		int y = (dimension.height / 2) - (height / 2);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		super.setSize(width, height);
		super.setLocation(x, y - 80);
		super.setTitle("Calculator");
		super.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.add(getPnlMain());
		super.setJMenuBar(getMainMenu());
	}

	public MainFormEvent getEvent() {
		if (event == null) {
			event = new MainFormEvent(this);
		}
		return event;
	}

	public MainMenu getMainMenu() {
		if (mainmenu == null) {
			mainmenu = new MainMenu();
		}
		return mainmenu;
	}

	/*public JScrollPane getScrPane() {
		if (scrPane == null) {
			scrPane = new JScrollPane();
			scrPane.setViewportView(getTextArea());
		}
		return scrPane;
	}*/

	public JPanel getPnlMain() {
		if (PnlMain == null) {
			PnlMain = new JPanel(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.ipadx = 12;
			gbc.ipady = 4;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 4;
			PnlMain.add(getBat0(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatDut(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatPer(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatPls(), gbc);
			gbc.gridx++;
			gbc.gridwidth = 2;
			PnlMain.add(getBatRes(), gbc);
			gbc.gridwidth = 1;
			gbc.gridx = 0;
			gbc.gridy = 3;
			PnlMain.add(getBat1(), gbc);
			gbc.gridx++;
			PnlMain.add(getBat2(), gbc);
			gbc.gridx++;
			PnlMain.add(getBat3(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatMin(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatSqR(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatSqr(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			PnlMain.add(getBat4(), gbc);
			gbc.gridx++;
			PnlMain.add(getBat5(), gbc);
			gbc.gridx++;
			PnlMain.add(getBat6(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatMul(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatStG(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatEnG(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			PnlMain.add(getBat7(), gbc);
			gbc.gridx++;
			PnlMain.add(getBat8(), gbc);
			gbc.gridx++;
			PnlMain.add(getBat9(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatDiv(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatUnd(), gbc);
			gbc.gridx++;
			PnlMain.add(getBatClr(), gbc);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 6;
			gbc.ipady = 30;
			PnlMain.add(getTextArea(), gbc);
		}
		return PnlMain;
	}

	public JTextField getTextArea() {
		if (textArea == null) {
			textArea = new JTextField();
			textArea.setHorizontalAlignment(JTextField.RIGHT);
			textArea.setFont(new Font("", 8, 20));
		}
		return textArea;
	}

	public JButton getBat0() {
		if (bat0 == null) {
			bat0 = new JButton("0");
			bat0.addActionListener(getEvent().btnClick);
		}
		return bat0;
	}

	public JButton getBat1() {
		if (bat1 == null) {
			bat1 = new JButton("1");
			bat1.addActionListener(getEvent().btnClick);
		}
		return bat1;
	}

	public JButton getBat2() {
		if (bat2 == null) {
			bat2 = new JButton("2");
			bat2.addActionListener(getEvent().btnClick);
		}
		return bat2;
	}

	public JButton getBat3() {
		if (bat3 == null) {
			bat3 = new JButton("3");
			bat3.addActionListener(getEvent().btnClick);
		}
		return bat3;
	}

	public JButton getBat4() {
		if (bat4 == null) {
			bat4 = new JButton("4");
			bat4.addActionListener(getEvent().btnClick);
		}
		return bat4;
	}

	public JButton getBat5() {
		if (bat5 == null) {
			bat5 = new JButton("5");
			bat5.addActionListener(getEvent().btnClick);
		}
		return bat5;
	}

	public JButton getBat6() {
		if (bat6 == null) {
			bat6 = new JButton("6");
			bat6.addActionListener(getEvent().btnClick);
		}
		return bat6;
	}

	public JButton getBat7() {
		if (bat7 == null) {
			bat7 = new JButton("7");
			bat7.addActionListener(getEvent().btnClick);
		}
		return bat7;
	}

	public JButton getBat8() {
		if (bat8 == null) {
			bat8 = new JButton("8");
			bat8.addActionListener(getEvent().btnClick);
		}
		return bat8;
	}

	public JButton getBat9() {
		if (bat9 == null) {
			bat9 = new JButton("9");
			bat9.addActionListener(getEvent().btnClick);
		}
		return bat9;
	}

	public JButton getBatDut() {
		if (batDut == null) {
			batDut = new JButton(".");
			batDut.addActionListener(getEvent().btnClick);
		}
		return batDut;
	}

	public JButton getBatPer() {
		if (batPer == null) {
			batPer = new JButton("%");
			batPer.addActionListener(getEvent().btnClick);
		}
		return batPer;
	}

	public JButton getBatPls() {
		if (batPls == null) {
			batPls = new JButton("+");
			batPls.addActionListener(getEvent().btnClick);
		}
		return batPls;
	}

	public JButton getBatMin() {
		if (batMin == null) {
			batMin = new JButton("-");
			batMin.addActionListener(getEvent().btnClick);
		}
		return batMin;
	}

	public JButton getBatMul() {
		if (batMul == null) {
			batMul = new JButton("*");
			batMul.addActionListener(getEvent().btnClick);
		}
		return batMul;
	}

	public JButton getBatDiv() {
		if (batDiv == null) {
			batDiv = new JButton("/");
			batDiv.addActionListener(getEvent().btnClick);
		}
		return batDiv;
	}

	public JButton getBatUnd() {
		if (batUnd == null) {
			batUnd = new JButton();
			batUnd.addActionListener(getEvent().btnBackClick);
			batUnd.setIcon(new ImageIcon("src/com/arya/culculator/view/images/un.png"));
		}
		return batUnd;
	}

	public JButton getBatClr() {
		if (batClr == null) {
			batClr = new JButton();
			batClr.addActionListener(getEvent().btnClearClick);
			batClr.setIcon(new ImageIcon("src/com/arya/culculator/view/images/de.png"));
		}
		return batClr;
	}

	public JButton getBatStG() {
		if (batStG == null) {
			batStG = new JButton("(");
			batStG.addActionListener(getEvent().btnClick);
		}
		return batStG;
	}

	public JButton getBatEnG() {
		if (batEnG == null) {
			batEnG = new JButton(")");
			batEnG.addActionListener(getEvent().btnClick);
		}
		return batEnG;
	}

	public JButton getBatSqr() {
		if (batSqr == null) {
			batSqr = new JButton("SQR");
			batSqr.addActionListener(getEvent().btnClick);
		}
		return batSqr;
	}

	public JButton getBatSqR() {
		if (batSqR == null) {
			batSqR = new JButton("X^2");
			batSqR.addActionListener(getEvent().btnClick);
		}
		return batSqR;
	}

	public JButton getBatRes() {
		if (batRes == null) {
			batRes = new JButton("=");
			batRes.addActionListener(getEvent().btnResultClick);
		}
		return batRes;
	}

}
