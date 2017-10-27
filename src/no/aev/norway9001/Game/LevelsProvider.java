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
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * @author Asgeir Vinkenes
 */
public final class LevelsProvider
{

    public static final LevelsProvider INSTANCE = new LevelsProvider();
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
        level01.addWave(SquareShip.class, 3, 50);
        level01.addWave(FlyingSaucer.class, 3, 1000);
        level01.addWave(TriangleShip.class, 3, 1000);
        level01.addWave(SquareShip.class, 4, 300);
        level01.addWave(FlyingSaucer.class, 4, 1000);
        level01.addWave(TriangleShip.class, 5, 1000);
        level01.addWave(SquareShip.class, 4, 300);
        level01.addWave(FlyingSaucer.class, 4, 1000);
        level01.addWave(TriangleShip.class, 3, 1000);
        level01.addWave(TriangleShip.class, 4, 10);
        level01.addWave(TriangleShip.class, 5, 10);
        level01.addWave(SquareShip.class, 2, 200);
        level01.addWave(SquareShip.class, 3, 150);

        level01.addPowerups(HealthPowerupSmall.class, 1, 5000);
        System.out.println("There are " + level01.getNumWaves() + " waves in this level.");
    }

    private void createLevel02()
    {
        level02.clear();
        level02.addWave(SquareShip.class, 2, 50);
        level02.addWave(SquareShip.class, 2, 150);
        level02.addWave(FlyingSaucer.class, 2, 1000);
        level02.addWave(FlyingSaucer.class, 2, 150);
        level02.addWave(SquareShip.class, 3, 1000);
        level02.addWave(TriangleShip.class, 4, 100);
        level02.addWave(SquareShip.class, 5, 1000);
        level02.addWave(FlyingSaucer.class, 5, 1000);
        level02.addWave(TriangleShip.class, 1, 1000);
        level02.getWave(level02.getNumWaves() - 1).addShip(new SquareShip());
        level02.getWave(level02.getNumWaves() - 1).addShip(new FlyingSaucer());
        level02.getWave(level02.getNumWaves() - 1).addShip(new SquareShip());
        level02.getWave(level02.getNumWaves() - 1).addShip(new TriangleShip());
        level02.addWave(SquareShip.class, 1, 1000);
        level02.addWave(FlyingSaucer.class, 2, 150);
        level02.addWave(SquareShip.class, 3, 150);
        level02.addWave(TriangleShip.class, 4, 1000);
        level02.addWave(TriangleShip.class, 5, 150);
        level02.addWave(TriangleShip.class, 6, 150);
        level02.addWave(SquareShip.class, 3, 500);
        level02.addWave(SquareShip.class, 3, 150);

        level02.addPowerups(HealthPowerupSmall.class, 1, 2000);
        level02.addPowerups(HealthPowerupSmall.class, 1, 4000);
        level02.addPowerups(DoubleGunPowerup.class, 1, 5000);
        level02.addPowerups(HealthPowerupSmall.class, 1, 6000);
    }

    private void createLevel03()
    {
        level03.clear();
        level03.addWave(Minelayer.class, 1, 50);
        level03.addWave(SquareShip.class, 3, 900);
        level03.addWave(SquareShip.class, 2, 150);
        level03.addWave(FlyingSaucer.class, 2, 800);
        level03.addWave(FlyingSaucer.class, 2, 150);
        level03.addWave(TriangleShip.class, 6, 700);
        level03.addWave(TriangleShip.class, 6, 50);
        level03.addWave(TriangleShip.class, 6, 50);
        level03.addWave(SquareShip.class, 3, 800);
        level03.addWave(SquareShip.class, 4, 150);
        level03.addWave(SquareShip.class, 3, 150);
        level03.addWave(Minelayer.class, 1, 700);
        level03.addWave(FlyingSaucer.class, 2, 200);
        level03.addWave(FlyingSaucer.class, 2, 200);
        level03.addWave(SquareShip.class, 4, 800);
        level03.addWave(SquareShip.class, 3, 150);
        level03.addWave(SquareShip.class, 4, 150);
        level03.addWave(Minelayer.class, 2, 1000);
        level03.addWave(TriangleShip.class, 1, 500);
        level03.addWave(TriangleShip.class, 2, 50);
        level03.addWave(TriangleShip.class, 3, 50);
        level03.addWave(TriangleShip.class, 4, 50);
        level03.addWave(TriangleShip.class, 5, 50);
        level03.addWave(SquareShip.class, 6, 450);

        level03.addPowerups(HealthPowerupSmall.class, 1, 2000);
        level03.addPowerups(DoubleGunPowerup.class, 1, 3000);
        level03.addPowerups(HealthPowerupSmall.class, 1, 4000);
        level03.addPowerups(HealthPowerupSmall.class, 2, 6000);
        level03.addPowerups(TripleGunPowerup.class, 1, 6500);
    }

    private void createLevel04()
    {
        level04.clear();
        level04.addWave(TriangleShip.class, 1, 250);
        level04.addWave(TriangleShip.class, 2, 25);
        level04.addWave(TriangleShip.class, 3, 25);
        level04.addWave(TriangleShip.class, 4, 25);
        level04.addWave(TriangleShip.class, 5, 25);
        level04.addWave(TriangleShip.class, 6, 25);
        level04.addWave(Minelayer.class, 1, 500);
        level04.addWave(SquareShip.class, 3, 500);
        level04.addWave(FlyingSaucer.class, 3, 1000);
        level04.addWave(FlyingSaucer.class, 3, 100);
        level04.addWave(FlyingSaucer.class, 3, 100);
        level04.addWave(SquareShip.class, 3, 500);
        level04.addWave(SquareShip.class, 4, 500);
        level04.addWave(SquareShip.class, 3, 500);
        level04.addWave(SquareShip.class, 4, 500);
        level04.addWave(SquareShip.class, 3, 500);
        level04.addWave(Minelayer.class, 2, 500);
        level04.addWave(TriangleShip.class, 6, 500);
        level04.addWave(TriangleShip.class, 6, 10);
        level04.addWave(TriangleShip.class, 6, 10);
        level04.addWave(TriangleShip.class, 6, 10);
        level04.addWave(TriangleShip.class, 6, 10);
        level04.addWave(TriangleShip.class, 6, 10);
        level04.addWave(Minelayer.class, 1, 750);
        level04.addWave(SquareShip.class, 8, 750);
        level04.addWave(FlyingSaucer.class, 4, 1000);
        level04.addWave(SquareShip.class, 1, 400);
        level04.addWave(SquareShip.class, 2, 100);
        level04.addWave(SquareShip.class, 1, 100);
        level04.addWave(FlyingSaucer.class, 4, 750);
        level04.addWave(FlyingSaucer.class, 4, 50);
        level04.addWave(FlyingSaucer.class, 4, 50);
        level04.addWave(FlyingSaucer.class, 4, 50);
        level04.addWave(TriangleShip.class, 5, 50);
        level04.addWave(TriangleShip.class, 5, 10);
        level04.addWave(TriangleShip.class, 5, 10);
        level04.addWave(TriangleShip.class, 5, 10);
        level04.addWave(TriangleShip.class, 5, 10);

        level04.addPowerups(ShieldPowerup.class, 1, 50);
        level04.addPowerups(DoubleGunPowerup.class, 1, 1000);
        level04.addPowerups(HealthPowerupSmall.class, 1, 3000);
        level04.addPowerups(HealthPowerupSmall.class, 2, 3100);
        level04.addPowerups(LaserPowerup.class, 1, 3500);
        level04.addPowerups(DoubleGunPowerup.class, 1, 4500);
        level04.addPowerups(LaserPowerup.class, 1, 5500);
        level04.addPowerups(HealthPowerupSmall.class, 2, 6000);
        level04.addPowerups(HealthPowerupSmall.class, 1, 6100);
        level04.addPowerups(DoubleGunPowerup.class, 2, 7000);
        level04.addPowerups(LaserPowerup.class, 2, 8000);
        level04.addPowerups(HealthPowerupSmall.class, 2, 9000);
        level04.addPowerups(HealthPowerupSmall.class, 2, 9100);
        level04.addPowerups(TripleGunPowerup.class, 1, 9500);
        level04.addPowerups(ShieldPowerup.class, 1, 9800);

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
        level05.addWave(Bouncer.class, 2, 50);
        level05.addWave(SquareShip.class, 3, 800);
        level05.addWave(SquareShip.class, 3, 500);
        level05.addWave(SquareShip.class, 3, 500);
        level05.addWave(TriangleShip.class, 6, 1200);
        level05.addWave(TriangleShip.class, 5, 10);
        level05.addWave(TriangleShip.class, 4, 10);
        level05.addWave(TriangleShip.class, 3, 10);
        level05.addWave(TriangleShip.class, 2, 10);
        level05.addWave(TriangleShip.class, 1, 10);
        level05.addWave(Bouncer.class, 3, 200);
        level05.addWave(FlyingSaucer.class, 4, 800);
        level05.addWave(TriangleShip.class, 3, 500);
        level05.addWave(TriangleShip.class, 3, 20);
        level05.addWave(TriangleShip.class, 3, 20);
        level05.addWave(Minelayer.class, 3, 300);
        level05.addWave(SquareShip.class, 1, 500);
        level05.addWave(SquareShip.class, 2, 200);
        level05.addWave(SquareShip.class, 3, 200);
        level05.addWave(SquareShip.class, 2, 200);
        level05.addWave(SquareShip.class, 1, 200);
        level05.addWave(Bouncer.class, 2, 800);
        level05.addWave(Bouncer.class, 4, 200);
        level05.addWave(FlyingSaucer.class, 10, 500);
        level05.addWave(SquareShip.class, 6, 600);
        level05.addWave(SquareShip.class, 6, 150);
        level05.addWave(SquareShip.class, 6, 150);
        level05.addWave(SquareShip.class, 6, 150);
        level05.addWave(SquareShip.class, 6, 150);
        level05.addWave(SquareShip.class, 6, 150);
        level05.addWave(Minelayer.class, 3, 800);
        level05.addWave(Bouncer.class, 3, 800);
        level05.addWave(Bouncer.class, 3, 300);
        level05.addWave(Bouncer.class, 3, 300);
        level05.addWave(Minelayer.class, 4, 500);
        level05.addWave(Minelayer.class, 4, 200);
        level05.addWave(TriangleShip.class, 8, 200);
        level05.addWave(TriangleShip.class, 8, 30);
        level05.addWave(TriangleShip.class, 8, 30);
        level05.addWave(SquareShip.class, 5, 400);
        level05.addWave(SquareShip.class, 5, 200);
        level05.addWave(SquareShip.class, 5, 200);
        level05.addWave(SquareShip.class, 5, 200);
        level05.addWave(SquareShip.class, 5, 200);

        level05.addPowerups(HealthPowerupSmall.class, 2, 1500);
        level05.addPowerups(DoubleGunPowerup.class, 1, 2000);
        level05.addPowerups(HealthPowerupSmall.class, 3, 3000);
        level05.addPowerups(HealthPowerupSmall.class, 2, 3100);
        level05.addPowerups(HealthPowerupSmall.class, 3, 4000);
        level05.addPowerups(DoubleGunPowerup.class, 1, 4500);
        level05.addPowerups(HealthPowerupSmall.class, 3, 5000);
        level05.addPowerups(ShieldPowerup.class, 1, 5100);
        level05.addPowerups(HealthPowerupSmall.class, 2, 7000);
        level05.addPowerups(HealthPowerupSmall.class, 3, 7300);
        level05.addPowerups(LaserPowerup.class, 1, 8000);
        level05.addPowerups(LaserPowerup.class, 2, 8250);
        level05.addPowerups(ShieldPowerup.class, 1, 8500);
        level05.addPowerups(HealthPowerupSmall.class, 4, 9000);
        level05.addPowerups(TripleGunPowerup.class, 2, 10500);
        level05.addPowerups(HealthPowerupSmall.class, 3, 11000);
        level05.addPowerups(HealthPowerupSmall.class, 3, 11500);

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
        level06.addWave(SparkShooter.class, 2, 50);
        level06.addWave(SquareShip.class, 3, 150);
        level06.addWave(SquareShip.class, 4, 150);
        level06.addWave(SquareShip.class, 5, 150);
        level06.addWave(SparkShooter.class, 3, 700);
        level06.addWave(Minelayer.class, 4, 500);
        level06.addWave(Bouncer.class, 2, 1200);
        level06.addWave(SquareShip.class, 3, 400);
        level06.addWave(SquareShip.class, 4, 400);
        level06.addWave(SparkShooter.class, 1, 1000);
        level06.addWave(TriangleShip.class, 7, 800);
        level06.addWave(TriangleShip.class, 6, 20);
        level06.addWave(TriangleShip.class, 5, 20);
        level06.addWave(TriangleShip.class, 4, 20);
        level06.addWave(TriangleShip.class, 3, 20);
        level06.addWave(TriangleShip.class, 2, 20);
        level06.addWave(TriangleShip.class, 1, 20);
        level06.addWave(SparkShooter.class, 3, 200);
        level06.addWave(SquareShip.class, 3, 200);
        level06.addWave(SquareShip.class, 3, 200);
        level06.addWave(TriangleShip.class, 7, 800);
        level06.addWave(TriangleShip.class, 6, 20);
        level06.addWave(TriangleShip.class, 5, 20);
        level06.addWave(TriangleShip.class, 4, 20);
        level06.addWave(TriangleShip.class, 3, 20);
        level06.addWave(TriangleShip.class, 2, 20);
        level06.addWave(TriangleShip.class, 1, 20);
        level06.addWave(Minelayer.class, 3, 200);
        level06.addWave(Minelayer.class, 2, 200);
        level06.addWave(Minelayer.class, 3, 200);
        level06.addWave(SquareShip.class, 5, 800);
        level06.addWave(SparkShooter.class, 2, 200);
        level06.addWave(SquareShip.class, 5, 200);
        level06.addWave(SquareShip.class, 6, 200);
        level06.addWave(SquareShip.class, 5, 200);
        level06.addWave(SparkShooter.class, 3, 200);
        level06.addWave(SparkShooter.class, 4, 200);
        level06.addWave(SparkShooter.class, 2, 200);
        level06.addWave(Bouncer.class, 4, 200);

        level06.addPowerups(HealthPowerupSmall.class, 4, 1500);
        level06.addPowerups(DoubleGunPowerup.class, 2, 2500);
        level06.addPowerups(MineSweeper.class, 2, 3000);
        level06.addPowerups(HealthPowerupSmall.class, 4, 3500);
        level06.addPowerups(LaserPowerup.class, 2, 4000);
        level06.addPowerups(DoubleGunPowerup.class, 2, 4500);
        level06.addPowerups(HealthPowerupSmall.class, 4, 5000);
        level06.addPowerups(ShieldPowerup.class, 1, 5600);
        level06.addPowerups(HealthPowerupSmall.class, 5, 7000);
        level06.addPowerups(DoubleGunPowerup.class, 1, 7500);
        level06.addPowerups(HealthPowerupSmall.class, 3, 8000);
        level06.addPowerups(MineSweeper.class, 1, 8500);
        level06.addPowerups(LaserPowerup.class, 1, 9000);
        level06.addPowerups(HealthPowerupSmall.class, 4, 9500);

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
        level07.addWave(DiamondShip.class, 1, 50);
        level07.addWave(SquareShip.class, 3, 500);
        level07.addWave(SquareShip.class, 4, 200);
        level07.addWave(FlyingSaucer.class, 5, 600);
        level07.addWave(DiamondShip.class, 2, 600);
        level07.addWave(Minelayer.class, 4, 800);
        level07.addWave(FlyingSaucer.class, 5, 300);
        level07.addWave(Minelayer.class, 4, 300);
        level07.addWave(FlyingSaucer.class, 5, 300);
        level07.addWave(Minelayer.class, 4, 300);
        level07.addWave(FlyingSaucer.class, 5, 300);
        level07.addWave(Minelayer.class, 4, 300);
        level07.addWave(SquareShip.class, 4, 800);
        level07.addWave(SquareShip.class, 5, 200);
        level07.addWave(SquareShip.class, 6, 200);
        level07.addWave(SquareShip.class, 5, 200);
        level07.addWave(SquareShip.class, 4, 200);
        level07.addWave(Bouncer.class, 1, 800);
        level07.addWave(Bouncer.class, 2, 500);
        level07.addWave(Bouncer.class, 1, 500);
        level07.addWave(FlyingSaucer.class, 6, 500);
        level07.addWave(FlyingSaucer.class, 6, 200);
        level07.addWave(FlyingSaucer.class, 6, 200);
        level07.addWave(FlyingSaucer.class, 6, 200);
        level07.addWave(FlyingSaucer.class, 6, 200);
        level07.addWave(FlyingSaucer.class, 6, 200);
        level07.addWave(SquareShip.class, 1, 800);
        level07.addWave(SquareShip.class, 3, 200);
        level07.addWave(SquareShip.class, 5, 200);
        level07.addWave(SquareShip.class, 4, 200);
        level07.addWave(SquareShip.class, 3, 200);
        level07.addWave(SquareShip.class, 2, 200);
        level07.addWave(SquareShip.class, 1, 200);
        level07.addWave(SparkShooter.class, 3, 500);
        level07.addWave(DiamondShip.class, 3, 250);
        level07.addWave(SparkShooter.class, 4, 250);
        level07.addWave(DiamondShip.class, 2, 250);
        level07.addWave(SparkShooter.class, 3, 250);

        level07.addPowerups(DoubleGunPowerup.class, 3, 1000);
        level07.addPowerups(HealthPowerupSmall.class, 4, 2000);
        level07.addPowerups(HealthPowerupSmall.class, 4, 3000);
        level07.addPowerups(DoubleGunPowerup.class, 2, 3500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 4000);
        level07.addPowerups(DoubleGunPowerup.class, 1, 4500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 5000);
        level07.addPowerups(ShieldPowerup.class, 2, 5750);
        level07.addPowerups(HealthPowerupSmall.class, 4, 6000);
        level07.addPowerups(MineSweeper.class, 1, 6500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 7000);
        level07.addPowerups(ShieldPowerup.class, 1, 7500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 8000);
        level07.addPowerups(LaserPowerup.class, 2, 8500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 9000);
        level07.addPowerups(LaserPowerup.class, 2, 9500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 10000);
        level07.addPowerups(ShieldPowerup.class, 1, 10500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 11000);
        level07.addPowerups(TripleGunPowerup.class, 1, 11500);
        level07.addPowerups(HealthPowerupSmall.class, 4, 12000);

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
        level08.addWave(HexaShip.class, 1, 50);
        level08.addWave(SquareShip.class, 2, 500);
        level08.addWave(DiamondShip.class, 2, 500);
        level08.addWave(TriangleShip.class, 1, 800);
        level08.addWave(TriangleShip.class, 3, 20);
        level08.addWave(TriangleShip.class, 5, 20);
        level08.addWave(TriangleShip.class, 7, 20);
        level08.addWave(SparkShooter.class, 2, 500);
        level08.addWave(Bouncer.class, 2, 300);
        level08.addWave(TriangleShip.class, 2, 800);
        level08.addWave(TriangleShip.class, 4, 20);
        level08.addWave(TriangleShip.class, 6, 20);
        level08.addWave(TriangleShip.class, 8, 20);
        level08.addWave(HexaShip.class, 2, 500);
        level08.addWave(HexaShip.class, 2, 800);
        level08.addWave(Minelayer.class, 2, 500);
        level08.addWave(Minelayer.class, 2, 200);
        level08.addWave(Minelayer.class, 3, 200);
        level08.addWave(Minelayer.class, 3, 200);
        level08.addWave(Minelayer.class, 3, 200);
        level08.addWave(TriangleShip.class, 5, 200);
        level08.addWave(TriangleShip.class, 5, 200);
        level08.addWave(TriangleShip.class, 5, 200);
        level08.addWave(Bouncer.class, 1, 500);
        level08.addWave(SparkShooter.class, 1, 200);
        level08.addWave(Bouncer.class, 2, 200);
        level08.addWave(SparkShooter.class, 2, 200);
        level08.addWave(Bouncer.class, 3, 200);
        level08.addWave(SparkShooter.class, 3, 200);
        level08.addWave(DiamondShip.class, 3, 800);
        level08.addWave(TriangleShip.class, 5, 200);
        level08.addWave(TriangleShip.class, 5, 200);
        level08.addWave(TriangleShip.class, 5, 200);
        level08.addWave(FlyingSaucer.class, 5, 200);
        level08.addWave(FlyingSaucer.class, 5, 200);
        level08.addWave(FlyingSaucer.class, 5, 200);
        level08.addWave(FlyingSaucer.class, 5, 200);
        level08.addWave(FlyingSaucer.class, 5, 200);
        level08.addWave(HexaShip.class, 3, 800);
        level08.addWave(HexaShip.class, 3, 500);
        level08.addWave(HexaShip.class, 3, 500);

        level08.addPowerups(HealthPowerupBig.class, 1, 1000);
        level08.addPowerups(ShieldPowerup.class, 1, 1500);
        level08.addPowerups(HealthPowerupBig.class, 1, 2000);
        level08.addPowerups(DoubleGunPowerup.class, 2, 2500);
        level08.addPowerups(HealthPowerupBig.class, 1, 3000);
        level08.addPowerups(DoubleGunPowerup.class, 2, 3500);
        level08.addPowerups(HealthPowerupBig.class, 1, 4000);
        level08.addPowerups(ShieldPowerup.class, 1, 4500);
        level08.addPowerups(HealthPowerupBig.class, 1, 5000);
        level08.addPowerups(HealthPowerupBig.class, 1, 6000);
        level08.addPowerups(HealthPowerupBig.class, 1, 7000);
        level08.addPowerups(HealthPowerupBig.class, 1, 8000);
        level08.addPowerups(MineSweeper.class, 1, 8500);
        level08.addPowerups(HealthPowerupBig.class, 1, 9000);
        level08.addPowerups(ShieldPowerup.class, 1, 9500);
        level08.addPowerups(HealthPowerupBig.class, 1, 10000);
        level08.addPowerups(LaserPowerup.class, 2, 10500);
        level08.addPowerups(HealthPowerupBig.class, 1, 11000);

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
        level09.addWave(Aimer.class, 1, 50);
        level09.addWave(SparkShooter.class, 1, 200);
        level09.addWave(Aimer.class, 2, 300);
        level09.addWave(Aimer.class, 1, 500);
        level09.addWave(Aimer.class, 2, 500);
        level09.addWave(SquareShip.class, 3, 1000);
        level09.addWave(SquareShip.class, 4, 100);
        level09.addWave(SquareShip.class, 2, 100);
        level09.addWave(SquareShip.class, 3, 100);
        level09.addWave(SparkShooter.class, 1, 1000);
        level09.addWave(SparkShooter.class, 2, 150);
        level09.addWave(SparkShooter.class, 3, 150);
        level09.addWave(Bouncer.class, 5, 1000);
        level09.addWave(DiamondShip.class, 2, 500);
        level09.addWave(SquareShip.class, 3, 500);
        level09.addWave(HexaShip.class, 1, 500);
        level09.addWave(DiamondShip.class, 2, 500);
        level09.addWave(SquareShip.class, 3, 750);
        level09.addWave(Aimer.class, 2, 250);
        level09.addWave(SparkShooter.class, 2, 250);
        level09.addWave(HexaShip.class, 2, 500);
        level09.addWave(Minelayer.class, 4, 500);
        level09.addWave(TriangleShip.class, 6, 250);
        level09.addWave(TriangleShip.class, 6, 25);
        level09.addWave(TriangleShip.class, 6, 25);
        level09.addWave(TriangleShip.class, 6, 25);
        level09.addWave(TriangleShip.class, 6, 25);
        level09.addWave(TriangleShip.class, 6, 25);
        level09.addWave(Aimer.class, 3, 750);
        level09.addWave(HexaShip.class, 2, 500);
        level09.addWave(Minelayer.class, 4, 200);
        level09.addWave(DiamondShip.class, 3, 300);
        level09.addWave(Minelayer.class, 4, 200);
        level09.addWave(Minelayer.class, 5, 300);
        level09.addWave(Aimer.class, 5, 500);
        level09.addWave(Bouncer.class, 4, 300);
        level09.addWave(Aimer.class, 5, 300);
        level09.addWave(Aimer.class, 6, 300);

        level09.addPowerups(HealthPowerupBig.class, 1, 1000);
        level09.addPowerups(HealthPowerupSmall.class, 2, 1100);
        level09.addPowerups(DoubleGunPowerup.class, 1, 2000);
        level09.addPowerups(HealthPowerupSmall.class, 2, 2100);
        level09.addPowerups(DoubleGunPowerup.class, 1, 3000);
        level09.addPowerups(HealthPowerupSmall.class, 2, 3100);
        level09.addPowerups(HealthPowerupBig.class, 1, 4000);
        level09.addPowerups(HealthPowerupSmall.class, 2, 4100);
        level09.addPowerups(HealthPowerupSmall.class, 2, 5000);
        level09.addPowerups(HealthPowerupBig.class, 1, 5100);
        level09.addPowerups(LaserPowerup.class, 1, 6000);
        level09.addPowerups(HealthPowerupBig.class, 2, 6100);
        level09.addPowerups(HealthPowerupBig.class, 1, 7000);
        level09.addPowerups(HealthPowerupSmall.class, 4, 7100);
        level09.addPowerups(HealthPowerupSmall.class, 5, 8000);
        level09.addPowerups(HealthPowerupSmall.class, 5, 8100);
        level09.addPowerups(LaserPowerup.class, 1, 9000);
        level09.addPowerups(HealthPowerupBig.class, 2, 9100);
        level09.addPowerups(HealthPowerupBig.class, 3, 9200);
        level09.addPowerups(HealthPowerupSmall.class, 1, 10000);
        level09.addPowerups(MineSweeper.class, 2, 10100);
        level09.addPowerups(HealthPowerupBig.class, 3, 10200);
        level09.addPowerups(HealthPowerupSmall.class, 4, 10300);
        level09.addPowerups(MineSweeper.class, 2, 11000);
        level09.addPowerups(TripleGunPowerup.class, 1, 11100);
        level09.addPowerups(HealthPowerupBig.class, 1, 11200);
        level09.addPowerups(HealthPowerupBig.class, 1, 11300);
        level09.addPowerups(HealthPowerupBig.class, 1, 11400);
        level09.addPowerups(HealthPowerupBig.class, 1, 11500);
        level09.addPowerups(HealthPowerupBig.class, 1, 11600);
        level09.addPowerups(HealthPowerupBig.class, 1, 11700);
        level09.addPowerups(HealthPowerupBig.class, 1, 11800);
        level09.addPowerups(HealthPowerupBig.class, 1, 11900);
        level09.addPowerups(HealthPowerupBig.class, 3, 12000);
        level09.addPowerups(HealthPowerupSmall.class, 4, 12500);
        level09.addPowerups(HealthPowerupSmall.class, 4, 13000);

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
        level10.addWave(FinalBoss.class, 1, 100);
    }
}
