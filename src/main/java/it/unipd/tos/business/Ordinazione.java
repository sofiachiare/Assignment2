////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.Categoria;
import it.unipd.tos.model.MenuItem;

public class Ordinazione implements TakeAwayBill {

@Override
public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException{
double totale =0;
int contaGelati = 0;
double totBudGel =0;
for(MenuItem a : itemsOrdered) {
totale+=a.getPrezzo();
if (a.itemType==Categoria.Gelati || a.itemType==Categoria.Budini) {
contaGelati++;
totBudGel+=a.getPrezzo();
}
}
MenuItem min = new MenuItem(Categoria.Gelati, "prova", 9999999);
if (contaGelati>=5){
for(MenuItem b : itemsOrdered) {
if(b.itemType==Categoria.Gelati) {
if(b.getPrezzo()<min.getPrezzo()) {
min=b;
} 
}
}
totale=totale-(min.getPrezzo()/2);
totBudGel=totBudGel-(min.getPrezzo()/2);
}
if(totBudGel>50) {
totale=totale-(totale*0.10);
}
return totale;
}
}
