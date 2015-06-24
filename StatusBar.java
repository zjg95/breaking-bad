import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
public class StatusBar extends JPanel{
	public JLabel
		money=new JLabel("$ 127,000,000",SwingConstants.CENTER),
		product=new JLabel("978 u",SwingConstants.CENTER),
		risk= new JLabel("0.00%",SwingConstants.CENTER),
		riskRate=new JLabel("0.00% p/s",SwingConstants.CENTER),
		level=new JLabel("0",SwingConstants.CENTER),
		quality=new JLabel("Meth Level",SwingConstants.CENTER),
		grossProduction=new JLabel("0 u p/s",SwingConstants.CENTER),
		netProduction=new JLabel("0 u p/s",SwingConstants.CENTER),
		netDistribution=new JLabel("$ 0 p/s",SwingConstants.CENTER),
		grossDistribution=new JLabel("$ 0 p/s",SwingConstants.CENTER);
	public Player player;

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
	public void updateMoney(){
		money.setText("$ "+player.getMoney());
	}
		public void updateNetGross(){
			netProduction.setText(""/*+player.netProduction*/);
			grossProduction.setText(""/*+player.grossProduction*/);
			netDistribution.setText(""/*+player.netDistribution*/);
			grossDistribution.setText(""/*+player.grossDistribution*/);
		}
	public void updateProduct(){
		product.setText(""+player.getProduct()+"u");
	}
	public void updateRisk(){
		risk.setText("Risk: "+getRisk()+"%");
	}
	public void updateAll(){
		updateMoney();
		updateProduct();
		updateRisk();
	}

	public StatusBar(Player p){
		super(new GridBagLayout());
		setPreferredSize(new Dimension(350,150));
		//setBackground(Color.pink);

		player=p;
		GridBagConstraints c = new GridBagConstraints();

		money.setForeground(Color.green);
		money.setFont (money.getFont ().deriveFont (35.0f));
		product.setForeground(Color.blue);
		product.setFont (product.getFont ().deriveFont (35.0f));
		risk.setForeground(Color.magenta);
		risk.setFont (risk.getFont ().deriveFont (35.0f));
		level.setForeground(Color.blue);
		level.setFont (level.getFont ().deriveFont (35.0f));

		c.gridx=0;c.gridy=0;
		c.anchor=GridBagConstraints.CENTER;
		c.gridwidth=2;
		c.weightx=0.5;
		c.weighty=0.0;
		c.fill=GridBagConstraints.BOTH;
		add(money,c);

		c.gridy++;
		c.weightx=0.25;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor=GridBagConstraints.LINE_END;
		add(grossDistribution,c);

		c.gridx++;
		c.anchor=GridBagConstraints.LINE_START;
		add(netDistribution,c);

		c.gridx=0;
		c.gridy++;
		c.gridwidth=2;
		c.weightx=0.5;
		c.weighty=0.0;
		add(product,c);

		c.gridy++;
		c.weightx=0.25;
		c.gridwidth=1;
		c.gridheight=1;
		c.anchor=GridBagConstraints.LINE_END;
		add(grossProduction,c);

		c.gridx++;
		c.anchor=GridBagConstraints.LINE_START;
		add(netProduction,c);

		c.gridx=0;
		c.gridy++;
		c.gridwidth=2;
		c.weightx=0.5;
		c.weighty=0.0;
		add(risk,c);

		c.gridy++;
		c.gridwidth=2;
		c.gridheight=1;
		c.anchor=GridBagConstraints.CENTER;
		add(riskRate,c);

		c.gridx=2;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=1;
		c.weightx=0.5;
		c.weighty=0.0;
		add(level,c);

		c.gridy++;
		//c.gridheight=1;
		add(quality,c);
	}
}