package support.android.v4.text;

import android.os.Build.VERSION;
import android.os.Trace;
import android.text.Layout.Alignment;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import b.b.a.F;
import b.b.a.G;
import b.b.a.t;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class b
  implements Spannable
{
  public static final Object d = new Object();
  @F
  @t("sLock")
  public static Executor e = null;
  public static final char j = '\n';
  @F
  public final Label a;
  @F
  public final int[] b;
  @F
  public final Spannable editable;
  @G
  public final PrecomputedText k;
  
  public b(PrecomputedText paramPrecomputedText, Label paramLabel)
  {
    editable = ((Spannable)paramPrecomputedText);
    a = paramLabel;
    b = null;
    k = paramPrecomputedText;
  }
  
  public b(CharSequence paramCharSequence, Label paramLabel, int[] paramArrayOfInt)
  {
    editable = new SpannableString(paramCharSequence);
    a = paramLabel;
    b = paramArrayOfInt;
    k = null;
  }
  
  public static Future a(CharSequence paramCharSequence, Label paramLabel, Executor paramExecutor)
  {
    paramLabel = new Format(paramLabel, paramCharSequence);
    paramCharSequence = paramExecutor;
    if (paramExecutor == null)
    {
      paramExecutor = d;
      try
      {
        if (e == null) {
          e = Executors.newFixedThreadPool(1);
        }
        paramCharSequence = e;
      }
      catch (Throwable paramCharSequence)
      {
        throw paramCharSequence;
      }
    }
    paramCharSequence.execute(paramLabel);
    return paramLabel;
  }
  
  public static b a(CharSequence paramCharSequence, Label paramLabel)
  {
    if (paramCharSequence != null)
    {
      if (paramLabel != null) {
        try
        {
          i = Build.VERSION.SDK_INT;
          Trace.beginSection("PrecomputedText");
          i = Build.VERSION.SDK_INT;
          if (i >= 28)
          {
            localObject = c;
            if (localObject != null)
            {
              paramCharSequence = new b(PrecomputedText.create(paramCharSequence, (PrecomputedText.Params)localObject), paramLabel);
              i = Build.VERSION.SDK_INT;
              Trace.endSection();
              return paramCharSequence;
            }
          }
          Object localObject = new ArrayList();
          int m = paramCharSequence.length();
          i = 0;
          while (i < m)
          {
            i = TextUtils.indexOf(paramCharSequence, '\n', i, m);
            if (i < 0) {
              i = m;
            } else {
              i += 1;
            }
            ((ArrayList)localObject).add(Integer.valueOf(i));
          }
          int[] arrayOfInt = new int[((ArrayList)localObject).size()];
          i = 0;
          for (;;)
          {
            m = ((ArrayList)localObject).size();
            if (i >= m) {
              break;
            }
            arrayOfInt[i] = ((Integer)((ArrayList)localObject).get(i)).intValue();
            i += 1;
          }
          i = Build.VERSION.SDK_INT;
          if (i >= 23)
          {
            StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramLabel.getText(), Integer.MAX_VALUE).setBreakStrategy(paramLabel.a()).setHyphenationFrequency(paramLabel.f()).setTextDirection(paramLabel.getColor()).build();
          }
          else
          {
            i = Build.VERSION.SDK_INT;
            if (i >= 21) {
              new StaticLayout(paramCharSequence, paramLabel.getText(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
            }
          }
          paramCharSequence = new b(paramCharSequence, paramLabel, arrayOfInt);
          i = Build.VERSION.SDK_INT;
          Trace.endSection();
          return paramCharSequence;
        }
        catch (Throwable paramCharSequence)
        {
          int i = Build.VERSION.SDK_INT;
          Trace.endSection();
          throw paramCharSequence;
        }
      }
      throw new NullPointerException();
    }
    paramCharSequence = new NullPointerException();
    throw paramCharSequence;
  }
  
  private int c(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject = b;
      if (i >= localObject.length) {
        break;
      }
      if (paramInt < localObject[i]) {
        return i;
      }
      i += 1;
    }
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("pos must be less than ");
    int[] arrayOfInt = b;
    ((StringBuilder)localObject).append(arrayOfInt[(arrayOfInt.length - 1)]);
    ((StringBuilder)localObject).append(", gave ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
    throw ((Throwable)localObject);
  }
  
  public int a(int paramInt)
  {
    support.android.v4.util.Label.a(paramInt, 0, b(), "paraIndex");
    if (Build.VERSION.SDK_INT >= 28) {
      return k.getParagraphEnd(paramInt);
    }
    return b[paramInt];
  }
  
  public Label a()
  {
    return a;
  }
  
  public int b()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return k.getParagraphCount();
    }
    return b.length;
  }
  
  public int b(int paramInt)
  {
    support.android.v4.util.Label.a(paramInt, 0, b(), "paraIndex");
    if (Build.VERSION.SDK_INT >= 28) {
      return k.getParagraphStart(paramInt);
    }
    if (paramInt == 0) {
      return 0;
    }
    return b[(paramInt - 1)];
  }
  
  public char charAt(int paramInt)
  {
    return editable.charAt(paramInt);
  }
  
  public PrecomputedText getId()
  {
    Spannable localSpannable = editable;
    if ((localSpannable instanceof PrecomputedText)) {
      return (PrecomputedText)localSpannable;
    }
    return null;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    return editable.getSpanEnd(paramObject);
  }
  
  public int getSpanFlags(Object paramObject)
  {
    return editable.getSpanFlags(paramObject);
  }
  
  public int getSpanStart(Object paramObject)
  {
    return editable.getSpanStart(paramObject);
  }
  
  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return k.getSpans(paramInt1, paramInt2, paramClass);
    }
    return editable.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public int length()
  {
    return editable.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return editable.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public void removeSpan(Object paramObject)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        k.removeSpan(paramObject);
        return;
      }
      editable.removeSpan(paramObject);
      return;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        k.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
        return;
      }
      editable.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return editable.subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return editable.toString();
  }
}
