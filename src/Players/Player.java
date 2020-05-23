package Players;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Player {
    private String name;
    public String className;
    private int hp;
    private int maxHp;
    private int strength;
    private int mana;
    private int maxMana;
    private int speed;
    private int xp;
    private int levelUpXp; // xp needed for level up
    private int [] levelsXp = new int [10]; // levels xp array required for level up
    private int money;
    private int level;

    public PlayerSprite getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(PlayerSprite playerSprite) {
        this.playerSprite = playerSprite;
    }

    private PlayerSprite playerSprite;



    private BufferedImage img;


    public Player(int hp,int maxHp, int strength, int mana,int maxMana, int speed,
                  String name, String className,int xp,int levelUpXp, int money, BufferedImage img) {

        this.level = 1;
        this.hp = hp;
        this.maxHp= maxHp;
        this.strength = strength;
        this.mana = mana;
        this.maxMana=maxMana;
        this.speed = speed;
        this.name = name;
        this.className = className;
        this.money=money;
        this.xp = 0;
        this.levelUpXp=51;
//		int [] levelsXp,
//		this.levelsXp=levelsXp;
        this.img = img;

    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money=money;
    }

    public int getlevelUpXp() {
        return levelUpXp;
    }

    public void setlevelUpXp(int levelUpXp) {
        this.levelUpXp=levelUpXp;
    }

    //******fix formula not working*********
    public void initLevelsXpArray () {
        levelUpXp = 10; //xp needed for level 2
        levelsXp[0]=levelUpXp;
        int i;
        for (i=1; i<=levelsXp.length-1; i++) {
            levelUpXp*=2; //1/6*(Level-1)*(Level)*(1.1*(2*Level-1)+150)-(Level-1)/2+Level/20
            levelsXp[i]=levelUpXp;
        }
    }

    public void levelManager(int xpReward){
        xp+=xpReward;
        if (xp >= levelsXp[level-1])
            playerLevelUp();
    }

    public void playerLevelUp() {
        xp = xp % levelsXp[level-1];
        level++;
        levelUpXp=levelsXp[level];

    }

    public void basicAttack() {
        return;
    }


}
