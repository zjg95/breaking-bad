public class BackyardShed extends ManufacturingObject{
	private int fuel = 100;
	private int riskToDestroy = -18;
	public BackyardShed(Player p){
		super(p);
		name = "Old Shed";
		imageName= "bys";
		description1 = "A cheap storage shed with decent";
		description2 = "ventelation and a light bulb.";
		value = 2;

		costToGet = 20;
		costToSell = 90;

		timeToBuild = 10;
		timeToCollect = 5;
		currentCollectionTime = 5;

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
				System.out.printf("BackyardShed Cooked %d meth\n",value);
				currentCollectionTime=timeToCollect;
			}
		}
		else System.out.println("BackyardShed out of fuel.");
	}
	public String toString(){
		return "BackyardShed";
	}
}