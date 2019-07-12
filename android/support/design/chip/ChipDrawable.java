package android.support.design.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.animation.MotionSpec;
import android.support.design.canvas.CanvasCompat;
import android.support.design.drawable.DrawableUtils;
import android.support.design.internal.ThemeEnforcement;
import android.support.design.resources.MaterialResources;
import android.support.design.resources.TextAppearance;
import android.support.design.ripple.RippleUtils;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Xml;
import b.b.a.G;
import b.b.a.k;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.content.asm.Label;
import support.android.v4.internal.ColorUtils;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.internal.drawable.DrawableCompat.DrawableImpl;
import support.android.v4.text.BidiFormatter;

public class ChipDrawable
  extends Drawable
  implements DrawableCompat.DrawableImpl, Drawable.Callback
{
  public static final boolean DEBUG = false;
  public static final int[] DEFAULT_STATE = { 16842910 };
  public static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
  public int alpha = 255;
  public boolean checkable;
  @G
  public Drawable checkedIcon;
  public boolean checkedIconVisible;
  @G
  public ColorStateList chipBackgroundColor;
  public float chipCornerRadius;
  public float chipEndPadding;
  @G
  public Drawable chipIcon;
  public float chipIconSize;
  @G
  public ColorStateList chipIconTint;
  public boolean chipIconVisible;
  public float chipMinHeight;
  public final Paint chipPaint = new Paint(1);
  public float chipStartPadding;
  @G
  public ColorStateList chipStrokeColor;
  public float chipStrokeWidth;
  @G
  public Drawable closeIcon;
  @G
  public CharSequence closeIconContentDescription;
  public float closeIconEndPadding;
  public float closeIconSize;
  public float closeIconStartPadding;
  public int[] closeIconStateSet;
  @G
  public ColorStateList closeIconTint;
  public boolean closeIconVisible;
  @G
  public ColorFilter colorFilter;
  @G
  public ColorStateList compatRippleColor;
  public final Context context;
  public boolean currentChecked;
  @k
  public int currentChipBackgroundColor;
  @k
  public int currentChipStrokeColor;
  @k
  public int currentCompatRippleColor;
  @k
  public int currentTextColor;
  @k
  public int currentTint;
  @G
  public final Paint debugPaint;
  public WeakReference<Delegate> delegate = new WeakReference(null);
  public final Label fontCallback = new Label()
  {
    public void onFontRetrievalFailed(int paramAnonymousInt) {}
    
    public void onFontRetrieved(Typeface paramAnonymousTypeface)
    {
      ChipDrawable.access$002(ChipDrawable.this, true);
      onSizeChange();
      invalidateSelf();
    }
  };
  public final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
  @G
  public MotionSpec hideMotionSpec;
  public float iconEndPadding;
  public float iconStartPadding;
  public int maxWidth;
  public final PointF pointF = new PointF();
  @G
  public CharSequence rawText;
  public final RectF rectF = new RectF();
  @G
  public ColorStateList rippleColor;
  public boolean shouldDrawText;
  @G
  public MotionSpec showMotionSpec;
  @G
  public TextAppearance textAppearance;
  public float textEndPadding;
  public final TextPaint textPaint = new TextPaint(1);
  public float textStartPadding;
  public float textWidth;
  public boolean textWidthDirty = true;
  @G
  public ColorStateList tint;
  @G
  public PorterDuffColorFilter tintFilter;
  @G
  public PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
  public TextUtils.TruncateAt truncateAt;
  @G
  public CharSequence unicodeWrappedText;
  public boolean useCompatRipple;
  
  public ChipDrawable(Context paramContext)
  {
    context = paramContext;
    rawText = "";
    textPaint.density = getResourcesgetDisplayMetricsdensity;
    debugPaint = null;
    paramContext = debugPaint;
    if (paramContext != null) {
      paramContext.setStyle(Paint.Style.STROKE);
    }
    setState(DEFAULT_STATE);
    setCloseIconState(DEFAULT_STATE);
    shouldDrawText = true;
  }
  
  private void applyChildDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      DrawableCompat.setLayoutDirection(paramDrawable, DrawableCompat.getLayoutDirection(this));
      paramDrawable.setLevel(getLevel());
      paramDrawable.setVisible(isVisible(), false);
      if (paramDrawable == closeIcon)
      {
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getCloseIconState());
        }
        DrawableCompat.setTintList(paramDrawable, closeIconTint);
        return;
      }
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getState());
      }
    }
  }
  
  private void calculateChipIconBounds(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if ((showsChipIcon()) || (showsCheckedIcon()))
    {
      float f1 = chipStartPadding + iconStartPadding;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        left = (left + f1);
        right = (left + chipIconSize);
      }
      else
      {
        right = (right - f1);
        left = (right - chipIconSize);
      }
      f1 = paramRect.exactCenterY();
      float f2 = chipIconSize;
      top = (f1 - f2 / 2.0F);
      bottom = (top + f2);
    }
  }
  
  private void calculateChipTouchBounds(Rect paramRect, RectF paramRectF)
  {
    paramRectF.set(paramRect);
    if (showsCloseIcon())
    {
      float f = chipEndPadding + closeIconEndPadding + closeIconSize + closeIconStartPadding + textEndPadding;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        right = (right - f);
        return;
      }
      left = (left + f);
    }
  }
  
  private void calculateCloseIconBounds(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (showsCloseIcon())
    {
      float f1 = chipEndPadding + closeIconEndPadding;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        right = (right - f1);
        left = (right - closeIconSize);
      }
      else
      {
        left = (left + f1);
        right = (left + closeIconSize);
      }
      f1 = paramRect.exactCenterY();
      float f2 = closeIconSize;
      top = (f1 - f2 / 2.0F);
      bottom = (top + f2);
    }
  }
  
  private void calculateCloseIconTouchBounds(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (showsCloseIcon())
    {
      float f = chipEndPadding + closeIconEndPadding + closeIconSize + closeIconStartPadding + textEndPadding;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        right = right;
        left = (right - f);
      }
      else
      {
        int i = left;
        left = i;
        right = (i + f);
      }
      top = top;
      bottom = bottom;
    }
  }
  
  private float calculateCloseIconWidth()
  {
    if (showsCloseIcon()) {
      return closeIconStartPadding + closeIconSize + closeIconEndPadding;
    }
    return 0.0F;
  }
  
  private void calculateTextBounds(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (unicodeWrappedText != null)
    {
      float f1 = chipStartPadding;
      f1 = calculateChipIconWidth() + f1 + textStartPadding;
      float f2 = chipEndPadding + calculateCloseIconWidth() + textEndPadding;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        left = (left + f1);
        right = (right - f2);
      }
      else
      {
        left = (left + f2);
        right = (right - f1);
      }
      top = top;
      bottom = bottom;
    }
  }
  
  private float calculateTextCenterFromBaseline()
  {
    textPaint.getFontMetrics(fontMetrics);
    Paint.FontMetrics localFontMetrics = fontMetrics;
    return (descent + ascent) / 2.0F;
  }
  
  private float calculateTextWidth(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0.0F;
    }
    return textPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private boolean canShowCheckedIcon()
  {
    return (checkedIconVisible) && (checkedIcon != null) && (checkable);
  }
  
  public static ChipDrawable createFromAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = new ChipDrawable(paramContext);
    paramContext.loadFromAttributes(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  public static ChipDrawable createFromResource(Context paramContext, int paramInt)
  {
    try
    {
      localObject = paramContext.getResources().getXml(paramInt);
      int i;
      do
      {
        i = ((XmlPullParser)localObject).next();
      } while ((i != 2) && (i != 1));
      if (i == 2)
      {
        boolean bool = TextUtils.equals(((XmlPullParser)localObject).getName(), "chip");
        if (bool)
        {
          localObject = Xml.asAttributeSet((XmlPullParser)localObject);
          int j = ((AttributeSet)localObject).getStyleAttribute();
          i = j;
          if (j == 0) {
            i = R.style.Widget_MaterialComponents_Chip_Entry;
          }
          j = R.attr.chipStandaloneStyle;
          paramContext = createFromAttributes(paramContext, (AttributeSet)localObject, j, i);
          return paramContext;
        }
        paramContext = new XmlPullParserException("Must have a <chip> start tag");
        throw paramContext;
      }
      paramContext = new XmlPullParserException("No start tag found");
      throw paramContext;
    }
    catch (IOException paramContext) {}catch (XmlPullParserException paramContext) {}
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Can't load chip resource ID #0x");
    ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
    localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
    ((Exception)localObject).initCause(paramContext);
    throw ((Throwable)localObject);
  }
  
  private void drawCheckedIcon(Canvas paramCanvas, Rect paramRect)
  {
    if (showsCheckedIcon())
    {
      calculateChipIconBounds(paramRect, rectF);
      paramRect = rectF;
      float f1 = left;
      float f2 = top;
      paramCanvas.translate(f1, f2);
      checkedIcon.setBounds(0, 0, (int)rectF.width(), (int)rectF.height());
      checkedIcon.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void drawChipBackground(Canvas paramCanvas, Rect paramRect)
  {
    chipPaint.setColor(currentChipBackgroundColor);
    chipPaint.setStyle(Paint.Style.FILL);
    chipPaint.setColorFilter(getTintColorFilter());
    rectF.set(paramRect);
    paramRect = rectF;
    float f = chipCornerRadius;
    paramCanvas.drawRoundRect(paramRect, f, f, chipPaint);
  }
  
  private void drawChipIcon(Canvas paramCanvas, Rect paramRect)
  {
    if (showsChipIcon())
    {
      calculateChipIconBounds(paramRect, rectF);
      paramRect = rectF;
      float f1 = left;
      float f2 = top;
      paramCanvas.translate(f1, f2);
      chipIcon.setBounds(0, 0, (int)rectF.width(), (int)rectF.height());
      chipIcon.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void drawChipStroke(Canvas paramCanvas, Rect paramRect)
  {
    if (chipStrokeWidth > 0.0F)
    {
      chipPaint.setColor(currentChipStrokeColor);
      chipPaint.setStyle(Paint.Style.STROKE);
      chipPaint.setColorFilter(getTintColorFilter());
      RectF localRectF = rectF;
      float f1 = left;
      float f2 = chipStrokeWidth;
      float f3 = f2 / 2.0F;
      float f4 = top;
      localRectF.set(f3 + f1, f2 / 2.0F + f4, right - f2 / 2.0F, bottom - f2 / 2.0F);
      f1 = chipCornerRadius - chipStrokeWidth / 2.0F;
      paramCanvas.drawRoundRect(rectF, f1, f1, chipPaint);
    }
  }
  
  private void drawCloseIcon(Canvas paramCanvas, Rect paramRect)
  {
    if (showsCloseIcon())
    {
      calculateCloseIconBounds(paramRect, rectF);
      paramRect = rectF;
      float f1 = left;
      float f2 = top;
      paramCanvas.translate(f1, f2);
      closeIcon.setBounds(0, 0, (int)rectF.width(), (int)rectF.height());
      closeIcon.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void drawCompatRipple(Canvas paramCanvas, Rect paramRect)
  {
    chipPaint.setColor(currentCompatRippleColor);
    chipPaint.setStyle(Paint.Style.FILL);
    rectF.set(paramRect);
    paramRect = rectF;
    float f = chipCornerRadius;
    paramCanvas.drawRoundRect(paramRect, f, f, chipPaint);
  }
  
  private void drawDebug(Canvas paramCanvas, Rect paramRect)
  {
    Paint localPaint = debugPaint;
    if (localPaint != null)
    {
      localPaint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
      paramCanvas.drawRect(paramRect, debugPaint);
      if ((showsChipIcon()) || (showsCheckedIcon()))
      {
        calculateChipIconBounds(paramRect, rectF);
        paramCanvas.drawRect(rectF, debugPaint);
      }
      if (unicodeWrappedText != null) {
        paramCanvas.drawLine(left, paramRect.exactCenterY(), right, paramRect.exactCenterY(), debugPaint);
      }
      if (showsCloseIcon())
      {
        calculateCloseIconBounds(paramRect, rectF);
        paramCanvas.drawRect(rectF, debugPaint);
      }
      debugPaint.setColor(ColorUtils.setAlphaComponent(-65536, 127));
      calculateChipTouchBounds(paramRect, rectF);
      paramCanvas.drawRect(rectF, debugPaint);
      debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
      calculateCloseIconTouchBounds(paramRect, rectF);
      paramCanvas.drawRect(rectF, debugPaint);
    }
  }
  
  private void drawText(Canvas paramCanvas, Rect paramRect)
  {
    if (unicodeWrappedText != null)
    {
      Object localObject = calculateTextOriginAndAlignment(paramRect, pointF);
      calculateTextBounds(paramRect, rectF);
      if (textAppearance != null)
      {
        textPaint.drawableState = getState();
        textAppearance.updateDrawState(context, textPaint, fontCallback);
      }
      textPaint.setTextAlign((Paint.Align)localObject);
      int i = Math.round(getTextWidth());
      int k = Math.round(rectF.width());
      int j = 0;
      if (i > k) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        j = paramCanvas.save();
        paramCanvas.clipRect(rectF);
      }
      localObject = unicodeWrappedText;
      paramRect = (Rect)localObject;
      if (i != 0)
      {
        paramRect = (Rect)localObject;
        if (truncateAt != null) {
          paramRect = TextUtils.ellipsize((CharSequence)localObject, textPaint, rectF.width(), truncateAt);
        }
      }
      k = paramRect.length();
      localObject = pointF;
      paramCanvas.drawText(paramRect, 0, k, x, y, textPaint);
      if (i != 0) {
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  private float getTextWidth()
  {
    if (!textWidthDirty) {
      return textWidth;
    }
    textWidth = calculateTextWidth(unicodeWrappedText);
    textWidthDirty = false;
    return textWidth;
  }
  
  private ColorFilter getTintColorFilter()
  {
    ColorFilter localColorFilter = colorFilter;
    if (localColorFilter != null) {
      return localColorFilter;
    }
    return tintFilter;
  }
  
  public static boolean hasState(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isStateful(ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  public static boolean isStateful(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful());
  }
  
  public static boolean isStateful(TextAppearance paramTextAppearance)
  {
    if (paramTextAppearance != null)
    {
      paramTextAppearance = textColor;
      if ((paramTextAppearance != null) && (paramTextAppearance.isStateful())) {
        return true;
      }
    }
    return false;
  }
  
  private void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(context, paramAttributeSet, R.styleable.Chip, paramInt1, paramInt2, new int[0]);
    setChipBackgroundColor(MaterialResources.getColorStateList(context, localTypedArray, R.styleable.Chip_chipBackgroundColor));
    setChipMinHeight(localTypedArray.getDimension(R.styleable.Chip_chipMinHeight, 0.0F));
    setChipCornerRadius(localTypedArray.getDimension(R.styleable.Chip_chipCornerRadius, 0.0F));
    setChipStrokeColor(MaterialResources.getColorStateList(context, localTypedArray, R.styleable.Chip_chipStrokeColor));
    setChipStrokeWidth(localTypedArray.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0F));
    setRippleColor(MaterialResources.getColorStateList(context, localTypedArray, R.styleable.Chip_rippleColor));
    setText(localTypedArray.getText(R.styleable.Chip_android_text));
    setTextAppearance(MaterialResources.getTextAppearance(context, localTypedArray, R.styleable.Chip_android_textAppearance));
    paramInt1 = localTypedArray.getInt(R.styleable.Chip_android_ellipsize, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          setEllipsize(TextUtils.TruncateAt.END);
        }
      }
      else {
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
      }
    }
    else {
      setEllipsize(TextUtils.TruncateAt.START);
    }
    setChipIconVisible(localTypedArray.getBoolean(R.styleable.Chip_chipIconVisible, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
      setChipIconVisible(localTypedArray.getBoolean(R.styleable.Chip_chipIconEnabled, false));
    }
    setChipIcon(MaterialResources.getDrawable(context, localTypedArray, R.styleable.Chip_chipIcon));
    setChipIconTint(MaterialResources.getColorStateList(context, localTypedArray, R.styleable.Chip_chipIconTint));
    setChipIconSize(localTypedArray.getDimension(R.styleable.Chip_chipIconSize, 0.0F));
    setCloseIconVisible(localTypedArray.getBoolean(R.styleable.Chip_closeIconVisible, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
      setCloseIconVisible(localTypedArray.getBoolean(R.styleable.Chip_closeIconEnabled, false));
    }
    setCloseIcon(MaterialResources.getDrawable(context, localTypedArray, R.styleable.Chip_closeIcon));
    setCloseIconTint(MaterialResources.getColorStateList(context, localTypedArray, R.styleable.Chip_closeIconTint));
    setCloseIconSize(localTypedArray.getDimension(R.styleable.Chip_closeIconSize, 0.0F));
    setCheckable(localTypedArray.getBoolean(R.styleable.Chip_android_checkable, false));
    setCheckedIconVisible(localTypedArray.getBoolean(R.styleable.Chip_checkedIconVisible, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
      setCheckedIconVisible(localTypedArray.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
    }
    setCheckedIcon(MaterialResources.getDrawable(context, localTypedArray, R.styleable.Chip_checkedIcon));
    setShowMotionSpec(MotionSpec.createFromAttribute(context, localTypedArray, R.styleable.Chip_showMotionSpec));
    setHideMotionSpec(MotionSpec.createFromAttribute(context, localTypedArray, R.styleable.Chip_hideMotionSpec));
    setChipStartPadding(localTypedArray.getDimension(R.styleable.Chip_chipStartPadding, 0.0F));
    setIconStartPadding(localTypedArray.getDimension(R.styleable.Chip_iconStartPadding, 0.0F));
    setIconEndPadding(localTypedArray.getDimension(R.styleable.Chip_iconEndPadding, 0.0F));
    setTextStartPadding(localTypedArray.getDimension(R.styleable.Chip_textStartPadding, 0.0F));
    setTextEndPadding(localTypedArray.getDimension(R.styleable.Chip_textEndPadding, 0.0F));
    setCloseIconStartPadding(localTypedArray.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0F));
    setCloseIconEndPadding(localTypedArray.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0F));
    setChipEndPadding(localTypedArray.getDimension(R.styleable.Chip_chipEndPadding, 0.0F));
    setMaxWidth(localTypedArray.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
    localTypedArray.recycle();
  }
  
  private boolean onStateChange(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    Object localObject = chipBackgroundColor;
    int j = 0;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, currentChipBackgroundColor);
    } else {
      i = 0;
    }
    if (currentChipBackgroundColor != i)
    {
      currentChipBackgroundColor = i;
      bool1 = true;
    }
    localObject = chipStrokeColor;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, currentChipStrokeColor);
    } else {
      i = 0;
    }
    if (currentChipStrokeColor != i)
    {
      currentChipStrokeColor = i;
      bool1 = true;
    }
    localObject = compatRippleColor;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, currentCompatRippleColor);
    } else {
      i = 0;
    }
    boolean bool2 = bool1;
    if (currentCompatRippleColor != i)
    {
      currentCompatRippleColor = i;
      bool2 = bool1;
      if (useCompatRipple) {
        bool2 = true;
      }
    }
    localObject = textAppearance;
    if (localObject != null)
    {
      localObject = textColor;
      if (localObject != null)
      {
        i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, currentTextColor);
        break label207;
      }
    }
    int i = 0;
    label207:
    bool1 = bool2;
    if (currentTextColor != i)
    {
      currentTextColor = i;
      bool1 = true;
    }
    boolean bool3;
    if ((hasState(getState(), 16842912)) && (checkable)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    bool2 = bool1;
    if (currentChecked != bool3)
    {
      bool2 = bool1;
      if (checkedIcon != null)
      {
        float f = calculateChipIconWidth();
        currentChecked = bool3;
        if (f != calculateChipIconWidth())
        {
          bool2 = true;
          i = 1;
          break label317;
        }
        bool2 = true;
      }
    }
    i = 0;
    label317:
    localObject = tint;
    if (localObject != null) {
      j = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, currentTint);
    }
    if (currentTint != j)
    {
      currentTint = j;
      tintFilter = DrawableUtils.updateTintFilter(this, tint, tintMode);
      bool2 = true;
    }
    bool1 = bool2;
    if (isStateful(chipIcon)) {
      bool1 = bool2 | chipIcon.setState(paramArrayOfInt1);
    }
    bool2 = bool1;
    if (isStateful(checkedIcon)) {
      bool2 = bool1 | checkedIcon.setState(paramArrayOfInt1);
    }
    bool1 = bool2;
    if (isStateful(closeIcon)) {
      bool1 = bool2 | closeIcon.setState(paramArrayOfInt2);
    }
    if (bool1) {
      invalidateSelf();
    }
    if (i != 0) {
      onSizeChange();
    }
    return bool1;
  }
  
  private boolean showsCheckedIcon()
  {
    return (checkedIconVisible) && (checkedIcon != null) && (currentChecked);
  }
  
  private boolean showsChipIcon()
  {
    return (chipIconVisible) && (chipIcon != null);
  }
  
  private boolean showsCloseIcon()
  {
    return (closeIconVisible) && (closeIcon != null);
  }
  
  private void unapplyChildDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void updateCompatRippleColor()
  {
    ColorStateList localColorStateList;
    if (useCompatRipple) {
      localColorStateList = RippleUtils.convertToRippleDrawableColor(rippleColor);
    } else {
      localColorStateList = null;
    }
    compatRippleColor = localColorStateList;
  }
  
  public float calculateChipIconWidth()
  {
    if ((!showsChipIcon()) && (!showsCheckedIcon())) {
      return 0.0F;
    }
    return iconStartPadding + chipIconSize + iconEndPadding;
  }
  
  public Paint.Align calculateTextOriginAndAlignment(Rect paramRect, PointF paramPointF)
  {
    paramPointF.set(0.0F, 0.0F);
    Paint.Align localAlign = Paint.Align.LEFT;
    if (unicodeWrappedText != null)
    {
      float f = chipStartPadding;
      f = calculateChipIconWidth() + f + textStartPadding;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        x = (left + f);
        localAlign = Paint.Align.LEFT;
      }
      else
      {
        x = (right - f);
        localAlign = Paint.Align.RIGHT;
      }
      y = (paramRect.centerY() - calculateTextCenterFromBaseline());
    }
    return localAlign;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty())
    {
      if (getAlpha() == 0) {
        return;
      }
      int i = 0;
      int j = alpha;
      if (j < 255) {
        i = CanvasCompat.saveLayerAlpha(paramCanvas, left, top, right, bottom, j);
      }
      drawChipBackground(paramCanvas, localRect);
      drawChipStroke(paramCanvas, localRect);
      drawCompatRipple(paramCanvas, localRect);
      drawChipIcon(paramCanvas, localRect);
      drawCheckedIcon(paramCanvas, localRect);
      if (shouldDrawText) {
        drawText(paramCanvas, localRect);
      }
      drawCloseIcon(paramCanvas, localRect);
      drawDebug(paramCanvas, localRect);
      if (alpha < 255) {
        paramCanvas.restoreToCount(i);
      }
    }
  }
  
  public int getAlpha()
  {
    return alpha;
  }
  
  public Drawable getCheckedIcon()
  {
    return checkedIcon;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    return chipBackgroundColor;
  }
  
  public float getChipCornerRadius()
  {
    return chipCornerRadius;
  }
  
  public float getChipEndPadding()
  {
    return chipEndPadding;
  }
  
  public Drawable getChipIcon()
  {
    Drawable localDrawable = chipIcon;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    return chipIconSize;
  }
  
  public ColorStateList getChipIconTint()
  {
    return chipIconTint;
  }
  
  public float getChipMinHeight()
  {
    return chipMinHeight;
  }
  
  public float getChipStartPadding()
  {
    return chipStartPadding;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    return chipStrokeColor;
  }
  
  public float getChipStrokeWidth()
  {
    return chipStrokeWidth;
  }
  
  public void getChipTouchBounds(RectF paramRectF)
  {
    calculateChipTouchBounds(getBounds(), paramRectF);
  }
  
  public Drawable getCloseIcon()
  {
    Drawable localDrawable = closeIcon;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    return closeIconContentDescription;
  }
  
  public float getCloseIconEndPadding()
  {
    return closeIconEndPadding;
  }
  
  public float getCloseIconSize()
  {
    return closeIconSize;
  }
  
  public float getCloseIconStartPadding()
  {
    return closeIconStartPadding;
  }
  
  public int[] getCloseIconState()
  {
    return closeIconStateSet;
  }
  
  public ColorStateList getCloseIconTint()
  {
    return closeIconTint;
  }
  
  public void getCloseIconTouchBounds(RectF paramRectF)
  {
    calculateCloseIconTouchBounds(getBounds(), paramRectF);
  }
  
  public ColorFilter getColorFilter()
  {
    return colorFilter;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    return truncateAt;
  }
  
  public MotionSpec getHideMotionSpec()
  {
    return hideMotionSpec;
  }
  
  public float getIconEndPadding()
  {
    return iconEndPadding;
  }
  
  public float getIconStartPadding()
  {
    return iconStartPadding;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)chipMinHeight;
  }
  
  public int getIntrinsicWidth()
  {
    float f = chipStartPadding;
    return Math.min(Math.round(calculateChipIconWidth() + f + textStartPadding + getTextWidth() + textEndPadding + calculateCloseIconWidth() + chipEndPadding), maxWidth);
  }
  
  public int getMaxWidth()
  {
    return maxWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, chipCornerRadius);
    } else {
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), chipCornerRadius);
    }
    paramOutline.setAlpha(getAlpha() / 255.0F);
  }
  
  public ColorStateList getRippleColor()
  {
    return rippleColor;
  }
  
  public MotionSpec getShowMotionSpec()
  {
    return showMotionSpec;
  }
  
  public CharSequence getText()
  {
    return rawText;
  }
  
  public TextAppearance getTextAppearance()
  {
    return textAppearance;
  }
  
  public float getTextEndPadding()
  {
    return textEndPadding;
  }
  
  public float getTextStartPadding()
  {
    return textStartPadding;
  }
  
  public boolean getUseCompatRipple()
  {
    return useCompatRipple;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public boolean isCheckable()
  {
    return checkable;
  }
  
  public boolean isCheckedIconEnabled()
  {
    return isCheckedIconVisible();
  }
  
  public boolean isCheckedIconVisible()
  {
    return checkedIconVisible;
  }
  
  public boolean isChipIconEnabled()
  {
    return isChipIconVisible();
  }
  
  public boolean isChipIconVisible()
  {
    return chipIconVisible;
  }
  
  public boolean isCloseIconEnabled()
  {
    return isCloseIconVisible();
  }
  
  public boolean isCloseIconStateful()
  {
    return isStateful(closeIcon);
  }
  
  public boolean isCloseIconVisible()
  {
    return closeIconVisible;
  }
  
  public boolean isStateful()
  {
    return (isStateful(chipBackgroundColor)) || (isStateful(chipStrokeColor)) || ((useCompatRipple) && (isStateful(compatRippleColor))) || (isStateful(textAppearance)) || (canShowCheckedIcon()) || (isStateful(chipIcon)) || (isStateful(checkedIcon)) || (isStateful(tint));
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (showsChipIcon()) {
      bool1 = bool2 | chipIcon.setLayoutDirection(paramInt);
    }
    bool2 = bool1;
    if (showsCheckedIcon()) {
      bool2 = bool1 | checkedIcon.setLayoutDirection(paramInt);
    }
    bool1 = bool2;
    if (showsCloseIcon()) {
      bool1 = bool2 | closeIcon.setLayoutDirection(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return true;
  }
  
  public boolean onLevelChange(int paramInt)
  {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (showsChipIcon()) {
      bool1 = bool2 | chipIcon.setLevel(paramInt);
    }
    bool2 = bool1;
    if (showsCheckedIcon()) {
      bool2 = bool1 | checkedIcon.setLevel(paramInt);
    }
    bool1 = bool2;
    if (showsCloseIcon()) {
      bool1 = bool2 | closeIcon.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public void onSizeChange()
  {
    Delegate localDelegate = (Delegate)delegate.get();
    if (localDelegate != null) {
      localDelegate.onChipDrawableSizeChange();
    }
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return onStateChange(paramArrayOfInt, getCloseIconState());
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (alpha != paramInt)
    {
      alpha = paramInt;
      invalidateSelf();
    }
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (checkable != paramBoolean)
    {
      checkable = paramBoolean;
      float f1 = calculateChipIconWidth();
      if ((!paramBoolean) && (currentChecked)) {
        currentChecked = false;
      }
      float f2 = calculateChipIconWidth();
      invalidateSelf();
      if (f1 != f2) {
        onSizeChange();
      }
    }
  }
  
  public void setCheckableResource(int paramInt)
  {
    setCheckable(context.getResources().getBoolean(paramInt));
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    if (checkedIcon != paramDrawable)
    {
      float f1 = calculateChipIconWidth();
      checkedIcon = paramDrawable;
      float f2 = calculateChipIconWidth();
      unapplyChildDrawable(checkedIcon);
      applyChildDrawable(checkedIcon);
      invalidateSelf();
      if (f1 != f2) {
        onSizeChange();
      }
    }
  }
  
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  public void setCheckedIconEnabledResource(int paramInt)
  {
    setCheckedIconVisible(context.getResources().getBoolean(paramInt));
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    setCheckedIcon(AppCompatResources.getDrawable(context, paramInt));
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    setCheckedIconVisible(context.getResources().getBoolean(paramInt));
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    if (checkedIconVisible != paramBoolean)
    {
      boolean bool = showsCheckedIcon();
      checkedIconVisible = paramBoolean;
      paramBoolean = showsCheckedIcon();
      int i;
      if (bool != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          applyChildDrawable(checkedIcon);
        } else {
          unapplyChildDrawable(checkedIcon);
        }
        invalidateSelf();
        onSizeChange();
      }
    }
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (chipBackgroundColor != paramColorStateList)
    {
      chipBackgroundColor = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setChipBackgroundColorResource(int paramInt)
  {
    setChipBackgroundColor(AppCompatResources.getColorStateList(context, paramInt));
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    if (chipCornerRadius != paramFloat)
    {
      chipCornerRadius = paramFloat;
      invalidateSelf();
    }
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    setChipCornerRadius(context.getResources().getDimension(paramInt));
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    if (chipEndPadding != paramFloat)
    {
      chipEndPadding = paramFloat;
      invalidateSelf();
      onSizeChange();
    }
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    setChipEndPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getChipIcon();
    if (localDrawable != paramDrawable)
    {
      float f1 = calculateChipIconWidth();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      chipIcon = paramDrawable;
      float f2 = calculateChipIconWidth();
      unapplyChildDrawable(localDrawable);
      if (showsChipIcon()) {
        applyChildDrawable(chipIcon);
      }
      invalidateSelf();
      if (f1 != f2) {
        onSizeChange();
      }
    }
  }
  
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  public void setChipIconEnabledResource(int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(int paramInt)
  {
    setChipIcon(AppCompatResources.getDrawable(context, paramInt));
  }
  
  public void setChipIconSize(float paramFloat)
  {
    if (chipIconSize != paramFloat)
    {
      float f = calculateChipIconWidth();
      chipIconSize = paramFloat;
      paramFloat = calculateChipIconWidth();
      invalidateSelf();
      if (f != paramFloat) {
        onSizeChange();
      }
    }
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    setChipIconSize(context.getResources().getDimension(paramInt));
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (chipIconTint != paramColorStateList)
    {
      chipIconTint = paramColorStateList;
      if (showsChipIcon()) {
        DrawableCompat.setTintList(chipIcon, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void setChipIconTintResource(int paramInt)
  {
    setChipIconTint(AppCompatResources.getColorStateList(context, paramInt));
  }
  
  public void setChipIconVisible(int paramInt)
  {
    setChipIconVisible(context.getResources().getBoolean(paramInt));
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    if (chipIconVisible != paramBoolean)
    {
      boolean bool = showsChipIcon();
      chipIconVisible = paramBoolean;
      paramBoolean = showsChipIcon();
      int i;
      if (bool != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          applyChildDrawable(chipIcon);
        } else {
          unapplyChildDrawable(chipIcon);
        }
        invalidateSelf();
        onSizeChange();
      }
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    if (chipMinHeight != paramFloat)
    {
      chipMinHeight = paramFloat;
      invalidateSelf();
      onSizeChange();
    }
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    setChipMinHeight(context.getResources().getDimension(paramInt));
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    if (chipStartPadding != paramFloat)
    {
      chipStartPadding = paramFloat;
      invalidateSelf();
      onSizeChange();
    }
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    setChipStartPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (chipStrokeColor != paramColorStateList)
    {
      chipStrokeColor = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setChipStrokeColorResource(int paramInt)
  {
    setChipStrokeColor(AppCompatResources.getColorStateList(context, paramInt));
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    if (chipStrokeWidth != paramFloat)
    {
      chipStrokeWidth = paramFloat;
      chipPaint.setStrokeWidth(paramFloat);
      invalidateSelf();
    }
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    setChipStrokeWidth(context.getResources().getDimension(paramInt));
  }
  
  public void setCloseIcon(Drawable paramDrawable)
  {
    Drawable localDrawable = getCloseIcon();
    if (localDrawable != paramDrawable)
    {
      float f1 = calculateCloseIconWidth();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      closeIcon = paramDrawable;
      float f2 = calculateCloseIconWidth();
      unapplyChildDrawable(localDrawable);
      if (showsCloseIcon()) {
        applyChildDrawable(closeIcon);
      }
      invalidateSelf();
      if (f1 != f2) {
        onSizeChange();
      }
    }
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    if (closeIconContentDescription != paramCharSequence)
    {
      closeIconContentDescription = BidiFormatter.getInstance().getPackageName(paramCharSequence);
      invalidateSelf();
    }
  }
  
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  public void setCloseIconEnabledResource(int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    if (closeIconEndPadding != paramFloat)
    {
      closeIconEndPadding = paramFloat;
      invalidateSelf();
      if (showsCloseIcon()) {
        onSizeChange();
      }
    }
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    setCloseIconEndPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setCloseIconResource(int paramInt)
  {
    setCloseIcon(AppCompatResources.getDrawable(context, paramInt));
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    if (closeIconSize != paramFloat)
    {
      closeIconSize = paramFloat;
      invalidateSelf();
      if (showsCloseIcon()) {
        onSizeChange();
      }
    }
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    setCloseIconSize(context.getResources().getDimension(paramInt));
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    if (closeIconStartPadding != paramFloat)
    {
      closeIconStartPadding = paramFloat;
      invalidateSelf();
      if (showsCloseIcon()) {
        onSizeChange();
      }
    }
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    setCloseIconStartPadding(context.getResources().getDimension(paramInt));
  }
  
  public boolean setCloseIconState(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(closeIconStateSet, paramArrayOfInt))
    {
      closeIconStateSet = paramArrayOfInt;
      if (showsCloseIcon()) {
        return onStateChange(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (closeIconTint != paramColorStateList)
    {
      closeIconTint = paramColorStateList;
      if (showsCloseIcon()) {
        DrawableCompat.setTintList(closeIcon, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void setCloseIconTintResource(int paramInt)
  {
    setCloseIconTint(AppCompatResources.getColorStateList(context, paramInt));
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    setCloseIconVisible(context.getResources().getBoolean(paramInt));
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    if (closeIconVisible != paramBoolean)
    {
      boolean bool = showsCloseIcon();
      closeIconVisible = paramBoolean;
      paramBoolean = showsCloseIcon();
      int i;
      if (bool != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          applyChildDrawable(closeIcon);
        } else {
          unapplyChildDrawable(closeIcon);
        }
        invalidateSelf();
        onSizeChange();
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (colorFilter != paramColorFilter)
    {
      colorFilter = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public void setDelegate(Delegate paramDelegate)
  {
    delegate = new WeakReference(paramDelegate);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    truncateAt = paramTruncateAt;
  }
  
  public void setHideMotionSpec(MotionSpec paramMotionSpec)
  {
    hideMotionSpec = paramMotionSpec;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(MotionSpec.createFromResource(context, paramInt));
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    if (iconEndPadding != paramFloat)
    {
      float f = calculateChipIconWidth();
      iconEndPadding = paramFloat;
      paramFloat = calculateChipIconWidth();
      invalidateSelf();
      if (f != paramFloat) {
        onSizeChange();
      }
    }
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    setIconEndPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    if (iconStartPadding != paramFloat)
    {
      float f = calculateChipIconWidth();
      iconStartPadding = paramFloat;
      paramFloat = calculateChipIconWidth();
      invalidateSelf();
      if (f != paramFloat) {
        onSizeChange();
      }
    }
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    setIconStartPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setMaxWidth(int paramInt)
  {
    maxWidth = paramInt;
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (rippleColor != paramColorStateList)
    {
      rippleColor = paramColorStateList;
      updateCompatRippleColor();
      onStateChange(getState());
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    setRippleColor(AppCompatResources.getColorStateList(context, paramInt));
  }
  
  public void setShouldDrawText(boolean paramBoolean)
  {
    shouldDrawText = paramBoolean;
  }
  
  public void setShowMotionSpec(MotionSpec paramMotionSpec)
  {
    showMotionSpec = paramMotionSpec;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(MotionSpec.createFromResource(context, paramInt));
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (rawText != localObject)
    {
      rawText = ((CharSequence)localObject);
      unicodeWrappedText = BidiFormatter.getInstance().getPackageName((CharSequence)localObject);
      textWidthDirty = true;
      invalidateSelf();
      onSizeChange();
    }
  }
  
  public void setTextAppearance(TextAppearance paramTextAppearance)
  {
    if (textAppearance != paramTextAppearance)
    {
      textAppearance = paramTextAppearance;
      if (paramTextAppearance != null)
      {
        paramTextAppearance.updateMeasureState(context, textPaint, fontCallback);
        textWidthDirty = true;
      }
      onStateChange(getState());
      onSizeChange();
    }
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(new TextAppearance(context, paramInt));
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    if (textEndPadding != paramFloat)
    {
      textEndPadding = paramFloat;
      invalidateSelf();
      onSizeChange();
    }
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    setTextEndPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setTextResource(int paramInt)
  {
    setText(context.getResources().getString(paramInt));
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    if (textStartPadding != paramFloat)
    {
      textStartPadding = paramFloat;
      invalidateSelf();
      onSizeChange();
    }
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    setTextStartPadding(context.getResources().getDimension(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (tint != paramColorStateList)
    {
      tint = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (tintMode != paramMode)
    {
      tintMode = paramMode;
      tintFilter = DrawableUtils.updateTintFilter(this, tint, paramMode);
      invalidateSelf();
    }
  }
  
  public void setUseCompatRipple(boolean paramBoolean)
  {
    if (useCompatRipple != paramBoolean)
    {
      useCompatRipple = paramBoolean;
      updateCompatRippleColor();
      onStateChange(getState());
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (showsChipIcon()) {
      bool1 = bool2 | chipIcon.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (showsCheckedIcon()) {
      bool2 = bool1 | checkedIcon.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (showsCloseIcon()) {
      bool1 = bool2 | closeIcon.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public boolean shouldDrawText()
  {
    return shouldDrawText;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public static abstract interface Delegate
  {
    public abstract void onChipDrawableSizeChange();
  }
}
