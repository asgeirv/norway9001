package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.Enemy;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;

public final class Aimbot
{

    public static final Aimbot INSTANCE = new Aimbot();
    private Player player;

    private Aimbot()
    {

    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void aim(Enemy enemy, Bullet... bullets)
    {
        try
        {
            double bulletSpeed = bullets[0].getxSpeed();

            // Calculate distances between ship and player
            double xDist = enemy.getX() - player.getX();
            double yDist = enemy.getY() - player.getY();
            double dist = Math.sqrt(xDist * xDist + yDist * yDist);

            // Calculate sine and cosine of the angle between ship and player
            double sin = yDist / dist;
            double cos = xDist / dist;

            // Calculate x and y speeds
            for (Bullet bullet : bullets)
            {
                bullet.setxSpeed(bulletSpeed * cos);
                bullet.setySpeed(bulletSpeed * sin);
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("**********" +
                    "\nHave you specified a Player object?" +
                    "\n**********");
            e.printStackTrace();
        }
    }
}
