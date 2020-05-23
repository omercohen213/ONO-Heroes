package Players;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Shots {
    private double x, y; //CURRENT location of the Shot
    private double distance;
    private double dirY; // random Y axis direction
    private int dirX; // X axis direction
    private Image img;
    private PlayerSprite PlayerSprite;
    private boolean visible; // sets weather THIS Shot is visible or not


    public Shots(double startX, double startY, int dirX, Player player, double dirY, PlayerSprite PlayerSprite) {
        ImageIcon newShot;
        this.dirX = dirX;
        if (this.dirX == 1)
            newShot = new ImageIcon("src\\Players\\" + player.getClassName() + "\\Images\\shot_right.png");
        else
            newShot = new ImageIcon("src\\Players\\" + player.getClassName() + "\\Images\\shot_left.png");
        img = newShot.getImage();
        img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        x = startX;
        y = startY;
        distance=0;
        visible = true;
        this.dirY=dirY;
        this.PlayerSprite=PlayerSprite;
        //System.out.print(dirY);
        System.out.print(PlayerSprite.getY());
    }

    public double getX() {
        return x;
    }

    public boolean getVisible() {
        return visible;
    }

    public double getY() {
        return y;
    }

    public Image getImage() {
        return img;
    }

    // Just like the move class in PlayerSprite class...
    public void move() {
        if (dirX == 1) {
            x = x + 2;
            y+=dirY;
            distance +=2;
            if (distance > 500 || y>720 || y<PlayerSprite.getY()-650+ 620)
                visible = false;

        } else {
            x = x - 2;
            y+=dirY;
            distance +=2;
            if (distance > 500 || y>720 || y<PlayerSprite.getY()-650+ 620)
                visible = false;
        }
    }



}