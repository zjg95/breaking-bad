import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TestPanel extends JPanel{
	public Player player;
	public JLayeredPane layeredPane = new JLayeredPane();
	public JLabel money;
	public JLabel product;
	public JLabel risk;

	private String getRisk(){
		String a;
		int x = player.getRisk();
		int four = (x%10); x/=10;
		int three = (x%10); x/=10;
		int two = (x%10); x/=10;
		int one = (x%10);
		a=""+three+"."+four;
		if (two>0)
			a=two+a;
		if (one>0)
			a=one+a;
		return a;
	}
	public void buy(){
		player.buyManuObject(new RV(player));
		money.setText("Money: $"+player.getMoney());
		risk.setText("Risk: "+getRisk()+"%");
	}
	public void sell(){
		player.sellManuObject(null);
		money.setText("Money: $"+player.getMoney());
		risk.setText("Risk: "+getRisk()+"%");
	}
	public void collect(){
		player.collect();
		product.setText("Product: "+player.getProduct());
		risk.setText("Risk: "+getRisk()+"%");
	}
	public void cook(){
		player.cook();
		risk.setText("Risk: "+getRisk()+"%");
	}

	public TestPanel(Player p){
		super();
		player = p;
		layeredPane.setPreferredSize(new Dimension(300,300));

		money = new JLabel("Money: $"+player.getMoney());
		product = new JLabel("Product: "+player.getProduct());
		risk = new JLabel("Risk: "+getRisk()+"%");

		JButton buy = new JButton("Buy RV");
		buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buy();
			}
		});

		JButton sell = new JButton("Sell RV");
		sell.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sell();
			}
		});

		JButton collect = new JButton("Collect");
		collect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				collect();
			}
		});

		JButton cook = new JButton("cook");
		cook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cook();
			}
		});

		layeredPane.add(money,new Integer(0));
		money.setBounds(0,0,100,20);

		layeredPane.add(product,new Integer(0));
		product.setBounds(0,20,100,20);

		layeredPane.add(risk,new Integer(0));
		risk.setBounds(0,40,100,20);

		layeredPane.add(buy,new Integer(0));
		buy.setBounds(100,0,101,30);

		layeredPane.add(sell,new Integer(0));
		sell.setBounds(100,30,101,30);

		layeredPane.add(collect,new Integer(0));
		collect.setBounds(100,60,101,30);

		layeredPane.add(cook,new Integer(0));
		cook.setBounds(100,90,101,30);

		add(layeredPane);
		(new Thread(new StartGame())).start();
	}
	private class StartGame implements Runnable{
		public void run(){
			while(true){
				try{Thread.sleep(1000);}catch(InterruptedException e){}
				cook();
				collect();
				money.setText("Money: $"+player.getMoney());
				risk.setText("Risk: "+getRisk()+"%");
			}
		}
	}
}