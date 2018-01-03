package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Consumer {
  public String name;
  public Object maxbasketsize;
  public VDMSeq baskets;
  public Delegation delegation;

  public void cg_init_Consumer_1(final String N, final Object S) {

    name = N;
    maxbasketsize = S;
    baskets = SeqUtil.seq();
    delegation = null;
    return;
  }

  public Consumer(final String N, final Object S) {

    cg_init_Consumer_1(N, S);
  }

  public Object getBasketMaxSize() {

    return maxbasketsize;
  }

  public VDMSeq getBaskets() {

    return Utils.copy(baskets);
  }

  public void addBasket(final Basket B) {

    baskets = SeqUtil.conc(SeqUtil.seq(B), Utils.copy(baskets));
  }

  public void setDelegation(final Delegation D) {

    delegation = D;
  }

  public void fetchBasket() {

    delegation.giveBasket(this);
  }

  public void cancelBasket() {

    delegation.cancelBasket(this);
  }

  public Consumer() {}

  public String toString() {

    return "Consumer{"
        + "name := "
        + Utils.toString(name)
        + ", maxbasketsize := "
        + Utils.toString(maxbasketsize)
        + ", baskets := "
        + Utils.toString(baskets)
        + ", delegation := "
        + Utils.toString(delegation)
        + "}";
  }
}
