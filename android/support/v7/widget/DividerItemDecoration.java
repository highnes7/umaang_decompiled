package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public class DividerItemDecoration
  extends RecyclerView.ItemDecoration
{
  public static final int[] ATTRS = { 16843284 };
  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;
  public static final String size = "DividerItem";
  public final Rect mBounds = new Rect();
  public Drawable mDivider;
  public int mOrientation;
  
  public DividerItemDecoration(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(ATTRS);
    mDivider = paramContext.getDrawable(0);
    paramContext.recycle();
    setOrientation(paramInt);
  }
  
  private void drawHorizontal(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int k = 0;
    int i;
    int j;
    if (bool)
    {
      m = paramRecyclerView.getPaddingTop();
      i = m;
      j = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), m, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), j);
    }
    else
    {
      j = paramRecyclerView.getHeight();
      i = 0;
    }
    int m = paramRecyclerView.getChildCount();
    while (k < m)
    {
      View localView = paramRecyclerView.getChildAt(k);
      paramRecyclerView.getLayoutManager().getDecoratedBoundsWithMargins(localView, mBounds);
      int n = mBounds.right;
      n = Math.round(localView.getTranslationX()) + n;
      int i1 = mDivider.getIntrinsicWidth();
      mDivider.setBounds(n - i1, i, n, j);
      mDivider.draw(paramCanvas);
      k += 1;
    }
    paramCanvas.restore();
  }
  
  private void drawVertical(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int k = 0;
    int i;
    int j;
    if (bool)
    {
      m = paramRecyclerView.getPaddingLeft();
      i = m;
      j = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      paramCanvas.clipRect(m, paramRecyclerView.getPaddingTop(), j, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    }
    else
    {
      j = paramRecyclerView.getWidth();
      i = 0;
    }
    int m = paramRecyclerView.getChildCount();
    while (k < m)
    {
      View localView = paramRecyclerView.getChildAt(k);
      paramRecyclerView.getDecoratedBoundsWithMargins(localView, mBounds);
      int n = mBounds.bottom;
      n = Math.round(localView.getTranslationY()) + n;
      int i1 = mDivider.getIntrinsicHeight();
      mDivider.setBounds(i, n - i1, j, n);
      mDivider.draw(paramCanvas);
      k += 1;
    }
    paramCanvas.restore();
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramView = mDivider;
    if (paramView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (mOrientation == 1)
    {
      paramRect.set(0, 0, 0, paramView.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, paramView.getIntrinsicWidth(), 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (paramRecyclerView.getLayoutManager() != null)
    {
      if (mDivider == null) {
        return;
      }
      if (mOrientation == 1)
      {
        drawVertical(paramCanvas, paramRecyclerView);
        return;
      }
      drawHorizontal(paramCanvas, paramRecyclerView);
    }
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      mDivider = paramDrawable;
      return;
    }
    throw new IllegalArgumentException("Drawable cannot be null.");
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
    mOrientation = paramInt;
  }
}
