abstract public class GameObject{
	public Player player;
	public String name;
	public int costToGet,value=0;
	public int timeToBuild,riskToGet = 0;
	public String description1="default1",description2="default2";
	public GameObject(Player p){
		player = p;
	}
	public abstract void collect();
}