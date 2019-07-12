package support.android.asm;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import b.b.a.K;

@K(18)
public class NavigationMenuPresenter
  implements x
{
  public final ViewOverlay q;
  
  public NavigationMenuPresenter(View paramView)
  {
    q = paramView.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    q.add(paramDrawable);
  }
  
  public void c(Drawable paramDrawable)
  {
    q.remove(paramDrawable);
  }
  
  public void clear()
  {
    q.clear();
  }
}
