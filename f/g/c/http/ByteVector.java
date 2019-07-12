package f.g.c.http;

import f.g.c.package_10.Preconditions;
import f.g.c.package_10.h;

public final class ByteVector
{
  public final String a;
  public int p = 0;
  
  public ByteVector(String paramString)
  {
    a = paramString;
  }
  
  public char add(char paramChar)
  {
    Preconditions.checkState(add());
    boolean bool;
    if (get() == paramChar) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    p += 1;
    return paramChar;
  }
  
  public String add(h paramH)
  {
    Preconditions.checkState(add());
    int i = p;
    p = paramH.negate().a(a, i);
    if (add()) {
      return a.substring(i, p);
    }
    return a.substring(i);
  }
  
  public boolean add()
  {
    int i = p;
    return (i >= 0) && (i < a.length());
  }
  
  public char get()
  {
    Preconditions.checkState(add());
    return a.charAt(p);
  }
  
  public String get(h paramH)
  {
    int i = p;
    paramH = add(paramH);
    boolean bool;
    if (p != i) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    return paramH;
  }
  
  public char read(h paramH)
  {
    Preconditions.checkState(add());
    char c = get();
    Preconditions.checkState(paramH.a(c));
    p += 1;
    return c;
  }
}
