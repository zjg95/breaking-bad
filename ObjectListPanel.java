import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ObjectListPanel extends JPanel{
	private final ObjectDetailsPanel[] objects;
	private final SelectionBox sbox;
	private final JButton back;
	private final int maxObjects = 20;
	public final Player player;
	public ObjectListPanel(SelectionBox a){
		super(new GridLayout(21,1,10,10));
		objects = new ObjectDetailsPanel[maxObjects];
		sbox = a;
		player = a.player;
		back = new JButton("Back");
		add(back);
		for (int i = 0;i<maxObjects;i++){
			objects[i]=new ObjectDetailsPanel(this);
			add(objects[i]);
		}
		setPreferredSize(new Dimension(450,2100));

		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				back();
			}
		});
	}
	public void back(){
		sbox.hidePurchase();
	}
	public void buy(ManufacturingObject a){
		player.buyManuObject(a);
		sbox.buy(a);
		back();
	}
}