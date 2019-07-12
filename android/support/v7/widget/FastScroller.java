package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import b.b.a.W;
import support.android.v4.view.ViewCompat;

@W
public class FastScroller
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnItemTouchListener
{
  public static final int ANIMATION_STATE_FADING_IN = 1;
  public static final int ANIMATION_STATE_FADING_OUT = 3;
  public static final int ANIMATION_STATE_IN = 2;
  public static final int ANIMATION_STATE_OUT = 0;
  public static final int DRAG_NONE = 0;
  public static final int DRAG_X = 1;
  public static final int DRAG_Y = 2;
  public static final int[] EMPTY_STATE_SET = new int[0];
  public static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
  public static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
  public static final int HIDE_DURATION_MS = 500;
  public static final int[] PRESSED_STATE_SET = { 16842919 };
  public static final int SCROLLBAR_FULL_OPAQUE = 255;
  public static final int SHOW_DURATION_MS = 500;
  public static final int STATE_DRAGGING = 2;
  public static final int STATE_HIDDEN = 0;
  public static final int STATE_VISIBLE = 1;
  public int mAnimationState = 0;
  public int mDragState = 0;
  public final Runnable mHideRunnable = new Runnable()
  {
    public void run()
    {
      hide(500);
    }
  };
  @W
  public float mHorizontalDragX;
  public final int[] mHorizontalRange = new int[2];
  @W
  public int mHorizontalThumbCenterX;
  public final StateListDrawable mHorizontalThumbDrawable;
  public final int mHorizontalThumbHeight;
  @W
  public int mHorizontalThumbWidth;
  public final Drawable mHorizontalTrackDrawable;
  public final int mHorizontalTrackHeight;
  public final int mMargin;
  public boolean mNeedHorizontalScrollbar = false;
  public boolean mNeedVerticalScrollbar = false;
  public final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener()
  {
    public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      updateScrollPosition(paramAnonymousRecyclerView.computeHorizontalScrollOffset(), paramAnonymousRecyclerView.computeVerticalScrollOffset());
    }
  };
  public RecyclerView mRecyclerView;
  public int mRecyclerViewHeight = 0;
  public int mRecyclerViewWidth = 0;
  public final int mScrollbarMinimumRange;
  public final ValueAnimator mShowHideAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  public int mState = 0;
  @W
  public float mVerticalDragY;
  public final int[] mVerticalRange = new int[2];
  @W
  public int mVerticalThumbCenterY;
  public final StateListDrawable mVerticalThumbDrawable;
  @W
  public int mVerticalThumbHeight;
  public final int mVerticalThumbWidth;
  public final Drawable mVerticalTrackDrawable;
  public final int mVerticalTrackWidth;
  
  public FastScroller(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    mVerticalThumbDrawable = paramStateListDrawable1;
    mVerticalTrackDrawable = paramDrawable1;
    mHorizontalThumbDrawable = paramStateListDrawable2;
    mHorizontalTrackDrawable = paramDrawable2;
    mVerticalThumbWidth = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    mVerticalTrackWidth = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    mHorizontalThumbHeight = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    mHorizontalTrackHeight = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    mScrollbarMinimumRange = paramInt2;
    mMargin = paramInt3;
    mVerticalThumbDrawable.setAlpha(255);
    mVerticalTrackDrawable.setAlpha(255);
    mShowHideAnimator.addListener(new AnimatorListener());
    mShowHideAnimator.addUpdateListener(new AnimatorUpdater());
    attachToRecyclerView(paramRecyclerView);
  }
  
  private void cancelHide()
  {
    mRecyclerView.removeCallbacks(mHideRunnable);
  }
  
  private void destroyCallbacks()
  {
    mRecyclerView.removeItemDecoration(this);
    mRecyclerView.removeOnItemTouchListener(this);
    mRecyclerView.removeOnScrollListener(mOnScrollListener);
    cancelHide();
  }
  
  private void drawHorizontalScrollbar(Canvas paramCanvas)
  {
    int j = mRecyclerViewHeight;
    int i = mHorizontalThumbHeight;
    j -= i;
    int m = mHorizontalThumbCenterX;
    int k = mHorizontalThumbWidth;
    m -= k / 2;
    mHorizontalThumbDrawable.setBounds(0, 0, k, i);
    mHorizontalTrackDrawable.setBounds(0, 0, mRecyclerViewWidth, mHorizontalTrackHeight);
    paramCanvas.translate(0.0F, j);
    mHorizontalTrackDrawable.draw(paramCanvas);
    paramCanvas.translate(m, 0.0F);
    mHorizontalThumbDrawable.draw(paramCanvas);
    paramCanvas.translate(-m, -j);
  }
  
  private void drawVerticalScrollbar(Canvas paramCanvas)
  {
    int j = mRecyclerViewWidth;
    int i = mVerticalThumbWidth;
    j -= i;
    int m = mVerticalThumbCenterY;
    int k = mVerticalThumbHeight;
    m -= k / 2;
    mVerticalThumbDrawable.setBounds(0, 0, i, k);
    mVerticalTrackDrawable.setBounds(0, 0, mVerticalTrackWidth, mRecyclerViewHeight);
    if (isLayoutRTL())
    {
      mVerticalTrackDrawable.draw(paramCanvas);
      paramCanvas.translate(mVerticalThumbWidth, m);
      paramCanvas.scale(-1.0F, 1.0F);
      mVerticalThumbDrawable.draw(paramCanvas);
      paramCanvas.scale(1.0F, 1.0F);
      paramCanvas.translate(-mVerticalThumbWidth, -m);
      return;
    }
    paramCanvas.translate(j, 0.0F);
    mVerticalTrackDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, m);
    mVerticalThumbDrawable.draw(paramCanvas);
    paramCanvas.translate(-j, -m);
  }
  
  private int[] getHorizontalRange()
  {
    int[] arrayOfInt = mHorizontalRange;
    int i = mMargin;
    arrayOfInt[0] = i;
    arrayOfInt[1] = (mRecyclerViewWidth - i);
    return arrayOfInt;
  }
  
  private int[] getVerticalRange()
  {
    int[] arrayOfInt = mVerticalRange;
    int i = mMargin;
    arrayOfInt[0] = i;
    arrayOfInt[1] = (mRecyclerViewHeight - i);
    return arrayOfInt;
  }
  
  private void horizontalScrollTo(float paramFloat)
  {
    int[] arrayOfInt = getHorizontalRange();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(mHorizontalThumbCenterX - paramFloat) < 2.0F) {
      return;
    }
    int i = scrollTo(mHorizontalDragX, paramFloat, arrayOfInt, mRecyclerView.computeHorizontalScrollRange(), mRecyclerView.computeHorizontalScrollOffset(), mRecyclerViewWidth);
    if (i != 0) {
      mRecyclerView.scrollBy(i, 0);
    }
    mHorizontalDragX = paramFloat;
  }
  
  private boolean isLayoutRTL()
  {
    return ViewCompat.getLayoutDirection(mRecyclerView) == 1;
  }
  
  private void resetHideDelay(int paramInt)
  {
    cancelHide();
    mRecyclerView.postDelayed(mHideRunnable, paramInt);
  }
  
  private int scrollTo(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i == 0) {
      return 0;
    }
    paramFloat1 = (paramFloat2 - paramFloat1) / i;
    paramInt1 -= paramInt3;
    paramInt3 = (int)(paramFloat1 * paramInt1);
    paramInt2 += paramInt3;
    if ((paramInt2 < paramInt1) && (paramInt2 >= 0)) {
      return paramInt3;
    }
    return 0;
  }
  
  private void setupCallbacks()
  {
    mRecyclerView.addItemDecoration(this);
    mRecyclerView.addOnItemTouchListener(this);
    mRecyclerView.addOnScrollListener(mOnScrollListener);
  }
  
  private void verticalScrollTo(float paramFloat)
  {
    int[] arrayOfInt = getVerticalRange();
    paramFloat = Math.max(arrayOfInt[0], Math.min(arrayOfInt[1], paramFloat));
    if (Math.abs(mVerticalThumbCenterY - paramFloat) < 2.0F) {
      return;
    }
    int i = scrollTo(mVerticalDragY, paramFloat, arrayOfInt, mRecyclerView.computeVerticalScrollRange(), mRecyclerView.computeVerticalScrollOffset(), mRecyclerViewHeight);
    if (i != 0) {
      mRecyclerView.scrollBy(0, i);
    }
    mVerticalDragY = paramFloat;
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView)
  {
    RecyclerView localRecyclerView = mRecyclerView;
    if (localRecyclerView == paramRecyclerView) {
      return;
    }
    if (localRecyclerView != null) {
      destroyCallbacks();
    }
    mRecyclerView = paramRecyclerView;
    if (mRecyclerView != null) {
      setupCallbacks();
    }
  }
  
  public Drawable getHorizontalThumbDrawable()
  {
    return mHorizontalThumbDrawable;
  }
  
  public Drawable getHorizontalTrackDrawable()
  {
    return mHorizontalTrackDrawable;
  }
  
  public Drawable getVerticalThumbDrawable()
  {
    return mVerticalThumbDrawable;
  }
  
  public Drawable getVerticalTrackDrawable()
  {
    return mVerticalTrackDrawable;
  }
  
  public void hide()
  {
    hide(0);
  }
  
  public void hide(int paramInt)
  {
    int i = mAnimationState;
    if (i != 1)
    {
      if (i == 2) {}
    }
    else {
      mShowHideAnimator.cancel();
    }
    mAnimationState = 3;
    ValueAnimator localValueAnimator = mShowHideAnimator;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
    mShowHideAnimator.setDuration(paramInt);
    mShowHideAnimator.start();
  }
  
  public boolean isDragging()
  {
    return mState == 2;
  }
  
  public boolean isHidden()
  {
    return mState == 0;
  }
  
  public boolean isPointInsideHorizontalThumb(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= mRecyclerViewHeight - mHorizontalThumbHeight)
    {
      int i = mHorizontalThumbCenterX;
      int j = mHorizontalThumbWidth;
      if ((paramFloat1 >= i - j / 2) && (paramFloat1 <= j / 2 + i)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isPointInsideVerticalThumb(float paramFloat1, float paramFloat2)
  {
    if (isLayoutRTL() ? paramFloat1 <= mVerticalThumbWidth / 2 : paramFloat1 >= mRecyclerViewWidth - mVerticalThumbWidth)
    {
      int i = mVerticalThumbCenterY;
      int j = mVerticalThumbHeight;
      if ((paramFloat2 >= i - j / 2) && (paramFloat2 <= j / 2 + i)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isVisible()
  {
    return mState == 1;
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((mRecyclerViewWidth == mRecyclerView.getWidth()) && (mRecyclerViewHeight == mRecyclerView.getHeight()))
    {
      if (mAnimationState != 0)
      {
        if (mNeedVerticalScrollbar) {
          drawVerticalScrollbar(paramCanvas);
        }
        if (mNeedHorizontalScrollbar) {
          drawHorizontalScrollbar(paramCanvas);
        }
      }
    }
    else
    {
      mRecyclerViewWidth = mRecyclerView.getWidth();
      mRecyclerViewHeight = mRecyclerView.getHeight();
      setState(0);
    }
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = mState;
    if (i == 1)
    {
      boolean bool1 = isPointInsideVerticalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = isPointInsideHorizontalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((paramMotionEvent.getAction() != 0) || ((!bool1) && (!bool2))) {
        break label113;
      }
      if (bool2)
      {
        mDragState = 1;
        mHorizontalDragX = ((int)paramMotionEvent.getX());
      }
      else if (bool1)
      {
        mDragState = 2;
        mVerticalDragY = ((int)paramMotionEvent.getY());
      }
      setState(2);
    }
    else
    {
      if (i != 2) {
        break label113;
      }
    }
    return true;
    label113:
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (mState == 0) {
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = isPointInsideVerticalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = isPointInsideHorizontalThumb(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (bool2)
        {
          mDragState = 1;
          mHorizontalDragX = ((int)paramMotionEvent.getX());
        }
        else if (bool1)
        {
          mDragState = 2;
          mVerticalDragY = ((int)paramMotionEvent.getY());
        }
        setState(2);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 1) && (mState == 2))
      {
        mVerticalDragY = 0.0F;
        mHorizontalDragX = 0.0F;
        setState(1);
        mDragState = 0;
        return;
      }
      if ((paramMotionEvent.getAction() == 2) && (mState == 2))
      {
        show();
        if (mDragState == 1) {
          horizontalScrollTo(paramMotionEvent.getX());
        }
        if (mDragState == 2) {
          verticalScrollTo(paramMotionEvent.getY());
        }
      }
    }
  }
  
  public void requestRedraw()
  {
    mRecyclerView.invalidate();
  }
  
  public void setState(int paramInt)
  {
    if ((paramInt == 2) && (mState != 2))
    {
      mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
      cancelHide();
    }
    if (paramInt == 0) {
      requestRedraw();
    } else {
      show();
    }
    if ((mState == 2) && (paramInt != 2))
    {
      mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
      resetHideDelay(1200);
    }
    else if (paramInt == 1)
    {
      resetHideDelay(1500);
    }
    mState = paramInt;
  }
  
  public void show()
  {
    int i = mAnimationState;
    if (i != 0)
    {
      if (i != 3) {
        return;
      }
      mShowHideAnimator.cancel();
    }
    mAnimationState = 1;
    ValueAnimator localValueAnimator = mShowHideAnimator;
    localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 1.0F });
    mShowHideAnimator.setDuration(500L);
    mShowHideAnimator.setStartDelay(0L);
    mShowHideAnimator.start();
  }
  
  public void updateScrollPosition(int paramInt1, int paramInt2)
  {
    int i = mRecyclerView.computeVerticalScrollRange();
    int j = mRecyclerViewHeight;
    boolean bool;
    if ((i - j > 0) && (j >= mScrollbarMinimumRange)) {
      bool = true;
    } else {
      bool = false;
    }
    mNeedVerticalScrollbar = bool;
    int k = mRecyclerView.computeHorizontalScrollRange();
    int m = mRecyclerViewWidth;
    if ((k - m > 0) && (m >= mScrollbarMinimumRange)) {
      bool = true;
    } else {
      bool = false;
    }
    mNeedHorizontalScrollbar = bool;
    if ((!mNeedVerticalScrollbar) && (!mNeedHorizontalScrollbar))
    {
      if (mState != 0) {
        setState(0);
      }
    }
    else
    {
      float f1;
      float f2;
      if (mNeedVerticalScrollbar)
      {
        f1 = paramInt2;
        f2 = j;
        mVerticalThumbCenterY = ((int)((f2 / 2.0F + f1) * f2 / i));
        mVerticalThumbHeight = Math.min(j, j * j / i);
      }
      if (mNeedHorizontalScrollbar)
      {
        f1 = paramInt1;
        f2 = m;
        mHorizontalThumbCenterX = ((int)((f2 / 2.0F + f1) * f2 / k));
        mHorizontalThumbWidth = Math.min(m, m * m / k);
      }
      paramInt1 = mState;
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        setState(1);
      }
    }
  }
  
  private class AnimatorListener
    extends AnimatorListenerAdapter
  {
    public boolean mCanceled = false;
    
    public AnimatorListener() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      mCanceled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (mCanceled)
      {
        mCanceled = false;
        return;
      }
      if (((Float)mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0F)
      {
        paramAnimator = FastScroller.this;
        mAnimationState = 0;
        paramAnimator.setState(0);
        return;
      }
      paramAnimator = FastScroller.this;
      mAnimationState = 2;
      paramAnimator.requestRedraw();
    }
  }
  
  private class AnimatorUpdater
    implements ValueAnimator.AnimatorUpdateListener
  {
    public AnimatorUpdater() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      mVerticalThumbDrawable.setAlpha(i);
      mVerticalTrackDrawable.setAlpha(i);
      requestRedraw();
    }
  }
}
