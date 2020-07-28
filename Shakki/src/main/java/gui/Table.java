package gui;

import javax.swing.*;  
import java.awt.*;

public class Table extends JFrame {
    
    JPanel gamePanel = new JPanel();
    JButton b = new JButton("Hello world!");
    Color dark = Color.BLACK;
    Color light = Color.WHITE;
    private static final Table INSTANCE = new Table();
    
    public Table() {
        super("Chess");
        setSize(800, 800);
        setResizable(true);
        
        gamePanel.add(b);
        repaint();
        add(gamePanel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public Table get() {
        return this.INSTANCE;
    }
//    
//    public void visible() {
//        System.out.println("Frame haetaan");
//        gameFrame.setVisible(true);
//    }
//    
    @Override
    public void paint(Graphics g) {
        System.out.println("Piirretään");
        super.paintComponents(g);
        g.setColor(dark);
        g.fillRect(0, 0, 100, 100);
    }
}
