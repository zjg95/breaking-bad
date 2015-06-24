public class Zone{
	private SectorType type;
	private String name;
	private GameObject currentObject = null;
	private boolean active;
	private boolean selected = false;
	private java.util.LinkedList<ZonePanel> zonePanel;

	private ZoneInfoPanel infoPanel;
	private int risk,collectionTime;
	private Map map;
	private java.util.Random random= new java.util.Random();

	public Zone(SectorType t,Map m){
		map = m;
		collectionTime=random.nextInt(100);
		risk=random.nextInt(100);
		type = t;
		name = "Empty Zone";
		active = false;
		zonePanel = new java.util.LinkedList<ZonePanel>();
		infoPanel = new ZoneInfoPanel(this);
	}
	public SectorType getType(){
		return type;
	}
	public boolean isActive(){
		return active;
	}
	public ZoneInfoPanel getInfoPanel(){
		return infoPanel;
	}
	public int getRisk(){
		return risk;
	}
	public String getName(){
		return name;
	}
	public int getCollectionTime(){
		return collectionTime;
	}



	public void setZonePanel(ZonePanel z){
		zonePanel.add(z);
	}
	public void setActive(boolean b){
		active = b;
	}
	public void setObject(GameObject o){
		currentObject = o;
	}
	public void select(){
		selected = true;
		for (ZonePanel z: zonePanel)
			z.select(this);
		map.setSelected(this);
	}
	public void deselect(){
		selected = false;
		for (ZonePanel z: zonePanel)
			z.deselect();
	}
	public void buy(ManufacturingObject a){
		currentObject=a;
		for (ZonePanel z: zonePanel)
			z.setImage(a.getImage());
	}
	public void sell(){
		currentObject=null;
		for (ZonePanel z: zonePanel)
			z.setImage(null);
	}
}