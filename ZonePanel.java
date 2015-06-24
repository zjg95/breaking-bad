import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
public class ZonePanel extends JPanel{
	private final MapPanel map;
	private Color color;
	private JLabel image;
	private Zone zone;
	private JPanel[] panels = new JPanel[4];
	private boolean selected = false;
	private final JPanel middle;
	private GridBagConstraints c;
	public ZonePanel(Zone z,MapPanel m){
		super(new GridBagLayout());

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		image = new JLabel();
		image.setPreferredSize(new Dimension(250,250));

		zone = z;
		zone.setZonePanel(this);
		map = m;
		SectorType type = z.getType();
		JPanel temp;
		switch (type){
			case NUL: color = Color.white; break;
			case RUR: color = Color.orange; break;
			case BUS: color = Color.pink; break;
			case RES: color = Color.green; break;
			case URB: color = Color.magenta; break;
			case DWN: color = Color.gray; break;
			case SLM: color = Color.yellow; break;
			case IND: color = Color.gray; break;
			default: color = Color.orange; break;
		}

		addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            	if (selected){
            		selected=false;
            		//zone.deselect();
            	}
            	else{
            		selected=true;
            		zone.select();
            	}
            }
        });

		int x = 0;
		temp = new JPanel();
		temp.setPreferredSize(new Dimension(25,300));
		//temp.setOpaque(false);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		temp.setBackground(color);
		panels[x++]=temp;
		add(temp,c);

		temp = new JPanel();
		temp.setPreferredSize(new Dimension(25,300));
		//temp.setOpaque(false);
		c.gridx = 2;
		c.gridy = 0;
		temp.setBackground(color);
		panels[x++]=temp;
		add(temp,c);

		temp = new JPanel();
		temp.setPreferredSize(new Dimension(250,25));
		//temp.setOpaque(false);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		temp.setBackground(color);
		panels[x++]=temp;
		add(temp,c);

		temp = new JPanel();
		temp.setPreferredSize(new Dimension(250,25));
		//temp.setOpaque(false);
		c.gridx = 1;
		c.gridy = 2;
		temp.setBackground(color);
		panels[x++]=temp;
		add(temp,c);

		middle = new JPanel();
		middle.setPreferredSize(new Dimension(250,250));
		middle.setBackground(color);
		//middle.setOpaque(false);
		c.gridx = 1;
		c.gridy = 1;
		add(middle,c);

	}
	public void setImage(ImageIcon a){
		if (a==null){
			remove(image);
			add(middle,c);
		}
		else{
			remove(middle);
			add(image,c);
		}
		image.setIcon(a);
		image.repaint();
		image.revalidate();
		repaint();
		revalidate();
	}
	public void select(Zone z){
		for (JPanel p:panels){
			p.setBackground(Color.green);
			p.setOpaque(true);
		}
		middle.setBackground(Color.green);
		//middle.setOpaque(true);
		map.setSelected(z);
	}
	public void deselect(){
		for (JPanel p:panels){
			p.setBackground(color);
			p.setOpaque(false);
		}
		middle.setBackground(color);
		//middle.setOpaque(false);
	}
}