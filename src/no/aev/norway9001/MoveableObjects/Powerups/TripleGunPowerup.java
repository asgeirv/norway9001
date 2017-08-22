package no.aev.norway9001.MoveableObjects.Powerups;

import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import no.aev.norway9001.Weapons.TripleGun;
import javafx.scene.image.Image;

public class TripleGunPowerup extends Powerup
{

    private static double SPEED = 2;
    private static double SIZE = 50;

    public TripleGunPowerup()
    {
        setImage(new Image("powerups/triplegun.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    public TripleGunPowerup(double initialX, double initialY)
    {
        super(initialX, initialY);
        setImage(new Image("powerups/triplegun.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setySpeed(SPEED);
    }

    @Override
    public void hit(Player player)
    {
        player.setCurrentWeapon(new TripleGun(player));
        setImage(null);
    }
}
