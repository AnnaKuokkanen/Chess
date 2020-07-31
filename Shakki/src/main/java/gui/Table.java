package gui;

import domain.pieces.*;
import javax.swing.*;  
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Table extends JFrame {

    Color dark = Color.BLACK;
    Color light = Color.WHITE;
    int width;
    int height;
    Piece[][] locations;
    Pieces pieces = new Pieces();
    
    public Table(int height, int width) {
        pieces.setLocations();
        locations = pieces.getLocations();
        this.height = height;
        this.width = width;
        setTitle("Chess");
        //System.out.println("Konstruktori");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(height, width);
        setResizable(true);
        repaint();
        
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        //System.out.println("Piirretään");
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    g.setColor(dark);
                } else {
                    g.setColor(light);
                }
                int rectHeight = height/8;
                int rectWidth = width/8;
                g.fillRect(rectHeight * i, rectWidth * j, rectHeight, rectWidth);
                if(locations[i][j] instanceof King) {
                    
                }
            }
        }
        g.drawImage(findPiece(), 10, 10, this);
    }
    
    public final Image findPiece(Strig file) {
        try {
            final BufferedImage image = ImageIO.read(new File("resources/BKing.png"));
            final ImageIcon ic = new ImageIcon(image);
            final JLabel imageLabel = new JLabel(ic);
            //System.out.println("Palautetaan label");
            return image;
        } catch (final IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Palautetaan null");
        return null;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
