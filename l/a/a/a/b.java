package l.a.a.a;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;

public class b
{
  public final Application h;
  public b.a i;
  
  public b(Context paramContext)
  {
    h = ((Application)paramContext.getApplicationContext());
    int j = Build.VERSION.SDK_INT;
    i = new b.a(h);
  }
  
  public void a()
  {
    b.a localA = i;
    if (localA != null) {
      b.a.a(localA);
    }
  }
  
  public boolean a(h paramH)
  {
    b.a localA = i;
    return (localA != null) && (b.a.a(localA, paramH));
  }
}
