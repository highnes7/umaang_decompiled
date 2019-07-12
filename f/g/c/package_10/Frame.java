package f.g.c.package_10;

import java.util.Arrays;

public final class Frame
  extends h
{
  public Frame(String paramString)
  {
    super(paramString);
  }
  
  public int a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, i, "index");
    if (paramInt == i) {
      return -1;
    }
    return paramInt;
  }
  
  public h a()
  {
    return this;
  }
  
  public String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return "";
    }
    throw new NullPointerException();
  }
  
  public String a(CharSequence paramCharSequence, char paramChar)
  {
    if (paramCharSequence.length() == 0) {
      return "";
    }
    return String.valueOf(paramChar);
  }
  
  public String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = paramCharSequence1.length();
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence2.length() * i);
    i = 0;
    while (i < paramCharSequence1.length())
    {
      localStringBuilder.append(paramCharSequence2);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean a(char paramChar)
  {
    return true;
  }
  
  public h and(h paramH)
  {
    if (paramH != null) {
      return paramH;
    }
    throw new NullPointerException();
  }
  
  public int b(CharSequence paramCharSequence)
  {
    return paramCharSequence.length() - 1;
  }
  
  public String c(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return "";
    }
    throw new NullPointerException();
  }
  
  public int d(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() == 0) {
      return -1;
    }
    return 0;
  }
  
  public boolean get(CharSequence paramCharSequence)
  {
    return paramCharSequence.length() == 0;
  }
  
  public h negate()
  {
    return h.NONE;
  }
  
  public h or(h paramH)
  {
    if (paramH != null) {
      return this;
    }
    throw new NullPointerException();
  }
  
  public boolean put(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return true;
    }
    throw new NullPointerException();
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = new char[paramCharSequence.length()];
    Arrays.fill(paramCharSequence, paramChar);
    return new String(paramCharSequence);
  }
  
  public int write(CharSequence paramCharSequence)
  {
    return paramCharSequence.length();
  }
}
