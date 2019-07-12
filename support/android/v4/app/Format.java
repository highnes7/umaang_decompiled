package support.android.v4.app;

import b.b.a.N;
import java.util.Locale;

@N({b.b.a.N.a.b})
public final class Format
{
  public Format() {}
  
  public static Locale getName(String paramString)
  {
    String[] arrayOfString;
    if (paramString.contains("-"))
    {
      arrayOfString = paramString.split("-", -1);
      if (arrayOfString.length > 2) {
        return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      }
      if (arrayOfString.length > 1) {
        return new Locale(arrayOfString[0], arrayOfString[1]);
      }
      if (arrayOfString.length == 1) {
        return new Locale(arrayOfString[0]);
      }
    }
    else
    {
      if (!paramString.contains("_")) {
        break label170;
      }
      arrayOfString = paramString.split("_", -1);
      if (arrayOfString.length > 2) {
        return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      }
      if (arrayOfString.length > 1) {
        return new Locale(arrayOfString[0], arrayOfString[1]);
      }
      if (arrayOfString.length == 1) {
        return new Locale(arrayOfString[0]);
      }
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Can not parse language tag: [", paramString, "]"));
    label170:
    return new Locale(paramString);
  }
  
  public static String getTitle(Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage());
    String str = paramLocale.getCountry();
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramLocale.getCountry());
    }
    return localStringBuilder.toString();
  }
}
