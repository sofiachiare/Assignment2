////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
public 
Categoria itemType;
String name;
double price;
public
MenuItem(Categoria c, String n, double p) {
this.itemType = c;
this.price = p;
this.name = n;
}
public
double getPrezzo () {
return this.price;
}
}
