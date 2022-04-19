import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

public class CompositeIcon implements Icon {
    private int height;
    private int width;
    private String name;
    private ArrayList<IconLeaf> icons;


    public CompositeIcon(String name) {
        this.height = 50;
        this.width = 50;
        this.name = name;
        icons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    @Override
    public int getIconHeight() { return height; }

    @Override
    public int getIconWidth() { return width; }

    public ArrayList<IconLeaf> getLeaves() {
        return icons;
    }

    /**
     * 0 height
     * 1 width
     * @param list the current composite list
     * @param sizes the max sizes in component
     * @return
     */
    private int[] maxTraversal( ArrayList<IconLeaf> list, int[] sizes) {
        for(int i = 0; i < list.size(); i++) {
            Icon index = list.get(i).getIcon();

            if(index instanceof CompositeIcon) {
                int[] temp = maxTraversal(((CompositeIcon) index).getLeaves(), sizes);
                

                if (sizes[0] < temp[0]) 
                sizes[0] =  temp[0];
                if (sizes[1] < temp[1]) 
                    sizes[1] =  temp[1];
            }
            if (sizes[0]  < list.get(i).getY()) 
                sizes[0] =  list.get(i).getY() + list.get(i).getIcon().getIconHeight();
            if (sizes[1] < list.get(i).getX()) 
                sizes[1] =  list.get(i).getX() + list.get(i).getIcon().getIconWidth();
        
        }

        return sizes;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2d = (Graphics2D) g.create();
        int[] sizes = maxTraversal(this.icons, new int[] {this.height, this.width});

        g2d.setColor(Color.WHITE);
        g2d.fillRect(x +1 ,y + 1,sizes[1],sizes[0] );

        g2d.setColor(Color.BLACK);
        g2d.drawRect(x +1 ,y + 1,sizes[1],sizes[0] );
        g2d.dispose();

        
        for(IconLeaf i : icons) {
            i.getIcon().paintIcon(c, g, i.getX() + x, i.getY() + y);
        }
    }

    public void addIcon(Icon icon,int x, int y){
        icons.add(new IconLeaf(icon, x, y));
    }

    /**
     * Creates Icon Objects with desired render coordinates
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

    @Override 
    public String toString() {
        String str = name + ":";

        for(IconLeaf i : icons) {
            str += "\n" + i.getIcon().getClass().getSimpleName() + "x: " + i.getX() + "y: ";
        }

        return str;

    }
}