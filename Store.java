import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Store extends JPanel{
	public Player player;
	public GridBagConstraints c = new GridBagConstraints();
	public JButton
		manufacturing = new JButton("Manufacturing (1)"),
		distribution = new JButton("Distribution (0)"),
		information = new JButton("Information"),
		previous=manufacturing;
	public StorePane storePane;
	public Store(Player p){
		super(new GridBagLayout());
		player = p;
		storePane = new StorePane(p);
		c.fill =GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		setBackground(Color.black);

		manufacturing.setPreferredSize(new Dimension(150,25));
		manufacturing.setBackground(Color.CYAN);
		manufacturing.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (storePane.setContents(0)){
					manufacturing.setBackground(Color.CYAN);
					previous.setBackground(UIManager.getColor("Button.background")); 
					previous=manufacturing;
					manufacturing.setText("Manufacturing");
				}
			}
		});
		distribution.setPreferredSize(new Dimension(150,25));
		distribution.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (storePane.setContents(1)){
					distribution.setBackground(Color.CYAN);
					previous.setBackground(UIManager.getColor("Button.background")); 
					previous=distribution;
					distribution.setText("Distribution");
				}
			}
		});
		information.setPreferredSize(new Dimension(150,25));
		information.setEnabled(false);

		c.gridx=0;
		c.gridy=0;
		c.weightx=1.0;

		c.weighty=0.00;
		add(manufacturing,c);

		c.gridx++;
		add(distribution,c);

		c.gridx++;
		add(information,c);

		c.gridx=0;
		c.gridy++;
		add(new JButton("Test"),c);

		c.gridx++;
		c.gridwidth=2;
		add(new JButton("Test 2"),c);

		c.gridx=0;
		c.gridy++;
		c.gridwidth=4;
		c.weighty=1.0;
		add(storePane,c);
	}
}