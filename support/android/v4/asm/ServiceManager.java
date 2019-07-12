package support.android.v4.asm;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import b.b.a.K;

@K(26)
public class ServiceManager
{
  public ServiceManager() {}
  
  public static Object subscribe(Subscriber paramSubscriber)
  {
    return new MediaBrowserCompat.SubscriptionCallback(paramSubscriber);
  }
  
  public static void subscribe(Object paramObject1, String paramString, Bundle paramBundle, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).subscribe(paramString, paramBundle, (MediaBrowser.SubscriptionCallback)paramObject2);
  }
  
  public static void subscribe(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).unsubscribe(paramString, (MediaBrowser.SubscriptionCallback)paramObject2);
  }
}
