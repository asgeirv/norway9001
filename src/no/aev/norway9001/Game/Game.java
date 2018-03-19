package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.BackgroundObject;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.Enemy;
import no.aev.norway9001.MoveableObjects.Powerup;
import no.aev.norway9001.MoveableObjects.Powerups.MineSweeper;
import no.aev.norway9001.MoveableObjects.ShipTypes.Aimer;
import no.aev.norway9001.MoveableObjects.ShipTypes.FinalBoss;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Asgeir on 03.06.2017.
 */
public class Game
{

    private Stage stage;
    private Scene mainMenu;
    private Level level;
    private Pane bgPane = new Pane();
    private Pane planetsPane = new Pane();
    private Pane shipsPane = new Pane();

    private FontsProvider fonts = new FontsProvider();
    private LevelTracker levelTracker;
    private Aimbot aimbot = Aimbot.getInstance();
    private Debugger debugger = Debugger.getInstance();

    private double windowWidth = Screen.getPrimary().getVisualBounds().getWidth();
    private double windowHeight = Screen.getPrimary().getVisualBounds().getHeight();
    private static final double FRAME_DURATION = 10;
    private int score = 0;
    private int currentBgObj = 0;
    private int currentWave = 0;
    private int currentPowerupWave = 0;
    private boolean running = true;

    private ObservableList<Bullet> enemyBullets = FXCollections.observableArrayList();
    private ObservableList<Bullet> playerBullets = FXCollections.observableArrayList();
    private ObservableList<Powerup> powerups = FXCollections.observableArrayList();

    private Player playerShip = new Player(0, (windowHeight / 2) - 25, 5);
    private ArrayList<BackgroundObject> bgObjs = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();

    private Label infoLabelBig = new Label();
    private Label infoLabelSmall = new Label();

    private Label hpLabel = new Label();
    private Label scoreLabel = new Label("Score: 0");

    private Random rng = new Random();

    private Timeline gameLoop;
    private long timer = 0;

    public Game(Stage stage, Scene mainMenu, Level level, LevelTracker levelTracker)
    {
        this.stage = stage;
        this.mainMenu = mainMenu;
        this.level = level;
        this.levelTracker = levelTracker;

        aimbot.setPlayer(playerShip);

        windowWidth = Screen.getPrimary().getVisualBounds().getWidth();
        windowHeight = Screen.getPrimary().getVisualBounds().getHeight();
    }

    /**
     * Main game loop.
     */
    public void run()
    {
        // UI layers
        StackPane root = new StackPane();
        root.setCursor(Cursor.CROSSHAIR);

        // Drop shadow effect for labels
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);

        // HP label
        hpLabel.setFont(fonts.getSpaceFontMedium());
        hpLabel.setTextFill(Color.WHITE);
        hpLabel.setEffect(dropShadow);

        // Score label
        scoreLabel.setFont(fonts.getSpaceFontMedium());
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setEffect(dropShadow);

        // Info labels
        VBox infoBox = new VBox();
        infoLabelBig.setFont(fonts.getSpaceFontLarge());
        infoLabelBig.setTextFill(Color.WHITE);
        infoLabelBig.setEffect(dropShadow);
        infoLabelSmall.setFont(fonts.getSpaceFontSmall());
        infoLabelSmall.setTextFill(Color.WHITE);
        infoLabelSmall.setEffect(dropShadow);
        infoLabelSmall.setTextAlignment(TextAlignment.CENTER);
        infoBox.getChildren().addAll(infoLabelBig, infoLabelSmall);
        infoBox.setSpacing(20);
        infoBox.setAlignment(Pos.CENTER);

        // Background image
        ImageView bgImg = new ImageView();
        bgImg.setImage(level.getBgImg());
        bgImg.setFitWidth(windowWidth);
        bgImg.setFitHeight(windowHeight + 50);

        // Set up UI
        root.getChildren().addAll(bgPane, planetsPane, shipsPane, hpLabel, scoreLabel, infoBox);
        bgPane.getChildren().add(bgImg);
        planetsPane.setMinSize(windowWidth, windowHeight);
        planetsPane.setMaxSize(windowWidth, windowHeight);
        shipsPane.setMinSize(windowWidth, windowHeight);
        shipsPane.setMaxSize(windowWidth, windowHeight);
        root.setAlignment(hpLabel, Pos.TOP_LEFT);
        root.setAlignment(scoreLabel, Pos.TOP_RIGHT);

        // Set up background objects
        bgObjs.addAll(level.getBgObjs());
        for (BackgroundObject bgObj : bgObjs)
        {
            planetsPane.getChildren().add(bgObj);
            bgObj.setX(windowWidth + 10);
            bgObj.setY((double) rng.nextInt((int) windowHeight) - 200);
        }

        shipsPane.getChildren().add(playerShip);

        Scene gameScene = new Scene(root);
        gameScene.setOnKeyReleased(this::keyReleased);
        gameScene.setOnKeyPressed(this::keyPressed);
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, playerShip.getKeyDownListener());
        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, playerShip.getKeyUpListener());
        stage.setScene(gameScene);
        stage.setFullScreen(true);
        stage.show();

        // Keep the screen updated with enemy bullets
        enemyBullets.addListener((ListChangeListener<Bullet>) c -> {
            c.next();
            shipsPane.getChildren().addAll(c.getAddedSubList());
        });

        // Keep the screen updated with player bullets
        playerBullets.addListener((ListChangeListener<Bullet>) c -> {
            c.next();
            shipsPane.getChildren().addAll(c.getAddedSubList());
        });

        // Create the main game loop
        KeyFrame k = new KeyFrame(Duration.millis(FRAME_DURATION), event -> doOneGameTick());
        gameLoop = new Timeline(k);
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }

    private void doOneGameTick()
    {
        sendWave();
        moveBgObjs();
        updateStatusLabels();
        movePlayer();
        moveEnemies();
        movePowerups();
        doEnemiesShoot();
        moveBullets();
        detectCollisions();
        checkIfLastWave();
        timer++;
    }

    private void movePowerups()
    {
        for (Powerup currentPowerup : powerups)
        {
            currentPowerup.move();
        }
    }

    /**
     * Checks if all waves have passed and if this is the case writes out a victory message.
     */
    private void checkIfLastWave()
    {
        if (currentWave >= level.getNumWaves() && enemies.isEmpty())
        {
            running = false;
            gameLoop.stop();
            infoLabelBig.setText("LEVEL CLEARED");
            infoLabelBig.setVisible(true);
            infoLabelSmall.setText("Your score: " + score + "\n" +
                    "Press 'Esc' to return to main menu.");
            infoLabelSmall.setVisible(true);

            hpLabel.setVisible(false);
            scoreLabel.setVisible(false);
            shipsPane.getChildren().removeAll(playerBullets);
            levelTracker.setCurrentLevel(levelTracker.getCurrentLevel() + 1);
        }
    }

    /**
     * Sends waves of enemy ships at the times specified by the wave.
     * Also sends powerups.
     */
    private void sendWave()
    {
        if (currentWave < level.getNumWaves())
        {
            if (timer == level.getWave(currentWave).getTime())
            {
                spawnEnemies(level.getWave(currentWave).getShips());
                debugger.printDebugInfo(this.getClass(), "Sending wave " + currentWave);
                currentWave++;
            }
        }

        if (currentPowerupWave < level.getNumPowerupWaves())
        {
            if (timer == level.getPowerupWave(currentPowerupWave).getTime())
            {
                spawnPowerups(level.getPowerupWave(currentPowerupWave).getPowerups());
                currentPowerupWave++;
            }
        }
    }

    /**
     * Spawns enemy ships.
     *
     * @param enemiesToSpawn A list of enemies to spawn.
     */
    private void spawnEnemies(ArrayList<Enemy> enemiesToSpawn)
    {
        Enemy currentEnemy;
        int numShips = enemiesToSpawn.size();
        int shipDistance;
        double shipHeight;
        for (int i = 1; i <= numShips; i++)
        {
            shipDistance = (int) windowHeight / (numShips + 1);
            currentEnemy = enemiesToSpawn.get(i - 1);
            shipHeight = currentEnemy.getImage().getHeight();
            enemies.add(currentEnemy);
            shipsPane.getChildren().add(currentEnemy);
            currentEnemy.setX(windowWidth);
            debugger.printDebugInfo(this.getClass(), "Enemy height = " + shipHeight);
            currentEnemy.setY((shipDistance * i) - (shipHeight / 2));
            if (currentEnemy.getClass() == FinalBoss.class)
            {
                FinalBoss boss;
                boss = (FinalBoss) currentEnemy;
                boss.setScreenBounds(windowWidth, windowHeight);
            }
        }
    }

    private void spawnPowerups(ArrayList<Powerup> powerupsToSpawn)
    {
        Powerup currentPowerup;
        int numPowerups = powerupsToSpawn.size();
        int pNum;
        int pDistance;
        for (int i = 0; i < numPowerups; i++)
        {
            pNum = i + 1;
            pDistance = (int) windowWidth / (numPowerups + 1);
            currentPowerup = powerupsToSpawn.get(i);
            powerups.add(currentPowerup);
            shipsPane.getChildren().add(currentPowerup);
            currentPowerup.setX(pDistance * pNum);
            currentPowerup.setY(-20);
        }
    }

    /**
     * Move all bullets on the screen.
     */
    private void moveBullets()
    {
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
        for (Bullet enemyBullet : enemyBullets)
        {
            enemyBullet.move();
            if (enemyBullet.getX() < -50 || enemyBullet.getImage() == null)
                bulletsToRemove.add(enemyBullet);
        }

        for (Bullet playerBullet : playerBullets)
        {
            playerBullet.move();
            if (playerBullet.getX() > windowWidth || playerBullet.getImage() == null)
                bulletsToRemove.add(playerBullet);
        }
        enemyBullets.removeAll(bulletsToRemove);
        playerBullets.removeAll(bulletsToRemove);
        shipsPane.getChildren().removeAll(bulletsToRemove);
    }

    /**
     * Let enemies shoot.
     */
    private void doEnemiesShoot()
    {
        for (Enemy enemy : enemies)
        {
            if (enemy.isAlive())
            {
                enemy.shoot(enemyBullets);
            }
        }
    }

    /**
     * Collision detection.
     */
    private void detectCollisions()
    {
        ArrayList<Enemy> deadEnemies = new ArrayList<>();
        ArrayList<Bullet> bulletsHit = new ArrayList<>();
        ArrayList<Powerup> powerupsHit = new ArrayList<>();

        for (Enemy es : enemies)
        {
            // Detect if player collides with enemy ships
            if (playerShip.intersects(es.getLayoutBounds()) && es.isAlive() && !playerShip.isInvulnerable())
            {
                playerShip.takeDamage(playerShip.getCollisionDmg());
                deadEnemies.add(es);
                es.die();
                score = score + es.getPoints();
            }
        }

        // Detect if player is hit by an enemy bullet
        for (Bullet eb : enemyBullets)
        {
            if (playerShip.intersects(eb.getLayoutBounds()) && !playerShip.isInvulnerable())
            {
                playerShip.takeDamage(eb.getDamage());
                bulletsHit.add(eb);
                eb.hit();
            }
        }

        // Detect if enemy ships are hit by player bullets
        for (Enemy es : enemies)
        {
            for (Bullet pb : playerBullets)
            {
                if (es.intersects(pb.getLayoutBounds()) && es.isAlive())
                {
                    es.takeDamage(pb.getDamage());
                    bulletsHit.add(pb);
                    pb.hit();
                    if (es.getCurrentHP() <= 0)
                    {
                        es.die();
                        deadEnemies.add(es);
                        score = score + es.getPoints();
                    }
                }
            }
        }

        // Detect if player touches any powerups
        for (Powerup p : powerups)
        {
            if (p.intersects(playerShip.getLayoutBounds()))
            {
                if (p.getClass() == MineSweeper.class)
                {
                    MineSweeper antiMine = (MineSweeper) p;
                    antiMine.setBullets(enemyBullets);
                }
                p.hit(playerShip);
                powerupsHit.add(p);
            }
        }

        enemies.removeAll(deadEnemies);
        enemyBullets.removeAll(bulletsHit);
        playerBullets.removeAll(bulletsHit);
        powerups.removeAll(powerupsHit);
    }

    /**
     * Move all enemy ships.
     */
    private void moveEnemies()
    {
        ArrayList<Enemy> enemiesToRemove = new ArrayList<>();

        for (Enemy enemy : enemies)
        {
            enemy.move();
            if (enemy.getX() < -enemy.getFitWidth() - 100)
            {
                enemiesToRemove.add(enemy);
                shipsPane.getChildren().remove(enemy);
            }
        }
        enemies.removeAll(enemiesToRemove);
    }

    /**
     * Update status labels.
     */
    private void updateStatusLabels()
    {
        scoreLabel.setText("Score: " + score);

        if (playerShip.getCurrentHP() >= 0)
            hpLabel.setText("HP: " + playerShip.getCurrentHP());
        else if (playerShip.getCurrentHP() < 0)
            hpLabel.setText("HP: 0");
    }

    /**
     * Move background objects in the background.
     */
    private void moveBgObjs()
    {
        BackgroundObject bgObj = bgObjs.get(currentBgObj);
        if (bgObj.getX() < -bgObj.getBoundsInParent().getWidth() + 10)
        {
            bgObj.setX(windowWidth + 10);
            bgObj.setY((double) rng.nextInt((int) windowHeight));
            if (currentBgObj == bgObjs.size() - 1)
                currentBgObj = 0;
            else
                currentBgObj++;
        }
        else
        {
            bgObj.move();
        }
    }

    /**
     * Move the player ship.
     */
    private void movePlayer()
    {
        double x = playerShip.getX();
        double y = playerShip.getY();
        if (playerShip.isAlive())
        {
            // Stay within bounds
            x += playerShip.getxVelocity();
            y += playerShip.getyVelocity();
            if (x < playerShip.getFitHeight() - 25)
                x = playerShip.getFitHeight() - 25;
            else if (x > windowWidth - playerShip.getFitWidth() - 25)
                x = windowWidth - playerShip.getFitWidth() - 25;
            else if (y < -50)
                y = playerShip.getFitHeight() - 50;
            else if (y > windowHeight)
                y = windowHeight;

            playerShip.setX(x);
            playerShip.setY(y);
        }
        else
        {
            pauseGame();
            hpLabel.setVisible(false);
            scoreLabel.setVisible(false);
            infoLabelBig.setText("GAME OVER");
            infoLabelBig.setVisible(true);
            infoLabelSmall.setText("Your score: " + score + "\n" +
                    "Press 'Esc' to return to main menu.");
            infoLabelSmall.setVisible(true);
        }

    }

    /**
     * Pauses and unpauses the game.
     */
    private void pauseGame()
    {
        if (running)
        {
            running = false;
            stage.getScene().setCursor(Cursor.DEFAULT);
            gameLoop.pause();
            infoLabelBig.setText("GAME PAUSED");
            infoLabelBig.setVisible(true);
            infoLabelSmall.setText("Press 'Esc' to return to main menu.");
            infoLabelSmall.setVisible(true);
        }
        else
        {
            if (playerShip.isAlive())
            {
                running = true;
                gameLoop.play();
                infoLabelBig.setVisible(false);
                infoLabelSmall.setVisible(false);
            }
        }
    }

    /**
     * Handle keyboard keyPressed events.
     *
     * @param ke The keyboard event to handle.
     */
    private void keyReleased(KeyEvent ke)
    {

        if (ke.getCode() == KeyCode.P)
        {
            pauseGame();
        }
        else if (ke.getCode() == KeyCode.ESCAPE)
        {
            if (!running)
            {
                stage.getScene().setCursor(Cursor.DEFAULT);
                mainMenu.setCursor(Cursor.DEFAULT);
                stage.setScene(mainMenu);
                stage.setFullScreen(true);
            }
        }
        else if (ke.getCode() == KeyCode.SPACE)
            playerShip.shoot(playerBullets);
    }

    private void keyPressed(KeyEvent ke)
    {

    }
}
