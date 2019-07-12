package android.support.design.widget;

import android.view.View;
import support.android.v4.view.ViewCompat;

public class ViewOffsetHelper
{
  public int layoutLeft;
  public int layoutTop;
  public int offsetLeft;
  public int offsetTop;
  public final View view;
  
  public ViewOffsetHelper(View paramView)
  {
    view = paramView;
  }
  
  private void updateOffsets()
  {
    View localView = view;
    ViewCompat.offsetTopAndBottom(localView, offsetTop - (localView.getTop() - layoutTop));
    localView = view;
    ViewCompat.offsetLeftAndRight(localView, offsetLeft - (localView.getLeft() - layoutLeft));
  }
  
  public int getLayoutLeft()
  {
    return layoutLeft;
  }
  
  public int getLayoutTop()
  {
    return layoutTop;
  }
  
  public int getLeftAndRightOffset()
  {
    return offsetLeft;
  }
  
  public int getTopAndBottomOffset()
  {
    return offsetTop;
  }
  
  public void onViewLayout()
  {
    layoutTop = view.getTop();
    layoutLeft = view.getLeft();
    updateOffsets();
  }
  
  public boolean setLeftAndRightOffset(int paramInt)
  {
    if (offsetLeft != paramInt)
    {
      offsetLeft = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
  
  public boolean setTopAndBottomOffset(int paramInt)
  {
    if (offsetTop != paramInt)
    {
      offsetTop = paramInt;
      updateOffsets();
      return true;
    }
    return false;
  }
}
