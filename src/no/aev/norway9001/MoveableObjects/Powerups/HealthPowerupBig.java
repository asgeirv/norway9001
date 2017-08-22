package no.aev.norway9001.MoveableObjects.Powerups;

import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.scene.image.Image;

public class HealthPowerupBig extends Powerup
{

    private static int HEALTH = 25;
    private static double SIZE = 75;

    public HealthPowerupBig()
    {
        setImage(new Image("powerups/hp-powerup01.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
    }

    public HealthPowerupBig(double initialX, double initialY)
    {
        super(initialX, initialY);
        setImage(new Image("powerups/hp-powerup01.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
    }

    public void hit(Player player)
    {
        player.heal(HEALTH);
        setImage(null);
        //TODO: Add animation?
    }
}
