package support.android.v4.asm;

import android.media.browse.MediaBrowser.MediaItem;

public class MediaDescriptionCompat
{
  public MediaDescriptionCompat() {}
  
  public static Object getDescription(Object paramObject)
  {
    return ((MediaBrowser.MediaItem)paramObject).getDescription();
  }
  
  public static int getFlags(Object paramObject)
  {
    return ((MediaBrowser.MediaItem)paramObject).getFlags();
  }
}
