package Players.Mage;

import java.awt.image.BufferedImage;

import Players.Player;

public class Mage extends Player {
    private String skill;

    public Mage(BufferedImage img, String name) {
        super(150, 150, 80, 300, 300, 10, name, "Mage", 0, 51, 0, img);
        this.skill = "fireBall";
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        String about = "<html>" + "<body style=\"font-family:'Courier';\">"
                + "<h2 style=\"align:'center'; color: yellow;\">\"PREPARE FOR SOME FLASH AND BANG!\"</h2>" + "<p>"
                + "Magicians may not have much of attacking abilities, but they can handle<br />"
                + "awesome, spectacular magic at will.<br />" + "<br /><br /><br />" + "</p>"

                + "<ul>" + "<li>hp: " + getHp() + "</li>" + "<li>strength: " + getStrength() + "</li>" + "<li>mana: "
                + getMana() + "</li>" + "<li>speed: " + getSpeed() + "</li>" + "<li>skill: " + this.skill + "</li>"
                + "<li>xp: " + getXp() + "</li>" + "<li>level: " + getLevel() + "</li>" + "</ul>" + "</body>"
                + "</html>";
        return about;
    }
}
