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
        
         
        
     
     if(q==3 && getY()>350)
      {
       setLocation(x,y-dis);
      }
      if(getY()<500 && q==2)
      {
       setLocation(x,y+dis);
      
      }
    }
     
    public void eligeEnemigo(int nivel)
    {   
       if (nivel==2)
        setImage("enemigo1.png");
       if (nivel==3)
        setImage("enemigo2.png");
    }
    
 }
