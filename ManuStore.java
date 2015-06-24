import javax.swing.*;
import java.awt.*;
public class ManuStore extends JPanel{
	public ManuStoreItem[] objects = new ManuStoreItem[20];
	public ManuStore(Player p){
		super(new GridLayout(20,1));
		setPreferredSize(new Dimension(400,2000));

		objects[0]= new ManuStoreItem(new KitchenSink(p));
		ManuStoreItem sink = objects[0];
		sink.give();
		add(sink);
		objects[1]= new ManuStoreItem(new BackyardShed(p));
		ManuStoreItem shed = objects[1];
		add(shed);
		objects[2]= new ManuStoreItem(new RV(p));
		ManuStoreItem rv = objects[2];
		add(rv);
		for (int i=3;i<20;i++){
			objects[i]=new ManuStoreItem(new BackyardShed(p));
			add(objects[i]);
			objects[i].setVisible(false);
		}
	}
}