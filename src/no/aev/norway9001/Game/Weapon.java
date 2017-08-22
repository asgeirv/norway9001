package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.collections.ObservableList;

public abstract class Weapon
{

    private Player owner;

    public Weapon(Player owner)
    {
        this.owner = owner;
    }

    public Player getOwner()
    {
        return owner;
    }

    public abstract void shoot(ObservableList<Bullet> bullets);
}
