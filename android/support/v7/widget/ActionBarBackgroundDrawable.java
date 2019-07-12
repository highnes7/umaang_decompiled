package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

public class ActionBarBackgroundDrawable
  extends Drawable
{
  public final ActionBarContainer mContainer;
  
  public ActionBarBackgroundDrawable(ActionBarContainer paramActionBarContainer)
  {
    mContainer = paramActionBarContainer;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = mContainer;
    if (mIsSplit)
    {
      localObject = mSplitBackground;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
    }
    else
    {
      localObject = mBackground;
      if (localObject != null) {
        ((Drawable)localObject).draw(paramCanvas);
      }
      localObject = mContainer;
      Drawable localDrawable = mStackedBackground;
      if ((localDrawable != null) && (mIsStacked)) {
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Object localObject = mContainer;
    if (mIsSplit)
    {
      localObject = mSplitBackground;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
    else
    {
      localObject = mBackground;
      if (localObject != null) {
        ((Drawable)localObject).getOutline(paramOutline);
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}
