package internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import com.pnikosis.materialishprogress.ProgressWheel;

public class f
{
  public ProgressWheel a;
  public boolean b;
  public float c = 0.75F;
  public int e;
  public float i;
  public int k;
  public boolean l = true;
  public int m;
  public int n;
  public int r;
  
  public f(Context paramContext)
  {
    e = (paramContext.getResources().getDimensionPixelSize(R.dimen.common_circle_width) + 1);
    n = paramContext.getResources().getColor(R.color.success_stroke_color);
    m = 0;
    r = 0;
    b = false;
    i = -1.0F;
    k = paramContext.getResources().getDimensionPixelOffset(R.dimen.progress_circle_radius);
  }
  
  private void a()
  {
    ProgressWheel localProgressWheel = a;
    if (localProgressWheel != null)
    {
      if ((!l) && (localProgressWheel.a())) {
        a.d();
      } else if ((l) && (!a.a())) {
        a.c();
      }
      if (c != a.getSpinSpeed()) {
        a.setSpinSpeed(c);
      }
      if (e != a.getBarWidth()) {
        a.setBarWidth(e);
      }
      if (n != a.getBarColor()) {
        a.setBarColor(n);
      }
      if (m != a.getRimWidth()) {
        a.setRimWidth(m);
      }
      if (r != a.getRimColor()) {
        a.setRimColor(r);
      }
      if (i != a.getProgress()) {
        if (b) {
          a.setInstantProgress(i);
        } else {
          a.setProgress(i);
        }
      }
      if (k != a.getCircleRadius()) {
        a.setCircleRadius(k);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    c = paramFloat;
    a();
  }
  
  public void a(int paramInt)
  {
    n = paramInt;
    a();
  }
  
  public void a(ProgressWheel paramProgressWheel)
  {
    a = paramProgressWheel;
    a();
  }
  
  public void b()
  {
    l = true;
    a();
  }
  
  public void b(float paramFloat)
  {
    i = paramFloat;
    b = true;
    a();
  }
  
  public void b(int paramInt)
  {
    k = paramInt;
    a();
  }
  
  public float c()
  {
    return c;
  }
  
  public void c(int paramInt)
  {
    e = paramInt;
    a();
  }
  
  public void close()
  {
    ProgressWheel localProgressWheel = a;
    if (localProgressWheel != null) {
      localProgressWheel.b();
    }
  }
  
  public void d(int paramInt)
  {
    r = paramInt;
    a();
  }
  
  public boolean d()
  {
    return l;
  }
  
  public int e()
  {
    return e;
  }
  
  public void e(float paramFloat)
  {
    b = false;
    i = paramFloat;
    a();
  }
  
  public void f()
  {
    l = false;
    a();
  }
  
  public void f(int paramInt)
  {
    m = paramInt;
    a();
  }
  
  public float i()
  {
    return i;
  }
  
  public int k()
  {
    return k;
  }
  
  public int l()
  {
    return n;
  }
  
  public int m()
  {
    return m;
  }
  
  public ProgressWheel n()
  {
    return a;
  }
  
  public int r()
  {
    return r;
  }
}
