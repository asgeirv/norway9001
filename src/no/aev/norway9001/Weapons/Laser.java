package no.aev.norway9001.Weapons;

import no.aev.norway9001.Game.Weapon;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.LaserBlast;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.collections.ObservableList;

public class Laser extends Weapon
{

    public Laser(Player owner)
    {
        super(owner);
    }

    @Override
    public void shoot(ObservableList<Bullet> bullets)
    {
        Player owner = getOwner();
        bullets.add(new LaserBlast(owner.getX() + owner.getFitWidth(), owner.getY() + 15));
    }
}
