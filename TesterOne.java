import javax.swing.*;
import java.awt.*;

/**
 * Class is responsible for testing the composite design pattern from Icon to CompositeIcon to SquareIcon to CircleIcon
 */
public class TesterOne {
    
    /**
     * Tests Composite functionality
     */
    public TesterOne() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();    
        panel.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
        panel.setLayout(new GridLayout(0, 1));

        //composite icon that contains three icons, and two composites
        CompositeIcon parent = new CompositeIcon("parent");
        parent.addIcon(new SquareIcon(), 20, 10);
        parent.addIcon(new SquareIcon(), 50, 5);
        parent.addIcon(new CircleIcon(), 0, 40);

        //composite contained within the parent, with two icons
        CompositeIcon group1 = new CompositeIcon("child");
        group1.addIcon(new SquareIcon(), 7, 5);
        group1.addIcon(new CircleIcon(), 3, 20);

        //composite contained within the parent, with one icon
        CompositeIcon group3 = new CompositeIcon("child");
        group3.addIcon(new SquareIcon(), 7, 5);

        //adding composites to parent
        parent.addIcon(group1, 80, 80);
        parent.addIcon(group3, 20, 65);
        
        //adding parent to a JLabel
        panel.add(new JLabel(parent));
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Part One Test");
        frame.setVisible(true);
        
        
    }
    //When running the code, enlargen the window to view full result
    public static void main(String[] args) {
        
        new TesterOne();
    }
}
