package ejerciciosProgramacion;
import java.util.ArrayList;
import java.util.Scanner;
public class Almacen {
  static ArrayList<Articulo> listaArticulos=new ArrayList<Articulo>();
  
  /*
   * Esta funcion crea un nuevo articulo y lo añade a la listaArticulos
   * 
   * @param String
   * @param int
   * @param int
   * @param int
   * @param double
   * @param double
   */
  
  public static void alta(String descripcion,int cantidad,int cantidadMax,int cantidadMin,double precioCompra,double precioVenta) {
    Articulo a=new Articulo(descripcion,cantidad,cantidadMax,cantidadMin,precioCompra,precioVenta);
    listaArticulos.add(a);
  }
  
  /*
   * Esta funcion busca un articulo por su codigo en la listaArticulos y lo elimina si existe
   * 
   * @param int
   * 
   * @return boolean
   */
  
  public static boolean baja(int codigo) {
    for(int i=0;i<listaArticulos.size();i++) {
      if(codigo==listaArticulos.get(i).getCodigo()) {
        listaArticulos.remove(i);
        return true;
      }
    }
    return false;
  }
  
  /*
   * Esta funcion permite modificar la cantidad del articulo segun su codigo
   * 
   * @param int
   * @param int
   * 
   * @return boolean
   */
  
  public static boolean modificarMercancia(int cantidad,int codigo) {
    for(int i=0;i<listaArticulos.size();i++) {
      if(codigo==listaArticulos.get(i).getCodigo()) {
        int cantidadFinal= listaArticulos.get(i).getUnidades()+cantidad;
        if(listaArticulos.get(i).setUnidades(cantidadFinal)) {
          return true;
        }
      }
    }
    return false;
  }
  
  /*
   *Esta funcion imprime todos los articulos de la listaArticulos 
   */
  
  public static void imprimirTodos() {
    if(listaArticulos.size()==0) {
      System.out.println("Lista vacia");
    }
    for(int i=0;i<listaArticulos.size();i++) {
      System.out.println(listaArticulos.get(i).toString());
    }
  }
  
  /*
   *Esta funcion imprime un articulo buscado por su codigo de la listaArticulos 
   *
   *@param int
   *
   *@return boolean   *
   */
  
  public static boolean imprimirUno(int codigo) {
    for(int i=0;i<listaArticulos.size();i++) {
      if(codigo==listaArticulos.get(i).getCodigo()) {
        System.out.println(listaArticulos.get(i).toString());
        return true;
      }
    }
    return false;
  }
  
  /*
   * Esta funcion pide al usuario los datos de un articulo y lo añade a la listaArticulos el articulo creado
   */
  
  public static void introducirDatos() {
    String descripcion;
    int cantidad,cantidadMax,cantidadMin;
    double precioCompra,precioVenta;
    Scanner s=new Scanner(System.in);
    
    descripcion=introducirDatosString("Introduce una descripcion: ");
    
    cantidad=introducirDatosEnteros("Introduce una cantidad de unidades: ");
    s.nextLine();
    
    cantidadMin=introducirDatosEnteros("Introduce una cantidad minima: ");
    s.nextLine();
    
    cantidadMax=introducirDatosEnteros("Introduce una cantidad maxima: ");
    s.nextLine();
    
    precioCompra=introducirDatosDouble("Introduce una cantidad de compra: ");
    s.nextLine();
    
    precioVenta=introducirDatosDouble("Introduce una cantidad de venta: ");
    s.nextLine();
    
    Almacen.alta(descripcion,cantidad,cantidadMax,cantidadMin,precioCompra,precioVenta);
  }
  
  /*
   * Esta funcion imprime un mensaje y devuelve un String
   * 
   * @param String
   * 
   * @return String
   */
  
  public static String introducirDatosString(String mensaje) {
    Scanner s=new Scanner(System.in);
    System.out.println(mensaje);
    return (s.nextLine());
  }
  /*
   * Esta funcion imprime un mensaje y devuelve un entero
   * @param String
   * @return int
   */
  
  public static int introducirDatosEnteros(String mensaje) {
    Scanner s=new Scanner(System.in);
    System.out.println(mensaje);
    return (s.nextInt());
  }
  
  /*
   * Esta funcion imprime un mensaje y devuelve un double
   * 
   * @param String
   * 
   * @return Double
   */
  
  public static Double introducirDatosDouble(String mensaje) {
    Scanner s=new Scanner(System.in);
    System.out.println(mensaje);
    return (s.nextDouble());
  }
}
