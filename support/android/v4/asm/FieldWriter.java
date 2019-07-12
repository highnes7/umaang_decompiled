package support.android.v4.asm;

import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.j;
import android.support.v4.media.MediaBrowserServiceCompat.k;
import android.support.v4.os.ResultReceiver;
import support.android.v4.util.SimpleArrayMap;

public class FieldWriter
  implements Runnable
{
  public FieldWriter(MediaBrowserServiceCompat.j paramJ, MediaBrowserServiceCompat.k paramK, String paramString, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    Object localObject = j.asBinder();
    localObject = (MediaBrowserServiceCompat.b)i.this$0.m.get(localObject);
    if (localObject == null)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("getMediaItem for callback that isn't registered id=");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).toString();
      return;
    }
    i.this$0.a(c, (MediaBrowserServiceCompat.b)localObject, d);
  }
}
