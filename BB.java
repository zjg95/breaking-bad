public class BB{
	public static void main(String[] args)
	{
		BBFrame frame = new BBFrame();
		frame.setVisible(true);
		Game game = frame.getGame();
		game.start();
	}
}