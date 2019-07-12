package com.google.android.android.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.android.internal.zzdbo;
import com.google.android.android.internal.zzdby;
import com.google.android.android.internal.zzdbz;
import com.google.android.android.internal.zzdca;
import com.google.android.android.internal.zzdcb;
import com.google.android.android.internal.zzeyn;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzes
  implements Runnable
{
  public final Context mContext;
  public final String zzjoz;
  public volatile String zzjpx;
  public final zzdca zzjtw;
  public final String zzjtx;
  public com.google.android.gms.tagmanager.zzdi<com.google.android.gms.internal.zzbo> zzjty;
  public volatile zzal zzjtz;
  public volatile String zzjua;
  
  public zzes(Context paramContext, String paramString, zzdca paramZzdca, zzal paramZzal)
  {
    mContext = paramContext;
    zzjtw = paramZzdca;
    zzjoz = paramString;
    zzjtz = paramZzal;
    paramContext = String.valueOf(paramString);
    if (paramContext.length() != 0) {
      paramContext = "/r?id=".concat(paramContext);
    } else {
      paramContext = new String("/r?id=");
    }
    zzjtx = paramContext;
    zzjpx = zzjtx;
    zzjua = null;
  }
  
  public zzes(Context paramContext, String paramString, zzal paramZzal)
  {
    this(paramContext, paramString, new zzdca(), paramZzal);
  }
  
  public final void run()
  {
    Object localObject1;
    Object localObject2;
    zzdby localZzdby;
    if (zzjty != null)
    {
      localObject1 = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
      {
        i = 1;
      }
      else
      {
        zzdj.zzjss.append("...no network connectivity");
        i = 0;
      }
      if (i == 0)
      {
        zzjty.zzed(zzda.zzjsk);
        return;
      }
      zzdj.zzjss.append("Start loading resource from network ...");
      localObject1 = zzjtz.zzbdc();
      localObject2 = zzjpx;
      i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, String.valueOf(localObject1).length());
      localObject4 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("&v=a65833898".length() + i, (String)localObject1, (String)localObject2, "&v=a65833898");
      localObject1 = localObject4;
      localObject2 = localObject1;
      if (zzjua != null)
      {
        localObject2 = localObject1;
        if (!zzjua.trim().equals(""))
        {
          localObject1 = String.valueOf(localObject4);
          localObject2 = zzjua;
          i = ((String)localObject1).length();
          localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, "&pv=".length() + i), (String)localObject1, "&pv=", (String)localObject2);
        }
      }
      localObject1 = localObject2;
      if (zzei.zzbeh().zzbei().equals(zzei.zza.zzjto))
      {
        localObject1 = String.valueOf(localObject2);
        if ("&gtm_debug=x".length() != 0) {
          localObject1 = ((String)localObject1).concat("&gtm_debug=x");
        } else {
          localObject1 = new String((String)localObject1);
        }
      }
      localZzdby = new zzdby();
      localObject4 = null;
    }
    try
    {
      try
      {
        localObject2 = localZzdby.zznb((String)localObject1);
      }
      catch (Throwable localThrowable)
      {
        break label900;
      }
      catch (IOException localIOException1)
      {
        localObject4 = localIOException1.getMessage();
        i = String.valueOf(localThrowable).length();
        j = String.valueOf(localObject4).length();
        localObject5 = new StringBuilder(i + 40 + j);
        ((StringBuilder)localObject5).append("Error when loading resources from url: ");
        ((StringBuilder)localObject5).append(localThrowable);
        ((StringBuilder)localObject5).append(" ");
        ((StringBuilder)localObject5).append((String)localObject4);
        str1 = ((StringBuilder)localObject5).toString();
        zzdj.zzjss.closeSession(str1, localIOException1);
        zzjty.zzed(zzda.zzjsl);
        localZzdby.close();
        return;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      int j;
      Object localObject5;
      String str1;
      Object localObject3;
      String str2;
      for (;;) {}
    }
    catch (zzdcb localZzdcb)
    {
      for (;;) {}
    }
    localObject3 = String.valueOf(str1);
    int i = ((String)localObject3).length();
    if (i != 0) {
      localObject3 = "Error when loading resource for url: ".concat((String)localObject3);
    } else {
      localObject3 = new String("Error when loading resource for url: ");
    }
    zzdj.zzjss.zzcr((String)localObject3);
    zzjty.zzed(zzda.zzjsn);
    localObject3 = localObject4;
    try
    {
      localObject4 = new ByteArrayOutputStream();
      zzdbo.copyFile((InputStream)localObject3, (OutputStream)localObject4);
      localObject3 = ((ByteArrayOutputStream)localObject4).toByteArray();
      localObject4 = new com.google.android.android.internal.zzbo();
      zzeyn.sign((zzeyn)localObject4, (byte[])localObject3);
      localObject4 = (com.google.android.android.internal.zzbo)localObject4;
      localObject3 = String.valueOf(localObject4);
      i = ((String)localObject3).length();
      localObject5 = new StringBuilder(i + 43);
      ((StringBuilder)localObject5).append("Successfully loaded supplemented resource: ");
      ((StringBuilder)localObject5).append((String)localObject3);
      localObject3 = ((StringBuilder)localObject5).toString();
      localObject5 = zzdj.zzjss;
      ((zzdk)localObject5).append((String)localObject3);
      localObject3 = zzxx;
      if (localObject3 == null)
      {
        i = zzxw.length;
        if (i == 0)
        {
          localObject3 = zzjoz;
          localObject3 = String.valueOf(localObject3);
          i = ((String)localObject3).length();
          if (i != 0) {
            localObject3 = "No change for container: ".concat((String)localObject3);
          } else {
            localObject3 = new String("No change for container: ");
          }
          localObject5 = zzdj.zzjss;
          ((zzdk)localObject5).append((String)localObject3);
        }
      }
      localObject3 = zzjty;
      ((zzdi)localObject3).onSuccess(localObject4);
      localZzdby.close();
      zzdj.zzjss.append("Load resource from network finished.");
      return;
    }
    catch (IOException localIOException2)
    {
      localObject4 = localIOException2.getMessage();
      i = String.valueOf(str1).length();
      j = String.valueOf(localObject4).length();
      localObject5 = new StringBuilder(i + 51 + j);
      ((StringBuilder)localObject5).append("Error when parsing downloaded resources from url: ");
      ((StringBuilder)localObject5).append(str1);
      ((StringBuilder)localObject5).append(" ");
      ((StringBuilder)localObject5).append((String)localObject4);
      str1 = ((StringBuilder)localObject5).toString();
      zzdj.zzjss.closeSession(str1, localIOException2);
      zzjty.zzed(zzda.zzjsm);
      localZzdby.close();
      return;
    }
    str2 = zzjoz;
    i = String.valueOf(str1).length();
    j = String.valueOf(str2).length();
    Object localObject4 = new StringBuilder(i + 79 + j);
    ((StringBuilder)localObject4).append("No data is retrieved from the given url: ");
    ((StringBuilder)localObject4).append(str1);
    ((StringBuilder)localObject4).append(". Make sure container_id: ");
    ((StringBuilder)localObject4).append(str2);
    ((StringBuilder)localObject4).append(" is correct.");
    str1 = ((StringBuilder)localObject4).toString();
    zzdj.zzjss.zzcr(str1);
    zzjty.zzed(zzda.zzjsm);
    localZzdby.close();
    return;
    label900:
    localZzdby.close();
    throw str1;
    throw new IllegalStateException("callback must be set before execute");
  }
  
  public final void setBounds(zzdi paramZzdi)
  {
    zzjty = paramZzdi;
  }
  
  public final void zzli(String paramString)
  {
    if (paramString == null)
    {
      zzjpx = zzjtx;
      return;
    }
    String str;
    if (paramString.length() != 0) {
      str = "Setting CTFE URL path: ".concat(paramString);
    } else {
      str = new String("Setting CTFE URL path: ");
    }
    zzdj.zzjss.zzca(str);
    zzjpx = paramString;
  }
  
  public final void zzly(String paramString)
  {
    String str = String.valueOf(paramString);
    if (str.length() != 0) {
      str = "Setting previous container version: ".concat(str);
    } else {
      str = new String("Setting previous container version: ");
    }
    zzdj.zzjss.zzca(str);
    zzjua = paramString;
  }
}
