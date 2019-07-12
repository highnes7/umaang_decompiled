package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.b.a.N;
import support.android.v4.view.OnApplyWindowInsetsListener;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.WindowInsetsCompat;

@N({b.b.a.N.a.b})
public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  public Drawable insetForeground;
  public Rect insets;
  public Rect tempRect = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    insetForeground = paramContext.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    ViewCompat.setBackground(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if (insets == null) {
          insets = new Rect();
        }
        insets.set(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
        onInsetsChanged(paramAnonymousWindowInsetsCompat);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        boolean bool;
        if ((paramAnonymousWindowInsetsCompat.get()) && (insetForeground != null)) {
          bool = false;
        } else {
          bool = true;
        }
        paramAnonymousView.setWillNotDraw(bool);
        ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
        return paramAnonymousWindowInsetsCompat.consumeSystemWindowInsets();
      }
    });
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((insets != null) && (insetForeground != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      tempRect.set(0, 0, i, insets.top);
      insetForeground.setBounds(tempRect);
      insetForeground.draw(paramCanvas);
      tempRect.set(0, j - insets.bottom, i, j);
      insetForeground.setBounds(tempRect);
      insetForeground.draw(paramCanvas);
      Rect localRect1 = tempRect;
      Rect localRect2 = insets;
      localRect1.set(0, top, left, j - bottom);
      insetForeground.setBounds(tempRect);
      insetForeground.draw(paramCanvas);
      localRect1 = tempRect;
      localRect2 = insets;
      localRect1.set(i - right, top, i, j - bottom);
      insetForeground.setBounds(tempRect);
      insetForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable = insetForeground;
    if (localDrawable != null) {
      localDrawable.setCallback(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Drawable localDrawable = insetForeground;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
  }
  
  public void onInsetsChanged(WindowInsetsCompat paramWindowInsetsCompat) {}
}
