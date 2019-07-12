package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DatabaseAdapter
  extends zzgi
{
  public static final String ARG0;
  public static final String ID = zzbd.zzkc.toString();
  public static final String zzjot;
  public static final String zzjou;
  public static String zzjov;
  public static final Set<String> zzjow = new HashSet();
  public final Context mContext;
  public final zzm.zza zzjox;
  
  static
  {
    ARG0 = zzbe.zzvc.toString();
    zzjot = zzbe.zzma.toString();
    zzjou = zzbe.zzvb.toString();
    String str = ID;
    zzjov = StringBuilder.append(StringBuilder.append(str, 17), "gtm_", str, "_unrepeatable");
  }
  
  public DatabaseAdapter(Context paramContext)
  {
    this(paramContext, new FileBrowser.1(paramContext));
  }
  
  public DatabaseAdapter(Context paramContext, zzm.zza paramZza)
  {
    super(ID, new String[] { ARG0 });
    zzjox = paramZza;
    mContext = paramContext;
  }
  
  private final boolean zzlc(String paramString)
  {
    try
    {
      boolean bool = zzjow.contains(paramString);
      if (bool) {
        return true;
      }
      if (mContext.getSharedPreferences(zzjov, 0).contains(paramString))
      {
        zzjow.add(paramString);
        return true;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void doInBackground(Map paramMap)
  {
    String str;
    if (paramMap.get(zzjou) != null) {
      str = zzgk.toString((zzbp)paramMap.get(zzjou));
    } else {
      str = null;
    }
    if ((str != null) && (zzlc(str))) {
      return;
    }
    Uri.Builder localBuilder = Uri.parse(zzgk.toString((zzbp)paramMap.get(ARG0))).buildUpon();
    paramMap = (zzbp)paramMap.get(zzjot);
    if (paramMap != null)
    {
      paramMap = zzgk.get(paramMap);
      if (!(paramMap instanceof List))
      {
        paramMap = String.valueOf(localBuilder.build().toString());
        if (paramMap.length() != 0) {
          paramMap = "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(paramMap);
        } else {
          paramMap = new String("ArbitraryPixel: additional params not a list: not sending partial hit: ");
        }
        zzdj.zzjss.get(paramMap);
        return;
      }
      paramMap = ((List)paramMap).iterator();
      while (paramMap.hasNext())
      {
        Object localObject = paramMap.next();
        if (!(localObject instanceof Map))
        {
          paramMap = String.valueOf(localBuilder.build().toString());
          if (paramMap.length() != 0) {
            paramMap = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(paramMap);
          } else {
            paramMap = new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: ");
          }
          zzdj.zzjss.get(paramMap);
          return;
        }
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localBuilder.appendQueryParameter(localEntry.getKey().toString(), localEntry.getValue().toString());
        }
      }
    }
    paramMap = localBuilder.build().toString();
    zzjox.zzbck().zzlo(paramMap);
    paramMap = String.valueOf(paramMap);
    if (paramMap.length() != 0) {
      paramMap = "ArbitraryPixel: url = ".concat(paramMap);
    } else {
      paramMap = new String("ArbitraryPixel: url = ");
    }
    zzdj.zzjss.append(paramMap);
    if (str != null) {
      try
      {
        zzjow.add(str);
        zzfu.store(mContext, zzjov, str, "true");
        return;
      }
      catch (Throwable paramMap)
      {
        throw paramMap;
      }
    }
  }
}
