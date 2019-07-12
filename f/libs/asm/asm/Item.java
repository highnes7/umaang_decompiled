package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.a;
import java.math.BigDecimal;
import java.util.Currency;

public class Item
  extends I<a>
{
  public static final String DUE_DATE_FORMAT = "addToCart";
  public static final String SEK = "currency";
  public static final String a = "itemId";
  public static final BigDecimal d = BigDecimal.valueOf(1000000L);
  public static final String i = "itemName";
  public static final String strVal2 = "itemPrice";
  public static final String type = "itemType";
  
  public Item() {}
  
  public Item a(String paramString)
  {
    c.add("itemId", paramString);
    return this;
  }
  
  public Item a(BigDecimal paramBigDecimal)
  {
    if (!v.add(paramBigDecimal, "itemPrice")) {
      c.add("itemPrice", Long.valueOf(add(paramBigDecimal)));
    }
    return this;
  }
  
  public long add(BigDecimal paramBigDecimal)
  {
    return d.multiply(paramBigDecimal).longValue();
  }
  
  public String getId()
  {
    return "addToCart";
  }
  
  public Item set(String paramString)
  {
    c.add("itemType", paramString);
    return this;
  }
  
  public Item write(String paramString)
  {
    c.add("itemName", paramString);
    return this;
  }
  
  public Item write(Currency paramCurrency)
  {
    if (!v.add(paramCurrency, "currency")) {
      c.add("currency", paramCurrency.getCurrencyCode());
    }
    return this;
  }
}
