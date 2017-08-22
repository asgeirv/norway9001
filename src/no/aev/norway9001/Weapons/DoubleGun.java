package no.aev.norway9001.Weapons;

import no.aev.norway9001.Game.Weapon;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.GreenBullet;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.collections.ObservableList;

public class DoubleGun extends Weapon
{

    public DoubleGun(Player owner)
    {
        super(owner);
    }

    @Override
    public void shoot(ObservableList<Bullet> bullets)
    {
        Player owner = getOwner();
        bullets.add(new GreenBullet(owner.getX() + owner.getFitWidth(), owner.getY() + 8));
        bullets.add(new GreenBullet(owner.getX() + owner.getFitWidth(), owner.getY() + 22));
    }
}
