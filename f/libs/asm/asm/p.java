package f.libs.asm.asm;

import java.util.List;
import l.a.a.a.a.c.a.b;
import l.a.a.a.a.c.a.c;
import l.a.a.a.a.c.a.d;
import l.a.a.a.a.c.a.g;
import l.a.a.a.a.c.a.h;

public class p
  implements l.a.a.a.a.d.p
{
  public static final int FORMAT_ISO_8859_7 = 8;
  public static final int TRANSITION_TIME = 1000;
  public static final double b = 0.1D;
  public static final int e = 5;
  public final Attribute a;
  public final XYPlotZoomPan d;
  
  public p(XYPlotZoomPan paramXYPlotZoomPan, Attribute paramAttribute)
  {
    d = paramXYPlotZoomPan;
    a = paramAttribute;
  }
  
  public static p a(XYPlotZoomPan paramXYPlotZoomPan)
  {
    return new p(paramXYPlotZoomPan, new Attribute(new g(0, new Log((h)new d(1000L, 8), 0.1D), (b)new c(5))));
  }
  
  public boolean a(List paramList)
  {
    long l = System.nanoTime();
    if (a.a(l))
    {
      if (d.a(paramList))
      {
        a.a();
        return true;
      }
      a.b(l);
    }
    return false;
  }
}
