import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class BBMenuBar extends JMenuBar{
	public BBMenuBar(){
		super();
		JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        JMenu gsa = new JMenu("File");
        gsa.setMnemonic(KeyEvent.VK_G);
        gsa.getAccessibleContext().setAccessibleDescription(
                "This menu manages stores");
        add(gsa);

            JMenuItem gsaItem1 = new JMenuItem("Import",
                                     KeyEvent.VK_N);
            gsaItem1.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            gsaItem1.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            gsa.add(gsaItem1);

            JMenuItem gsaItem2 = new JMenuItem("Export",
                                     KeyEvent.VK_N);
            gsaItem2.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_2, ActionEvent.ALT_MASK));
            gsaItem2.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            gsa.add(gsaItem2);

        JMenu store = new JMenu("Upgrades");
        store.setMnemonic(KeyEvent.VK_S);
        store.getAccessibleContext().setAccessibleDescription(
                "This menu manages stores");
        add(store);

            JMenuItem storeItem = new JMenuItem("New Store",
                                     KeyEvent.VK_N);
            storeItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            storeItem.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            store.add(storeItem);

            JMenuItem storeItem2 = new JMenuItem("Store Manager",
                                     KeyEvent.VK_N);
            storeItem2.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            storeItem2.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            store.add(storeItem2);

        JMenu employee = new JMenu("People");
        employee.setMnemonic(KeyEvent.VK_E);
        employee.getAccessibleContext().setAccessibleDescription(
                "This menu manages employees");
        add(employee);

            JMenuItem employeeItem = new JMenuItem("New Employee",
                                     KeyEvent.VK_N);
            employeeItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            employeeItem.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            employee.add(employeeItem);

            JMenuItem employeeItem2 = new JMenuItem("Employee Manager",
                                     KeyEvent.VK_N);
            employeeItem2.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            employeeItem2.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            employee.add(employeeItem2);

        //Build the first menu.
        menu = new JMenu("Menu bar");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        ImageIcon icon = new ImageIcon("image.png");
        menuItem = new JMenuItem("Both text and icon", icon);
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(icon);
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);
	}
}        