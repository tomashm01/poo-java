package ejerciciosProgramacion;
import java.util.ArrayList;
public class Almacen {
  static ArrayList<Articulo> lista=new ArrayList<Articulo>();
  
  public static void alta(String descrip,int uni,int max,int min,double precioCompra,double precioVenta) {
    Articulo a=new Articulo(descrip,uni,max,min,precioCompra,precioVenta);
    lista.add(a);
  }
  public static boolean baja(int n) {
    for(int i=0;i<lista.size();i++) {
      if(n==lista.get(i).getCodigo()) {
        lista.remove(i);
        return true;
      }
    }
    return false;
  }
  public static boolean modificarMercancia(int num,int pos) {
    
    for(int i=0;i<lista.size();i++) {
      if(pos==lista.get(i).getCodigo()) {
        int cantidad= lista.get(i).getUnidades()+num;
        if(lista.get(i).setUnidades(cantidad)) {
          return true;
        }
      }
    }
    return false;
  }
  public static void imprimirTodos() {
    if(lista.size()==0) {
      System.out.println("Lista vacia");
    }
    for(int i=0;i<lista.size();i++) {
      System.out.println(lista.get(i).toString());
    }
  }
  public static boolean imprimirUno(int n) {
    for(int i=0;i<lista.size();i++) {
      if(n==lista.get(i).getCodigo()) {
        System.out.println(lista.get(i).toString());
        return true;
      }
    }
    return false;
  }
}
