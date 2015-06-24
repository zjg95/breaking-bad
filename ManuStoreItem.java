import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
public class ManuStoreItem extends JPanel{
	public JButton buy = new JButton("Buy");
	public JLabel
		image = new JLabel(new ImageIcon("rv.png")),
		name = new JLabel("Default",SwingConstants.CENTER),
		description = new JLabel("A beat up old RV that is",SwingConstants.LEFT),
		description2 = new JLabel("great for cooking on the go!",SwingConstants.LEFT),
		production = new JLabel("Cooks 3 meth in 7 seconds",SwingConstants.CENTER),
		totalOwned = new JLabel("0",SwingConstants.CENTER),
		cost = new JLabel("Cost: $200",SwingConstants.CENTER),
		risk = new JLabel("Risk: +12%",SwingConstants.CENTER);
	public int
		totalOwnedI=0,
		yieldI=3,
		timeI=7,
		costI=200,
		riskI=12;
	public GridBagConstraints c = new GridBagConstraints();
	public ManufacturingObject object;
	public Player player;

	public void setInfo(ManufacturingObject o){
		object=o;
		costI=object.costToGet;
		riskI=object.riskToGet;

		name.setText(object.name);
		image.setIcon(new ImageIcon(object.imageName+".png"));
		cost.setText("Cost: $"+costI);
		risk.setText("Risk: "+riskI+"%");
		timeI=o.timeToCollect;
		yieldI=o.value;
		production.setText("Cooks "+yieldI+" meth in "+timeI+" seconds");
		description.setText(object.description1);
		description2.setText(object.description2);
	}

	public ManuStoreItem(ManufacturingObject a){
		super(new GridBagLayout());
		setPreferredSize(new Dimension(350,100));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		setInfo(a);

		name.setFont (name.getFont ().deriveFont (24.0f));
		totalOwned.setFont (totalOwned.getFont ().deriveFont (55.0f));
		//totalOwned.setVisible(false);
		image.setPreferredSize(new Dimension(100,100));
		image.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		c.gridx=0;c.gridy=0;
		c.gridheight=5;
		add(image,c);

		c.gridx+=2;
		c.gridheight=1;
		c.gridwidth=1;
		add(name,c);

		c.gridx--;
		c.gridy++;
		c.gridwidth=3;
		add(description,c);
		c.gridy++;
		add(description2,c);

		c.gridy++;
		add(production,c);

		c.gridy++;
		c.gridwidth=1;
		add(cost,c);

		c.gridx+=2;
		add(risk,c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx++;
		c.gridy=0;
		c.gridheight=4;
		c.gridwidth=3;
		c.weightx=1.0;
		c.weighty=1.0;
		add(totalOwned,c);

		c.weightx=0.0;
		c.weighty=0.0;
		c.gridy+=4;
		c.gridx+=2;
		c.gridheight=1;
		c.gridwidth=1;
		add(buy,c);
		buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buy();
			}
		});
		buy.setEnabled(false);
	}
	public void buy(){
		give();
	}
	public void give(){
		totalOwnedI++;
		totalOwned.setText(""+totalOwnedI);
		//totalOwned.setVisible(true);
	}
	public void selected(boolean a){
		buy.setEnabled(a);
	}
}