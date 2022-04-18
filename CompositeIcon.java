import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class CompositeIcon implements Icon {
    private int height;
    private int width;
    private ArrayList<IconLeaf> icons;


    public CompositeIcon() {
        this.height = 50;
        this.width = 50;
        icons = new ArrayList<>();
    }


    @Override
    public int getIconHeight() { return height; }

    @Override
    public int getIconWidth() { return width; }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(x +1 ,y + 1,width -2 ,height -2);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(x +1 ,y + 1,width -2 ,height -2);
        g2d.dispose();

        
        for(IconLeaf i : icons) {
            i.getIcon().paintIcon(c, g, i.getX(), i.getY());
            System.out.println(i.getX());
        }
        

    }

    public void addIcon(Icon icon,int x, int y){
        icons.add(new IconLeaf(icon, x, y));
    }

    /**
     * Creates Icon Objects to be stored
     */
    private class IconLeaf{
        private Icon icon;
        private int x;
        private int y;

        public IconLeaf(Icon icon, int x, int y) {
            this.icon = icon;
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public Icon getIcon() {
            return icon;
        }

    }
}