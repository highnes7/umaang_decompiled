package support.android.v4.asm;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat.f;
import android.support.v4.media.MediaBrowserServiceCompat.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main
  extends MediaBrowserServiceCompat.i<List<MediaBrowserCompat.MediaItem>>
{
  public Main(MediaBrowserServiceCompat.f paramF, Object paramObject, SimpleArrayMap paramSimpleArrayMap)
  {
    super(paramObject);
  }
  
  public void detach()
  {
    request.clear();
  }
  
  public void onLoadChildren(List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (MediaBrowserCompat.MediaItem)localIterator.next();
        Parcel localParcel = Parcel.obtain();
        paramList.writeToParcel(localParcel, 0);
        localArrayList.add(localParcel);
      }
    }
    paramList = null;
    request.get(paramList, get());
  }
}
