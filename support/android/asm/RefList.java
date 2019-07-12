package support.android.asm;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

public final class RefList
  extends Property<View, PointF>
{
  public RefList(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public void a(View paramView, PointF paramPointF)
  {
    int i = Math.round(x);
    int j = Math.round(y);
    Frame.set(paramView, i, j, paramView.getWidth() + i, paramView.getHeight() + j);
  }
  
  public PointF put(View paramView)
  {
    return null;
  }
}
