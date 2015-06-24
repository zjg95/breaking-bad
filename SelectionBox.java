import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class SelectionBox extends JScrollPane{
	private ZoneInfoPanel current = null;
	private final ObjectListPanel purchases;
	private final MainScreen main;
	public final Player player;
	private ManufacturingObject currentObject;
	public SelectionBox(MainScreen a){
		super();
		setPreferredSize(new Dimension(320,320));
		setBorder(BorderFactory.createTitledBorder("Current Selection"));
		getVerticalScrollBar().setUnitIncrement(16);
		main = a;
		player = a.getGame().getPlayer(0);
		purchases = new ObjectListPanel(this);
	}
	public void setContents(ZoneInfoPanel a){
		setViewportView(a);
		current = a;
		a.setSelectionBox(this);
		setSize(320,150);
	}
	public void showPurchase(){
		setViewportView(purchases);
		setSize(500,600);
	}
	public void hidePurchase(){
		setViewportView(current);
		setSize(300,300);
	}
	public void buy(ManufacturingObject a){
		current.buy.setEnabled(false);
		current.sell.setEnabled(true);
		current.setImage(a.getImage());
		currentObject=a;
		main.buy(a);
	}
	public void sell(){
		player.sellManuObject(currentObject);
		currentObject=null;
		main.sell();
	}
}