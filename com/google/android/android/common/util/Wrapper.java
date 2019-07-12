package com.google.android.android.common.util;

import android.database.CharArrayBuffer;
import android.text.TextUtils;

public final class Wrapper
{
  public static void append(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if (TextUtils.isEmpty(paramString))
    {
      sizeCopied = 0;
    }
    else
    {
      char[] arrayOfChar = data;
      if ((arrayOfChar != null) && (arrayOfChar.length >= paramString.length())) {
        paramString.getChars(0, paramString.length(), data, 0);
      } else {
        data = paramString.toCharArray();
      }
    }
    sizeCopied = paramString.length();
  }
}
