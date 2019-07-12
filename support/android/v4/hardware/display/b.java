package support.android.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.view.Display;
import b.b.x.e.a.a;
import java.util.WeakHashMap;

public final class b
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  public static final WeakHashMap<Context, a> m = new WeakHashMap();
  public final Context a;
  
  public b(Context paramContext)
  {
    a = paramContext;
  }
  
  public static b a(Context paramContext)
  {
    WeakHashMap localWeakHashMap = m;
    try
    {
      b localB2 = (b)m.get(paramContext);
      b localB1 = localB2;
      if (localB2 == null)
      {
        localB1 = new b(paramContext);
        m.put(paramContext, localB1);
      }
      return localB1;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public Display a(int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    return ((DisplayManager)a.getSystemService("display")).getDisplay(paramInt);
  }
  
  public Display[] a()
  {
    int i = Build.VERSION.SDK_INT;
    return ((DisplayManager)a.getSystemService("display")).getDisplays();
  }
  
  public Display[] a(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    return ((DisplayManager)a.getSystemService("display")).getDisplays(paramString);
  }
}
