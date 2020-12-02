////////////////////////////////////////////////////////////////////
// Sofia Chiarello 1187024
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.Categoria;
import it.unipd.tos.model.MenuItem;

import org.junit.Test;

public class OrdinazioneTest {

@Test
public void getOrderPricetest()  {
		
List<MenuItem> tmp = new ArrayList<MenuItem>();
		
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 1.3D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
		
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 8.0D ));
		
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2D));
		
double p =0;
Ordinazione ord = new Ordinazione();
try  {
			
p = ord.getOrderPrice(tmp, new User());
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(24.2, p,0);
		
}

}
