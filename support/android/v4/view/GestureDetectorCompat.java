package support.android.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat
{
  public final GestureDetectorCompatImpl mImpl;
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    int i = Build.VERSION.SDK_INT;
    mImpl = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener, null);
  }
  
  public GestureDetectorCompat(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    int i = Build.VERSION.SDK_INT;
    mImpl = new GestureDetectorCompatImplJellybeanMr2(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean isLongpressEnabled()
  {
    return mImpl.isLongpressEnabled();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return mImpl.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    mImpl.setIsLongpressEnabled(paramBoolean);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    mImpl.setOnDoubleTapListener(paramOnDoubleTapListener);
  }
  
  public abstract interface GestureDetectorCompatImpl
  {
    public abstract boolean isLongpressEnabled();
    
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract void setIsLongpressEnabled(boolean paramBoolean);
    
    public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
  }
  
  public class GestureDetectorCompatImplBase
    implements GestureDetectorCompat.GestureDetectorCompatImpl
  {
    public static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    public static final int HINT_CONTEXT_CAR_HOME = 2;
    public static final int LONGPRESS_TIMEOUT = ;
    public static final int LONG_PRESS = 1;
    public static final int TAP = 3;
    public static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    public boolean mAlwaysInBiggerTapRegion;
    public boolean mAlwaysInTapRegion;
    public MotionEvent mCurrentDownEvent;
    public boolean mDeferConfirmSingleTap;
    public GestureDetector.OnDoubleTapListener mDoubleTapListener;
    public int mDoubleTapSlopSquare;
    public float mDownFocusX;
    public float mDownFocusY;
    public final Handler mHandler;
    public boolean mInLongPress;
    public boolean mIsDoubleTapping;
    public boolean mIsLongpressEnabled;
    public float mLastFocusX;
    public float mLastFocusY;
    public final GestureDetector.OnGestureListener mListener;
    public int mMaximumFlingVelocity;
    public int mMinimumFlingVelocity;
    public MotionEvent mPreviousUpEvent;
    public boolean mStillDown;
    public int mTouchSlopSquare;
    public VelocityTracker mVelocityTracker;
    
    public GestureDetectorCompatImplBase(GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
    {
      if (paramHandler != null) {
        mHandler = new g.b.a(this, paramHandler);
      } else {
        mHandler = new g.b.a(this);
      }
      mListener = paramOnGestureListener;
      if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
        setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
      }
      init(this$1);
    }
    
    private void cancel()
    {
      mHandler.removeMessages(1);
      mHandler.removeMessages(2);
      mHandler.removeMessages(3);
      mVelocityTracker.recycle();
      mVelocityTracker = null;
      mIsDoubleTapping = false;
      mStillDown = false;
      mAlwaysInTapRegion = false;
      mAlwaysInBiggerTapRegion = false;
      mDeferConfirmSingleTap = false;
      if (mInLongPress) {
        mInLongPress = false;
      }
    }
    
    private void cancelTaps()
    {
      mHandler.removeMessages(1);
      mHandler.removeMessages(2);
      mHandler.removeMessages(3);
      mIsDoubleTapping = false;
      mAlwaysInTapRegion = false;
      mAlwaysInBiggerTapRegion = false;
      mDeferConfirmSingleTap = false;
      if (mInLongPress) {
        mInLongPress = false;
      }
    }
    
    private void init(Context paramContext)
    {
      if (paramContext != null)
      {
        if (mListener != null)
        {
          mIsLongpressEnabled = true;
          paramContext = ViewConfiguration.get(paramContext);
          int i = paramContext.getScaledTouchSlop();
          int j = paramContext.getScaledDoubleTapSlop();
          mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
          mMaximumFlingVelocity = paramContext.getScaledMaximumFlingVelocity();
          mTouchSlopSquare = (i * i);
          mDoubleTapSlopSquare = (j * j);
          return;
        }
        throw new IllegalArgumentException("OnGestureListener must not be null");
      }
      throw new IllegalArgumentException("Context must not be null");
    }
    
    private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
    {
      if (!mAlwaysInBiggerTapRegion) {
        return false;
      }
      if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > DOUBLE_TAP_TIMEOUT) {
        return false;
      }
      int i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      int j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
      return j * j + i * i < mDoubleTapSlopSquare;
    }
    
    public void dispatchLongPress()
    {
      mHandler.removeMessages(3);
      mDeferConfirmSingleTap = false;
      mInLongPress = true;
      mListener.onLongPress(mCurrentDownEvent);
    }
    
    public boolean isLongpressEnabled()
    {
      return mIsLongpressEnabled;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      if (mVelocityTracker == null) {
        mVelocityTracker = VelocityTracker.obtain();
      }
      mVelocityTracker.addMovement(paramMotionEvent);
      int n = i & 0xFF;
      if (n == 6) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (i != 0) {
        j = paramMotionEvent.getActionIndex();
      } else {
        j = -1;
      }
      int m = paramMotionEvent.getPointerCount();
      int k = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (k < m)
      {
        if (j != k)
        {
          f2 = paramMotionEvent.getX(k) + f2;
          f1 = paramMotionEvent.getY(k) + f1;
        }
        k += 1;
      }
      if (i != 0) {
        i = m - 1;
      } else {
        i = m;
      }
      float f3 = i;
      f2 /= f3;
      f1 /= f3;
      boolean bool2;
      MotionEvent localMotionEvent;
      Object localObject;
      if (n != 0)
      {
        boolean bool3;
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3)
            {
              if (n != 5)
              {
                if (n != 6) {
                  return false;
                }
                mLastFocusX = f2;
                mDownFocusX = f2;
                mLastFocusY = f1;
                mDownFocusY = f1;
                mVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                j = paramMotionEvent.getActionIndex();
                i = paramMotionEvent.getPointerId(j);
                f1 = mVelocityTracker.getXVelocity(i);
                f2 = mVelocityTracker.getYVelocity(i);
                i = 0;
                while (i < m)
                {
                  if (i != j)
                  {
                    k = paramMotionEvent.getPointerId(i);
                    f3 = mVelocityTracker.getXVelocity(k);
                    if (mVelocityTracker.getYVelocity(k) * f2 + f3 * f1 < 0.0F)
                    {
                      mVelocityTracker.clear();
                      return false;
                    }
                  }
                  i += 1;
                }
              }
              mLastFocusX = f2;
              mDownFocusX = f2;
              mLastFocusY = f1;
              mDownFocusY = f1;
              cancelTaps();
              return false;
            }
            cancel();
            return false;
          }
          if (mInLongPress) {
            return false;
          }
          f3 = mLastFocusX - f2;
          float f4 = mLastFocusY - f1;
          if (mIsDoubleTapping) {
            return false | mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
          }
          if (mAlwaysInTapRegion)
          {
            i = (int)(f2 - mDownFocusX);
            j = (int)(f1 - mDownFocusY);
            i = j * j + i * i;
            if (i > mTouchSlopSquare)
            {
              bool2 = mListener.onScroll(mCurrentDownEvent, paramMotionEvent, f3, f4);
              mLastFocusX = f2;
              mLastFocusY = f1;
              mAlwaysInTapRegion = false;
              mHandler.removeMessages(3);
              mHandler.removeMessages(1);
              mHandler.removeMessages(2);
            }
            else
            {
              bool2 = false;
            }
            bool3 = bool2;
            if (i > mTouchSlopSquare)
            {
              mAlwaysInBiggerTapRegion = false;
              return bool2;
            }
          }
          else
          {
            if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
              break label1145;
            }
            bool2 = mListener.onScroll(mCurrentDownEvent, paramMotionEvent, f3, f4);
            mLastFocusX = f2;
            mLastFocusY = f1;
            return bool2;
          }
        }
        else
        {
          mStillDown = false;
          localMotionEvent = MotionEvent.obtain(paramMotionEvent);
          if (mIsDoubleTapping)
          {
            bool2 = mDoubleTapListener.onDoubleTapEvent(paramMotionEvent) | false;
          }
          else
          {
            if (mInLongPress)
            {
              mHandler.removeMessages(3);
              mInLongPress = false;
            }
            else
            {
              if (mAlwaysInTapRegion)
              {
                bool2 = mListener.onSingleTapUp(paramMotionEvent);
                if (mDeferConfirmSingleTap)
                {
                  localObject = mDoubleTapListener;
                  if (localObject != null) {
                    ((GestureDetector.OnDoubleTapListener)localObject).onSingleTapConfirmed(paramMotionEvent);
                  }
                }
                break label809;
              }
              localObject = mVelocityTracker;
              i = paramMotionEvent.getPointerId(0);
              ((VelocityTracker)localObject).computeCurrentVelocity(1000, mMaximumFlingVelocity);
              f1 = ((VelocityTracker)localObject).getYVelocity(i);
              f2 = ((VelocityTracker)localObject).getXVelocity(i);
              if ((Math.abs(f1) > mMinimumFlingVelocity) || (Math.abs(f2) > mMinimumFlingVelocity)) {
                break label791;
              }
            }
            bool2 = false;
            break label809;
            label791:
            bool2 = mListener.onFling(mCurrentDownEvent, paramMotionEvent, f2, f1);
          }
          label809:
          paramMotionEvent = mPreviousUpEvent;
          if (paramMotionEvent != null) {
            paramMotionEvent.recycle();
          }
          mPreviousUpEvent = localMotionEvent;
          paramMotionEvent = mVelocityTracker;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.recycle();
            mVelocityTracker = null;
          }
          mIsDoubleTapping = false;
          mDeferConfirmSingleTap = false;
          mHandler.removeMessages(1);
          mHandler.removeMessages(2);
          bool3 = bool2;
        }
        return bool3;
      }
      else
      {
        boolean bool1;
        if (mDoubleTapListener != null)
        {
          bool2 = mHandler.hasMessages(3);
          if (bool2) {
            mHandler.removeMessages(3);
          }
          localMotionEvent = mCurrentDownEvent;
          if (localMotionEvent != null)
          {
            localObject = mPreviousUpEvent;
            if ((localObject != null) && (bool2) && (isConsideredDoubleTap(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
            {
              mIsDoubleTapping = true;
              bool1 = mDoubleTapListener.onDoubleTap(mCurrentDownEvent) | false | mDoubleTapListener.onDoubleTapEvent(paramMotionEvent);
              break label1000;
            }
          }
          mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
        }
        else
        {
          bool1 = false;
        }
        label1000:
        mLastFocusX = f2;
        mDownFocusX = f2;
        mLastFocusY = f1;
        mDownFocusY = f1;
        localMotionEvent = mCurrentDownEvent;
        if (localMotionEvent != null) {
          localMotionEvent.recycle();
        }
        mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        mAlwaysInTapRegion = true;
        mAlwaysInBiggerTapRegion = true;
        mStillDown = true;
        mInLongPress = false;
        mDeferConfirmSingleTap = false;
        if (mIsLongpressEnabled)
        {
          mHandler.removeMessages(2);
          mHandler.sendEmptyMessageAtTime(2, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
        }
        mHandler.sendEmptyMessageAtTime(1, mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
        return bool1 | mListener.onDown(paramMotionEvent);
      }
      label1145:
      return false;
    }
    
    public void setIsLongpressEnabled(boolean paramBoolean)
    {
      mIsLongpressEnabled = paramBoolean;
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
    {
      mDoubleTapListener = paramOnDoubleTapListener;
    }
  }
  
  public class GestureDetectorCompatImplJellybeanMr2
    implements GestureDetectorCompat.GestureDetectorCompatImpl
  {
    public final GestureDetector mDetector;
    
    public GestureDetectorCompatImplJellybeanMr2(GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
    {
      mDetector = new GestureDetector(this$1, paramOnGestureListener, paramHandler);
    }
    
    public boolean isLongpressEnabled()
    {
      return mDetector.isLongpressEnabled();
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return mDetector.onTouchEvent(paramMotionEvent);
    }
    
    public void setIsLongpressEnabled(boolean paramBoolean)
    {
      mDetector.setIsLongpressEnabled(paramBoolean);
    }
    
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
    {
      mDetector.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
  }
}
