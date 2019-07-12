package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class zzgo
{
  public static zzea evaluate(zzea paramZzea, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      if (!(zzgk.get((zzbp)paramZzea.getObject()) instanceof String))
      {
        zzdj.zzjss.get("Escaping can only be applied to strings.");
      }
      else if (k != 12)
      {
        String str = StringBuilder.add(39, "Unsupported Value Escaping: ", k);
        zzdj.zzjss.get(str);
      }
      else
      {
        paramZzea = getObject(paramZzea);
      }
      i += 1;
    }
    return paramZzea;
  }
  
  public static zzea getObject(zzea paramZzea)
  {
    try
    {
      Object localObject = paramZzea.getObject();
      localObject = (zzbp)localObject;
      localObject = zzmj(zzgk.toString((zzbp)localObject));
      localObject = new zzea(zzgk.zzah(localObject), paramZzea.zzbed());
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      zzdj.zzjss.e("Escape URI: unsupported encoding", localUnsupportedEncodingException);
    }
    return paramZzea;
  }
  
  public static String zzmj(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
}
