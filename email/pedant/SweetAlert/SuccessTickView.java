package email.pedant.SweetAlert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import internal.view.menu.FloatingActionButtonEclairMr1.BaseShadowAnimation;
import internal.view.menu.R.color;

public class SuccessTickView
  extends View
{
  public float a;
  public final float b = create(15.0F);
  public boolean c;
  public float d;
  public float density = -1.0F;
  public Paint e;
  public final float f = create(25.0F);
  public final float g = create(1.2F);
  public final float i = create(3.0F);
  public float j;
  public final float k = create(3.3F);
  public final float l;
  
  public SuccessTickView(Context paramContext)
  {
    super(paramContext);
    float f1 = f;
    l = (create(6.7F) + f1);
    a();
  }
  
  public SuccessTickView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    float f1 = f;
    l = (create(6.7F) + f1);
    a();
  }
  
  private void a()
  {
    e = new Paint();
    e.setColor(getResources().getColor(R.color.success_stroke_color));
    a = b;
    j = f;
    c = false;
  }
  
  public float create(float paramFloat)
  {
    if (density == -1.0F) {
      density = getResourcesgetDisplayMetricsdensity;
    }
    return paramFloat * density + 0.5F;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int n = getWidth();
    int m = getHeight();
    paramCanvas.rotate(45.0F, n / 2, m / 2);
    double d1 = n;
    Double.isNaN(d1);
    n = (int)(d1 / 1.2D);
    d1 = m;
    Double.isNaN(d1);
    m = (int)(d1 / 1.4D);
    float f1 = n;
    d = ((b + f1) / 2.0F + i - 1.0F);
    RectF localRectF = new RectF();
    if (c)
    {
      left = 0.0F;
      right = (left + a);
      top = ((m + f) / 2.0F);
      bottom = (top + i);
    }
    else
    {
      f2 = (b + f1) / 2.0F;
      f3 = i;
      right = (f2 + f3 - 1.0F);
      left = (right - a);
      top = ((m + f) / 2.0F);
      bottom = (top + f3);
    }
    float f2 = g;
    paramCanvas.drawRoundRect(localRectF, f2, f2, e);
    localRectF = new RectF();
    f2 = (m + f) / 2.0F;
    float f3 = i;
    bottom = (f2 + f3 - 1.0F);
    left = ((f1 + b) / 2.0F);
    right = (left + f3);
    top = (bottom - j);
    f1 = g;
    paramCanvas.drawRoundRect(localRectF, f1, f1, e);
  }
  
  public void reset()
  {
    a = 0.0F;
    j = 0.0F;
    invalidate();
    FloatingActionButtonEclairMr1.BaseShadowAnimation localBaseShadowAnimation = new FloatingActionButtonEclairMr1.BaseShadowAnimation(this);
    localBaseShadowAnimation.setDuration(750L);
    localBaseShadowAnimation.setStartOffset(100L);
    startAnimation(localBaseShadowAnimation);
  }
}
