package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Basket {
  public Object maxWeight;
  public Products stocks;

  public void cg_init_Basket_1(final Object M) {

    maxWeight = M;
    stocks = new Products();
    return;
  }

  public Basket(final Object M) {

    cg_init_Basket_1(M);
  }

  public void addProduct(final String P) {

    stocks.addProduct(P);
  }

  public VDMSet getProducts() {

    return stocks.getProducts();
  }

  public void addProductStock(final String P, final Number S) {

    stocks.addProductStock(P, S);
  }

  public Number getStock(final String P) {

    return stocks.getStock(P);
  }

  public Number getMaxWeight() {

    return maxWeightW(((Object) maxWeight));
  }

  public Basket() {}

  public static Number totalWeight(final VDMMap Products) {

    if (Utils.empty(Products)) {
      return 0L;

    } else {
      Number letBeStExp_1 = null;
      String s = null;
      Boolean success_1 = false;
      VDMSet set_1 = MapUtil.dom(Utils.copy(Products));
      for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext() && !(success_1); ) {
        s = ((String) iterator_1.next());
        success_1 = true;
      }
      if (!(success_1)) {
        throw new RuntimeException("Let Be St found no applicable bindings");
      }

      letBeStExp_1 =
          ((Number) Utils.get(Products, s)).doubleValue()
              + totalWeight(MapUtil.domResBy(SetUtil.set(s), Utils.copy(Products))).doubleValue();
      return letBeStExp_1;
    }
  }

  public static Number maxNProducts(final Object P) {

    if (Utils.equals(P, MFES.quotes.PequenaQuote.getInstance())) {
      return 3L;

    } else {
      if (Utils.equals(P, MFES.quotes.GrandeQuote.getInstance())) {
        return 4L;

      } else {
        return 0L;
      }
    }
  }

  public static Number maxWeightW(final Object P) {

    if (Utils.equals(P, MFES.quotes.PequenaQuote.getInstance())) {
      return 4L;

    } else {
      if (Utils.equals(P, MFES.quotes.GrandeQuote.getInstance())) {
        return 8L;

      } else {
        return 0L;
      }
    }
  }

  public String toString() {

    return "Basket{"
        + "maxWeight := "
        + Utils.toString(maxWeight)
        + ", stocks := "
        + Utils.toString(stocks)
        + "}";
  }
}
