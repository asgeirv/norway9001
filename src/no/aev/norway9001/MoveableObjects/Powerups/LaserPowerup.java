package no.aev.norway9001.MoveableObjects.Powerups;

import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import no.aev.norway9001.Weapons.DoubleGun;
import no.aev.norway9001.Weapons.Laser;
import javafx.scene.image.Image;

public class LaserPowerup extends Powerup
{
    private static double SPEED = 2;
    private static double SIZE = 50;

    public LaserPowerup()
    {
        setImage(new Image("powerups/laserpowerup.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    public LaserPowerup(double initialX, double initialY)
    {
        super(initialX, initialY);
        setImage(new Image("powerups/laserpowerup.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    @Override
    public void hit(Player player)
    {
        player.setCurrentWeapon(new Laser(player));
        setImage(null);
    }
}
