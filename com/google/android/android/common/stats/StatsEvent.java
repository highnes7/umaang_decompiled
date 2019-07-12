package com.google.android.android.common.stats;

import com.google.android.android.common.internal.ReflectedParcelable;
import com.google.android.android.internal.zzbck;

public abstract class StatsEvent
  extends zzbck
  implements ReflectedParcelable
{
  public StatsEvent() {}
  
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    long l1 = getTimeMillis();
    int i = getEventType();
    long l2 = zzakz();
    String str = zzala();
    int j = "\t".length();
    StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, "\t".length() + (j + 51)));
    localStringBuilder.append(l1);
    localStringBuilder.append("\t");
    localStringBuilder.append(i);
    localStringBuilder.append("\t");
    localStringBuilder.append(l2);
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public abstract long zzakz();
  
  public abstract String zzala();
}
