package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PequenaQuote {
  private static int hc = 0;
  private static PequenaQuote instance = null;

  public PequenaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PequenaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PequenaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PequenaQuote;
  }

  public String toString() {

    return "<Pequena>";
  }
}
