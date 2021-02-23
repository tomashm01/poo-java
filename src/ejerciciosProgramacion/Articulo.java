package ejerciciosProgramacion;

import java.util.Scanner;

public class Articulo {
  private int codigo,unidades,stockMax,stockMin;
  private double compra,venta;
  private String descripcion;
  static int nArticulos=0;

   Articulo(String descripcion,int cantidad,int cantidadMax,int cantidadMin,double precioCompra,double precioVenta){
     
     if(cantidad<0 || cantidad>cantidadMax || cantidad<cantidadMin) {
       cantidad=20;
       cantidadMax=100;
       cantidadMin=5;
     }
     if(cantidadMax<0 || cantidadMax<=cantidadMin) {
       cantidadMax=100;
       cantidadMin=5;
     }
     if(precioCompra<0) {
       precioCompra=10;
     }
     if(precioVenta<0) {
       precioVenta=30;
     }
     if(precioCompra>precioVenta) {
       precioVenta=30;
       precioCompra=10;
     }
     nArticulos++;
     this.codigo=getCodigoAutomatico();
     this.unidades=cantidad;
     this.stockMax=cantidadMax;
     this.stockMin=cantidadMin;
     this.compra=precioCompra;
     this.venta=precioVenta;
     this.descripcion=descripcion;
   }

  //Getters
   
  public int getCodigo() {
    return codigo;
  }

  public int getUnidades() {
    return unidades;
  }

  public int getStockMax() {
    return stockMax;
  }

  public int getStockMin() {
    return stockMin;
  }

  public double getCompra() {
    return compra;
  }

  public double getVenta() {
    return venta;
  }

  public String getDescripcion() {
    return descripcion;
  }
  
  public static int getCodigoAutomatico(){
    int n=nArticulos;
    return n;
  }
  
  //Setters
  
  public boolean setUnidades(int unidades) {
    if(unidades<0 || unidades>this.stockMax || unidades<this.stockMin) {
      return false;
    }
    this.unidades = unidades;
    return true;
  }

  public boolean setStockMax(int stockMax) {
    if(stockMax<0 || stockMax<this.stockMin) {
      return false;
    }
    this.stockMax = stockMax;
    return true;
  }

  public boolean setStockMin(int stockMin) {
    if(stockMin<0 || stockMin>this.stockMax) {
      return false;
    }
    this.stockMin = stockMin;
    return true;
  }

  public boolean setCompra(double compra) {
    if(compra<0 || compra>this.venta) {
      return false;
    }
    this.compra = compra;
    return true;
  }

  public boolean setVenta(double venta) {
    if(venta<0 || venta>this.compra) {
      return false;
    }
    this.venta = venta;
    return true;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return ("Articulo["+this.codigo+"]."+"Descripcion: "+this.getDescripcion()+". Unidades: "+this.unidades+". Compra: "+this.getCompra()+". Venta: "+this.venta+". Stock minimo: "+this.getStockMin()+". Stock maximo: "+this.getStockMax()+"\n");
  }
  
  /*
   * Esta funcion permite aumentar o decrementar las unidades de un articulo
   * 
   * @param String
   */
  
  public static void modificar(String tipoModificacion) {
    Scanner s=new Scanner(System.in);
    int posicion,cantidad;
    if(tipoModificacion.equals("I")) {//Si el usuario quiere incrementar unidades
      
      
      cantidad=pedirCantidad(tipoModificacion);//Pedir cantidad
      
      posicion=TestAlmacen.controlCodigo(); //Pedir codigo
      
      if(!Almacen.modificarMercancia(cantidad, posicion)) {
        System.out.println("Mercancia no modificada");
      }
      else {
        System.out.println("Mercancia correctamente modificada");
        Almacen.imprimirTodos();
      }
    }
    else {//Si el usuario quiere decrementar unidades
      
      cantidad=pedirCantidad(tipoModificacion);//Pedir cantidad
      
      posicion=TestAlmacen.controlCodigo(); //Pedir codigo
      
      if(!Almacen.modificarMercancia((cantidad*-1), posicion)) {
        System.out.println("Mercancia no modificada");
      }
      else {
        System.out.println("Mercancia correctamente modificada");
        Almacen.imprimirTodos();
      }
    }
  }
  
  /*
   * Esta funcion pide una cantidad al usuario y la devuelve
   * 
   * @param String
   * 
   * @return int
   */
  
  public static int pedirCantidad(String tipoModificacion) {
    int cantidad;
    Scanner s=new Scanner(System.in);
    if(tipoModificacion.equals("I")) {
      do {//Cantidad pedida
        System.out.println("Inserta la cantidad para incrementar: ");
        cantidad=s.nextInt();
        s.nextLine();
      }while(cantidad<0);
    }
    else {
      do {//Cantidad pedida
        System.out.println("Inserta la cantidad para decrementar: ");
        cantidad=s.nextInt();
        s.nextLine();
      }while(cantidad<0);
    }
    return cantidad;
  }
  
  /*
   * Esta funcion pide el tipo de modificacion sobre la cantidad de un articulo.
   * Es decir, si el usuario quiere incrementar o decrementar unidades de un articulo
   * 
   * @return String
   */
  
  public static String pedirTipoModificacion() {
    String letraMayuscula,letra;
    Scanner s=new Scanner(System.in);
    do {//Pedir datos 
      System.out.println("Deseas incrementar(I) o decrementar(D): ");
      letra=s.nextLine();
      letraMayuscula=letra.toUpperCase();
    }while(!letraMayuscula.equals("D") && !letraMayuscula.equals("I"));
    return letraMayuscula;
  }
}