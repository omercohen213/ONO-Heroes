package MainClasses;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Program {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePanel game = new GamePanel(frame);
        frame.add(game);

        try{
            Image icon = ImageIO.read(new File("src\\Images\\Warrior.png"));
            frame.setIconImage(icon);
        }catch(Exception e){
            e.printStackTrace();
        }

        frame.setTitle("Adventures");
        frame.setSize(game.getWidth(),game.getHeight());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
