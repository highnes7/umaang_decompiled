package f.fasterxml.jackson.core.impl;

public final class NumberInput
{
  public static final long L_BILLION = 1000000000L;
  public static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
  public static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
  public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
  
  public NumberInput() {}
  
  public static boolean inLongRange(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = MIN_LONG_STR_NO_SIGN;
    } else {
      str = MAX_LONG_STR;
    }
    int j = str.length();
    int i = paramString.length();
    if (i < j) {
      return true;
    }
    if (i > j) {
      return false;
    }
    i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i) - str.charAt(i);
      if (k != 0) {
        return k < 0;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean inLongRange(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = MIN_LONG_STR_NO_SIGN;
    } else {
      str = MAX_LONG_STR;
    }
    int i = str.length();
    if (paramInt2 < i) {
      return true;
    }
    if (paramInt2 > i) {
      return false;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      int j = paramArrayOfChar[(paramInt1 + paramInt2)] - str.charAt(paramInt2);
      if (j != 0) {
        return j < 0;
      }
      paramInt2 += 1;
    }
    return true;
  }
  
  public static double parseAsDouble(String paramString, double paramDouble)
  {
    if (paramString == null) {
      return paramDouble;
    }
    paramString = paramString.trim();
    if (paramString.length() == 0) {
      return paramDouble;
    }
    try
    {
      double d = parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public static int parseAsInt(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    String str2 = paramString.trim();
    paramString = str2;
    int n = str2.length();
    int k = n;
    if (n == 0) {
      return paramInt;
    }
    int m = 0;
    int j = k;
    int i = m;
    String str1 = paramString;
    if (n > 0)
    {
      n = str2.charAt(0);
      if (n == 43)
      {
        paramString = str2.substring(1);
        str1 = paramString;
        j = paramString.length();
        i = m;
      }
      else
      {
        j = k;
        i = m;
        str1 = paramString;
        if (n == 45)
        {
          i = 1;
          str1 = paramString;
          j = k;
        }
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label169;
      }
      k = str1.charAt(i);
      if ((k > 57) || (k < 48)) {
        break;
      }
      i += 1;
    }
    try
    {
      double d = parseDouble(str1);
      return (int)d;
    }
    catch (NumberFormatException paramString)
    {
      try
      {
        label169:
        i = Integer.parseInt(str1);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
    return paramInt;
  }
  
  public static long parseAsLong(String paramString, long paramLong)
  {
    if (paramString == null) {
      return paramLong;
    }
    String str2 = paramString.trim();
    paramString = str2;
    int n = str2.length();
    int k = n;
    if (n == 0) {
      return paramLong;
    }
    int m = 0;
    int j = k;
    int i = m;
    String str1 = paramString;
    if (n > 0)
    {
      n = str2.charAt(0);
      if (n == 43)
      {
        paramString = str2.substring(1);
        str1 = paramString;
        j = paramString.length();
        i = m;
      }
      else
      {
        j = k;
        i = m;
        str1 = paramString;
        if (n == 45)
        {
          i = 1;
          str1 = paramString;
          j = k;
        }
      }
    }
    for (;;)
    {
      if (i >= j) {
        break label169;
      }
      k = str1.charAt(i);
      if ((k > 57) || (k < 48)) {
        break;
      }
      i += 1;
    }
    try
    {
      double d = parseDouble(str1);
      return d;
    }
    catch (NumberFormatException paramString)
    {
      try
      {
        label169:
        long l = Long.parseLong(str1);
        return l;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramLong;
    }
    return paramLong;
  }
  
  public static double parseDouble(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return Double.MIN_VALUE;
    }
    return Double.parseDouble(paramString);
  }
  
  public static int parseInt(String paramString)
  {
    int j = 0;
    int m = paramString.charAt(0);
    int i = m;
    int n = paramString.length();
    int k = 1;
    if (m == 45) {
      j = 1;
    }
    if (j != 0)
    {
      if ((n != 1) && (n <= 10))
      {
        i = paramString.charAt(1);
        k = 2;
      }
      else
      {
        return Integer.parseInt(paramString);
      }
    }
    else if (n > 9) {
      return Integer.parseInt(paramString);
    }
    if ((i <= 57) && (i >= 48))
    {
      m = i - 48;
      i = m;
      if (k < n)
      {
        int i1 = k + 1;
        i = paramString.charAt(k);
        if ((i <= 57) && (i >= 48))
        {
          k = m * 10 + (i - 48);
          i = k;
          if (i1 < n)
          {
            m = i1 + 1;
            i = paramString.charAt(i1);
            if ((i <= 57) && (i >= 48))
            {
              k = k * 10 + (i - 48);
              i = k;
              if (m < n)
              {
                i = k;
                for (;;)
                {
                  k = m + 1;
                  m = paramString.charAt(m);
                  if ((m > 57) || (m < 48)) {
                    break;
                  }
                  i = i * 10 + (m - 48);
                  if (k >= n) {
                    break label273;
                  }
                  m = k;
                }
                return Integer.parseInt(paramString);
              }
            }
            else
            {
              return Integer.parseInt(paramString);
            }
          }
        }
        else
        {
          return Integer.parseInt(paramString);
        }
      }
      label273:
      if (j != 0) {
        return -i;
      }
    }
    else
    {
      return Integer.parseInt(paramString);
    }
    return i;
  }
  
  public static int parseInt(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1] - '0';
    int j = paramInt2 + paramInt1;
    int k = paramInt1 + 1;
    paramInt1 = i;
    if (k < j)
    {
      paramInt2 = i * 10 + (paramArrayOfChar[k] - '0');
      i = k + 1;
      paramInt1 = paramInt2;
      if (i < j)
      {
        paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
        i += 1;
        paramInt1 = paramInt2;
        if (i < j)
        {
          paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
          i += 1;
          paramInt1 = paramInt2;
          if (i < j)
          {
            paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
            i += 1;
            paramInt1 = paramInt2;
            if (i < j)
            {
              paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
              i += 1;
              paramInt1 = paramInt2;
              if (i < j)
              {
                paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                i += 1;
                paramInt1 = paramInt2;
                if (i < j)
                {
                  paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  i += 1;
                  paramInt1 = paramInt2;
                  if (i < j) {
                    return paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  }
                }
              }
            }
          }
        }
      }
    }
    return paramInt1;
  }
  
  public static long parseLong(String paramString)
  {
    if (paramString.length() <= 9) {
      return parseInt(paramString);
    }
    return Long.parseLong(paramString);
  }
  
  public static long parseLong(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt2 -= 9;
    return parseInt(paramArrayOfChar, paramInt1, paramInt2) * 1000000000L + parseInt(paramArrayOfChar, paramInt1 + paramInt2, 9);
  }
}
