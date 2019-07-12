package com.google.android.android.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.TypedValue;

public final class zzca
{
  public static String a(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if (paramAttributeSet == null) {
      paramString1 = null;
    } else {
      paramString1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
    }
    if ((paramString1 != null) && (paramString1.startsWith("@string/")))
    {
      paramString3 = paramString1.substring(8);
      String str = paramContext.getPackageName();
      paramAttributeSet = new TypedValue();
      try
      {
        paramContext = paramContext.getResources();
        i = String.valueOf(str).length();
        int j = String.valueOf(paramString3).length();
        StringBuilder localStringBuilder = new StringBuilder(i + 8 + j);
        localStringBuilder.append(str);
        localStringBuilder.append(":string/");
        localStringBuilder.append(paramString3);
        paramContext.getValue(localStringBuilder.toString(), paramAttributeSet, true);
      }
      catch (Resources.NotFoundException paramContext)
      {
        int i;
        for (;;) {}
      }
      i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString2, 30);
      paramContext = new StringBuilder(paramString1.length() + i);
      paramContext.append("Could not find resource for ");
      paramContext.append(paramString2);
      paramContext.append(": ");
      paramContext.append(paramString1);
      paramContext.toString();
      paramContext = string;
      if (paramContext != null) {
        return paramContext.toString();
      }
      paramContext = String.valueOf(paramAttributeSet);
      i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString2, 28);
      paramAttributeSet = new StringBuilder(paramContext.length() + i);
      paramAttributeSet.append("Resource ");
      paramAttributeSet.append(paramString2);
      paramAttributeSet.append(" was not a string: ");
      paramAttributeSet.append(paramContext);
      paramAttributeSet.toString();
      return paramString1;
    }
    return paramString1;
  }
}
