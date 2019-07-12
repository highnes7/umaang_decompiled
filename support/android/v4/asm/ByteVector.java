package support.android.v4.asm;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.h;
import java.util.Iterator;
import java.util.Set;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public class ByteVector
  implements Runnable
{
  public ByteVector(MediaBrowserServiceCompat.h paramH, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = n.h.m.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IBinder)localIterator.next();
      localObject = (MediaBrowserServiceCompat.b)n.h.m.get(localObject);
      n.a((MediaBrowserServiceCompat.b)localObject, a, b);
    }
  }
}
