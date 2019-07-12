package support.android.classic.net.asm;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;

public final class ClassWriter
{
  public static final String[] A = new String[0];
  public static final int INVALID_OFFSET = Integer.MIN_VALUE;
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;
  public static final String threshold = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
  
  public ClassWriter() {}
  
  public static void a(EditorInfo paramEditorInfo, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      contentMimeTypes = paramArrayOfString;
      return;
    }
    if (extras == null) {
      extras = new Bundle();
    }
    extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
  }
  
  public static String[] get(EditorInfo paramEditorInfo)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo = contentMimeTypes;
      if (paramEditorInfo != null) {
        return paramEditorInfo;
      }
      return A;
    }
    paramEditorInfo = extras;
    if (paramEditorInfo == null) {
      return A;
    }
    paramEditorInfo = paramEditorInfo.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    if (paramEditorInfo != null) {
      return paramEditorInfo;
    }
    return A;
  }
}
