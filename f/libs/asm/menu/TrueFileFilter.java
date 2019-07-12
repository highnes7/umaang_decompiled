package f.libs.asm.menu;

import java.io.File;
import java.io.FilenameFilter;

public final class TrueFileFilter
  implements FilenameFilter
{
  public TrueFileFilter() {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return true;
  }
}
