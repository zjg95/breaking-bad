import java.util.Random;
public class Map{
	private final Sector sectors[];
	private final MainScreen main;
	private Zone selected=null;
	public Map(MainScreen m){
		main = m;
		sectors = new Sector[25];
		Random random = new Random();

		switch (random.nextInt(4)){
			case(0):layout1(); break;
			case(1):layout2(); break;
			case(2):layout3(); break;
			case(3):layout4(); break;
		}

		for (int i = 0; i<25;i++){
			if (sectors[i]==null)
				sectors[i] = new Sector(SectorType.DWN,this);			
		}
	}
	public void layout1(){ // 0-6, 10
		for (int i = 0;i<11;i++){
			sectors[i] = new Sector(SectorType.DWN,this);
			if (i<10&&i>6)
				continue;
			sectors[i] = new Sector(SectorType.RUR,this);
		}
		
	}
	public void layout2(){ // 0-5, 8-9, 14
		layout1();	
	}
	public void layout3(){ // 18-24, 14
		for (int i = 24;i>13;i--){
			sectors[i] = new Sector(SectorType.DWN,this);
			if (i<18&&i>14)
				continue;
			sectors[i] = new Sector(SectorType.RUR,this);
		}
		
	}
	public void layout4(){ // 20-24, 15-16, 10
		layout1();
	}
	public Sector getSector(int i){
		return sectors[i];
	}
	public void setSelected(Zone z){
		selected = z;
		main.setSelected(z);
	}
}