package com.google.android.android.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.android.analytics.ecommerce.Product;
import com.google.android.android.analytics.ecommerce.ProductAction;
import com.google.android.android.analytics.ecommerce.Promotion;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzamj;
import com.google.android.android.internal.zzamr;
import com.google.android.android.internal.zzamt;
import com.google.android.android.internal.zzamu;
import com.google.android.android.internal.zzamx;
import com.google.android.android.internal.zzaoi;
import com.google.android.android.internal.zzaon;
import com.google.android.android.internal.zzapd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class JSONObject
  extends zzamr
  implements Dictionary
{
  public static DecimalFormat zzdjn;
  public final zzamu zzdjj;
  public final String zzdjo;
  public final Uri zzdjp;
  
  public JSONObject(zzamu paramZzamu, String paramString)
  {
    this(paramZzamu, paramString, true, false);
  }
  
  public JSONObject(zzamu paramZzamu, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramZzamu);
    zzbp.zzgg(paramString);
    zzdjj = paramZzamu;
    zzdjo = paramString;
    zzdjp = zzcx(zzdjo);
  }
  
  public static void put(Map paramMap, String paramString, double paramDouble)
  {
    if (paramDouble != 0.0D) {
      paramMap.put(paramString, toString(paramDouble));
    }
  }
  
  public static void put(Map paramMap, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(23);
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      paramMap.put(paramString, localStringBuilder.toString());
    }
  }
  
  public static void put(Map paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static String toString(double paramDouble)
  {
    if (zzdjn == null) {
      zzdjn = new DecimalFormat("0.######");
    }
    return zzdjn.format(paramDouble);
  }
  
  public static Map writeValue(PingManager paramPingManager)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (com.google.android.android.internal.zzalz)paramPingManager.getLogger(com.google.android.gms.internal.zzalz.class);
    Object localObject3;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = ((com.google.android.android.internal.zzalz)localObject1).zzuy().entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        localObject2 = ((Map.Entry)localObject4).getValue();
        localObject1 = null;
        if (localObject2 != null) {
          if ((localObject2 instanceof String))
          {
            localObject2 = (String)localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = localObject2;
            }
          }
          else if ((localObject2 instanceof Double))
          {
            localObject2 = (Double)localObject2;
            if (((Double)localObject2).doubleValue() != 0.0D) {
              localObject1 = toString(((Double)localObject2).doubleValue());
            }
          }
          else if ((localObject2 instanceof Boolean))
          {
            if (localObject2 != Boolean.FALSE) {
              localObject1 = "1";
            }
          }
          else
          {
            localObject1 = String.valueOf(localObject2);
          }
        }
        if (localObject1 != null) {
          localHashMap.put((String)((Map.Entry)localObject4).getKey(), localObject1);
        }
      }
    }
    localObject1 = (com.google.android.android.internal.zzame)paramPingManager.getLogger(com.google.android.gms.internal.zzame.class);
    if (localObject1 != null)
    {
      put(localHashMap, "t", ((com.google.android.android.internal.zzame)localObject1).zzvd());
      put(localHashMap, "cid", ((com.google.android.android.internal.zzame)localObject1).zzve());
      put(localHashMap, "uid", ((com.google.android.android.internal.zzame)localObject1).getUserId());
      put(localHashMap, "sc", ((com.google.android.android.internal.zzame)localObject1).zzvh());
      put(localHashMap, "sf", ((com.google.android.android.internal.zzame)localObject1).zzvj());
      writeValue(localHashMap, "ni", ((com.google.android.android.internal.zzame)localObject1).zzvi());
      put(localHashMap, "adid", ((com.google.android.android.internal.zzame)localObject1).zzvf());
      writeValue(localHashMap, "ate", ((com.google.android.android.internal.zzame)localObject1).zzvg());
    }
    localObject1 = (com.google.android.android.internal.zzamf)paramPingManager.getLogger(com.google.android.gms.internal.zzamf.class);
    if (localObject1 != null)
    {
      put(localHashMap, "cd", ((com.google.android.android.internal.zzamf)localObject1).zzvk());
      put(localHashMap, "a", ((com.google.android.android.internal.zzamf)localObject1).zzvl());
      put(localHashMap, "dr", ((com.google.android.android.internal.zzamf)localObject1).zzvm());
    }
    localObject1 = (com.google.android.android.internal.zzamc)paramPingManager.getLogger(com.google.android.gms.internal.zzamc.class);
    if (localObject1 != null)
    {
      put(localHashMap, "ec", ((com.google.android.android.internal.zzamc)localObject1).getCategory());
      put(localHashMap, "ea", ((com.google.android.android.internal.zzamc)localObject1).getAction());
      put(localHashMap, "el", ((com.google.android.android.internal.zzamc)localObject1).getLabel());
      put(localHashMap, "ev", ((com.google.android.android.internal.zzamc)localObject1).getValue());
    }
    localObject1 = (com.google.android.android.internal.zzalw)paramPingManager.getLogger(com.google.android.gms.internal.zzalw.class);
    if (localObject1 != null)
    {
      put(localHashMap, "cn", ((com.google.android.android.internal.zzalw)localObject1).getName());
      put(localHashMap, "cs", ((com.google.android.android.internal.zzalw)localObject1).getSource());
      put(localHashMap, "cm", ((com.google.android.android.internal.zzalw)localObject1).zzuq());
      put(localHashMap, "ck", ((com.google.android.android.internal.zzalw)localObject1).zzur());
      put(localHashMap, "cc", ((com.google.android.android.internal.zzalw)localObject1).getContent());
      put(localHashMap, "ci", ((com.google.android.android.internal.zzalw)localObject1).getId());
      put(localHashMap, "anid", ((com.google.android.android.internal.zzalw)localObject1).zzus());
      put(localHashMap, "gclid", ((com.google.android.android.internal.zzalw)localObject1).zzut());
      put(localHashMap, "dclid", ((com.google.android.android.internal.zzalw)localObject1).zzuu());
      put(localHashMap, "aclid", ((com.google.android.android.internal.zzalw)localObject1).zzuv());
    }
    localObject1 = (com.google.android.android.internal.zzamd)paramPingManager.getLogger(com.google.android.gms.internal.zzamd.class);
    if (localObject1 != null)
    {
      put(localHashMap, "exd", zzdmu);
      writeValue(localHashMap, "exf", zzdmv);
    }
    localObject1 = (com.google.android.android.internal.zzamg)paramPingManager.getLogger(com.google.android.gms.internal.zzamg.class);
    if (localObject1 != null)
    {
      put(localHashMap, "sn", zzdnk);
      put(localHashMap, "sa", zzdmr);
      put(localHashMap, "st", zzdnl);
    }
    localObject1 = (com.google.android.android.internal.zzamh)paramPingManager.getLogger(com.google.android.gms.internal.zzamh.class);
    if (localObject1 != null)
    {
      put(localHashMap, "utv", zzdnm);
      put(localHashMap, "utt", zzdnn);
      put(localHashMap, "utc", mCategory);
      put(localHashMap, "utl", zzdms);
    }
    localObject1 = (com.google.android.android.internal.zzalx)paramPingManager.getLogger(com.google.android.gms.internal.zzalx.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.google.android.android.internal.zzalx)localObject1).zzuw().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = OrderedMap.zzah(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, (String)((Map.Entry)localObject2).getValue());
        }
      }
    }
    localObject1 = (com.google.android.android.internal.zzaly)paramPingManager.getLogger(com.google.android.gms.internal.zzaly.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.google.android.android.internal.zzaly)localObject1).zzux().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = OrderedMap.zzaj(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localHashMap.put(localObject3, toString(((Double)((Map.Entry)localObject2).getValue()).doubleValue()));
        }
      }
    }
    Object localObject2 = (com.google.android.android.internal.zzamb)paramPingManager.getLogger(com.google.android.gms.internal.zzamb.class);
    if (localObject2 != null)
    {
      localObject1 = ((com.google.android.android.internal.zzamb)localObject2).zzuz();
      if (localObject1 != null)
      {
        localObject3 = ((ProductAction)localObject1).build().entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          if (((String)((Map.Entry)localObject4).getKey()).startsWith("&")) {
            localObject1 = ((String)((Map.Entry)localObject4).getKey()).substring(1);
          } else {
            localObject1 = (String)((Map.Entry)localObject4).getKey();
          }
          localHashMap.put(localObject1, (String)((Map.Entry)localObject4).getValue());
        }
      }
      localObject1 = ((com.google.android.android.internal.zzamb)localObject2).zzvc().iterator();
      int i = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localHashMap.putAll(((Promotion)((Iterator)localObject1).next()).zzdj(OrderedMap.zzan(i)));
        i += 1;
      }
      localObject1 = ((com.google.android.android.internal.zzamb)localObject2).zzva().iterator();
      i = 1;
      while (((Iterator)localObject1).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject1).next()).zzdj(OrderedMap.zzal(i)));
        i += 1;
      }
      localObject2 = ((com.google.android.android.internal.zzamb)localObject2).zzvb().entrySet().iterator();
      i = 1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        localObject1 = (List)((Map.Entry)localObject3).getValue();
        localObject4 = OrderedMap.zzaq(i);
        Iterator localIterator = ((List)localObject1).iterator();
        int j = 1;
        while (localIterator.hasNext())
        {
          Product localProduct = (Product)localIterator.next();
          localObject1 = String.valueOf(localObject4);
          String str = String.valueOf(OrderedMap.zzao(j));
          if (str.length() != 0) {
            localObject1 = ((String)localObject1).concat(str);
          } else {
            localObject1 = new String((String)localObject1);
          }
          localHashMap.putAll(localProduct.zzdj((String)localObject1));
          j += 1;
        }
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject3).getKey()))
        {
          localObject1 = String.valueOf(localObject4);
          if ("nm".length() != 0) {
            localObject1 = ((String)localObject1).concat("nm");
          } else {
            localObject1 = new String((String)localObject1);
          }
          localHashMap.put(localObject1, (String)((Map.Entry)localObject3).getKey());
        }
        i += 1;
      }
    }
    localObject1 = (com.google.android.android.internal.zzama)paramPingManager.getLogger(com.google.android.gms.internal.zzama.class);
    if (localObject1 != null)
    {
      put(localHashMap, "ul", ((com.google.android.android.internal.zzama)localObject1).getLanguage());
      put(localHashMap, "sd", zzdmo);
      put(localHashMap, "sr", zzceu, zzcev);
      put(localHashMap, "vp", zzdmp, zzdmq);
    }
    paramPingManager = (com.google.android.android.internal.zzalv)paramPingManager.getLogger(com.google.android.gms.internal.zzalv.class);
    if (paramPingManager != null)
    {
      put(localHashMap, "an", paramPingManager.zzun());
      put(localHashMap, "aid", paramPingManager.getAppId());
      put(localHashMap, "aiid", paramPingManager.zzup());
      put(localHashMap, "av", paramPingManager.zzuo());
    }
    return localHashMap;
  }
  
  public static void writeValue(Map paramMap, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramMap.put(paramString, "1");
    }
  }
  
  public static Uri zzcx(String paramString)
  {
    zzbp.zzgg(paramString);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("google-analytics.com");
    localBuilder.path(paramString);
    return localBuilder.build();
  }
  
  public final void write(PingManager paramPingManager)
  {
    zzbp.append(paramPingManager);
    zzbp.get(paramPingManager.zzub(), "Can't deliver not submitted measurement");
    zzbp.zzgh("deliver should be called on worker thread");
    Object localObject1 = paramPingManager.zztx();
    Object localObject2 = (com.google.android.android.internal.zzame)((PingManager)localObject1).getInstance(com.google.android.gms.internal.zzame.class);
    if (TextUtils.isEmpty(((com.google.android.android.internal.zzame)localObject2).zzvd()))
    {
      zzvy().write(writeValue((PingManager)localObject1), "Ignoring measurement without type");
      return;
    }
    if (TextUtils.isEmpty(((com.google.android.android.internal.zzame)localObject2).zzve()))
    {
      zzvy().write(writeValue((PingManager)localObject1), "Ignoring measurement without client id");
      return;
    }
    if (zzdjj.zzwn().getAppOptOut()) {
      return;
    }
    double d = ((com.google.android.android.internal.zzame)localObject2).zzvj();
    if (zzapd.a(d, ((com.google.android.android.internal.zzame)localObject2).zzve()))
    {
      add("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
      return;
    }
    localObject1 = writeValue((PingManager)localObject1);
    ((Map)localObject1).put("v", "1");
    ((Map)localObject1).put("_v", zzamt.zzdof);
    ((Map)localObject1).put("tid", zzdjo);
    if (zzdjj.zzwn().isDryRunEnabled())
    {
      paramPingManager = new StringBuilder();
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (paramPingManager.length() != 0) {
          paramPingManager.append(", ");
        }
        paramPingManager.append((String)((Map.Entry)localObject2).getKey());
        paramPingManager.append("=");
        paramPingManager.append((String)((Map.Entry)localObject2).getValue());
      }
      usage("Dry run is enabled. GoogleAnalytics would have sent", paramPingManager.toString());
      return;
    }
    HashMap localHashMap = new HashMap();
    zzapd.put(localHashMap, "uid", ((com.google.android.android.internal.zzame)localObject2).getUserId());
    com.google.android.android.internal.zzalv localZzalv = (com.google.android.android.internal.zzalv)paramPingManager.getLogger(com.google.android.gms.internal.zzalv.class);
    if (localZzalv != null)
    {
      zzapd.put(localHashMap, "an", localZzalv.zzun());
      zzapd.put(localHashMap, "aid", localZzalv.getAppId());
      zzapd.put(localHashMap, "av", localZzalv.zzuo());
      zzapd.put(localHashMap, "aiid", localZzalv.zzup());
    }
    localObject2 = new zzamx(0L, ((com.google.android.android.internal.zzame)localObject2).zzve(), zzdjo, TextUtils.isEmpty(((com.google.android.android.internal.zzame)localObject2).zzvf()) ^ true, 0L, localHashMap);
    ((Map)localObject1).put("_s", String.valueOf(zzwc().getThreadId((zzamx)localObject2)));
    paramPingManager = new zzaoi(zzvy(), (Map)localObject1, paramPingManager.zztz(), true);
    zzwc().removeKey(paramPingManager);
  }
  
  public final Uri zztu()
  {
    return zzdjp;
  }
}
