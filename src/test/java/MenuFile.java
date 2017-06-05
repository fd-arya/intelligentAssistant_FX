import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuFile extends JMenu{

	private static final long serialVersionUID = 1L;
	private JMenuItem mnuItmExit;

	public MenuFile() {
		super.setText("File");
		super.add(getMnuItmExit());
	}

	public JMenuItem getMnuItmExit(){
		if (mnuItmExit == null) {
			mnuItmExit = new JMenuItem("Exit");
		}
		return mnuItmExit;
	}

}
