import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



public class MainFormEvent {
	private MainForm mainForm;

	public MainForm getMainForm() {
		return mainForm;
	}
	public MainFormEvent(MainForm mainForm) {
		this.mainForm = mainForm;
	}

	public ActionListener btnClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (getMainForm().getTextArea().getText().toLowerCase().equals("malformed expression")){
				getMainForm().getTextArea().setText("");
			}
			Object o = e.getSource();
			if (!(o instanceof JButton)) {
				return;
			}
			JButton btn = (JButton) o;
			getMainForm().getTextArea().setText((getMainForm().getTextArea().getText() + btn.getText()));
			//JOptionPane.showMessageDialog(null, btn.getText());
		}
	};
	public ActionListener btnBackClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (!(o instanceof JButton)) {
				return;
			}
			String s = getMainForm().getTextArea().getText();
			if (s.length() == 0) {
				return;
			}
			s = s.substring(0 , s.length() - 1);
			getMainForm().getTextArea().setText(s);
		}
	};
	public ActionListener btnClearClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (!(o instanceof JButton)) {
				return;
			}
			getMainForm().getTextArea().setText("");
		}
	};
	public ActionListener btnResultClick = new ActionListener() {
		private Calculate calculate;

		public Calculate getCalculate() {
			if (calculate == null) {
				calculate = new Calculate(getMainForm().getTextArea().getText());
			}
			return calculate;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (! (o instanceof JButton)) {
				return;
			}
			getMainForm().getTextArea().setText(getCalculate().getResult());
			calculate = null;
		}
	};
}
