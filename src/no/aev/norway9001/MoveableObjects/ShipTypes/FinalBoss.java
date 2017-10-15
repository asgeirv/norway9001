package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.Enemy;

public class FinalBoss extends Enemy
{

    private static final int SPEED = 1;
    private static final int MAX_HP = 1000;
    private static final int POINTS = 15;
    private static final int COOLDOWN = 200;
    private int counter = 4;
    private Player player;

    public FinalBoss()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/finalboss.png"));
    }

    public FinalBoss(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/finalboss.png"));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {

    }
}
