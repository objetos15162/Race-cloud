import greenfoot.*;
import java.util.LinkedList;
import java.lang.Class;
/**
 * Class DWorld sub-clase de Sworld
 * @Author: 
 * @version  
 */
public class DragonWorld extends SWorld
{
    //Variables de los distintos botones que se usan durante el juego.
    private Button Start, Shop, Salir;
    
    private LinkedList <GreenfootImage> imagenes;
    private MouseInfo info;
    public Personaje p= new Personaje();
    public Puntos c = new Puntos();
    public int i = 0, j = 0, t = 0,lvl1=0;
    public Enemigo1 e1 = new Enemigo1();
  

    /**
     * Constructor que crea un mundo con scroll que contiene actor, un fondo, obstaculos, y objetos.
     * 
     */
    public DragonWorld()
    {    
        //super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        super(800,600,1,50000,600);

        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("menu.jpg"));      //0
        imagenes.add(new GreenfootImage("Shop.jpg"));      //1
        imagenes.add(new GreenfootImage("Start.png")); //2
        imagenes.add(new GreenfootImage("Score.png"));   //3
        imagenes.add(new GreenfootImage("logros.png"));//4
        imagenes.add(new GreenfootImage("Salir.png"));//5
       
        

        Start = new Button(getImagen(2));
        Shop = new Button(getImagen(4));
        Salir = new Button(getImagen(5));

        menu();

    }
    
   /**
     * Crea el menu del juego agregando los objetos
     * necesarios para este ademas de definir la 
     * velocidad del juego.
     */
    public void menu()
    {
        removeObjects(getObjects(null));
        setBackground(getImagen(0));
        addObject(Start, 200, 100);
        addObject(Shop, 400, 100);
        Greenfoot.setSpeed(40);

    }
    
    /**
     * Metodo encargado de crear el nivel con
     * el fondo determinado y el actor principal
     */
    public int level1()
    {
        removeObjects(getObjects(null));
        addMainActor(p, 300,450,0,300);
        addObject(Salir,100,50);

        GreenfootImage bg = new GreenfootImage("level1.jpg");
        setScrollingBackground(bg); 
        return 1;

    }
    
    /**
     * Metodo que permite mostrar al usuario
     * una tienda donde puede ver sus objetos 
     * y escenarios desbloqueables.
     */
    public void Shop()
    {
        removeObjects(getObjects(null));

        GreenfootImage bg = new GreenfootImage("Shop.jpg");
        setBackground(bg);
        addObject(Salir,100,50);
        
    }
  
    /**
     * Metodo act() por el se determina el estado actual 
     * del personaje ademas del nivel y los obstaculos 
     * y premios que puede llegar a tener.
     */
    public void act()
    {            
        super.act();
        seleccionar();
        if(lvl1==1)
        {
            juego();
        }
    
    }

    public void juego()
      {
       boolean a; 
       int no=0;
        
            if(j%10==0)
       
            {
                i=i+1;
                puntos();
                if(c.limite() <= 0)
                removeObject(c);
            }
       
            showText("Puntos: " + i, 200, 50);
            //showText("localizacion: " + p.movimiento(), 200, 65);
            
            if(i==10 && no==0)
            {
             addObject(e1,p.movimiento()+500, Greenfoot.getRandomNumber(600));
             no=1;
            }
    }
   /**
    * Metodo que crea capsulas dentro del escenario de manera aleatoria 
    */
   public void puntos()
    {
        int x= p.movimiento()+500,y= Greenfoot.getRandomNumber(600);
        addObject(c, x, y);
       
    }

    /**
     *Metodo encargado de controlar los eventos de 
     *los botones que se encuentran en la pantalla de menu 
     */
    public void seleccionar()
    {
        if(Greenfoot.mouseClicked(Salir)) {

            removeObjects(getObjects(null));
            menu();
        }
        if(Greenfoot.mouseClicked(Shop)) {

            removeObjects(getObjects(null));
            Shop();
        }
        if(Greenfoot.mouseClicked(Start)) {

            removeObjects(getObjects(null));
            lvl1 = level1();
        }

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

    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto jugar de la clase Boton.
     */
    public Button getJugar()
    {
        return Start;
    }

    /**
     * Este método regresa un objeto en especifico de la clase Boton.
     * 
     * @return Boton - Objeto record de la clase Boton.
     */
    public Button getAyuda()
    {
        return Shop;
    }

    
    
}
