package support.android.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;

public final class EdgeEffectCompat
{
  public EdgeEffect IMPL;
  
  public EdgeEffectCompat(Context paramContext)
  {
    IMPL = new EdgeEffect(paramContext);
  }
  
  public static void draw(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return;
    }
    paramEdgeEffect.onPull(paramFloat1);
  }
  
  public void draw()
  {
    IMPL.finish();
  }
  
  public boolean draw(float paramFloat1, float paramFloat2)
  {
    draw(IMPL, paramFloat1, paramFloat2);
    return true;
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    return IMPL.draw(paramCanvas);
  }
  
  public boolean isFinished()
  {
    return IMPL.isFinished();
  }
  
  public boolean onAbsorb(int paramInt)
  {
    IMPL.onAbsorb(paramInt);
    return true;
  }
  
  public boolean onPull(float paramFloat)
  {
    IMPL.onPull(paramFloat);
    return true;
  }
  
  public boolean onRelease()
  {
    IMPL.onRelease();
    return IMPL.isFinished();
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    IMPL.setSize(paramInt1, paramInt2);
  }
}
