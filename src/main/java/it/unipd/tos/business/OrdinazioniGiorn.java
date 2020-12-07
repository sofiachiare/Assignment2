////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import java.util.Random;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.Categoria;
import it.unipd.tos.model.MenuItem;

public class OrdinazioniGiorn implements TakeAwayBill {



public int cont;

public OrdinazioniGiorn() {

cont = 0;
}

public OrdinazioniGiorn(int c) {

cont = c;
}

@Override
public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException{
double totale =0;
int conta = 0;
int contaGelati = 0;
double totBudGel =0;
for(MenuItem a : itemsOrdered) {
conta++;
totale+=a.getPrezzo();
if (a.itemType==Categoria.Gelati || a.itemType==Categoria.Budini) {
contaGelati++;
totBudGel+=a.getPrezzo();
}
}
MenuItem min = new MenuItem(Categoria.Gelati, "prova", 9999999, 16);
if(conta<=30) {
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

totale=totale-(totale*controlloGelati(totBudGel));


MenuItem primo = itemsOrdered.get(0);
totale=controlloTotale(totale);
if(controlloDieci(user,primo)) {
totale=0;
}
return totale;
}else {
throw new TakeAwayBillException ("Sono stati inseriti più di 30 elementi");
}
}

public static double controlloTotale(double totale) {
if (totale <10) {
totale += 0.5;
}
return totale;
}

public static double controlloGelati (double totGel) {

if(totGel>50) {
return 0.10;
}
return 0;
}



public boolean controlloDieci (User user, MenuItem ord) {

if(cont>=10){
return false;
}

else{
if (user.eta<18 && ord.orario>18 && ord.orario<19 ) {
Random rd = new Random();
if(rd.nextBoolean()) {
cont++;
return true;
}


}else {
return false;
}

}



return true;
}

}
