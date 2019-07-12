package com.google.android.android.common;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.android.R.styleable;
import com.google.android.android.common.internal.zzbw;
import com.google.android.android.common.internal.zzbx;
import com.google.android.android.common.package_9.Scope;
import com.google.android.android.dynamic.InvalidPatternException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton
  extends FrameLayout
  implements View.OnClickListener
{
  public static final int COLOR_AUTO = 2;
  public static final int COLOR_DARK = 0;
  public static final int COLOR_LIGHT = 1;
  public static final int SIZE_ICON_ONLY = 2;
  public static final int SIZE_STANDARD = 0;
  public static final int SIZE_WIDE = 1;
  public int mColor;
  public int mSize;
  public View zzfgd;
  public View.OnClickListener zzfge = null;
  
  public SignInButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SignInButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.SignInButton, 0, 0);
    try
    {
      mSize = paramContext.getInt(R.styleable.SignInButton_buttonSize, 0);
      mColor = paramContext.getInt(R.styleable.SignInButton_colorScheme, 2);
      paramContext.recycle();
      setStyle(mSize, mColor);
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  public final void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = zzfge;
    if ((localOnClickListener != null) && (paramView == zzfgd)) {
      localOnClickListener.onClick(this);
    }
  }
  
  public final void setColorScheme(int paramInt)
  {
    setStyle(mSize, paramInt);
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    zzfgd.setEnabled(paramBoolean);
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzfge = paramOnClickListener;
    paramOnClickListener = zzfgd;
    if (paramOnClickListener != null) {
      paramOnClickListener.setOnClickListener(this);
    }
  }
  
  public final void setScopes(Scope[] paramArrayOfScope)
  {
    setStyle(mSize, mColor);
  }
  
  public final void setSize(int paramInt)
  {
    setStyle(paramInt, mColor);
  }
  
  public final void setStyle(int paramInt1, int paramInt2)
  {
    mSize = paramInt1;
    mColor = paramInt2;
    Context localContext = getContext();
    Object localObject = zzfgd;
    if (localObject != null) {
      removeView((View)localObject);
    }
    paramInt1 = mSize;
    paramInt2 = mColor;
    try
    {
      localObject = zzbw.build(localContext, paramInt1, paramInt2);
      zzfgd = ((View)localObject);
    }
    catch (InvalidPatternException localInvalidPatternException)
    {
      for (;;) {}
    }
    paramInt1 = mSize;
    paramInt2 = mColor;
    localObject = new zzbx(localContext);
    ((zzbx)localObject).init(localContext.getResources(), paramInt1, paramInt2);
    zzfgd = ((View)localObject);
    addView(zzfgd);
    zzfgd.setEnabled(isEnabled());
    zzfgd.setOnClickListener(this);
  }
  
  public final void setStyle(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    setStyle(paramInt1, paramInt2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public @interface ButtonSize {}
  
  @Retention(RetentionPolicy.SOURCE)
  public @interface ColorScheme {}
}
