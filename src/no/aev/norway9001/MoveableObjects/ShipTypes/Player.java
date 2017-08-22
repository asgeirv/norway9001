package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.Game.Weapon;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.Ship;
import no.aev.norway9001.Weapons.BasicGun;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * Class representing a player ship.
 * A player ship can move with WASD and the arrow keys.
 * A player ship can die. Suicide key is U.
 *
 * @author Asgeir
 */
public class Player extends Ship
{

    private double xVelocity, yVelocity;
    private static final int DEFAULT_MAX_HP = 100;
    private static final int COLLISION_DMG = 10;
    private static final int COOLDOWN = 5;
    private int counter = COOLDOWN;
    private boolean isInvulnerable = false;
    private Weapon currentWeapon;

    private Timeline invincibility = new Timeline();

    /**
     * Default constructor. Sets max HP to DEFAULT_MAX_HP.
     *
     * @param initialX     Initial X position of player.
     * @param initialY     Initial Y position of player.
     * @param initialSpeed Initial speed of player.
     */
    public Player(double initialX, double initialY, double initialSpeed)
    {
        super(initialX, initialY, initialSpeed, DEFAULT_MAX_HP);
        setupPlayer();
    }

    /**
     * Custom HP constructor. Allows to set a custom amount of starting HP.
     *
     * @param initialX     Initial X position of player.
     * @param initialY     Initial Y position of player.
     * @param initialSpeed Initial speed of player.
     * @param maxHP        Starting HP of player.
     */
    public Player(double initialX, double initialY, double initialSpeed, int maxHP)
    {
        super(initialX, initialY, initialSpeed, maxHP);
        setupPlayer();
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        currentWeapon.shoot(bulletList);
    }

    private void setupPlayer()
    {
        xVelocity = 0;
        yVelocity = 0;
        this.setImage(new Image("ships/player.png", 50, 50, true, true));
        setDeathExplosion(new Image("effects/asplode.png"));
        currentWeapon = new BasicGun(this);
        invincibility.getKeyFrames().add(new KeyFrame(Duration.millis(500), (event) ->
        {
            setOpacity(1);
            isInvulnerable = false;
        }));
        invincibility.setCycleCount(1);
    }

    /**
     * Event handler for starting player movement.
     * The player will only move in a specified direction as long as the corresponding key is held down.
     */
    private EventHandler<KeyEvent> keyDownListener = ke ->
    {
        if (ke.getCode() == KeyCode.UP || ke.getCode() == KeyCode.W)
        {
            //Move up
            yVelocity = -getSpeed();
        }
        else if (ke.getCode() == KeyCode.A || ke.getCode() == KeyCode.LEFT)
        {
            // Move left
            xVelocity = -getSpeed();
        }
        else if (ke.getCode() == KeyCode.S || ke.getCode() == KeyCode.DOWN)
        {
            // Move down
            yVelocity = getSpeed();
        }
        else if (ke.getCode() == KeyCode.D || ke.getCode() == KeyCode.RIGHT)
        {
            // Move right
            xVelocity = getSpeed();
        }
        ke.consume();
    };

    /**
     * Event handler for stopping player movement. (Killing a player technically stops them from moving.)
     * The player will stop moving in a specific direction when the corresponding key is released.
     */
    private EventHandler<KeyEvent> keyUpListener = ke ->
    {
        if (ke.getCode() == KeyCode.UP || ke.getCode() == KeyCode.W || ke.getCode() == KeyCode.DOWN || ke.getCode() == KeyCode.S)
            yVelocity = 0;
        else if (ke.getCode() == KeyCode.RIGHT || ke.getCode() == KeyCode.D || ke.getCode() == KeyCode.LEFT || ke.getCode() == KeyCode.A)
            xVelocity = 0;
            // Suicide button
        else if (ke.getCode() == KeyCode.U)
            die();
    };

    public EventHandler<KeyEvent> getKeyDownListener()
    {
        return keyDownListener;
    }

    public EventHandler<KeyEvent> getKeyUpListener()
    {
        return keyUpListener;
    }

    public double getxVelocity()
    {
        return xVelocity;
    }

    public void setxVelocity(double newVelocity)
    {
        xVelocity = newVelocity;
    }

    public double getyVelocity()
    {
        return yVelocity;
    }

    public void setyVelocity(double newVelocity)
    {
        yVelocity = newVelocity;
    }


    public int getCollisionDmg()
    {
        return COLLISION_DMG;
    }

    @Override
    public void die()
    {
        alive = false;
        setImage(getDeathExplosion());
        // TODO: Add code for a cooler death animation
    }

    /**
     * Take damage.
     * Deal with invincibility frames.
     *
     * @param damage The incoming amount of damage.
     * @return Amount of HP remaining after taking damage.
     */
    @Override
    public int takeDamage(int damage)
    {
        if (!isInvulnerable)
        {
            setHP(getCurrentHP() - damage);
            if (getCurrentHP() <= 1)
                die();
            else
            {
                isInvulnerable = true;
                setOpacity(0.25);
                invincibility.playFromStart();
            }
        }

        return getCurrentHP();
    }

    /**
     * Changes the player's weapon.
     *
     * @param newWeapon The new weapon type for the player.
     */
    public void setCurrentWeapon(Weapon newWeapon)
    {
        currentWeapon = newWeapon;
    }

    /**
     * Increases the player's current hit points.
     *
     * @param hp The amount of hit points to add to the player's health.
     */
    public void heal(int hp)
    {
        if (getCurrentHP() + hp >= DEFAULT_MAX_HP)
        {
            setHP(DEFAULT_MAX_HP);
        }
        else
        {
            setHP(getCurrentHP() + hp);
        }
    }

    public boolean isInvulnerable()
    {
        return isInvulnerable;
    }

    public void setInvulnerable(int time)
    {
        invincibility.pause();
        KeyFrame k = new KeyFrame(Duration.millis(time), event -> {
            isInvulnerable = false;
            setOpacity(1);
        });
        isInvulnerable = true;
        setOpacity(0.25);
        Timeline invulnerable = new Timeline(k);
        invulnerable.setCycleCount(1);
        invulnerable.play();
    }
}
