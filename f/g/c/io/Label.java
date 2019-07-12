package f.g.c.io;

import f.g.c.g.J;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class Label
  implements J<FileOutputStream>
{
  public Label(File paramFile, boolean paramBoolean) {}
  
  public FileOutputStream write()
    throws IOException
  {
    return new FileOutputStream(d, c);
  }
}
