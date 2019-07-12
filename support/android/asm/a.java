package support.android.asm;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

public final class a
  extends Property<Drawable, PointF>
{
  public Rect r = new Rect();
  
  public a(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public PointF a(Drawable paramDrawable)
  {
    paramDrawable.copyBounds(r);
    paramDrawable = r;
    return new PointF(left, top);
  }
  
  public void a(Drawable paramDrawable, PointF paramPointF)
  {
    paramDrawable.copyBounds(r);
    r.offsetTo(Math.round(x), Math.round(y));
    paramDrawable.setBounds(r);
  }
}
