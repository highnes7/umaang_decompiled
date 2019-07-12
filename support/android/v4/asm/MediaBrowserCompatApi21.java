package support.android.v4.asm;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import b.b.a.K;
import b.b.x.h.t.a;
import b.b.x.h.t.d;
import java.util.List;

@K(21)
public class MediaBrowserCompatApi21
{
  public static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";
  
  public MediaBrowserCompatApi21() {}
  
  public static void connect(Object paramObject)
  {
    ((MediaBrowser)paramObject).connect();
  }
  
  public static Object createBrowser(Context paramContext, ComponentName paramComponentName, Object paramObject, Bundle paramBundle)
  {
    return new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramObject, paramBundle);
  }
  
  public static Object createConnectionCallback(ConnectionCallback paramConnectionCallback)
  {
    return new ConnectionCallbackProxy();
  }
  
  public static Object createSubscriptionCallback(Subscription paramSubscription)
  {
    return new SubscriptionCallbackProxy();
  }
  
  public static void disconnect(Object paramObject)
  {
    ((MediaBrowser)paramObject).disconnect();
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getExtras();
  }
  
  public static String getRoot(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getRoot();
  }
  
  public static ComponentName getServiceComponent(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getServiceComponent();
  }
  
  public static Object getSessionToken(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getSessionToken();
  }
  
  public static boolean isConnected(Object paramObject)
  {
    return ((MediaBrowser)paramObject).isConnected();
  }
  
  public static void subscribe(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).subscribe(paramString, (MediaBrowser.SubscriptionCallback)paramObject2);
  }
  
  public static void unsubscribe(Object paramObject, String paramString)
  {
    ((MediaBrowser)paramObject).unsubscribe(paramString);
  }
  
  public abstract interface ConnectionCallback
  {
    public abstract void e();
    
    public abstract void onConnected();
    
    public abstract void setCheckable();
  }
  
  public class ConnectionCallbackProxy<T extends t.a>
    extends MediaBrowser.ConnectionCallback
  {
    public ConnectionCallbackProxy() {}
    
    public void onConnected()
    {
      MediaBrowserCompatApi21.this.onConnected();
    }
    
    public void onConnectionFailed()
    {
      e();
    }
    
    public void onConnectionSuspended()
    {
      setCheckable();
    }
  }
  
  public class SubscriptionCallbackProxy<T extends t.d>
    extends MediaBrowser.SubscriptionCallback
  {
    public SubscriptionCallbackProxy() {}
    
    public void onChildrenLoaded(String paramString, List paramList)
    {
      a(paramString, paramList);
    }
    
    public void onError(String paramString)
    {
      setTitle(paramString);
    }
  }
}
