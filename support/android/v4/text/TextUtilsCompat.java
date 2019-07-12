package support.android.v4.text;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat
{
  public static final String ARAB_SCRIPT_SUBTAG = "Arab";
  public static final String HEBR_SCRIPT_SUBTAG = "Hebr";
  public static final Locale ROOT = new Locale("", "");
  
  public TextUtilsCompat() {}
  
  public static int getLayoutDirectionFromFirstChar(Locale paramLocale)
  {
    int i = Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0));
    if ((i != 1) && (i != 2)) {
      return 0;
    }
    return 1;
  }
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    int i = Build.VERSION.SDK_INT;
    return TextUtils.getLayoutDirectionFromLocale(paramLocale);
  }
  
  public static String htmlEncode(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    return TextUtils.htmlEncode(paramString);
  }
}
