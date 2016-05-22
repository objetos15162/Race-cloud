import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    int dis=-15;
    /**
     * Act - do whatever the BalaEnemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(dis);
    }
    public void mov(int dis)
    {
        move(dis);
    }
    public int limite()
    {
        return getX();
    }   
}
