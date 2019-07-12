package support.android.v4.asm;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import b.b.a.K;
import b.b.x.h.u.a;

@K(23)
public class MediaBrowserCompatApi23
{
  public MediaBrowserCompatApi23() {}
  
  public static Object createItemCallback(ItemCallback paramItemCallback)
  {
    return new ItemCallbackProxy();
  }
  
  public static void getItem(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).getItem(paramString, (MediaBrowser.ItemCallback)paramObject2);
  }
  
  public abstract interface ItemCallback
  {
    public abstract void onError(String paramString);
    
    public abstract void onItemLoaded(Parcel paramParcel);
  }
  
  public class ItemCallbackProxy<T extends u.a>
    extends MediaBrowser.ItemCallback
  {
    public ItemCallbackProxy() {}
    
    public void onError(String paramString)
    {
      MediaBrowserCompatApi23.this.onError(paramString);
    }
    
    public void onItemLoaded(MediaBrowser.MediaItem paramMediaItem)
    {
      if (paramMediaItem == null)
      {
        onItemLoaded(null);
        return;
      }
      Parcel localParcel = Parcel.obtain();
      paramMediaItem.writeToParcel(localParcel, 0);
      onItemLoaded(localParcel);
    }
  }
}
