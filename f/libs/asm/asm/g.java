package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.da;
import java.math.BigDecimal;
import java.util.Currency;

public class g
  extends I<da>
{
  public static final String a = "currency";
  public static final String b = "itemCount";
  public static final BigDecimal d = BigDecimal.valueOf(1000000L);
  public static final String e = "startCheckout";
  public static final String g = "totalPrice";
  
  public g() {}
  
  public g a(int paramInt)
  {
    c.add("itemCount", Integer.valueOf(paramInt));
    return this;
  }
  
  public g a(BigDecimal paramBigDecimal)
  {
    if (!v.add(paramBigDecimal, "totalPrice")) {
      c.add("totalPrice", Long.valueOf(add(paramBigDecimal)));
    }
    return this;
  }
  
  public long add(BigDecimal paramBigDecimal)
  {
    return d.multiply(paramBigDecimal).longValue();
  }
  
  public String getId()
  {
    return "startCheckout";
  }
  
  public g write(Currency paramCurrency)
  {
    if (!v.add(paramCurrency, "currency")) {
      c.add("currency", paramCurrency.getCurrencyCode());
    }
    return this;
  }
}
