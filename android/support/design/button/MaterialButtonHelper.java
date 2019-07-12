package android.support.design.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.R.styleable;
import android.support.design.internal.ViewUtils;
import android.support.design.resources.MaterialResources;
import android.support.design.ripple.RippleUtils;
import android.view.View;
import b.b.a.G;
import b.b.a.N;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.view.ViewCompat;

@N({b.b.a.N.a.b})
public class MaterialButtonHelper
{
  public static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5F;
  public static final int DEFAULT_BACKGROUND_COLOR = -1;
  public static final boolean IS_LOLLIPOP;
  @G
  public GradientDrawable backgroundDrawableLollipop;
  public boolean backgroundOverwritten = false;
  @G
  public ColorStateList backgroundTint;
  @G
  public PorterDuff.Mode backgroundTintMode;
  public final Rect bounds = new Rect();
  public final Paint buttonStrokePaint = new Paint(1);
  @G
  public GradientDrawable colorableBackgroundDrawableCompat;
  public int cornerRadius;
  public int insetBottom;
  public int insetLeft;
  public int insetRight;
  public int insetTop;
  @G
  public GradientDrawable maskDrawableLollipop;
  public final MaterialButton materialButton;
  public final RectF rectF = new RectF();
  @G
  public ColorStateList rippleColor;
  @G
  public GradientDrawable rippleDrawableCompat;
  @G
  public ColorStateList strokeColor;
  @G
  public GradientDrawable strokeDrawableLollipop;
  public int strokeWidth;
  @G
  public Drawable tintableBackgroundDrawableCompat;
  @G
  public Drawable tintableRippleDrawableCompat;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    IS_LOLLIPOP = bool;
  }
  
  public MaterialButtonHelper(MaterialButton paramMaterialButton)
  {
    materialButton = paramMaterialButton;
  }
  
  private Drawable createBackgroundCompat()
  {
    colorableBackgroundDrawableCompat = new GradientDrawable();
    colorableBackgroundDrawableCompat.setCornerRadius(cornerRadius + 1.0E-5F);
    colorableBackgroundDrawableCompat.setColor(-1);
    tintableBackgroundDrawableCompat = DrawableCompat.wrap(colorableBackgroundDrawableCompat);
    DrawableCompat.setTintList(tintableBackgroundDrawableCompat, backgroundTint);
    PorterDuff.Mode localMode = backgroundTintMode;
    if (localMode != null) {
      DrawableCompat.setTintMode(tintableBackgroundDrawableCompat, localMode);
    }
    rippleDrawableCompat = new GradientDrawable();
    rippleDrawableCompat.setCornerRadius(cornerRadius + 1.0E-5F);
    rippleDrawableCompat.setColor(-1);
    tintableRippleDrawableCompat = DrawableCompat.wrap(rippleDrawableCompat);
    DrawableCompat.setTintList(tintableRippleDrawableCompat, rippleColor);
    return wrapDrawableWithInset(new LayerDrawable(new Drawable[] { tintableBackgroundDrawableCompat, tintableRippleDrawableCompat }));
  }
  
  private Drawable createBackgroundLollipop()
  {
    backgroundDrawableLollipop = new GradientDrawable();
    backgroundDrawableLollipop.setCornerRadius(cornerRadius + 1.0E-5F);
    backgroundDrawableLollipop.setColor(-1);
    updateTintAndTintModeLollipop();
    strokeDrawableLollipop = new GradientDrawable();
    strokeDrawableLollipop.setCornerRadius(cornerRadius + 1.0E-5F);
    strokeDrawableLollipop.setColor(0);
    strokeDrawableLollipop.setStroke(strokeWidth, strokeColor);
    InsetDrawable localInsetDrawable = wrapDrawableWithInset(new LayerDrawable(new Drawable[] { backgroundDrawableLollipop, strokeDrawableLollipop }));
    maskDrawableLollipop = new GradientDrawable();
    maskDrawableLollipop.setCornerRadius(cornerRadius + 1.0E-5F);
    maskDrawableLollipop.setColor(-1);
    return (Drawable)new MaterialButtonBackgroundDrawable(RippleUtils.convertToRippleDrawableColor(rippleColor), localInsetDrawable, maskDrawableLollipop);
  }
  
  private GradientDrawable unwrapBackgroundDrawable()
  {
    if ((IS_LOLLIPOP) && (materialButton.getBackground() != null)) {
      return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }
    return null;
  }
  
  private GradientDrawable unwrapStrokeDrawable()
  {
    if ((IS_LOLLIPOP) && (materialButton.getBackground() != null)) {
      return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }
    return null;
  }
  
  private void updateStroke()
  {
    if ((IS_LOLLIPOP) && (strokeDrawableLollipop != null))
    {
      materialButton.setInternalBackground(createBackgroundLollipop());
      return;
    }
    if (!IS_LOLLIPOP) {
      materialButton.invalidate();
    }
  }
  
  private void updateTintAndTintModeLollipop()
  {
    Object localObject = backgroundDrawableLollipop;
    if (localObject != null)
    {
      DrawableCompat.setTintList((Drawable)localObject, backgroundTint);
      localObject = backgroundTintMode;
      if (localObject != null) {
        DrawableCompat.setTintMode(backgroundDrawableLollipop, (PorterDuff.Mode)localObject);
      }
    }
  }
  
  private InsetDrawable wrapDrawableWithInset(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, insetLeft, insetTop, insetRight, insetBottom);
  }
  
  public void drawStroke(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (strokeColor != null) && (strokeWidth > 0))
    {
      bounds.set(materialButton.getBackground().getBounds());
      RectF localRectF = rectF;
      Rect localRect = bounds;
      float f1 = left;
      int i = strokeWidth;
      float f2 = i / 2.0F;
      float f3 = insetLeft;
      float f4 = top;
      localRectF.set(f2 + f1 + f3, i / 2.0F + f4 + insetTop, right - i / 2.0F - insetRight, bottom - i / 2.0F - insetBottom);
      f1 = cornerRadius - strokeWidth / 2.0F;
      paramCanvas.drawRoundRect(rectF, f1, f1, buttonStrokePaint);
    }
  }
  
  public int getCornerRadius()
  {
    return cornerRadius;
  }
  
  public ColorStateList getRippleColor()
  {
    return rippleColor;
  }
  
  public ColorStateList getStrokeColor()
  {
    return strokeColor;
  }
  
  public int getStrokeWidth()
  {
    return strokeWidth;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    return backgroundTint;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return backgroundTintMode;
  }
  
  public boolean isBackgroundOverwritten()
  {
    return backgroundOverwritten;
  }
  
  public void loadFromAttributes(TypedArray paramTypedArray)
  {
    int j = R.styleable.MaterialButton_android_insetLeft;
    int i = 0;
    insetLeft = paramTypedArray.getDimensionPixelOffset(j, 0);
    insetRight = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    insetTop = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    insetBottom = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    cornerRadius = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
    strokeWidth = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    backgroundTintMode = ViewUtils.parseTintMode(paramTypedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    backgroundTint = MaterialResources.getColorStateList(materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_backgroundTint);
    strokeColor = MaterialResources.getColorStateList(materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_strokeColor);
    rippleColor = MaterialResources.getColorStateList(materialButton.getContext(), paramTypedArray, R.styleable.MaterialButton_rippleColor);
    buttonStrokePaint.setStyle(Paint.Style.STROKE);
    buttonStrokePaint.setStrokeWidth(strokeWidth);
    paramTypedArray = buttonStrokePaint;
    Object localObject = strokeColor;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(materialButton.getDrawableState(), 0);
    }
    paramTypedArray.setColor(i);
    i = ViewCompat.getPaddingStart(materialButton);
    j = materialButton.getPaddingTop();
    int k = ViewCompat.getPaddingEnd(materialButton);
    int m = materialButton.getPaddingBottom();
    localObject = materialButton;
    if (IS_LOLLIPOP) {
      paramTypedArray = createBackgroundLollipop();
    } else {
      paramTypedArray = createBackgroundCompat();
    }
    ((MaterialButton)localObject).setInternalBackground(paramTypedArray);
    ViewCompat.setPaddingRelative(materialButton, i + insetLeft, j + insetTop, k + insetRight, m + insetBottom);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    GradientDrawable localGradientDrawable;
    if (IS_LOLLIPOP)
    {
      localGradientDrawable = backgroundDrawableLollipop;
      if (localGradientDrawable != null)
      {
        localGradientDrawable.setColor(paramInt);
        return;
      }
    }
    if (!IS_LOLLIPOP)
    {
      localGradientDrawable = colorableBackgroundDrawableCompat;
      if (localGradientDrawable != null) {
        localGradientDrawable.setColor(paramInt);
      }
    }
  }
  
  public void setBackgroundOverwritten()
  {
    backgroundOverwritten = true;
    materialButton.setSupportBackgroundTintList(backgroundTint);
    materialButton.setSupportBackgroundTintMode(backgroundTintMode);
  }
  
  public void setCornerRadius(int paramInt)
  {
    if (cornerRadius != paramInt)
    {
      cornerRadius = paramInt;
      GradientDrawable localGradientDrawable;
      float f;
      if ((IS_LOLLIPOP) && (backgroundDrawableLollipop != null) && (strokeDrawableLollipop != null) && (maskDrawableLollipop != null))
      {
        if (Build.VERSION.SDK_INT == 21)
        {
          localGradientDrawable = unwrapBackgroundDrawable();
          f = paramInt + 1.0E-5F;
          localGradientDrawable.setCornerRadius(f);
          unwrapStrokeDrawable().setCornerRadius(f);
        }
        localGradientDrawable = backgroundDrawableLollipop;
        f = paramInt + 1.0E-5F;
        localGradientDrawable.setCornerRadius(f);
        strokeDrawableLollipop.setCornerRadius(f);
        maskDrawableLollipop.setCornerRadius(f);
        return;
      }
      if (!IS_LOLLIPOP)
      {
        localGradientDrawable = colorableBackgroundDrawableCompat;
        if ((localGradientDrawable != null) && (rippleDrawableCompat != null))
        {
          f = paramInt + 1.0E-5F;
          localGradientDrawable.setCornerRadius(f);
          rippleDrawableCompat.setCornerRadius(f);
          materialButton.invalidate();
        }
      }
    }
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (rippleColor != paramColorStateList)
    {
      rippleColor = paramColorStateList;
      if ((IS_LOLLIPOP) && ((materialButton.getBackground() instanceof RippleDrawable)))
      {
        ((RippleDrawable)materialButton.getBackground()).setColor(paramColorStateList);
        return;
      }
      if (!IS_LOLLIPOP)
      {
        Drawable localDrawable = tintableRippleDrawableCompat;
        if (localDrawable != null) {
          DrawableCompat.setTintList(localDrawable, paramColorStateList);
        }
      }
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (strokeColor != paramColorStateList)
    {
      strokeColor = paramColorStateList;
      Paint localPaint = buttonStrokePaint;
      int i = 0;
      if (paramColorStateList != null) {
        i = paramColorStateList.getColorForState(materialButton.getDrawableState(), 0);
      }
      localPaint.setColor(i);
      updateStroke();
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (strokeWidth != paramInt)
    {
      strokeWidth = paramInt;
      buttonStrokePaint.setStrokeWidth(paramInt);
      updateStroke();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (backgroundTint != paramColorStateList)
    {
      backgroundTint = paramColorStateList;
      if (IS_LOLLIPOP)
      {
        updateTintAndTintModeLollipop();
        return;
      }
      paramColorStateList = tintableBackgroundDrawableCompat;
      if (paramColorStateList != null) {
        DrawableCompat.setTintList(paramColorStateList, backgroundTint);
      }
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (backgroundTintMode != paramMode)
    {
      backgroundTintMode = paramMode;
      if (IS_LOLLIPOP)
      {
        updateTintAndTintModeLollipop();
        return;
      }
      paramMode = tintableBackgroundDrawableCompat;
      if (paramMode != null)
      {
        PorterDuff.Mode localMode = backgroundTintMode;
        if (localMode != null) {
          DrawableCompat.setTintMode(paramMode, localMode);
        }
      }
    }
  }
  
  public void updateMaskBounds(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = maskDrawableLollipop;
    if (localGradientDrawable != null) {
      localGradientDrawable.setBounds(insetLeft, insetTop, paramInt2 - insetRight, paramInt1 - insetBottom);
    }
  }
}
