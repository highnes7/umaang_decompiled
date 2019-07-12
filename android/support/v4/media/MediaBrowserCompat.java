package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.package_7.BundleCompat;
import android.text.TextUtils;
import android.util.Log;
import b.b.a.K;
import b.b.a.N;
import b.b.x.n.b;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import support.android.v4.asm.AgendaListView.2;
import support.android.v4.asm.AnnotationWriter;
import support.android.v4.asm.Channel;
import support.android.v4.asm.DayFragment.1;
import support.android.v4.asm.DownloaderService.LVLRunnable;
import support.android.v4.asm.Frame;
import support.android.v4.asm.Item;
import support.android.v4.asm.Local.1;
import support.android.v4.asm.MediaBrowserCompat.MediaBrowserImplBase.5;
import support.android.v4.asm.MediaBrowserCompat.SubscriptionCallback;
import support.android.v4.asm.MediaBrowserCompatApi21;
import support.android.v4.asm.MediaBrowserCompatApi21.ConnectionCallback;
import support.android.v4.asm.MediaBrowserCompatApi23;
import support.android.v4.asm.MediaBrowserCompatApi23.ItemCallback;
import support.android.v4.asm.MediaBrowserCompatApi23.ItemCallbackProxy;
import support.android.v4.asm.NotificationService.3;
import support.android.v4.asm.NumberPicker.BeginSoftInputOnLongPressCommand;
import support.android.v4.asm.NumberPicker.PressedStateHelper;
import support.android.v4.asm.ServiceManager;
import support.android.v4.asm.Session;
import support.android.v4.asm.Slider;
import support.android.v4.asm.Subscriber;
import support.android.v4.asm.Subscription;
import support.android.v4.asm.VerticalProgressBar.SavedState.1;
import support.android.v4.asm.WebSocketClient.1;
import support.android.v4.asm.a;
import support.android.v4.asm.session.IMediaSession;
import support.android.v4.asm.session.IMediaSession.Stub;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public final class MediaBrowserCompat
{
  public static final String ACTION_SHOW_PLAYER = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
  public static final String EVENTLOG_URL = "android.media.browse.extra.MEDIA_ID";
  public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
  public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
  public static final String MODULE_PACKAGE = "android.media.browse.extra.DOWNLOAD_PROGRESS";
  public static final String PAGE_KEY = "android.support.v4.media.action.DOWNLOAD";
  public static final String TAG = "MediaBrowserCompat";
  public static final boolean mState = Log.isLoggable("MediaBrowserCompat", 3);
  public final e mImpl;
  
  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, b paramB, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 26)
    {
      mImpl = new h(paramContext, paramComponentName, paramB, paramBundle);
      return;
    }
    if (i >= 23)
    {
      mImpl = new g(paramContext, paramComponentName, paramB, paramBundle);
      return;
    }
    if (i >= 21)
    {
      mImpl = new f(paramContext, paramComponentName, paramB, paramBundle);
      return;
    }
    mImpl = new i(paramContext, paramComponentName, paramB, paramBundle);
  }
  
  public void connect()
  {
    mImpl.connect();
  }
  
  public void disconnect()
  {
    mImpl.disconnect();
  }
  
  public Bundle getExtras()
  {
    return mImpl.getExtras();
  }
  
  public void getItem(String paramString, d paramD)
  {
    mImpl.getItem(paramString, paramD);
  }
  
  public String getRoot()
  {
    return mImpl.getRoot();
  }
  
  public ComponentName getServiceComponent()
  {
    return mImpl.getServiceComponent();
  }
  
  public MediaSessionCompat.Token getSessionToken()
  {
    return mImpl.getSessionToken();
  }
  
  public boolean isConnected()
  {
    return mImpl.isConnected();
  }
  
  public void subscribe(String paramString, Bundle paramBundle, n paramN)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramN != null)
      {
        if (paramBundle != null)
        {
          mImpl.subscribe(paramString, paramBundle, paramN);
          return;
        }
        throw new IllegalArgumentException("options are null");
      }
      throw new IllegalArgumentException("callback is null");
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  public void subscribe(String paramString, n paramN)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramN != null)
      {
        mImpl.subscribe(paramString, null, paramN);
        return;
      }
      throw new IllegalArgumentException("callback is null");
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  public Bundle unsubscribe()
  {
    return mImpl.d();
  }
  
  public void unsubscribe(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mImpl.onServiceConnected(paramString, null);
      return;
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  public void unsubscribe(String paramString, Bundle paramBundle, c paramC)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mImpl.connect(paramString, paramBundle, paramC);
      return;
    }
    throw new IllegalArgumentException("action cannot be empty");
  }
  
  public void unsubscribe(String paramString, Bundle paramBundle, k paramK)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramK != null)
      {
        mImpl.connect(paramString, paramBundle, paramK);
        return;
      }
      throw new IllegalArgumentException("callback cannot be null");
    }
    throw new IllegalArgumentException("query cannot be empty");
  }
  
  public void unsubscribe(String paramString, n paramN)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramN != null)
      {
        mImpl.onServiceConnected(paramString, paramN);
        return;
      }
      throw new IllegalArgumentException("callback is null");
    }
    throw new IllegalArgumentException("parentId is empty");
  }
  
  private static class CustomActionResultReceiver
    extends ResultReceiver
  {
    public final Bundle a;
    public final String i;
    public final MediaBrowserCompat.c j;
    
    public CustomActionResultReceiver(String paramString, Bundle paramBundle, MediaBrowserCompat.c paramC, Handler paramHandler)
    {
      super();
      i = paramString;
      a = paramBundle;
      j = paramC;
    }
    
    public void a(int paramInt, Bundle paramBundle)
    {
      if (j == null) {
        return;
      }
      MediaSessionCompat.append(paramBundle);
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown result code: ", paramInt, " (extras=");
            localStringBuilder.append(a);
            localStringBuilder.append(", resultData=");
            localStringBuilder.append(paramBundle);
            localStringBuilder.append(")");
            localStringBuilder.toString();
            return;
          }
          j.get(i, a, paramBundle);
          return;
        }
        j.b(i, a, paramBundle);
        return;
      }
      j.a(i, a, paramBundle);
    }
  }
  
  private static class ItemReceiver
    extends ResultReceiver
  {
    public final MediaBrowserCompat.d mCallback;
    public final String mMediaId;
    
    public ItemReceiver(String paramString, MediaBrowserCompat.d paramD, Handler paramHandler)
    {
      super();
      mMediaId = paramString;
      mCallback = paramD;
    }
    
    public void a(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.append(paramBundle);
      if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("media_item")))
      {
        paramBundle = paramBundle.getParcelable("media_item");
        if ((paramBundle != null) && (!(paramBundle instanceof MediaBrowserCompat.MediaItem)))
        {
          mCallback.a(mMediaId);
          return;
        }
        mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)paramBundle);
        return;
      }
      mCallback.a(mMediaId);
    }
  }
  
  public static class MediaItem
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaItem> CREATOR = new VerticalProgressBar.SavedState.1();
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    public final MediaDescriptionCompat mDescription;
    public final int mFlags;
    
    public MediaItem(Parcel paramParcel)
    {
      mFlags = paramParcel.readInt();
      mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }
    
    public MediaItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat != null)
      {
        if (!TextUtils.isEmpty(paramMediaDescriptionCompat.getMediaId()))
        {
          mFlags = paramInt;
          mDescription = paramMediaDescriptionCompat;
          return;
        }
        throw new IllegalArgumentException("description must have a non-empty media id");
      }
      throw new IllegalArgumentException("description cannot be null");
    }
    
    public static List a(List paramList)
    {
      if ((paramList != null) && (Build.VERSION.SDK_INT >= 21))
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(obtain(paramList.next()));
        }
        return localArrayList;
      }
      return null;
    }
    
    public static MediaItem obtain(Object paramObject)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
      {
        int i = support.android.v4.asm.MediaDescriptionCompat.getFlags(paramObject);
        return new MediaItem(MediaDescriptionCompat.fromMediaDescription(support.android.v4.asm.MediaDescriptionCompat.getDescription(paramObject)), i);
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public MediaDescriptionCompat getDescription()
    {
      return mDescription;
    }
    
    public int getFlags()
    {
      return mFlags;
    }
    
    public String getMediaId()
    {
      return mDescription.getMediaId();
    }
    
    public boolean isBrowsable()
    {
      return (mFlags & 0x1) != 0;
    }
    
    public boolean isPlayable()
    {
      return (mFlags & 0x2) != 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
      localStringBuilder.append("mFlags=");
      localStringBuilder.append(mFlags);
      localStringBuilder.append(", mDescription=");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(localStringBuilder, mDescription, '}');
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(mFlags);
      mDescription.writeToParcel(paramParcel, paramInt);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @N({b.b.a.N.a.b})
    public static @interface a {}
  }
  
  private static class SearchResultReceiver
    extends ResultReceiver
  {
    public final Bundle a;
    public final String d;
    public final MediaBrowserCompat.k j;
    
    public SearchResultReceiver(String paramString, Bundle paramBundle, MediaBrowserCompat.k paramK, Handler paramHandler)
    {
      super();
      d = paramString;
      a = paramBundle;
      j = paramK;
    }
    
    public void a(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.append(paramBundle);
      if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("search_results")))
      {
        Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("search_results");
        paramBundle = null;
        if (arrayOfParcelable != null)
        {
          ArrayList localArrayList = new ArrayList();
          int i = arrayOfParcelable.length;
          paramInt = 0;
          for (;;)
          {
            paramBundle = localArrayList;
            if (paramInt >= i) {
              break;
            }
            localArrayList.add((MediaBrowserCompat.MediaItem)arrayOfParcelable[paramInt]);
            paramInt += 1;
          }
        }
        j.a(d, a, paramBundle);
        return;
      }
      j.a(d, a);
    }
  }
  
  private static class a
    extends Handler
  {
    public WeakReference<Messenger> l;
    public final WeakReference<MediaBrowserCompat.j> view;
    
    public a(MediaBrowserCompat.j paramJ)
    {
      view = new WeakReference(paramJ);
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject1 = l;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        if (view.get() == null) {
          return;
        }
        Object localObject2 = paramMessage.getData();
        MediaSessionCompat.append((Bundle)localObject2);
        localObject1 = (MediaBrowserCompat.j)view.get();
        Messenger localMessenger = (Messenger)l.get();
        int i = what;
        if ((i == 1) || ((i == 2) || (i != 3))) {}
        try
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Unhandled message: ");
          ((StringBuilder)localObject2).append(paramMessage);
          ((StringBuilder)localObject2).append("\n  Client version: ");
          ((StringBuilder)localObject2).append(1);
          ((StringBuilder)localObject2).append("\n  Service version: ");
          i = arg1;
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).toString();
          return;
        }
        catch (BadParcelableException localBadParcelableException)
        {
          Bundle localBundle;
          Object localObject3;
          for (;;) {}
        }
        localBundle = ((Bundle)localObject2).getBundle("data_options");
        MediaSessionCompat.append(localBundle);
        localObject3 = ((Bundle)localObject2).getBundle("data_notify_children_changed_options");
        MediaSessionCompat.append((Bundle)localObject3);
        ((MediaBrowserCompat.j)localObject1).onLoadChildren(localMessenger, ((Bundle)localObject2).getString("data_media_item_id"), ((Bundle)localObject2).getParcelableArrayList("data_media_item_list"), localBundle, (Bundle)localObject3);
        return;
        ((MediaBrowserCompat.j)localObject1).onConnectionFailed(localMessenger);
        return;
        localBundle = ((Bundle)localObject2).getBundle("data_root_hints");
        MediaSessionCompat.append(localBundle);
        localObject3 = ((Bundle)localObject2).getString("data_media_item_id");
        localObject2 = ((Bundle)localObject2).getParcelable("data_media_session_token");
        localObject2 = (MediaSessionCompat.Token)localObject2;
        ((MediaBrowserCompat.j)localObject1).onServiceConnected(localMessenger, (String)localObject3, (MediaSessionCompat.Token)localObject2, localBundle);
        return;
        if (what == 1)
        {
          ((MediaBrowserCompat.j)localObject1).onConnectionFailed(localMessenger);
          return;
        }
      }
    }
    
    public void setCallbacksMessenger(Messenger paramMessenger)
    {
      l = new WeakReference(paramMessenger);
    }
  }
  
  public static class b
  {
    public final Object mConnectionCallbackObj;
    public a o;
    
    public b()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new b());
        return;
      }
      mConnectionCallbackObj = null;
    }
    
    public void a() {}
    
    public void b() {}
    
    public void b(a paramA)
    {
      o = paramA;
    }
    
    public void put() {}
    
    public static abstract interface a
    {
      public abstract void b();
      
      public abstract void onConnected();
      
      public abstract void onConnectionSuspended();
    }
    
    private class b
      implements MediaBrowserCompatApi21.ConnectionCallback
    {
      public b() {}
      
      public void e()
      {
        MediaBrowserCompat.b.a localA = o;
        if (localA != null) {
          localA.b();
        }
        put();
      }
      
      public void onConnected()
      {
        MediaBrowserCompat.b.a localA = o;
        if (localA != null) {
          localA.onConnected();
        }
        a();
      }
      
      public void setCheckable()
      {
        MediaBrowserCompat.b.a localA = o;
        if (localA != null) {
          localA.onConnectionSuspended();
        }
        b();
      }
    }
  }
  
  public static abstract class c
  {
    public c() {}
    
    public void a(String paramString, Bundle paramBundle1, Bundle paramBundle2) {}
    
    public void b(String paramString, Bundle paramBundle1, Bundle paramBundle2) {}
    
    public void get(String paramString, Bundle paramBundle1, Bundle paramBundle2) {}
  }
  
  public static abstract class d
  {
    public final Object mItemCallbackObj;
    
    public d()
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        mItemCallbackObj = new MediaBrowserCompatApi23.ItemCallbackProxy(new a());
        return;
      }
      mItemCallbackObj = null;
    }
    
    public void a(String paramString) {}
    
    public void onItemLoaded(MediaBrowserCompat.MediaItem paramMediaItem) {}
    
    private class a
      implements MediaBrowserCompatApi23.ItemCallback
    {
      public a() {}
      
      public void onError(String paramString)
      {
        a(paramString);
      }
      
      public void onItemLoaded(Parcel paramParcel)
      {
        if (paramParcel == null)
        {
          onItemLoaded(null);
          return;
        }
        paramParcel.setDataPosition(0);
        MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(paramParcel);
        paramParcel.recycle();
        onItemLoaded(localMediaItem);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void connect();
    
    public abstract void connect(String paramString, Bundle paramBundle, MediaBrowserCompat.c paramC);
    
    public abstract void connect(String paramString, Bundle paramBundle, MediaBrowserCompat.k paramK);
    
    public abstract Bundle d();
    
    public abstract void disconnect();
    
    public abstract Bundle getExtras();
    
    public abstract void getItem(String paramString, MediaBrowserCompat.d paramD);
    
    public abstract String getRoot();
    
    public abstract ComponentName getServiceComponent();
    
    public abstract MediaSessionCompat.Token getSessionToken();
    
    public abstract boolean isConnected();
    
    public abstract void onServiceConnected(String paramString, MediaBrowserCompat.n paramN);
    
    public abstract void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.n paramN);
  }
  
  @K(21)
  public static class f
    implements MediaBrowserCompat.e, MediaBrowserCompat.j, MediaBrowserCompat.b.a
  {
    public final Bundle arguments;
    public final Object mBrowserObj;
    public Messenger mCallbacksMessenger;
    public final MediaBrowserCompat.a mHandler = new MediaBrowserCompat.a(this);
    public MediaBrowserCompat.l mServiceBinderWrapper;
    public final Context mServiceComponent;
    public MediaSessionCompat.Token mSession;
    public int mState;
    public final b<String, MediaBrowserCompat.m> mSubscriptions = new ArrayMap();
    public Bundle s;
    
    public f(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramB, Bundle paramBundle)
    {
      mServiceComponent = paramContext;
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      }
      arguments = paramBundle;
      arguments.putInt("extra_client_version", 1);
      paramB.b(this);
      mBrowserObj = MediaBrowserCompatApi21.createBrowser(paramContext, paramComponentName, mConnectionCallbackObj, arguments);
    }
    
    public void b() {}
    
    public void connect()
    {
      MediaBrowserCompatApi21.connect(mBrowserObj);
    }
    
    public void connect(String paramString, Bundle paramBundle, MediaBrowserCompat.c paramC)
    {
      MediaBrowserCompat.l localL;
      Messenger localMessenger;
      if (isConnected())
      {
        if ((mServiceBinderWrapper == null) && (paramC != null)) {
          mHandler.post(new a(this, paramC, paramString, paramBundle));
        }
        localObject = new MediaBrowserCompat.CustomActionResultReceiver(paramString, paramBundle, paramC, mHandler);
        localL = mServiceBinderWrapper;
        localMessenger = mCallbacksMessenger;
      }
      try
      {
        localL.addSubscription(paramString, paramBundle, (ResultReceiver)localObject, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Remote error sending a custom action: action=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", extras=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).toString();
      if (paramC != null)
      {
        mHandler.post(new WebSocketClient.1(this, paramC, paramString, paramBundle));
        return;
        paramC = new StringBuilder();
        paramC.append("Cannot send a custom action (");
        paramC.append(paramString);
        paramC.append(") with ");
        paramC.append("extras ");
        paramC.append(paramBundle);
        throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramC, " because the browser is not connected to the ", "service."));
      }
    }
    
    public void connect(String paramString, Bundle paramBundle, MediaBrowserCompat.k paramK)
    {
      MediaBrowserCompat.SearchResultReceiver localSearchResultReceiver;
      MediaBrowserCompat.l localL;
      Messenger localMessenger;
      if (isConnected())
      {
        if (mServiceBinderWrapper == null)
        {
          mHandler.post(new NumberPicker.PressedStateHelper(this, paramK, paramString, paramBundle));
          return;
        }
        localSearchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(paramString, paramBundle, paramK, mHandler);
        localL = mServiceBinderWrapper;
        localMessenger = mCallbacksMessenger;
      }
      try
      {
        localL.removeSubscription(paramString, paramBundle, localSearchResultReceiver, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Remote error searching items with query: ", paramString);
      mHandler.post(new Session(this, paramK, paramString, paramBundle));
      return;
      throw new IllegalStateException("search() called while not connected");
    }
    
    public Bundle d()
    {
      return s;
    }
    
    public void disconnect()
    {
      MediaBrowserCompat.l localL = mServiceBinderWrapper;
      Messenger localMessenger;
      if (localL != null)
      {
        localMessenger = mCallbacksMessenger;
        if (localMessenger == null) {}
      }
      try
      {
        localL.unregisterCallbackMessenger(localMessenger);
        MediaBrowserCompatApi21.disconnect(mBrowserObj);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
    }
    
    public Bundle getExtras()
    {
      return MediaBrowserCompatApi21.getExtras(mBrowserObj);
    }
    
    public void getItem(String paramString, MediaBrowserCompat.d paramD)
    {
      MediaBrowserCompat.ItemReceiver localItemReceiver;
      MediaBrowserCompat.l localL;
      Messenger localMessenger;
      if (!TextUtils.isEmpty(paramString)) {
        if (paramD != null)
        {
          if (!MediaBrowserCompatApi21.isConnected(mBrowserObj))
          {
            mHandler.post(new AgendaListView.2(this, paramD, paramString));
            return;
          }
          if (mServiceBinderWrapper == null)
          {
            mHandler.post(new Channel(this, paramD, paramString));
            return;
          }
          localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramD, mHandler);
          localL = mServiceBinderWrapper;
          localMessenger = mCallbacksMessenger;
        }
      }
      try
      {
        localL.getMediaItem(paramString, localItemReceiver, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Remote error getting media item: ", paramString);
      mHandler.post(new NumberPicker.BeginSoftInputOnLongPressCommand(this, paramD, paramString));
      return;
      throw new IllegalArgumentException("cb is null");
      throw new IllegalArgumentException("mediaId is empty");
    }
    
    public String getRoot()
    {
      return MediaBrowserCompatApi21.getRoot(mBrowserObj);
    }
    
    public ComponentName getServiceComponent()
    {
      return MediaBrowserCompatApi21.getServiceComponent(mBrowserObj);
    }
    
    public MediaSessionCompat.Token getSessionToken()
    {
      if (mSession == null) {
        mSession = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(mBrowserObj));
      }
      return mSession;
    }
    
    public boolean isConnected()
    {
      return MediaBrowserCompatApi21.isConnected(mBrowserObj);
    }
    
    public void onConnected()
    {
      Object localObject1 = MediaBrowserCompatApi21.getExtras(mBrowserObj);
      if (localObject1 == null) {
        return;
      }
      mState = ((Bundle)localObject1).getInt("extra_service_version", 0);
      Object localObject2 = BundleCompat.getBinder((Bundle)localObject1, "extra_messenger");
      Context localContext;
      Messenger localMessenger;
      if (localObject2 != null)
      {
        mServiceBinderWrapper = new MediaBrowserCompat.l((IBinder)localObject2, arguments);
        mCallbacksMessenger = new Messenger(mHandler);
        mHandler.setCallbacksMessenger(mCallbacksMessenger);
        localObject2 = mServiceBinderWrapper;
        localContext = mServiceComponent;
        localMessenger = mCallbacksMessenger;
      }
      try
      {
        ((MediaBrowserCompat.l)localObject2).connect(localContext, localMessenger);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      localObject1 = IMediaSession.Stub.asInterface(BundleCompat.getBinder((Bundle)localObject1, "extra_session_binder"));
      if (localObject1 != null)
      {
        mSession = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(mBrowserObj), (IMediaSession)localObject1);
        return;
      }
    }
    
    public void onConnectionFailed(Messenger paramMessenger) {}
    
    public void onConnectionSuspended()
    {
      mServiceBinderWrapper = null;
      mCallbacksMessenger = null;
      mSession = null;
      mHandler.setCallbacksMessenger(null);
    }
    
    public void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (mCallbacksMessenger != paramMessenger) {
        return;
      }
      paramMessenger = (MediaBrowserCompat.m)mSubscriptions.get(paramString);
      if (paramMessenger == null)
      {
        if (MediaBrowserCompat.mState) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.get("onLoadChildren for id that isn't subscribed id=", paramString);
        }
      }
      else
      {
        paramMessenger = paramMessenger.a(paramBundle1);
        if (paramMessenger != null)
        {
          if (paramBundle1 == null)
          {
            if (paramList == null)
            {
              paramMessenger.b(paramString);
              return;
            }
            s = paramBundle2;
            paramMessenger.a(paramString, paramList);
            s = null;
            return;
          }
          if (paramList == null)
          {
            paramMessenger.b(paramString, paramBundle1);
            return;
          }
          s = paramBundle2;
          paramMessenger.add(paramString, paramList, paramBundle1);
          s = null;
        }
      }
    }
    
    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle) {}
    
    public void onServiceConnected(String paramString, MediaBrowserCompat.n paramN)
    {
      MediaBrowserCompat.m localM = (MediaBrowserCompat.m)mSubscriptions.get(paramString);
      if (localM == null) {
        return;
      }
      Object localObject1 = mServiceBinderWrapper;
      int j;
      if (localObject1 == null)
      {
        if (paramN == null)
        {
          MediaBrowserCompatApi21.unsubscribe(mBrowserObj, paramString);
        }
        else
        {
          localObject1 = localM.getValue();
          localObject2 = localM.get();
          i = ((List)localObject1).size();
          for (;;)
          {
            j = i - 1;
            if (j < 0) {
              break;
            }
            i = j;
            if (((List)localObject1).get(j) == paramN)
            {
              ((List)localObject1).remove(j);
              ((List)localObject2).remove(j);
              i = j;
            }
          }
          if (((List)localObject1).size() == 0) {
            MediaBrowserCompatApi21.unsubscribe(mBrowserObj, paramString);
          }
        }
      }
      else if (paramN == null) {
        localObject2 = mCallbacksMessenger;
      }
      try
      {
        ((MediaBrowserCompat.l)localObject1).addSubscription(paramString, null, (Messenger)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      localObject1 = localM.getValue();
      Object localObject2 = localM.get();
      int i = ((List)localObject1).size();
      for (;;)
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        Object localObject3 = ((List)localObject1).get(j);
        i = j;
        if (localObject3 == paramN)
        {
          localObject3 = mServiceBinderWrapper;
          IBinder localIBinder = mCallbacksMessenger;
          Messenger localMessenger = mCallbacksMessenger;
          ((MediaBrowserCompat.l)localObject3).addSubscription(paramString, localIBinder, localMessenger);
          ((List)localObject1).remove(j);
          ((List)localObject2).remove(j);
          i = j;
        }
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("removeSubscription failed with RemoteException parentId=", paramString);
      if ((localM.matches()) || (paramN == null))
      {
        mSubscriptions.remove(paramString);
        return;
      }
    }
    
    public void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.n paramN)
    {
      Object localObject2 = (MediaBrowserCompat.m)mSubscriptions.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new MediaBrowserCompat.m();
        mSubscriptions.put(paramString, localObject1);
      }
      paramN.b((MediaBrowserCompat.m)localObject1);
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = new Bundle(paramBundle);
      }
      ((MediaBrowserCompat.m)localObject1).a(paramBundle, paramN);
      localObject1 = mServiceBinderWrapper;
      if (localObject1 == null)
      {
        MediaBrowserCompatApi21.subscribe(mBrowserObj, paramString, name);
        return;
      }
      paramN = mCallbacksMessenger;
      localObject2 = mCallbacksMessenger;
      try
      {
        ((MediaBrowserCompat.l)localObject1).addSubscription(paramString, paramN, paramBundle, (Messenger)localObject2);
        return;
      }
      catch (RemoteException paramBundle)
      {
        for (;;) {}
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Remote error subscribing media item: ", paramString);
    }
  }
  
  @K(23)
  public static class g
    extends MediaBrowserCompat.f
  {
    public g(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramB, Bundle paramBundle)
    {
      super(paramComponentName, paramB, paramBundle);
    }
    
    public void getItem(String paramString, MediaBrowserCompat.d paramD)
    {
      if (mServiceBinderWrapper == null)
      {
        MediaBrowserCompatApi23.getItem(mBrowserObj, paramString, mItemCallbackObj);
        return;
      }
      super.getItem(paramString, paramD);
    }
  }
  
  @K(26)
  public static class h
    extends MediaBrowserCompat.g
  {
    public h(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramB, Bundle paramBundle)
    {
      super(paramComponentName, paramB, paramBundle);
    }
    
    public void onServiceConnected(String paramString, MediaBrowserCompat.n paramN)
    {
      if ((mServiceBinderWrapper != null) && (mState >= 2))
      {
        super.onServiceConnected(paramString, paramN);
        return;
      }
      if (paramN == null)
      {
        MediaBrowserCompatApi21.unsubscribe(mBrowserObj, paramString);
        return;
      }
      ServiceManager.subscribe(mBrowserObj, paramString, name);
    }
    
    public void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.n paramN)
    {
      if ((mServiceBinderWrapper != null) && (mState >= 2))
      {
        super.subscribe(paramString, paramBundle, paramN);
        return;
      }
      if (paramBundle == null)
      {
        MediaBrowserCompatApi21.subscribe(mBrowserObj, paramString, name);
        return;
      }
      ServiceManager.subscribe(mBrowserObj, paramString, paramBundle, name);
    }
  }
  
  public static class i
    implements MediaBrowserCompat.e, MediaBrowserCompat.j
  {
    public static final int SORT_MENU_ITEM = 3;
    public static final int TYPE_DIALOG = 2;
    public static final int TYPE_EXPANDED = 1;
    public static final int VIEW_LIST = 0;
    public static final int VIEW_SERIEDETAILS_CONTEXT = 4;
    public final MediaBrowserCompat.b mCallback;
    public Messenger mCallbacksMessenger;
    public final Context mContext;
    public Bundle mExtras;
    public final MediaBrowserCompat.a mHandler = new MediaBrowserCompat.a(this);
    public MediaSessionCompat.Token mMediaSessionToken;
    public String mRootId;
    public MediaBrowserCompat.l mServiceBinderWrapper;
    public final ComponentName mServiceComponent;
    public a mServiceConnection;
    public int mState = 1;
    public final b<String, MediaBrowserCompat.m> mSubscriptions = new ArrayMap();
    public final Bundle mView;
    public Bundle s;
    
    public i(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramB, Bundle paramBundle)
    {
      if (paramContext != null)
      {
        if (paramComponentName != null)
        {
          if (paramB != null)
          {
            mContext = paramContext;
            mServiceComponent = paramComponentName;
            mCallback = paramB;
            if (paramBundle == null) {
              paramContext = null;
            } else {
              paramContext = new Bundle(paramBundle);
            }
            mView = paramContext;
            return;
          }
          throw new IllegalArgumentException("connection callback must not be null");
        }
        throw new IllegalArgumentException("service component must not be null");
      }
      throw new IllegalArgumentException("context must not be null");
    }
    
    public static String getStateLabel(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4) {
                return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("UNKNOWN/", paramInt);
              }
              return "CONNECT_STATE_SUSPENDED";
            }
            return "CONNECT_STATE_CONNECTED";
          }
          return "CONNECT_STATE_CONNECTING";
        }
        return "CONNECT_STATE_DISCONNECTED";
      }
      return "CONNECT_STATE_DISCONNECTING";
    }
    
    private boolean isCurrent(Messenger paramMessenger, String paramString)
    {
      if (mCallbacksMessenger == paramMessenger)
      {
        i = mState;
        if ((i != 0) && (i != 1)) {
          return true;
        }
      }
      int i = mState;
      if ((i != 0) && (i != 1))
      {
        paramMessenger = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, " for ");
        paramMessenger.append(mServiceComponent);
        paramMessenger.append(" with mCallbacksMessenger=");
        paramMessenger.append(mCallbacksMessenger);
        paramMessenger.append(" this=");
        paramMessenger.append(this);
        paramMessenger.toString();
      }
      return false;
    }
    
    public void connect()
    {
      int i = mState;
      if ((i != 0) && (i != 1))
      {
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("connect() called while neigther disconnecting nor disconnected (state=");
        localStringBuilder.append(getStateLabel(mState));
        localStringBuilder.append(")");
        throw new IllegalStateException(localStringBuilder.toString());
      }
      mState = 2;
      mHandler.post(new Local.1(this));
    }
    
    public void connect(String paramString, Bundle paramBundle, MediaBrowserCompat.c paramC)
    {
      MediaBrowserCompat.l localL;
      Messenger localMessenger;
      if (isConnected())
      {
        localObject = new MediaBrowserCompat.CustomActionResultReceiver(paramString, paramBundle, paramC, mHandler);
        localL = mServiceBinderWrapper;
        localMessenger = mCallbacksMessenger;
      }
      try
      {
        localL.addSubscription(paramString, paramBundle, (ResultReceiver)localObject, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Remote error sending a custom action: action=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", extras=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).toString();
      if (paramC != null)
      {
        mHandler.post(new AnnotationWriter(this, paramC, paramString, paramBundle));
        return;
        paramC = new StringBuilder();
        paramC.append("Cannot send a custom action (");
        paramC.append(paramString);
        paramC.append(") with ");
        paramC.append("extras ");
        paramC.append(paramBundle);
        throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramC, " because the browser is not connected to the ", "service."));
      }
    }
    
    public void connect(String paramString, Bundle paramBundle, MediaBrowserCompat.k paramK)
    {
      MediaBrowserCompat.SearchResultReceiver localSearchResultReceiver;
      MediaBrowserCompat.l localL;
      Messenger localMessenger;
      if (isConnected())
      {
        localSearchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(paramString, paramBundle, paramK, mHandler);
        localL = mServiceBinderWrapper;
        localMessenger = mCallbacksMessenger;
      }
      try
      {
        localL.removeSubscription(paramString, paramBundle, localSearchResultReceiver, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Remote error searching items with query: ", paramString);
      mHandler.post(new Item(this, paramK, paramString, paramBundle));
      return;
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append("search() called while not connected (state=");
      paramString.append(getStateLabel(mState));
      paramString.append(")");
      throw new IllegalStateException(paramString.toString());
    }
    
    public Bundle d()
    {
      return s;
    }
    
    public void disconnect()
    {
      mState = 0;
      mHandler.post(new NotificationService.3(this));
    }
    
    public void dump()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("  mServiceComponent=");
      localStringBuilder.append(mServiceComponent);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mCallback=");
      localStringBuilder.append(mCallback);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mRootHints=");
      localStringBuilder.append(mView);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mState=");
      localStringBuilder.append(getStateLabel(mState));
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mServiceConnection=");
      localStringBuilder.append(mServiceConnection);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mServiceBinderWrapper=");
      localStringBuilder.append(mServiceBinderWrapper);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mCallbacksMessenger=");
      localStringBuilder.append(mCallbacksMessenger);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mRootId=");
      localStringBuilder.append(mRootId);
      localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  mMediaSessionToken=");
      localStringBuilder.append(mMediaSessionToken);
      localStringBuilder.toString();
    }
    
    public void forceCloseConnection()
    {
      a localA = mServiceConnection;
      if (localA != null) {
        mContext.unbindService(localA);
      }
      mState = 1;
      mServiceConnection = null;
      mServiceBinderWrapper = null;
      mCallbacksMessenger = null;
      mHandler.setCallbacksMessenger(null);
      mRootId = null;
      mMediaSessionToken = null;
    }
    
    public Bundle getExtras()
    {
      if (isConnected()) {
        return mExtras;
      }
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("getExtras() called while not connected (state=");
      localStringBuilder.append(getStateLabel(mState));
      localStringBuilder.append(")");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public void getItem(String paramString, MediaBrowserCompat.d paramD)
    {
      MediaBrowserCompat.ItemReceiver localItemReceiver;
      MediaBrowserCompat.l localL;
      Messenger localMessenger;
      if (!TextUtils.isEmpty(paramString)) {
        if (paramD != null)
        {
          if (!isConnected())
          {
            mHandler.post(new DayFragment.1(this, paramD, paramString));
            return;
          }
          localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramD, mHandler);
          localL = mServiceBinderWrapper;
          localMessenger = mCallbacksMessenger;
        }
      }
      try
      {
        localL.getMediaItem(paramString, localItemReceiver, localMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Remote error getting media item: ", paramString);
      mHandler.post(new Slider(this, paramD, paramString));
      return;
      throw new IllegalArgumentException("cb is null");
      throw new IllegalArgumentException("mediaId is empty");
    }
    
    public String getRoot()
    {
      if (isConnected()) {
        return mRootId;
      }
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("getRoot() called while not connected(state=");
      localStringBuilder.append(getStateLabel(mState));
      localStringBuilder.append(")");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public ComponentName getServiceComponent()
    {
      if (isConnected()) {
        return mServiceComponent;
      }
      throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("getServiceComponent() called while not connected (state="), mState, ")"));
    }
    
    public MediaSessionCompat.Token getSessionToken()
    {
      if (isConnected()) {
        return mMediaSessionToken;
      }
      throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("getSessionToken() called while not connected(state="), mState, ")"));
    }
    
    public boolean isConnected()
    {
      return mState == 3;
    }
    
    public void onConnectionFailed(Messenger paramMessenger)
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("onConnectFailed for ");
      localStringBuilder.append(mServiceComponent);
      localStringBuilder.toString();
      if (!isCurrent(paramMessenger, "onConnectFailed")) {
        return;
      }
      if (mState != 2)
      {
        paramMessenger = f.sufficientlysecure.rootcommands.util.StringBuilder.append("onConnect from service while mState=");
        paramMessenger.append(getStateLabel(mState));
        paramMessenger.append("... ignoring");
        paramMessenger.toString();
        return;
      }
      forceCloseConnection();
      mCallback.put();
    }
    
    public void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (!isCurrent(paramMessenger, "onLoadChildren")) {
        return;
      }
      if (MediaBrowserCompat.mState)
      {
        paramMessenger = f.sufficientlysecure.rootcommands.util.StringBuilder.append("onLoadChildren for ");
        paramMessenger.append(mServiceComponent);
        paramMessenger.append(" id=");
        paramMessenger.append(paramString);
        paramMessenger.toString();
      }
      paramMessenger = (MediaBrowserCompat.m)mSubscriptions.get(paramString);
      if (paramMessenger == null)
      {
        if (MediaBrowserCompat.mState) {
          f.sufficientlysecure.rootcommands.util.StringBuilder.get("onLoadChildren for id that isn't subscribed id=", paramString);
        }
      }
      else
      {
        paramMessenger = paramMessenger.a(paramBundle1);
        if (paramMessenger != null)
        {
          if (paramBundle1 == null)
          {
            if (paramList == null)
            {
              paramMessenger.b(paramString);
              return;
            }
            s = paramBundle2;
            paramMessenger.a(paramString, paramList);
            s = null;
            return;
          }
          if (paramList == null)
          {
            paramMessenger.b(paramString, paramBundle1);
            return;
          }
          s = paramBundle2;
          paramMessenger.add(paramString, paramList, paramBundle1);
          s = null;
        }
      }
    }
    
    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!isCurrent(paramMessenger, "onConnect")) {
        return;
      }
      if (mState != 2)
      {
        paramMessenger = f.sufficientlysecure.rootcommands.util.StringBuilder.append("onConnect from service while mState=");
        paramMessenger.append(getStateLabel(mState));
        paramMessenger.append("... ignoring");
        paramMessenger.toString();
        return;
      }
      mRootId = paramString;
      mMediaSessionToken = paramToken;
      mExtras = paramBundle;
      mState = 3;
      if (MediaBrowserCompat.mState) {
        dump();
      }
      mCallback.a();
      paramMessenger = mSubscriptions;
      try
      {
        paramMessenger = paramMessenger.entrySet().iterator();
        boolean bool = paramMessenger.hasNext();
        if (bool)
        {
          paramString = paramMessenger.next();
          paramToken = (Map.Entry)paramString;
          paramString = paramToken.getKey();
          paramString = (String)paramString;
          paramToken = paramToken.getValue();
          paramBundle = (MediaBrowserCompat.m)paramToken;
          paramToken = paramBundle.getValue();
          paramBundle = paramBundle.get();
          int i = 0;
          for (;;)
          {
            int j = paramToken.size();
            if (i >= j) {
              break;
            }
            MediaBrowserCompat.l localL = mServiceBinderWrapper;
            Object localObject1 = paramToken.get(i);
            localObject1 = mCallbacksMessenger;
            Object localObject2 = paramBundle.get(i);
            localObject2 = (Bundle)localObject2;
            Messenger localMessenger = mCallbacksMessenger;
            localL.addSubscription(paramString, (IBinder)localObject1, (Bundle)localObject2, localMessenger);
            i += 1;
          }
        }
        return;
      }
      catch (RemoteException paramMessenger) {}
    }
    
    public void onServiceConnected(String paramString, MediaBrowserCompat.n paramN)
    {
      MediaBrowserCompat.m localM = (MediaBrowserCompat.m)mSubscriptions.get(paramString);
      if (localM == null) {
        return;
      }
      if (paramN == null) {}
      try
      {
        bool = isConnected();
        if (!bool) {
          break label182;
        }
        localObject1 = mServiceBinderWrapper;
        localObject2 = mCallbacksMessenger;
        ((MediaBrowserCompat.l)localObject1).addSubscription(paramString, null, (Messenger)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        boolean bool;
        Object localObject1;
        Object localObject2;
        int i;
        for (;;) {}
      }
      localObject1 = localM.getValue();
      localObject2 = localM.get();
      i = ((List)localObject1).size();
      for (;;)
      {
        int j = i - 1;
        if (j < 0) {
          break;
        }
        Object localObject3 = ((List)localObject1).get(j);
        i = j;
        if (localObject3 == paramN)
        {
          bool = isConnected();
          if (bool)
          {
            localObject3 = mServiceBinderWrapper;
            IBinder localIBinder = mCallbacksMessenger;
            Messenger localMessenger = mCallbacksMessenger;
            ((MediaBrowserCompat.l)localObject3).addSubscription(paramString, localIBinder, localMessenger);
          }
          ((List)localObject1).remove(j);
          ((List)localObject2).remove(j);
          i = j;
        }
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("removeSubscription failed with RemoteException parentId=", paramString);
      label182:
      if ((localM.matches()) || (paramN == null))
      {
        mSubscriptions.remove(paramString);
        return;
      }
    }
    
    public void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.n paramN)
    {
      Object localObject2 = (MediaBrowserCompat.m)mSubscriptions.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new MediaBrowserCompat.m();
        mSubscriptions.put(paramString, localObject1);
      }
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = new Bundle(paramBundle);
      }
      ((MediaBrowserCompat.m)localObject1).a(paramBundle, paramN);
      if (isConnected())
      {
        localObject1 = mServiceBinderWrapper;
        paramN = mCallbacksMessenger;
        localObject2 = mCallbacksMessenger;
        try
        {
          ((MediaBrowserCompat.l)localObject1).addSubscription(paramString, paramN, paramBundle, (Messenger)localObject2);
          return;
        }
        catch (RemoteException paramBundle)
        {
          for (;;) {}
        }
        f.sufficientlysecure.rootcommands.util.StringBuilder.get("addSubscription failed with RemoteException parentId=", paramString);
        return;
      }
    }
    
    private class a
      implements ServiceConnection
    {
      public a() {}
      
      private void postOrRun(Runnable paramRunnable)
      {
        if (Thread.currentThread() == mHandler.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        mHandler.post(paramRunnable);
      }
      
      public boolean isCurrent(String paramString)
      {
        MediaBrowserCompat.i localI = MediaBrowserCompat.i.this;
        if (mServiceConnection == this)
        {
          i = mState;
          if ((i != 0) && (i != 1)) {
            return true;
          }
        }
        int i = mState;
        if ((i != 0) && (i != 1))
        {
          paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, " for ");
          paramString.append(mServiceComponent);
          paramString.append(" with mServiceConnection=");
          paramString.append(mServiceConnection);
          paramString.append(" this=");
          paramString.append(this);
          paramString.toString();
        }
        return false;
      }
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        postOrRun(new MediaBrowserCompat.MediaBrowserImplBase.5(this, paramComponentName, paramIBinder));
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        postOrRun(new DownloaderService.LVLRunnable(this, paramComponentName));
      }
    }
  }
  
  public static abstract interface j
  {
    public abstract void onConnectionFailed(Messenger paramMessenger);
    
    public abstract void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2);
    
    public abstract void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
  }
  
  public static abstract class k
  {
    public k() {}
    
    public void a(String paramString, Bundle paramBundle) {}
    
    public void a(String paramString, Bundle paramBundle, List paramList) {}
  }
  
  private static class l
  {
    public Messenger mMessenger;
    public Bundle mState;
    
    public l(IBinder paramIBinder, Bundle paramBundle)
    {
      mMessenger = new Messenger(paramIBinder);
      mState = paramBundle;
    }
    
    private void sendRequest(int paramInt, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      what = paramInt;
      arg1 = 1;
      localMessage.setData(paramBundle);
      replyTo = paramMessenger;
      mMessenger.send(localMessage);
    }
    
    public void addSubscription(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putBundle("data_root_hints", mState);
      sendRequest(1, localBundle, paramMessenger);
    }
    
    public void addSubscription(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_custom_action", paramString);
      localBundle.putBundle("data_custom_action_extras", paramBundle);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(9, localBundle, paramMessenger);
    }
    
    public void addSubscription(String paramString, IBinder paramIBinder, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.put("data_media_item_id", paramString);
      int i = Build.VERSION.SDK_INT;
      paramString.putBinder("data_callback_token", paramIBinder);
      paramString.putBundle("data_options", paramBundle);
      sendRequest(3, paramString, paramMessenger);
    }
    
    public void addSubscription(String paramString, IBinder paramIBinder, Messenger paramMessenger)
      throws RemoteException
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.put("data_media_item_id", paramString);
      int i = Build.VERSION.SDK_INT;
      paramString.putBinder("data_callback_token", paramIBinder);
      sendRequest(4, paramString, paramMessenger);
    }
    
    public void connect(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putBundle("data_root_hints", mState);
      sendRequest(6, localBundle, paramMessenger);
    }
    
    public void disconnect(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(2, null, paramMessenger);
    }
    
    public void getMediaItem(String paramString, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(5, localBundle, paramMessenger);
    }
    
    public void removeSubscription(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_search_query", paramString);
      localBundle.putBundle("data_search_extras", paramBundle);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(8, localBundle, paramMessenger);
    }
    
    public void unregisterCallbackMessenger(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(7, null, paramMessenger);
    }
  }
  
  private static class m
  {
    public final List<MediaBrowserCompat.n> a = new ArrayList();
    public final List<Bundle> c = new ArrayList();
    
    public m() {}
    
    public MediaBrowserCompat.n a(Bundle paramBundle)
    {
      int i = 0;
      while (i < c.size())
      {
        if (Frame.c((Bundle)c.get(i), paramBundle)) {
          return (MediaBrowserCompat.n)a.get(i);
        }
        i += 1;
      }
      return null;
    }
    
    public void a(Bundle paramBundle, MediaBrowserCompat.n paramN)
    {
      int i = 0;
      while (i < c.size())
      {
        if (Frame.c((Bundle)c.get(i), paramBundle))
        {
          a.set(i, paramN);
          return;
        }
        i += 1;
      }
      a.add(paramN);
      c.add(paramBundle);
    }
    
    public List get()
    {
      return c;
    }
    
    public List getValue()
    {
      return a;
    }
    
    public boolean matches()
    {
      return a.isEmpty();
    }
  }
  
  public static abstract class n
  {
    public WeakReference<MediaBrowserCompat.m> l;
    public final IBinder mCallbacksMessenger = new Binder();
    public final Object name;
    
    public n()
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 26)
      {
        name = new MediaBrowserCompat.SubscriptionCallback(new b());
        return;
      }
      if (i >= 21)
      {
        name = MediaBrowserCompatApi21.createSubscriptionCallback(new a());
        return;
      }
      name = null;
    }
    
    public void a(String paramString, List paramList) {}
    
    public void add(String paramString, List paramList, Bundle paramBundle) {}
    
    public void b(MediaBrowserCompat.m paramM)
    {
      l = new WeakReference(paramM);
    }
    
    public void b(String paramString) {}
    
    public void b(String paramString, Bundle paramBundle) {}
    
    private class a
      implements Subscription
    {
      public a() {}
      
      public void a(String paramString, List paramList)
      {
        Object localObject = l;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = (MediaBrowserCompat.m)((WeakReference)localObject).get();
        }
        if (localObject == null)
        {
          MediaBrowserCompat.n.this.a(paramString, MediaBrowserCompat.MediaItem.a(paramList));
          return;
        }
        paramList = MediaBrowserCompat.MediaItem.a(paramList);
        List localList = ((MediaBrowserCompat.m)localObject).getValue();
        localObject = ((MediaBrowserCompat.m)localObject).get();
        int i = 0;
        while (i < localList.size())
        {
          Bundle localBundle = (Bundle)((List)localObject).get(i);
          if (localBundle == null) {
            MediaBrowserCompat.n.this.a(paramString, paramList);
          } else {
            add(paramString, get(paramList, localBundle), localBundle);
          }
          i += 1;
        }
      }
      
      public List get(List paramList, Bundle paramBundle)
      {
        if (paramList == null) {
          return null;
        }
        int i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
        int m = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if ((i == -1) && (m == -1)) {
          return paramList;
        }
        int k = m * i;
        int j = k + m;
        if ((i >= 0) && (m >= 1) && (k < paramList.size()))
        {
          i = j;
          if (j > paramList.size()) {
            i = paramList.size();
          }
          return paramList.subList(k, i);
        }
        return Collections.emptyList();
      }
      
      public void setTitle(String paramString)
      {
        b(paramString);
      }
    }
    
    private class b
      extends MediaBrowserCompat.n.a
      implements Subscriber
    {
      public b()
      {
        super();
      }
      
      public void add(String paramString, List paramList, Bundle paramBundle)
      {
        MediaBrowserCompat.n.this.add(paramString, MediaBrowserCompat.MediaItem.a(paramList), paramBundle);
      }
      
      public void e(String paramString, Bundle paramBundle)
      {
        b(paramString, paramBundle);
      }
    }
  }
}
