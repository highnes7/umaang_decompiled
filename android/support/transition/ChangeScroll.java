package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import support.android.asm.Edit;
import support.android.asm.Type;

public class ChangeScroll
  extends Transition
{
  public static final String ACTION_UPDATE_ALL = "android:changeScroll:y";
  public static final String PAGE_KEY = "android:changeScroll:x";
  public static final String[] suVersion = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void captureValues(Edit paramEdit)
  {
    values.put("android:changeScroll:x", Integer.valueOf(view.getScrollX()));
    values.put("android:changeScroll:y", Integer.valueOf(view.getScrollY()));
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    Object localObject = null;
    if (paramEdit1 != null)
    {
      if (paramEdit2 == null) {
        return null;
      }
      View localView = view;
      int i = ((Integer)values.get("android:changeScroll:x")).intValue();
      int j = ((Integer)values.get("android:changeScroll:x")).intValue();
      int k = ((Integer)values.get("android:changeScroll:y")).intValue();
      int m = ((Integer)values.get("android:changeScroll:y")).intValue();
      if (i != j)
      {
        localView.setScrollX(i);
        paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });
      }
      else
      {
        paramViewGroup = null;
      }
      paramEdit1 = localObject;
      if (k != m)
      {
        localView.setScrollY(k);
        paramEdit1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });
      }
      return Type.loadAnimator(paramViewGroup, paramEdit1);
    }
    return null;
  }
  
  public String[] getTransitionProperties()
  {
    return suVersion;
  }
}
