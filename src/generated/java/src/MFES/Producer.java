package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Producer {
  public String name;
  public Products stocks;
  public VDMSet delegations;

  public void cg_init_Producer_1(final String Name) {

    name = Name;
    stocks = new Products();
    delegations = SetUtil.set();
    return;
  }

  public Producer(final String Name) {

    cg_init_Producer_1(Name);
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

  public void addDelegation(final Delegation D) {

    delegations = SetUtil.union(Utils.copy(delegations), SetUtil.set(D));
  }

  public void removeDelegation(final Delegation D) {

    delegations = SetUtil.diff(Utils.copy(delegations), SetUtil.set(D));
  }

  public VDMSet getDelegations() {

    return Utils.copy(delegations);
  }

  public void sendToDelegation(final Delegation D, final String P, final Number Q) {

    D.addProductStock(P, Q);
    removeProductStock(P, Q);
  }

  public void sendProducts() {

    Number n = 0L;
    Number s = 0L;
    for (Iterator iterator_15 = MapUtil.dom(stocks.products).iterator(); iterator_15.hasNext(); ) {
      String product = (String) iterator_15.next();
      n = 0L;
      for (Iterator iterator_16 = delegations.iterator(); iterator_16.hasNext(); ) {
        Delegation delegation = (Delegation) iterator_16.next();
        if (SetUtil.inSet(product, delegation.getProducts())) {
          n = n.longValue() + 1L;
        }
      }
      if (getStock(product).doubleValue() > 0L) {
        s = getStock(product);
        for (Iterator iterator_17 = delegations.iterator(); iterator_17.hasNext(); ) {
          Delegation delegation = (Delegation) iterator_17.next();
          if (SetUtil.inSet(product, delegation.getProducts())) {
            sendToDelegation(
                delegation, product, Utils.divide((1.0 * s.longValue()), n.longValue()));
          }
        }
        removeProductStock(product, getStock(product));
      }
    }
  }

  public Producer() {}

  public String toString() {

    return "Producer{"
        + "name := "
        + Utils.toString(name)
        + ", stocks := "
        + Utils.toString(stocks)
        + ", delegations := "
        + Utils.toString(delegations)
        + "}";
  }
}
