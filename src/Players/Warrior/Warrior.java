package Players.Warrior;

import java.awt.image.BufferedImage;

import Players.Player;

public class Warrior extends Player {
    private String skill;

    public Warrior(BufferedImage img, String name) {
        super(200, 200, 100, 100, 100, 20, name, "Warrior", 0, 51, 0, img);
        this.skill = "strongHit";
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
                + "<h2 style=\"align:'center'; color: yellow;\">\"I'LL BE RIGHT IN FRONT, FOLLOW MY LEAD!\"</h2>"
                + "<p>" + "Warriors display awesome attacking prowess and everlasting stamina.<br />"
                + "They show their worth fighting up close and personal.<br />" + "<br /><br /><br />" + "</p>"

                + "<ul>" + "<li>hp: " + getHp() + "</li>" + "<li>strength: " + getStrength() + "</li>" + "<li>mana: "
                + getMana() + "</li>" + "<li>speed: " + getSpeed() + "</li>" + "<li>skill: " + this.skill + "</li>"
                + "<li>xp: " + getXp() + "</li>" + "<li>level: " + getLevel() + "</li>" + "</ul>" + "</body>"
                + "</html>";
        return about;
    }
}
