import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Personaje extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int rota=0;
    public int disp=0;
    int posicion=200;
    
    public void act() 
    {
       movimiento();
    }    
    
    public int movimiento()
    {
        int dis=30,x=getX(),y=getY();
        String cadena = Greenfoot.getKey();
      
        rota=rota+1;  
        disp=disp+1;
        move(dis);
      if(cadena == "up")
      {
       setLocation(x,y-dis);
       setImage("Perso2.png");
      }
       if(cadena == "down")
      {
       setLocation(x,y+dis);
       setImage("Perso3.png");
      }
      if(cadena == "space")
      {
       setImage("Perso4.png");
      }
      if(rota==11)
      {
      setRotation(0);
      rota=0;
      }
      if(disp==15)
      {
      setImage("Perso1.png");
      disp=0;
      }
      
      Actor c = getOneObjectAtOffset(0, 0, Puntos.class);
        if(c != null) {
            getWorld().removeObject(c);
        }
        posicion+=dis;
      return posicion;
    } 
}
