package f.g.c.package_10;

public final class MethodWriter
  extends h
{
  public MethodWriter(String paramString)
  {
    super(paramString);
  }
  
  public int a(CharSequence paramCharSequence, int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, paramCharSequence.length(), "index");
    return -1;
  }
  
  public h a()
  {
    return this;
  }
  
  public String a(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
  
  public String a(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString();
  }
  
  public String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 != null) {
      return paramCharSequence1.toString();
    }
    throw new NullPointerException();
  }
  
  public void a(g paramG) {}
  
  public boolean a(char paramChar)
  {
    return false;
  }
  
  public h and(h paramH)
  {
    if (paramH != null) {
      return this;
    }
    throw new NullPointerException();
  }
  
  public int b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return -1;
    }
    throw new NullPointerException();
  }
  
  public String c(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
  
  public int d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return -1;
    }
    throw new NullPointerException();
  }
  
  public boolean get(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return true;
    }
    throw new NullPointerException();
  }
  
  public h negate()
  {
    return h.ANY;
  }
  
  public h or(h paramH)
  {
    if (paramH != null) {
      return paramH;
    }
    throw new NullPointerException();
  }
  
  public boolean put(CharSequence paramCharSequence)
  {
    return paramCharSequence.length() == 0;
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString();
  }
  
  public int write(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      return 0;
    }
    throw new NullPointerException();
  }
}
