////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;



public class MenuItem {
public 
Categoria itemType;
String name;
double price;
public double orario;
public
MenuItem(Categoria c, String n, double p, double o) {
this.itemType = c;
this.price = p;
this.name = n;
this.orario=o;

}
public
double getPrezzo () {
return this.price;
}
}
