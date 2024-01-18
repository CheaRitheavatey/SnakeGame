//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyAdapter;
//import java.util.Random;
//import java.util.random.*;
//
//public class snakePanel extends JPanel implements ActionListener {
//    static final int Screen_width = 600;
//    static final int Screen_height = 600;
//    static final int unit_size = 25;
//    static final int game_units = (Screen_width * Screen_height)/unit_size;
//    static final int delay = 75;
//
//    final int x[] = new int[game_units];
//    final int y[] = new int[game_units];
//
//    int body_part = 6;
//    int apple_eat;
//    int apple_x;
//    int apple_y;
//    char direction = 'r';
//    boolean running = false;
//    Timer timer;
//    Random random;
//    snakePanel() {
//        random = new Random();
//        this.setPreferredSize(new Dimension(Screen_width,Screen_height));
//        this.setBackground(Color.BLACK);
//        this.setFocusable(true);
//        this.addKeyListener(new MyKeyAdapter());
//        this.requestFocus();
//        Startgame();
//    }
//
//    public void Startgame() {
//        newApple();
//        running = true;
//        timer = new Timer(delay,this);
//        timer.start();
//    }
//
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        draw(g);
//    }
//
//    public void draw(Graphics g) {
//        if (running) {
//            for (int i = 0; i < Screen_height / unit_size; i++) {
//                g.drawLine(i * unit_size, 0, i * unit_size, Screen_height);
//                g.drawLine(0, i * unit_size, Screen_width, i * unit_size);
//            }
//            g.setColor(Color.red);
//            g.fillOval(apple_x, apple_y, unit_size, unit_size);
//
//            for (int i = 0; i < body_part; i++) {
//                if (i == 0) {
//                    g.setColor(Color.green);
//                    g.fillRect(x[i], y[i], unit_size, unit_size);
//                } else {
//                    g.setColor(new Color(45, 180, 0));
//                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//                    g.fillRect(x[i], y[i], unit_size, unit_size);
//                }
//            }
//            g.setColor(Color.red);
//            g.setFont(new Font("Times New Roman",Font.BOLD,30));
//            FontMetrics metrics = getFontMetrics(g.getFont());
//            g.drawString("Score:"+apple_eat,(Screen_width - metrics.stringWidth("Score:"+apple_eat))/2,g.getFont().getSize());
//        }
//        else {
//            gameOver(g);
//        }
//    }
//    public void newApple() {
//        apple_x = random.nextInt((int)Screen_width/unit_size) * unit_size;
//        apple_y = random.nextInt((int)Screen_height/unit_size) * unit_size;
//    }
//
//    public void move() {
//        for (int i = body_part; i > 0; i--) {
//            x[i] = x[i-1];
//            y[i] = y[i-1];
//        }
//        switch (direction) {
//            case 'u':
//                y[0] = y[0] - unit_size;
//                break;
//            case 'd':
//                y[0] = y[0] + unit_size;
//                break;
//            case 'l':
//                x[0] = x[0] - unit_size;
//                break;
//            case 'r':
//                x[0] = x[0] + unit_size;
//                break;
//        }
//    }
//
//    public void checkApple() {
//        if ((x[0] == apple_x) && (y[0] == apple_y)) {
//            body_part ++;
//            apple_eat++;
//            newApple();
//        }
//    }
//
//    public void checkCollision() {
//        // check if head collide with body
//        for (int i = body_part; i > 0; i--) {
//            if ((x[0] == x[i]) && (y[0] == y[i])) {
//                running = false;
//            }
//        }
//        // check if head touch left border
//        if (x[0] < 0) {
//            running = false;
//        }
//        // check if head touch right border
//        if (x[0] > Screen_width) {
//            running = false;
//        }
//        // check if head touch top border
//        if (y[0] < 0) {
//            running = false;
//        }
//        // check if head touch down border
//        if (y[0] > Screen_height) {
//            running = false;
//        }
//        if (!running)
//            timer.stop();
//    }
//
//    public void gameOver(Graphics g) {
//        g.setColor(Color.red);
//        g.setFont(new Font("Times New Roman",Font.BOLD,30));
//        FontMetrics metrics = getFontMetrics(g.getFont());
//        g.drawString("Score:"+apple_eat,(Screen_width - metrics.stringWidth("Score:"+apple_eat))/2,g.getFont().getSize());
//
//        g.setColor(Color.red);
//        g.setFont(new Font("Times New Roman",Font.BOLD,75));
//        FontMetrics metric = getFontMetrics(g.getFont());
//        g.drawString("Game Over",(Screen_width - metrics.stringWidth("Game Over"))/4,Screen_height/2);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (running) {
//            move();
//            checkApple();
//            checkCollision();
//        }
//        repaint();
//    }
//
//    public class MyKeyAdapter extends KeyAdapter {
//        @Override
//        public void keyPressed(KeyEvent e) {
//            switch (e.getKeyCode()) {
//                case KeyEvent.VK_UP:
//                    if (direction != 'd')
//                        direction = 'u';
//                    break;
//                case KeyEvent.VK_DOWN:
//                    if (direction != 'u')
//                        direction = 'd';
//                    break;
//                case KeyEvent.VK_LEFT:
//                    if (direction != 'r')
//                        direction = 'l';
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    if (direction != 'l')
//                        direction = 'r';
//                    break;
//            }
//        }
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Random;

public class snakePanel extends JPanel implements ActionListener {
    static final int Screen_width = 600;
    static final int Screen_height = 600;
    static final int unit_size = 25;
    static final int game_units = (Screen_width * Screen_height) / unit_size;
    static final int delay = 75;

    final int x[] = new int[game_units];
    final int y[] = new int[game_units];

    int body_part = 6;
    int apple_eat;
    int apple_x;
    int apple_y;
    char direction = 'r';
    boolean running = false;
    Timer timer;
    Random random;

    snakePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(Screen_width, Screen_height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.requestFocus();
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            for (int i = 0; i < Screen_height / unit_size; i++) {
                g.drawLine(i * unit_size, 0, i * unit_size, Screen_height);
                g.drawLine(0, i * unit_size, Screen_width, i * unit_size);
            }
            g.setColor(Color.red);
            g.fillOval(apple_x, apple_y, unit_size, unit_size);

            for (int i = 0; i < body_part; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unit_size, unit_size);
                } else {
                    g.setColor(new Color(72, 156, 149, 121));
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], unit_size, unit_size);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score:" + apple_eat, (Screen_width - metrics.stringWidth("Score:" + apple_eat)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        apple_x = random.nextInt((int) Screen_width / unit_size) * unit_size;
        apple_y = random.nextInt((int) Screen_height / unit_size) * unit_size;
    }

    public void move() {
        for (int i = body_part; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'u':
                y[0] = y[0] - unit_size;
                break;
            case 'd':
                y[0] = y[0] + unit_size;
                break;
            case 'l':
                x[0] = x[0] - unit_size;
                break;
            case 'r':
                x[0] = x[0] + unit_size;
                break;
        }
    }

    public void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            body_part++;
            apple_eat++;
            newApple();
        }
    }

    public void checkCollision() {
        // check if head collide with body
        for (int i = body_part; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }
        // check if head touches the borders
        if (x[0] < 0 || x[0] >= Screen_width || y[0] < 0 || y[0] >= Screen_height) {
            running = false;
        }
        if (!running)
            timer.stop();
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score:" + apple_eat,(Screen_width - metrics.stringWidth("Score:" + apple_eat)) / 2, g.getFont().getSize());

        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.BOLD, 75));
        FontMetrics metric = getFontMetrics(g.getFont());
        g.drawString("Game Over", (Screen_width - metrics.stringWidth("Game Over")) / 4, Screen_height / 2);

        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        FontMetrics retryMetrics = getFontMetrics(g.getFont());
        g.drawString("Press Enter to Retry", (Screen_width - retryMetrics.stringWidth("Press Enter to Retry")) / 2, Screen_height / 2 + 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (!running && e.getKeyCode() == KeyEvent.VK_ENTER) {
                resetGame();
            } else {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != 'd')
                            direction = 'u';
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 'u')
                            direction = 'd';
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != 'r')
                            direction = 'l';
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'l')
                            direction = 'r';
                        break;
                }
            }
        }
    }

    public void resetGame() {
        body_part = 6;
        apple_eat = 0;
        direction = 'r';
        running = true;
        timer.start();
        newApple();
        resetSnakePosition();
    }

    public void resetSnakePosition() {
        for (int i = 0; i < body_part; i++) {
            x[i] = 0;
            y[i] = 0;
        }
    }
}