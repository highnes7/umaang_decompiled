package android.support.design.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.R.styleable;
import android.text.TextPaint;
import b.b.a.G;
import b.b.a.N;
import b.b.a.r;
import support.android.v4.content.asm.Config;
import support.android.v4.content.asm.Label;

@N({b.b.a.N.a.b})
public class TextAppearance
{
  public static final String TAG = "TextAppearance";
  public static final int TYPEFACE_MONOSPACE = 3;
  public static final int TYPEFACE_SANS = 1;
  public static final int TYPEFACE_SERIF = 2;
  @G
  public Typeface font;
  @G
  public final String fontFamily;
  @r
  public final int fontFamilyResourceId;
  public boolean fontResolved = false;
  @G
  public final ColorStateList shadowColor;
  public final float shadowDx;
  public final float shadowDy;
  public final float shadowRadius;
  public final boolean textAllCaps;
  @G
  public final ColorStateList textColor;
  @G
  public final ColorStateList textColorHint;
  @G
  public final ColorStateList textColorLink;
  public final float textSize;
  public final int textStyle;
  public final int typeface;
  
  public TextAppearance(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    textSize = localTypedArray.getDimension(R.styleable.TextAppearance_android_textSize, 0.0F);
    textColor = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColor);
    textColorHint = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorHint);
    textColorLink = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorLink);
    textStyle = localTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, 0);
    typeface = localTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
    paramInt = R.styleable.TextAppearance_fontFamily;
    int i = R.styleable.TextAppearance_android_fontFamily;
    if (!localTypedArray.hasValue(paramInt)) {
      paramInt = i;
    }
    fontFamilyResourceId = localTypedArray.getResourceId(paramInt, 0);
    fontFamily = localTypedArray.getString(paramInt);
    textAllCaps = localTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
    shadowColor = MaterialResources.getColorStateList(paramContext, localTypedArray, R.styleable.TextAppearance_android_shadowColor);
    shadowDx = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    shadowDy = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    shadowRadius = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTypedArray.recycle();
  }
  
  private void createFallbackTypeface()
  {
    if (font == null) {
      font = Typeface.create(fontFamily, textStyle);
    }
    if (font == null)
    {
      int i = typeface;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            font = Typeface.DEFAULT;
          } else {
            font = Typeface.MONOSPACE;
          }
        }
        else {
          font = Typeface.SERIF;
        }
      }
      else {
        font = Typeface.SANS_SERIF;
      }
      Typeface localTypeface = font;
      if (localTypeface != null) {
        font = Typeface.create(localTypeface, textStyle);
      }
    }
  }
  
  public Typeface getFont(Context paramContext)
  {
    if (fontResolved) {
      return font;
    }
    int i;
    if (!paramContext.isRestricted()) {
      i = fontFamilyResourceId;
    }
    try
    {
      paramContext = Config.get(paramContext, i);
      font = paramContext;
      if (font == null) {
        break label86;
      }
      paramContext = font;
      i = textStyle;
      paramContext = Typeface.create(paramContext, i);
      font = paramContext;
    }
    catch (UnsupportedOperationException paramContext)
    {
      for (;;) {}
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error loading font ");
    paramContext.append(fontFamily);
    paramContext.toString();
    label86:
    createFallbackTypeface();
    fontResolved = true;
    return font;
  }
  
  public void getFontAsync(Context paramContext, final TextPaint paramTextPaint, final Label paramLabel)
  {
    if (fontResolved)
    {
      updateTextPaintMeasureState(paramTextPaint, font);
      return;
    }
    createFallbackTypeface();
    if (paramContext.isRestricted())
    {
      fontResolved = true;
      updateTextPaintMeasureState(paramTextPaint, font);
      return;
    }
    int i = fontFamilyResourceId;
    try
    {
      Config.init(paramContext, i, new Label()
      {
        public void onFontRetrievalFailed(int paramAnonymousInt)
        {
          TextAppearance.access$200(TextAppearance.this);
          TextAppearance.access$102(TextAppearance.this, true);
          paramLabel.onFontRetrievalFailed(paramAnonymousInt);
        }
        
        public void onFontRetrieved(Typeface paramAnonymousTypeface)
        {
          TextAppearance localTextAppearance = TextAppearance.this;
          TextAppearance.access$002(localTextAppearance, Typeface.create(paramAnonymousTypeface, textStyle));
          updateTextPaintMeasureState(paramTextPaint, paramAnonymousTypeface);
          TextAppearance.access$102(TextAppearance.this, true);
          paramLabel.onFontRetrieved(paramAnonymousTypeface);
        }
      }, null);
      return;
    }
    catch (UnsupportedOperationException paramContext)
    {
      return;
    }
    catch (Resources.NotFoundException paramContext)
    {
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error loading font ");
    paramContext.append(fontFamily);
    paramContext.toString();
  }
  
  public void updateDrawState(Context paramContext, TextPaint paramTextPaint, Label paramLabel)
  {
    updateMeasureState(paramContext, paramTextPaint, paramLabel);
    paramContext = textColor;
    int i;
    if (paramContext != null) {
      i = paramContext.getColorForState(drawableState, paramContext.getDefaultColor());
    } else {
      i = -16777216;
    }
    paramTextPaint.setColor(i);
    float f1 = shadowRadius;
    float f2 = shadowDx;
    float f3 = shadowDy;
    paramContext = shadowColor;
    if (paramContext != null) {
      i = paramContext.getColorForState(drawableState, paramContext.getDefaultColor());
    } else {
      i = 0;
    }
    paramTextPaint.setShadowLayer(f1, f2, f3, i);
  }
  
  public void updateMeasureState(Context paramContext, TextPaint paramTextPaint, Label paramLabel)
  {
    if (TextAppearanceConfig.shouldLoadFontSynchronously)
    {
      updateTextPaintMeasureState(paramTextPaint, getFont(paramContext));
      return;
    }
    getFontAsync(paramContext, paramTextPaint, paramLabel);
    if (!fontResolved) {
      updateTextPaintMeasureState(paramTextPaint, font);
    }
  }
  
  public void updateTextPaintMeasureState(TextPaint paramTextPaint, Typeface paramTypeface)
  {
    paramTextPaint.setTypeface(paramTypeface);
    int i = textStyle;
    i = paramTypeface.getStyle() & i;
    boolean bool;
    if ((i & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramTextPaint.setFakeBoldText(bool);
    float f;
    if ((i & 0x2) != 0) {
      f = -0.25F;
    } else {
      f = 0.0F;
    }
    paramTextPaint.setTextSkewX(f);
    paramTextPaint.setTextSize(textSize);
  }
}
