package support.android.v4.asm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.MediaBrowserServiceCompat.a;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.j;
import android.support.v4.media.MediaBrowserServiceCompat.k;
import android.support.v4.media.session.MediaSessionCompat.Token;
import b.b.x.h.M;
import support.android.v4.util.SimpleArrayMap;

public class e
  implements Runnable
{
  public e(MediaBrowserServiceCompat.j paramJ, MediaBrowserServiceCompat.k paramK, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject1 = i.asBinder();
    j.this$0.m.remove(localObject1);
    Object localObject2 = new MediaBrowserServiceCompat.b(j.this$0, e, a, c, b, i);
    Object localObject3 = j.this$0;
    c = ((MediaBrowserServiceCompat.b)localObject2);
    b = ((MediaBrowserServiceCompat)localObject3).a(e, c, b);
    localObject3 = j.this$0;
    c = null;
    if (b == null)
    {
      localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No root for client ");
      ((StringBuilder)localObject1).append(e);
      ((StringBuilder)localObject1).append(" from service ");
      ((StringBuilder)localObject1).append(M.class.getName());
      ((StringBuilder)localObject1).toString();
      localObject1 = i;
    }
    try
    {
      ((MediaBrowserServiceCompat.k)localObject1).deleteContact();
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      for (;;) {}
    }
    localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Calling onConnectFailed() failed. Ignoring. pkg=");
    ((StringBuilder)localObject1).append(e);
    ((StringBuilder)localObject1).toString();
    return;
    localObject3 = m;
    try
    {
      ((SimpleArrayMap)localObject3).put(localObject1, localObject2);
      ((IBinder)localObject1).linkToDeath((IBinder.DeathRecipient)localObject2, 0);
      if (j.this$0.mSession == null) {
        return;
      }
      localObject3 = i;
      Object localObject4 = b;
      localObject4 = ((MediaBrowserServiceCompat.a)localObject4).b();
      MediaSessionCompat.Token localToken = j.this$0.mSession;
      localObject2 = b;
      ((MediaBrowserServiceCompat.k)localObject3).onConnect((String)localObject4, localToken, ((MediaBrowserServiceCompat.a)localObject2).c());
      return;
    }
    catch (RemoteException localRemoteException2)
    {
      for (;;) {}
    }
    localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Calling onConnect() failed. Dropping client. pkg=");
    ((StringBuilder)localObject2).append(e);
    ((StringBuilder)localObject2).toString();
    j.this$0.m.remove(localObject1);
    return;
  }
}
