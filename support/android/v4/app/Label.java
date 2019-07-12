package support.android.v4.app;

import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.Locale;

public final class Label
{
  public static final Label b = new Label();
  public static final Method c = new Attribute();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      c = new TSynchronizedCharByteMap();
      return;
    }
  }
  
  public Label() {}
  
  public static Label a()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return a(LocaleList.getAdjustedDefault());
    }
    return a(new Locale[] { Locale.getDefault() });
  }
  
  public static Label a(Object paramObject)
  {
    Label localLabel = new Label();
    if ((paramObject instanceof LocaleList)) {
      localLabel.b((LocaleList)paramObject);
    }
    return localLabel;
  }
  
  public static Label a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      String[] arrayOfString = paramString.split(",", -1);
      Locale[] arrayOfLocale = new Locale[arrayOfString.length];
      int i = 0;
      while (i < arrayOfLocale.length)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramString = Locale.forLanguageTag(arrayOfString[i]);
        } else {
          paramString = Format.getName(arrayOfString[i]);
        }
        arrayOfLocale[i] = paramString;
        i += 1;
      }
      paramString = new Label();
      c.a(arrayOfLocale);
      return paramString;
    }
    return b;
  }
  
  public static Label a(Locale... paramVarArgs)
  {
    Label localLabel = new Label();
    c.a(paramVarArgs);
    return localLabel;
  }
  
  public static Label b()
  {
    return b;
  }
  
  private void b(LocaleList paramLocaleList)
  {
    int j = paramLocaleList.size();
    if (j > 0)
    {
      Locale[] arrayOfLocale = new Locale[j];
      int i = 0;
      while (i < j)
      {
        arrayOfLocale[i] = paramLocaleList.get(i);
        i += 1;
      }
      c.a(arrayOfLocale);
    }
  }
  
  private void b(Locale... paramVarArgs)
  {
    c.a(paramVarArgs);
  }
  
  public static Label getType()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return a(LocaleList.getDefault());
    }
    return a(new Locale[] { Locale.getDefault() });
  }
  
  public boolean equals()
  {
    return c.isEmpty();
  }
  
  public boolean equals(Object paramObject)
  {
    return c.equals(paramObject);
  }
  
  public int getName(Locale paramLocale)
  {
    return c.toString(paramLocale);
  }
  
  public Object getName()
  {
    return c.getValue();
  }
  
  public Locale getName(int paramInt)
  {
    return c.toString(paramInt);
  }
  
  public Locale getName(String[] paramArrayOfString)
  {
    return c.toString(paramArrayOfString);
  }
  
  public int getOffset()
  {
    return c.size();
  }
  
  public int hashCode()
  {
    return c.hashCode();
  }
  
  public String isNull()
  {
    return c.equals();
  }
  
  public String toString()
  {
    return c.toString();
  }
}
