package f.libs.asm.menu;

import java.io.File;
import java.io.FileFilter;

public final class FalseFileFilter
  implements FileFilter
{
  public FalseFileFilter() {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().length() == 35);
  }
}
