package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import f.g.b.a.e.a.a.a.a.b;

@b
public final class Cache
{
  public Cache() {}
  
  public static String get(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 != null)
    {
      if (paramCharSequence2 != null)
      {
        int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
        int i = 0;
        while ((i < j) && (paramCharSequence1.charAt(i) == paramCharSequence2.charAt(i))) {
          i += 1;
        }
        int k = i - 1;
        if (!write(paramCharSequence1, k))
        {
          j = i;
          if (!write(paramCharSequence2, k)) {}
        }
        else
        {
          j = i - 1;
        }
        return paramCharSequence1.subSequence(0, j).toString();
      }
      throw new NullPointerException();
    }
    paramCharSequence1 = new NullPointerException();
    throw paramCharSequence1;
  }
  
  public static String get(String paramString, int paramInt, char paramChar)
  {
    if (paramString != null)
    {
      if (paramString.length() >= paramInt) {
        return paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramInt);
      localStringBuilder.append(paramString);
      int i = paramString.length();
      while (i < paramInt)
      {
        localStringBuilder.append(paramChar);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    paramString = new NullPointerException();
    throw paramString;
  }
  
  public static String getElement(String paramString)
  {
    if (isEmpty(paramString)) {
      return null;
    }
    return paramString;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String read(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString;
  }
  
  public static String read(String paramString, int paramInt, char paramChar)
  {
    if (paramString != null)
    {
      if (paramString.length() >= paramInt) {
        return paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramInt);
      int i = paramString.length();
      while (i < paramInt)
      {
        localStringBuilder.append(paramChar);
        i += 1;
      }
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    paramString = new NullPointerException();
    throw paramString;
  }
  
  public static String repeat(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramInt <= 1)
      {
        boolean bool;
        if (paramInt >= 0) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "invalid count: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == 0) {
          return "";
        }
      }
      else
      {
        int j = paramString.length();
        int i = j;
        long l = j * paramInt;
        paramInt = (int)l;
        if (paramInt == l)
        {
          char[] arrayOfChar = new char[paramInt];
          paramString.getChars(0, j, arrayOfChar, 0);
          for (;;)
          {
            j = paramInt - i;
            if (i >= j) {
              break;
            }
            System.arraycopy(arrayOfChar, 0, arrayOfChar, i, i);
            i <<= 1;
          }
          System.arraycopy(arrayOfChar, 0, arrayOfChar, i, j);
          return new String(arrayOfChar);
        }
        paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Required array size too large: ");
        paramString.append(String.valueOf(l));
        throw new ArrayIndexOutOfBoundsException(paramString.toString());
      }
    }
    else
    {
      paramString = new NullPointerException();
      throw paramString;
    }
    return paramString;
  }
  
  public static String write(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 != null)
    {
      if (paramCharSequence2 != null)
      {
        int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
        int i = 0;
        while ((i < j) && (paramCharSequence1.charAt(paramCharSequence1.length() - i - 1) == paramCharSequence2.charAt(paramCharSequence2.length() - i - 1))) {
          i += 1;
        }
        if (!write(paramCharSequence1, paramCharSequence1.length() - i - 1))
        {
          j = i;
          if (!write(paramCharSequence2, paramCharSequence2.length() - i - 1)) {}
        }
        else
        {
          j = i - 1;
        }
        return paramCharSequence1.subSequence(paramCharSequence1.length() - j, paramCharSequence1.length()).toString();
      }
      throw new NullPointerException();
    }
    paramCharSequence1 = new NullPointerException();
    throw paramCharSequence1;
  }
  
  public static boolean write(CharSequence paramCharSequence, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= paramCharSequence.length() - 2) && (Character.isHighSurrogate(paramCharSequence.charAt(paramInt))) && (Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)));
  }
}
