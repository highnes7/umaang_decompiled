package f.libs.asm.menu;

import android.os.Build;
import java.util.HashMap;

public class XYRegionFormatter
  extends HashMap<String, Object>
{
  public XYRegionFormatter(NumberPicker paramNumberPicker)
  {
    put("arch", Integer.valueOf(a.x));
    put("build_model", Build.MODEL);
    put("available_processors", Integer.valueOf(a.b));
    put("total_ram", Long.valueOf(a.d));
    put("disk_space", Long.valueOf(a.e));
    put("is_emulator", Boolean.valueOf(a.f));
    put("ids", a.c);
    put("state", Integer.valueOf(a.r));
    put("build_manufacturer", Build.MANUFACTURER);
    put("build_product", Build.PRODUCT);
  }
}
