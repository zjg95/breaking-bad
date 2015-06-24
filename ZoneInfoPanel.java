import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ZoneInfoPanel extends JPanel{
	private SelectionBox sbox;
	private final JLabel icon;
	private JTextField 
		name, name2, risk, risk2,
		time, time2;
	public JButton
		buy, sell;
	public ZoneInfoPanel(Zone z){
		super(new GridBagLayout());
		setSize(300,100);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;

		c.gridheight = 4;
		c.gridwidth = 1;
		icon = new JLabel(new ImageIcon("rv.png"));
		icon.setPreferredSize(new Dimension(100,100));
		add(icon,c);

		c.gridy = 0;
		c.gridx = 1;
		c.gridheight = 1;
		c.gridwidth = 2;
		name2 = new JTextField(z.getName());
		name2.setPreferredSize(new Dimension(200,25));
		name2.setEditable(false);
		add(name2,c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		risk = new JTextField("Risk: "+z.getRisk()+"%");
		risk.setPreferredSize(new Dimension(100,25));
		risk.setEditable(false);
		add(risk,c);

		c.gridx = 2;
		c.gridy = 1;
		risk2 = new JTextField("Yield: 2%");
		risk2.setPreferredSize(new Dimension(100,25));
		risk2.setEditable(false);
		add(risk2,c);
		
		c.gridx = 1;
		c.gridy = 2;
		time = new JTextField("Time: "+z.getCollectionTime()+"%");
		time.setPreferredSize(new Dimension(100,25));
		time.setEditable(false);
		add(time,c);

		c.gridx = 2;
		c.gridy = 2;
		time2 = new JTextField("Fuel: 62%");
		time2.setPreferredSize(new Dimension(100,25));
		time2.setEditable(false);
		add(time2,c);

		c.gridx = 1;
		c.gridy = 3;
		buy = new JButton("Buy");
		buy.setPreferredSize(new Dimension(100,25));
		add(buy,c);
		buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("buy clicked");
				sbox.showPurchase();
			}
		});

		c.gridx = 2;
		c.gridy = 3;
		sell = new JButton("Sell");
		sell.setPreferredSize(new Dimension(100,25));
		add(sell,c);
		sell.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sell.setEnabled(false);
				buy.setEnabled(true);
				setImage(null);
				sbox.sell();
			}
		});
		sell.setEnabled(false);
	}
	public void setSelectionBox(SelectionBox a){
		sbox = a;
	}
	public void setImage(ImageIcon a){
		icon.setIcon(a);
		icon.repaint();
		icon.revalidate();
	}
}