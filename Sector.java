import java.util.Random;
import java.util.LinkedList;
public class Sector{
	private SectorType type;
	private Zone[] zones;

	public Sector(SectorType typ,Map m){
		type = typ;
		zones = new Zone[25];
		boolean bool = true;
		for (int i = 0; i<25;i++){
			zones[i] = new Zone(typ,m);
		}
		if (type==SectorType.RUR){
			for (Zone z: zones)
				z.setActive(true);
			return;
		}
		Random random = new Random();
		LinkedList<Zone> list = new LinkedList<Zone>();
		for (Zone z: zones)
			list.add(z);
		for (int i = 25;i>9;i--){
			int x = random.nextInt(i);
			Zone z = list.get(x);
			z.setActive(true);
			list.remove(z);
		}
	}
	public Zone getZone(int i){
		return zones[i];
	}
}