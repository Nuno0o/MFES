package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GrandeQuote {
  private static int hc = 0;
  private static GrandeQuote instance = null;

  public GrandeQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GrandeQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GrandeQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GrandeQuote;
  }

  public String toString() {

    return "<Grande>";
  }
}
