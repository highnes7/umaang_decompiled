package com.google.android.android.internal;

import com.google.android.gms.internal.zzdbq;
import java.util.Collections;
import java.util.List;

public final class zzdbu
{
  public final List<zzdbq> zzkee;
  public final List<zzdbq> zzkef;
  public final List<zzdbq> zzkeg;
  public final List<zzdbq> zzkeh;
  public final List<zzdbq> zzkfm;
  public final List<zzdbq> zzkfn;
  public final List<String> zzkfo;
  public final List<String> zzkfp;
  public final List<String> zzkfq;
  public final List<String> zzkfr;
  
  public zzdbu(List paramList1, List paramList2, List paramList3, List paramList4, List paramList5, List paramList6, List paramList7, List paramList8, List paramList9, List paramList10)
  {
    zzkee = Collections.unmodifiableList(paramList1);
    zzkef = Collections.unmodifiableList(paramList2);
    zzkeg = Collections.unmodifiableList(paramList3);
    zzkeh = Collections.unmodifiableList(paramList4);
    zzkfm = Collections.unmodifiableList(paramList5);
    zzkfn = Collections.unmodifiableList(paramList6);
    zzkfo = Collections.unmodifiableList(paramList7);
    zzkfp = Collections.unmodifiableList(paramList8);
    zzkfq = Collections.unmodifiableList(paramList9);
    zzkfr = Collections.unmodifiableList(paramList10);
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(zzkee);
    String str2 = String.valueOf(zzkef);
    String str3 = String.valueOf(zzkeg);
    String str4 = String.valueOf(zzkeh);
    String str5 = String.valueOf(zzkfm);
    String str6 = String.valueOf(zzkfn);
    int i = str1.length();
    int j = str2.length();
    int k = str3.length();
    int m = str4.length();
    int n = str5.length();
    StringBuilder localStringBuilder = new StringBuilder(str6.length() + (n + (m + (k + (j + (i + 102))))));
    localStringBuilder.append("Positive predicates: ");
    localStringBuilder.append(str1);
    localStringBuilder.append("  Negative predicates: ");
    localStringBuilder.append(str2);
    f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, "  Add tags: ", str3, "  Remove tags: ", str4);
    return f.sufficientlysecure.rootcommands.util.StringBuilder.replace(localStringBuilder, "  Add macros: ", str5, "  Remove macros: ", str6);
  }
  
  public final List zzbhf()
  {
    return zzkee;
  }
  
  public final List zzbhg()
  {
    return zzkef;
  }
  
  public final List zzbhh()
  {
    return zzkeg;
  }
  
  public final List zzbhi()
  {
    return zzkeh;
  }
  
  public final List zzbia()
  {
    return zzkfm;
  }
  
  public final List zzbib()
  {
    return zzkfn;
  }
}
