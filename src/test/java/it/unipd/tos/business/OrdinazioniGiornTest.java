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


public class OrdinazioniGiornTest {

@Test
public void GetOrderPrice_NonScontatitest()  {
		
List<MenuItem> tmp = new ArrayList<MenuItem>();
		
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ,12));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 1.3D,12 ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 2.5D,12));
tmp.add(new MenuItem(Categoria.Bevande, "Fanta", 2.5D,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 2.5D,12));
tmp.add(new MenuItem(Categoria.Bevande, "Fanta", 2.5D,12));
double p =0;
OrdinazioniGiorn ord = new OrdinazioniGiorn();
try  {
			
p = ord.getOrderPrice(tmp, new User(24));
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(13.8, p,0);

}

@Test
public void GetOrderPrice_ScontoGelatitest () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D,12 ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Fragola", 2D,12)); 
double p =0;
OrdinazioniGiorn ord = new OrdinazioniGiorn();
try  {			
p = ord.getOrderPrice(tmp, new User(24));
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(24.8, p,0);
}

@Test
public void GetOrderPrice_ScontoGelatiBudinitest () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D,20 ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D,12 ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Fragola", 2D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Super", 20D,12)); 
tmp.add(new MenuItem(Categoria.Budini, "Budino del re", 15D,12)); 
tmp.add(new MenuItem(Categoria.Budini, "Budino della principessa", 18D,12)); 
double p =0;
OrdinazioniGiorn ord = new OrdinazioniGiorn();
try  {			
p = ord.getOrderPrice(tmp, new User(24));
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(70.02, p,0);
}


@Test (expected = TakeAwayBillException.class)
public void GetOrderPrice_PiuDi30elementi () throws TakeAwayBillException {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ,12));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D,12 ));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ,12));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D,12 ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D,12 ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D,12 ));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ,12));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D,12 ));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D,12 ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Nafta", 2.5D ,12));
tmp.add(new MenuItem(Categoria.Budini, "Pinguino", 2.9D ,12));
tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));
tmp.add(new MenuItem(Categoria.Gelati, "Pistacchio", 2.3D,12 ));
tmp.add(new MenuItem(Categoria.Gelati, "Coppa Maxi", 8.0D ,12));
tmp.add(new MenuItem(Categoria.Gelati, "Limone", 2.5D,12));
OrdinazioniGiorn ord = new OrdinazioniGiorn();
ord.getOrderPrice(tmp, new User(11));
}

@Test
public void GetOrderPrice_MenoDiDiecitest () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D,12));

double p =0;
OrdinazioniGiorn ord = new OrdinazioniGiorn();
try  {			
p = ord.getOrderPrice(tmp, new User(23));
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
} 
assertEquals(6.1, p,0);
}

@Test
public void GetOrderPrice_DieciGratistest () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D, 18.17));

double p =0;

OrdinazioniGiorn ord = new OrdinazioniGiorn();

for (int i=0; i<25; i++) {

try  {
p = ord.getOrderPrice(tmp, new User(10));
} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
}
assertTrue(p==6.1 || p==0);
}
}


@Test
public void GetOrderPrice_DieciGratis_GiaDieci_test () {
List<MenuItem> tmp = new ArrayList<MenuItem>();

tmp.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D, 18.17));

List<MenuItem> prova = new ArrayList<MenuItem>();

prova.add(new MenuItem(Categoria.Bevande, "Coca Cola", 5.6D, 12));
double p =0;


OrdinazioniGiorn ord = new OrdinazioniGiorn(14);


try  {
p = ord.getOrderPrice(tmp, new User(3));

} catch ( TakeAwayBillException e){
System.out.println(e.getMessage());
}
assertEquals(6.1, p,0);

}

}

