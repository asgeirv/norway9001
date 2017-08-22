package no.aev.norway9001.MoveableObjects.Powerups;

import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import no.aev.norway9001.Weapons.DoubleGun;
import javafx.scene.image.Image;

public class DoubleGunPowerup extends Powerup
{

    private static double SPEED = 2;
    private static double SIZE = 50;

    public DoubleGunPowerup()
    {
        setImage(new Image("powerups/doublegun.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    public DoubleGunPowerup(double initialX, double initialY)
    {
        super(initialX, initialY);
        setImage(new Image("powerups/doublegun.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    @Override
    public void hit(Player player)
    {
        player.setCurrentWeapon(new DoubleGun(player));
        setImage(null);
    }
}
