package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Delegation {
  public String name;
  public Products stocks;
  public VDMSet customers;
  public VDMMap baskets;

  public void cg_init_Delegation_1(final String N) {

    name = N;
    stocks = new Products();
    customers = SetUtil.set();
    baskets = MapUtil.map();
    return;
  }

  public Delegation(final String N) {

    cg_init_Delegation_1(N);
  }

  public void addCustomer(final Consumer C) {

    customers = SetUtil.union(Utils.copy(customers), SetUtil.set(C));
    C.setDelegation(this);
  }

  public void removeCustomer(final Consumer C) {

    customers = SetUtil.diff(Utils.copy(customers), SetUtil.set(C));
  }

  public void addProduct(final String P) {

    stocks.addProduct(P);
  }

  public void removeProduct(final String P) {

    stocks.removeProduct(P);
  }

  public VDMSet getProducts() {

    return stocks.getProducts();
  }

  public void addProductStock(final String P, final Number S) {

    stocks.addProductStock(P, S);
  }

  public void removeProductStock(final String P, final Number S) {

    stocks.removeProductStock(P, S);
  }

  public Number getStock(final String P) {

    return stocks.getStock(P);
  }

  public void makeBasket(final Consumer C) {

    Basket b = new Basket(((Object) C.getBasketMaxSize()));
    baskets = MapUtil.munion(Utils.copy(baskets), MapUtil.map(new Maplet(C, b)));
  }

  public void makeBaskets() {

    for (Iterator iterator_10 = customers.iterator(); iterator_10.hasNext(); ) {
      Consumer customer = (Consumer) iterator_10.next();
      makeBasket(customer);
    }
  }

  public void fillBasket(final Consumer C) {

    VDMSeq products =
        highestN(
            stocks.products,
            Basket.maxNProducts(((Object) ((Basket) Utils.get(baskets, C)).maxWeight)));
    Number sum = 0L;
    for (Iterator iterator_11 = products.iterator(); iterator_11.hasNext(); ) {
      String p = (String) iterator_11.next();
      {
        sum = sum.doubleValue() + stocks.getStock(p).doubleValue();
      }
    }
    for (Iterator iterator_12 = products.iterator(); iterator_12.hasNext(); ) {
      String p = (String) iterator_12.next();
      {
        ((Basket) Utils.get(baskets, C)).addProduct(p);
        removeProductStock(
            p,
            Utils.divide(
                stocks.getStock(p).doubleValue()
                    * ((Basket) Utils.get(baskets, C)).getMaxWeight().doubleValue(),
                sum.doubleValue()));
        ((Basket) Utils.get(baskets, C))
            .addProductStock(
                p,
                Utils.divide(
                    stocks.getStock(p).doubleValue()
                        * ((Basket) Utils.get(baskets, C)).getMaxWeight().doubleValue(),
                    sum.doubleValue()));
      }
    }
  }

  public void fillBaskets() {

    for (Iterator iterator_13 = customers.iterator(); iterator_13.hasNext(); ) {
      Consumer c = (Consumer) iterator_13.next();
      fillBasket(c);
    }
  }

  public void giveBasket(final Consumer C) {

    Basket B = null;
    B = ((Basket) Utils.get(baskets, C));
    baskets = MapUtil.domResBy(SetUtil.set(C), Utils.copy(baskets));
    C.addBasket(B);
  }

  public void cancelBasket(final Consumer C) {

    baskets = MapUtil.domResBy(SetUtil.set(C), Utils.copy(baskets));
  }

  public Delegation() {}

  public static VDMSeq highestN(final VDMMap P, final Number N) {

    return highestNaux(Utils.copy(P), N, SeqUtil.seq());
  }

  public static VDMSeq highestNaux(final VDMMap P, final Number N, final VDMSeq L) {

    Boolean orResult_1 = false;

    if (Utils.equals(N, 0L)) {
      orResult_1 = true;
    } else {
      orResult_1 = Utils.empty(P);
    }

    if (orResult_1) {
      return Utils.copy(L);

    } else {
      final String c = highest(Utils.copy(P));

      return highestNaux(
          MapUtil.domResBy(SetUtil.set(c), Utils.copy(P)),
          N.longValue() - 1L,
          SeqUtil.conc(Utils.copy(L), SeqUtil.seq(c)));
    }
  }

  public static String highest(final VDMMap P) {

    return highestaux(Utils.copy(P), "", -1L);
  }

  public static String highestaux(final VDMMap P, final String Biggest, final Number Max) {

    if (Utils.empty(P)) {
      return Biggest;

    } else {
      String letBeStExp_2 = null;
      String p = null;
      Boolean success_2 = false;
      VDMSet set_2 = MapUtil.dom(Utils.copy(P));
      for (Iterator iterator_2 = set_2.iterator(); iterator_2.hasNext() && !(success_2); ) {
        p = ((String) iterator_2.next());
        success_2 = true;
      }
      if (!(success_2)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      String ternaryIfExp_1 = null;

      if (((Number) Utils.get(P, p)).doubleValue() > Max.doubleValue()) {
        ternaryIfExp_1 =
            highestaux(
                MapUtil.domResBy(SetUtil.set(p), Utils.copy(P)), p, ((Number) Utils.get(P, p)));
      } else {
        ternaryIfExp_1 = highestaux(MapUtil.domResBy(SetUtil.set(p), Utils.copy(P)), Biggest, Max);
      }

      letBeStExp_2 = ternaryIfExp_1;

      return letBeStExp_2;
    }
  }

  public String toString() {

    return "Delegation{"
        + "name := "
        + Utils.toString(name)
        + ", stocks := "
        + Utils.toString(stocks)
        + ", customers := "
        + Utils.toString(customers)
        + ", baskets := "
        + Utils.toString(baskets)
        + "}";
  }
}
