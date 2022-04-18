import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;


public class SquareIcon implements Icon{
    private int height;
    private int width;

    public SquareIcon() {
        this.height = 32;
        this.width = 32;
    }
    @Override
    public int getIconHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getIconWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.RED);
        g2d.fillRect(x +1 ,y + 1,width -2 ,height -2);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(x +1 ,y + 1,width -2 ,height -2);
        g2d.dispose();

    }

}
