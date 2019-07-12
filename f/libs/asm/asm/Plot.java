package f.libs.asm.asm;

import android.content.Context;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import l.a.a.a.a.b.G;
import l.a.a.a.a.d.l;
import l.a.a.a.a.d.q;
import l.a.a.a.a.f.a;

public class Plot
{
  public static final String e = "session_analytics_to_send";
  public static final String g = "session_analytics.tap";
  public final a j;
  public final Context l;
  
  public Plot(Context paramContext, a paramA)
  {
    l = paramContext;
    j = paramA;
  }
  
  public o a()
    throws IOException
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      h localH = new h();
      G localG = new G();
      Object localObject = j.a();
      localObject = new q(l, (File)localObject, "session_analytics.tap", "session_analytics_to_send");
      return new o(l, localH, localG, (l)localObject);
    }
    throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
  }
}
