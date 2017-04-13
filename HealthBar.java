import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * -- An interactible HealthBar, changes in response to other actors
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private GreenfootImage frame;
    private GreenfootImage healthBar;
    
    private Color good;
    private Color warning;
    private Color danger;
    
    private int target;
    private int current;
    private int max;
    private int speed;
    
    public HealthBar()
    {
        frame = new GreenfootImage(200, 30);
        healthBar = new GreenfootImage(200, 30);
        frame.setColor(Color.GRAY);
        frame.fillRect(0, 0, 200, 30);
        good = Color.GREEN;
        warning = Color.YELLOW;
        danger = Color.RED;
        max = 1000;
        current = 1000;
        target = current;
        speed = 1;
        
        updateBar();
    }
    
    public HealthBar(int c, int m, int s)
    {
        frame = new GreenfootImage(200, 30);
        healthBar = new GreenfootImage(200, 30);
        frame.setColor(Color.GRAY);
        frame.fillRect(0, 0, 200, 30);
        good = Color.GREEN;
        warning = Color.YELLOW;
        danger = Color.RED;
        max = m;
        current = c;
        speed = s;
        
        updateBar();
    }
    
    public HealthBar(int c, int m, int s, Color g, Color w, Color d)
    {
        frame = new GreenfootImage(200, 30);
        healthBar = new GreenfootImage(200, 30);
        frame.setColor(Color.GRAY);
        frame.fillRect(0, 0, 200, 30);
        good = g;
        warning = w;
        danger = d;
        max = m;
        current = c;
        speed = s;
        
        updateBar();
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
            if(current > target)
            {
                if( current - speed < target)
                {
                    current = target;
                }
                else
                {
                    current -= speed;
                }
            }
            else if(current < target)
            {
                if(current + speed > target)
                {
                    current = target;
                }
                else
                {
                    current += speed;
                }
            }
            
            updateBar();
    }
    
    /**
     * updateBar causes the Healthbar object to change images in reaction to button presses
     * 
     * @param there are no parameters
     * @return Nothing is returned
     */
    private void updateBar()
    {
        GreenfootImage text = new GreenfootImage(200, 30);
        double ratio = current / (max * 1.0);
        int healthWidth = (int)Math.round(ratio * frame.getWidth());
        
        if( current > max/2)
        {
            healthBar.setColor(good);
        }
        else if( current > max/4)
        {
            healthBar.setColor(warning);
        }
        else
        {
            healthBar.setColor(danger);
        }
        
        healthBar.clear();
        healthBar.fillRect(0, 0, healthWidth, 30);
        
        text.clear();
        text.setColor(Color.BLACK);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.drawString(current + "/" + max, 0, 30 - text.getFont().getSize()/2);
        
        frame.clear();
        frame.setColor(Color.GRAY);
        frame.fillRect(0, 0, 200, 30);
        frame.drawImage(healthBar, 0, 0);
        frame.drawImage(text, frame.getWidth()/3, 0);
        
        setImage(frame);
    }
    
    /**
     * add causes the target to be changed by the value given in the Button Actor
     * 
     * @param int change is what number the target should change by
     * @return Nothing is returned
     */
    public void add(int change)
    {
        target = target + change;
        
        if(target > max)
        {
            target = max;
        }
        else if(target < 0)
        {
            target = 0;
        }
    }
    
    /**
     * setTarget sets the target value to be equal to the t value
     * 
     * @param int t is the value that target will be set to
     * @return Nothing is returned
     */
    public void setTarget(int t)
    {
        target = t;
    }
    
    /**
     * setCurrent sets the current value to be equal to the c value
     * 
     * @param int c is the value that target will be set to
     * @return Nothing is returned
     */
    public void setCurrent(int c)
    {
        current = c;
    }
    
    /**
     * setMax sets the max value to be equal to the m value
     * 
     * @param int m is the value that max will be set to
     * @return Nothing is returned
     */
    public void setMax(int m)
    {
        max = m;
    }
    
    /**
     * setSpeed sets the speed value to be equal to the s value
     * 
     * @param int s is the value that speed will be set to
     * @return Nothing is returned
     */
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    /**
     * getMax returns the max value when called
     * 
     * @param There are no parameters
     * @return Returns the max value
     */
    public int getMax()
    {
        return max;
    }
    
    /**
     * getCurrent returns the current value when called
     * 
     * @param There are no parameters
     * @return Returns the current value
     */
    public int getCurrent()
    {
        return current;
    }
}
