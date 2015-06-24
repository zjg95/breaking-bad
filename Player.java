import java.util.LinkedList;
public class Player{

	public Game game;
	public String name;
	public int num;
	public Person character;
	public LinkedList<ManufacturingObject> manu;

	public int fear, control, product, resources, reputation = 0;
	public int risk = 0;
	public int money = 100;

	public Player(Game g,int n){
		game = g;
		character = new Person();
		name = "Player "+n;
		num = n;
		manu= new LinkedList<ManufacturingObject>();
	}
	public int getMoney(){
		return money;
	}
	public int getProduct(){
		return product;
	}
	public int getRisk(){
		return risk;
	}


	public void addMoney(int v){
		money+=v;
	}
	public void subMoney(int v){
		money-=v;
	}
	public void addRisk(int v){
		risk+=v;
	}
	public void addProduct(int v){
		product+=v;
	}
	public void subProduct(int v){
		product-=v;
	}
	public void buyManuObject(ManufacturingObject j){
		manu.add(j);
		System.out.printf("New %s purchased.\n",j);
		subMoney(j.costToGet);
		addRisk(j.riskToGet);
	}
	public void sellManuObject(ManufacturingObject j){
		if (manu.size()<2){
			System.out.println("Nothing to Sell");
			return;
		}
		j = manu.get(1);
		manu.remove(j);
		System.out.printf("%s sold.\n",j);
		addMoney(j.costToSell);
		addRisk(j.riskToSell);
	}
	public void collect(){
		for (ManufacturingObject j:manu)
			j.collect();
	}
	public void cook(){
		for (ManufacturingObject j:manu)
			j.cook();
	}
	public void start(){
		buyManuObject(new KitchenSink(this));
	}
}