package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaController.TransportControls;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.package_7.BundleCompat;
import android.support.v4.package_7.SupportActivity;
import android.support.v4.package_7.SupportActivity.ExtraData;
import android.text.TextUtils;
import android.view.KeyEvent;
import b.b.a.K;
import b.b.a.N;
import b.b.a.t;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import support.android.v4.asm.session.IMediaControllerCallback;
import support.android.v4.asm.session.IMediaControllerCallback.Stub;
import support.android.v4.asm.session.IMediaSession;
import support.android.v4.asm.session.IMediaSession.Stub;
import support.android.v4.asm.session.MediaControllerCompat.Callback;
import support.android.v4.asm.session.MediaControllerCompat.Callback.StubCompat;
import support.android.v4.asm.session.MediaControllerCompat.TransportControls;
import support.android.v4.asm.session.MediaControllerCompatApi21;
import support.android.v4.asm.session.MediaControllerCompatApi21.PlaybackInfo;

public final class MediaControllerCompat
{
  @N({b.b.a.N.a.a})
  public static final String ACTION_ERROR = "android.support.v4.media.session.command.ARGUMENT_INDEX";
  @N({b.b.a.N.a.a})
  public static final String ACTION_UPDATE_ALL = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
  @N({b.b.a.N.a.a})
  public static final String CANCEL_MENU = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
  @N({b.b.a.N.a.a})
  public static final String EVENTLOG_URL = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
  @N({b.b.a.N.a.a})
  public static final String EXTRA_SEARCH_TERM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
  @N({b.b.a.N.a.a})
  public static final String MODULE_PACKAGE = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
  @N({b.b.a.N.a.a})
  public static final String PAGE_KEY = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
  public static final String TAG = "MediaControllerCompat";
  public final c mImpl;
  public final MediaSessionCompat.Token mToken;
  public final HashSet<a> this$0 = new HashSet();
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat.Token paramToken)
    throws RemoteException
  {
    if (paramToken != null)
    {
      mToken = paramToken;
      int i = Build.VERSION.SDK_INT;
      if (i >= 24)
      {
        mImpl = new e(paramContext, paramToken);
        return;
      }
      if (i >= 23)
      {
        mImpl = new d(paramContext, paramToken);
        return;
      }
      if (i >= 21)
      {
        mImpl = new MediaControllerImplApi21(paramContext, paramToken);
        return;
      }
      mImpl = new f(paramToken);
      return;
    }
    throw new IllegalArgumentException("sessionToken must not be null");
  }
  
  public MediaControllerCompat(Context paramContext, MediaSessionCompat paramMediaSessionCompat) {}
  
  public static MediaControllerCompat a(Activity paramActivity)
  {
    if ((paramActivity instanceof SupportActivity))
    {
      paramActivity = (b)((SupportActivity)paramActivity).getExtraData(b.class);
      if (paramActivity != null) {
        return paramActivity.getRectF();
      }
    }
    else
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = paramActivity.getMediaController();
        if (localObject == null) {
          return null;
        }
        localObject = MediaControllerCompatApi21.getSessionToken(localObject);
      }
      try
      {
        paramActivity = new MediaControllerCompat(paramActivity, MediaSessionCompat.Token.fromToken(localObject));
        return paramActivity;
      }
      catch (RemoteException paramActivity) {}
      return null;
    }
    return null;
  }
  
  public static void put(String paramString, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    int i = -1;
    int j = paramString.hashCode();
    if (j != -1348483723)
    {
      if ((j == 503011406) && (paramString.equals("android.support.v4.media.session.action.UNFOLLOW"))) {
        i = 1;
      }
    }
    else if (paramString.equals("android.support.v4.media.session.action.FOLLOW")) {
      i = 0;
    }
    if ((i != 0) && (i != 1)) {
      return;
    }
    if ((paramBundle != null) && (paramBundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE"))) {
      return;
    }
    throw new IllegalArgumentException(StringBuilder.append("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ", paramString, "."));
  }
  
  public static void showNotification(Activity paramActivity, MediaControllerCompat paramMediaControllerCompat)
  {
    if ((paramActivity instanceof SupportActivity)) {
      ((SupportActivity)paramActivity).putExtraData(new b(paramMediaControllerCompat));
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = null;
      if (paramMediaControllerCompat != null) {
        localObject = MediaControllerCompatApi21.fromToken(paramActivity, paramMediaControllerCompat.getSessionToken().get());
      }
      paramActivity.setMediaController((MediaController)localObject);
    }
  }
  
  public void addSample(int paramInt)
  {
    Object localObject = getQueue();
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (MediaSessionCompat.QueueItem)((List)localObject).get(paramInt);
      if (localObject != null) {
        sendCommand(((MediaSessionCompat.QueueItem)localObject).getDescription());
      }
    }
  }
  
  public int adjustVolume()
  {
    return mImpl.adjustVolume();
  }
  
  public void adjustVolume(int paramInt1, int paramInt2)
  {
    mImpl.adjustVolume(paramInt1, paramInt2);
  }
  
  public boolean dispatchMediaButtonEvent()
  {
    return mImpl.dispatchMediaButtonEvent();
  }
  
  public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent != null) {
      return mImpl.dispatchMediaButtonEvent(paramKeyEvent);
    }
    throw new IllegalArgumentException("KeyEvent may not be null");
  }
  
  public Bundle doInBackground()
  {
    return mToken.getToken();
  }
  
  public boolean f()
  {
    return mImpl.f();
  }
  
  public Bundle getExtras()
  {
    return mImpl.getExtras();
  }
  
  public long getFlags()
  {
    return mImpl.getFlags();
  }
  
  public void getFlags(MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    mImpl.getFlags(paramMediaDescriptionCompat);
  }
  
  public Object getMediaController()
  {
    return mImpl.getMediaController();
  }
  
  public MediaMetadataCompat getMetadata()
  {
    return mImpl.getMetadata();
  }
  
  public String getPackageName()
  {
    return mImpl.getPackageName();
  }
  
  public g getPlaybackInfo()
  {
    return mImpl.getPlaybackInfo();
  }
  
  public PlaybackStateCompat getPlaybackState()
  {
    return mImpl.getPlaybackState();
  }
  
  public List getQueue()
  {
    return mImpl.getQueue();
  }
  
  public CharSequence getQueueTitle()
  {
    return mImpl.getQueueTitle();
  }
  
  public int getRatingType()
  {
    return mImpl.getRatingType();
  }
  
  public PendingIntent getSessionActivity()
  {
    return mImpl.getSessionActivity();
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return mToken;
  }
  
  public h getTransportControls()
  {
    return mImpl.getTransportControls();
  }
  
  public void registerCallback(a paramA)
  {
    registerCallback(paramA, null);
  }
  
  public void registerCallback(a paramA, Handler paramHandler)
  {
    if (paramA != null)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler();
      }
      paramA.a(localHandler);
      mImpl.registerCallback(paramA, localHandler);
      this$0.add(paramA);
      return;
    }
    throw new IllegalArgumentException("callback must not be null");
  }
  
  public int sendCommand()
  {
    return mImpl.sendCommand();
  }
  
  public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat)
  {
    mImpl.sendCommand(paramMediaDescriptionCompat);
  }
  
  public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
  {
    mImpl.sendCommand(paramMediaDescriptionCompat, paramInt);
  }
  
  public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mImpl.sendCommand(paramString, paramBundle, paramResultReceiver);
      return;
    }
    throw new IllegalArgumentException("command must neither be null nor empty");
  }
  
  public void setVolumeTo(int paramInt1, int paramInt2)
  {
    mImpl.setVolumeTo(paramInt1, paramInt2);
  }
  
  public void unregisterCallback(a paramA)
  {
    if (paramA != null) {
      try
      {
        this$0.remove(paramA);
        mImpl.unregisterCallback(paramA);
        paramA.a(null);
        return;
      }
      catch (Throwable localThrowable)
      {
        paramA.a(null);
        throw localThrowable;
      }
    }
    throw new IllegalArgumentException("callback must not be null");
  }
  
  @K(21)
  public static class MediaControllerImplApi21
    implements MediaControllerCompat.c
  {
    public HashMap<MediaControllerCompat.a, a> TAG = new HashMap();
    @t("mLock")
    public final List<MediaControllerCompat.a> callbacks = new ArrayList();
    public final Object mControllerObj;
    public final Object mService = new Object();
    public final MediaSessionCompat.Token this$0;
    
    public MediaControllerImplApi21(Context paramContext, MediaSessionCompat.Token paramToken)
      throws RemoteException
    {
      this$0 = paramToken;
      mControllerObj = MediaControllerCompatApi21.fromToken(paramContext, this$0.get());
      if (mControllerObj != null)
      {
        if (this$0.e() == null) {
          setRepeat();
        }
      }
      else {
        throw new RemoteException();
      }
    }
    
    private void setRepeat()
    {
      sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
    }
    
    public int adjustVolume()
    {
      MediaSessionCompat.Token localToken;
      if ((Build.VERSION.SDK_INT < 22) && (this$0.e() != null)) {
        localToken = this$0;
      }
      try
      {
        int i = localToken.e().getRatingType();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return MediaControllerCompatApi21.getRatingType(mControllerObj);
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      ((MediaController)mControllerObj).adjustVolume(paramInt1, paramInt2);
    }
    
    public boolean dispatchMediaButtonEvent()
    {
      MediaSessionCompat.Token localToken;
      if (this$0.e() != null) {
        localToken = this$0;
      }
      try
      {
        boolean bool = localToken.e().play();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return false;
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      return MediaControllerCompatApi21.dispatchMediaButtonEvent(mControllerObj, paramKeyEvent);
    }
    
    public void doInBackground()
    {
      if (this$0.e() == null) {
        return;
      }
      Iterator localIterator = callbacks.iterator();
      for (;;)
      {
        MediaControllerCompat.a localA;
        a localA1;
        MediaSessionCompat.Token localToken;
        if (localIterator.hasNext())
        {
          localA = (MediaControllerCompat.a)localIterator.next();
          localA1 = new a(localA);
          TAG.put(localA, localA1);
          a = localA1;
          localToken = this$0;
        }
        try
        {
          localToken.e().registerCallbackListener(localA1);
          localA.post(13, null, null);
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
      callbacks.clear();
    }
    
    public boolean f()
    {
      return this$0.e() != null;
    }
    
    public Bundle getExtras()
    {
      return MediaControllerCompatApi21.getExtras(mControllerObj);
    }
    
    public long getFlags()
    {
      return MediaControllerCompatApi21.getFlags(mControllerObj);
    }
    
    public void getFlags(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      if ((getFlags() & 0x4) != 0L)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", paramMediaDescriptionCompat);
        sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", localBundle, null);
        return;
      }
      throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public Object getMediaController()
    {
      return mControllerObj;
    }
    
    public MediaMetadataCompat getMetadata()
    {
      Object localObject = MediaControllerCompatApi21.getMetadata(mControllerObj);
      if (localObject != null) {
        return MediaMetadataCompat.fromMediaMetadata(localObject);
      }
      return null;
    }
    
    public String getPackageName()
    {
      return MediaControllerCompatApi21.getPackageName(mControllerObj);
    }
    
    public MediaControllerCompat.g getPlaybackInfo()
    {
      Object localObject = MediaControllerCompatApi21.getPlaybackInfo(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.g(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(localObject), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(localObject), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(localObject), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(localObject), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(localObject));
      }
      return null;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      if (this$0.e() != null) {
        localObject = this$0;
      }
      try
      {
        localObject = ((MediaSessionCompat.Token)localObject).e().getPlaybackState();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      Object localObject = MediaControllerCompatApi21.getPlaybackState(mControllerObj);
      if (localObject != null) {
        return PlaybackStateCompat.fromPlaybackState(localObject);
      }
      return null;
    }
    
    public List getQueue()
    {
      List localList = MediaControllerCompatApi21.getQueue(mControllerObj);
      if (localList != null) {
        return MediaSessionCompat.QueueItem.getPath(localList);
      }
      return null;
    }
    
    public CharSequence getQueueTitle()
    {
      return MediaControllerCompatApi21.getQueueTitle(mControllerObj);
    }
    
    public int getRatingType()
    {
      MediaSessionCompat.Token localToken;
      if (this$0.e() != null) {
        localToken = this$0;
      }
      try
      {
        int i = localToken.e().getMaxAmplitude();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return -1;
    }
    
    public PendingIntent getSessionActivity()
    {
      return MediaControllerCompatApi21.getSessionActivity(mControllerObj);
    }
    
    public MediaControllerCompat.h getTransportControls()
    {
      Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.i(localObject);
      }
      return null;
    }
    
    public final void registerCallback(MediaControllerCompat.a paramA, Handler paramHandler)
    {
      MediaControllerCompatApi21.registerCallback(mControllerObj, mCallbackObj, paramHandler);
      paramHandler = mService;
      for (;;)
      {
        try
        {
          if (this$0.e() != null)
          {
            localA = new a(paramA);
            TAG.put(paramA, localA);
            a = localA;
            localToken = this$0;
          }
        }
        catch (Throwable paramA)
        {
          a localA;
          MediaSessionCompat.Token localToken;
          throw paramA;
        }
        try
        {
          localToken.e().registerCallbackListener(localA);
          paramA.post(13, null, null);
        }
        catch (RemoteException paramA) {}
      }
      a = null;
      callbacks.add(paramA);
    }
    
    public int sendCommand()
    {
      MediaSessionCompat.Token localToken;
      if (this$0.e() != null) {
        localToken = this$0;
      }
      try
      {
        int i = localToken.e().rate();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return -1;
    }
    
    public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      if ((getFlags() & 0x4) != 0L)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", paramMediaDescriptionCompat);
        sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", localBundle, null);
        return;
      }
      throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if ((getFlags() & 0x4) != 0L)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", paramMediaDescriptionCompat);
        localBundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", paramInt);
        sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", localBundle, null);
        return;
      }
      throw new UnsupportedOperationException("This session doesn't support queue management operations");
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      ((MediaController)mControllerObj).sendCommand(paramString, paramBundle, paramResultReceiver);
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2)
    {
      ((MediaController)mControllerObj).setVolumeTo(paramInt1, paramInt2);
    }
    
    public final void unregisterCallback(MediaControllerCompat.a paramA)
    {
      MediaControllerCompatApi21.unregisterCallback(mControllerObj, mCallbackObj);
      localObject1 = mService;
      for (;;)
      {
        try
        {
          localObject2 = this$0.e();
          if (localObject2 != null) {
            localObject2 = TAG;
          }
        }
        catch (Throwable paramA)
        {
          Object localObject2;
          throw paramA;
        }
        try
        {
          localObject2 = ((HashMap)localObject2).remove(paramA);
          localObject2 = (a)localObject2;
          if (localObject2 == null) {
            continue;
          }
          a = null;
          paramA = this$0;
          paramA.e().unregisterCallbackListener((IMediaControllerCallback)localObject2);
        }
        catch (RemoteException paramA) {}
      }
      callbacks.remove(paramA);
    }
    
    private static class ExtraBinderRequestResultReceiver
      extends ResultReceiver
    {
      public WeakReference<MediaControllerCompat.MediaControllerImplApi21> mProgressDialog;
      
      public ExtraBinderRequestResultReceiver(MediaControllerCompat.MediaControllerImplApi21 paramMediaControllerImplApi21)
      {
        super();
        mProgressDialog = new WeakReference(paramMediaControllerImplApi21);
      }
      
      public void onReceiveResult(int paramInt, Bundle paramBundle)
      {
        MediaControllerCompat.MediaControllerImplApi21 localMediaControllerImplApi21 = (MediaControllerCompat.MediaControllerImplApi21)mProgressDialog.get();
        if (localMediaControllerImplApi21 != null)
        {
          if (paramBundle == null) {
            return;
          }
          Object localObject = mService;
          try
          {
            this$0.finish(IMediaSession.Stub.asInterface(BundleCompat.getBinder(paramBundle, "android.support.v4.media.session.EXTRA_BINDER")));
            this$0.initialize(paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
            localMediaControllerImplApi21.doInBackground();
            return;
          }
          catch (Throwable paramBundle)
          {
            throw paramBundle;
          }
        }
      }
    }
    
    private static class a
      extends MediaControllerCompat.a.c
    {
      public a(MediaControllerCompat.a paramA)
      {
        super();
      }
      
      public void onEvent(Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onSessionDestroyed()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void send(CharSequence paramCharSequence)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void sendHit(List paramList)
        throws RemoteException
      {
        throw new AssertionError();
      }
    }
  }
  
  public static abstract class a
    implements IBinder.DeathRecipient
  {
    public IMediaControllerCallback a;
    public a j;
    public final Object mCallbackObj;
    
    public a()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        mCallbackObj = new MediaControllerCompat.Callback.StubCompat(new b(this));
        return;
      }
      c localC = new c(this);
      a = localC;
      mCallbackObj = localC;
    }
    
    public void a(Handler paramHandler)
    {
      if (paramHandler == null)
      {
        paramHandler = j;
        if (paramHandler != null)
        {
          l = false;
          paramHandler.removeCallbacksAndMessages(null);
          j = null;
        }
      }
      else
      {
        j = new a(paramHandler.getLooper());
        j.l = true;
      }
    }
    
    public void binderDied()
    {
      post(8, null, null);
    }
    
    public IMediaControllerCallback n()
    {
      return a;
    }
    
    public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) {}
    
    public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) {}
    
    public void post(int paramInt, Object paramObject, Bundle paramBundle)
    {
      a localA = j;
      if (localA != null)
      {
        paramObject = localA.obtainMessage(paramInt, paramObject);
        paramObject.setData(paramBundle);
        paramObject.sendToTarget();
      }
    }
    
    public void remove(List paramList) {}
    
    public void setId(int paramInt) {}
    
    public void setId(boolean paramBoolean) {}
    
    public void setName(int paramInt) {}
    
    public void setSize() {}
    
    public void setTime(String paramString, Bundle paramBundle) {}
    
    public void updateNotification() {}
    
    public void updateNotification(Bundle paramBundle) {}
    
    public void updateNotification(MediaControllerCompat.g paramG) {}
    
    public void updateNotification(CharSequence paramCharSequence) {}
    
    private class a
      extends Handler
    {
      public static final int DELETE_CONTEXT = 8;
      public static final int DIALOG_CANCEL = 5;
      public static final int DISK_CACHE_VERSION = 9;
      public static final int PRIORITY_MIDHIGH = 7;
      public static final int RB = 11;
      public static final int SELECT_FOLDER = 12;
      public static final int SORT_MENU_ITEM = 3;
      public static final int TYPE_DIALOG = 2;
      public static final int TYPE_EXPANDED = 1;
      public static final int TYPE_WILDCARD = 13;
      public static final int UPDATE_CONTEXT = 6;
      public static final int VIEW_SERIEDETAILS_CONTEXT = 4;
      public boolean l = false;
      
      public a(Looper paramLooper)
      {
        super();
      }
      
      public void handleMessage(Message paramMessage)
      {
        if (!l) {
          return;
        }
        switch (what)
        {
        default: 
          return;
        case 10: 
          return;
        case 13: 
          setSize();
          return;
        case 12: 
          setId(((Integer)obj).intValue());
          return;
        case 11: 
          setId(((Boolean)obj).booleanValue());
          return;
        case 9: 
          setName(((Integer)obj).intValue());
          return;
        case 8: 
          updateNotification();
          return;
        case 7: 
          paramMessage = (Bundle)obj;
          MediaSessionCompat.append(paramMessage);
          updateNotification(paramMessage);
          return;
        case 6: 
          updateNotification((CharSequence)obj);
          return;
        case 5: 
          remove((List)obj);
          return;
        case 4: 
          updateNotification((MediaControllerCompat.g)obj);
          return;
        case 3: 
          onMetadataChanged((MediaMetadataCompat)obj);
          return;
        case 2: 
          onPlaybackStateChanged((PlaybackStateCompat)obj);
          return;
        }
        Bundle localBundle = paramMessage.getData();
        MediaSessionCompat.append(localBundle);
        setTime((String)obj, localBundle);
      }
    }
    
    private static class b
      implements MediaControllerCompat.Callback
    {
      public final WeakReference<MediaControllerCompat.a> this$0;
      
      public b(MediaControllerCompat.a paramA)
      {
        this$0 = new WeakReference(paramA);
      }
      
      public void notifyProgress()
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.updateNotification();
        }
      }
      
      public void notifyProgress(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.updateNotification(new MediaControllerCompat.g(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
        }
      }
      
      public void notifyProgress(CharSequence paramCharSequence)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.updateNotification(paramCharSequence);
        }
      }
      
      public void onMetadataChanged(Object paramObject)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(paramObject));
        }
      }
      
      public void onPlaybackStateChanged(Object paramObject)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null)
        {
          if (a != null) {
            return;
          }
          localA.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(paramObject));
        }
      }
      
      public void pause(Bundle paramBundle)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.updateNotification(paramBundle);
        }
      }
      
      public void processMessage(String paramString, Bundle paramBundle)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null)
        {
          if ((a != null) && (Build.VERSION.SDK_INT < 23)) {
            return;
          }
          localA.setTime(paramString, paramBundle);
        }
      }
      
      public void recycle(List paramList)
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.remove(MediaSessionCompat.QueueItem.getPath(paramList));
        }
      }
    }
    
    private static class c
      extends IMediaControllerCallback.Stub
    {
      public final WeakReference<MediaControllerCompat.a> this$0;
      
      public c(MediaControllerCompat.a paramA)
      {
        this$0 = new WeakReference(paramA);
      }
      
      public void next(int paramInt)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(9, Integer.valueOf(paramInt), null);
        }
      }
      
      public void next(boolean paramBoolean)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(11, Boolean.valueOf(paramBoolean), null);
        }
      }
      
      public void onEvent()
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(13, null, null);
        }
      }
      
      public void onEvent(Bundle paramBundle)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(7, paramBundle, null);
        }
      }
      
      public void onEvent(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(1, paramString, paramBundle);
        }
      }
      
      public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(3, paramMediaMetadataCompat, null);
        }
      }
      
      public void onPitchAdjustmentAvailableChanged(boolean paramBoolean)
        throws RemoteException
      {}
      
      public void onPlaybackStateChanged(int paramInt)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(12, Integer.valueOf(paramInt), null);
        }
      }
      
      public void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(2, paramPlaybackStateCompat, null);
        }
      }
      
      public void onSessionDestroyed()
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(8, null, null);
        }
      }
      
      public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null)
        {
          if (paramParcelableVolumeInfo != null) {
            paramParcelableVolumeInfo = new MediaControllerCompat.g(volumeType, controlType, maxVolume, currentVolume, audioStream);
          } else {
            paramParcelableVolumeInfo = null;
          }
          localA.post(4, paramParcelableVolumeInfo, null);
        }
      }
      
      public void send(CharSequence paramCharSequence)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(6, paramCharSequence, null);
        }
      }
      
      public void sendHit(List paramList)
        throws RemoteException
      {
        MediaControllerCompat.a localA = (MediaControllerCompat.a)this$0.get();
        if (localA != null) {
          localA.post(5, paramList, null);
        }
      }
    }
  }
  
  private static class b
    extends SupportActivity.ExtraData
  {
    public final MediaControllerCompat x;
    
    public b(MediaControllerCompat paramMediaControllerCompat)
    {
      x = paramMediaControllerCompat;
    }
    
    public MediaControllerCompat getRectF()
    {
      return x;
    }
  }
  
  public static abstract interface c
  {
    public abstract int adjustVolume();
    
    public abstract void adjustVolume(int paramInt1, int paramInt2);
    
    public abstract boolean dispatchMediaButtonEvent();
    
    public abstract boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent);
    
    public abstract boolean f();
    
    public abstract Bundle getExtras();
    
    public abstract long getFlags();
    
    public abstract void getFlags(MediaDescriptionCompat paramMediaDescriptionCompat);
    
    public abstract Object getMediaController();
    
    public abstract MediaMetadataCompat getMetadata();
    
    public abstract String getPackageName();
    
    public abstract MediaControllerCompat.g getPlaybackInfo();
    
    public abstract PlaybackStateCompat getPlaybackState();
    
    public abstract List getQueue();
    
    public abstract CharSequence getQueueTitle();
    
    public abstract int getRatingType();
    
    public abstract PendingIntent getSessionActivity();
    
    public abstract MediaControllerCompat.h getTransportControls();
    
    public abstract void registerCallback(MediaControllerCompat.a paramA, Handler paramHandler);
    
    public abstract int sendCommand();
    
    public abstract void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat);
    
    public abstract void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt);
    
    public abstract void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver);
    
    public abstract void setVolumeTo(int paramInt1, int paramInt2);
    
    public abstract void unregisterCallback(MediaControllerCompat.a paramA);
  }
  
  @K(23)
  public static class d
    extends MediaControllerCompat.MediaControllerImplApi21
  {
    public d(Context paramContext, MediaSessionCompat.Token paramToken)
      throws RemoteException
    {
      super(paramToken);
    }
    
    public MediaControllerCompat.h getTransportControls()
    {
      Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.j(localObject);
      }
      return null;
    }
  }
  
  @K(24)
  public static class e
    extends MediaControllerCompat.d
  {
    public e(Context paramContext, MediaSessionCompat.Token paramToken)
      throws RemoteException
    {
      super(paramToken);
    }
    
    public MediaControllerCompat.h getTransportControls()
    {
      Object localObject = MediaControllerCompatApi21.getTransportControls(mControllerObj);
      if (localObject != null) {
        return new MediaControllerCompat.k(localObject);
      }
      return null;
    }
  }
  
  public static class f
    implements MediaControllerCompat.c
  {
    public IMediaSession mBinder;
    public MediaControllerCompat.h mTransportControls;
    
    public f(MediaSessionCompat.Token paramToken)
    {
      mBinder = IMediaSession.Stub.asInterface((IBinder)paramToken.get());
    }
    
    public int adjustVolume()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        int i = localIMediaSession.getRatingType();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return 0;
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.adjustVolume(paramInt1, paramInt2, null);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public boolean dispatchMediaButtonEvent()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        boolean bool = localIMediaSession.play();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return false;
    }
    
    public boolean dispatchMediaButtonEvent(KeyEvent paramKeyEvent)
    {
      IMediaSession localIMediaSession;
      if (paramKeyEvent != null) {
        localIMediaSession = mBinder;
      }
      try
      {
        localIMediaSession.sendMediaButton(paramKeyEvent);
        return false;
        throw new IllegalArgumentException("event may not be null.");
      }
      catch (RemoteException paramKeyEvent)
      {
        for (;;) {}
      }
    }
    
    public boolean f()
    {
      return true;
    }
    
    public Bundle getExtras()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getExtras();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public long getFlags()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        long l = localIMediaSession.getFlags();
        return l;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return 0L;
    }
    
    public void getFlags(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        long l = localIMediaSession.getFlags();
        if ((l & 0x4) != 0L)
        {
          localIMediaSession = mBinder;
          localIMediaSession.rate(paramMediaDescriptionCompat);
          return;
        }
        paramMediaDescriptionCompat = new UnsupportedOperationException("This session doesn't support queue management operations");
        throw paramMediaDescriptionCompat;
      }
      catch (RemoteException paramMediaDescriptionCompat) {}
    }
    
    public Object getMediaController()
    {
      return null;
    }
    
    public MediaMetadataCompat getMetadata()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getMetadata();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public String getPackageName()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getPackageName();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public MediaControllerCompat.g getPlaybackInfo()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getVolumeAttributes();
        int i = volumeType;
        int j = controlType;
        int k = maxVolume;
        int m = currentVolume;
        int n = audioStream;
        localObject = new MediaControllerCompat.g(i, j, k, m, n);
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public PlaybackStateCompat getPlaybackState()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getPlaybackState();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public List getQueue()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getQueue();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public CharSequence getQueueTitle()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getQueueTitle();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public int getRatingType()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        int i = localIMediaSession.getMaxAmplitude();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return -1;
    }
    
    public PendingIntent getSessionActivity()
    {
      Object localObject = mBinder;
      try
      {
        localObject = ((IMediaSession)localObject).getLaunchPendingIntent();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return null;
    }
    
    public MediaControllerCompat.h getTransportControls()
    {
      if (mTransportControls == null) {
        mTransportControls = new MediaControllerCompat.l(mBinder);
      }
      return mTransportControls;
    }
    
    public void registerCallback(MediaControllerCompat.a paramA, Handler paramHandler)
    {
      if (paramA != null) {
        paramHandler = mBinder;
      }
      try
      {
        paramHandler.asBinder().linkToDeath(paramA, 0);
        paramHandler = mBinder;
        IMediaControllerCallback localIMediaControllerCallback = (IMediaControllerCallback)mCallbackObj;
        paramHandler.registerCallbackListener(localIMediaControllerCallback);
        paramA.post(13, null, null);
        return;
      }
      catch (RemoteException paramHandler)
      {
        for (;;) {}
      }
      paramA.post(8, null, null);
      return;
      throw new IllegalArgumentException("callback may not be null.");
    }
    
    public int sendCommand()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        int i = localIMediaSession.rate();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      return -1;
    }
    
    public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        long l = localIMediaSession.getFlags();
        if ((l & 0x4) != 0L)
        {
          localIMediaSession = mBinder;
          localIMediaSession.sendCommand(paramMediaDescriptionCompat);
          return;
        }
        paramMediaDescriptionCompat = new UnsupportedOperationException("This session doesn't support queue management operations");
        throw paramMediaDescriptionCompat;
      }
      catch (RemoteException paramMediaDescriptionCompat) {}
    }
    
    public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        long l = localIMediaSession.getFlags();
        if ((l & 0x4) != 0L)
        {
          localIMediaSession = mBinder;
          localIMediaSession.seekTo(paramMediaDescriptionCompat, paramInt);
          return;
        }
        paramMediaDescriptionCompat = new UnsupportedOperationException("This session doesn't support queue management operations");
        throw paramMediaDescriptionCompat;
      }
      catch (RemoteException paramMediaDescriptionCompat) {}
    }
    
    public void sendCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.sendCommand(paramString, paramBundle, new MediaSessionCompat.ResultReceiverWrapper(paramResultReceiver));
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void setVolumeTo(int paramInt1, int paramInt2)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.setVolumeTo(paramInt1, paramInt2, null);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void unregisterCallback(MediaControllerCompat.a paramA)
    {
      IMediaSession localIMediaSession;
      IMediaControllerCallback localIMediaControllerCallback;
      if (paramA != null)
      {
        localIMediaSession = mBinder;
        localIMediaControllerCallback = (IMediaControllerCallback)mCallbackObj;
      }
      try
      {
        localIMediaSession.unregisterCallbackListener(localIMediaControllerCallback);
        localIMediaSession = mBinder;
        localIMediaSession.asBinder().unlinkToDeath(paramA, 0);
        return;
      }
      catch (RemoteException paramA) {}
      throw new IllegalArgumentException("callback may not be null.");
    }
  }
  
  public static final class g
  {
    public static final int TYPE_DIALOG = 2;
    public static final int TYPE_EXPANDED = 1;
    public final int a;
    public final int d;
    public final int f;
    public final int k;
    public final int points;
    
    public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      k = paramInt1;
      a = paramInt2;
      d = paramInt3;
      f = paramInt4;
      points = paramInt5;
    }
    
    public int b()
    {
      return d;
    }
    
    public int c()
    {
      return f;
    }
    
    public int getCellWidth()
    {
      return a;
    }
    
    public int getRenderMode()
    {
      return k;
    }
    
    public int points()
    {
      return points;
    }
  }
  
  public static abstract class h
  {
    public static final String PAGE_KEY = "android.media.session.extra.LEGACY_STREAM_TYPE";
    
    public h() {}
    
    public abstract void e(String paramString, Bundle paramBundle);
    
    public abstract void fastForward();
    
    public abstract void fastForward(long paramLong);
    
    public abstract void fastForward(String paramString, Bundle paramBundle);
    
    public abstract void openUrl(RatingCompat paramRatingCompat, Bundle paramBundle);
    
    public abstract void pause();
    
    public abstract void pause(int paramInt);
    
    public abstract void pause(Uri paramUri, Bundle paramBundle);
    
    public abstract void pause(String paramString, Bundle paramBundle);
    
    public abstract void pause(boolean paramBoolean);
    
    public abstract void play();
    
    public abstract void playFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void playFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void playFromUri(Uri paramUri, Bundle paramBundle);
    
    public abstract void rewind();
    
    public abstract void rewind(int paramInt);
    
    public abstract void sendCustomAction();
    
    public abstract void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle);
    
    public abstract void setRating(RatingCompat paramRatingCompat);
    
    public abstract void skipToNext();
    
    public abstract void skipToPrevious();
    
    public abstract void skipToQueueItem(long paramLong);
    
    public abstract void stop();
  }
  
  public static class i
    extends MediaControllerCompat.h
  {
    public final Object mControlsObj;
    
    public i(Object paramObject)
    {
      mControlsObj = paramObject;
    }
    
    public void e(String paramString, Bundle paramBundle)
    {
      MediaControllerCompat.put(paramString, paramBundle);
      ((MediaController.TransportControls)mControlsObj).sendCustomAction(paramString, paramBundle);
    }
    
    public void fastForward()
    {
      ((MediaController.TransportControls)mControlsObj).fastForward();
    }
    
    public void fastForward(long paramLong)
    {
      ((MediaController.TransportControls)mControlsObj).seekTo(paramLong);
    }
    
    public void fastForward(String paramString, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", paramString);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      e("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", localBundle);
    }
    
    public void openUrl(RatingCompat paramRatingCompat, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", paramRatingCompat);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      e("android.support.v4.media.session.action.SET_RATING", localBundle);
    }
    
    public void pause()
    {
      ((MediaController.TransportControls)mControlsObj).pause();
    }
    
    public void pause(int paramInt)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", paramInt);
      e("android.support.v4.media.session.action.SET_SHUFFLE_MODE", localBundle);
    }
    
    public void pause(Uri paramUri, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", paramUri);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      e("android.support.v4.media.session.action.PREPARE_FROM_URI", localBundle);
    }
    
    public void pause(String paramString, Bundle paramBundle)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", paramString);
      localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
      e("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", localBundle);
    }
    
    public void pause(boolean paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", paramBoolean);
      e("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", localBundle);
    }
    
    public void play()
    {
      e("android.support.v4.media.session.action.PREPARE", null);
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)mControlsObj).playFromMediaId(paramString, paramBundle);
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)mControlsObj).playFromSearch(paramString, paramBundle);
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      if ((paramUri != null) && (!Uri.EMPTY.equals(paramUri)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", paramUri);
        localBundle.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", paramBundle);
        e("android.support.v4.media.session.action.PLAY_FROM_URI", localBundle);
        return;
      }
      throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
    }
    
    public void rewind()
    {
      ((MediaController.TransportControls)mControlsObj).rewind();
    }
    
    public void rewind(int paramInt)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", paramInt);
      e("android.support.v4.media.session.action.SET_REPEAT_MODE", localBundle);
    }
    
    public void sendCustomAction()
    {
      ((MediaController.TransportControls)mControlsObj).play();
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle)
    {
      MediaControllerCompat.put(paramCustomAction.getAction(), paramBundle);
      Object localObject = mControlsObj;
      paramCustomAction = paramCustomAction.getAction();
      ((MediaController.TransportControls)localObject).sendCustomAction(paramCustomAction, paramBundle);
    }
    
    public void setRating(RatingCompat paramRatingCompat)
    {
      Object localObject = mControlsObj;
      if (paramRatingCompat != null) {
        paramRatingCompat = paramRatingCompat.getRating();
      } else {
        paramRatingCompat = null;
      }
      MediaControllerCompat.TransportControls.setRating(localObject, paramRatingCompat);
    }
    
    public void skipToNext()
    {
      ((MediaController.TransportControls)mControlsObj).skipToNext();
    }
    
    public void skipToPrevious()
    {
      ((MediaController.TransportControls)mControlsObj).skipToPrevious();
    }
    
    public void skipToQueueItem(long paramLong)
    {
      ((MediaController.TransportControls)mControlsObj).skipToQueueItem(paramLong);
    }
    
    public void stop()
    {
      ((MediaController.TransportControls)mControlsObj).stop();
    }
  }
  
  @K(23)
  public static class j
    extends MediaControllerCompat.i
  {
    public j(Object paramObject)
    {
      super();
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      ((MediaController.TransportControls)mControlsObj).playFromUri(paramUri, paramBundle);
    }
  }
  
  @K(24)
  public static class k
    extends MediaControllerCompat.j
  {
    public k(Object paramObject)
    {
      super();
    }
    
    public void fastForward(String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)mControlsObj).prepareFromMediaId(paramString, paramBundle);
    }
    
    public void pause(Uri paramUri, Bundle paramBundle)
    {
      ((MediaController.TransportControls)mControlsObj).prepareFromUri(paramUri, paramBundle);
    }
    
    public void pause(String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)mControlsObj).prepareFromSearch(paramString, paramBundle);
    }
    
    public void play()
    {
      ((MediaController.TransportControls)mControlsObj).prepare();
    }
  }
  
  public static class l
    extends MediaControllerCompat.h
  {
    public IMediaSession mBinder;
    
    public l(IMediaSession paramIMediaSession)
    {
      mBinder = paramIMediaSession;
    }
    
    public void e(String paramString, Bundle paramBundle)
    {
      MediaControllerCompat.put(paramString, paramBundle);
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.sendCustomAction(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void fastForward()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.fastForward();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void fastForward(long paramLong)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.seekTo(paramLong);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void fastForward(String paramString, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.sendCommand(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void openUrl(RatingCompat paramRatingCompat, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.rate(paramRatingCompat, paramBundle);
        return;
      }
      catch (RemoteException paramRatingCompat) {}
    }
    
    public void pause()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.pause();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void pause(int paramInt)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.next(paramInt);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void pause(Uri paramUri, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.sendCommand(paramUri, paramBundle);
        return;
      }
      catch (RemoteException paramUri) {}
    }
    
    public void pause(String paramString, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.pause(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void pause(boolean paramBoolean)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.next(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void play()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.seekTo();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void playFromMediaId(String paramString, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.playFromMediaId(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void playFromSearch(String paramString, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.playFromSearch(paramString, paramBundle);
        return;
      }
      catch (RemoteException paramString) {}
    }
    
    public void playFromUri(Uri paramUri, Bundle paramBundle)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.playFromUri(paramUri, paramBundle);
        return;
      }
      catch (RemoteException paramUri) {}
    }
    
    public void rewind()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.rewind();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void rewind(int paramInt)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.seekTo(paramInt);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void sendCustomAction()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.sendCustomAction();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void sendCustomAction(PlaybackStateCompat.CustomAction paramCustomAction, Bundle paramBundle)
    {
      e(paramCustomAction.getAction(), paramBundle);
    }
    
    public void setRating(RatingCompat paramRatingCompat)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.rate(paramRatingCompat);
        return;
      }
      catch (RemoteException paramRatingCompat) {}
    }
    
    public void skipToNext()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.next();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void skipToPrevious()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.previous();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void skipToQueueItem(long paramLong)
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.skipToQueueItem(paramLong);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    
    public void stop()
    {
      IMediaSession localIMediaSession = mBinder;
      try
      {
        localIMediaSession.stop();
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
  }
}
