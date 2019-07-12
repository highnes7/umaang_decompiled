package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import support.android.asm.Edit;
import support.android.asm.Frame;
import support.android.asm.MethodVisitor;
import support.android.asm.MethodWriter;
import support.android.asm.R.styleable;
import support.android.asm.SwipeDismissListViewTouchListener.3;
import support.android.asm.Type;
import support.android.asm.g;
import support.android.asm.n;
import support.android.v4.content.asm.TypedArrayUtils;

public abstract class Visibility
  extends Transition
{
  public static final String DEFAULT = "android:visibility:parent";
  public static final String EVENTLOG_URL = "android:visibility:screenLocation";
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final String PRIVATE = "android:visibility:visibility";
  public static final int PUBLIC = 1;
  public static final String[] suVersion = { "android:visibility:visibility", "android:visibility:parent" };
  public int type = 3;
  
  public Visibility() {}
  
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwitchCompat);
    int i = TypedArrayUtils.getString(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      a(i);
    }
  }
  
  private c a(Edit paramEdit1, Edit paramEdit2)
  {
    c localC = new c();
    l = false;
    c = false;
    if ((paramEdit1 != null) && (values.containsKey("android:visibility:visibility")))
    {
      b = ((Integer)values.get("android:visibility:visibility")).intValue();
      a = ((ViewGroup)values.get("android:visibility:parent"));
    }
    else
    {
      b = -1;
      a = null;
    }
    if ((paramEdit2 != null) && (values.containsKey("android:visibility:visibility")))
    {
      i = ((Integer)values.get("android:visibility:visibility")).intValue();
      g = ((ViewGroup)values.get("android:visibility:parent"));
    }
    else
    {
      i = -1;
      g = null;
    }
    if ((paramEdit1 != null) && (paramEdit2 != null))
    {
      if ((b == i) && (a == g)) {
        return localC;
      }
      int i = b;
      int j = i;
      if (i != j)
      {
        if (i == 0)
        {
          c = false;
          l = true;
          return localC;
        }
        if (j == 0)
        {
          c = true;
          l = true;
          return localC;
        }
      }
      else
      {
        if (g == null)
        {
          c = false;
          l = true;
          return localC;
        }
        if (a == null)
        {
          c = true;
          l = true;
          return localC;
        }
      }
    }
    else
    {
      if ((paramEdit1 == null) && (i == 0))
      {
        c = true;
        l = true;
        return localC;
      }
      if ((paramEdit2 == null) && (b == 0))
      {
        c = false;
        l = true;
      }
    }
    return localC;
  }
  
  private void captureValues(Edit paramEdit)
  {
    int i = view.getVisibility();
    values.put("android:visibility:visibility", Integer.valueOf(i));
    values.put("android:visibility:parent", view.getParent());
    int[] arrayOfInt = new int[2];
    view.getLocationOnScreen(arrayOfInt);
    values.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  public Animator a(ViewGroup paramViewGroup, Edit paramEdit1, int paramInt1, Edit paramEdit2, int paramInt2)
  {
    if ((type & 0x2) != 2) {
      return null;
    }
    if (paramEdit1 != null) {
      localObject2 = view;
    } else {
      localObject2 = null;
    }
    if (paramEdit2 != null) {
      localObject1 = view;
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((View)localObject1).getParent() != null))
    {
      if ((paramInt2 == 4) || (localObject2 == localObject1))
      {
        localObject2 = null;
        break label267;
      }
      if (mCanRemoveViews) {
        localObject1 = localObject2;
      } else {
        localObject1 = Type.a(paramViewGroup, (View)localObject2, (View)((View)localObject2).getParent());
      }
    }
    else
    {
      if (localObject1 == null) {
        break label136;
      }
    }
    for (;;)
    {
      Object localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label267;
      label136:
      if (localObject2 == null) {
        break;
      }
      if (((View)localObject2).getParent() == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        if (!(((View)localObject2).getParent() instanceof View)) {
          break;
        }
        localObject1 = (View)((View)localObject2).getParent();
        if (!agetTransitionValuesgetMatchedTransitionValuesl)
        {
          localObject1 = Type.a(paramViewGroup, (View)localObject2, (View)localObject1);
        }
        else
        {
          if (((View)localObject1).getParent() == null)
          {
            paramInt1 = ((View)localObject1).getId();
            if ((paramInt1 != -1) && (paramViewGroup.findViewById(paramInt1) != null) && (mCanRemoveViews))
            {
              localObject1 = localObject2;
              continue;
            }
          }
          localObject1 = null;
        }
      }
    }
    Object localObject2 = null;
    Object localObject1 = null;
    label267:
    if ((localObject2 != null) && (paramEdit1 != null))
    {
      localObject1 = (int[])values.get("android:visibility:screenLocation");
      paramInt1 = localObject1[0];
      paramInt2 = localObject1[1];
      localObject1 = new int[2];
      paramViewGroup.getLocationOnScreen((int[])localObject1);
      ((View)localObject2).offsetLeftAndRight(paramInt1 - localObject1[0] - ((View)localObject2).getLeft());
      ((View)localObject2).offsetTopAndBottom(paramInt2 - localObject1[1] - ((View)localObject2).getTop());
      localObject1 = n.a(paramViewGroup);
      ((g)localObject1).b((View)localObject2);
      paramViewGroup = onDisappear(paramViewGroup, (View)localObject2, paramEdit1, paramEdit2);
      if (paramViewGroup == null)
      {
        ((g)localObject1).c((View)localObject2);
        return paramViewGroup;
      }
      paramViewGroup.addListener(new SwipeDismissListViewTouchListener.3(this, (g)localObject1, (View)localObject2));
      return paramViewGroup;
    }
    if (localObject1 != null)
    {
      paramInt1 = ((View)localObject1).getVisibility();
      Frame.set((View)localObject1, 0);
      paramViewGroup = onDisappear(paramViewGroup, (View)localObject1, paramEdit1, paramEdit2);
      if (paramViewGroup != null)
      {
        paramEdit1 = new a((View)localObject1, paramInt2, true);
        paramViewGroup.addListener(paramEdit1);
        paramInt1 = Build.VERSION.SDK_INT;
        paramViewGroup.addPauseListener(paramEdit1);
        addListener(paramEdit1);
        return paramViewGroup;
      }
      Frame.set((View)localObject1, paramInt1);
      return paramViewGroup;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) == 0)
    {
      type = paramInt;
      return;
    }
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
  
  public boolean a(Edit paramEdit)
  {
    if (paramEdit == null) {
      return false;
    }
    int i = ((Integer)values.get("android:visibility:visibility")).intValue();
    paramEdit = (View)values.get("android:visibility:parent");
    return (i == 0) && (paramEdit != null);
  }
  
  public Animator b(ViewGroup paramViewGroup, Edit paramEdit1, int paramInt1, Edit paramEdit2, int paramInt2)
  {
    if ((type & 0x1) == 1)
    {
      if (paramEdit2 == null) {
        return null;
      }
      if (paramEdit1 == null)
      {
        View localView = (View)view.getParent();
        if (agetMatchedTransitionValuesgetTransitionValuesl) {
          return null;
        }
      }
      return onAppear(paramViewGroup, view, paramEdit1, paramEdit2);
    }
    return null;
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
    c localC = a(paramEdit1, paramEdit2);
    if ((l) && ((a != null) || (g != null)))
    {
      if (c) {
        return b(paramViewGroup, paramEdit1, b, paramEdit2, i);
      }
      return a(paramViewGroup, paramEdit1, b, paramEdit2, i);
    }
    return null;
  }
  
  public String[] getTransitionProperties()
  {
    return suVersion;
  }
  
  public boolean isTransitionRequired(Edit paramEdit1, Edit paramEdit2)
  {
    if ((paramEdit1 == null) && (paramEdit2 == null)) {
      return false;
    }
    if ((paramEdit1 != null) && (paramEdit2 != null) && (values.containsKey("android:visibility:visibility") != values.containsKey("android:visibility:visibility"))) {
      return false;
    }
    paramEdit1 = a(paramEdit1, paramEdit2);
    return (l) && ((b == 0) || (i == 0));
  }
  
  public int next()
  {
    return type;
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    return null;
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    return null;
  }
  
  private static class a
    extends AnimatorListenerAdapter
    implements Transition.e, MethodVisitor
  {
    public final ViewGroup a;
    public boolean d;
    public boolean mIsVisible = false;
    public final int mPosition;
    public final View mView;
    public final boolean o;
    
    public a(View paramView, int paramInt, boolean paramBoolean)
    {
      mView = paramView;
      mPosition = paramInt;
      a = ((ViewGroup)paramView.getParent());
      o = paramBoolean;
      b(true);
    }
    
    private void b(boolean paramBoolean)
    {
      if ((o) && (d != paramBoolean))
      {
        ViewGroup localViewGroup = a;
        if (localViewGroup != null)
        {
          d = paramBoolean;
          int i = Build.VERSION.SDK_INT;
          MethodWriter.a(localViewGroup, paramBoolean);
        }
      }
    }
    
    private void close()
    {
      if (!mIsVisible)
      {
        Frame.set(mView, mPosition);
        ViewGroup localViewGroup = a;
        if (localViewGroup != null) {
          localViewGroup.invalidate();
        }
      }
      b(false);
    }
    
    public void a(Transition paramTransition)
    {
      close();
      paramTransition.removeListener(this);
    }
    
    public void b(Transition paramTransition)
    {
      b(false);
    }
    
    public void c(Transition paramTransition)
    {
      b(true);
    }
    
    public void d(Transition paramTransition) {}
    
    public void e(Transition paramTransition) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      mIsVisible = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      close();
    }
    
    public void onAnimationPause(Animator paramAnimator)
    {
      if (!mIsVisible) {
        Frame.set(mView, mPosition);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationResume(Animator paramAnimator)
    {
      if (!mIsVisible) {
        Frame.set(mView, 0);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface b {}
  
  private static class c
  {
    public ViewGroup a;
    public int b;
    public boolean c;
    public ViewGroup g;
    public int i;
    public boolean l;
    
    public c() {}
  }
}
