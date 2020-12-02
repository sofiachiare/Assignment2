////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class Ordinazione implements TakeAwayBill {

@Override
public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException{
double totale =0;
MenuItem min = itemsOrdered.get(0);
if(itemsOrdered.size()>=5) {
for(MenuItem a : itemsOrdered) {
if (a.getPrezzo() < min.getPrezzo()) {
min=a;
}
}
for(MenuItem a : itemsOrdered) {
if(a==min) {
totale += (a.getPrezzo())/2;
}
else {
totale += a.getPrezzo();
}
}
}
else {
for(MenuItem a : itemsOrdered) {
totale += a.getPrezzo();
}
}
return totale;
}

}

