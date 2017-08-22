package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
import no.aev.norway9001.MoveableObjects.Enemy;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 * A Bouncer ship for the Norway 9001 game.
 * It shoots two bullets diagonally.
 * It also bounces back when hit.
 */
public class Bouncer extends Enemy
{

    private static final int SPEED = 1;
    private static final int MAX_HP = 100;
    private static final int POINTS = 50;
    private static final int COOLDOWN = 150;

    public Bouncer()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupBouncer();
    }

    public Bouncer(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupBouncer();
    }

    private void setupBouncer()
    {
        setImage(new Image("ships/bouncer.png", 50, 50, false, false));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet bullet1 = new OrangeBullet(getX(), getY());
            Bullet bullet2 = new OrangeBullet(getX(), getY() + 30);
            bullet1.setySpeed(-2);
            bullet2.setySpeed(2);
            bulletList.addAll(bullet1, bullet2);
            setShotCooldown(COOLDOWN);
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }

    @Override
    public int takeDamage(int damage)
    {
        super.takeDamage(damage);
        if (getCurrentHP() <= 1)
            die();
        else
            setX(getX() + 50);
        return getCurrentHP();
    }
}
