package ejerciciosProgramacion;

import java.util.Scanner;

public class TestAlmacen {
  public static void main(String[] args) {
    int opcion;
    Scanner s=new Scanner(System.in);
    do {
      menu();
      System.out.println();
      System.out.println("Inserta una opcion: ");
      opcion=s.nextInt();
      s.nextLine();
      switch(opcion) {
        case 1://Crear jugador y añadirlo a la listaArticulos
          Almacen.introducirDatos();
          break;
        case 2: //ToString de un articulo insertado
          int toString=controlCodigo();
          
          if(!Almacen.imprimirUno(toString)) { //Error si no encuentra el elemento
            System.out.println("Elemento no encontrado en la listaArticulos");
          }
          break;
        case 3://ToString de todos los elementos en el almacen
          Almacen.imprimirTodos();          
          break;
        case 4://Eliminar articulo
          int eliminar=controlCodigo();
          
          if(!Almacen.baja(eliminar)) {//Control de error
            System.out.println("No se pudo eliminar el articulo de la listaArticulos");
            break;
          }
          
          Almacen.imprimirTodos();
          
          break;
        case 5://Modificar unidades de un articulo
          String modif;
          modif=Articulo.pedirTipoModificacion();
          Articulo.modificar(modif);
            break;
        case 6://Fin programa
          System.out.println("Hasta luego!");
          break;
        default://Error opcion
          System.out.println("Error en la opcion insertada");
          System.out.println();
          break;
      }
    }while(opcion!=6);
  }

  /*
   * Esta funcion es el menu del programa
   */
  
  public static void menu() {
    System.out.println("1.Crear articulo");
    System.out.println("2.Mostrar un articulo");
    System.out.println("3.Mostrar todos los articulos");
    System.out.println("4.Eliminar articulo");
    System.out.println("5.Modificar articulo");
    System.out.println("6.Salir");
  }
  
  /*
   *Esta funcion permite controlar el codigo insertado por el usuario 
   *
   *@return int
   */
  
  public static int controlCodigo() {
    int codigo;
    Scanner s=new Scanner(System.in);
    do {
      System.out.println("Inserta el codigo para buscar en la listaArticulos: ");
      codigo=s.nextInt();
      s.nextLine();
    }while(codigo<0);
    return codigo;
  }
}
