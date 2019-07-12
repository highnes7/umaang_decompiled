package support.android.classic.net;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import support.android.v4.view.MotionEventCompat;

public class Splitter
{
  public final View libraryBottomContainer;
  public final View.OnTouchListener libraryBottomDivider = new DownloadActivity.1(this);
  public final View.OnLongClickListener libraryDescription = new TextCandidatesViewManager.3(this);
  public final Attributes properties;
  public boolean value;
  public int x;
  public int y;
  
  public Splitter(View paramView, Attributes paramAttributes)
  {
    libraryBottomContainer = paramView;
    properties = paramAttributes;
  }
  
  public void bindView()
  {
    libraryBottomContainer.setOnLongClickListener(null);
    libraryBottomContainer.setOnTouchListener(null);
  }
  
  public void onBindViewHolder()
  {
    libraryBottomContainer.setOnLongClickListener(libraryDescription);
    libraryBottomContainer.setOnTouchListener(libraryBottomDivider);
  }
  
  public void process(Point paramPoint)
  {
    paramPoint.set(x, y);
  }
  
  public boolean process(View paramView)
  {
    return properties.get(paramView, this);
  }
  
  public boolean process(View paramView, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            return false;
          }
        }
        else
        {
          if (!MotionEventCompat.process(paramMotionEvent, 8194)) {
            break label142;
          }
          if ((paramMotionEvent.getButtonState() & 0x1) == 0) {
            return false;
          }
          if (value) {
            return false;
          }
          if ((x == i) && (y == j)) {
            return false;
          }
          x = i;
          y = j;
          value = properties.get(paramView, this);
          return value;
        }
      }
      value = false;
      return false;
    }
    else
    {
      x = i;
      y = j;
    }
    label142:
    return false;
  }
}
