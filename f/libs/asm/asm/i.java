package f.libs.asm.asm;

import android.app.Activity;
import android.os.Bundle;
import l.a.a.a.h;

public class i
  extends h
{
  public final a b;
  public final f c;
  
  public i(f paramF, a paramA)
  {
    c = paramF;
    b = paramA;
  }
  
  public void a(Activity paramActivity)
  {
    c.a(paramActivity, TextOrientationType.q);
    b.close();
  }
  
  public void a(Activity paramActivity, Bundle paramBundle) {}
  
  public void b(Activity paramActivity)
  {
    c.a(paramActivity, TextOrientationType.g);
    b.a();
  }
  
  public void b(Activity paramActivity, Bundle paramBundle) {}
  
  public void clear(Activity paramActivity)
  {
    c.a(paramActivity, TextOrientationType.b);
  }
  
  public void d(Activity paramActivity)
  {
    c.a(paramActivity, TextOrientationType.d);
  }
  
  public void setVisible(Activity paramActivity) {}
}
