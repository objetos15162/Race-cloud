import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Puntos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntos extends Actor
{
    /**
     * Act - do whatever the Puntos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(-10);
    }
    public int limite()
    {
        return getX();
    }
}
