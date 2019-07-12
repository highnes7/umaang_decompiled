package android.support.design.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.design.circularreveal.CircularRevealHelper;
import android.support.design.circularreveal.CircularRevealWidget;
import android.support.design.circularreveal.CircularRevealWidget.RevealInfo;
import android.support.v7.cardview.R.attr;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class CircularRevealCardView
  extends CardView
  implements CircularRevealWidget
{
  public final CircularRevealHelper helper = new CircularRevealHelper(this);
  
  public CircularRevealCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, R.attr.cardViewStyle);
  }
  
  public void actualDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public boolean actualIsOpaque()
  {
    return super.isOpaque();
  }
  
  public void buildCircularRevealCache()
  {
    helper.buildCircularRevealCache();
  }
  
  public void destroyCircularRevealCache()
  {
    helper.destroyCircularRevealCache();
  }
  
  public void draw(Canvas paramCanvas)
  {
    CircularRevealHelper localCircularRevealHelper = helper;
    if (localCircularRevealHelper != null)
    {
      localCircularRevealHelper.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public Drawable getCircularRevealOverlayDrawable()
  {
    return helper.getCircularRevealOverlayDrawable();
  }
  
  public int getCircularRevealScrimColor()
  {
    return helper.getCircularRevealScrimColor();
  }
  
  public CircularRevealWidget.RevealInfo getRevealInfo()
  {
    return helper.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    CircularRevealHelper localCircularRevealHelper = helper;
    if (localCircularRevealHelper != null) {
      return localCircularRevealHelper.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    helper.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(int paramInt)
  {
    helper.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    helper.setRevealInfo(paramRevealInfo);
  }
}
