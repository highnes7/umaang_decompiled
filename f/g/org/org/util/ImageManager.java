package f.g.org.org.util;

import f.g.b.a.g.h;
import java.io.IOException;

@h
public final class ImageManager
{
  public ImageManager() {}
  
  public static boolean put(Context paramContext, BackOff paramBackOff)
    throws InterruptedException, IOException
  {
    long l = paramBackOff.nextBackOffMillis();
    if (l == -1L) {
      return false;
    }
    paramContext.report(l);
    return true;
  }
}
