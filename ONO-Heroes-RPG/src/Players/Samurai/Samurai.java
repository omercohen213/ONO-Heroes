package Players.Samurai;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Players.Player;
import Players.PlayerSprite;
import Players.Shot;

public class Samurai extends Player {
    private String skill;
    private int ammo;
    private int manaCost = 2; // this is temporary for all players for only fire attack
    private ArrayList<Shot> Shots;// Holds number of Shots on screen
    private int shotDirX = 1; // shot direction; starts right as the player starts standing right
    private double posX;


    public Samurai(BufferedImage img, String name) {
        super(100, 100, 60, 100, 100, 3, "omercohen213", "Samurai", 0, 51, 1000, img);
        this.skill = "speed";
        Shots = new ArrayList<Shot>();// j
        ammo = 100;
        posX = 150;

    }
//
//	public void setSamuraiSprite(PlayerSprite playerSprite) {
//		samuraiSprite = playerSprite;
//	}

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
                + getMana() + "</li>" + "<li>speed: " + getSpeed() + "</li>" + "<li>skill: " + this.skill + "</li>"
                + "<li>xp: " + getXp() + "</li>" + "<li>level: " + getLevel() + "</li>" + "</ul>" + "</body>"
                + "</html>";
        return about;
    }

    public void basicAttack() {
        if (ammo > 0) {
            if (getMana()>=manaCost) {
                // chooses which image to use according to player's direction

                if (this.shotDirX == 1)
                    this.getPlayerSprite().setCurrentPlayerImg(this.getPlayerSprite().getAttackRightImage());
                else
                    this.getPlayerSprite().setCurrentPlayerImg(this.getPlayerSprite().getAttackLeftImage());
                this.getPlayerSprite().setCurrentPlayerImg(this.getPlayerSprite().getCurrentPlayerImg().getScaledInstance(140, 100, java.awt.Image.SCALE_SMOOTH));

                setMana(getMana() - manaCost);
                ammo--;

                //player.setMana(0);

                // randomize a number and a boolean to determine whether the shot goes up or
                // down and how fast
                Random r = new Random();
                double rndDirY = r.nextDouble() * (r.nextBoolean() ? -1 : 1);
                Shot shot = new Shot((posX + 100), (this.getPlayerSprite().getY() + 30), shotDirX, this, rndDirY, this.getPlayerSprite());
                Shots.add(shot);
            }
        }

    }

    public int getAmmo() {
        return ammo;
    }

    public ArrayList<Shot> getShots() {
        return Shots;
    }

}
