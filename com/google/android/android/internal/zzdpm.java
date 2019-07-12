package com.google.android.android.internal;

import java.util.Comparator;

public final class zzdpm<A extends Comparable<A>>
  implements Comparator<A>
{
  public static zzdpm zzlte = new zzdpm();
  
  public zzdpm() {}
  
  public static zzdpm lookupName(Class paramClass)
  {
    return zzlte;
  }
}
