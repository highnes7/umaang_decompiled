package support.android.v4.asm;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService.BrowserRoot;
import android.service.media.MediaBrowserService.Result;
import android.support.v4.media.session.MediaSessionCompat;

public class Unit
  extends MediaBrowserService
{
  public final TransactionListener INSTANCE;
  
  public Unit(Context paramContext, TransactionListener paramTransactionListener)
  {
    attachBaseContext(paramContext);
    INSTANCE = paramTransactionListener;
  }
  
  public MediaBrowserService.BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle)
  {
    MediaSessionCompat.append(paramBundle);
    TransactionListener localTransactionListener = INSTANCE;
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    paramString = localTransactionListener.run(paramString, paramInt, paramBundle);
    if (paramString == null) {
      return null;
    }
    return new MediaBrowserService.BrowserRoot(text, context);
  }
  
  public void onLoadChildren(String paramString, MediaBrowserService.Result paramResult)
  {
    INSTANCE.d(paramString, new MediaBrowserCompat.MediaBrowserImplBase(paramResult));
  }
}
