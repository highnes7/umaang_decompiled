package support.android.asm;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewOverlay;
import b.b.a.K;

@K(18)
public class o
  implements g
{
  public final ViewGroupOverlay c;
  
  public o(ViewGroup paramViewGroup)
  {
    c = paramViewGroup.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    c.add(paramDrawable);
  }
  
  public void b(View paramView)
  {
    c.add(paramView);
  }
  
  public void c(Drawable paramDrawable)
  {
    c.remove(paramDrawable);
  }
  
  public void c(View paramView)
  {
    c.remove(paramView);
  }
  
  public void clear()
  {
    c.clear();
  }
}
