package support.android.v4.asm;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession.Token;
import android.os.IBinder;
import android.service.media.MediaBrowserService;
import b.b.a.K;

@K(21)
public class ImageManager
{
  public ImageManager() {}
  
  public static void cleanup(Object paramObject)
  {
    ((MediaBrowserService)paramObject).onCreate();
  }
  
  public static IBinder onBind(Object paramObject, Intent paramIntent)
  {
    return ((MediaBrowserService)paramObject).onBind(paramIntent);
  }
  
  public static void put(Object paramObject1, Object paramObject2)
  {
    ((MediaBrowserService)paramObject1).setSessionToken((MediaSession.Token)paramObject2);
  }
  
  public static Object query(Context paramContext, TransactionListener paramTransactionListener)
  {
    return new Unit(paramContext, paramTransactionListener);
  }
  
  public static void writeFile(Object paramObject, String paramString)
  {
    ((MediaBrowserService)paramObject).notifyChildrenChanged(paramString);
  }
}
