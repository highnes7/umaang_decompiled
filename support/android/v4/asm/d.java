package support.android.v4.asm;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.d;
import support.android.v4.util.SimpleArrayMap;

public class d
  implements Runnable
{
  public d(MediaBrowserServiceCompat.d paramD, ea.b paramB, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    int i = 0;
    while (i < l.h.m.size())
    {
      MediaBrowserServiceCompat.b localB = (MediaBrowserServiceCompat.b)l.h.m.get(i);
      if (i.equals(b)) {
        l.a(localB, c, s);
      }
      i += 1;
    }
  }
}
