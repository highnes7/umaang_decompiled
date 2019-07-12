package support.android.asm;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Label
{
  public Runnable a;
  public Runnable b;
  public Context c;
  public int f = -1;
  public ViewGroup g;
  public View h;
  
  public Label(ViewGroup paramViewGroup)
  {
    g = paramViewGroup;
  }
  
  public Label(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    c = paramContext;
    g = paramViewGroup;
    f = paramInt;
  }
  
  public Label(ViewGroup paramViewGroup, View paramView)
  {
    g = paramViewGroup;
    h = paramView;
  }
  
  public static Label a(View paramView)
  {
    return (Label)paramView.getTag(R.id.transition_current_scene);
  }
  
  public static Label a(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    Object localObject2 = (SparseArray)paramViewGroup.getTag(R.id.transition_scene_layoutid_cache);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SparseArray();
      paramViewGroup.setTag(R.id.transition_scene_layoutid_cache, localObject1);
    }
    localObject2 = (Label)((SparseArray)localObject1).get(paramInt);
    if (localObject2 != null) {
      return localObject2;
    }
    paramViewGroup = new Label(paramViewGroup, paramInt, paramContext);
    ((SparseArray)localObject1).put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public static void a(View paramView, Label paramLabel)
  {
    paramView.setTag(R.id.transition_current_scene, paramLabel);
  }
  
  public void a()
  {
    if ((f > 0) || (h != null))
    {
      getText().removeAllViews();
      if (f > 0) {
        LayoutInflater.from(c).inflate(f, g);
      } else {
        g.addView(h);
      }
    }
    Runnable localRunnable = a;
    if (localRunnable != null) {
      localRunnable.run();
    }
    g.setTag(R.id.transition_current_scene, this);
  }
  
  public void a(Runnable paramRunnable)
  {
    a = paramRunnable;
  }
  
  public void b()
  {
    if (a(g) == this)
    {
      Runnable localRunnable = b;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
  
  public boolean c()
  {
    return f > 0;
  }
  
  public void e(Runnable paramRunnable)
  {
    b = paramRunnable;
  }
  
  public ViewGroup getText()
  {
    return g;
  }
}
