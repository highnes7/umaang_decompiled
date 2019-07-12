package android.support.design.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.ThemeEnforcement;
import android.support.design.internal.ViewUtils;
import android.support.design.resources.MaterialResources;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatBackgroundHelper;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import b.b.a.G;
import b.b.a.I;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.view.ViewCompat;
import support.android.v4.widget.f;

public class MaterialButton
  extends AppCompatButton
{
  public static final int ICON_GRAVITY_START = 1;
  public static final int ICON_GRAVITY_TEXT_START = 2;
  public static final String LOG_TAG = "MaterialButton";
  public Drawable icon;
  public int iconGravity;
  @I
  public int iconLeft;
  @I
  public int iconPadding;
  @I
  public int iconSize;
  public ColorStateList iconTint;
  public PorterDuff.Mode iconTintMode;
  @G
  public final MaterialButtonHelper materialButtonHelper;
  
  public MaterialButton(Context paramContext)
  {
    this(paramContext, null, R.attr.materialButtonStyle);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialButtonStyle);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.MaterialButton, paramInt, R.style.Widget_MaterialComponents_Button, new int[0]);
    iconPadding = paramContext.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
    iconTintMode = ViewUtils.parseTintMode(paramContext.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    iconTint = MaterialResources.getColorStateList(getContext(), paramContext, R.styleable.MaterialButton_iconTint);
    icon = MaterialResources.getDrawable(getContext(), paramContext, R.styleable.MaterialButton_icon);
    iconGravity = paramContext.getInteger(R.styleable.MaterialButton_iconGravity, 1);
    iconSize = paramContext.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
    materialButtonHelper = new MaterialButtonHelper(this);
    materialButtonHelper.loadFromAttributes(paramContext);
    paramContext.recycle();
    setCompoundDrawablePadding(iconPadding);
    updateIcon();
  }
  
  private boolean isLayoutRTL()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  private boolean isUsingOriginalBackground()
  {
    MaterialButtonHelper localMaterialButtonHelper = materialButtonHelper;
    return (localMaterialButtonHelper != null) && (!localMaterialButtonHelper.isBackgroundOverwritten());
  }
  
  private void updateIcon()
  {
    Object localObject = icon;
    if (localObject != null)
    {
      icon = ((Drawable)localObject).mutate();
      DrawableCompat.setTintList(icon, iconTint);
      localObject = iconTintMode;
      if (localObject != null) {
        DrawableCompat.setTintMode(icon, (PorterDuff.Mode)localObject);
      }
      int i = iconSize;
      if (i == 0) {
        i = icon.getIntrinsicWidth();
      }
      int j = iconSize;
      if (j == 0) {
        j = icon.getIntrinsicHeight();
      }
      localObject = icon;
      int k = iconLeft;
      ((Drawable)localObject).setBounds(k, 0, i + k, j);
    }
    f.setCompoundDrawablesRelative(this, icon, null, null, null);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius()
  {
    if (isUsingOriginalBackground()) {
      return materialButtonHelper.getCornerRadius();
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return icon;
  }
  
  public int getIconGravity()
  {
    return iconGravity;
  }
  
  public int getIconPadding()
  {
    return iconPadding;
  }
  
  public int getIconSize()
  {
    return iconSize;
  }
  
  public ColorStateList getIconTint()
  {
    return iconTint;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return iconTintMode;
  }
  
  public ColorStateList getRippleColor()
  {
    if (isUsingOriginalBackground()) {
      return materialButtonHelper.getRippleColor();
    }
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    if (isUsingOriginalBackground()) {
      return materialButtonHelper.getStrokeColor();
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (isUsingOriginalBackground()) {
      return materialButtonHelper.getStrokeWidth();
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (isUsingOriginalBackground()) {
      return materialButtonHelper.getSupportBackgroundTintList();
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (isUsingOriginalBackground()) {
      return materialButtonHelper.getSupportBackgroundTintMode();
    }
    return super.getSupportBackgroundTintMode();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (isUsingOriginalBackground())) {
      materialButtonHelper.drawStroke(paramCanvas);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      MaterialButtonHelper localMaterialButtonHelper = materialButtonHelper;
      if (localMaterialButtonHelper != null) {
        localMaterialButtonHelper.updateMaskBounds(paramInt4 - paramInt2, paramInt3 - paramInt1);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (icon != null)
    {
      if (iconGravity != 2) {
        return;
      }
      int i = (int)getPaint().measureText(getText().toString());
      paramInt2 = iconSize;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = icon.getIntrinsicWidth();
      }
      paramInt2 = (getMeasuredWidth() - i - ViewCompat.getPaddingEnd(this) - paramInt1 - iconPadding - ViewCompat.getPaddingStart(this)) / 2;
      paramInt1 = paramInt2;
      if (isLayoutRTL()) {
        paramInt1 = -paramInt2;
      }
      if (iconLeft != paramInt1)
      {
        iconLeft = paramInt1;
        updateIcon();
      }
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (isUsingOriginalBackground())
    {
      materialButtonHelper.setBackgroundColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (isUsingOriginalBackground())
    {
      if (paramDrawable != getBackground())
      {
        materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(paramDrawable);
        return;
      }
      getBackground().setState(paramDrawable.getState());
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCornerRadius(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      materialButtonHelper.setCornerRadius(paramInt);
    }
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (icon != paramDrawable)
    {
      icon = paramDrawable;
      updateIcon();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    iconGravity = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (iconPadding != paramInt)
    {
      iconPadding = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (iconSize != paramInt)
      {
        iconSize = paramInt;
        updateIcon();
      }
    }
    else {
      throw new IllegalArgumentException("iconSize cannot be less than 0");
    }
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (iconTint != paramColorStateList)
    {
      iconTint = paramColorStateList;
      updateIcon();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (iconTintMode != paramMode)
    {
      iconTintMode = paramMode;
      updateIcon();
    }
  }
  
  public void setIconTintResource(int paramInt)
  {
    setIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (isUsingOriginalBackground()) {
      materialButtonHelper.setRippleColor(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (isUsingOriginalBackground()) {
      materialButtonHelper.setStrokeColor(paramColorStateList);
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      materialButtonHelper.setStrokeWidth(paramInt);
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (isUsingOriginalBackground())
    {
      materialButtonHelper.setSupportBackgroundTintList(paramColorStateList);
      return;
    }
    if (materialButtonHelper != null)
    {
      AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
      if (localAppCompatBackgroundHelper != null) {
        localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
      }
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (isUsingOriginalBackground())
    {
      materialButtonHelper.setSupportBackgroundTintMode(paramMode);
      return;
    }
    if (materialButtonHelper != null)
    {
      AppCompatBackgroundHelper localAppCompatBackgroundHelper = mBackgroundTintHelper;
      if (localAppCompatBackgroundHelper != null) {
        localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconGravity {}
}
