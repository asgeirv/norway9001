package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.aev.norway9001.Game.Debugger;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.Enemy;

public class FinalBoss extends Enemy
{

    private static final double SPEED = 0.5;
    private static final int MAX_HP = 1000;
    private static final int POINTS = 15;
    private static final int COOLDOWN = 200;
    private static final int TRAVEL_TIME = 200; // measured in ticks
    private boolean movingDown = false;
    private int counter = 4;
    private Player player;

    private Debugger debugger = Debugger.INSTANCE;

    private double screenWidth;
    private double screenHeight;

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
