import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class CompositeIcon implements Icon {
    private int height;
    private int width;
    private ArrayList<Icon> icons;


    public CompositeIcon() {
        this.height = 32;
        this.width = 32;
    }


    @Override
    public int getIconHeight() { return height; }

    @Override
    public int getIconWidth() { return width; }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        JPanel panel = new JPanel();    
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(x +1 ,y + 1,width -2 ,height -2);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(x +1 ,y + 1,width -2 ,height -2);
        g2d.dispose();
        
    }

    public void addIcon(Icon icon,int x, int y){
        
    }
}