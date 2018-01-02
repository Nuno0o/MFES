package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Products {
  public VDMMap products;

  public void cg_init_Products_1() {

    products = MapUtil.map();
    return;
  }

  public Products() {

    cg_init_Products_1();
  }

  public void addProduct(final String P) {

    products = MapUtil.munion(Utils.copy(products), MapUtil.map(new Maplet(P, 0L)));
  }

  public void removeProduct(final String P) {

    products = MapUtil.domResBy(SetUtil.set(P), Utils.copy(products));
  }

  public VDMSet getProducts() {

    return MapUtil.dom(Utils.copy(products));
  }

  public void addProductStock(final String P, final Number S) {

    products =
        MapUtil.override(
            Utils.copy(products),
            MapUtil.map(
                new Maplet(P, ((Number) Utils.get(products, P)).doubleValue() + S.doubleValue())));
  }

  public void removeProductStock(final String P, final Number S) {

    products =
        MapUtil.override(
            Utils.copy(products),
            MapUtil.map(
                new Maplet(P, ((Number) Utils.get(products, P)).doubleValue() - S.doubleValue())));
  }

  public Number getStock(final String P) {

    return ((Number) Utils.get(products, P));
  }

  public String toString() {

    return "Products{" + "products := " + Utils.toString(products) + "}";
  }
}
