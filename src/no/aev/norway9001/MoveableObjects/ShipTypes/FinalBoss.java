package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.util.Duration;
import no.aev.norway9001.Game.Aimbot;
import no.aev.norway9001.Game.Debugger;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.EnemyLaserBlast;
import no.aev.norway9001.MoveableObjects.BulletTypes.Missile;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.Spark;
import no.aev.norway9001.MoveableObjects.Enemy;

public class FinalBoss extends Enemy
{

    private static final double SPEED = 0.5;
    private static final int MAX_HP = 1000;
    private static final int POINTS = 15;
    private static final int LASER_COOLDOWN = 400;
    private static final int BULLET_COOLDOWN = 200;
    private static final int MAX_SHOTS = 10;
    private boolean movingDown = false;
    private int laserCounter = 0;
    private int bulletCounter = BULLET_COOLDOWN;
    private int shotsLeft = MAX_SHOTS;
    private Aimbot aimbot;

    // Bullet battery modes
    private int bulletBatteryMode = 0;
    private static final int FRONTAL_MODE = 0;
    private static final int DIAGONAL_MODE = 1;
    private static final int AIMBOT_MODE = 2;
    private static final int MISSILE_MODE = 3;

    // Ship states
    private static final Image HEALTHY_SPRITE = new Image("ships/finalboss-healthy.png");
    private static final Image DAMAGED_SPRITE = new Image("ships/finalboss-damaged.png");
    private static final Image CRITICAL_SPRITE = new Image("ships/finalboss-critical.png");

    private Debugger debugger = Debugger.INSTANCE;

    private double screenWidth;
    private double screenHeight;

    public FinalBoss()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, BULLET_COOLDOWN);
        setImage(new Image("ships/finalboss.png"));
    }

    public FinalBoss(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, BULLET_COOLDOWN);
        setImage(new Image("ships/finalboss.png"));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        // FIRE MAH LASERS
        if (laserCounter >= LASER_COOLDOWN && bulletBatteryMode != MISSILE_MODE)
        {
            Bullet upperLaser = new EnemyLaserBlast(getX() + 80, getY());
            Bullet middleLaser = new Spark(getX() + 80, getY() + 140);
            Bullet lowerLaser = new EnemyLaserBlast(getX() + 80, getY() + 280);
            bulletList.add(upperLaser);
            bulletList.add(middleLaser);
            bulletList.add(lowerLaser);
            laserCounter = 0;
        }
        else
            laserCounter++;

        // Fire bullets
        if (bulletCounter <= 0)
        {
            Bullet bullet1;
            Bullet bullet2;

            if (bulletBatteryMode == MISSILE_MODE)
            {

                bullet1 = new Missile(getX(), getY() + 135);
                bullet2 = new Missile(getX(), getY() + 135);
                bulletList.add(new Missile(getX() + 80, getY()));
                bulletList.add(new Missile(getX() + 80, getY() + 280));
            }
            else
            {
                bullet1 = new OrangeBullet(getX(), getY() + 135);
                bullet2 = new OrangeBullet(getX(), getY() + 145);
                bulletList.add(new OrangeBullet(getX() + 80, getY()));
                bulletList.add(new OrangeBullet(getX() + 80, getY() + 280));
            }

            bulletList.add(bullet1);
            bulletList.add(bullet2);

            if (bulletBatteryMode == DIAGONAL_MODE)
            {
                bullet1.setySpeed(-2);
                bullet2.setySpeed(2);
            }
            else if (bulletBatteryMode == AIMBOT_MODE)
            {
                aimbot.aim(this, bullet1, bullet2);
            }

            if (shotsLeft > 0)
            {
                bulletCounter = 10;
                shotsLeft--;
            }
            else
            {
                bulletCounter = BULLET_COOLDOWN;
                shotsLeft = MAX_SHOTS;
                if (bulletBatteryMode == FRONTAL_MODE)
                    bulletBatteryMode = DIAGONAL_MODE;
                else if (bulletBatteryMode == DIAGONAL_MODE)
                    bulletBatteryMode = AIMBOT_MODE;
                else if (bulletBatteryMode == AIMBOT_MODE)
                    bulletBatteryMode = MISSILE_MODE;
                else if (bulletBatteryMode == MISSILE_MODE)
                    bulletBatteryMode = FRONTAL_MODE;
            }
        }
        else
            bulletCounter--;
    }

    @Override
    public void move()
    {
        //debugger.printDebugInfo(this.getClass(), "Boss coordinates: " + getX() + "," + getY());
        updateAppearance();
        if (getX() > screenWidth - 250)
            super.move();
        else
        {
            if (movingDown)
            {
                setY(getY() + getSpeed());
            }
            else
            {
                setY(getY() - getSpeed());
            }

            if (getY() < 100)
                movingDown = true;
            else if (getY() > screenHeight - 400)
                movingDown = false;
        }
    }

    private void updateAppearance()
    {
        if (getCurrentHP() > MAX_HP * 0.67)
            setImage(HEALTHY_SPRITE);
        else if (getCurrentHP() > MAX_HP * 0.33)
            setImage(DAMAGED_SPRITE);
        else
            setImage(CRITICAL_SPRITE);
    }

    @Override
    public void die()
    {
        alive = false;
        setSpeed(0);
        setImage(getDeathExplosion());
        setX(getX() - 20);
        setY(getY() - 20);
        setFitWidth(250);
        setFitHeight(250);
        Timeline death = new Timeline(
                new KeyFrame(Duration.millis(500), event -> setImage(null))
        );
        death.setCycleCount(1);
        death.play();
        // TODO: Add code for a cooler death animation
    }

    public void setAimbot(Aimbot aimbot)
    {
        this.aimbot = aimbot;
    }

    public void setScreenBounds(double width, double height)
    {
        this.screenWidth = width;
        this.screenHeight = height;
    }
}
