package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.b.a.N;

@N({b.b.a.N.a.b})
public class DescendantOffsetUtils
{
  public static final ThreadLocal<Matrix> matrix = new ThreadLocal();
  public static final ThreadLocal<RectF> rectF = new ThreadLocal();
  
  public DescendantOffsetUtils() {}
  
  public static void getDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    offsetDescendantRect(paramViewGroup, paramView, paramRect);
  }
  
  public static void offsetDescendantMatrix(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if (((localObject instanceof View)) && (localObject != paramViewParent))
    {
      localObject = (View)localObject;
      offsetDescendantMatrix(paramViewParent, (View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity()) {
      paramMatrix.preConcat(paramView.getMatrix());
    }
  }
  
  public static void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    Matrix localMatrix = (Matrix)matrix.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      matrix.set(localMatrix);
    }
    else
    {
      localMatrix.reset();
    }
    offsetDescendantMatrix(paramViewGroup, paramView, localMatrix);
    paramView = (RectF)rectF.get();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new RectF();
      rectF.set(paramViewGroup);
    }
    paramViewGroup.set(paramRect);
    localMatrix.mapRect(paramViewGroup);
    paramRect.set((int)(left + 0.5F), (int)(top + 0.5F), (int)(right + 0.5F), (int)(bottom + 0.5F));
  }
}
