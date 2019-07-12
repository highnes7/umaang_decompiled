package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public abstract class PlatformServiceClient
  implements ServiceConnection
{
  public final String applicationId;
  public final Context context;
  public final Handler handler;
  public CompletedListener listener;
  public final int protocolVersion;
  public int replyMessage;
  public int requestMessage;
  public boolean running;
  public Messenger sender;
  
  public PlatformServiceClient(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    context = paramContext;
    requestMessage = paramInt1;
    replyMessage = paramInt2;
    applicationId = paramString;
    protocolVersion = paramInt3;
    handler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        PlatformServiceClient.this.handleMessage(paramAnonymousMessage);
      }
    };
  }
  
  private void callback(Bundle paramBundle)
  {
    if (!running) {
      return;
    }
    running = false;
    CompletedListener localCompletedListener = listener;
    if (localCompletedListener != null) {
      localCompletedListener.completed(paramBundle);
    }
  }
  
  private void sendMessage()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("com.facebook.platform.extra.APPLICATION_ID", applicationId);
    populateRequestBundle((Bundle)localObject);
    Message localMessage = Message.obtain(null, requestMessage);
    arg1 = protocolVersion;
    localMessage.setData((Bundle)localObject);
    replyTo = new Messenger(handler);
    localObject = sender;
    try
    {
      ((Messenger)localObject).send(localMessage);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    callback(null);
  }
  
  public void cancel()
  {
    running = false;
  }
  
  public Context getContext()
  {
    return context;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (what == replyMessage)
    {
      paramMessage = paramMessage.getData();
      if (paramMessage.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
        callback(null);
      } else {
        callback(paramMessage);
      }
      context.unbindService(this);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    sender = new Messenger(paramIBinder);
    sendMessage();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    sender = null;
    paramComponentName = context;
    try
    {
      paramComponentName.unbindService(this);
      callback(null);
      return;
    }
    catch (IllegalArgumentException paramComponentName)
    {
      for (;;) {}
    }
  }
  
  public abstract void populateRequestBundle(Bundle paramBundle);
  
  public void setCompletedListener(CompletedListener paramCompletedListener)
  {
    listener = paramCompletedListener;
  }
  
  public boolean start()
  {
    if (running) {
      return false;
    }
    if (NativeProtocol.getLatestAvailableProtocolVersionForService(protocolVersion) == -1) {
      return false;
    }
    Intent localIntent = NativeProtocol.createPlatformServiceIntent(context);
    if (localIntent == null) {
      return false;
    }
    running = true;
    context.bindService(localIntent, this, 1);
    return true;
  }
  
  public static abstract interface CompletedListener
  {
    public abstract void completed(Bundle paramBundle);
  }
}
