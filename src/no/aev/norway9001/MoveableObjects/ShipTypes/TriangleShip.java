package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.Enemy;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 * Created by Asgeir on 09.07.2017.
 */
public class TriangleShip extends Enemy
{

    private static final int SPEED = 12;
    private static final int MAX_HP = 10;
    private static final int POINTS = 15;
    private static final int COOLDOWN = 100;

    public TriangleShip()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        this.setImage(new Image("ships/triangle.png", 50, 50, true, true));
    }

    public TriangleShip(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        this.setImage(new Image("ships/triangle.png", 50, 50, true, true));
    }

    /**
     * This ship type doesn't shoot.
     * @param bulletList
     * @return null
     */
    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {

    }
}
