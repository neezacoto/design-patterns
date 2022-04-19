import javax.swing.Icon;
import java.awt.Graphics;

import javax.swing.JComponent;
import java.awt.*;

public class SquareAdapter extends JComponent{
    private Icon icon;

    public SquareAdapter() {
        this.icon = new SquareIcon();
    }

    public SquareAdapter(Icon icon) {
        this.icon = icon;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        SquareIcon gIcon = (SquareIcon) icon;
        g.setColor(gIcon.getColor());
        g.fillRect(0, 0, gIcon.getIconWidth(), gIcon.getIconHeight());

        g.setColor(Color.BLACK);
        g.drawRect( 0 , 0, gIcon.getIconWidth() ,gIcon.getIconHeight());
        g.dispose();
    }

    
}
