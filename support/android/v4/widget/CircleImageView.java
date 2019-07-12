package support.android.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import support.android.v4.content.ContextCompat;
import support.android.v4.view.ViewCompat;

public class CircleImageView
  extends ImageView
{
  public static final int FILL_SHADOW_COLOR = 1023410176;
  public static final int KEY_SHADOW_COLOR = 503316480;
  public static final int SHADOW_ELEVATION = 4;
  public static final float SHADOW_RADIUS = 3.5F;
  public static final float X_OFFSET = 0.0F;
  public static final float Y_OFFSET = 1.75F;
  public Animation.AnimationListener mListener;
  public int mShadowRadius;
  
  public CircleImageView(Context paramContext, int paramInt)
  {
    super(paramContext);
    float f = getContextgetResourcesgetDisplayMetricsdensity;
    int i = (int)(1.75F * f);
    int j = (int)(0.0F * f);
    mShadowRadius = ((int)(3.5F * f));
    if (elevationSupported())
    {
      paramContext = new ShapeDrawable(new OvalShape());
      ViewCompat.setElevation(this, f * 4.0F);
    }
    else
    {
      paramContext = new ShapeDrawable(new OvalShadow(mShadowRadius));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(mShadowRadius, j, i, 503316480);
      i = mShadowRadius;
      setPadding(i, i, i, i);
    }
    paramContext.getPaint().setColor(paramInt);
    ViewCompat.setBackgroundDrawable(this, paramContext);
  }
  
  private boolean elevationSupported()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public void onAnimationEnd()
  {
    super.onAnimationEnd();
    Animation.AnimationListener localAnimationListener = mListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationEnd(getAnimation());
    }
  }
  
  public void onAnimationStart()
  {
    super.onAnimationStart();
    Animation.AnimationListener localAnimationListener = mListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(getAnimation());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!elevationSupported())
    {
      paramInt1 = getMeasuredWidth();
      paramInt2 = mShadowRadius;
      int i = getMeasuredHeight();
      setMeasuredDimension(paramInt2 * 2 + paramInt1, mShadowRadius * 2 + i);
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    mListener = paramAnimationListener;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable)) {
      ((ShapeDrawable)getBackground()).getPaint().setColor(paramInt);
    }
  }
  
  public void setBackgroundColorRes(int paramInt)
  {
    setBackgroundColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public class OvalShadow
    extends OvalShape
  {
    public RadialGradient mRadialGradient;
    public Paint mShadowPaint = new Paint();
    
    public OvalShadow(int paramInt)
    {
      mShadowRadius = paramInt;
      draw((int)rect().width());
    }
    
    private void draw(int paramInt)
    {
      float f1 = paramInt / 2;
      float f2 = mShadowRadius;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      mRadialGradient = new RadialGradient(f1, f1, f2, new int[] { 1023410176, 0 }, null, localTileMode);
      mShadowPaint.setShader(mRadialGradient);
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int j = getWidth();
      int i = getHeight();
      j /= 2;
      float f1 = j;
      float f2 = i / 2;
      paramCanvas.drawCircle(f1, f2, f1, mShadowPaint);
      paramCanvas.drawCircle(f1, f2, j - mShadowRadius, paramPaint);
    }
    
    public void onResize(float paramFloat1, float paramFloat2)
    {
      super.onResize(paramFloat1, paramFloat2);
      draw((int)paramFloat1);
    }
  }
}
