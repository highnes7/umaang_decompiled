package support.android.v4.asm;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;

public final class c
{
  public static volatile c a;
  public static final boolean b = Log.isLoggable("MediaSessionManager", 3);
  public static final Object d = new Object();
  public static final String l = "MediaSessionManager";
  public ea.a c;
  
  public c(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28)
    {
      c = new MethodWriter(paramContext);
      return;
    }
    if (i >= 21)
    {
      c = new ClassReader(paramContext);
      return;
    }
    c = new Label(paramContext);
  }
  
  public static c a(Context paramContext)
  {
    Object localObject1 = a;
    if (localObject1 == null)
    {
      Object localObject2 = d;
      try
      {
        c localC = a;
        localObject1 = localC;
        if (localC == null)
        {
          a = new c(paramContext.getApplicationContext());
          localObject1 = a;
        }
        return localObject1;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return localObject1;
  }
  
  public Context b()
  {
    return c.getContext();
  }
  
  public boolean b(ea.b paramB)
  {
    if (paramB != null) {
      return c.a(d);
    }
    throw new IllegalArgumentException("userInfo should not be null");
  }
}
