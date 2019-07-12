package support.android.v4.text;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import b.b.a.F;
import b.b.a.G;
import java.util.Locale;
import support.android.v4.util.LatLong;

public final class Label
{
  @F
  public final TextPaint a;
  @G
  public final TextDirectionHeuristic b;
  public final PrecomputedText.Params c;
  public final int d;
  public final int f;
  
  public Label(PrecomputedText.Params paramParams)
  {
    a = paramParams.getTextPaint();
    b = paramParams.getTextDirection();
    d = paramParams.getBreakStrategy();
    f = paramParams.getHyphenationFrequency();
    c = paramParams;
  }
  
  public Label(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      c = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();
    } else {
      c = null;
    }
    a = paramTextPaint;
    b = paramTextDirectionHeuristic;
    d = paramInt1;
    f = paramInt2;
  }
  
  public int a()
  {
    return d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof Label)) {
        return false;
      }
      paramObject = (Label)paramObject;
      PrecomputedText.Params localParams = c;
      if (localParams != null) {
        return localParams.equals(c);
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (d != paramObject.a()) {
          return false;
        }
        if (f != paramObject.f()) {
          return false;
        }
      }
      int i = Build.VERSION.SDK_INT;
      if (b != paramObject.getColor()) {
        return false;
      }
      if (a.getTextSize() != paramObject.getText().getTextSize()) {
        return false;
      }
      if (a.getTextScaleX() != paramObject.getText().getTextScaleX()) {
        return false;
      }
      if (a.getTextSkewX() != paramObject.getText().getTextSkewX()) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (a.getLetterSpacing() != paramObject.getText().getLetterSpacing()) {
          return false;
        }
        if (!TextUtils.equals(a.getFontFeatureSettings(), paramObject.getText().getFontFeatureSettings())) {
          return false;
        }
      }
      if (a.getFlags() != paramObject.getText().getFlags()) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        if (!a.getTextLocales().equals(paramObject.getText().getTextLocales())) {
          return false;
        }
      }
      else if (!a.getTextLocale().equals(paramObject.getText().getTextLocale())) {
        return false;
      }
      if (a.getTypeface() == null)
      {
        if (paramObject.getText().getTypeface() != null) {
          return false;
        }
      }
      else
      {
        if (a.getTypeface().equals(paramObject.getText().getTypeface())) {
          break label323;
        }
        return false;
      }
      return true;
    }
    else
    {
      return false;
    }
    label323:
    return true;
  }
  
  public int f()
  {
    return f;
  }
  
  public TextDirectionHeuristic getColor()
  {
    return b;
  }
  
  public TextPaint getText()
  {
    return a;
  }
  
  public int hashCode()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      return LatLong.hashCode(new Object[] { Float.valueOf(a.getTextSize()), Float.valueOf(a.getTextScaleX()), Float.valueOf(a.getTextSkewX()), Float.valueOf(a.getLetterSpacing()), Integer.valueOf(a.getFlags()), a.getTextLocales(), a.getTypeface(), Boolean.valueOf(a.isElegantTextHeight()), b, Integer.valueOf(d), Integer.valueOf(f) });
    }
    if (i >= 21) {
      return LatLong.hashCode(new Object[] { Float.valueOf(a.getTextSize()), Float.valueOf(a.getTextScaleX()), Float.valueOf(a.getTextSkewX()), Float.valueOf(a.getLetterSpacing()), Integer.valueOf(a.getFlags()), a.getTextLocale(), a.getTypeface(), Boolean.valueOf(a.isElegantTextHeight()), b, Integer.valueOf(d), Integer.valueOf(f) });
    }
    return LatLong.hashCode(new Object[] { Float.valueOf(a.getTextSize()), Float.valueOf(a.getTextScaleX()), Float.valueOf(a.getTextSkewX()), Integer.valueOf(a.getFlags()), a.getTextLocale(), a.getTypeface(), b, Integer.valueOf(d), Integer.valueOf(f) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("{");
    StringBuilder localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("textSize=");
    localStringBuilder2.append(a.getTextSize());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textScaleX=");
    localStringBuilder2.append(a.getTextScaleX());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textSkewX=");
    localStringBuilder2.append(a.getTextSkewX());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 21)
    {
      localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", letterSpacing=");
      localStringBuilder2.append(a.getLetterSpacing());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", elegantTextHeight=");
      localStringBuilder2.append(a.isElegantTextHeight());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", textLocale=");
      localStringBuilder2.append(a.getTextLocales());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", textLocale=");
      localStringBuilder2.append(a.getTextLocale());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", typeface=");
    localStringBuilder2.append(a.getTypeface());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 26)
    {
      localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", variationSettings=");
      localStringBuilder2.append(a.getFontVariationSettings());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(", textDir=");
    localStringBuilder2.append(b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", breakStrategy=");
    localStringBuilder2.append(d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", hyphenationFrequency=");
    localStringBuilder2.append(f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}
