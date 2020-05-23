package Enemies;

import java.awt.image.BufferedImage;

public abstract class Enemy {
    private String name;
    private int hp;
    private int strength;
    private int speed;
    private int level;
    public String className;
    private BufferedImage img;

    public Enemy(int hp, int strength, int mana, int speed, int level, String className, String name,
                 BufferedImage img) {
        super();
        this.hp = hp;
        this.strength = strength;
        this.speed = speed;
        this.level = level;
        this.name = name;
        this.className = className;
        this.img = img;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
