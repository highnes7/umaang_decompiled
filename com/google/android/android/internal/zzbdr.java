package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzbdr
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbdr> CREATOR = new zzbdu();
  public int zzdxs;
  public final HashMap<String, Map<String, com.google.android.gms.internal.zzbdm<?, ?>>> zzfxa;
  public final ArrayList<com.google.android.gms.internal.zzbds> zzfxb;
  public final String zzfxc;
  
  public zzbdr(int paramInt, ArrayList paramArrayList, String paramString)
  {
    zzdxs = paramInt;
    zzfxb = null;
    HashMap localHashMap = new HashMap();
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i)
    {
      zzbds localZzbds = (zzbds)paramArrayList.get(paramInt);
      localHashMap.put(className, localZzbds.zzakw());
      paramInt += 1;
    }
    zzfxa = localHashMap;
    zzbp.append(paramString);
    zzfxc = ((String)paramString);
    zzaku();
  }
  
  private final void zzaku()
  {
    Iterator localIterator1 = zzfxa.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)zzfxa.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((zzbdm)((Map)localObject).get((String)localIterator2.next())).addPauseListener(this);
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = zzfxa.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(":\n");
      localObject = (Map)zzfxa.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        f.sufficientlysecure.rootcommands.util.StringBuilder.write(localStringBuilder, "  ", str, ": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzfxa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzbds(str, (Map)zzfxa.get(str)));
    }
    zzbcn.save(paramParcel, 2, localArrayList, false);
    zzbcn.append(paramParcel, 3, zzfxc, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final String zzakv()
  {
    return zzfxc;
  }
  
  public final Map zzgk(String paramString)
  {
    return (Map)zzfxa.get(paramString);
  }
}
