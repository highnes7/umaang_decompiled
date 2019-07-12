package f.libs.asm.menu;

import java.io.File;
import l.a.a.a.a.f.a;

public final class LayoutManager
  implements ya.a
{
  public static final String e = "log-files";
  public final a c;
  
  public LayoutManager(a paramA)
  {
    c = paramA;
  }
  
  public File a()
  {
    File localFile = new File(c.a(), "log-files");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
}
