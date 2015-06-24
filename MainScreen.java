import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class MainScreen extends JPanel{
	private MapPanel mapPanel;
	private Game game;
	private BBFrame frame;
	private Zone selectedZone;
	private Sidebar sidebar;
	
	public MiniMap miniMap;
	public SelectionBox selectionBox;
	public MainScreen(BBFrame f){
		super(new BorderLayout());

		frame = f;
		mapPanel = new MapPanel(this);
		miniMap= new MiniMap(mapPanel);

		mapPanel.setOtherMap(miniMap);
		JScrollPane scrollMap = new JScrollPane(mapPanel);

		//scrollMap.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollMap.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollMap.getVerticalScrollBar().setUnitIncrement(25);
        scrollMap.getHorizontalScrollBar().setUnitIncrement(25);

		//scrollMap.getViewport().setViewPosition(new Point(330, 330)); 

		game = new Game(mapPanel.getMap());
		selectionBox = new SelectionBox(this);
		sidebar = new Sidebar(this);

		add(sidebar,BorderLayout.LINE_END);
		add(scrollMap,BorderLayout.CENTER);
	}
	public Game getGame(){
		return game;
	}
	public void setSelected(Zone z){
		selectionBox.setContents(z.getInfoPanel());
		if (selectedZone!=z)
			selectedZone = z;
	}
	public void buy(ManufacturingObject a){
		selectedZone.buy(a);
	}
	public void sell(){
		selectedZone.sell();
	}
}