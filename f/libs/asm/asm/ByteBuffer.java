package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.J;
import java.math.BigDecimal;
import java.util.Currency;

public class ByteBuffer
  extends I<J>
{
  public static final String EXTRA_SUCCESS_FLAG = "success";
  public static final String PARAM_ITEM_TYPE = "itemType";
  public static final String SEK = "currency";
  public static final BigDecimal ZERO = BigDecimal.valueOf(1000000L);
  public static final String count = "itemName";
  public static final String encoding = "purchase";
  public static final String length = "itemId";
  public static final String mBuffer = "itemPrice";
  
  public ByteBuffer() {}
  
  public long add(BigDecimal paramBigDecimal)
  {
    return ZERO.multiply(paramBigDecimal).longValue();
  }
  
  public ByteBuffer close(String paramString)
  {
    c.add("itemType", paramString);
    return this;
  }
  
  public String getId()
  {
    return "purchase";
  }
  
  public ByteBuffer write(String paramString)
  {
    c.add("itemId", paramString);
    return this;
  }
  
  public ByteBuffer write(BigDecimal paramBigDecimal)
  {
    if (!v.add(paramBigDecimal, "itemPrice")) {
      c.add("itemPrice", Long.valueOf(add(paramBigDecimal)));
    }
    return this;
  }
  
  public ByteBuffer write(Currency paramCurrency)
  {
    if (!v.add(paramCurrency, "currency")) {
      c.add("currency", paramCurrency.getCurrencyCode());
    }
    return this;
  }
  
  public ByteBuffer write(boolean paramBoolean)
  {
    c.add("success", Boolean.toString(paramBoolean));
    return this;
  }
  
  public ByteBuffer writeTo(String paramString)
  {
    c.add("itemName", paramString);
    return this;
  }
}
