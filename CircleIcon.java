import java.awt.Component;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;


public class CircleIcon implements Icon{
    private int height;
    private int width;
    private String name;
    private Color color = Color.CYAN;

    public CircleIcon() {
        this.height = 32;
        this.width = 32;
        this.name = "Circle";
    }
    @Override
    public int getIconHeight() {
        
        return height;
    }

    @Override
    public int getIconWidth() {
        
        return width;
    }

    public String getName() {
        return name;
    }


    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillOval(x +1 ,y + 1,width -2 ,height -2);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x +1 ,y + 1,width -2 ,height -2);
        g2d.dispose();

    }

}
