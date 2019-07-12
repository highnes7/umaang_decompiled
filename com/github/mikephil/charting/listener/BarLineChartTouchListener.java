package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener
  extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>>
{
  public IDataSet mClosestDataSetToTouch;
  public PointF mDecelerationCurrentPoint = new PointF();
  public long mDecelerationLastTime = 0L;
  public PointF mDecelerationVelocity = new PointF();
  public float mDragTriggerDist;
  public Matrix mMatrix = new Matrix();
  public float mMinScalePointerDistance;
  public float mSavedDist = 1.0F;
  public Matrix mSavedMatrix = new Matrix();
  public float mSavedXDist = 1.0F;
  public float mSavedYDist = 1.0F;
  public PointF mTouchPointCenter = new PointF();
  public PointF mTouchStartPoint = new PointF();
  public VelocityTracker mVelocityTracker;
  
  public BarLineChartTouchListener(BarLineChartBase paramBarLineChartBase, Matrix paramMatrix)
  {
    super(paramBarLineChartBase);
    mMatrix = paramMatrix;
    mDragTriggerDist = Utils.convertDpToPixel(3.0F);
    mMinScalePointerDistance = Utils.convertDpToPixel(3.5F);
  }
  
  public static float getXDist(MotionEvent paramMotionEvent)
  {
    return Math.abs(paramMotionEvent.getX(0) - paramMotionEvent.getX(1));
  }
  
  public static float getYDist(MotionEvent paramMotionEvent)
  {
    return Math.abs(paramMotionEvent.getY(0) - paramMotionEvent.getY(1));
  }
  
  public static void midPoint(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getX(1);
    float f3 = paramMotionEvent.getY(0);
    float f4 = paramMotionEvent.getY(1);
    paramPointF.set((f2 + f1) / 2.0F, (f4 + f3) / 2.0F);
  }
  
  private void performDrag(MotionEvent paramMotionEvent)
  {
    mLastGesture = ChartTouchListener.ChartGesture.DRAG;
    mMatrix.set(mSavedMatrix);
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)mChart).getOnChartGestureListener();
    if (((BarLineChartBase)mChart).isAnyAxisInverted())
    {
      IDataSet localIDataSet = mClosestDataSetToTouch;
      if ((localIDataSet != null) && (((BarLineChartBase)mChart).getAxis(localIDataSet.getAxisDependency()).isInverted()))
      {
        if ((mChart instanceof HorizontalBarChart))
        {
          f1 = -(paramMotionEvent.getX() - mTouchStartPoint.x);
          f2 = paramMotionEvent.getY();
          f3 = mTouchStartPoint.y;
          break label175;
        }
        f1 = paramMotionEvent.getX() - mTouchStartPoint.x;
        f2 = -(paramMotionEvent.getY() - mTouchStartPoint.y);
        break label180;
      }
    }
    float f1 = paramMotionEvent.getX() - mTouchStartPoint.x;
    float f2 = paramMotionEvent.getY();
    float f3 = mTouchStartPoint.y;
    label175:
    f2 -= f3;
    label180:
    mMatrix.postTranslate(f1, f2);
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartTranslate(paramMotionEvent, f1, f2);
    }
  }
  
  private void performHighlightDrag(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = ((BarLineChartBase)mChart).getHighlightByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY());
    if ((paramMotionEvent != null) && (!paramMotionEvent.equalTo(mLastHighlighted)))
    {
      mLastHighlighted = paramMotionEvent;
      ((BarLineChartBase)mChart).highlightValue(paramMotionEvent, true);
    }
  }
  
  private void performZoom(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() >= 2)
    {
      OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)mChart).getOnChartGestureListener();
      float f1 = spacing(paramMotionEvent);
      if (f1 > mMinScalePointerDistance)
      {
        PointF localPointF = mTouchPointCenter;
        localPointF = getTrans(x, y);
        ViewPortHandler localViewPortHandler = ((BarLineChartBase)mChart).getViewPortHandler();
        int m = mTouchMode;
        int j = 1;
        int k = 1;
        int i = 1;
        boolean bool1;
        if (m == 4)
        {
          mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
          f1 /= mSavedDist;
          if (f1 >= 1.0F) {
            i = 0;
          }
          if (i != 0) {
            bool1 = localViewPortHandler.canZoomOutMoreX();
          } else {
            bool1 = localViewPortHandler.canZoomInMoreX();
          }
          boolean bool2;
          if (i != 0) {
            bool2 = localViewPortHandler.canZoomOutMoreY();
          } else {
            bool2 = localViewPortHandler.canZoomInMoreY();
          }
          float f2;
          if (((BarLineChartBase)mChart).isScaleXEnabled()) {
            f2 = f1;
          } else {
            f2 = 1.0F;
          }
          if (!((BarLineChartBase)mChart).isScaleYEnabled()) {
            f1 = 1.0F;
          }
          if ((bool2) || (bool1))
          {
            mMatrix.set(mSavedMatrix);
            mMatrix.postScale(f2, f1, x, y);
            if (localOnChartGestureListener != null) {
              localOnChartGestureListener.onChartScale(paramMotionEvent, f2, f1);
            }
          }
        }
        else if ((m == 2) && (((BarLineChartBase)mChart).isScaleXEnabled()))
        {
          mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
          f1 = getXDist(paramMotionEvent) / mSavedXDist;
          if (f1 < 1.0F) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0) {
            bool1 = localViewPortHandler.canZoomOutMoreX();
          } else {
            bool1 = localViewPortHandler.canZoomInMoreX();
          }
          if (bool1)
          {
            mMatrix.set(mSavedMatrix);
            mMatrix.postScale(f1, 1.0F, x, y);
            if (localOnChartGestureListener != null) {
              localOnChartGestureListener.onChartScale(paramMotionEvent, f1, 1.0F);
            }
          }
        }
        else if ((mTouchMode == 3) && (((BarLineChartBase)mChart).isScaleYEnabled()))
        {
          mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
          f1 = getYDist(paramMotionEvent) / mSavedYDist;
          if (f1 < 1.0F) {
            i = k;
          } else {
            i = 0;
          }
          if (i != 0) {
            bool1 = localViewPortHandler.canZoomOutMoreY();
          } else {
            bool1 = localViewPortHandler.canZoomInMoreY();
          }
          if (bool1)
          {
            mMatrix.set(mSavedMatrix);
            mMatrix.postScale(1.0F, f1, x, y);
            if (localOnChartGestureListener != null) {
              localOnChartGestureListener.onChartScale(paramMotionEvent, 1.0F, f1);
            }
          }
        }
      }
    }
  }
  
  private void saveTouchStart(MotionEvent paramMotionEvent)
  {
    mSavedMatrix.set(mMatrix);
    mTouchStartPoint.set(paramMotionEvent.getX(), paramMotionEvent.getY());
    mClosestDataSetToTouch = ((BarLineChartBase)mChart).getDataSetByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  public static float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f2 * f2 + f1 * f1);
  }
  
  public void computeScroll()
  {
    Object localObject = mDecelerationVelocity;
    if ((x == 0.0F) && (y == 0.0F)) {
      return;
    }
    long l = AnimationUtils.currentAnimationTimeMillis();
    localObject = mDecelerationVelocity;
    float f1 = x;
    x = (((BarLineChartBase)mChart).getDragDecelerationFrictionCoef() * f1);
    localObject = mDecelerationVelocity;
    f1 = y;
    y = (((BarLineChartBase)mChart).getDragDecelerationFrictionCoef() * f1);
    f1 = (float)(l - mDecelerationLastTime) / 1000.0F;
    localObject = mDecelerationVelocity;
    float f2 = x;
    float f3 = y;
    localObject = mDecelerationCurrentPoint;
    x += f2 * f1;
    y += f3 * f1;
    localObject = MotionEvent.obtain(l, l, 2, x, y, 0);
    performDrag((MotionEvent)localObject);
    ((MotionEvent)localObject).recycle();
    mMatrix = ((BarLineChartBase)mChart).getViewPortHandler().refresh(mMatrix, mChart, false);
    mDecelerationLastTime = l;
    if ((Math.abs(mDecelerationVelocity.x) < 0.01D) && (Math.abs(mDecelerationVelocity.y) < 0.01D))
    {
      ((BarLineChartBase)mChart).calculateOffsets();
      ((BarLineChartBase)mChart).postInvalidate();
      stopDeceleration();
      return;
    }
    Utils.postInvalidateOnAnimation(mChart);
  }
  
  public Matrix getMatrix()
  {
    return mMatrix;
  }
  
  public PointF getTrans(float paramFloat1, float paramFloat2)
  {
    ViewPortHandler localViewPortHandler = ((BarLineChartBase)mChart).getViewPortHandler();
    float f = localViewPortHandler.offsetLeft();
    if (((BarLineChartBase)mChart).isAnyAxisInverted())
    {
      IDataSet localIDataSet = mClosestDataSetToTouch;
      if ((localIDataSet != null) && (((BarLineChartBase)mChart).isInverted(localIDataSet.getAxisDependency())))
      {
        paramFloat2 = -(paramFloat2 - localViewPortHandler.offsetTop());
        break label95;
      }
    }
    paramFloat2 = -(((BarLineChartBase)mChart).getMeasuredHeight() - paramFloat2 - localViewPortHandler.offsetBottom());
    label95:
    return new PointF(paramFloat1 - f, paramFloat2);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
    Object localObject1 = ((BarLineChartBase)mChart).getOnChartGestureListener();
    if (localObject1 != null) {
      ((OnChartGestureListener)localObject1).onChartDoubleTapped(paramMotionEvent);
    }
    if (((BarLineChartBase)mChart).isDoubleTapToZoomEnabled())
    {
      localObject1 = getTrans(paramMotionEvent.getX(), paramMotionEvent.getY());
      Object localObject2 = mChart;
      BarLineChartBase localBarLineChartBase = (BarLineChartBase)localObject2;
      boolean bool = ((BarLineChartBase)localObject2).isScaleXEnabled();
      float f2 = 1.4F;
      float f1;
      if (bool) {
        f1 = 1.4F;
      } else {
        f1 = 1.0F;
      }
      if (!((BarLineChartBase)mChart).isScaleYEnabled()) {
        f2 = 1.0F;
      }
      localBarLineChartBase.zoom(f1, f2, x, y);
      if (((BarLineChartBase)mChart).isLogEnabled())
      {
        localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Double-Tap, Zooming In, x: ");
        ((StringBuilder)localObject2).append(x);
        ((StringBuilder)localObject2).append(", y: ");
        ((StringBuilder)localObject2).append(y);
        ((StringBuilder)localObject2).toString();
      }
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    mLastGesture = ChartTouchListener.ChartGesture.FLING;
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartLongPressed(paramMotionEvent);
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
    OnChartGestureListener localOnChartGestureListener = ((BarLineChartBase)mChart).getOnChartGestureListener();
    if (localOnChartGestureListener != null) {
      localOnChartGestureListener.onChartSingleTapped(paramMotionEvent);
    }
    if (!((BarLineChartBase)mChart).isHighlightPerTapEnabled()) {
      return false;
    }
    performHighlight(((BarLineChartBase)mChart).getHighlightByTouchPoint(paramMotionEvent.getX(), paramMotionEvent.getY()), paramMotionEvent);
    return super.onSingleTapUp(paramMotionEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 3)
    {
      paramView = mVelocityTracker;
      if (paramView != null)
      {
        paramView.recycle();
        mVelocityTracker = null;
      }
    }
    if (mTouchMode == 0) {
      mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    if ((!((BarLineChartBase)mChart).isDragEnabled()) && (!((BarLineChartBase)mChart).isScaleXEnabled()) && (!((BarLineChartBase)mChart).isScaleYEnabled())) {
      return true;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i == 6)
              {
                Utils.velocityTrackerPointerUpCleanUpIfNecessary(paramMotionEvent, mVelocityTracker);
                mTouchMode = 5;
              }
            }
            else if (paramMotionEvent.getPointerCount() >= 2)
            {
              ((BarLineChartBase)mChart).disableScroll();
              saveTouchStart(paramMotionEvent);
              mSavedXDist = getXDist(paramMotionEvent);
              mSavedYDist = getYDist(paramMotionEvent);
              mSavedDist = spacing(paramMotionEvent);
              if (mSavedDist > 10.0F) {
                if (((BarLineChartBase)mChart).isPinchZoomEnabled()) {
                  mTouchMode = 4;
                } else if (mSavedXDist > mSavedYDist) {
                  mTouchMode = 2;
                } else {
                  mTouchMode = 3;
                }
              }
              midPoint(mTouchPointCenter, paramMotionEvent);
            }
          }
          else
          {
            mTouchMode = 0;
            endAction(paramMotionEvent);
          }
        }
        else
        {
          i = mTouchMode;
          if (i == 1)
          {
            ((BarLineChartBase)mChart).disableScroll();
            performDrag(paramMotionEvent);
          }
          else if ((i != 2) && (i != 3) && (i != 4))
          {
            if ((i == 0) && (Math.abs(ChartTouchListener.distance(paramMotionEvent.getX(), mTouchStartPoint.x, paramMotionEvent.getY(), mTouchStartPoint.y)) > mDragTriggerDist)) {
              if (((BarLineChartBase)mChart).hasNoDragOffset())
              {
                if ((!((BarLineChartBase)mChart).isFullyZoomedOut()) && (((BarLineChartBase)mChart).isDragEnabled()))
                {
                  mTouchMode = 1;
                }
                else
                {
                  mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                  if (((BarLineChartBase)mChart).isHighlightPerDragEnabled()) {
                    performHighlightDrag(paramMotionEvent);
                  }
                }
              }
              else if (((BarLineChartBase)mChart).isDragEnabled())
              {
                mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                mTouchMode = 1;
              }
            }
          }
          else
          {
            ((BarLineChartBase)mChart).disableScroll();
            if ((((BarLineChartBase)mChart).isScaleXEnabled()) || (((BarLineChartBase)mChart).isScaleYEnabled())) {
              performZoom(paramMotionEvent);
            }
          }
        }
      }
      else
      {
        paramView = mVelocityTracker;
        i = paramMotionEvent.getPointerId(0);
        paramView.computeCurrentVelocity(1000, Utils.mMaximumFlingVelocity);
        float f1 = paramView.getYVelocity(i);
        float f2 = paramView.getXVelocity(i);
        if (((Math.abs(f2) > Utils.mMinimumFlingVelocity) || (Math.abs(f1) > Utils.mMinimumFlingVelocity)) && (mTouchMode == 1) && (((BarLineChartBase)mChart).isDragDecelerationEnabled()))
        {
          stopDeceleration();
          mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
          mDecelerationCurrentPoint = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
          mDecelerationVelocity = new PointF(f2, f1);
          Utils.postInvalidateOnAnimation(mChart);
        }
        i = mTouchMode;
        if ((i == 2) || (i == 3) || (i == 4) || (i == 5))
        {
          ((BarLineChartBase)mChart).calculateOffsets();
          ((BarLineChartBase)mChart).postInvalidate();
        }
        mTouchMode = 0;
        ((BarLineChartBase)mChart).enableScroll();
        paramView = mVelocityTracker;
        if (paramView != null)
        {
          paramView.recycle();
          mVelocityTracker = null;
        }
        endAction(paramMotionEvent);
      }
    }
    else
    {
      startAction(paramMotionEvent);
      stopDeceleration();
      saveTouchStart(paramMotionEvent);
    }
    mMatrix = ((BarLineChartBase)mChart).getViewPortHandler().refresh(mMatrix, mChart, true);
    return true;
  }
  
  public void stopDeceleration()
  {
    mDecelerationVelocity = new PointF(0.0F, 0.0F);
  }
}
