import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.InputMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.KeyboardFocusManager;
public class BBFrame extends JFrame{
	private Game game;
	private MainScreen mainScreen;
	public BBFrame(){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setJMenuBar(new BBMenuBar());

		mainScreen=new MainScreen(this);
		game = mainScreen.getGame();
		game.setBBFrame(this);

		add(mainScreen,BorderLayout.CENTER);

		setSize(1200,900);
		setMaximumSize(new Dimension(1920,1080));
	}
	public Game getGame(){
		return game;
	}
}