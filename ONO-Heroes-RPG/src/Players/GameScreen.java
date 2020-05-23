package Players;

import Enemies.Enemy;
import Enemies.EnemySprite;
import Enemies.Zombie.Zombie;
import Players.Samurai.Samurai;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameScreen extends JPanel implements ActionListener, Runnable {
    private PlayerSprite PlayerSprite;
    private EnemySprite EnemySprite;
    private Image bgImg; // background
    private Timer time;
    private Thread JumpAnimation;
    private Player player;
    private Enemy enemy;
    private boolean stopAnimation = false;
    private double regenMana;
    private BufferedImage hpIcon = null, mpIcon= null, moneyIcon= null,runSmokeRight=null,runSmokeLeft=null;
    private int count = 0;
    private boolean doTime=false;



    public static void startGame(JFrame frame, Player player) throws IOException {
        JFrame Gameframe = frame;
        Gameframe.add(new GameScreen(player));
        Gameframe.setTitle("2-D Test Game");
        Gameframe.setSize(1000, 1000);
        Gameframe.setResizable(false);
        Gameframe.setVisible(true);
        Gameframe.setLocationRelativeTo(null);
        Gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GameScreen(Player player) throws IOException {
        this.player = player;
        this.enemy = new Zombie("Zombie");
        PlayerSprite = new PlayerSprite(player);
        this.player.setPlayerSprite(PlayerSprite);
        EnemySprite = new EnemySprite(enemy);

        player.initLevelsXpArray();
        try {
            runSmokeLeft = ImageIO.read(new File("src/Images/runSmokeLeft.png"));
            runSmokeRight = ImageIO.read(new File("src/Images/runSmokeRight.png"));
            hpIcon = ImageIO.read(new File("src/Images/hpIcon.png"));
            mpIcon = ImageIO.read(new File("src/Images/mpIcon.png"));
            moneyIcon = ImageIO.read(new File("src/Images/moneyIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // call this when player kills an enemy
        int xpReward = 15; // should be: xpReward = (enemy.getXpRward);
        player.levelManager(xpReward);

        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("src/Images/Background_desert.jpg");
        bgImg = i.getImage();
        bgImg = bgImg.getScaledInstance(1200, 1000, java.awt.Image.SCALE_SMOOTH);
        time = new Timer(2, this); // sets the delay between each JumpAnimation
        time.start();

    }

    public void samuraiShots() {
        Samurai samurai= (Samurai) (PlayerSprite.getPlayer());
        ArrayList<Shot> Shots = samurai.getShots();
        for (int i = 0; i < Shots.size(); i++) {

            Shot shot = (Shot) Shots.get(i);// This is how to get a current element in an arrayList
            if (shot.getVisible() == true) {
                shot.move();
            } else
                Shots.remove(i);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (PlayerSprite.getPlayer() instanceof Samurai)
            samuraiShots();
        PlayerSprite.move();
        EnemySprite.move();
        repaint();
    }

    public void paint(Graphics g) {
        if (PlayerSprite.getDirY() == 1 && stopAnimation == false) {
            JumpAnimation = new Thread(this);
            JumpAnimation.start();
            stopAnimation = true;
        }

        count++;
        if (count == 100) {
            count = 0;
            if (player.getMana() < 100) {
                player.setMana(player.getMana() + 1);
            }
        }

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;



//		if ((PlayerSprite.getX() - 590) % 2400 == 0)
//			PlayerSprite.setFirstImagePos(0);

        g2d.drawImage(bgImg, 685 - PlayerSprite.getSecondImagePos(), 0, null);
        if (PlayerSprite.getX() > 300) {
            g2d.drawImage(bgImg, 1200 - PlayerSprite.getFirstImagePos(), 0, null);
        }
        g2d.drawImage(PlayerSprite.getImage(), (int) PlayerSprite.getPosX(), (int) PlayerSprite.getY(), null);
        g2d.drawImage(EnemySprite.getImage(), (int) EnemySprite.getPosX(), (int) EnemySprite.getY(), null);
        //System.out.printf("\n"+ "Zombie x: " + EnemySprite.getX()+ " Zombie posX: " + EnemySprite.getPosX());

//		if (PlayerSprite.getDirX() < 0) {
//			g2d.drawImage(bgImg, 685 - PlayerSprite.getSecondImagePos(), 0, null);
//			g2d.drawImage(PlayerSprite.getImage(), (int) PlayerSprite.getPosX(), (int) PlayerSprite.getY(), null);
//		}



        if(PlayerSprite.getPlayer() instanceof Samurai)// In case of Samorai
        {
            PlayerSprite.getPlayer().setPlayerSprite(PlayerSprite);
            ArrayList<Shot> Shots = ((Samurai) (PlayerSprite.getPlayer())).getShots();

            for (int i = 0; i < Shots.size(); i++) {
                Shot shot = (Shot) Shots.get(i);// This is how to get a current element in an arrayList
                g2d.drawImage(shot.getImage(), (int) shot.getX(), (int) shot.getY(), null);
            }

            g2d.drawString("Ammo left: " + ((Samurai)PlayerSprite.getPlayer()).getAmmo(), 800, 50); // In case of Samorai
        }

        int index =(int)PlayerSprite.getPosX()+100;
        if (PlayerSprite.isRunningLeft()) {
            doTime=true;
            g2d.drawImage(runSmokeLeft,index, (int)PlayerSprite.getY()+10,200,100, null);

        }

        else if (PlayerSprite.isRunningRight()) {
            g2d.drawImage(runSmokeRight,(int)PlayerSprite.getPosX()-100, (int)PlayerSprite.getY()+10,200,100, null);
        }

//		g2d.drawImage(EnemySprite.getImage(), 650, 650, null);
//		System.out.println(EnemySprite.getX());



        // show player ammo left
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        g2d.setColor(Color.black);


        // player hp bar
        g2d.drawImage(hpIcon, 2, 27, 20, 20, null);
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        g2d.drawString("HP: ", 20, 45);
        g2d.setColor(new Color(34, 139, 34));
        g2d.fillRoundRect(60, 15, 150, 40, 15, 15);
        g2d.setColor(Color.green);
        g2d.fillRoundRect(60, 15, 150 * player.getHp() / player.getMaxHp(), 40, 20, 20);
        g2d.setColor(Color.black);
        g2d.drawString(player.getHp() + " / " + player.getMaxHp(), 70, 40);

        //player mana bar
        g2d.drawImage(mpIcon, 2, 77, 18, 18, null);
        g2d.drawString("MP:", 22, 90);
        g2d.setColor(new Color(0, 0, 205));
        g2d.fillRoundRect(60, 65, 150, 40, 15, 15);
        g2d.setColor(new Color(65, 105, 225));
        g2d.fillRoundRect(60, 65, 150 * player.getMana() / player.getMaxMana(), 40, 15, 15);
        g2d.setColor(Color.black);
        g2d.drawString(player.getMana() + " / " + player.getMaxMana(), 70, 90);

        // regen Mana - instead of count
        /*
         * if (player.getMaxMana()>player.getMana()) { while
         * (player.getMaxMana()>player.getMana()) { player.setMana(player.getMana()+1);
         * if (player.getMana() + regenMana >= player.getMaxMana())
         * player.setMana(player.getMaxMana()); } // timer.schedule(new TimerTask() {
         * // @Override // public void run() { // // Your database code here // } // },
         * 2*1000);
         *
         *
         * }
         */

        // player xp bar
        g2d.drawString("LVL: " + player.getLevel(), 5, 140);
        g2d.setColor(new Color(138, 43, 226));
        g2d.fillRoundRect(70, 115, 150, 40, 15, 15);
        g2d.setColor(new Color(153, 50, 204));
        g2d.fillRoundRect(70, 115, player.getXp() * 2, 40, 15, 15);
        g2d.setColor(Color.black);
        g2d.drawString(player.getXp() + " / " + player.getlevelUpXp(), 80, 140);

        // player money
        g2d.drawImage(moneyIcon, 60, 165, 20, 20, null);
        g2d.setColor(Color.black);
        g2d.drawString("Money:   " + player.getMoney(), 5, 180);

        // player name above the playerSprite
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g2d.setColor(Color.black);
        g2d.drawString(player.getName(), (int) PlayerSprite.getPosX(), (int) PlayerSprite.getY() - 20);

    }

    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            PlayerSprite.keyReleased(e);
            EnemySprite.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            PlayerSprite.keyPressed(e);
            EnemySprite.keyPressed(e);
        }
    }

    boolean isJumping = true;
    boolean stoppedJumping = false;

    public void cycle() {
        boolean sprint = PlayerSprite.getKeys()[KeyEvent.VK_SHIFT];
        if (isJumping) {
            PlayerSprite.setY(PlayerSprite.getY() - 2);
            if (PlayerSprite.isRunningRight())
                PlayerSprite.setRunningRight(false);
            else if (PlayerSprite.isRunningLeft())
                PlayerSprite.setRunningLeft(false);
        }
        if (PlayerSprite.getY() == 550)
            isJumping = false;
        if (!isJumping && PlayerSprite.getY() <= 650) {
            PlayerSprite.setY(PlayerSprite.getY() + 2);
            if (PlayerSprite.getY() == 650) {
                stoppedJumping = true;
                if (!PlayerSprite.isRunningRight() && sprint)
                    PlayerSprite.setRunningRight(true);
                else if (!PlayerSprite.isRunningLeft() && sprint)
                    PlayerSprite.setRunningLeft(true);
            }
        }
    }

    public void run() {
        while (!stoppedJumping) {
            cycle();
            int sleep = 10;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

        }
        stoppedJumping = false; // set to false so player can jump again after falling
        isJumping = true; // set to true so player can jump again after falling
        stopAnimation = false; // set to false so JumpAnimation can start again after the end of the loop
    }

}