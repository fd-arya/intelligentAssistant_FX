import javax.swing.JMenuBar;



public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private MenuFile menuFile;

	public MainMenu() {
		super.add(getMenuFile());
	}

	public MenuFile getMenuFile() {
		if ( menuFile == null ) {
			menuFile = new MenuFile();
		}
		return menuFile;
	}

}
