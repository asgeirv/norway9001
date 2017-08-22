package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.EnemyLaserBlast;
import no.aev.norway9001.MoveableObjects.Enemy;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class DiamondShip extends Enemy
{
    private static final double SPEED = 1.5;
    private static final int MAX_HP = 40;
    private static final int POINTS = 30;
    private static final int COOLDOWN = 150;

    private boolean movingUp = false;
    private boolean movingForwards = true;
    private int xCounter = 0;
    private int yCounter = 0;
    private static final int FORWARDS_TIME = 100; // measured in ticks
    private static final int BACKWARDS_TIME = 80;
    private static final int VERTICAL_TIME = FORWARDS_TIME + BACKWARDS_TIME;

    public DiamondShip()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupDiamondShip();
    }

    public DiamondShip(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupDiamondShip();
    }

    private void setupDiamondShip()
    {
        this.setImage(new Image("ships/diamond.png", 50, 50, true, true));
        yCounter = VERTICAL_TIME / 2;
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet newBullet = new EnemyLaserBlast(getX(), getY() + 15);
            bulletList.add(newBullet);
            setShotCooldown(COOLDOWN);
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }

    @Override
    public void move()
    {
        if (movingForwards)
        {
            setX(getX() - getSpeed());
            xCounter++;
        }
        else
        {
            setX(getX() + getSpeed());
            xCounter++;
        }

        if ((xCounter > FORWARDS_TIME) && movingForwards)
        {
            xCounter = 0;
            movingForwards = !movingForwards;
        }

        if ((xCounter > BACKWARDS_TIME) && !movingForwards)
        {
            xCounter = 0;
            movingForwards = !movingForwards;
        }

        if (movingUp)
        {
            setY(getY() + getSpeed());
            yCounter++;
        }
        else
        {
            setY(getY() - getSpeed());
            yCounter++;
        }

        if (yCounter > VERTICAL_TIME)
        {
            yCounter = 0;
            movingUp = !movingUp;
        }
    }
}
