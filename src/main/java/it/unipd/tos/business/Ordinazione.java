////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.Categoria;
import it.unipd.tos.model.MenuItem;

public class Ordinazione implements TakeAwayBill {

LocalDate dataUltimo;

double cont;

public Ordinazione() {
dataUltimo = LocalDate.now();
cont = 0;
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
MenuItem min = new MenuItem(Categoria.Gelati, "prova", 9999999);
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
if(totBudGel>50) {
totale=totale-(totale*0.10);
}


totale=controlloTotale(totale);
totale=dieciGratis(user,totale);
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

public double dieciGratis (User user, double totale ) {

LocalTime ora = LocalTime.now();
LocalTime up = LocalTime.of(17,00,00);
LocalTime down = LocalTime.of(18,00,00);

if(dataUltimo != LocalDate.now()) {
cont=0;
dataUltimo = LocalDate.now();
}
if(fun(user,cont)) {
if(ora.isAfter(up) && ora.isBefore(down)) {
Random rd = new Random();
if (rd.nextBoolean()) {
cont++;
return 0;
}
}
}

return totale;

}
public boolean fun (User user, double cont) {
if (user.eta < 18 && cont < 10) {
return true;
}
else { return false;}
}

}
