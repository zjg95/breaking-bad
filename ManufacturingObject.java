import javax.swing.ImageIcon;
abstract public class ManufacturingObject extends GameObject{
	public int costToSell,
		collectValue = 0;
	public int 
		riskToSell,
		currentCollectionTime,
		timeToCollect = 0;
	public ImageIcon image;
	public String imageName;
	public ManufacturingObject(Player p){
		super(p);
	}
	public void sell(){
		player.addMoney(costToSell);
		player.addRisk(riskToSell);
	}
	public void collect(){
		player.addProduct(collectValue);
		//System.out.printf("collected %d product from %s\n",collectValue,this);
		collectValue = 0;
	}
	public void setImage(String a){
		image = new ImageIcon(a);
	}
	public ImageIcon getImage(){
		return image;
	}
	abstract public void cook();
}