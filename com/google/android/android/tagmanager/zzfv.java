package com.google.android.android.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public final class zzfv
  implements zzbe
{
  public final Context mContext;
  public final String zzbwi;
  public final zzfy zzjvu;
  public final zzfx zzjvv;
  
  public zzfv(Context paramContext, zzfx paramZzfx)
  {
    this(new zzfw(), paramContext, paramZzfx);
  }
  
  public zzfv(zzfy paramZzfy, Context paramContext, zzfx paramZzfx)
  {
    zzjvu = paramZzfy;
    mContext = paramContext.getApplicationContext();
    zzjvv = paramZzfx;
    paramZzfx = Build.VERSION.RELEASE;
    Locale localLocale = Locale.getDefault();
    paramContext = null;
    if (localLocale == null)
    {
      paramZzfy = paramContext;
    }
    else
    {
      paramZzfy = paramContext;
      if (localLocale.getLanguage() != null) {
        if (localLocale.getLanguage().length() == 0)
        {
          paramZzfy = paramContext;
        }
        else
        {
          paramZzfy = new StringBuilder();
          paramZzfy.append(localLocale.getLanguage().toLowerCase());
          if ((localLocale.getCountry() != null) && (localLocale.getCountry().length() != 0))
          {
            paramZzfy.append("-");
            paramZzfy.append(localLocale.getCountry().toLowerCase());
          }
          paramZzfy = paramZzfy.toString();
        }
      }
    }
    zzbwi = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { "GoogleTagManager", "4.00", paramZzfx, paramZzfy, Build.MODEL, Build.ID });
  }
  
  public static URL toURL(zzbx paramZzbx)
  {
    paramZzbx = paramZzbx.zzbdt();
    try
    {
      paramZzbx = new URL(paramZzbx);
      return paramZzbx;
    }
    catch (MalformedURLException paramZzbx)
    {
      for (;;) {}
    }
    zzdj.zzjss.get("Error trying to parse the GTM url.");
    return null;
  }
  
  public final void zzai(List paramList)
  {
    int n = Math.min(paramList.size(), 40);
    int m = 0;
    int i;
    for (int j = 1; m < n; j = i)
    {
      zzbx localZzbx = (zzbx)paramList.get(m);
      Object localObject1 = toURL(localZzbx);
      if (localObject1 == null)
      {
        zzdj.zzjss.zzcr("No destination: discarding hit.");
        zzjvv.goTo(localZzbx);
        i = j;
      }
      else
      {
        Object localObject2 = null;
        Object localObject3 = zzjvu;
        int k = j;
        try
        {
          HttpURLConnection localHttpURLConnection = ((zzfy)localObject3).createConnection((URL)localObject1);
          i = j;
          if (j != 0) {
            localObject1 = localObject2;
          }
          try
          {
            zzdo.zzdx(mContext);
            i = 0;
            j = i;
            localObject1 = localObject2;
            localHttpURLConnection.setRequestProperty("User-Agent", zzbwi);
            j = i;
            localObject1 = localObject2;
            k = localHttpURLConnection.getResponseCode();
            j = i;
            localObject1 = localObject2;
            localObject3 = localHttpURLConnection.getInputStream();
            localObject2 = localObject3;
            if (k != 200)
            {
              j = i;
              localObject1 = localObject2;
              Object localObject4 = new StringBuilder(25);
              j = i;
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append("Bad response: ");
              j = i;
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append(k);
              j = i;
              localObject1 = localObject2;
              localObject4 = ((StringBuilder)localObject4).toString();
              j = i;
              localObject1 = localObject2;
              zzdj.zzjss.zzcr((String)localObject4);
              j = i;
              localObject1 = localObject2;
              zzjvv.remind(localZzbx);
            }
            else
            {
              j = i;
              localObject1 = localObject2;
              zzjvv.removeParameter(localZzbx);
            }
            if (localObject3 != null)
            {
              k = i;
              ((InputStream)localObject3).close();
            }
            k = i;
            localHttpURLConnection.disconnect();
          }
          catch (Throwable localThrowable)
          {
            if (localObject1 != null)
            {
              k = j;
              ((InputStream)localObject1).close();
            }
            k = j;
            localHttpURLConnection.disconnect();
            k = j;
            throw localThrowable;
          }
          m += 1;
        }
        catch (IOException localIOException)
        {
          localObject1 = localIOException.getClass().getSimpleName();
          if (((String)localObject1).length() != 0) {
            localObject1 = "Exception sending hit: ".concat((String)localObject1);
          } else {
            localObject1 = new String("Exception sending hit: ");
          }
          zzdj.zzjss.zzcr((String)localObject1);
          localObject1 = ((IOException)localIOException).getMessage();
          zzdj.zzjss.zzcr((String)localObject1);
          zzjvv.remind(localZzbx);
          i = k;
        }
      }
    }
  }
  
  public final boolean zzbdk()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
      return true;
    }
    zzdj.zzjss.append("...no network connectivity");
    return false;
  }
}
