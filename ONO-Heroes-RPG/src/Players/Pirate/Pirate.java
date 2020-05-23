package Players.Pirate;

import java.awt.image.BufferedImage;

import Players.Player;

public class Pirate extends Player {
    private String skill;

    public Pirate(BufferedImage img, String name) {
        super(120,120, 80, 60, 140,140, name,"Pirate",0, 51,0, img);
        this.skill = "hiding";
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        String about =
                "<html>"
                        + "<body style=\"font-family:'Courier';\">"
                        + "<h2 style=\"align:'center'; color: yellow;\">\"CARE TO CHALLENGE MY BULLET OR FIST?\"</h2>"
                        + "<p>"
                        + "Pirates are essentially masters of attack and defence, requiring a balance<br />"
                        + "of strength and dexterity to utilize their powers to the max.<br />"
                        + "<br /><br /><br />"
                        + "</p>"

                        + "<ul>"
                        + "<li>hp: " + getHp() + "</li>"
                        + "<li>strength: " + getStrength() + "</li>"
                        + "<li>mana: " + getMana() + "</li>"
                        + "<li>speed: " + getSpeed() + "</li>"
                        + "<li>skill: " + this.skill + "</li>"
                        + "<li>xp: " + getXp() + "</li>"
                        + "<li>level: " + getLevel() + "</li>"
                        + "</ul>"
                        + "</body>"
                        + "</html>";
        return about;
    }
}
