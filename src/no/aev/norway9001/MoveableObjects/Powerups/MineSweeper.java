package no.aev.norway9001.MoveableObjects.Powerups;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.Mine;
import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class MineSweeper extends Powerup
{

    private static double SIZE = 50;
    private ObservableList<Bullet> bullets;

    public MineSweeper()
    {
        setImage(new Image("powerups/minesweeper.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
    }

    public MineSweeper(double initialX, double initialY)
    {
        super(initialX, initialY);
        setImage(new Image("powerups/minesweeper.png"));
        setFitWidth(SIZE);
        setFitHeight(SIZE);
    }

    @Override
    public void hit(Player player)
    {
        if (bullets != null)
        {
            for (Bullet currentBullet : bullets)
            {
                if (currentBullet.getClass() == Mine.class)
                    currentBullet.hit();
            }
        }
        setImage(null);
    }

    public void setBullets(ObservableList<Bullet> bullets)
    {
        this.bullets = bullets;
    }
}
