package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import support.android.asm.AppCompatDelegateImplV7.PanelFeatureState.SavedState.1;
import support.android.asm.Edit;
import support.android.asm.FlurryAdSize;
import support.android.asm.Plot;
import support.android.asm.R.styleable;
import support.android.asm.TranslationAnimationCreator;
import support.android.asm.ViewCompat.BaseViewCompatImpl;
import support.android.asm.ViewCompat.HCViewCompatImpl;
import support.android.asm.j;
import support.android.asm.r;
import support.android.v4.content.asm.TypedArrayUtils;

public class Slide
  extends Visibility
{
  public static final a M;
  public static final a h;
  public static final a left = new ViewCompat.HCViewCompatImpl();
  public static final a p;
  public static final TimeInterpolator sAccelerate;
  public static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
  public static final a t;
  public static final String text = "android:slide:screenPosition";
  public static final a y;
  public int b = 80;
  public a x = left;
  
  static
  {
    sAccelerate = new AccelerateInterpolator();
    h = new j();
    y = new AppCompatDelegateImplV7.PanelFeatureState.SavedState.1();
    M = new ViewCompat.BaseViewCompatImpl();
    t = new FlurryAdSize();
    p = new r();
  }
  
  public Slide()
  {
    init(80);
  }
  
  public Slide(int paramInt)
  {
    init(paramInt);
  }
  
  public Slide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View);
    int i = TypedArrayUtils.getString(paramContext, (XmlPullParser)paramAttributeSet, "slideEdge", 0, 80);
    paramContext.recycle();
    init(i);
  }
  
  private void captureValues(Edit paramEdit)
  {
    View localView = view;
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    values.put("android:slide:screenPosition", arrayOfInt);
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    super.captureEndValues(paramEdit);
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    super.captureStartValues(paramEdit);
    captureValues(paramEdit);
  }
  
  public int getShowcaseY()
  {
    return b;
  }
  
  public void init(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 48)
        {
          if (paramInt != 80)
          {
            if (paramInt != 8388611)
            {
              if (paramInt == 8388613) {
                x = p;
              } else {
                throw new IllegalArgumentException("Invalid slide direction");
              }
            }
            else {
              x = y;
            }
          }
          else {
            x = left;
          }
        }
        else {
          x = M;
        }
      }
      else {
        x = t;
      }
    }
    else {
      x = h;
    }
    b = paramInt;
    Plot localPlot = new Plot();
    localPlot.setParent(paramInt);
    setPropagation(localPlot);
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    if (paramEdit2 == null) {
      return null;
    }
    paramEdit1 = (int[])values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = x.a(paramViewGroup, paramView);
    float f4 = x.getTranslationY(paramViewGroup, paramView);
    return TranslationAnimationCreator.createAnimation(paramView, paramEdit2, paramEdit1[0], paramEdit1[1], f3, f4, f1, f2, sDecelerate);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, Edit paramEdit1, Edit paramEdit2)
  {
    if (paramEdit1 == null) {
      return null;
    }
    paramEdit2 = (int[])values.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = x.a(paramViewGroup, paramView);
    float f4 = x.getTranslationY(paramViewGroup, paramView);
    return TranslationAnimationCreator.createAnimation(paramView, paramEdit1, paramEdit2[0], paramEdit2[1], f1, f2, f3, f4, sAccelerate);
  }
  
  private static abstract interface a
  {
    public abstract float a(ViewGroup paramViewGroup, View paramView);
    
    public abstract float getTranslationY(ViewGroup paramViewGroup, View paramView);
  }
  
  private static abstract class b
    implements Slide.a
  {
    public b() {}
    
    public float getTranslationY(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationY();
    }
  }
  
  private static abstract class c
    implements Slide.a
  {
    public c() {}
    
    public float a(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationX();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface d {}
}
