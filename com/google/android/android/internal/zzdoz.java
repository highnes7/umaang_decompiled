package com.google.android.android.internal;

public final class zzdoz<K, V>
  extends com.google.android.gms.internal.zzdpf<K, V>
{
  public int size = -1;
  
  public zzdoz(Object paramObject1, Object paramObject2, zzdpb paramZzdpb1, zzdpb paramZzdpb2)
  {
    super(paramObject1, paramObject2, paramZzdpb1, paramZzdpb2);
  }
  
  public final void moveToNext(zzdpb paramZzdpb)
  {
    if (size == -1)
    {
      zzlst = paramZzdpb;
      return;
    }
    throw new IllegalStateException("Can't set left after using size");
  }
  
  public final int size()
  {
    if (size == -1)
    {
      int i = zzbqm().size();
      size = (zzbqn().size() + (i + 1));
    }
    return size;
  }
  
  public final zzdpf subtract(Object paramObject1, Object paramObject2, zzdpb paramZzdpb1, zzdpb paramZzdpb2)
  {
    Object localObject = paramObject1;
    if (paramObject1 == null) {
      localObject = getKey();
    }
    paramObject1 = paramObject2;
    if (paramObject2 == null) {
      paramObject1 = getValue();
    }
    paramObject2 = paramZzdpb1;
    if (paramZzdpb1 == null) {
      paramObject2 = zzbqm();
    }
    paramZzdpb1 = paramZzdpb2;
    if (paramZzdpb2 == null) {
      paramZzdpb1 = zzbqn();
    }
    return new zzdoz(localObject, paramObject1, paramObject2, paramZzdpb1);
  }
  
  public final int zzbqj()
  {
    return zzdpc.zzlsq;
  }
  
  public final boolean zzbqk()
  {
    return false;
  }
}
