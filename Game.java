public class Game{
	private Player[] players;
	private Map map;
	private boolean status;
	private BBFrame frame;
	public Game(Map m){
		map = m;
		status = true;
		players = new Player[1];
		for (int i= 0;i<players.length;i++){
			System.out.println("creating new player");
			players[i]= new Player(this,i);
		}
	}
	public Player getPlayer(int x){
		return players[x];
	}
	public void setBBFrame(BBFrame f){
		frame = f;
	}
	public void start(){
		for (Player p:players){
			System.out.println("Starting player");
			p.start();
		}
		//(new Thread(new StartGame())).start();
	}
	private class StartGame implements Runnable{
		public void run(){
				while(status){
				try{Thread.sleep(1000);}catch(InterruptedException e){}
				for (Player p:players)
					p.cook();
				for (Player p:players)
					p.collect();
			}
		}
	}
}