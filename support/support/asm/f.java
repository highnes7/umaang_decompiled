package support.support.asm;

import b.a.b.h.b;

public enum f
{
  static
  {
    b = new f("INITIALIZED", 1);
    d = new f("CREATED", 2);
    g = new f("STARTED", 3);
    y = new f("RESUMED", 4);
  }
  
  public boolean a(f paramF)
  {
    return compareTo(paramF) >= 0;
  }
}
