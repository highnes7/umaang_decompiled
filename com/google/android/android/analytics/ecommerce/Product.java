package com.google.android.android.analytics.ecommerce;

import com.google.android.android.analytics.Log;
import com.google.android.android.analytics.OrderedMap;
import com.google.android.android.common.internal.zzbp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Product
{
  public Map<String, String> zzdno = new HashMap();
  
  public Product() {}
  
  private final void put(String paramString1, String paramString2)
  {
    zzbp.get(paramString1, "Name should be non-null");
    zzdno.put(paramString1, paramString2);
  }
  
  public Product setBrand(String paramString)
  {
    put("br", paramString);
    return this;
  }
  
  public Product setCategory(String paramString)
  {
    put("ca", paramString);
    return this;
  }
  
  public Product setCouponCode(String paramString)
  {
    put("cc", paramString);
    return this;
  }
  
  public Product setCustomDimension(int paramInt, String paramString)
  {
    put(OrderedMap.zzar(paramInt), paramString);
    return this;
  }
  
  public Product setCustomMetric(int paramInt1, int paramInt2)
  {
    put(OrderedMap.zzas(paramInt1), Integer.toString(paramInt2));
    return this;
  }
  
  public Product setId(String paramString)
  {
    put("id", paramString);
    return this;
  }
  
  public Product setName(String paramString)
  {
    put("nm", paramString);
    return this;
  }
  
  public Product setPosition(int paramInt)
  {
    put("ps", Integer.toString(paramInt));
    return this;
  }
  
  public Product setPrice(double paramDouble)
  {
    put("pr", Double.toString(paramDouble));
    return this;
  }
  
  public Product setQuantity(int paramInt)
  {
    put("qt", Integer.toString(paramInt));
    return this;
  }
  
  public Product setVariant(String paramString)
  {
    put("va", paramString);
    return this;
  }
  
  public String toString()
  {
    return Log.getID(zzdno);
  }
  
  public final Map zzdj(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = zzdno.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = String.valueOf(paramString);
      String str2 = String.valueOf((String)localEntry.getKey());
      if (str2.length() != 0) {
        str1 = str1.concat(str2);
      } else {
        str1 = new String(str1);
      }
      localHashMap.put(str1, (String)localEntry.getValue());
    }
    return localHashMap;
  }
}
