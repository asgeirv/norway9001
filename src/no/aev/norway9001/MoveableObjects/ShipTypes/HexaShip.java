package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.EnemyLaserBlast;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
import no.aev.norway9001.MoveableObjects.Enemy;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class HexaShip extends Enemy
{
    private static final double SPEED = 0.5;
    private static final int MAX_HP = 60;
    private static final int POINTS = 30;
    private static final int COOLDOWN = 200;

    private boolean movingUp = true;
    private int shotCounter = 2;
    private int moveCounter = 2;
    private static final int TRAVEL_TIME = 300; // measured in ticks

    public HexaShip()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/hexaship.png", 50, 50, true, true));
    }

    public HexaShip(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/hexaship.png", 50, 50, true, true));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            setSpeed(0);
            Bullet newBullet = new OrangeBullet(getX(), getY() + 15);
            bulletList.add(newBullet);
            if (shotCounter > 0)
            {
                setShotCooldown(10);
                shotCounter--;
            }
            else
            {
                setShotCooldown(COOLDOWN);
                shotCounter = 2;
                Bullet laser1 = new EnemyLaserBlast(getX(), getY() - 15);
                Bullet laser2 = new EnemyLaserBlast(getX(), getY() + 45);
                bulletList.addAll(laser1, laser2);
                setSpeed(SPEED);
            }
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }

    @Override
    public void move()
    {
        setX(getX() - getSpeed());

        if (movingUp)
        {
            setY(getY() + getSpeed());
            moveCounter++;
        }
        else
        {
            setY(getY() - getSpeed());
            moveCounter++;
        }

        if (moveCounter > TRAVEL_TIME)
        {
            moveCounter = 0;
            movingUp = !movingUp;
        }
    }
}
