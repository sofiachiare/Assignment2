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
public void GetOrderPrice_NonScontatitest()  {
		
List<MenuItem> tmp = new ArrayList<MenuItem>();
		
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 1.3D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 2.5D));
tmp.add(new MenuItem(Categoria.Bevande, "Fanta", 2.5D));		
double p =0;
Ordinazione ord = new Ordinazione();
try  {
			
p = ord.getOrderPrice(tmp, new User());
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(8.8, p,0);

}

@Test
public void GetOrderPrice_ScontoGelatitest () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Fragola", 2D)); 
double p =0;
Ordinazione ord = new Ordinazione();
try  {			
p = ord.getOrderPrice(tmp, new User());
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(24.8, p,0);
}

@Test
public void GetOrderPrice_ScontoGelatiBudinitest () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Fragola", 2D));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Super", 20D)); 
tmp.add(new MenuItem(Categoria.Budini, "Budino del re", 15D)); 
tmp.add(new MenuItem(Categoria.Budini, "Budino della principessa", 18D)); 
double p =0;
Ordinazione ord = new Ordinazione();
try  {			
p = ord.getOrderPrice(tmp, new User());
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(70.02, p,0);
}


@Test (expected = TakeAwayBillException.class)
public void GetOrderPrice_PiuDi30elementi () throws TakeAwayBillException {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D));
Ordinazione ord = new Ordinazione();
ord.getOrderPrice(tmp, new User());
}
}
