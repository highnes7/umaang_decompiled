package f.libs.asm.asm;

import f.c.a.a.d;
import java.util.Map;
import l.a.a.a.f;

public abstract class Buffer<T extends d>
{
  public static final int DIGITS = 20;
  public static final int N_100 = 100;
  public final c c = new c(v);
  public final ByteVector v = new ByteVector(20, 100, f.d());
  
  public Buffer() {}
  
  public Map getTitle()
  {
    return c.c;
  }
  
  public Buffer write(String paramString, Number paramNumber)
  {
    c.add(paramString, paramNumber);
    return this;
  }
  
  public Buffer write(String paramString1, String paramString2)
  {
    c.add(paramString1, paramString2);
    return this;
  }
}
