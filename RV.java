public class RV extends ManufacturingObject{
	private int fuel = 99;
	private int riskToDestroy = -18;
	public RV(Player p){
		super(p);
		name = "RV";
		imageName= "rv";
		description1 = "A beat up old RV. Great for the  ";
		description2 = "mobile cooking needs!";
		value = 3;

		costToGet = 200;
		costToSell = 90;

		timeToBuild = 10;
		timeToCollect = 3;
		currentCollectionTime = 3;

		riskToGet = 20;
		riskToSell = -10;

		setImage(imageName+"1.png");
	}
	public void cook(){
		if ((fuel--)>0){
			if ((currentCollectionTime--)>0){
				//System.out.println("more time needed");
			}
			else{
				collectValue+=value;
				System.out.printf("RV Cooked %d meth\n",value);
				currentCollectionTime=timeToCollect;
			}
		}
		else System.out.println("RV out of fuel.");
	}
	public String toString(){
		return "RV";
	}
}