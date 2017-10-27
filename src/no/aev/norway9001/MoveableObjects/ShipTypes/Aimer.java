package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.aev.norway9001.Game.Aimbot;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
import no.aev.norway9001.MoveableObjects.Enemy;

/**
 * Created by Asgeir on 09.07.2017.
 */
public class Aimer extends Enemy
{

    private static final int SPEED = 1;
    private static final int MAX_HP = 40;
    private static final int POINTS = 15;
    private static final int COOLDOWN = 200;
    private int counter = 4;
    private Aimbot aimbot = Aimbot.INSTANCE;

    public Aimer()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/aimer.png", 50, 50, true, true));
    }

    public Aimer(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/aimer.png", 50, 50, true, true));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet newBullet = new OrangeBullet(getX(), getY() + 15);
            aimbot.aim(this, newBullet);
            bulletList.add(newBullet);
            if (counter > 0)
            {
                setShotCooldown(20);
                counter--;
            }
            else
            {
                setShotCooldown(COOLDOWN);
                counter = 4;
            }
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }
}
