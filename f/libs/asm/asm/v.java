package f.libs.asm.asm;

import f.c.a.a.X.b;
import java.util.Set;

public class v
  implements x
{
  public static final Set<X.b> flags = new AVTransportVariable.1();
  public final int a;
  
  public v(int paramInt)
  {
    a = paramInt;
  }
  
  public boolean a(Label paramLabel)
  {
    int i;
    if ((flags.contains(b)) && (e.a == null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (Math.abs(e.d.hashCode() % a) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    return (i != 0) && (j != 0);
  }
}
