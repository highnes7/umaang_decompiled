package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import support.android.asm.Edit;
import support.android.asm.Frame;
import support.android.asm.GlowPadView.1;
import support.android.asm.Node;
import support.android.v4.view.ViewCompat;

public class ChangeClipBounds
  extends Transition
{
  public static final String ACTION_UPDATE_ALL = "android:clipBounds:bounds";
  public static final String PAGE_KEY = "android:clipBounds:clip";
  public static final String[] suVersion = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void captureValues(Edit paramEdit)
  {
    Object localObject = view;
    if (((View)localObject).getVisibility() == 8) {
      return;
    }
    Rect localRect = ViewCompat.create((View)localObject);
    values.put("android:clipBounds:clip", localRect);
    if (localRect == null)
    {
      localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      values.put("android:clipBounds:bounds", localObject);
    }
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
    if ((paramEdit1 != null) && (paramEdit2 != null) && (values.containsKey("android:clipBounds:clip")))
    {
      if (!values.containsKey("android:clipBounds:clip")) {
        return null;
      }
      Object localObject = (Rect)values.get("android:clipBounds:clip");
      Rect localRect = (Rect)values.get("android:clipBounds:clip");
      int i;
      if (localRect == null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((localObject == null) && (localRect == null)) {
        return null;
      }
      if (localObject == null)
      {
        paramViewGroup = (Rect)values.get("android:clipBounds:bounds");
        paramEdit1 = localRect;
      }
      else
      {
        paramViewGroup = (ViewGroup)localObject;
        paramEdit1 = localRect;
        if (localRect == null)
        {
          paramEdit1 = (Rect)values.get("android:clipBounds:bounds");
          paramViewGroup = (ViewGroup)localObject;
        }
      }
      if (paramViewGroup.equals(paramEdit1)) {
        return null;
      }
      ViewCompat.get(view, paramViewGroup);
      localObject = new Node(new Rect());
      paramViewGroup = ObjectAnimator.ofObject(view, Frame.table, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramEdit1 });
      if (i != 0)
      {
        paramViewGroup.addListener(new GlowPadView.1(this, view));
        return paramViewGroup;
      }
    }
    else
    {
      return null;
    }
    return paramViewGroup;
  }
  
  public String[] getTransitionProperties()
  {
    return suVersion;
  }
}
