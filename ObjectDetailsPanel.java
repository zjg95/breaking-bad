import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ObjectDetailsPanel extends JPanel{
	private final JLabel imageLabel;
	private final ObjectListPanel listPanel;
	private JLabel
		name=new JLabel("RV"), description=new JLabel("A beat up old RV"),
		baseRisk=new JLabel("+100 Risk"), baseCost=new JLabel("Cost: $200"),
		stats=new JLabel("Yields 3 meth every 3 seconds.");
	private final JButton buy = new JButton("Buy");
	private final JLayeredPane layeredPane;
	private int
		cost=200, risk=200, time=3;
	private GameObject object;
	public ObjectDetailsPanel(ObjectListPanel a){
		super();
		listPanel = a;
		layeredPane=new JLayeredPane();
		imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon("rv1.png"));

		layeredPane.add(imageLabel,new Integer(0));
		imageLabel.setBounds(0,0,100,100);

		layeredPane.add(name,new Integer(0));
		name.setBounds(110,10,200,15);

		layeredPane.add(description,new Integer(0));
		description.setBounds(110,30,200,15);

		layeredPane.add(baseRisk,new Integer(0));
		baseRisk.setBounds(110,50,100,15);

		layeredPane.add(baseCost,new Integer(1));
		baseCost.setBounds(210,50,100,15);

		layeredPane.add(stats,new Integer(0));
		stats.setBounds(110,70,250,15);

		layeredPane.add(buy,new Integer(1));
		buy.setBounds(360,25,75,30);

		layeredPane.setPreferredSize(new Dimension(450,100));
		add(layeredPane);

		buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("you just bought some shit");
				listPanel.buy(new RV(listPanel.player));
			}
		});
	}
}