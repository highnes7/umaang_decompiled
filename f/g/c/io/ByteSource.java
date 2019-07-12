package f.g.c.io;

import f.g.c.g.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ByteSource
  implements y<FileInputStream>
{
  public ByteSource(File paramFile) {}
  
  public FileInputStream getInput()
    throws IOException
  {
    return new FileInputStream(input);
  }
}
