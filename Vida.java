import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Actor
{
    
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
    }  
    
    public Vida()
    {

    }
    
     public void eligeVida(int vidas)
      {
       if (vidas==3)
           setImage("vida3.png");
       if (vidas==2)
           setImage("vida2.png");
       if (vidas==1)
           setImage("vida1.png");    
       if (vidas==0)
       {
           setImage("vida0.png");
       }
    } 
     
      

}
