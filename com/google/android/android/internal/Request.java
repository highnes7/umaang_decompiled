package com.google.android.android.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.zzp;
import java.util.Collections;
import java.util.Map;

public abstract class Request<T>
  implements Comparable<zzp<T>>
{
  public final zzab.zza zzab;
  public final int zzac;
  public final String zzad;
  public final int zzae;
  public final Marker zzaf;
  public Integer zzag;
  public RequestQueue zzah;
  public boolean zzai;
  public boolean zzaj;
  public boolean zzak;
  public boolean zzal;
  public RetryPolicy zzam;
  public Cache.Entry zzan;
  
  public Request(int paramInt, String paramString, Marker paramMarker)
  {
    zzab.zza localZza;
    if (zzab.zza.zzbi) {
      localZza = new zzab.zza();
    } else {
      localZza = null;
    }
    zzab = localZza;
    zzai = true;
    int i = 0;
    zzaj = false;
    zzak = false;
    zzal = false;
    zzan = null;
    zzac = paramInt;
    zzad = paramString;
    zzaf = paramMarker;
    zzam = new DefaultRetryPolicy();
    paramInt = i;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      paramInt = i;
      if (paramString != null)
      {
        paramString = paramString.getHost();
        paramInt = i;
        if (paramString != null) {
          paramInt = paramString.hashCode();
        }
      }
    }
    zzae = paramInt;
  }
  
  public static String getBodyContentType()
  {
    if ("UTF-8".length() != 0) {
      return "application/x-www-form-urlencoded; charset=".concat("UTF-8");
    }
    return new String("application/x-www-form-urlencoded; charset=");
  }
  
  public final void addMarker()
  {
    zzak = true;
  }
  
  public final void addMarker(zzaa paramZzaa)
  {
    Marker localMarker = zzaf;
    if (localMarker != null) {
      localMarker.setMarker(paramZzaa);
    }
  }
  
  public final void addMarker(String paramString)
  {
    if (zzab.zza.zzbi) {
      zzab.add(paramString, Thread.currentThread().getId());
    }
  }
  
  public abstract void deliverResponse(Object paramObject);
  
  public final void finish(String paramString)
  {
    RequestQueue localRequestQueue = zzah;
    if (localRequestQueue != null) {
      localRequestQueue.finish(this);
    }
    if (zzab.zza.zzbi)
    {
      long l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        new Handler(Looper.getMainLooper()).post(new MainActivity.13(this, paramString, l));
        return;
      }
      zzab.add(paramString, l);
      zzab.finish(toString());
    }
  }
  
  public final Cache.Entry getCacheEntry()
  {
    return zzan;
  }
  
  public final String getCacheKey()
  {
    return zzad;
  }
  
  public Map getHeaders()
    throws AtomicBoolean
  {
    return Collections.emptyMap();
  }
  
  public final int getMethod()
  {
    return zzac;
  }
  
  public byte[] getPostBody()
    throws AtomicBoolean
  {
    return null;
  }
  
  public final RetryPolicy getRetryPolicy()
  {
    return zzam;
  }
  
  public final int getTimeoutMs()
  {
    return zzam.getCurrentTimeout();
  }
  
  public final int getTrafficStatsTag()
  {
    return zzae;
  }
  
  public final String getUrl()
  {
    return zzad;
  }
  
  public final boolean hasHadResponseDelivered()
  {
    return zzak;
  }
  
  public abstract Response parseNetworkResponse(NetworkResponse paramNetworkResponse);
  
  public final Request request(int paramInt)
  {
    zzag = Integer.valueOf(paramInt);
    return this;
  }
  
  public final Request setCacheEntry(Cache.Entry paramEntry)
  {
    zzan = paramEntry;
    return this;
  }
  
  public final Request setRequestQueue(RequestQueue paramRequestQueue)
  {
    zzah = paramRequestQueue;
    return this;
  }
  
  public final boolean shouldCache()
  {
    return zzai;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(Integer.toHexString(zzae));
    if (str1.length() != 0) {
      str1 = "0x".concat(str1);
    } else {
      str1 = new String("0x");
    }
    String str2 = zzad;
    String str3 = String.valueOf(RAT.zzas);
    String str4 = String.valueOf(zzag);
    int i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str1, f.sufficientlysecure.rootcommands.util.StringBuilder.append(str2, "[ ] ".length() + 3));
    int j = str3.length();
    StringBuilder localStringBuilder = new StringBuilder(str4.length() + (j + i));
    localStringBuilder.append("[ ] ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" ");
    localStringBuilder.append(str1);
    return f.sufficientlysecure.rootcommands.util.StringBuilder.replace(localStringBuilder, " ", str3, " ", str4);
  }
}
