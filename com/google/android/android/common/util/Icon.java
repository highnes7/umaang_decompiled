package com.google.android.android.common.util;

import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.Scope;
import java.util.Set;

public final class Icon
{
  public static String[] render(Set paramSet)
  {
    zzbp.get(paramSet, "scopes can't be null.");
    paramSet = (Scope[])paramSet.toArray(new Scope[paramSet.size()]);
    zzbp.get(paramSet, "scopes can't be null.");
    String[] arrayOfString = new String[paramSet.length];
    int i = 0;
    while (i < paramSet.length)
    {
      arrayOfString[i] = paramSet[i].zzaft();
      i += 1;
    }
    return arrayOfString;
  }
}
