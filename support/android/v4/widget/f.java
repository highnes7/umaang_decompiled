package support.android.v4.widget;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode.Callback;
import android.view.View;
import java.lang.reflect.Field;
import support.android.v4.text.b;
import support.android.v4.text.d.a.a;

public final class f
{
  public static final int A = 1;
  public static final String ACTION_VIEW_STATES_KEY = "TextViewCompat";
  public static final int d = 0;
  public static Field expression;
  public static final int f = 1;
  public static Field l;
  public static boolean mIsActionItemsStale;
  public static boolean mPreventDispatchingItemsChanged;
  public static boolean mQwertyMode;
  public static boolean mShortcutsVisible;
  public static Field mTempShortcutItemList;
  public static Field mVisibleItems;
  
  public f() {}
  
  public static ActionMode.Callback a(android.widget.TextView paramTextView, ActionMode.Callback paramCallback)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 26) && (i <= 27))
    {
      if ((paramCallback instanceof i)) {
        return paramCallback;
      }
      return new i(paramCallback, paramTextView);
    }
    return paramCallback;
  }
  
  public static support.android.v4.text.Label a(android.widget.TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return new support.android.v4.text.Label(paramTextView.getTextMetricsParams());
    }
    d.a.a localA = new d.a.a(new TextPaint(paramTextView.getPaint()));
    if (Build.VERSION.SDK_INT >= 23)
    {
      localA.send(paramTextView.getBreakStrategy());
      localA.b(paramTextView.getHyphenationFrequency());
    }
    int i = Build.VERSION.SDK_INT;
    localA.b(init(paramTextView));
    return localA.a();
  }
  
  public static void a(android.widget.TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    if ((paramTextView instanceof TextView)) {
      ((TextView)paramTextView).setAutoSizeTextTypeWithDefaults(paramInt);
    }
  }
  
  public static void a(android.widget.TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if ((paramTextView instanceof TextView)) {
      ((TextView)paramTextView).setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void a(android.widget.TextView paramTextView, support.android.v4.text.Label paramLabel)
  {
    int i = Build.VERSION.SDK_INT;
    paramTextView.setTextDirection(testConnection(paramLabel.getColor()));
    if (Build.VERSION.SDK_INT < 23)
    {
      float f1 = paramLabel.getText().getTextScaleX();
      paramTextView.getPaint().set(paramLabel.getText());
      if (f1 == paramTextView.getTextScaleX()) {
        paramTextView.setTextScaleX(f1 / 2.0F + 1.0F);
      }
      paramTextView.setTextScaleX(f1);
      return;
    }
    paramTextView.getPaint().set(paramLabel.getText());
    paramTextView.setBreakStrategy(paramLabel.a());
    paramTextView.setHyphenationFrequency(paramLabel.f());
  }
  
  public static void a(android.widget.TextView paramTextView, b paramB)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setText((CharSequence)paramB.getId());
      return;
    }
    if (a(paramTextView).equals(paramB.a()))
    {
      paramTextView.setText(paramB);
      return;
    }
    throw new IllegalArgumentException("Given text can not be applied to TextView.");
  }
  
  public static void a(android.widget.TextView paramTextView, int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (Build.VERSION.SDK_INT >= 27)
    {
      paramTextView.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    if ((paramTextView instanceof TextView)) {
      ((TextView)paramTextView).setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
  }
  
  public static int b(android.widget.TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMinTextSize();
    }
    if ((paramTextView instanceof TextView)) {
      return ((TextView)paramTextView).getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  public static void b(android.widget.TextView paramTextView, ActionMode.Callback paramCallback)
  {
    paramTextView.setCustomSelectionActionModeCallback(a(paramTextView, paramCallback));
  }
  
  public static int c(android.widget.TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeMaxTextSize();
    }
    if ((paramTextView instanceof TextView)) {
      return ((TextView)paramTextView).getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  public static int d(android.widget.TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeStepGranularity();
    }
    if ((paramTextView instanceof TextView)) {
      return ((TextView)paramTextView).getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  public static void draw(android.widget.TextView paramTextView, int paramInt)
  {
    support.android.v4.util.Label.getKey(paramInt);
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramTextView.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i = Build.VERSION.SDK_INT;
    if (paramTextView.getIncludeFontPadding()) {
      i = top;
    } else {
      i = ascent;
    }
    if (paramInt > Math.abs(i))
    {
      i = -i;
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramInt - i, paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
    }
  }
  
  public static int e(android.widget.TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextType();
    }
    if ((paramTextView instanceof TextView)) {
      return ((TextView)paramTextView).getAutoSizeTextType();
    }
    return 0;
  }
  
  public static Drawable[] getCompoundDrawablesRelative(android.widget.TextView paramTextView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramTextView.getCompoundDrawablesRelative();
  }
  
  public static int getMaxLines(android.widget.TextView paramTextView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramTextView.getMaxLines();
  }
  
  public static int getMinLines(android.widget.TextView paramTextView)
  {
    int i = Build.VERSION.SDK_INT;
    return paramTextView.getMinLines();
  }
  
  public static TextDirectionHeuristic init(android.widget.TextView paramTextView)
  {
    if ((paramTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
      return TextDirectionHeuristics.LTR;
    }
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if ((j >= 28) && ((paramTextView.getInputType() & 0xF) == 3))
    {
      i = Character.getDirectionality(android.icu.text.DecimalFormatSymbols.getInstance(paramTextView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
      if ((i != 1) && (i != 2)) {
        return TextDirectionHeuristics.LTR;
      }
      return TextDirectionHeuristics.RTL;
    }
    if (paramTextView.getLayoutDirection() == 1) {
      i = 1;
    }
    switch (paramTextView.getTextDirection())
    {
    default: 
      if (i != 0) {
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
      }
      break;
    case 7: 
      return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    case 6: 
      return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    case 5: 
      return TextDirectionHeuristics.LOCALE;
    case 4: 
      return TextDirectionHeuristics.RTL;
    case 3: 
      return TextDirectionHeuristics.LTR;
    case 2: 
      return TextDirectionHeuristics.ANYRTL_LTR;
    }
    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
  }
  
  public static void init(android.widget.TextView paramTextView, int paramInt)
  {
    support.android.v4.util.Label.getKey(paramInt);
    int i = paramTextView.getPaint().getFontMetricsInt(null);
    if (paramInt != i) {
      paramTextView.setLineSpacing(paramInt - i, 1.0F);
    }
  }
  
  public static void initialize(android.widget.TextView paramTextView, int paramInt)
  {
    support.android.v4.util.Label.getKey(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = paramTextView.getPaint().getFontMetricsInt();
    int i = Build.VERSION.SDK_INT;
    if (paramTextView.getIncludeFontPadding()) {
      i = bottom;
    } else {
      i = descent;
    }
    if (paramInt > Math.abs(i)) {
      paramTextView.setPadding(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramInt - i);
    }
  }
  
  public static Field retrieveField(String paramString)
  {
    Object localObject = null;
    try
    {
      Field localField = android.widget.TextView.class.getDeclaredField(paramString);
      localObject = localField;
      localField.setAccessible(true);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Could not retrieve ", paramString, " field.");
    return localObject;
  }
  
  public static int retrieveIntFromField(Field paramField, android.widget.TextView paramTextView)
  {
    try
    {
      int i = paramField.getInt(paramTextView);
      return i;
    }
    catch (IllegalAccessException paramTextView)
    {
      for (;;) {}
    }
    paramTextView = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Could not retrieve value of ");
    paramTextView.append(paramField.getName());
    paramTextView.append(" field.");
    paramTextView.toString();
    return -1;
  }
  
  public static void setCompoundDrawablesRelative(android.widget.TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int i = Build.VERSION.SDK_INT;
    paramTextView.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(android.widget.TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Build.VERSION.SDK_INT;
    paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(android.widget.TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int i = Build.VERSION.SDK_INT;
    paramTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static int setText(android.widget.TextView paramTextView)
  {
    return paramTextView.getPaddingBottom() + getPaintgetFontMetricsIntbottom;
  }
  
  public static void setTextAppearance(android.widget.TextView paramTextView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramTextView.setTextAppearance(paramInt);
      return;
    }
    paramTextView.setTextAppearance(paramTextView.getContext(), paramInt);
  }
  
  public static int testConnection(TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 1;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
      return 2;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
      return 3;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
      return 4;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
      return 5;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
      return 6;
    }
    if (paramTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
      return 7;
    }
    return 1;
  }
  
  public static int[] updateColor(android.widget.TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 27) {
      return paramTextView.getAutoSizeTextAvailableSizes();
    }
    if ((paramTextView instanceof TextView)) {
      return ((TextView)paramTextView).getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  public static int updatePadding(android.widget.TextView paramTextView)
  {
    return paramTextView.getPaddingTop() - getPaintgetFontMetricsInttop;
  }
}
