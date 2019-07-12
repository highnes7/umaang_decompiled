package f.g.c.io;

import f.g.c.g.y;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public final class CharSource
  implements y<InputStream>
{
  public CharSource(URL paramURL) {}
  
  public InputStream getInput()
    throws IOException
  {
    return val$url.openStream();
  }
}
