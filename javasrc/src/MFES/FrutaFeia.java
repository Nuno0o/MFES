package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FrutaFeia {
  public VDMSeq delegations;
  public VDMSeq producers;
  public VDMSeq consumers;

  public void cg_init_FrutaFeia_1() {

    delegations = SeqUtil.seq();
    producers = SeqUtil.seq();
    consumers = SeqUtil.seq();
    return;
  }

  public VDMSeq getDelegations() {

    return Utils.copy(delegations);
  }

  public VDMSeq getProducers() {

    return Utils.copy(producers);
  }

  public VDMSeq getConsumers() {

    return Utils.copy(consumers);
  }

  public VDMSet getDelPro(final String PN) {

    return getProByName(Utils.copy(producers), PN).getDelegations();
  }

  public Number getNBaskets(final String CN) {

    return getConByName(Utils.copy(consumers), CN).getBaskets().size();
  }

  public Basket getLastBasket(final String CN) {

    return ((Basket) getConByName(Utils.copy(consumers), CN).getBaskets().get(0));
  }

  public FrutaFeia() {

    cg_init_FrutaFeia_1();
  }

  public void newCustomer(final String N, final Object M) {

    Consumer customer = new Consumer(N, ((Object) M));
    consumers = SeqUtil.conc(SeqUtil.seq(customer), Utils.copy(consumers));
  }

  public void newDelegation(final String N) {

    Delegation delegation = new Delegation(N);
    delegations = SeqUtil.conc(SeqUtil.seq(delegation), Utils.copy(delegations));
  }

  public void addCustomer(final String DN, final String CN) {

    FrutaFeia.getDelByName(Utils.copy(delegations), DN)
        .addCustomer(getConByName(Utils.copy(consumers), CN));
  }

  public void removeCustomer(final String DN, final String CN) {

    FrutaFeia.getDelByName(Utils.copy(delegations), DN)
        .removeCustomer(getConByName(Utils.copy(consumers), CN));
  }

  public void addProductDel(final String DN, final String PT) {

    FrutaFeia.getDelByName(Utils.copy(delegations), DN).addProduct(PT);
  }

  public void removeProductDel(final String DN, final String PT) {

    FrutaFeia.getDelByName(Utils.copy(delegations), DN).removeProduct(PT);
  }

  public void makeAndFillBaskets(final String DN) {

    FrutaFeia.getDelByName(Utils.copy(delegations), DN).makeBaskets();
    FrutaFeia.getDelByName(Utils.copy(delegations), DN).fillBaskets();
  }

  public void newProducer(final String N) {

    Producer producer = new Producer(N);
    producers = SeqUtil.conc(SeqUtil.seq(producer), Utils.copy(producers));
  }

  public void addProductPro(final String PN, final String PT) {

    FrutaFeia.getProByName(Utils.copy(producers), PN).addProduct(PT);
  }

  public void removeProductPro(final String PN, final String PT) {

    FrutaFeia.getProByName(Utils.copy(producers), PN).removeProduct(PT);
  }

  public void addProductStockPro(final String PN, final String PT, final Number Q) {

    FrutaFeia.getProByName(Utils.copy(producers), PN).addProductStock(PT, Q);
  }

  public void removeProductStockPro(final String PN, final String PT, final Number Q) {

    FrutaFeia.getProByName(Utils.copy(producers), PN).removeProductStock(PT, Q);
  }

  public void addDelToPro(final String PN, final String DN) {

    FrutaFeia.getProByName(Utils.copy(producers), PN)
        .addDelegation(getDelByName(Utils.copy(delegations), DN));
  }

  public void removeDelFromPro(final String PN, final String DN) {

    FrutaFeia.getProByName(Utils.copy(producers), PN)
        .removeDelegation(getDelByName(Utils.copy(delegations), DN));
  }

  public void sendToDels(final String PN) {

    FrutaFeia.getProByName(Utils.copy(producers), PN).sendProducts();
  }

  public void fetchBasket(final String CN) {

    FrutaFeia.getConByName(Utils.copy(consumers), CN).fetchBasket();
  }

  public void cancelBasket(final String CN) {

    FrutaFeia.getConByName(Utils.copy(consumers), CN).cancelBasket();
  }

  public static Delegation getDelByName(final VDMSeq D, final String N) {

    if (Utils.empty(D)) {
      return null;

    } else {
      if (Utils.equals(((Delegation) D.get(0)).name, N)) {
        return ((Delegation) D.get(0));

      } else {
        return getDelByName(SeqUtil.tail(Utils.copy(D)), N);
      }
    }
  }

  public static Consumer getConByName(final VDMSeq C, final String N) {

    if (Utils.empty(C)) {
      return null;

    } else {
      if (Utils.equals(((Consumer) C.get(0)).name, N)) {
        return ((Consumer) C.get(0));

      } else {
        return getConByName(SeqUtil.tail(Utils.copy(C)), N);
      }
    }
  }

  public static Producer getProByName(final VDMSeq P, final String N) {

    if (Utils.empty(P)) {
      return null;

    } else {
      if (Utils.equals(((Producer) P.get(0)).name, N)) {
        return ((Producer) P.get(0));

      } else {
        return getProByName(SeqUtil.tail(Utils.copy(P)), N);
      }
    }
  }

  public String toString() {

    return "FrutaFeia{"
        + "delegations := "
        + Utils.toString(delegations)
        + ", producers := "
        + Utils.toString(producers)
        + ", consumers := "
        + Utils.toString(consumers)
        + "}";
  }
}
