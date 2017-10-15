package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.aev.norway9001.Game.Debugger;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.EnemyLaserBlast;
import no.aev.norway9001.MoveableObjects.BulletTypes.Missile;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
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
    private Player player;

    // Bullet battery modes
    private int bulletBatteryMode = 0;
    private static final int FRONTAL_MODE = 0;
    private static final int DIAGONAL_MODE = 1;
    private static final int AIMBOT_MODE = 2;
    private static final int MISSILE_MODE = 3;

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
            Bullet lowerLaser = new EnemyLaserBlast(getX() + 80, getY() + 280);
            bulletList.add(upperLaser);
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

            if (bulletBatteryMode != MISSILE_MODE)
            {
                bullet1 = new OrangeBullet(getX(), getY() + 135);
                bullet2 = new OrangeBullet(getX(), getY() + 145);
            }
            else
            {
                bullet1 = new Missile(getX(), getY() + 135);
                bullet2 = new Missile(getX(), getY() + 135);
                bulletList.add(new Missile(getX() + 80, getY()));
                bulletList.add(new Missile(getX() + 80, getY() + 280));
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
                double bulletSpeed = bullet1.getxSpeed();

                // Calculate distances between ship and player
                double xDist = getX() - player.getX();
                double yDist = getY() - player.getY();
                double dist = Math.sqrt(xDist * xDist + yDist * yDist);

                // Calculate sine and cosine of the angle between ship and player
                double sin = yDist / dist;
                double cos = xDist / dist;

                // Calculate x and y speeds
                bullet1.setxSpeed(bulletSpeed * cos);
                bullet1.setySpeed(bulletSpeed * sin);
                bullet2.setxSpeed(bulletSpeed * cos);
                bullet2.setySpeed(bulletSpeed * sin);
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
        debugger.printDebugInfo(this.getClass(), "Boss coordinates: " + getX() + "," + getY());
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

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void setScreenBounds(double width, double height)
    {
        this.screenWidth = width;
        this.screenHeight = height;
    }
}
