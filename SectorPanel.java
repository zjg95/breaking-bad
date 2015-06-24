import javax.swing.*;
import java.awt.*;
import java.awt.Color;
public class SectorPanel extends JPanel{
	public SectorPanel(Sector s,MapPanel m){
		super(new GridLayout(5, 5));
		for (int i = 0;i<25;i++){
			add(new ZonePanel(s.getZone(i),m));
		}
	}
}