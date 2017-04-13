import greenfoot.*;
import java.awt.Color;

/**
 * Space. Something for rockets to fly in.
 * 
 * Author: Gade Ricard
 * Teacher: Mr. Hardman
 * Assignment #2 (Modified for assignment #3 bonus marks)
 * Date Last Modified: April 13th
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();

        paintStars(300);

        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);

        addAsteroids(startAsteroids);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        prepare();
    }

    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing.
        ScoreBoard endGame = new ScoreBoard( scoreCounter.getValue() );
        addObject(endGame, getWidth()/2, getHeight()/2);
    }

    /**
     * paintStars adds stars to the background as decoration with random X and Y
     * locations and random transparencies
     * 
     * @param count determines how many stars are created
     * @return There is no return type
     */
    private void paintStars(int count)
    {
        int x;
        int y;
        int transparency;

        GreenfootImage background = getBackground();

        for(int i = 0; i < count; i++)
        {
            x = Greenfoot.getRandomNumber( getWidth() );
            y = Greenfoot.getRandomNumber( getHeight() );
            transparency = Greenfoot.getRandomNumber( 256 );
            background.setColor(new Color(255,255,255,transparency));
            background.fillOval(x, y, 2, 2);
        }
    }

    /**
     * countScore will add a certain number of points to the score counter
     * 
     * @param score is a number that will be added to the score counter
     * @return Nothing is returned
     */
    public void countScore(int score)
    {
        scoreCounter.add(score);
    }

    /**
     * -- Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        HealthBar healthbar = new HealthBar();
        addObject(healthbar,468,444);
        healthbar.setLocation(501,484);
    }
}