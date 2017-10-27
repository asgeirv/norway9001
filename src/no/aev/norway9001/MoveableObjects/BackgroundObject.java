package no.aev.norway9001.MoveableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundObject extends ImageView
{

    // Default speed
    private double speed = 0.5;

    public BackgroundObject(Image img)
    {
        super.setImage(img);
    }

    public BackgroundObject(Image img, double speed)
    {
        super.setImage(img);
        this.speed = speed;
    }

    public void move()
    {
        setX(getX() - speed);
    }

}
