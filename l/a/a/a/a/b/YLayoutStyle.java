package l.a.a.a.a.b;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import l.a.a.a.Log;
import l.a.a.a.f;

public enum YLayoutStyle
{
  public static final Map<String, l.a> a;
  
  static
  {
    ABSOLUTE_FROM_TOP = new YLayoutStyle("X86_64", 1);
    ABSOLUTE_FROM_BOTTOM = new YLayoutStyle("ARM_UNKNOWN", 2);
    ABSOLUTE_FROM_CENTER = new YLayoutStyle("PPC", 3);
    RELATIVE_TO_LEFT = new YLayoutStyle("PPC64", 4);
    d = new YLayoutStyle("ARMV6", 5);
    c = new YLayoutStyle("ARMV7", 6);
    b = new YLayoutStyle("UNKNOWN", 7);
    RELATIVE_TO_TOP = new YLayoutStyle("ARMV7S", 8);
    RELATIVE_TO_BOTTOM = new YLayoutStyle("ARM64", 9);
    $VALUES = new YLayoutStyle[] { RELATIVE_TO_CENTER, ABSOLUTE_FROM_TOP, ABSOLUTE_FROM_BOTTOM, ABSOLUTE_FROM_CENTER, RELATIVE_TO_LEFT, d, c, b, RELATIVE_TO_TOP, RELATIVE_TO_BOTTOM };
    a = new HashMap(4);
    a.put("armeabi-v7a", c);
    a.put("armeabi", d);
    a.put("arm64-v8a", RELATIVE_TO_BOTTOM);
    a.put("x86", RELATIVE_TO_CENTER);
  }
  
  public static YLayoutStyle a()
  {
    Object localObject = Build.CPU_ABI;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      f.get().d("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
      return b;
    }
    localObject = ((String)localObject).toLowerCase(Locale.US);
    YLayoutStyle localYLayoutStyle = (YLayoutStyle)a.get(localObject);
    localObject = localYLayoutStyle;
    if (localYLayoutStyle == null) {
      localObject = b;
    }
    return localObject;
  }
}
