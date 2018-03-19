package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.BackgroundObject;
import no.aev.norway9001.MoveableObjects.Enemy;
import no.aev.norway9001.MoveableObjects.Powerups.DoubleGunPowerup;
import no.aev.norway9001.MoveableObjects.Powerups.HealthPowerupBig;
import no.aev.norway9001.MoveableObjects.Powerups.HealthPowerupSmall;
import no.aev.norway9001.MoveableObjects.Powerups.LaserPowerup;
import no.aev.norway9001.MoveableObjects.Powerups.MineSweeper;
import no.aev.norway9001.MoveableObjects.Powerups.ShieldPowerup;
import no.aev.norway9001.MoveableObjects.Powerups.TripleGunPowerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Aimer;
import no.aev.norway9001.MoveableObjects.ShipTypes.Bouncer;
import no.aev.norway9001.MoveableObjects.ShipTypes.DiamondShip;
import no.aev.norway9001.MoveableObjects.ShipTypes.FinalBoss;
import no.aev.norway9001.MoveableObjects.ShipTypes.FlyingSaucer;
import no.aev.norway9001.MoveableObjects.ShipTypes.HexaShip;
import no.aev.norway9001.MoveableObjects.ShipTypes.Minelayer;
import no.aev.norway9001.MoveableObjects.ShipTypes.SparkShooter;
import no.aev.norway9001.MoveableObjects.ShipTypes.SquareShip;
import no.aev.norway9001.MoveableObjects.ShipTypes.TriangleShip;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * @author Asgeir Vinkenes
 */
public final class LevelsProvider
{

    private static LevelsProvider instance;
    private ArrayList<Level> levels = new ArrayList<>();
    private Level level01;
    private Level level02;
    private Level level03;
    private Level level04;
    private Level level05;
    private Level level06;
    private Level level07;
    private Level level08;
    private Level level09;
    private Level level10;

    private LevelsProvider()
    {
        createLevels();
    }

    public static LevelsProvider getInstance()
    {
        if (instance == null)
        {
            instance = new LevelsProvider();
        }

        return instance;
    }

    private void createLevels()
    {
        levels.clear();
        String lvl01Desc = "The year is 9001.\n" +
                "The unassuming little country of Norway has taken over the world.\n" +
                "Not happy with this conquest though the stalwart Norwegians have decided that Planet Earth is not enough and are now planning on taking over the entire universe.\n" +
                "As their best fighter pilot you have been chosen to be the vanguard of this assault.\n" +
                "Your first mission is to gain full control of our own solar system.\n\n" +
                "Controls:\n" +
                "Movement: WASD/arrow keys\n" +
                "Shoot: Space";
        level01 = new Level(lvl01Desc, new Image("backgrounds/lvl01bg.png"));
        levels.add(level01);
        level01.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl01planet01.png")));
        level01.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl01planet02.png"), 0.2));

        String lvl02Desc = "Well done! The Sol system is now fully under Norwegian control.\n" +
                "Did you notice the green crosses which RAIN FROM THE SKY and heal you?\n" +
                "You will get more powerups like that here, and also a possible weapon upgrade.\n" +
                "We can now set our sights on our nearest star, the Alpha Centauri system.\n" +
                "Good luck pilot!";
        level02 = new Level(lvl02Desc, new Image("backgrounds/lvl02bg.png"));
        levels.add(level02);
        level02.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl02planet01.png")));
        level02.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl02planet02.png")));

        String lvl03Desc = "Congratulations! The Alpha Centauri system is now ours!\n" +
                "Clearly you are a capable pilot; with your skill Norway can certainly take over the entire universe.\n" +
                "Your next mission takes you to the Tau Ceti system within which Minelayers\n" +
                "have been spotted. Their mines are slow and deadly and may be tricky to see, you were warned\n" +
                "Good flying!";
        level03 = new Level(lvl03Desc, new Image("backgrounds/lvl03bg.png"));
        levels.add(level03);
        level03.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl03planet01.png")));
        level03.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl03planet02.png")));

        String lvl04Desc = "Well done! You have captured Tau Ceti. \n" +
                "We can now move on to the Rigel system. Here you will encounter a new powerup; the Shield.\n" +
                "A shield will make you invulnerable for 5 seconds and you can still shoot while under its effect.\n" +
                "Good luck pilot!";
        level04 = new Level(lvl04Desc, new Image("backgrounds/lvl04bg.png"));
        levels.add(level04);
        level04.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl04planet01.png")));
        level04.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl04planet02.png")));
        level04.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl04planet03.png")));

        String lvl05Desc = "Good job on securing the Rigel system! We can now move on to the Serious, er, Sirius System.\n" +
                "Scouts report that you will encounter a new enemy ship type here; the Bouncer.\n" +
                "It's tough as nails but it is pushed backwards every time it is so you should be able to keep it at arm's length!\n" +
                "Go get'em pilot!";
        level05 = new Level(lvl05Desc, new Image("backgrounds/lvl05bg.png"));
        levels.add(level05);
        level05.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl05planet01.png")));
        level05.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl05planet02.png")));

        String lvl06Desc = "Siriusly well done! You obviously are a very Sirius pilot.\n" +
                "Next up is Aldebaran, were our enemies appear to have come across a new type of weapon\n" +
                "which hits harder than what you are used to, so watch out for that.\n" +
                "The good news are that our scientists too have invented a new toy for you; the Minesweeper!\n" +
                "It will remove every mine on the screen when picked up.\n" +
                "Good luck!";
        level06 = new Level(lvl06Desc, new Image("backgrounds/lvl06bg.png"));
        levels.add(level06);
        level06.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl06planet01.png")));
        level06.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl06planet02.png")));

        String lvl07Desc = "Another system successfully cleared, you're getting into the groove of things!\n" +
                "The next system, Betelgeuse, once again has a new challenge for you; our enemies have\n" +
                "have begun arming their own ships with lasers! We currently have no new way of countering\n" +
                "this new menace so you are on your own. Good luck!";
        level07 = new Level(lvl07Desc, new Image("backgrounds/lvl07bg.png"));
        levels.add(level07);
        level07.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl07planet01.png"), 0.2));

        String lvl08Desc = "Good job, you dealt with the laser gunners of Betelgeuse like it was nothing!\n" +
                "Now you will be going to the Antares system where our enemies have perfected the art of putting lasers on hexagons\n" +
                "but that's nothing an ace pilot like you can't deal with, right?\n" +
                "Also our scientists have solved the problem of our enemies having access to lasers.\n" +
                "How, you might ask? Well, have a look for yourself.";
        level08 = new Level(lvl08Desc, new Image("backgrounds/lvl08bg.png"));
        levels.add(level08);
        level08.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl08planet01.png")));
        level08.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl08planet02.png")));

        String lvl09Desc = "Antares has fallen to your lasers and bullets and whatnot!\n" +
                "Things are heating up though as we conquer more and more enemy territory.\n" +
                "You are now going to Epsilon Eridani, where our enemies actually have learnt how to aim!\n" +
                "Are you prepared to be shot at directly?\n" +
                "Good luck ace!";
        level09 = new Level(lvl09Desc, new Image("backgrounds/lvl09bg.png"));
        levels.add(level09);
        level09.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl09planet01.png")));
        level09.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl09planet02.png")));

        String lvl10Desc = "Under construction";
        level10 = new Level(lvl10Desc, new Image("backgrounds/lvl10bg.png"));
        levels.add(level10);
        level10.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl10planet01.png")));
        level10.addBgObj(new BackgroundObject(new Image("backgroundObjs/lvl10planet02.png")));
    }

    public void createLevel(int levelNumber)
    {
        switch (levelNumber)
        {
            case 1:
            {
                createLevel01();
                break;
            }
            case 2:
            {
                createLevel02();
                break;
            }
            case 3:
            {
                createLevel03();
                break;
            }
            case 4:
            {
                createLevel04();
                break;
            }
            case 5:
            {
                createLevel05();
                break;
            }
            case 6:
            {
                createLevel06();
                break;
            }
            case 7:
            {
                createLevel07();
                break;
            }
            case 8:
            {
                createLevel08();
                break;
            }
            case 9:
            {
                createLevel09();
                break;
            }
            case 10:
                createLevel10();
                break;
            default:
                throw new IndexOutOfBoundsException("Invalid level number.");
        }
    }

    /**
     * Returns a level based upon its number.
     * Level numbers start at 1 (one).
     *
     * @param levelNumber The number of the level.
     * @return The specified level.
     */
    public Level getLevel(int levelNumber)
    {
        return levels.get(levelNumber - 1);
    }

    public int getNumLevels()
    {
        return levels.size();
    }

    private void createLevel01()
    {
        level01.clear();
        level01.addWave(50, SquareShip.class, 3);
        level01.addWave(1000, FlyingSaucer.class, 3);
        level01.addWave(1000, TriangleShip.class, 3);
        level01.addWave(300, SquareShip.class, 4);
        level01.addWave(1000, FlyingSaucer.class, 4);
        level01.addWave(1000, TriangleShip.class, 5);
        level01.addWave(300, SquareShip.class, 4);
        level01.addWave(1000, FlyingSaucer.class, 4);
        level01.addWave(1000, TriangleShip.class, 3);
        level01.addWave(10, TriangleShip.class, 4);
        level01.addWave(10, TriangleShip.class, 5);
        level01.addWave(200, SquareShip.class, 2);
        level01.addWave(150, SquareShip.class, 3);

        level01.addPowerups(5000, HealthPowerupSmall.class, 1);
        System.out.println("There are " + level01.getNumWaves() + " waves in this level.");
    }

    private void createLevel02()
    {
        level02.clear();
        level02.addWave(50, SquareShip.class, 2);
        level02.addWave(150, SquareShip.class, 2);
        level02.addWave(1000, FlyingSaucer.class, 2);
        level02.addWave(150, FlyingSaucer.class, 2);
        level02.addWave(1000, SquareShip.class, 3);
        level02.addWave(100, TriangleShip.class, 4);
        level02.addWave(1000, SquareShip.class, 5);
        level02.addWave(1000, FlyingSaucer.class, 5);
        level02.addWave(1000, TriangleShip.class, 1);
        level02.getWave(level02.getNumWaves() - 1).addShip(new SquareShip());
        level02.getWave(level02.getNumWaves() - 1).addShip(new FlyingSaucer());
        level02.getWave(level02.getNumWaves() - 1).addShip(new SquareShip());
        level02.getWave(level02.getNumWaves() - 1).addShip(new TriangleShip());
        level02.addWave(1000, SquareShip.class, 1);
        level02.addWave(150, FlyingSaucer.class, 2);
        level02.addWave(150, SquareShip.class, 3);
        level02.addWave(1000, TriangleShip.class, 4);
        level02.addWave(150, TriangleShip.class, 5);
        level02.addWave(150, TriangleShip.class, 6);
        level02.addWave(500, SquareShip.class, 3);
        level02.addWave(150, SquareShip.class, 3);

        level02.addPowerups(2000, HealthPowerupSmall.class, 1);
        level02.addPowerups(4000, HealthPowerupSmall.class, 1);
        level02.addPowerups(5000, DoubleGunPowerup.class, 1);
        level02.addPowerups(6000, HealthPowerupSmall.class, 1);
    }

    private void createLevel03()
    {
        level03.clear();
        level03.addWave(50, Minelayer.class, 1);
        level03.addWave(900, SquareShip.class, 3);
        level03.addWave(150, SquareShip.class, 2);
        level03.addWave(800, FlyingSaucer.class, 2);
        level03.addWave(150, FlyingSaucer.class, 2);
        level03.addWave(700, TriangleShip.class, 6);
        level03.addWave(50, TriangleShip.class, 6);
        level03.addWave(50, TriangleShip.class, 6);
        level03.addWave(800, SquareShip.class, 3);
        level03.addWave(150, SquareShip.class, 4);
        level03.addWave(150, SquareShip.class, 3);
        level03.addWave(700, Minelayer.class, 1);
        level03.addWave(200, FlyingSaucer.class, 2);
        level03.addWave(200, FlyingSaucer.class, 2);
        level03.addWave(800, SquareShip.class, 4);
        level03.addWave(150, SquareShip.class, 3);
        level03.addWave(150, SquareShip.class, 4);
        level03.addWave(1000, Minelayer.class, 2);
        level03.addWave(500, TriangleShip.class, 1);
        level03.addWave(50, TriangleShip.class, 2);
        level03.addWave(50, TriangleShip.class, 3);
        level03.addWave(50, TriangleShip.class, 4);
        level03.addWave(50, TriangleShip.class, 5);
        level03.addWave(450, SquareShip.class, 6);

        level03.addPowerups(2000, HealthPowerupSmall.class, 1);
        level03.addPowerups(3000, DoubleGunPowerup.class, 1);
        level03.addPowerups(4000, HealthPowerupSmall.class, 1);
        level03.addPowerups(6000, HealthPowerupSmall.class, 2);
        level03.addPowerups(6500, TripleGunPowerup.class, 1);
    }

    private void createLevel04()
    {
        level04.clear();
        level04.addWave(250, TriangleShip.class, 1);
        level04.addWave(25, TriangleShip.class, 2);
        level04.addWave(25, TriangleShip.class, 3);
        level04.addWave(25, TriangleShip.class, 4);
        level04.addWave(25, TriangleShip.class, 5);
        level04.addWave(25, TriangleShip.class, 6);
        level04.addWave(500, Minelayer.class, 1);
        level04.addWave(500, SquareShip.class, 3);
        level04.addWave(1000, FlyingSaucer.class, 3);
        level04.addWave(100, FlyingSaucer.class, 3);
        level04.addWave(100, FlyingSaucer.class, 3);
        level04.addWave(500, SquareShip.class, 3);
        level04.addWave(500, SquareShip.class, 4);
        level04.addWave(500, SquareShip.class, 3);
        level04.addWave(500, SquareShip.class, 4);
        level04.addWave(500, SquareShip.class, 3);
        level04.addWave(500, Minelayer.class, 2);
        level04.addWave(500, TriangleShip.class, 6);
        level04.addWave(10, TriangleShip.class, 6);
        level04.addWave(10, TriangleShip.class, 6);
        level04.addWave(10, TriangleShip.class, 6);
        level04.addWave(10, TriangleShip.class, 6);
        level04.addWave(10, TriangleShip.class, 6);
        level04.addWave(750, Minelayer.class, 1);
        level04.addWave(750, SquareShip.class, 8);
        level04.addWave(1000, FlyingSaucer.class, 4);
        level04.addWave(400, SquareShip.class, 1);
        level04.addWave(100, SquareShip.class, 2);
        level04.addWave(100, SquareShip.class, 1);
        level04.addWave(750, FlyingSaucer.class, 4);
        level04.addWave(50, FlyingSaucer.class, 4);
        level04.addWave(50, FlyingSaucer.class, 4);
        level04.addWave(50, FlyingSaucer.class, 4);
        level04.addWave(50, TriangleShip.class, 5);
        level04.addWave(10, TriangleShip.class, 5);
        level04.addWave(10, TriangleShip.class, 5);
        level04.addWave(10, TriangleShip.class, 5);
        level04.addWave(10, TriangleShip.class, 5);

        level04.addPowerups(50, ShieldPowerup.class, 1);
        level04.addPowerups(1000, DoubleGunPowerup.class, 1);
        level04.addPowerups(3000, HealthPowerupSmall.class, 1);
        level04.addPowerups(3100, HealthPowerupSmall.class, 2);
        level04.addPowerups(3500, LaserPowerup.class, 1);
        level04.addPowerups(4500, DoubleGunPowerup.class, 1);
        level04.addPowerups(5500, LaserPowerup.class, 1);
        level04.addPowerups(6000, HealthPowerupSmall.class, 2);
        level04.addPowerups(6100, HealthPowerupSmall.class, 1);
        level04.addPowerups(7000, DoubleGunPowerup.class, 2);
        level04.addPowerups(8000, LaserPowerup.class, 2);
        level04.addPowerups(9000, HealthPowerupSmall.class, 2);
        level04.addPowerups(9100, HealthPowerupSmall.class, 2);
        level04.addPowerups(9500, TripleGunPowerup.class, 1);
        level04.addPowerups(9800, ShieldPowerup.class, 1);

        ArrayList<Minelayer> minelayers = new ArrayList<>();

        for (int i = 0; i < level04.getNumWaves(); i++)
        {
            for (Enemy currentEnemy : level04.getWave(i).getShips())
            {
                if (currentEnemy.getClass() == Minelayer.class)
                {
                    minelayers.add((Minelayer) currentEnemy);
                }
            }
        }

        for (int i = 0; i < minelayers.size(); i++)
        {
            if (i % 2 == 0)
                minelayers.get(i).toggleDirection();
        }
    }

    private void createLevel05()
    {
        level05.clear();
        level05.addWave(50, Bouncer.class, 2);
        level05.addWave(800, SquareShip.class, 3);
        level05.addWave(500, SquareShip.class, 3);
        level05.addWave(500, SquareShip.class, 3);
        level05.addWave(1200, TriangleShip.class, 6);
        level05.addWave(10, TriangleShip.class, 5);
        level05.addWave(10, TriangleShip.class, 4);
        level05.addWave(10, TriangleShip.class, 3);
        level05.addWave(10, TriangleShip.class, 2);
        level05.addWave(10, TriangleShip.class, 1);
        level05.addWave(200, Bouncer.class, 3);
        level05.addWave(800, FlyingSaucer.class, 4);
        level05.addWave(500, TriangleShip.class, 3);
        level05.addWave(20, TriangleShip.class, 3);
        level05.addWave(20, TriangleShip.class, 3);
        level05.addWave(300, Minelayer.class, 3);
        level05.addWave(500, SquareShip.class, 1);
        level05.addWave(200, SquareShip.class, 2);
        level05.addWave(200, SquareShip.class, 3);
        level05.addWave(200, SquareShip.class, 2);
        level05.addWave(200, SquareShip.class, 1);
        level05.addWave(800, Bouncer.class, 2);
        level05.addWave(200, Bouncer.class, 4);
        level05.addWave(500, FlyingSaucer.class, 10);
        level05.addWave(600, SquareShip.class, 6);
        level05.addWave(150, SquareShip.class, 6);
        level05.addWave(150, SquareShip.class, 6);
        level05.addWave(150, SquareShip.class, 6);
        level05.addWave(150, SquareShip.class, 6);
        level05.addWave(150, SquareShip.class, 6);
        level05.addWave(800, Minelayer.class, 3);
        level05.addWave(800, Bouncer.class, 3);
        level05.addWave(300, Bouncer.class, 3);
        level05.addWave(300, Bouncer.class, 3);
        level05.addWave(500, Minelayer.class, 4);
        level05.addWave(200, Minelayer.class, 4);
        level05.addWave(200, TriangleShip.class, 8);
        level05.addWave(30, TriangleShip.class, 8);
        level05.addWave(30, TriangleShip.class, 8);
        level05.addWave(400, SquareShip.class, 5);
        level05.addWave(200, SquareShip.class, 5);
        level05.addWave(200, SquareShip.class, 5);
        level05.addWave(200, SquareShip.class, 5);
        level05.addWave(200, SquareShip.class, 5);

        level05.addPowerups(1500, HealthPowerupSmall.class, 2);
        level05.addPowerups(2000, DoubleGunPowerup.class, 1);
        level05.addPowerups(3000, HealthPowerupSmall.class, 3);
        level05.addPowerups(3100, HealthPowerupSmall.class, 2);
        level05.addPowerups(4000, HealthPowerupSmall.class, 3);
        level05.addPowerups(4500, DoubleGunPowerup.class, 1);
        level05.addPowerups(5000, HealthPowerupSmall.class, 3);
        level05.addPowerups(5100, ShieldPowerup.class, 1);
        level05.addPowerups(7000, HealthPowerupSmall.class, 2);
        level05.addPowerups(7300, HealthPowerupSmall.class, 3);
        level05.addPowerups(8000, LaserPowerup.class, 1);
        level05.addPowerups(8250, LaserPowerup.class, 2);
        level05.addPowerups(8500, ShieldPowerup.class, 1);
        level05.addPowerups(9000, HealthPowerupSmall.class, 4);
        level05.addPowerups(10500, TripleGunPowerup.class, 2);
        level05.addPowerups(11000, HealthPowerupSmall.class, 3);
        level05.addPowerups(11500, HealthPowerupSmall.class, 3);

        ArrayList<Minelayer> minelayers = new ArrayList<>();

        for (int i = 0; i < level05.getNumWaves(); i++)
        {
            for (Enemy currentEnemy : level05.getWave(i).getShips())
            {
                if (currentEnemy.getClass() == Minelayer.class)
                {
                    minelayers.add((Minelayer) currentEnemy);
                }
            }
        }

        for (int i = 0; i < minelayers.size(); i++)
        {
            if (i % 2 == 0)
                minelayers.get(i).toggleDirection();
        }
    }

    private void createLevel06()
    {
        level06.clear();
        level06.addWave(50, SparkShooter.class, 2);
        level06.addWave(150, SquareShip.class, 3);
        level06.addWave(150, SquareShip.class, 4);
        level06.addWave(150, SquareShip.class, 5);
        level06.addWave(700, SparkShooter.class, 3);
        level06.addWave(500, Minelayer.class, 4);
        level06.addWave(1200, Bouncer.class, 2);
        level06.addWave(400, SquareShip.class, 3);
        level06.addWave(400, SquareShip.class, 4);
        level06.addWave(1000, SparkShooter.class, 1);
        level06.addWave(800, TriangleShip.class, 7);
        level06.addWave(20, TriangleShip.class, 6);
        level06.addWave(20, TriangleShip.class, 5);
        level06.addWave(20, TriangleShip.class, 4);
        level06.addWave(20, TriangleShip.class, 3);
        level06.addWave(20, TriangleShip.class, 2);
        level06.addWave(20, TriangleShip.class, 1);
        level06.addWave(200, SparkShooter.class, 3);
        level06.addWave(200, SquareShip.class, 3);
        level06.addWave(200, SquareShip.class, 3);
        level06.addWave(800, TriangleShip.class, 7);
        level06.addWave(20, TriangleShip.class, 6);
        level06.addWave(20, TriangleShip.class, 5);
        level06.addWave(20, TriangleShip.class, 4);
        level06.addWave(20, TriangleShip.class, 3);
        level06.addWave(20, TriangleShip.class, 2);
        level06.addWave(20, TriangleShip.class, 1);
        level06.addWave(200, Minelayer.class, 3);
        level06.addWave(200, Minelayer.class, 2);
        level06.addWave(200, Minelayer.class, 3);
        level06.addWave(800, SquareShip.class, 5);
        level06.addWave(200, SparkShooter.class, 2);
        level06.addWave(200, SquareShip.class, 5);
        level06.addWave(200, SquareShip.class, 6);
        level06.addWave(200, SquareShip.class, 5);
        level06.addWave(200, SparkShooter.class, 3);
        level06.addWave(200, SparkShooter.class, 4);
        level06.addWave(200, SparkShooter.class, 2);
        level06.addWave(200, Bouncer.class, 4);

        level06.addPowerups(1500, HealthPowerupSmall.class, 4);
        level06.addPowerups(2500, DoubleGunPowerup.class, 2);
        level06.addPowerups(3000, MineSweeper.class, 2);
        level06.addPowerups(3500, HealthPowerupSmall.class, 4);
        level06.addPowerups(4000, LaserPowerup.class, 2);
        level06.addPowerups(4500, DoubleGunPowerup.class, 2);
        level06.addPowerups(5000, HealthPowerupSmall.class, 4);
        level06.addPowerups(5600, ShieldPowerup.class, 1);
        level06.addPowerups(7000, HealthPowerupSmall.class, 5);
        level06.addPowerups(7500, DoubleGunPowerup.class, 1);
        level06.addPowerups(8000, HealthPowerupSmall.class, 3);
        level06.addPowerups(8500, MineSweeper.class, 1);
        level06.addPowerups(9000, LaserPowerup.class, 1);
        level06.addPowerups(9500, HealthPowerupSmall.class, 4);

        ArrayList<Minelayer> minelayers = new ArrayList<>();

        for (int i = 0; i < level06.getNumWaves(); i++)
        {
            for (Enemy currentEnemy : level06.getWave(i).getShips())
            {
                if (currentEnemy.getClass() == Minelayer.class)
                {
                    minelayers.add((Minelayer) currentEnemy);
                }
            }
        }

        for (int i = 0; i < minelayers.size(); i++)
        {
            if (i % 2 == 0)
                minelayers.get(i).toggleDirection();
        }
    }

    private void createLevel07()
    {
        level07.clear();
        level07.addWave(50, DiamondShip.class, 1);
        level07.addWave(500, SquareShip.class, 3);
        level07.addWave(200, SquareShip.class, 4);
        level07.addWave(600, FlyingSaucer.class, 5);
        level07.addWave(600, DiamondShip.class, 2);
        level07.addWave(800, Minelayer.class, 4);
        level07.addWave(300, FlyingSaucer.class, 5);
        level07.addWave(300, Minelayer.class, 4);
        level07.addWave(300, FlyingSaucer.class, 5);
        level07.addWave(300, Minelayer.class, 4);
        level07.addWave(300, FlyingSaucer.class, 5);
        level07.addWave(300, Minelayer.class, 4);
        level07.addWave(800, SquareShip.class, 4);
        level07.addWave(200, SquareShip.class, 5);
        level07.addWave(200, SquareShip.class, 6);
        level07.addWave(200, SquareShip.class, 5);
        level07.addWave(200, SquareShip.class, 4);
        level07.addWave(800, Bouncer.class, 1);
        level07.addWave(500, Bouncer.class, 2);
        level07.addWave(500, Bouncer.class, 1);
        level07.addWave(500, FlyingSaucer.class, 6);
        level07.addWave(200, FlyingSaucer.class, 6);
        level07.addWave(200, FlyingSaucer.class, 6);
        level07.addWave(200, FlyingSaucer.class, 6);
        level07.addWave(200, FlyingSaucer.class, 6);
        level07.addWave(200, FlyingSaucer.class, 6);
        level07.addWave(800, SquareShip.class, 1);
        level07.addWave(200, SquareShip.class, 3);
        level07.addWave(200, SquareShip.class, 5);
        level07.addWave(200, SquareShip.class, 4);
        level07.addWave(200, SquareShip.class, 3);
        level07.addWave(200, SquareShip.class, 2);
        level07.addWave(200, SquareShip.class, 1);
        level07.addWave(500, SparkShooter.class, 3);
        level07.addWave(250, DiamondShip.class, 3);
        level07.addWave(250, SparkShooter.class, 4);
        level07.addWave(250, DiamondShip.class, 2);
        level07.addWave(250, SparkShooter.class, 3);

        level07.addPowerups(1000, DoubleGunPowerup.class, 3);
        level07.addPowerups(2000, HealthPowerupSmall.class, 4);
        level07.addPowerups(3000, HealthPowerupSmall.class, 4);
        level07.addPowerups(3500, DoubleGunPowerup.class, 2);
        level07.addPowerups(4000, HealthPowerupSmall.class, 4);
        level07.addPowerups(4500, DoubleGunPowerup.class, 1);
        level07.addPowerups(5000, HealthPowerupSmall.class, 4);
        level07.addPowerups(5750, ShieldPowerup.class, 2);
        level07.addPowerups(6000, HealthPowerupSmall.class, 4);
        level07.addPowerups(6500, MineSweeper.class, 1);
        level07.addPowerups(7000, HealthPowerupSmall.class, 4);
        level07.addPowerups(7500, ShieldPowerup.class, 1);
        level07.addPowerups(8000, HealthPowerupSmall.class, 4);
        level07.addPowerups(8500, LaserPowerup.class, 2);
        level07.addPowerups(9000, HealthPowerupSmall.class, 4);
        level07.addPowerups(9500, LaserPowerup.class, 2);
        level07.addPowerups(10000, HealthPowerupSmall.class, 4);
        level07.addPowerups(10500, ShieldPowerup.class, 1);
        level07.addPowerups(11000, HealthPowerupSmall.class, 4);
        level07.addPowerups(11500, TripleGunPowerup.class, 1);
        level07.addPowerups(12000, HealthPowerupSmall.class, 4);

        ArrayList<Minelayer> minelayers = new ArrayList<>();

        for (int i = 0; i < level07.getNumWaves(); i++)
        {
            for (Enemy currentEnemy : level07.getWave(i).getShips())
            {
                if (currentEnemy.getClass() == Minelayer.class)
                {
                    minelayers.add((Minelayer) currentEnemy);
                }
            }
        }

        for (int i = 0; i < minelayers.size(); i++)
        {
            if (i % 2 == 0)
                minelayers.get(i).toggleDirection();
        }
    }

    private void createLevel08()
    {
        level08.clear();
        level08.addWave(50, HexaShip.class, 1);
        level08.addWave(500, SquareShip.class, 2);
        level08.addWave(500, DiamondShip.class, 2);
        level08.addWave(800, TriangleShip.class, 1);
        level08.addWave(20, TriangleShip.class, 3);
        level08.addWave(20, TriangleShip.class, 5);
        level08.addWave(20, TriangleShip.class, 7);
        level08.addWave(500, SparkShooter.class, 2);
        level08.addWave(300, Bouncer.class, 2);
        level08.addWave(800, TriangleShip.class, 2);
        level08.addWave(20, TriangleShip.class, 4);
        level08.addWave(20, TriangleShip.class, 6);
        level08.addWave(20, TriangleShip.class, 8);
        level08.addWave(500, HexaShip.class, 2);
        level08.addWave(800, HexaShip.class, 2);
        level08.addWave(500, Minelayer.class, 2);
        level08.addWave(200, Minelayer.class, 2);
        level08.addWave(200, Minelayer.class, 3);
        level08.addWave(200, Minelayer.class, 3);
        level08.addWave(200, Minelayer.class, 3);
        level08.addWave(200, TriangleShip.class, 5);
        level08.addWave(200, TriangleShip.class, 5);
        level08.addWave(200, TriangleShip.class, 5);
        level08.addWave(500, Bouncer.class, 1);
        level08.addWave(200, SparkShooter.class, 1);
        level08.addWave(200, Bouncer.class, 2);
        level08.addWave(200, SparkShooter.class, 2);
        level08.addWave(200, Bouncer.class, 3);
        level08.addWave(200, SparkShooter.class, 3);
        level08.addWave(800, DiamondShip.class, 3);
        level08.addWave(200, TriangleShip.class, 5);
        level08.addWave(200, TriangleShip.class, 5);
        level08.addWave(200, TriangleShip.class, 5);
        level08.addWave(200, FlyingSaucer.class, 5);
        level08.addWave(200, FlyingSaucer.class, 5);
        level08.addWave(200, FlyingSaucer.class, 5);
        level08.addWave(200, FlyingSaucer.class, 5);
        level08.addWave(200, FlyingSaucer.class, 5);
        level08.addWave(800, HexaShip.class, 3);
        level08.addWave(500, HexaShip.class, 3);
        level08.addWave(500, HexaShip.class, 3);

        level08.addPowerups(1000, HealthPowerupBig.class, 1);
        level08.addPowerups(1500, ShieldPowerup.class, 1);
        level08.addPowerups(2000, HealthPowerupBig.class, 1);
        level08.addPowerups(2500, DoubleGunPowerup.class, 2);
        level08.addPowerups(3000, HealthPowerupBig.class, 1);
        level08.addPowerups(3500, DoubleGunPowerup.class, 2);
        level08.addPowerups(4000, HealthPowerupBig.class, 1);
        level08.addPowerups(4500, ShieldPowerup.class, 1);
        level08.addPowerups(5000, HealthPowerupBig.class, 1);
        level08.addPowerups(6000, HealthPowerupBig.class, 1);
        level08.addPowerups(7000, HealthPowerupBig.class, 1);
        level08.addPowerups(8000, HealthPowerupBig.class, 1);
        level08.addPowerups(8500, MineSweeper.class, 1);
        level08.addPowerups(9000, HealthPowerupBig.class, 1);
        level08.addPowerups(9500, ShieldPowerup.class, 1);
        level08.addPowerups(10000, HealthPowerupBig.class, 1);
        level08.addPowerups(10500, LaserPowerup.class, 2);
        level08.addPowerups(11000, HealthPowerupBig.class, 1);

        ArrayList<Minelayer> minelayers = new ArrayList<>();

        for (int i = 0; i < level08.getNumWaves(); i++)
        {
            for (Enemy currentEnemy : level08.getWave(i).getShips())
            {
                if (currentEnemy.getClass() == Minelayer.class)
                {
                    minelayers.add((Minelayer) currentEnemy);
                }
            }
        }

        for (int i = 0; i < minelayers.size(); i++)
        {
            if (i % 2 == 0)
                minelayers.get(i).toggleDirection();
        }
    }

    private void createLevel09()
    {
        level09.clear();
        level09.addWave(50, Aimer.class, 1);
        level09.addWave(200, SparkShooter.class, 1);
        level09.addWave(300, Aimer.class, 2);
        level09.addWave(500, Aimer.class, 1);
        level09.addWave(500, Aimer.class, 2);
        level09.addWave(1000, SquareShip.class, 3);
        level09.addWave(100, SquareShip.class, 4);
        level09.addWave(100, SquareShip.class, 2);
        level09.addWave(100, SquareShip.class, 3);
        level09.addWave(1000, SparkShooter.class, 1);
        level09.addWave(150, SparkShooter.class, 2);
        level09.addWave(150, SparkShooter.class, 3);
        level09.addWave(1000, Bouncer.class, 5);
        level09.addWave(500, DiamondShip.class, 2);
        level09.addWave(500, SquareShip.class, 3);
        level09.addWave(500, HexaShip.class, 1);
        level09.addWave(500, DiamondShip.class, 2);
        level09.addWave(750, SquareShip.class, 3);
        level09.addWave(250, Aimer.class, 2);
        level09.addWave(250, SparkShooter.class, 2);
        level09.addWave(500, HexaShip.class, 2);
        level09.addWave(500, Minelayer.class, 4);
        level09.addWave(250, TriangleShip.class, 6);
        level09.addWave(25, TriangleShip.class, 6);
        level09.addWave(25, TriangleShip.class, 6);
        level09.addWave(25, TriangleShip.class, 6);
        level09.addWave(25, TriangleShip.class, 6);
        level09.addWave(25, TriangleShip.class, 6);
        level09.addWave(750, Aimer.class, 3);
        level09.addWave(500, HexaShip.class, 2);
        level09.addWave(200, Minelayer.class, 4);
        level09.addWave(300, DiamondShip.class, 3);
        level09.addWave(200, Minelayer.class, 4);
        level09.addWave(300, Minelayer.class, 5);
        level09.addWave(500, Aimer.class, 5);
        level09.addWave(300, Bouncer.class, 4);
        level09.addWave(300, Aimer.class, 5);
        level09.addWave(300, Aimer.class, 6);
        level09.addWave(500, new TriangleShip(), new Aimer(), new SquareShip(), new SquareShip(), new Aimer(), new TriangleShip());

        level09.addPowerups(1000, HealthPowerupBig.class, 1);
        level09.addPowerups(1100, HealthPowerupSmall.class, 2);
        level09.addPowerups(2000, DoubleGunPowerup.class, 1);
        level09.addPowerups(2100, HealthPowerupSmall.class, 2);
        level09.addPowerups(3000, DoubleGunPowerup.class, 1);
        level09.addPowerups(3100, HealthPowerupSmall.class, 2);
        level09.addPowerups(4000, HealthPowerupBig.class, 1);
        level09.addPowerups(4100, HealthPowerupSmall.class, 2);
        level09.addPowerups(5000, HealthPowerupSmall.class, 2);
        level09.addPowerups(5100, HealthPowerupBig.class, 1);
        level09.addPowerups(6000, LaserPowerup.class, 1);
        level09.addPowerups(6100, HealthPowerupBig.class, 2);
        level09.addPowerups(7000, HealthPowerupBig.class, 1);
        level09.addPowerups(7100, HealthPowerupSmall.class, 4);
        level09.addPowerups(8000, HealthPowerupSmall.class, 5);
        level09.addPowerups(8100, HealthPowerupSmall.class, 5);
        level09.addPowerups(9000, LaserPowerup.class, 1);
        level09.addPowerups(9100, HealthPowerupBig.class, 2);
        level09.addPowerups(9200, HealthPowerupBig.class, 3);
        level09.addPowerups(10000, HealthPowerupSmall.class, 1);
        level09.addPowerups(10100, MineSweeper.class, 2);
        level09.addPowerups(10200, HealthPowerupBig.class, 3);
        level09.addPowerups(10300, HealthPowerupSmall.class, 4);
        level09.addPowerups(11000, MineSweeper.class, 2);
        level09.addPowerups(11100, TripleGunPowerup.class, 1);
        level09.addPowerups(11200, HealthPowerupBig.class, 1);
        level09.addPowerups(11300, HealthPowerupBig.class, 1);
        level09.addPowerups(11400, HealthPowerupBig.class, 1);
        level09.addPowerups(11500, HealthPowerupBig.class, 1);
        level09.addPowerups(11600, HealthPowerupBig.class, 1);
        level09.addPowerups(11700, HealthPowerupBig.class, 1);
        level09.addPowerups(11800, HealthPowerupBig.class, 1);
        level09.addPowerups(11900, HealthPowerupBig.class, 1);
        level09.addPowerups(12000, HealthPowerupBig.class, 3);
        level09.addPowerups(12500, HealthPowerupSmall.class, 4);
        level09.addPowerups(13000, HealthPowerupSmall.class, 4);
        level09.addPowerups(13500, MineSweeper.class, 2);
        level09.addPowerups(14000, new HealthPowerupSmall(), new HealthPowerupBig(), new HealthPowerupBig(), new HealthPowerupSmall());

        ArrayList<Minelayer> minelayers = new ArrayList<>();

        for (int i = 0; i < level09.getNumWaves(); i++)
        {
            for (Enemy currentEnemy : level09.getWave(i).getShips())
            {
                if (currentEnemy.getClass() == Minelayer.class)
                {
                    minelayers.add((Minelayer) currentEnemy);
                }
            }
        }

        for (int i = 0; i < minelayers.size(); i++)
        {
            if (i % 2 == 0)
                minelayers.get(i).toggleDirection();
        }
    }

    private void createLevel10()
    {
        level10.clear();
        level10.addWave(100, FinalBoss.class, 1);
    }
}
