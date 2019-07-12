package com.google.android.android.internal;

public final class zzdpe<K, V>
  extends com.google.android.gms.internal.zzdpf<K, V>
{
  public zzdpe(Object paramObject1, Object paramObject2)
  {
    super(paramObject1, paramObject2, localZzdpa, localZzdpa);
  }
  
  public zzdpe(Object paramObject1, Object paramObject2, zzdpb paramZzdpb1, zzdpb paramZzdpb2)
  {
    super(paramObject1, paramObject2, paramZzdpb1, paramZzdpb2);
  }
  
  public final int size()
  {
    int i = zzbqm().size();
    return zzbqn().size() + (i + 1);
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
    return new zzdpe(localObject, paramObject1, paramObject2, paramZzdpb1);
  }
  
  public final int zzbqj()
  {
    return zzdpc.zzlsp;
  }
  
  public final boolean zzbqk()
  {
    return true;
  }
}
