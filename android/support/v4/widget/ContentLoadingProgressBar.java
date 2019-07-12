package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import support.android.v4.widget.EventInfoFragment.1;
import support.android.v4.widget.MonthByWeekFragment.2;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  public static final int MIN_DELAY = 500;
  public static final int MIN_SHOW_TIME = 500;
  public final Runnable mDelayedHide = new EventInfoFragment.1(this);
  public final Runnable mDelayedShow = new MonthByWeekFragment.2(this);
  public boolean mDismissed = false;
  public boolean mPostedHide = false;
  public boolean mPostedShow = false;
  public long mStartTime = -1L;
  
  public ContentLoadingProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void removeCallbacks()
  {
    removeCallbacks(mDelayedHide);
    removeCallbacks(mDelayedShow);
  }
  
  public void hide()
  {
    try
    {
      mDismissed = true;
      removeCallbacks(mDelayedShow);
      mPostedShow = false;
      long l = System.currentTimeMillis() - mStartTime;
      if ((l < 500L) && (mStartTime != -1L))
      {
        if (!mPostedHide)
        {
          postDelayed(mDelayedHide, 500L - l);
          mPostedHide = true;
        }
      }
      else {
        setVisibility(8);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks();
  }
  
  public void show()
  {
    try
    {
      mStartTime = -1L;
      mDismissed = false;
      removeCallbacks(mDelayedHide);
      mPostedHide = false;
      if (!mPostedShow)
      {
        postDelayed(mDelayedShow, 500L);
        mPostedShow = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
