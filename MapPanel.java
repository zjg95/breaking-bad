import javax.swing.*;
import java.awt.*;
import java.awt.Color;
public class MapPanel extends JPanel{

	private final Map map;
	private final String name;
	private MapPanel otherMap = null;
	private Zone selected=null;
	private MainScreen main;

	private SectorPanel[] sectors;

	public MapPanel(MainScreen m){
		super(new GridLayout(5, 5, 10,10));
		main = m;
		sectors = new SectorPanel[25];
		name = "Main Map";
		map = new Map(m);
		for (int i = 0;i<25;i++){
			sectors[i]=new SectorPanel(map.getSector(i),this);
			add(sectors[i]);
		}
	}
	public MapPanel(MapPanel m){
		super(new GridLayout(5, 5, 0,0));
		otherMap = m;
		name = "Mini Map";
		map = m.getMap();
		for (int i = 0;i<25;i++)
			add(new SectorPanel(map.getSector(i),m));
	}
	public Map getMap(){
		return map;
	}
	private SectorPanel getSector(int x){
		return sectors[x];
	}
	public void setOtherMap(MapPanel m){
		otherMap=m;
	}
	public void setSelected(Zone z){
		if (selected!=null&&selected!=z){
			selected.deselect();
		}
		selected=z;
		System.out.println(name+": telling other map");
		otherMap.tellOtherMap(z);
	}
	private void tellOtherMap(Zone z){
		if (selected!=null&&selected!=z){
			selected.deselect();
		}
		selected=z;
		System.out.println(name+": I heard you");
	}
}