import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo1 extends Actor
{
    /**
     * Act - do whatever the Enemigo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
        movimiento();
     
       // Add your action code here.
    }    


public void movimiento()
{
        int dis=30,x=getX(),y=getY();
        int r= Greenfoot.getRandomNumber(100);
        int q=Greenfoot.getRandomNumber(4);
         
        
      move(30);  
     if(r>50 && q==3)
      {
       setLocation(x,y-dis);
      }
       if(r<50 && q==3)
      {
       setLocation(x,y+dis);
    }
}
}