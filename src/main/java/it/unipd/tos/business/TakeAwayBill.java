////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business; 
import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException; 
import it.unipd.tos.model.MenuItem;
public interface TakeAwayBill {
double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException;
}
