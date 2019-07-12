package f.libs.asm.menu;

import android.os.Build.VERSION;
import java.util.HashMap;

public class ImageButton
  extends HashMap<String, Object>
{
  public ImageButton(Color paramColor)
  {
    put("version", Build.VERSION.RELEASE);
    put("build_version", Build.VERSION.CODENAME);
    put("is_rooted", Boolean.valueOf(mColor.r));
  }
}
