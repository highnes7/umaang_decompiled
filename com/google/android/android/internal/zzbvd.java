package com.google.android.android.internal;

public abstract class zzbvd<T>
{
  public final int zzbfe;
  public final String zzbff;
  public final T zzbfg;
  
  public zzbvd(int paramInt, String paramString, Object paramObject)
  {
    zzbfe = paramInt;
    zzbff = paramString;
    zzbfg = paramObject;
    zzbvo.zzapf().setFragment(this);
  }
  
  public static zzbvh addPlaylist(int paramInt, String paramString, long paramLong)
  {
    return new zzbvh(0, paramString, Long.valueOf(paramLong));
  }
  
  public static zzbvf setPermission(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new zzbvf(0, paramString, paramBoolean);
  }
  
  public static zzbvg sweep(int paramInt1, String paramString, int paramInt2)
  {
    return new zzbvg(0, paramString, Integer.valueOf(paramInt2));
  }
  
  public final String getKey()
  {
    return zzbff;
  }
  
  public final int getSource()
  {
    return zzbfe;
  }
  
  public abstract Object reduce(zzbvl paramZzbvl);
  
  public final Object zzil()
  {
    return zzbfg;
  }
}
