package com.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.package_7.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsLogger;

public abstract class FacebookButtonBase
  extends Button
{
  public String analyticsButtonCreatedEventName;
  public String analyticsButtonTappedEventName;
  public View.OnClickListener externalOnClickListener;
  public View.OnClickListener internalOnClickListener;
  public boolean overrideCompoundPadding;
  public int overrideCompoundPaddingLeft;
  public int overrideCompoundPaddingRight;
  public Fragment parentFragment;
  
  public FacebookButtonBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    super(paramContext, paramAttributeSet, 0);
    int i = paramInt2;
    if (paramInt2 == 0) {
      i = getDefaultStyleResource();
    }
    paramInt2 = i;
    if (i == 0) {
      paramInt2 = R.style.com_facebook_button;
    }
    configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    analyticsButtonCreatedEventName = paramString1;
    analyticsButtonTappedEventName = paramString2;
  }
  
  private void logButtonCreated(Context paramContext)
  {
    AppEventsLogger.newLogger(paramContext).logSdkEvent(analyticsButtonCreatedEventName, null, null);
  }
  
  private void logButtonTapped(Context paramContext)
  {
    AppEventsLogger.newLogger(paramContext).logSdkEvent(analyticsButtonTappedEventName, null, null);
  }
  
  private void parseBackgroundAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (isInEditMode()) {
      return;
    }
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16842964 }, paramInt1, paramInt2);
    try
    {
      boolean bool = paramContext.hasValue(0);
      if (bool)
      {
        paramInt1 = paramContext.getResourceId(0, 0);
        if (paramInt1 != 0) {
          setBackgroundResource(paramInt1);
        } else {
          setBackgroundColor(paramContext.getColor(0, 0));
        }
      }
      else
      {
        setBackgroundColor(paramContext.getColor(0, R.color.com_facebook_blue));
      }
      paramContext.recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  private void parseCompoundDrawableAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16843119, 16843117, 16843120, 16843118, 16843121 }, paramInt1, paramInt2);
    try
    {
      setCompoundDrawablesWithIntrinsicBounds(paramContext.getResourceId(0, 0), paramContext.getResourceId(1, 0), paramContext.getResourceId(2, 0), paramContext.getResourceId(3, 0));
      setCompoundDrawablePadding(paramContext.getDimensionPixelSize(4, 0));
      paramContext.recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  private void parseContentAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, new int[] { 16842966, 16842967, 16842968, 16842969 }, paramInt1, paramInt2);
    try
    {
      setPadding(paramContext.getDimensionPixelSize(0, 0), paramContext.getDimensionPixelSize(1, 0), paramContext.getDimensionPixelSize(2, 0), paramContext.getDimensionPixelSize(3, 0));
      paramContext.recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  /* Error */
  private void parseTextAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 81	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   4: aload_2
    //   5: iconst_1
    //   6: newarray int
    //   8: dup
    //   9: iconst_0
    //   10: ldc -111
    //   12: iastore
    //   13: iload_3
    //   14: iload 4
    //   16: invokevirtual 88	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   19: astore 5
    //   21: aload_0
    //   22: aload 5
    //   24: iconst_0
    //   25: iconst_m1
    //   26: invokevirtual 105	android/content/res/TypedArray:getColor	(II)I
    //   29: invokevirtual 148	android/widget/TextView:setTextColor	(I)V
    //   32: aload 5
    //   34: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   37: aload_1
    //   38: invokevirtual 81	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   41: aload_2
    //   42: iconst_1
    //   43: newarray int
    //   45: dup
    //   46: iconst_0
    //   47: ldc -107
    //   49: iastore
    //   50: iload_3
    //   51: iload 4
    //   53: invokevirtual 88	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   56: astore 5
    //   58: aload_0
    //   59: aload 5
    //   61: iconst_0
    //   62: bipush 17
    //   64: invokevirtual 152	android/content/res/TypedArray:getInt	(II)I
    //   67: invokevirtual 155	android/widget/TextView:setGravity	(I)V
    //   70: aload 5
    //   72: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   75: aload_1
    //   76: invokevirtual 81	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   79: aload_2
    //   80: iconst_3
    //   81: newarray int
    //   83: dup
    //   84: iconst_0
    //   85: ldc -100
    //   87: iastore
    //   88: dup
    //   89: iconst_1
    //   90: ldc -99
    //   92: iastore
    //   93: dup
    //   94: iconst_2
    //   95: ldc -98
    //   97: iastore
    //   98: iload_3
    //   99: iload 4
    //   101: invokevirtual 88	android/content/res/Resources$Theme:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   104: astore_1
    //   105: aload_0
    //   106: iconst_0
    //   107: aload_1
    //   108: iconst_0
    //   109: iconst_0
    //   110: invokevirtual 132	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   113: i2f
    //   114: invokevirtual 162	android/widget/TextView:setTextSize	(IF)V
    //   117: aload_0
    //   118: aload_1
    //   119: iconst_1
    //   120: iconst_1
    //   121: invokevirtual 152	android/content/res/TypedArray:getInt	(II)I
    //   124: invokestatic 168	android/graphics/Typeface:defaultFromStyle	(I)Landroid/graphics/Typeface;
    //   127: invokevirtual 172	android/widget/TextView:setTypeface	(Landroid/graphics/Typeface;)V
    //   130: aload_0
    //   131: aload_1
    //   132: iconst_2
    //   133: invokevirtual 176	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   136: invokevirtual 180	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   139: aload_1
    //   140: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   143: return
    //   144: astore_2
    //   145: aload_1
    //   146: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: aload 5
    //   154: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload 5
    //   162: invokevirtual 117	android/content/res/TypedArray:recycle	()V
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	FacebookButtonBase
    //   0	167	1	paramContext	Context
    //   0	167	2	paramAttributeSet	AttributeSet
    //   0	167	3	paramInt1	int
    //   0	167	4	paramInt2	int
    //   19	142	5	localTypedArray	TypedArray
    // Exception table:
    //   from	to	target	type
    //   105	139	144	java/lang/Throwable
    //   58	70	151	java/lang/Throwable
    //   21	32	159	java/lang/Throwable
  }
  
  private void setupOnClickListener()
  {
    super.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FacebookButtonBase localFacebookButtonBase = FacebookButtonBase.this;
        FacebookButtonBase.access$000(localFacebookButtonBase, localFacebookButtonBase.getContext());
        if (FacebookButtonBase.access$100(FacebookButtonBase.this) != null)
        {
          FacebookButtonBase.access$100(FacebookButtonBase.this).onClick(paramAnonymousView);
          return;
        }
        if (FacebookButtonBase.access$200(FacebookButtonBase.this) != null) {
          FacebookButtonBase.access$200(FacebookButtonBase.this).onClick(paramAnonymousView);
        }
      }
    });
  }
  
  public void callExternalOnClickListener(View paramView)
  {
    View.OnClickListener localOnClickListener = externalOnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
  }
  
  public void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    parseBackgroundAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseCompoundDrawableAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseContentAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    parseTextAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setupOnClickListener();
  }
  
  public Activity getActivity()
  {
    boolean bool;
    for (Object localObject = getContext();; localObject = ((ContextWrapper)localObject).getBaseContext())
    {
      bool = localObject instanceof Activity;
      if ((bool) || (!(localObject instanceof ContextWrapper))) {
        break;
      }
    }
    if (bool) {
      return (Activity)localObject;
    }
    localObject = new FacebookException("Unable to get Activity.");
    throw ((Throwable)localObject);
  }
  
  public int getCompoundPaddingLeft()
  {
    if (overrideCompoundPadding) {
      return overrideCompoundPaddingLeft;
    }
    return super.getCompoundPaddingLeft();
  }
  
  public int getCompoundPaddingRight()
  {
    if (overrideCompoundPadding) {
      return overrideCompoundPaddingRight;
    }
    return super.getCompoundPaddingRight();
  }
  
  public abstract int getDefaultRequestCode();
  
  public int getDefaultStyleResource()
  {
    return 0;
  }
  
  public Fragment getFragment()
  {
    return parentFragment;
  }
  
  public int getRequestCode()
  {
    return getDefaultRequestCode();
  }
  
  public int measureTextWidth(String paramString)
  {
    return (int)Math.ceil(getPaint().measureText(paramString));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      logButtonCreated(getContext());
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i;
    if ((getGravity() & 0x1) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = getCompoundPaddingLeft();
      int j = getCompoundPaddingRight();
      int k = getCompoundDrawablePadding();
      k = Math.min((getWidth() - (k + i) - j - measureTextWidth(getText().toString())) / 2, (i - getPaddingLeft()) / 2);
      overrideCompoundPaddingLeft = (i - k);
      overrideCompoundPaddingRight = (j + k);
      overrideCompoundPadding = true;
    }
    super.onDraw(paramCanvas);
    overrideCompoundPadding = false;
  }
  
  public void setFragment(Fragment paramFragment)
  {
    parentFragment = paramFragment;
  }
  
  public void setInternalOnClickListener(View.OnClickListener paramOnClickListener)
  {
    internalOnClickListener = paramOnClickListener;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    externalOnClickListener = paramOnClickListener;
  }
}
