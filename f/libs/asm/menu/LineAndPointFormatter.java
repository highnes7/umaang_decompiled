package f.libs.asm.menu;

import android.text.TextUtils;
import java.util.HashMap;

public class LineAndPointFormatter
  extends HashMap<String, Object>
{
  public LineAndPointFormatter(Widget paramWidget)
  {
    put("app_identifier", a.a);
    put("api_key", newUTF8a.g).a);
    put("version_code", a.c);
    put("version_name", a.e);
    put("install_uuid", a.f);
    put("delivery_mechanism", Integer.valueOf(a.b));
    if (TextUtils.isEmpty(ClassWriter.get(a.g))) {
      paramWidget = "";
    } else {
      paramWidget = ClassWriter.get(a.g);
    }
    put("unity_version", paramWidget);
  }
}
