
import javax.swing.JFrame;

public class TesterTwo {
    public static void main(String[] args) {
        JFrame aWindow = new JFrame();
        aWindow.setBounds(30, 30, 300, 300);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        SquareAdapter square = new SquareAdapter( new SquareIcon());
    
        aWindow.add(square);
    
        aWindow.setVisible(true);
      }
}
