import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TesterOne {
    

    public TesterOne() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();    
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setLayout(new GridLayout(0, 1));

        CompositeIcon parent = new CompositeIcon("parent");
        parent.addIcon(new SquareIcon(), 20, 10);
        parent.addIcon(new SquareIcon(), 5, 5);
        parent.addIcon(new CircleIcon(), 0, 40);

        CompositeIcon group1 = new CompositeIcon("child");
        group1.addIcon(new SquareIcon(), 7, 5);
        group1.addIcon(new CircleIcon(), 3, 20);

        parent.addIcon(group1, 80, 80);
        
        panel.add(new JLabel(parent));
        



        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Part One Test");
        frame.pack();
        frame.setVisible(true);
        
        
    }
    public static void main(String[] args) {
        
        new TesterOne();
    }
}
