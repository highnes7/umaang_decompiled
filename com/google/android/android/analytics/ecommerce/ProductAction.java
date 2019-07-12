package com.google.android.android.analytics.ecommerce;

import com.google.android.android.analytics.Log;
import com.google.android.android.common.internal.zzbp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProductAction
{
  public static final String ACTION_ADD = "add";
  public static final String ACTION_CHECKOUT = "checkout";
  public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
  @Deprecated
  public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
  public static final String ACTION_CLICK = "click";
  public static final String ACTION_DETAIL = "detail";
  public static final String ACTION_PURCHASE = "purchase";
  public static final String ACTION_REFUND = "refund";
  public static final String ACTION_REMOVE = "remove";
  public Map<String, String> zzdno = new HashMap();
  
  public ProductAction(String paramString)
  {
    set("&pa", paramString);
  }
  
  private final void set(String paramString1, String paramString2)
  {
    zzbp.get(paramString1, "Name should be non-null");
    zzdno.put(paramString1, paramString2);
  }
  
  public final Map build()
  {
    return new HashMap(zzdno);
  }
  
  public ProductAction setCheckoutOptions(String paramString)
  {
    set("&col", paramString);
    return this;
  }
  
  public ProductAction setCheckoutStep(int paramInt)
  {
    set("&cos", Integer.toString(paramInt));
    return this;
  }
  
  public ProductAction setProductActionList(String paramString)
  {
    set("&pal", paramString);
    return this;
  }
  
  public ProductAction setProductListSource(String paramString)
  {
    set("&pls", paramString);
    return this;
  }
  
  public ProductAction setTransactionAffiliation(String paramString)
  {
    set("&ta", paramString);
    return this;
  }
  
  public ProductAction setTransactionCouponCode(String paramString)
  {
    set("&tcc", paramString);
    return this;
  }
  
  public ProductAction setTransactionId(String paramString)
  {
    set("&ti", paramString);
    return this;
  }
  
  public ProductAction setTransactionRevenue(double paramDouble)
  {
    set("&tr", Double.toString(paramDouble));
    return this;
  }
  
  public ProductAction setTransactionShipping(double paramDouble)
  {
    set("&ts", Double.toString(paramDouble));
    return this;
  }
  
  public ProductAction setTransactionTax(double paramDouble)
  {
    set("&tt", Double.toString(paramDouble));
    return this;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzdno.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str;
      if (((String)localEntry.getKey()).startsWith("&")) {
        str = ((String)localEntry.getKey()).substring(1);
      } else {
        str = (String)localEntry.getKey();
      }
      localHashMap.put(str, (String)localEntry.getValue());
    }
    return Log.getID(localHashMap);
  }
}
