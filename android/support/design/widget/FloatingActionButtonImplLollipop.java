package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.ripple.RippleUtils;
import android.view.View;
import b.b.a.K;
import java.util.ArrayList;
import java.util.List;
import support.android.v4.internal.drawable.DrawableCompat;

@K(21)
public class FloatingActionButtonImplLollipop
  extends FloatingActionButtonImpl
{
  public InsetDrawable insetDrawable;
  
  public FloatingActionButtonImplLollipop(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
  }
  
  private Animator createElevationAnimator(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(view, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
    return localAnimatorSet;
  }
  
  public float getElevation()
  {
    return view.getElevation();
  }
  
  public void getPadding(Rect paramRect)
  {
    if (shadowViewDelegate.isCompatPaddingEnabled())
    {
      float f1 = shadowViewDelegate.getRadius();
      float f2 = getElevation() + pressedTranslationZ;
      int i = (int)Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(f2, f1, false));
      int j = (int)Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(f2, f1, false));
      paramRect.set(i, j, i, j);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  public void jumpDrawableToCurrentState() {}
  
  public CircularBorderDrawable newCircularDrawable()
  {
    return new CircularBorderDrawableLollipop();
  }
  
  public GradientDrawable newGradientDrawableForShape()
  {
    return new AlwaysStatefulGradientDrawable();
  }
  
  public void onCompatShadowChanged()
  {
    updatePadding();
  }
  
  public void onDrawableStateChanged(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (view.isEnabled())
      {
        view.setElevation(elevation);
        if (view.isPressed())
        {
          view.setTranslationZ(pressedTranslationZ);
          return;
        }
        if ((!view.isFocused()) && (!view.isHovered()))
        {
          view.setTranslationZ(0.0F);
          return;
        }
        view.setTranslationZ(hoveredFocusedTranslationZ);
        return;
      }
      view.setElevation(0.0F);
      view.setTranslationZ(0.0F);
    }
  }
  
  public void onElevationsChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      view.refreshDrawableState();
    }
    else
    {
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat3));
      localStateListAnimator.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat2));
      localStateListAnimator.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat2));
      localStateListAnimator.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(view, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      int i = Build.VERSION.SDK_INT;
      if ((i >= 22) && (i <= 24))
      {
        VisibilityAwareImageButton localVisibilityAwareImageButton = view;
        localArrayList.add(ObjectAnimator.ofFloat(localVisibilityAwareImageButton, View.TRANSLATION_Z, new float[] { localVisibilityAwareImageButton.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
      localStateListAnimator.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, localAnimatorSet);
      localStateListAnimator.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0F, 0.0F));
      view.setStateListAnimator(localStateListAnimator);
    }
    if (shadowViewDelegate.isCompatPaddingEnabled()) {
      updatePadding();
    }
  }
  
  public void onPaddingUpdated(Rect paramRect)
  {
    if (shadowViewDelegate.isCompatPaddingEnabled())
    {
      insetDrawable = new InsetDrawable(rippleDrawable, left, top, right, bottom);
      shadowViewDelegate.setBackgroundDrawable(insetDrawable);
      return;
    }
    shadowViewDelegate.setBackgroundDrawable(rippleDrawable);
  }
  
  public boolean requirePreDrawListener()
  {
    return false;
  }
  
  public void setBackgroundDrawable(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = rippleDrawable;
    if ((localDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)localDrawable).setColor(RippleUtils.convertToRippleDrawableColor(paramColorStateList));
      return;
    }
    if (localDrawable != null) {
      DrawableCompat.setTintList(localDrawable, RippleUtils.convertToRippleDrawableColor(paramColorStateList));
    }
  }
  
  public static class AlwaysStatefulGradientDrawable
    extends GradientDrawable
  {
    public AlwaysStatefulGradientDrawable() {}
    
    public boolean isStateful()
    {
      return true;
    }
  }
}
