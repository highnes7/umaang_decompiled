package com.google.android.android.analytics;

import android.text.TextUtils;
import com.google.android.android.analytics.ecommerce.ProductAction;
import com.google.android.android.internal.zzaom;
import com.google.android.android.internal.zzapd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HitBuilders
{
  public HitBuilders() {}
  
  @Deprecated
  public class AppViewBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.AppViewBuilder>
  {
    public AppViewBuilder()
    {
      set("&t", "screenview");
    }
  }
  
  public class EventBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.EventBuilder>
  {
    public EventBuilder()
    {
      set("&t", "event");
    }
    
    public EventBuilder(String paramString)
    {
      this();
      setCategory(this$1);
      setAction(paramString);
    }
    
    public EventBuilder setAction(String paramString)
    {
      set("&ea", paramString);
      return this;
    }
    
    public EventBuilder setCategory(String paramString)
    {
      set("&ec", paramString);
      return this;
    }
    
    public EventBuilder setLabel(String paramString)
    {
      set("&el", paramString);
      return this;
    }
    
    public EventBuilder setValue(long paramLong)
    {
      set("&ev", Long.toString(paramLong));
      return this;
    }
  }
  
  public class ExceptionBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.ExceptionBuilder>
  {
    public ExceptionBuilder()
    {
      set("&t", "exception");
    }
    
    public ExceptionBuilder setDescription(String paramString)
    {
      set("&exd", paramString);
      return this;
    }
    
    public ExceptionBuilder setFatal(boolean paramBoolean)
    {
      set("&exf", zzapd.zzaj(paramBoolean));
      return this;
    }
  }
  
  public class HitBuilder<T extends com.google.android.gms.analytics.HitBuilders.HitBuilder>
  {
    public Map<String, String> zzdkd = new HashMap();
    public ProductAction zzdke;
    public Map<String, List<com.google.android.gms.analytics.ecommerce.Product>> zzdkf = new HashMap();
    public List<com.google.android.gms.analytics.ecommerce.Promotion> zzdkg = new ArrayList();
    public List<com.google.android.gms.analytics.ecommerce.Product> zzdkh = new ArrayList();
    
    public HitBuilder() {}
    
    private final HitBuilder get(String paramString1, String paramString2)
    {
      if (paramString2 != null) {
        zzdkd.put(paramString1, paramString2);
      }
      return this;
    }
    
    public HitBuilder addImpression(com.google.android.android.analytics.ecommerce.Product paramProduct, String paramString)
    {
      if (paramProduct == null)
      {
        zzaom.zzcr("product should be non-null");
        return this;
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      if (!zzdkf.containsKey(str)) {
        zzdkf.put(str, new ArrayList());
      }
      ((List)zzdkf.get(str)).add(paramProduct);
      return this;
    }
    
    public HitBuilder addProduct(com.google.android.android.analytics.ecommerce.Product paramProduct)
    {
      if (paramProduct == null)
      {
        zzaom.zzcr("product should be non-null");
        return this;
      }
      zzdkh.add(paramProduct);
      return this;
    }
    
    public HitBuilder addPromotion(com.google.android.android.analytics.ecommerce.Promotion paramPromotion)
    {
      if (paramPromotion == null)
      {
        zzaom.zzcr("promotion should be non-null");
        return this;
      }
      zzdkg.add(paramPromotion);
      return this;
    }
    
    public Map build()
    {
      HashMap localHashMap = new HashMap(zzdkd);
      Object localObject = zzdke;
      if (localObject != null) {
        localHashMap.putAll(((ProductAction)localObject).build());
      }
      localObject = zzdkg.iterator();
      int i = 1;
      while (((Iterator)localObject).hasNext())
      {
        localHashMap.putAll(((com.google.android.android.analytics.ecommerce.Promotion)((Iterator)localObject).next()).zzdj(OrderedMap.zzam(i)));
        i += 1;
      }
      localObject = zzdkh.iterator();
      i = 1;
      while (((Iterator)localObject).hasNext())
      {
        localHashMap.putAll(((com.google.android.android.analytics.ecommerce.Product)((Iterator)localObject).next()).zzdj(OrderedMap.zzak(i)));
        i += 1;
      }
      Iterator localIterator1 = zzdkf.entrySet().iterator();
      i = 1;
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        localObject = (List)localEntry.getValue();
        String str1 = OrderedMap.zzap(i);
        Iterator localIterator2 = ((List)localObject).iterator();
        int j = 1;
        while (localIterator2.hasNext())
        {
          com.google.android.android.analytics.ecommerce.Product localProduct = (com.google.android.android.analytics.ecommerce.Product)localIterator2.next();
          localObject = String.valueOf(str1);
          String str2 = String.valueOf(OrderedMap.zzao(j));
          if (str2.length() != 0) {
            localObject = ((String)localObject).concat(str2);
          } else {
            localObject = new String((String)localObject);
          }
          localHashMap.putAll(localProduct.zzdj((String)localObject));
          j += 1;
        }
        if (!TextUtils.isEmpty((CharSequence)localEntry.getKey()))
        {
          localObject = String.valueOf(str1);
          if ("nm".length() != 0) {
            localObject = ((String)localObject).concat("nm");
          } else {
            localObject = new String((String)localObject);
          }
          localHashMap.put(localObject, (String)localEntry.getKey());
        }
        i += 1;
      }
      return localHashMap;
    }
    
    public String getMirror(String paramString)
    {
      return (String)zzdkd.get(paramString);
    }
    
    public final HitBuilder set(String paramString1, String paramString2)
    {
      if (paramString1 != null)
      {
        zzdkd.put(paramString1, paramString2);
        return this;
      }
      zzaom.zzcr("HitBuilder.set() called with a null paramName.");
      return this;
    }
    
    public final HitBuilder setAll(Map paramMap)
    {
      if (paramMap == null) {
        return this;
      }
      zzdkd.putAll(new HashMap(paramMap));
      return this;
    }
    
    public HitBuilder setCampaignParamsFromUrl(String paramString)
    {
      paramString = zzapd.zzeb(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return this;
      }
      paramString = zzapd.zzdz(paramString);
      get("&cc", (String)paramString.get("utm_content"));
      get("&cm", (String)paramString.get("utm_medium"));
      get("&cn", (String)paramString.get("utm_campaign"));
      get("&cs", (String)paramString.get("utm_source"));
      get("&ck", (String)paramString.get("utm_term"));
      get("&ci", (String)paramString.get("utm_id"));
      get("&anid", (String)paramString.get("anid"));
      get("&gclid", (String)paramString.get("gclid"));
      get("&dclid", (String)paramString.get("dclid"));
      get("&aclid", (String)paramString.get("aclid"));
      get("&gmob_t", (String)paramString.get("gmob_t"));
      return this;
    }
    
    public HitBuilder setCustomDimension(int paramInt, String paramString)
    {
      set(OrderedMap.zzag(paramInt), paramString);
      return this;
    }
    
    public HitBuilder setCustomMetric(int paramInt, float paramFloat)
    {
      set(OrderedMap.zzai(paramInt), Float.toString(paramFloat));
      return this;
    }
    
    public HitBuilder setHitType(String paramString)
    {
      set("&t", paramString);
      return this;
    }
    
    public HitBuilder setNewSession()
    {
      set("&sc", "start");
      return this;
    }
    
    public HitBuilder setNonInteraction(boolean paramBoolean)
    {
      set("&ni", zzapd.zzaj(paramBoolean));
      return this;
    }
    
    public HitBuilder setProductAction(ProductAction paramProductAction)
    {
      zzdke = paramProductAction;
      return this;
    }
    
    public HitBuilder setPromotionAction(String paramString)
    {
      zzdkd.put("&promoa", paramString);
      return this;
    }
  }
  
  @Deprecated
  public class ItemBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.ItemBuilder>
  {
    public ItemBuilder()
    {
      set("&t", "item");
    }
    
    public ItemBuilder setCategory(String paramString)
    {
      set("&iv", paramString);
      return this;
    }
    
    public ItemBuilder setCurrencyCode(String paramString)
    {
      set("&cu", paramString);
      return this;
    }
    
    public ItemBuilder setName(String paramString)
    {
      set("&in", paramString);
      return this;
    }
    
    public ItemBuilder setPrice(double paramDouble)
    {
      set("&ip", Double.toString(paramDouble));
      return this;
    }
    
    public ItemBuilder setQuantity(long paramLong)
    {
      set("&iq", Long.toString(paramLong));
      return this;
    }
    
    public ItemBuilder setSku(String paramString)
    {
      set("&ic", paramString);
      return this;
    }
    
    public ItemBuilder setTransactionId(String paramString)
    {
      set("&ti", paramString);
      return this;
    }
  }
  
  public class ScreenViewBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder>
  {
    public ScreenViewBuilder()
    {
      set("&t", "screenview");
    }
  }
  
  public class SocialBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.SocialBuilder>
  {
    public SocialBuilder()
    {
      set("&t", "social");
    }
    
    public SocialBuilder setAction(String paramString)
    {
      set("&sa", paramString);
      return this;
    }
    
    public SocialBuilder setNetwork(String paramString)
    {
      set("&sn", paramString);
      return this;
    }
    
    public SocialBuilder setTarget(String paramString)
    {
      set("&st", paramString);
      return this;
    }
  }
  
  public class TimingBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.TimingBuilder>
  {
    public TimingBuilder()
    {
      set("&t", "timing");
    }
    
    public TimingBuilder(String paramString, long paramLong)
    {
      this();
      setVariable(paramString);
      setValue(paramLong);
      setCategory(this$1);
    }
    
    public TimingBuilder setCategory(String paramString)
    {
      set("&utc", paramString);
      return this;
    }
    
    public TimingBuilder setLabel(String paramString)
    {
      set("&utl", paramString);
      return this;
    }
    
    public TimingBuilder setValue(long paramLong)
    {
      set("&utt", Long.toString(paramLong));
      return this;
    }
    
    public TimingBuilder setVariable(String paramString)
    {
      set("&utv", paramString);
      return this;
    }
  }
  
  @Deprecated
  public class TransactionBuilder
    extends com.google.android.gms.analytics.HitBuilders.HitBuilder<com.google.android.gms.analytics.HitBuilders.TransactionBuilder>
  {
    public TransactionBuilder()
    {
      set("&t", "transaction");
    }
    
    public TransactionBuilder setAffiliation(String paramString)
    {
      set("&ta", paramString);
      return this;
    }
    
    public TransactionBuilder setCurrencyCode(String paramString)
    {
      set("&cu", paramString);
      return this;
    }
    
    public TransactionBuilder setRevenue(double paramDouble)
    {
      set("&tr", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setShipping(double paramDouble)
    {
      set("&ts", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setTax(double paramDouble)
    {
      set("&tt", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setTransactionId(String paramString)
    {
      set("&ti", paramString);
      return this;
    }
  }
}
