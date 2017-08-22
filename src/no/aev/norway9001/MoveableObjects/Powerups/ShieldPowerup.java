package no.aev.norway9001.MoveableObjects.Powerups;

import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.scene.image.Image;

public class ShieldPowerup extends Powerup
{
    private static int SHIELD_DURATION = 5000;
    private static double SPEED = 1.5;
    private static double SIZE = 50;

    public ShieldPowerup()
    {
        setImage(new Image("powerups/shieldpowerup.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    public ShieldPowerup(double initialX, double initialY)
    {
        super(initialX, initialY);
        setImage(new Image("powerups/shieldpowerup.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    @Override
    public void hit(Player player)
    {
        player.setInvulnerable(SHIELD_DURATION);
        setImage(null);
    }
}
