package com.google.android.android.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class MultidimensionalCounter
{
  public static void toString(StringBuilder paramStringBuilder, HashMap paramHashMap)
  {
    paramStringBuilder.append("{");
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (i == 0) {
        paramStringBuilder.append(",");
      } else {
        i = 0;
      }
      String str2 = (String)paramHashMap.get(str1);
      f.sufficientlysecure.rootcommands.util.StringBuilder.write(paramStringBuilder, "\"", str1, "\":");
      if (str2 == null) {
        paramStringBuilder.append("null");
      } else {
        f.sufficientlysecure.rootcommands.util.StringBuilder.write(paramStringBuilder, "\"", str2, "\"");
      }
    }
    paramStringBuilder.append("}");
  }
}
