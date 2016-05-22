import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.LinkedList;
import java.lang.Class;


public class Personaje extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private LinkedList <GreenfootImage> imagenes;
    public int disp=0, pj;
    int posicion=200, dis=30;
    
    
    public void act() 
    {
       movimiento(dis);
    }    
    /**
     * se crea una lista de imagenes con los personajes y sus movimientos
     */
    public Personaje()
    {
        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("Goku1.png"));      //0
        imagenes.add(new GreenfootImage("Goku2.png"));      //1
        imagenes.add(new GreenfootImage("Goku3.png")); //2
        imagenes.add(new GreenfootImage("Goku4.png"));   //3
        imagenes.add(new GreenfootImage("Milk1.png"));//4
        imagenes.add(new GreenfootImage("Milk1.png"));//4
        imagenes.add(new GreenfootImage("Milk1.png"));//4
        imagenes.add(new GreenfootImage("Milk1.png"));//4
    }
    
    /**
     * se crea el movimiento del personaje y aumenta una variable con su posicion actual
     * llama los metodos ganaPuntos() y recibeDaño() a demas de cambiar la imagen de mov
     */
    public void movimiento(int dis)
    {
       int x=getX(),y=getY();
        String cadena = Greenfoot.getKey();
      
        disp=disp+1;
        move(dis);
      if(cadena == "up")
      {
       setLocation(x,y-dis);
       setImage(getImagen(pj+1));
      }
       if(cadena == "down")
      {
       setLocation(x,y+dis);
       setImage(getImagen(pj+2));
      }
      if(cadena == "space")
      {
       setImage(getImagen(pj+3));
      }
      
      if(disp==15)
      {
      setImage(getImagen(pj));
      disp=0;
      }
      //ganaPuntos();
      //recibeDaño();
       posicion+=dis;
      
    } 
    
    /**
     * revisa si es que el personaje entra en contacto con una capsula esta desaparesca
     */
    public int ganaPuntos(int puntos,int lvl, boolean ex)
    {
        int i=puntos; 
        if(ex)
        {
        Actor c = getOneObjectAtOffset(0, 0, Puntos.class);
         
        if(c != null) {
            getWorld().removeObject(c);
            i = puntos + (50*lvl);
            
            }
        }
        return i;
    }
    
    /**
     * revisa si entra en contacto con una bala y disminuira la barra de vida
     */
    public int recibeDaño(int vida,boolean ex)
    {
        int i;
        i=vida;
        if(ex)
        {
        Actor b1 = getOneObjectAtOffset(20, 0, Bala.class);
        if(b1!= null)
        {
            getWorld().removeObject(b1);
            i= vida - 1;
        }
        
        Actor o = getOneObjectAtOffset(20, 0, Obstaculo.class);
        if(o!= null)
        {
            getWorld().removeObject(o);
            i= vida - 1;
        }
      }
        
        return i;
    }
    
    /**
     * manda la posicion que se creea en movimiento
     */
    public int posicion()
    {
        return posicion;
    }
    
        /**
     * Metodo que devolvera una imagen (tipo GreenfootImage)
     * que contiene nuestra lista de imagenes y sera asignada
     * a los distintos objetos del escenario.
     * 
     * @param int Valor de la posición de la imágen que se
     * desea obtener.
     * @return GreenfootImage - Imágen contenida en la Lista
     * en la posición especificada.
     */
    public GreenfootImage getImagen(int n)
    {
        return imagenes.get(n);
    }
}
