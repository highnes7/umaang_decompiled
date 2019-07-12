package com.google.android.android.internal;

import com.google.android.android.analytics.Log;
import com.google.android.android.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzamb
  extends zzh<com.google.android.gms.internal.zzamb>
{
  public ProductAction zzdke;
  public final Map<String, List<Product>> zzdkf = new HashMap();
  public final List<Promotion> zzdkg = new ArrayList();
  public final List<Product> zzdkh = new ArrayList();
  
  public zzamb() {}
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    if (!zzdkh.isEmpty()) {
      localHashMap.put("products", zzdkh);
    }
    if (!zzdkg.isEmpty()) {
      localHashMap.put("promotions", zzdkg);
    }
    if (!zzdkf.isEmpty()) {
      localHashMap.put("impressions", zzdkf);
    }
    localHashMap.put("productAction", zzdke);
    return Log.getID(localHashMap);
  }
  
  public final ProductAction zzuz()
  {
    return zzdke;
  }
  
  public final List zzva()
  {
    return Collections.unmodifiableList(zzdkh);
  }
  
  public final Map zzvb()
  {
    return zzdkf;
  }
  
  public final List zzvc()
  {
    return Collections.unmodifiableList(zzdkg);
  }
}
