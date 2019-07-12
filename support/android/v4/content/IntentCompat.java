package support.android.v4.content;

import android.content.Intent;
import android.os.Build.VERSION;

public final class IntentCompat
{
  public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
  public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.START_PLAYBACK";
  public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
  
  public IntentCompat() {}
  
  public static Intent makeMainSelectorActivity(String paramString1, String paramString2)
  {
    int i = Build.VERSION.SDK_INT;
    return Intent.makeMainSelectorActivity(paramString1, paramString2);
  }
}
