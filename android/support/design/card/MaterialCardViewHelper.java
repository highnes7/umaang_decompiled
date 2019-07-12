package android.support.design.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.R.styleable;
import android.support.v7.widget.CardView;
import android.widget.FrameLayout;
import b.b.a.N;

@N({b.b.a.N.a.b})
public class MaterialCardViewHelper
{
  public static final int DEFAULT_STROKE_VALUE = -1;
  public final MaterialCardView materialCardView;
  public int strokeColor;
  public int strokeWidth;
  
  public MaterialCardViewHelper(MaterialCardView paramMaterialCardView)
  {
    materialCardView = paramMaterialCardView;
  }
  
  private void adjustContentPadding()
  {
    int i = materialCardView.getContentPaddingLeft();
    int j = strokeWidth;
    int k = materialCardView.getContentPaddingTop();
    int m = strokeWidth;
    int n = materialCardView.getContentPaddingRight();
    int i1 = strokeWidth;
    int i2 = materialCardView.getContentPaddingBottom();
    int i3 = strokeWidth;
    materialCardView.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
  
  private Drawable createForegroundDrawable()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(materialCardView.getRadius());
    int i = strokeColor;
    if (i != -1) {
      localGradientDrawable.setStroke(strokeWidth, i);
    }
    return localGradientDrawable;
  }
  
  public int getStrokeColor()
  {
    return strokeColor;
  }
  
  public int getStrokeWidth()
  {
    return strokeWidth;
  }
  
  public void loadFromAttributes(TypedArray paramTypedArray)
  {
    strokeColor = paramTypedArray.getColor(R.styleable.MaterialCardView_strokeColor, -1);
    strokeWidth = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
    updateForeground();
    adjustContentPadding();
  }
  
  public void setStrokeColor(int paramInt)
  {
    strokeColor = paramInt;
    updateForeground();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    strokeWidth = paramInt;
    updateForeground();
    adjustContentPadding();
  }
  
  public void updateForeground()
  {
    materialCardView.setForeground(createForegroundDrawable());
  }
}
