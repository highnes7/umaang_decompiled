package f.libs.asm.asm;

import android.content.Context;
import f.c.a.a.X;
import java.io.IOException;
import java.util.UUID;
import l.a.a.a.a.b.n;
import l.a.a.a.a.d.e;
import l.a.a.a.a.d.l;
import l.a.a.a.a.g.b;

public class o
  extends e<X>
{
  public static final String TAG = "sa";
  public static final String b = ".tap";
  public b c;
  
  public o(Context paramContext, h paramH, n paramN, l paramL)
    throws IOException
  {
    super(paramContext, paramH, paramN, paramL, 100);
  }
  
  public void a(b paramB)
  {
    c = paramB;
  }
  
  public int c()
  {
    b localB = c;
    if (localB == null) {
      return 8000;
    }
    return a;
  }
  
  public int i()
  {
    b localB = c;
    if (localB == null) {
      return i;
    }
    return k;
  }
  
  public String serialize()
  {
    UUID localUUID = UUID.randomUUID();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("sa", "_");
    localStringBuilder.append(localUUID.toString());
    localStringBuilder.append("_");
    localStringBuilder.append(g.a());
    localStringBuilder.append(".tap");
    return localStringBuilder.toString();
  }
}
