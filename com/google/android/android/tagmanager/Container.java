package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzbn;
import com.google.android.android.internal.zzbo;
import com.google.android.android.internal.zzbp;
import com.google.android.android.internal.zzdbo;
import com.google.android.android.internal.zzdbs;
import com.google.android.android.internal.zzdbw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  public final Context mContext;
  public final String zzjoz;
  public final DataLayer zzjpa;
  public zzfc zzjpb;
  public Map<String, com.google.android.gms.tagmanager.Container.FunctionCallMacroCallback> zzjpc = new HashMap();
  public Map<String, com.google.android.gms.tagmanager.Container.FunctionCallTagCallback> zzjpd = new HashMap();
  public volatile long zzjpe;
  public volatile String zzjpf = "";
  
  public Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzbo paramZzbo)
  {
    mContext = paramContext;
    zzjpa = paramDataLayer;
    zzjoz = paramString;
    zzjpe = paramLong;
    paramContext = zzxx;
    if (paramContext != null)
    {
      try
      {
        paramDataLayer = zzdbo.getPreferences(paramContext);
        load(paramDataLayer);
      }
      catch (zzdbw paramDataLayer)
      {
        paramContext = String.valueOf(paramContext);
        paramDataLayer = paramDataLayer.toString();
        paramString = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramDataLayer, paramContext.length() + 46));
        paramString.append("Not loading resource: ");
        paramString.append(paramContext);
        paramString.append(" because it is invalid: ");
        paramString.append(paramDataLayer);
        paramContext = paramString.toString();
        zzdj.zzjss.get(paramContext);
      }
      paramContext = zzxw;
      if (paramContext != null) {
        addFiles(paramContext);
      }
    }
    else
    {
      throw new NullPointerException();
    }
  }
  
  public Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzdbs paramZzdbs)
  {
    mContext = paramContext;
    zzjpa = paramDataLayer;
    zzjoz = paramString;
    zzjpe = 0L;
    load(paramZzdbs);
  }
  
  private final void addFiles(zzbn[] paramArrayOfZzbn)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfZzbn.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfZzbn[i]);
      i += 1;
    }
    zzbco().zzaj(localArrayList);
  }
  
  private final void close(zzfc paramZzfc)
  {
    try
    {
      zzjpb = paramZzfc;
      return;
    }
    catch (Throwable paramZzfc)
    {
      throw paramZzfc;
    }
  }
  
  private final void load(zzdbs paramZzdbs)
  {
    zzjpf = paramZzdbs.getVersion();
    zzei.zzbeh().zzbei().equals(zzei.zza.zzjto);
    zzdr localZzdr = new zzdr();
    close(new zzfc(mContext, paramZzdbs, zzjpa, new zza(null), new zzb(null), localZzdr));
    if (getBoolean("_gtm.loadEventEnabled")) {
      zzjpa.pushEvent("gtm.load", DataLayer.mapOf(new Object[] { "gtm.id", zzjoz }));
    }
  }
  
  private final zzfc zzbco()
  {
    try
    {
      zzfc localZzfc = zzjpb;
      return localZzfc;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean getBoolean(String paramString)
  {
    zzfc localZzfc = zzbco();
    if (localZzfc == null) {
      zzdj.zzjss.get("getBoolean called for closed container.");
    }
    for (;;)
    {
      return zzgk.zzjwm.booleanValue();
      try
      {
        paramString = localZzfc.zzlz(paramString).getObject();
        paramString = (zzbp)paramString;
        boolean bool = zzgk.valueOf(paramString).booleanValue();
        return bool;
      }
      catch (Exception paramString)
      {
        paramString = paramString.getMessage();
        paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 66), "Calling getBoolean() threw an exception: ", paramString, " Returning default value.");
        zzdj.zzjss.get(paramString);
      }
    }
  }
  
  public String getContainerId()
  {
    return zzjoz;
  }
  
  public double getDouble(String paramString)
  {
    zzfc localZzfc = zzbco();
    if (localZzfc == null) {
      zzdj.zzjss.get("getDouble called for closed container.");
    }
    for (;;)
    {
      return zzgk.zzjwj.doubleValue();
      try
      {
        paramString = localZzfc.zzlz(paramString).getObject();
        paramString = (zzbp)paramString;
        double d = zzgk.parseDouble(paramString).doubleValue();
        return d;
      }
      catch (Exception paramString)
      {
        paramString = paramString.getMessage();
        paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 65), "Calling getDouble() threw an exception: ", paramString, " Returning default value.");
        zzdj.zzjss.get(paramString);
      }
    }
  }
  
  public long getLastRefreshTime()
  {
    return zzjpe;
  }
  
  public long getLong(String paramString)
  {
    zzfc localZzfc = zzbco();
    if (localZzfc == null) {
      zzdj.zzjss.get("getLong called for closed container.");
    }
    for (;;)
    {
      return zzgk.zzjwi.longValue();
      try
      {
        paramString = localZzfc.zzlz(paramString).getObject();
        paramString = (zzbp)paramString;
        long l = zzgk.getFileSize(paramString).longValue();
        return l;
      }
      catch (Exception paramString)
      {
        paramString = paramString.getMessage();
        paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 63), "Calling getLong() threw an exception: ", paramString, " Returning default value.");
        zzdj.zzjss.get(paramString);
      }
    }
  }
  
  public String getString(String paramString)
  {
    zzfc localZzfc = zzbco();
    if (localZzfc == null) {
      zzdj.zzjss.get("getString called for closed container.");
    }
    for (;;)
    {
      return zzgk.zzjwl;
      try
      {
        paramString = localZzfc.zzlz(paramString).getObject();
        paramString = (zzbp)paramString;
        paramString = zzgk.toString(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = paramString.getMessage();
        paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 65), "Calling getString() threw an exception: ", paramString, " Returning default value.");
        zzdj.zzjss.get(paramString);
      }
    }
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback != null)
    {
      Map localMap = zzjpc;
      try
      {
        zzjpc.put(paramString, paramFunctionCallMacroCallback);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
    }
    throw new NullPointerException("Macro handler must be non-null");
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback != null)
    {
      Map localMap = zzjpd;
      try
      {
        zzjpd.put(paramString, paramFunctionCallTagCallback);
        return;
      }
      catch (Throwable paramString)
      {
        throw paramString;
      }
    }
    throw new NullPointerException("Tag callback must be non-null");
  }
  
  public final void release()
  {
    zzjpb = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    Map localMap = zzjpc;
    try
    {
      zzjpc.remove(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    Map localMap = zzjpd;
    try
    {
      zzjpd.remove(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final String zzbcn()
  {
    return zzjpf;
  }
  
  public final FunctionCallMacroCallback zzle(String paramString)
  {
    Map localMap = zzjpc;
    try
    {
      paramString = (FunctionCallMacroCallback)zzjpc.get(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final FunctionCallTagCallback zzlf(String paramString)
  {
    Map localMap = zzjpd;
    try
    {
      paramString = (FunctionCallTagCallback)zzjpd.get(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void zzlg(String paramString)
  {
    zzbco().zzlg(paramString);
  }
  
  public abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map paramMap);
  }
  
  public abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map paramMap);
  }
  
  public final class zza
    implements zzan
  {
    public zza() {}
    
    public final Object getRawValue(String paramString, Map paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = zzle(paramString);
      if (localFunctionCallMacroCallback == null) {
        return null;
      }
      return localFunctionCallMacroCallback.getValue(paramString, paramMap);
    }
  }
  
  public final class zzb
    implements zzan
  {
    public zzb() {}
    
    public final Object getRawValue(String paramString, Map paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = zzlf(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return zzgk.zzjwl;
    }
  }
}
