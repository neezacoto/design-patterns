import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TesterOne {
    

    public TesterOne() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();    
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(new JLabel(new CompositeIcon()));



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
