package ejerciciosProgramacion;

import java.util.Scanner;

public class Articulo {
  private int codigo,unidades,stockMax,stockMin;
  private double compra,venta;
  private String descripcion;
  static int nArticulos=0;

   Articulo(String descrip,int uni,int max,int min,double precioCompra,double precioVenta){
     
     if(uni<0) {
       uni=20;
     }
     if(max<0 || max<=min) {
       max=100;
       min=5;
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
     codigo=codigoAutomatico();
     unidades=uni;
     stockMax=max;
     stockMin=min;
     compra=precioCompra;
     venta=precioVenta;
     descripcion=descrip;
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
    return ("Articulo["+this.codigo+"]."+"Descripcion: "+this.getDescripcion()+".Unidades: "+this.unidades+".Compra: "+this.getCompra()+".Venta: "+this.venta+".Stock minimo: "+this.getStockMin()+".Stock maximo: "+this.getStockMax()+"\n");
  }
  public static int codigoAutomatico(){
    int n=nArticulos;
    return n;
  }
  public static void modificar(String modif) {
    Scanner s=new Scanner(System.in);
    if(modif.equals("I")) {//Si el usuario quiere incrementar unidades
      int pos,num;
      
      do {//Cantidad pedida
        System.out.println("Inserta la cantidad para incrementar: ");
        num=s.nextInt();
        s.nextLine();
      }while(num<0);
      
      pos=TestAlmacen.controlCodigo(); //Codigo pedido
      
      if(!Almacen.modificarMercancia(num, pos)) {
        System.out.println("Mercancia no modificada");
      }
      else {
        System.out.println("Mercancia correctamente modificada");
        Almacen.imprimirTodos();
      }
      
      break;
    }
    else {//Si el usuario quiere decrementar unidades
      int pos,num;
      
      do {//Cantidad pedida
        System.out.println("Inserta la cantidad para decrementar: ");
        num=s.nextInt();
        s.nextLine();
      }while(num<0);
      
      pos=TestAlmacen.controlCodigo(); //Codido pedido
      
      if(!Almacen.modificarMercancia((num*-1), pos)) {
        System.out.println("Mercancia no modificada");
      }
      else {
        System.out.println("Mercancia correctamente modificada");
        Almacen.imprimirTodos();
      }
  }
}
