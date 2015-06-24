import javax.swing.*;
import java.awt.*;
public class Sidebar extends JPanel{
	private MiniMap miniMap;
	private SelectionBox selectionBox;
	private final MainScreen main;
	public StatusBar statusBar;

	public Store store;
	public Player player;

	private final JLayeredPane layeredPane;
	public Sidebar(MainScreen m){
		super(new GridBagLayout());
		layeredPane=new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(320,320));

		player = m.getGame().getPlayer(0);
		statusBar= new StatusBar(player);
		store = new Store(player);

		main = m;
		miniMap=m.miniMap;
		selectionBox=m.selectionBox;

		layeredPane.add(miniMap,new Integer(0));
		miniMap.setBounds(10,10,300,300);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.weightx = 1.0;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		add(statusBar, c);

		c.gridy++;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.PAGE_END;
		add(store, c);
	}
}