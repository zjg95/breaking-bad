import javax.swing.*;
import java.awt.*;
public class StorePane extends JScrollPane{
	public ManuStore manu;
	public DistStore dist;
	public JPanel screens[];
	public Player player;
	public int current =0;
	public StorePane(Player p){
		super();
		player = p;
		dist = new DistStore(p);
		manu = new ManuStore(p);
		screens = new JPanel[]{manu,dist};
		setViewportView(manu);
        getVerticalScrollBar().setUnitIncrement(25);
	}
	public boolean setContents(int x){
		if (current==x)
			return false;
		setViewportView(screens[x]);
		current = x;
		return true;
	}
}