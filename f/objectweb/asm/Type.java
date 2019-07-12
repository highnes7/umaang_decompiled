package f.objectweb.asm;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Stack;

public class Type
  extends e
{
  public Type(android.support.v7.widget.Toolbar paramToolbar, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    super(paramToolbar.findViewById(paramInt), paramCharSequence1, paramCharSequence2);
  }
  
  public Type(android.support.v7.widget.Toolbar paramToolbar, boolean paramBoolean, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    super(paramToolbar, paramCharSequence1, paramCharSequence2);
  }
  
  public Type(android.widget.Toolbar paramToolbar, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    super(paramToolbar.findViewById(paramInt), paramCharSequence1, paramCharSequence2);
  }
  
  public Type(android.widget.Toolbar paramToolbar, boolean paramBoolean, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    super(paramToolbar, paramCharSequence1, paramCharSequence2);
  }
  
  public static View a(Object paramObject)
  {
    ChildHelper.Callback localCallback = get(paramObject);
    Object localObject = localCallback.addView();
    paramObject = localObject;
    int i = TextUtils.isEmpty((CharSequence)localObject) ^ true;
    if (i == 0) {
      paramObject = "taptarget-findme";
    }
    localCallback.setNavigationContentDescription((CharSequence)paramObject);
    localObject = new ArrayList(1);
    localCallback.addView((ArrayList)localObject, (CharSequence)paramObject, 2);
    if (i == 0) {
      localCallback.setNavigationContentDescription(null);
    }
    int k = ((ArrayList)localObject).size();
    i = 0;
    if (k > 0) {
      return (View)((ArrayList)localObject).get(0);
    }
    paramObject = localCallback.removeAllViews();
    if (paramObject != null)
    {
      k = localCallback.getChildCount();
      while (i < k)
      {
        localObject = localCallback.getChildAt(i);
        if (((localObject instanceof ImageButton)) && (((ImageButton)localObject).getDrawable() == paramObject)) {
          return localObject;
        }
        int j;
        i += 1;
      }
      throw new IllegalStateException("Could not find navigation view for Toolbar!");
    }
    paramObject = new IllegalStateException("Toolbar does not have a navigation view set!");
    throw paramObject;
  }
  
  public static View create(Object paramObject)
  {
    paramObject = get(paramObject);
    Drawable localDrawable = paramObject.getOverflowIcon();
    if (localDrawable != null)
    {
      Stack localStack = new Stack();
      localStack.push((ViewGroup)paramObject.getChildAt());
      while (!localStack.empty())
      {
        ViewGroup localViewGroup = (ViewGroup)localStack.pop();
        int j = localViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = localViewGroup.getChildAt(i);
          if ((localView instanceof ViewGroup)) {
            localStack.push((ViewGroup)localView);
          } else if (((localView instanceof ImageView)) && (((ImageView)localView).getDrawable() == localDrawable)) {
            return localView;
          }
          i += 1;
        }
      }
    }
    try
    {
      paramObject = HttpSenderFactory.create(HttpSenderFactory.create(HttpSenderFactory.create(paramObject.getChildAt(), "mMenuView"), "mPresenter"), "mOverflowButton");
      return (View)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new IllegalStateException("Unable to access overflow view for Toolbar!", paramObject);
    }
    catch (NoSuchFieldException paramObject)
    {
      paramObject = new IllegalStateException("Could not find overflow view for Toolbar!", paramObject);
      throw paramObject;
    }
  }
  
  public static ChildHelper.Callback get(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof android.support.v7.widget.Toolbar)) {
        return new RecyclerView.5((android.support.v7.widget.Toolbar)paramObject);
      }
      if ((paramObject instanceof android.widget.Toolbar)) {
        return new RecyclerView.4((android.widget.Toolbar)paramObject);
      }
      throw new IllegalStateException("Couldn't provide proper toolbar proxy instance");
    }
    throw new IllegalArgumentException("Given null instance");
  }
}
