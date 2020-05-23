package Players.Hunter;

import java.awt.image.BufferedImage;

import Players.Player;

public class Hunter extends Player {
    private String skill;

    public Hunter(BufferedImage img, String name) {
        super(100, 100, 70, 120, 120, 100, name, "Hunter", 0, 51, 0, img);
        this.skill = "arrows";
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
                + "<h2 style=\"align:'center'; color: yellow;\">\"LET ME, I'LL SHOOT FROM WHERE I STAND.\"</h2>" + "<p>"
                + "Bowmen embrace dexterity for powerful attacks. They are superior in<br />"
                + "long-range attacks in battles.<br />" + "<br /><br /><br />" + "</p>"

                + "<ul>" + "<li>hp: " + getHp() + "</li>" + "<li>strength: " + getStrength() + "</li>" + "<li>mana: "
                + getMana() + "</li>" + "<li>speed: " + getSpeed() + "</li>" + "<li>skill: " + this.skill + "</li>"
                + "<li>xp: " + getXp() + "</li>" + "<li>level: " + getLevel() + "</li>" + "</ul>" + "</body>"
                + "</html>";
        return about;
    }
}