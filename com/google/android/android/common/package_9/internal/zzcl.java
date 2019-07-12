package com.google.android.android.common.package_9.internal;

public final class zzcl<L>
{
  public final L mListener;
  public final String zzfox;
  
  public zzcl(Object paramObject, String paramString)
  {
    mListener = paramObject;
    zzfox = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zzcl)) {
      return false;
    }
    paramObject = (zzcl)paramObject;
    return (mListener == mListener) && (zzfox.equals(zzfox));
  }
  
  public final int hashCode()
  {
    int i = System.identityHashCode(mListener);
    return zzfox.hashCode() + i * 31;
  }
}
