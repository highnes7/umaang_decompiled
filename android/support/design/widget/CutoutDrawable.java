package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;

public class CutoutDrawable
  extends GradientDrawable
{
  public final RectF cutoutBounds;
  public final Paint cutoutPaint = new Paint(1);
  public int savedLayer;
  
  public CutoutDrawable()
  {
    setPaintStyles();
    cutoutBounds = new RectF();
  }
  
  private void postDraw(Canvas paramCanvas)
  {
    if (!(getCallback() instanceof View)) {
      paramCanvas.restoreToCount(savedLayer);
    }
  }
  
  private void preDraw(Canvas paramCanvas)
  {
    Drawable.Callback localCallback = getCallback();
    if ((localCallback instanceof View))
    {
      ((View)localCallback).setLayerType(2, null);
      return;
    }
    saveCanvasLayer(paramCanvas);
  }
  
  private void saveCanvasLayer(Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      savedLayer = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      return;
    }
    savedLayer = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
  }
  
  private void setPaintStyles()
  {
    cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    cutoutPaint.setColor(-1);
    cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private boolean useHardwareLayer(Drawable.Callback paramCallback)
  {
    return paramCallback instanceof View;
  }
  
  public void draw(Canvas paramCanvas)
  {
    preDraw(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(cutoutBounds, cutoutPaint);
    if (!(getCallback() instanceof View)) {
      paramCanvas.restoreToCount(savedLayer);
    }
  }
  
  public boolean hasCutout()
  {
    return cutoutBounds.isEmpty() ^ true;
  }
  
  public void removeCutout()
  {
    setCutout(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void setCutout(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    RectF localRectF = cutoutBounds;
    if ((paramFloat1 != left) || (paramFloat2 != top) || (paramFloat3 != right) || (paramFloat4 != bottom))
    {
      cutoutBounds.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  public void setCutout(RectF paramRectF)
  {
    setCutout(left, top, right, bottom);
  }
}
