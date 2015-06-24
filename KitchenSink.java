public class KitchenSink extends ManufacturingObject{
	public KitchenSink(Player p){
		super(p);
		name = "Sink";
		imageName = "sink";
		description1 = "Your kitchen sink. Definitely not the";
		description2 = "best method, but it's a start!";
		value = 1;

		costToGet = 0;
		costToSell = 0;

		timeToBuild = 0;
		timeToCollect = 7;
		currentCollectionTime = 7;

		riskToGet = 1;
		riskToSell = -1;
	}
	public void cook(){
		if ((currentCollectionTime--)>0){
			//System.out.println("more time needed");
		}
		else{
			collectValue+=value;
			System.out.printf("KitchenSink Cooked %d meth\n",value);
			currentCollectionTime=timeToCollect;
		}
	}
	public String toString(){
		return "KitchenSink";
	}
}