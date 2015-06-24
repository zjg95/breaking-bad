import java.awt.Dimension;
public class MiniMap extends MapPanel{
	public MiniMap(MapPanel m){
		super(m);
		setPreferredSize(new Dimension(300,300));
	}
}