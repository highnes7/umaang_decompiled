package com.google.android.android.internal;

import java.util.Comparator;

public abstract class zzdpf<K, V>
  implements com.google.android.gms.internal.zzdpb<K, V>
{
  public final V value;
  public final K zzlss;
  public com.google.android.gms.internal.zzdpb<K, V> zzlst;
  public final com.google.android.gms.internal.zzdpb<K, V> zzlsu;
  
  public zzdpf(Object paramObject1, Object paramObject2, zzdpb paramZzdpb1, zzdpb paramZzdpb2)
  {
    zzlss = paramObject1;
    value = paramObject2;
    paramObject1 = paramZzdpb1;
    if (paramZzdpb1 == null) {
      paramObject1 = zzdpa.zzlso;
    }
    zzlst = paramObject1;
    paramObject1 = paramZzdpb2;
    if (paramZzdpb2 == null) {
      paramObject1 = zzdpa.zzlso;
    }
    zzlsu = paramObject1;
  }
  
  private final zzdpf copyProperties(Object paramObject1, Object paramObject2, int paramInt, zzdpb paramZzdpb1, zzdpb paramZzdpb2)
  {
    Object localObject1 = zzlss;
    Object localObject2 = value;
    paramObject1 = paramZzdpb1;
    if (paramZzdpb1 == null) {
      paramObject1 = zzlst;
    }
    paramObject2 = paramZzdpb2;
    if (paramZzdpb2 == null) {
      paramObject2 = zzlsu;
    }
    if (paramInt == zzdpc.zzlsp) {
      return new zzdpe(localObject1, localObject2, paramObject1, paramObject2);
    }
    return new zzdoz(localObject1, localObject2, paramObject1, paramObject2);
  }
  
  public static int distanceTo(zzdpb paramZzdpb)
  {
    if (paramZzdpb.zzbqk()) {
      return zzdpc.zzlsq;
    }
    return zzdpc.zzlsp;
  }
  
  private final zzdpb zzbqq()
  {
    if (zzlst.isEmpty()) {
      return zzdpa.zzlso;
    }
    zzdpf localZzdpf = this;
    if (!zzlst.zzbqk())
    {
      localZzdpf = this;
      if (!zzlst.zzbqm().zzbqk()) {
        localZzdpf = zzbqr();
      }
    }
    return localZzdpf.subtract(null, null, ((zzdpf)zzlst).zzbqq(), null).zzbqs();
  }
  
  private final zzdpf zzbqr()
  {
    zzdpf localZzdpf2 = zzbqv();
    zzdpf localZzdpf1 = localZzdpf2;
    if (zzlsu.zzbqm().zzbqk()) {
      localZzdpf1 = localZzdpf2.subtract(null, null, null, ((zzdpf)zzlsu).zzbqu()).zzbqt().zzbqv();
    }
    return localZzdpf1;
  }
  
  private final zzdpf zzbqs()
  {
    Object localObject2 = this;
    if (zzlsu.zzbqk())
    {
      localObject2 = this;
      if (!zzlst.zzbqk()) {
        localObject2 = zzbqt();
      }
    }
    Object localObject1 = localObject2;
    if (zzlst.zzbqk())
    {
      localObject1 = localObject2;
      if (zzlst).zzlst.zzbqk()) {
        localObject1 = ((zzdpf)localObject2).zzbqu();
      }
    }
    localObject2 = localObject1;
    if (zzlst.zzbqk())
    {
      localObject2 = localObject1;
      if (zzlsu.zzbqk()) {
        localObject2 = ((zzdpf)localObject1).zzbqv();
      }
    }
    return localObject2;
  }
  
  private final zzdpf zzbqt()
  {
    zzdpf localZzdpf = copyProperties(null, null, zzdpc.zzlsp, null, zzlsu).zzlst);
    return (zzdpf)zzlsu.cross(null, null, zzbqj(), localZzdpf, null);
  }
  
  private final zzdpf zzbqu()
  {
    zzdpf localZzdpf = copyProperties(null, null, zzdpc.zzlsp, zzlst).zzlsu, null);
    return (zzdpf)zzlst.cross(null, null, zzbqj(), null, localZzdpf);
  }
  
  private final zzdpf zzbqv()
  {
    zzdpb localZzdpb1 = zzlst;
    localZzdpb1 = localZzdpb1.cross(null, null, distanceTo(localZzdpb1), null, null);
    zzdpb localZzdpb2 = zzlsu;
    localZzdpb2 = localZzdpb2.cross(null, null, distanceTo(localZzdpb2), null, null);
    int i;
    if (zzbqk()) {
      i = zzdpc.zzlsq;
    } else {
      i = zzdpc.zzlsp;
    }
    return copyProperties(null, null, i, localZzdpb1, localZzdpb2);
  }
  
  public final Object getKey()
  {
    return zzlss;
  }
  
  public final Object getValue()
  {
    return value;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  public void moveToNext(zzdpb paramZzdpb)
  {
    zzlst = paramZzdpb;
  }
  
  public final void saveToFile(zzdpd paramZzdpd)
  {
    zzlst.saveToFile(paramZzdpd);
    paramZzdpd.append(zzlss, value);
    zzlsu.saveToFile(paramZzdpd);
  }
  
  public final zzdpb subtract(Object paramObject1, Object paramObject2, Comparator paramComparator)
  {
    int i = paramComparator.compare(paramObject1, zzlss);
    if (i < 0) {
      paramObject1 = subtract(null, null, zzlst.subtract(paramObject1, paramObject2, paramComparator), null);
    } else if (i == 0) {
      paramObject1 = subtract(paramObject1, paramObject2, null, null);
    } else {
      paramObject1 = subtract(null, null, null, zzlsu.subtract(paramObject1, paramObject2, paramComparator));
    }
    return paramObject1.zzbqs();
  }
  
  public final zzdpb subtract(Object paramObject, Comparator paramComparator)
  {
    Object localObject1;
    if (paramComparator.compare(paramObject, zzlss) < 0)
    {
      localObject1 = this;
      if (!zzlst.isEmpty())
      {
        localObject1 = this;
        if (!zzlst.zzbqk())
        {
          localObject1 = this;
          if (!zzlst).zzlst.zzbqk()) {
            localObject1 = zzbqr();
          }
        }
      }
      paramObject = ((zzdpf)localObject1).subtract(null, null, zzlst.subtract(paramObject, paramComparator), null);
    }
    else
    {
      Object localObject2 = this;
      if (zzlst.zzbqk()) {
        localObject2 = zzbqu();
      }
      localObject1 = localObject2;
      if (!zzlsu.isEmpty())
      {
        localObject1 = localObject2;
        if (!zzlsu.zzbqk())
        {
          localObject1 = localObject2;
          if (!zzlsu).zzlst.zzbqk())
          {
            localObject2 = ((zzdpf)localObject2).zzbqv();
            localObject1 = localObject2;
            if (zzlst.zzbqm().zzbqk()) {
              localObject1 = ((zzdpf)localObject2).zzbqu().zzbqv();
            }
          }
        }
      }
      localObject2 = localObject1;
      if (paramComparator.compare(paramObject, zzlss) == 0)
      {
        if (zzlsu.isEmpty()) {
          return zzdpa.zzlso;
        }
        localObject2 = zzlsu.zzbqo();
        localObject2 = ((zzdpf)localObject1).subtract(((zzdpb)localObject2).getKey(), ((zzdpb)localObject2).getValue(), null, ((zzdpf)zzlsu).zzbqq());
      }
      paramObject = ((zzdpf)localObject2).subtract(null, null, null, zzlsu.subtract(paramObject, paramComparator));
    }
    return paramObject.zzbqs();
  }
  
  public abstract zzdpf subtract(Object paramObject1, Object paramObject2, zzdpb paramZzdpb1, zzdpb paramZzdpb2);
  
  public abstract int zzbqj();
  
  public final zzdpb zzbqm()
  {
    return zzlst;
  }
  
  public final zzdpb zzbqn()
  {
    return zzlsu;
  }
  
  public final zzdpb zzbqo()
  {
    if (zzlst.isEmpty()) {
      return this;
    }
    return zzlst.zzbqo();
  }
  
  public final zzdpb zzbqp()
  {
    if (zzlsu.isEmpty()) {
      return this;
    }
    return zzlsu.zzbqp();
  }
}
