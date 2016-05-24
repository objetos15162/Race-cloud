import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstaculo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstaculo extends Actor
{
    private int dis = -15;
    /**
     * Act - do whatever the Obstaculo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() 
    {
        // Add your action code here.
        mov(dis);
    }
    public void mov(int dis)
    {
        move(dis);
    }
    public int limite()
    {
        return getX();
    }
    
    public void eligeObstaculo(int co)
    {
        if(co==0)
            setImage("obstaculo.png");
        if(co==1)
            setImage("obstaculo1.png");
        if(co==2)
            setImage("obstaculo2.png");
    }
    
}
