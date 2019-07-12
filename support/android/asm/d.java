package support.android.asm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public class d
  implements x
{
  public sa.a b;
  
  public d() {}
  
  public d(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    b = new sa.a(paramContext, paramViewGroup, paramView, this);
  }
  
  public static d a(View paramView)
  {
    ViewGroup localViewGroup = findSuitableParent(paramView);
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView instanceof sa.a)) {
          return e;
        }
        i += 1;
      }
      return new c(localViewGroup.getContext(), localViewGroup, paramView);
    }
    return null;
  }
  
  public static ViewGroup findSuitableParent(View paramView)
  {
    while (paramView != null)
    {
      if ((paramView.getId() == 16908290) && ((paramView instanceof ViewGroup))) {
        return (ViewGroup)paramView;
      }
      if ((paramView.getParent() instanceof ViewGroup)) {
        paramView = (ViewGroup)paramView.getParent();
      }
    }
    return null;
  }
  
  public void a(Drawable paramDrawable)
  {
    b.a(paramDrawable);
  }
  
  public ViewGroup b()
  {
    return b;
  }
  
  public void c(Drawable paramDrawable)
  {
    b.remove(paramDrawable);
  }
  
  public boolean c()
  {
    return b.a();
  }
  
  public void clear()
  {
    b.clear();
  }
}
