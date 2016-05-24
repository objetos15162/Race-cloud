import greenfoot.*;
import java.util.LinkedList;
import java.lang.Class;
/**
 * Hay que revisar el metodo selecciona, para que cuando se seleccione el personaje no sea tan lento 
 * y salga mas rapido de la tienda
 * crear la barra de vida y agregarla, tratar de cambiarla
 * revisar los personajes para ver como funcionan a ver si encuantras como valla mas rapido
 *
 * Class DWorld sub-clase de Sworld
 * @Author: 
 * @version  
 */
public class DragonWorld extends SWorld
{
    //Variables de los distintos botones que se usan durante el juego.
    private Button Start, Shop, Salir,psj1,psj2,psj3, Help;  
    private LinkedList <GreenfootImage> imagenes;
    private LinkedList <GreenfootImage> vidas;
    private Personaje p= new Personaje();
    private Puntos c = new Puntos();
    private Enemigo1 e1 = new Enemigo1();
    private Bala b1 = new Bala();
    private Vida v = new Vida();
    private int salida;
    private boolean existe = true;
    private  Obstaculo o = new Obstaculo();
    
    private int i = 0, j = 0, lvl=0, no=0 , bg=10;
    private int vida = 4;
    private int co=0;
  
  

    /**
     * Constructor que crea un mundo con scroll que contiene actor, un fondo, obstaculos, y objetos.
     * 
     */
    public DragonWorld()
    {    
        //super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        super(800,600,1,40000,600);

        imagenes = new LinkedList();
        imagenes.add(new GreenfootImage("menu.jpg"));      //0
        imagenes.add(new GreenfootImage("Shop.jpg"));      //1
        imagenes.add(new GreenfootImage("Start.png")); //2
        imagenes.add(new GreenfootImage("Score.png"));   //3
        imagenes.add(new GreenfootImage("logros.png"));//4
        imagenes.add(new GreenfootImage("Salir.png"));//5
        imagenes.add(new GreenfootImage("psj1.png"));   //6
        imagenes.add(new GreenfootImage("psj2.png"));//7
        imagenes.add(new GreenfootImage("psj3.png"));//8
        imagenes.add(new GreenfootImage("Help.png")); //9
        imagenes.add(new GreenfootImage("level1.jpg"));//10
        imagenes.add(new GreenfootImage("level2.jpg")); //11
         imagenes.add(new GreenfootImage("level3.jpg")); //12
        
    

        Start = new Button(getImagen(2));
        Shop = new Button(getImagen(4));
        Salir = new Button(getImagen(5));
        psj1 = new Button(getImagen(6));
        psj2 = new Button(getImagen(7));
        psj3 = new Button(getImagen(8));
        Help = new Button(getImagen(9));

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
        addObject(Help, 600, 100);
        Greenfoot.setSpeed(40);

    }
    
    /**
     * Metodo encargado de crear el nivel con
     * el fondo determinado y el actor principal
     */
    public int level1()
    {
        //removeObjects(getObjects(null));
        addMainActor(p, 300,450,0,300);
        
  
        GreenfootImage bag = new GreenfootImage(getImagen(bg));
        setScrollingBackground(bag); 
        return 1;

    }
    public int level2()
    {

        Greenfoot.setSpeed(80);
  
        GreenfootImage bag = new GreenfootImage(getImagen(bg));
        setScrollingBackground(bag); 
        return 2;

    }
    
    public int level3()
    {

        Greenfoot.setSpeed(100);
  
        GreenfootImage bag = new GreenfootImage(getImagen(bg));
        setScrollingBackground(bag); 
        return 2;

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
        addObject(psj1,150,150);
        addObject(psj2,350,150);
        addObject(psj3,550,150);
        
    }
    
    public void Help()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("help.jpg");
        setBackground(hp);
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
        j=j*(lvl+2);
        if(lvl==1)
        {
            salida=juego();
        }
        if(lvl==2)
        {
            
            level2();
            p.movimiento(60);
            c.mov(-50);
            b1.mov(-60);
            o.mov(-60);
            salida=juego();
        }
        if(lvl==3)
        {
            level3();
            p.movimiento(80);
            c.mov(-90);
            b1.mov(-100);
            o.mov(-100);
            salida=juego();
        }
        if(salida==2 )
             {
                loser();
             }
    }

    /**
     * metodo con el que se comienza el juego, se inician los puntos y se aumentan 
     * se crea el enemigo y este comienza a disparar
     */
    public int juego()
      {
          
       boolean a; 
       int regreso= 0;
       
       addObject(v,600,50); 
       v.eligeVida(vida);
       e1.eligeEnemigo(lvl);
       showText("Puntos: " + i, 200, 50);
       showText("Vida: " + vida, 50, 50);
       i= p.ganaPuntos(i,lvl,pExiste());
       vida = p.recibeDaño(vida,pExiste());
        
            if(j%2==0)
            {
                i=i+1;
                puntos();
                if((c.limite()/(lvl+1)) <= 0)
                removeObject(c);
            }
            
            
            if(j%5==0)
            {
                i=i+1; 
                o.eligeObstaculo(co); 
                obstaculos();
                if((o.limite()/(lvl+1)) <= 0)
                {
                removeObject(o);
                co++;
                if(co==3)
                    co=0;
                }
            }
                       
            if(i==10 && no==0)
            {
             no=creaEnemigo();
            }
            
            if(j%2==0 && no==1)
               {
                   balas();
                   if((b1.limite()/(lvl+1)) <= 0)
                        removeObject(b1);
               }
             
             if (i >= 500)
             {
                 lvl=2;
                 bg=11;
             }
             
             if (i >= 1500)
             {
                 lvl=3;
                 bg=12;
             }
             
             if (vida==0)
                  regreso=2;
             
             if(vida == 0)
             {  
                showText("Vida: " + vida, 50, 50); 
                loser();
             }
             
             if(p.posicion() > 39990)
                winner();
                
             return regreso;
            }
   /**
    * Metodo que crea capsulas dentro del escenario de manera aleatoria 
    */
   public void puntos()
    {
        int x= p.posicion()+500,y= Greenfoot.getRandomNumber(600);
        addObject(c, x, y);
       
    }
    
    public void obstaculos()
    {
        int x= p.posicion()+500,y= Greenfoot.getRandomNumber(600);
       
        while(y<200)
            y= Greenfoot.getRandomNumber(600);
        
        addObject(o, x, y);
       
    }
    
     /**
    * Metodo que crea un enemigo
    */
   public int creaEnemigo()
    {
        addObject(e1,p.posicion()+600, Greenfoot.getRandomNumber(600));
        return 1;
       
    }
    
    /**
    * Metodo que crea las balas del enemigo
    */
   public void balas()
    {
        if(e1 != null)
        {
        int x= p.posicion()+250,y= e1.getY();
        addObject(b1,x,y);
    }
       
    }

    /**
     *Metodo encargado de controlar los eventos de 
     *los botones que se encuentran en la pantalla de menu 
     *se crean los botones con los personajes para cuando sean seleccionado 
     *cambie la imagen de nuestros personajes
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
            lvl = level1();
        }
        
         if(Greenfoot.mouseClicked(Help)) {
            removeObjects(getObjects(null));
            Help();
        }
        
        if(p != null)
        {
            if(Greenfoot.mouseClicked(psj1)) 
                p.eligePersonaje(0);
                
            if(Greenfoot.mouseClicked(psj2))
                p.eligePersonaje(4);
                
            if(Greenfoot.mouseClicked(psj3)) 
                p.eligePersonaje(8);
                
        
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
   
    public void loser()
    {
        removeObjects(getObjects(null));

        GreenfootImage hp = new GreenfootImage("loser.jpg");
        setBackground(hp);
        Greenfoot.stop();
        
    }
    
    public boolean pExiste()
    {
        return existe;
    }
    public void winner()
    {
        removeObjects(getObjects(null));
        GreenfootImage hp = new GreenfootImage("winner.jpg");
        setBackground(hp);
        Greenfoot.stop();
    }
    
    public int vidas()
    {
        return vida;
    }

    
    
}
