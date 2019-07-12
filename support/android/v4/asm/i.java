package support.android.v4.asm;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.h;
import support.android.v4.util.SimpleArrayMap;

public class i
  implements Runnable
{
  public i(MediaBrowserServiceCompat.h paramH, ea.b paramB, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    int j = 0;
    while (j < w.h.m.size())
    {
      MediaBrowserServiceCompat.b localB = (MediaBrowserServiceCompat.b)w.h.m.get(j);
      if (i.equals(i))
      {
        w.a(localB, a, b);
        return;
      }
      j += 1;
    }
  }
}
