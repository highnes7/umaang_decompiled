package com.google.android.android.internal;

public enum zzats
{
  public final String zzefq;
  
  public zzats(String paramString)
  {
    zzefq = paramString;
  }
  
  public static final zzats zzet(String paramString)
  {
    zzats[] arrayOfZzats = values();
    int j = arrayOfZzats.length;
    Object localObject = null;
    int i = 0;
    while (i < j)
    {
      zzats localZzats = arrayOfZzats[i];
      if (zzefq.equals(paramString)) {
        localObject = localZzats;
      }
      i += 1;
    }
    return localObject;
  }
}
