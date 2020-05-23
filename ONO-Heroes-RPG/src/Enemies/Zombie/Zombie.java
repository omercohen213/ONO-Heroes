package Enemies.Zombie;

import Enemies.Enemy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Zombie extends Enemy {

    public Zombie(String name) throws IOException {
        super(100, 100, 60, 100, 100, "Zombie",name, ImageIO.read(new File("src\\Images\\EnemyZombie.jpg")));
    }


    @Override
    public String toString() {
        String about = "<html>" + "<body style=\"font-family:'Courier';\">"
                + "<h2 style=\"align:'center'; color: yellow;\">\"Samurai, THE INSTRUMENT OF REVENGE!\"</h2>" + "<p>"
                + "Unknown to many, the Samurai isnן¿½t one of evil nature, but rather, like many<br />"
                + "other heroes, his purpose in life is to stop the ever present evil that<br />"
                + "threatens the very existence of the world. Sadly, The path of a Samurai is a lonely<br />"
                + "one. Always observing from his dark abode, the Samurai keeps an eye on<br />"
                + "evil, waiting for the right moment to strike before disappearing once against into<br />"
                + "the shadows.<br />" + "</p>"

                + "<ul>" + "<li>hp: " + getHp() + "</li>" + "<li>strength: " + getStrength() + "</li>" + "<li>mana: "
                + "</li>" + "<li>speed: " + getSpeed() + "</li>" + "<li>skill: "
                + "<li>level: " + getLevel() + "</li>" + "</ul>" + "</body>"
                + "</html>";
        return about;
    }
}
