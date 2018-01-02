package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Tests {
  protected static void assertTrue(final Boolean arg) {

    IO.print("Success\n");
    return;
  }

  public static void testAll() {

    IO.print("\n");
    testOps();
  }

  public static void testOps() {

    FrutaFeia fruta = new FrutaFeia();
    Producer p = null;
    Delegation d1 = null;
    Delegation d2 = null;
    Consumer c1 = null;
    Consumer c2 = null;
    Consumer c3 = null;
    fruta.newProducer("p1");
    fruta.addProductPro("p1", "Banana");
    fruta.addProductPro("p1", "Manga");
    fruta.addProductPro("p1", "Pera");
    p = fruta.getProByName(fruta.getProducers(), "p1");
    Tests.assertTrue(Utils.equals(p.getProducts(), SetUtil.set("Banana", "Manga", "Pera")));
    fruta.removeProductPro("p1", "Pera");
    Tests.assertTrue(Utils.equals(p.getProducts(), SetUtil.set("Banana", "Manga")));
    fruta.addProductStockPro("p1", "Banana", 10L);
    Tests.assertTrue(Utils.equals(p.getStock("Banana"), 10L));
    fruta.addProductStockPro("p1", "Manga", 15L);
    fruta.removeProductStockPro("p1", "Banana", 2L);
    Tests.assertTrue(Utils.equals(p.getStock("Banana"), 8L));
    fruta.newDelegation("d1");
    fruta.newDelegation("d2");
    d1 = fruta.getDelByName(fruta.getDelegations(), "d1");
    d2 = fruta.getDelByName(fruta.getDelegations(), "d2");
    fruta.addProductDel("d1", "Banana");
    fruta.addProductDel("d1", "Manga");
    fruta.addProductDel("d2", "Banana");
    fruta.addProductDel("d2", "Manga");
    fruta.removeProductDel("d2", "Manga");
    Tests.assertTrue(Utils.equals(d2.getProducts(), SetUtil.set("Banana")));
    fruta.addDelToPro("p1", "d1");
    fruta.addDelToPro("p1", "d2");
    Tests.assertTrue(Utils.equals(fruta.getDelPro("p1"), SetUtil.set(d1, d2)));
    fruta.removeDelFromPro("p1", "d2");
    fruta.addDelToPro("p1", "d2");
    fruta.sendToDels("p1");
    Tests.assertTrue(Utils.equals(d1.getStock("Banana"), 4L));
    fruta.newCustomer("c1", MFES.quotes.GrandeQuote.getInstance());
    fruta.newCustomer("c2", MFES.quotes.PequenaQuote.getInstance());
    fruta.newCustomer("c3", MFES.quotes.PequenaQuote.getInstance());
    fruta.addCustomer("d1", "c1");
    fruta.addCustomer("d1", "c2");
    fruta.addCustomer("d1", "c3");
    c1 = fruta.getConByName(fruta.getConsumers(), "c1");
    c2 = fruta.getConByName(fruta.getConsumers(), "c2");
    c3 = fruta.getConByName(fruta.getConsumers(), "c3");
    fruta.removeCustomer("d1", "c3");
    Tests.assertTrue(Utils.equals(d1.customers, SetUtil.set(c1, c2)));
    fruta.makeAndFillBaskets("d1");
    Tests.assertTrue(Utils.equals(MapUtil.dom(d1.baskets).size(), 2L));
    fruta.fetchBasket("c1");
    Tests.assertTrue(Utils.equals(fruta.getNBaskets("c1"), 1L));
    fruta.cancelBasket("c2");
    Tests.assertTrue(
        Utils.equals(fruta.getLastBasket("c1").getProducts(), SetUtil.set("Banana", "Manga")));
    Tests.assertTrue(
        fruta.getLastBasket("c1").getStock("Manga").doubleValue()
            > fruta.getLastBasket("c1").getStock("Banana").doubleValue());
  }

  public Tests() {}

  public String toString() {

    return "Tests{}";
  }
}
