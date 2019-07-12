package com.google.android.android.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class zzei
{
  public static zzei zzjti;
  public volatile String zzjoz = null;
  public volatile zza zzjtj = zza.zzjtm;
  public volatile String zzjtk = null;
  public volatile String zzjtl = null;
  
  public zzei() {}
  
  public static zzei zzbeh()
  {
    try
    {
      if (zzjti == null) {
        zzjti = new zzei();
      }
      zzei localZzei = zzjti;
      return localZzei;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static String zzlx(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  public final String getContainerId()
  {
    return zzjoz;
  }
  
  public final boolean parseUrl(Uri paramUri)
  {
    try
    {
      String str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$"))
      {
        if (str.length() != 0) {
          localObject = "Container preview url: ".concat(str);
        } else {
          localObject = new String("Container preview url: ");
        }
        zzdj.zzjss.append((String)localObject);
        if (str.matches(".*?&gtm_debug=x$")) {}
        for (Object localObject = zza.zzjto;; localObject = zza.zzjtn)
        {
          zzjtj = ((zza)localObject);
          break;
        }
        zzjtl = paramUri.getQuery().replace("&gtm_debug=x", "");
        if ((zzjtj == zza.zzjtn) || (zzjtj == zza.zzjto))
        {
          paramUri = String.valueOf(zzjtl);
          if (paramUri.length() != 0) {
            paramUri = "/r?".concat(paramUri);
          } else {
            paramUri = new String("/r?");
          }
          zzjtk = paramUri;
        }
        zzjoz = zzlx(zzjtl);
        return true;
      }
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (zzlx(paramUri.getQuery()).equals(zzjoz))
        {
          paramUri = String.valueOf(zzjoz);
          if (paramUri.length() != 0) {
            paramUri = "Exit preview mode for container: ".concat(paramUri);
          } else {
            paramUri = new String("Exit preview mode for container: ");
          }
          zzdj.zzjss.append(paramUri);
          zzjtj = zza.zzjtm;
          zzjtk = null;
          return true;
        }
        return false;
      }
      if (str.length() != 0) {
        paramUri = "Invalid preview uri: ".concat(str);
      } else {
        paramUri = new String("Invalid preview uri: ");
      }
      zzdj.zzjss.zzcr(paramUri);
      return false;
    }
    catch (Throwable paramUri)
    {
      throw paramUri;
      return false;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;) {}
    }
  }
  
  public final zza zzbei()
  {
    return zzjtj;
  }
  
  public final String zzbej()
  {
    return zzjtk;
  }
  
  public enum zza {}
}
