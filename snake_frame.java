import javax.swing.*;

public class snake_frame extends JFrame {
    snake_frame() {
        this.add(new snakePanel());
        this.setTitle("snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
