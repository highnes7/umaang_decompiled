package support.android.v4.asm;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat.i;
import android.support.v4.os.ResultReceiver;
import java.util.List;

public class x
  extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>>
{
  public x(MediaBrowserServiceCompat paramMediaBrowserServiceCompat, Object paramObject, ResultReceiver paramResultReceiver)
  {
    super(paramObject);
  }
  
  public void a(List paramList)
  {
    if (((get() & 0x4) == 0) && (paramList != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelableArray("search_results", (Parcelable[])paramList.toArray(new MediaBrowserCompat.MediaItem[0]));
      b.send(0, localBundle);
      return;
    }
    b.send(-1, null);
  }
}
