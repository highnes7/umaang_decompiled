package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataEditor;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat.b;
import android.support.v4.media.RatingCompat;
import android.support.v4.package_7.BundleCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import b.b.a.K;
import b.b.a.N;
import b.b.x.h.b.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import support.android.v4.asm.ea.b;
import support.android.v4.asm.f;
import support.android.v4.asm.la.a;
import support.android.v4.asm.session.DataSource;
import support.android.v4.asm.session.DiscreteSeekBar.CustomState.1;
import support.android.v4.asm.session.DownloadProgressInfo.1;
import support.android.v4.asm.session.IMediaControllerCallback;
import support.android.v4.asm.session.IMediaSession;
import support.android.v4.asm.session.IMediaSession.Stub;
import support.android.v4.asm.session.Item;
import support.android.v4.asm.session.Label;
import support.android.v4.asm.session.MediaSessionCompat.Callback;
import support.android.v4.asm.session.MediaSessionCompat.MediaSessionImplBase;
import support.android.v4.asm.session.MediaSessionCompatApi18.OnPlaybackPositionUpdateListener;
import support.android.v4.asm.session.MediaSessionCompatApi19.OnMetadataUpdateListener;
import support.android.v4.asm.session.MediaSessionCompatApi21;
import support.android.v4.asm.session.MediaSessionCompatApi21.Callback;
import support.android.v4.asm.session.MediaSessionCompatApi21.QueueItem;
import support.android.v4.asm.session.MediaSessionCompatApi23.Callback;
import support.android.v4.asm.session.SettingsActivity;
import support.android.v4.asm.session.VerticalProgressBar.SavedState.1;
import support.android.v4.asm.session.Widget;
import support.android.v4.asm.session.d;

public class MediaSessionCompat
{
  @N({b.b.a.N.a.a})
  public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
  @N({b.b.a.N.a.a})
  public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
  @N({b.b.a.N.a.a})
  public static final String ACTION_ERROR = "android.support.v4.media.session.action.ARGUMENT_RATING";
  @N({b.b.a.N.a.a})
  public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
  public static final String ACTION_SHOW_PLAYER = "android.support.v4.media.session.action.SKIP_AD";
  @N({b.b.a.N.a.a})
  public static final String ACTION_UPDATE_ALL = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
  @N({b.b.a.N.a.a})
  public static final String ACTIVITY_TYPE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
  @N({b.b.a.N.a.a})
  public static final String CACHE_PATH = "android.support.v4.media.session.action.PREPARE_FROM_URI";
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final String CANCEL_MENU = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
  public static final String DATA_CALLING_UID = "data_calling_uid";
  public static final String DISPLAY_SHOW = "data_extras";
  @N({b.b.a.N.a.a})
  public static final String EVENTLOG_URL = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
  @N({b.b.a.N.a.a})
  public static final String EXTRA_EMAIL = "android.support.v4.media.session.action.SET_RATING";
  @N({b.b.a.N.a.a})
  public static final String EXTRA_FILE_EXTENSIONS = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
  @N({b.b.a.N.a.a})
  public static final String EXTRA_LOCALE = "android.support.v4.media.session.action.ARGUMENT_QUERY";
  @N({b.b.a.N.a.a})
  public static final String EXTRA_OUTPUT = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
  @N({b.b.a.N.a.a})
  public static final String EXTRA_SEARCH_TERM = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
  public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
  public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
  public static final String FRAG_TAG_TIME_PICKER = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final String LATEST_URL_SEARCH = "data_calling_pid";
  @N({b.b.a.N.a.a})
  public static final String MODULE_PACKAGE = "android.support.v4.media.session.EXTRA_BINDER";
  @N({b.b.a.N.a.b})
  public static final String PAGE_KEY = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public static final String SET_TIME = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
  public static final String STATUS_TIMESTAMP = "data_calling_pkg";
  public static final String TAG = "MediaSessionCompat";
  @N({b.b.a.N.a.a})
  public static final String TAG_ACTION = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
  @N({b.b.a.N.a.a})
  public static final String TAG_PARAMS = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
  @N({b.b.a.N.a.a})
  public static final String TAG_PREFIX = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
  public static final int THUMBNAIL_TARGET_SIZE = 320;
  @N({b.b.a.N.a.b})
  public static final String WEATHER = "android.support.v4.media.session.TOKEN";
  public static final int WEEKS_BUFFER = 1;
  public static final String f = "android.support.v4.media.session.action.UNFOLLOW";
  public static int mState = 0;
  public static final String stationList = "android.support.v4.media.session.action.FOLLOW";
  @N({b.b.a.N.a.a})
  public static final String t = "android.support.v4.media.session.action.PREPARE";
  public final ArrayList<h> mActiveListeners = new ArrayList();
  public final MediaControllerCompat mController;
  public final b mImpl;
  
  public MediaSessionCompat(Context paramContext, b paramB)
  {
    mImpl = paramB;
    if ((Build.VERSION.SDK_INT >= 21) && (!MediaSessionCompatApi21.persist(paramB.getMediaSession()))) {
      setCallback(new DataSource(this));
    }
    mController = new MediaControllerCompat(paramContext, this);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString)
  {
    this(paramContext, paramString, null, null);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
  {
    this(paramContext, paramString, paramComponentName, paramPendingIntent, null);
  }
  
  public MediaSessionCompat(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        ComponentName localComponentName = paramComponentName;
        if (paramComponentName == null) {
          localComponentName = Widget.start(paramContext);
        }
        paramComponentName = paramPendingIntent;
        if (localComponentName != null)
        {
          paramComponentName = paramPendingIntent;
          if (paramPendingIntent == null)
          {
            paramComponentName = new Intent("android.intent.action.MEDIA_BUTTON");
            paramComponentName.setComponent(localComponentName);
            paramComponentName = PendingIntent.getBroadcast(paramContext, 0, paramComponentName, 0);
          }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 28)
        {
          mImpl = new f(paramContext, paramString, paramBundle);
          setCallback(new Item(this));
          mImpl.setMediaButtonReceiver(paramComponentName);
        }
        else if (i >= 21)
        {
          mImpl = new e(paramContext, paramString, paramBundle);
          setCallback(new SettingsActivity(this));
          mImpl.setMediaButtonReceiver(paramComponentName);
        }
        else
        {
          mImpl = new d(paramContext, paramString, localComponentName, paramComponentName);
        }
        mController = new MediaControllerCompat(paramContext, this);
        if (mState == 0) {
          mState = (int)(TypedValue.applyDimension(1, 320.0F, paramContext.getResources().getDisplayMetrics()) + 0.5F);
        }
      }
      else
      {
        throw new IllegalArgumentException("tag must not be null or empty");
      }
    }
    else {
      throw new IllegalArgumentException("context must not be null");
    }
  }
  
  public MediaSessionCompat(Context paramContext, String paramString, Bundle paramBundle)
  {
    this(paramContext, paramString, null, null, paramBundle);
  }
  
  public static void append(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
    }
  }
  
  public static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat paramPlaybackStateCompat, MediaMetadataCompat paramMediaMetadataCompat)
  {
    PlaybackStateCompat localPlaybackStateCompat = paramPlaybackStateCompat;
    if (paramPlaybackStateCompat != null)
    {
      long l1 = paramPlaybackStateCompat.getPosition();
      long l2 = -1L;
      if (l1 == -1L) {
        return paramPlaybackStateCompat;
      }
      if ((paramPlaybackStateCompat.getState() != 3) && (paramPlaybackStateCompat.getState() != 4))
      {
        localPlaybackStateCompat = paramPlaybackStateCompat;
        if (paramPlaybackStateCompat.getState() != 5) {}
      }
      else
      {
        l1 = paramPlaybackStateCompat.getLastPositionUpdateTime();
        localPlaybackStateCompat = paramPlaybackStateCompat;
        if (l1 > 0L)
        {
          long l4 = SystemClock.elapsedRealtime();
          long l3 = (paramPlaybackStateCompat.getPlaybackSpeed() * (float)(l4 - l1)) + paramPlaybackStateCompat.getPosition();
          l1 = l2;
          if (paramMediaMetadataCompat != null)
          {
            l1 = l2;
            if (paramMediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
              l1 = paramMediaMetadataCompat.getLong("android.media.metadata.DURATION");
            }
          }
          if ((l1 < 0L) || (l3 <= l1)) {
            if (l3 < 0L) {
              l1 = 0L;
            } else {
              l1 = l3;
            }
          }
          localPlaybackStateCompat = new PlaybackStateCompat.b(paramPlaybackStateCompat).setState(paramPlaybackStateCompat.getState(), l1, paramPlaybackStateCompat.getPlaybackSpeed(), l4).build();
        }
      }
    }
    return localPlaybackStateCompat;
  }
  
  public static MediaSessionCompat obtain(Context paramContext, Object paramObject)
  {
    if ((paramContext != null) && (paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
      return new MediaSessionCompat(paramContext, new e(paramObject));
    }
    return null;
  }
  
  public void addOnActiveChangeListener(h paramH)
  {
    if (paramH != null)
    {
      mActiveListeners.add(paramH);
      return;
    }
    throw new IllegalArgumentException("Listener may not be null");
  }
  
  public MediaControllerCompat getController()
  {
    return mController;
  }
  
  public String getItem()
  {
    return mImpl.a();
  }
  
  public Object getMediaSession()
  {
    return mImpl.getMediaSession();
  }
  
  public Object getRoot()
  {
    return mImpl.getRoot();
  }
  
  public Token getSessionToken()
  {
    return mImpl.getSessionToken();
  }
  
  public boolean isActive()
  {
    return mImpl.isActive();
  }
  
  public void release()
  {
    mImpl.release();
  }
  
  public void removeOnActiveChangeListener(h paramH)
  {
    if (paramH != null)
    {
      mActiveListeners.remove(paramH);
      return;
    }
    throw new IllegalArgumentException("Listener may not be null");
  }
  
  public void sendSessionEvent(String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      mImpl.sendEvent(paramString, paramBundle);
      return;
    }
    throw new IllegalArgumentException("event cannot be null or empty");
  }
  
  public final ea.b setActive()
  {
    return mImpl.setPlaybackState();
  }
  
  public void setActive(boolean paramBoolean)
  {
    mImpl.setActive(paramBoolean);
    Iterator localIterator = mActiveListeners.iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).destroyProxy();
    }
  }
  
  public void setCallback(a paramA)
  {
    setCallback(paramA, null);
  }
  
  public void setCallback(a paramA, Handler paramHandler)
  {
    if (paramA == null)
    {
      mImpl.setCallback(null, null);
      return;
    }
    b localB = mImpl;
    if (paramHandler == null) {
      paramHandler = new Handler();
    }
    localB.setCallback(paramA, paramHandler);
  }
  
  public void setExtras(Bundle paramBundle)
  {
    mImpl.setExtras(paramBundle);
  }
  
  public void setFlags(int paramInt)
  {
    mImpl.setFlags(paramInt);
  }
  
  public void setMediaButtonReceiver(PendingIntent paramPendingIntent)
  {
    mImpl.setMediaButtonReceiver(paramPendingIntent);
  }
  
  public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
  {
    mImpl.setMetadata(paramMediaMetadataCompat);
  }
  
  public void setPlaybackState(int paramInt)
  {
    mImpl.sendState(paramInt);
  }
  
  public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
  {
    mImpl.setPlaybackState(paramPlaybackStateCompat);
  }
  
  public void setPlaybackToLocal(int paramInt)
  {
    mImpl.setPlaybackToLocal(paramInt);
  }
  
  public void setPlaybackToRemote(f paramF)
  {
    if (paramF != null)
    {
      mImpl.setPlaybackToRemote(paramF);
      return;
    }
    throw new IllegalArgumentException("volumeProvider may not be null!");
  }
  
  public void setQueue(int paramInt)
  {
    mImpl.sendQueue(paramInt);
  }
  
  public void setQueue(CharSequence paramCharSequence)
  {
    mImpl.setQueue(paramCharSequence);
  }
  
  public void setQueue(List paramList)
  {
    mImpl.setQueue(paramList);
  }
  
  public void setQueue(boolean paramBoolean)
  {
    mImpl.sendQueue(paramBoolean);
  }
  
  public void setRatingType(int paramInt)
  {
    mImpl.setRatingType(paramInt);
  }
  
  public void setSessionActivity(PendingIntent paramPendingIntent)
  {
    mImpl.setSessionActivity(paramPendingIntent);
  }
  
  public static final class QueueItem
    implements Parcelable
  {
    public static final Parcelable.Creator<QueueItem> CREATOR = new VerticalProgressBar.SavedState.1();
    public static final int UNKNOWN_ID = -1;
    public final MediaDescriptionCompat mDescription;
    public final long mId;
    public Object mItem;
    
    public QueueItem(Parcel paramParcel)
    {
      mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
      mId = paramParcel.readLong();
    }
    
    public QueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
    {
      this(null, paramMediaDescriptionCompat, paramLong);
    }
    
    public QueueItem(Object paramObject, MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
    {
      if (paramMediaDescriptionCompat != null)
      {
        if (paramLong != -1L)
        {
          mDescription = paramMediaDescriptionCompat;
          mId = paramLong;
          mItem = paramObject;
          return;
        }
        throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
      }
      throw new IllegalArgumentException("Description cannot be null.");
    }
    
    public static List getPath(List paramList)
    {
      if ((paramList != null) && (Build.VERSION.SDK_INT >= 21))
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(obtain(paramList.next()));
        }
        return localArrayList;
      }
      return null;
    }
    
    public static QueueItem obtain(Object paramObject)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21)) {
        return new QueueItem(paramObject, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(paramObject)), MediaSessionCompatApi21.QueueItem.getQueueId(paramObject));
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
    
    public long getQueueId()
    {
      return mId;
    }
    
    public Object getQueueItem()
    {
      if ((mItem == null) && (Build.VERSION.SDK_INT >= 21))
      {
        mItem = MediaSessionCompatApi21.QueueItem.createItem(mDescription.getMediaDescription(), mId);
        return mItem;
      }
      return mItem;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("MediaSession.QueueItem {Description=");
      localStringBuilder.append(mDescription);
      localStringBuilder.append(", Id=");
      localStringBuilder.append(mId);
      localStringBuilder.append(" }");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      mDescription.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(mId);
    }
  }
  
  @N({b.b.a.N.a.a})
  public static final class ResultReceiverWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new DownloadProgressInfo.1();
    public ResultReceiver mResultReceiver;
    
    public ResultReceiverWrapper(Parcel paramParcel)
    {
      mResultReceiver = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }
    
    public ResultReceiverWrapper(ResultReceiver paramResultReceiver)
    {
      mResultReceiver = paramResultReceiver;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      mResultReceiver.writeToParcel(paramParcel, paramInt);
    }
  }
  
  public static final class Token
    implements Parcelable
  {
    public static final Parcelable.Creator<Token> CREATOR = new DiscreteSeekBar.CustomState.1();
    public final Object content;
    public Bundle data;
    public IMediaSession e;
    
    public Token(Object paramObject)
    {
      content = paramObject;
      e = null;
      data = null;
    }
    
    public Token(Object paramObject, IMediaSession paramIMediaSession)
    {
      content = paramObject;
      e = paramIMediaSession;
      data = null;
    }
    
    public Token(Object paramObject, IMediaSession paramIMediaSession, Bundle paramBundle)
    {
      content = paramObject;
      e = paramIMediaSession;
      data = paramBundle;
    }
    
    public static Token fromToken(Object paramObject)
    {
      return fromToken(paramObject, null);
    }
    
    public static Token fromToken(Object paramObject, IMediaSession paramIMediaSession)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
      {
        MediaSessionCompatApi21.verifyToken(paramObject);
        return new Token(paramObject, paramIMediaSession);
      }
      return null;
    }
    
    public static Token getToken(Bundle paramBundle)
    {
      if (paramBundle == null) {
        return null;
      }
      IMediaSession localIMediaSession = IMediaSession.Stub.asInterface(BundleCompat.getBinder(paramBundle, "android.support.v4.media.session.EXTRA_BINDER"));
      Bundle localBundle = paramBundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
      paramBundle = (Token)paramBundle.getParcelable("android.support.v4.media.session.TOKEN");
      if (paramBundle == null) {
        return null;
      }
      return new Token(content, localIMediaSession, localBundle);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public IMediaSession e()
    {
      return e;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof Token)) {
        return false;
      }
      Object localObject = (Token)paramObject;
      paramObject = content;
      if (paramObject == null) {
        return content == null;
      }
      localObject = content;
      if (localObject == null) {
        return false;
      }
      return paramObject.equals(localObject);
    }
    
    public void finish(IMediaSession paramIMediaSession)
    {
      e = paramIMediaSession;
    }
    
    public Object get()
    {
      return content;
    }
    
    public Bundle getToken()
    {
      return data;
    }
    
    public int hashCode()
    {
      Object localObject = content;
      if (localObject == null) {
        return 0;
      }
      return localObject.hashCode();
    }
    
    public void initialize(Bundle paramBundle)
    {
      data = paramBundle;
    }
    
    public Bundle onPostExecute()
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.v4.media.session.TOKEN", this);
      Object localObject = e;
      if (localObject != null)
      {
        localObject = ((IInterface)localObject).asBinder();
        int i = Build.VERSION.SDK_INT;
        localBundle.putBinder("android.support.v4.media.session.EXTRA_BINDER", (IBinder)localObject);
      }
      localObject = data;
      if (localObject != null) {
        localBundle.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", (Bundle)localObject);
      }
      return localBundle;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramParcel.writeParcelable((Parcelable)content, paramInt);
        return;
      }
      paramParcel.writeStrongBinder((IBinder)content);
    }
  }
  
  public static abstract class a
  {
    public a handler = null;
    public boolean i;
    public final Object mCallbackObj;
    public WeakReference<MediaSessionCompat.b> this$0;
    
    public a()
    {
      int j = Build.VERSION.SDK_INT;
      if (j >= 24)
      {
        mCallbackObj = d.b(new d());
        return;
      }
      if (j >= 23)
      {
        mCallbackObj = new MediaSessionCompat.Callback(new c());
        return;
      }
      if (j >= 21)
      {
        mCallbackObj = MediaSessionCompatApi21.createCallback(new b());
        return;
      }
      mCallbackObj = null;
    }
    
    public void MotionCallback(MediaDescriptionCompat paramMediaDescriptionCompat) {}
    
    public void append() {}
    
    public void append(String paramString, Bundle paramBundle) {}
    
    public void clear() {}
    
    public void connect(String paramString, Bundle paramBundle) {}
    
    public void enqueue(MediaSessionCompat.b paramB, Handler paramHandler)
    {
      this$0 = new WeakReference(paramB);
      paramB = handler;
      if (paramB != null) {
        paramB.removeCallbacksAndMessages(null);
      }
      handler = new a(paramHandler.getLooper());
    }
    
    public void log(MediaDescriptionCompat paramMediaDescriptionCompat) {}
    
    public void onCommand(String paramString, Bundle paramBundle) {}
    
    public void onCustomAction(RatingCompat paramRatingCompat, Bundle paramBundle) {}
    
    public void onCustomAction(String paramString, Bundle paramBundle) {}
    
    public void onFastForward() {}
    
    public void onPlay() {}
    
    public void onPlayFromMediaId(String paramString, Bundle paramBundle) {}
    
    public void onPlayFromUri(Uri paramUri, Bundle paramBundle) {}
    
    public void onRefreshComplete(boolean paramBoolean) {}
    
    public void onRewind() {}
    
    public void onSeekTo(long paramLong) {}
    
    public void onSetRating(RatingCompat paramRatingCompat) {}
    
    public void onSkipToPrevious() {}
    
    public void onSkipToQueueItem(long paramLong) {}
    
    public void onStop() {}
    
    public void pause() {}
    
    public void refreshInternal(int paramInt) {}
    
    public void remove(Uri paramUri, Bundle paramBundle) {}
    
    public void remove(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
    
    public void setProgress(int paramInt) {}
    
    public void update(ea.b paramB)
    {
      if (!i) {
        return;
      }
      int m = 0;
      i = false;
      handler.removeMessages(1);
      MediaSessionCompat.b localB = (MediaSessionCompat.b)this$0.get();
      if (localB == null) {
        return;
      }
      PlaybackStateCompat localPlaybackStateCompat = localB.getStateWithUpdatedPosition();
      long l;
      if (localPlaybackStateCompat == null) {
        l = 0L;
      } else {
        l = localPlaybackStateCompat.getActions();
      }
      int j;
      if ((localPlaybackStateCompat != null) && (localPlaybackStateCompat.getState() == 3)) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if ((0x204 & l) != 0L) {
        k = 1;
      } else {
        k = 0;
      }
      if ((l & 0x202) != 0L) {
        m = 1;
      }
      localB.setTileSource(paramB);
      if ((j != 0) && (m != 0)) {
        pause();
      } else if ((j == 0) && (k != 0)) {
        onPlay();
      }
      localB.setTileSource(null);
    }
    
    public boolean update(Intent paramIntent)
    {
      if (Build.VERSION.SDK_INT >= 27) {
        return false;
      }
      Object localObject = (MediaSessionCompat.b)this$0.get();
      if (localObject != null)
      {
        if (handler == null) {
          return false;
        }
        KeyEvent localKeyEvent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (localKeyEvent != null)
        {
          if (localKeyEvent.getAction() != 0) {
            return false;
          }
          paramIntent = ((MediaSessionCompat.b)localObject).setPlaybackState();
          int j = localKeyEvent.getKeyCode();
          if ((j != 79) && (j != 85))
          {
            update(paramIntent);
            return false;
          }
          if (localKeyEvent.getRepeatCount() > 0)
          {
            update(paramIntent);
            return true;
          }
          if (i)
          {
            handler.removeMessages(1);
            i = false;
            paramIntent = ((MediaSessionCompat.b)localObject).getStateWithUpdatedPosition();
            long l;
            if (paramIntent == null) {
              l = 0L;
            } else {
              l = paramIntent.getActions();
            }
            if ((l & 0x20) == 0L) {
              break label200;
            }
            append();
            return true;
          }
          i = true;
          localObject = handler;
          ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(1, paramIntent), ViewConfiguration.getDoubleTapTimeout());
          return true;
        }
      }
      return false;
      label200:
      return true;
    }
    
    public void updateState(int paramInt) {}
    
    public void updateState(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt) {}
    
    private class a
      extends Handler
    {
      public static final int TYPE_EXPANDED = 1;
      
      public a(Looper paramLooper)
      {
        super();
      }
      
      public void handleMessage(Message paramMessage)
      {
        if (what == 1) {
          update((ea.b)obj);
        }
      }
    }
    
    @K(21)
    private class b
      implements MediaSessionCompatApi21.Callback
    {
      public b() {}
      
      public void connect(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
      {
        try
        {
          bool = paramString.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER");
          localToken = null;
          localA = null;
          if (bool)
          {
            paramString = this$0;
            paramString = paramString.get();
            paramString = (MediaSessionCompat.e)paramString;
            if (paramString == null) {
              return;
            }
            paramBundle = new Bundle();
            localToken = paramString.getSessionToken();
            paramString = localToken.e();
            if (paramString == null) {
              paramString = localA;
            } else {
              paramString = paramString.asBinder();
            }
            i = Build.VERSION.SDK_INT;
            paramString = (IBinder)paramString;
            paramBundle.putBinder("android.support.v4.media.session.EXTRA_BINDER", paramString);
            paramBundle.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", localToken.getToken());
            paramResultReceiver.send(0, paramBundle);
            return;
          }
          bool = paramString.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM");
          if (bool) {
            paramString = MediaSessionCompat.a.this;
          }
        }
        catch (BadParcelableException paramString)
        {
          boolean bool;
          MediaSessionCompat.Token localToken;
          MediaSessionCompat.a localA;
          int i;
          int j;
          return;
        }
        try
        {
          paramBundle = paramBundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
          paramBundle = (MediaDescriptionCompat)paramBundle;
          paramString.MotionCallback(paramBundle);
          return;
        }
        catch (BadParcelableException paramString)
        {
          return;
        }
        bool = paramString.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT");
        if (bool) {
          paramString = MediaSessionCompat.a.this;
        }
        try
        {
          paramResultReceiver = paramBundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
          paramResultReceiver = (MediaDescriptionCompat)paramResultReceiver;
          paramString.updateState(paramResultReceiver, paramBundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
          return;
        }
        catch (BadParcelableException paramString) {}
        bool = paramString.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM");
        if (bool)
        {
          paramString = MediaSessionCompat.a.this;
          paramBundle = paramBundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION");
          paramBundle = (MediaDescriptionCompat)paramBundle;
          paramString.log(paramBundle);
          return;
        }
        bool = paramString.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT");
        if (bool)
        {
          paramString = this$0;
          paramString = paramString.get();
          paramResultReceiver = (MediaSessionCompat.e)paramString;
          if ((paramResultReceiver != null) && (mQueue != null))
          {
            i = paramBundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
            paramString = localToken;
            if (i >= 0)
            {
              paramString = mQueue;
              j = paramString.size();
              paramString = localToken;
              if (i < j)
              {
                paramString = mQueue;
                paramString = paramString.get(i);
                paramString = (MediaSessionCompat.QueueItem)paramString;
              }
            }
            if (paramString != null)
            {
              paramBundle = MediaSessionCompat.a.this;
              paramString = (MediaSessionCompat.QueueItem)paramString;
              paramBundle.log(paramString.getDescription());
            }
          }
        }
        else
        {
          localA = MediaSessionCompat.a.this;
          localA.remove(paramString, paramBundle, paramResultReceiver);
          return;
        }
      }
      
      public void onCommand(String paramString, Bundle paramBundle)
      {
        MediaSessionCompat.a.this.onCommand(paramString, paramBundle);
      }
      
      public void onCustomAction(Object paramObject, Bundle paramBundle) {}
      
      public void onCustomAction(String paramString, Bundle paramBundle)
      {
        Bundle localBundle = paramBundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
        MediaSessionCompat.append(localBundle);
        if (paramString.equals("android.support.v4.media.session.action.PLAY_FROM_URI"))
        {
          paramString = (Uri)paramBundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
          onPlayFromUri(paramString, localBundle);
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.PREPARE"))
        {
          clear();
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID"))
        {
          paramString = paramBundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
          connect(paramString, localBundle);
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH"))
        {
          paramString = paramBundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
          append(paramString, localBundle);
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.PREPARE_FROM_URI"))
        {
          paramString = (Uri)paramBundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
          remove(paramString, localBundle);
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED"))
        {
          boolean bool = paramBundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
          onRefreshComplete(bool);
          return;
        }
        int i;
        if (paramString.equals("android.support.v4.media.session.action.SET_REPEAT_MODE"))
        {
          i = paramBundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
          setProgress(i);
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE"))
        {
          i = paramBundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
          updateState(i);
          return;
        }
        if (paramString.equals("android.support.v4.media.session.action.SET_RATING"))
        {
          paramString = (RatingCompat)paramBundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
          onCustomAction(paramString, localBundle);
          return;
        }
        MediaSessionCompat.a.this.onCustomAction(paramString, paramBundle);
      }
      
      public void onFastForward()
      {
        MediaSessionCompat.a.this.onFastForward();
      }
      
      public boolean onMediaButtonEvent(Intent paramIntent)
      {
        return update(paramIntent);
      }
      
      public void onPause()
      {
        pause();
      }
      
      public void onPlay()
      {
        MediaSessionCompat.a.this.onPlay();
      }
      
      public void onPlayFromMediaId()
      {
        append();
      }
      
      public void onPlayFromMediaId(String paramString, Bundle paramBundle)
      {
        MediaSessionCompat.a.this.onPlayFromMediaId(paramString, paramBundle);
      }
      
      public void onRewind()
      {
        MediaSessionCompat.a.this.onRewind();
      }
      
      public void onSeekTo(long paramLong)
      {
        MediaSessionCompat.a.this.onSeekTo(paramLong);
      }
      
      public void onSetRating(Object paramObject)
      {
        onSetRating(RatingCompat.fromRating(paramObject));
      }
      
      public void onSkipToPrevious()
      {
        MediaSessionCompat.a.this.onSkipToPrevious();
      }
      
      public void onSkipToQueueItem(long paramLong)
      {
        MediaSessionCompat.a.this.onSkipToQueueItem(paramLong);
      }
      
      public void onStop()
      {
        MediaSessionCompat.a.this.onStop();
      }
    }
    
    @K(23)
    private class c
      extends MediaSessionCompat.a.b
      implements MediaSessionCompatApi23.Callback
    {
      public c()
      {
        super();
      }
      
      public void onPlayFromUri(Uri paramUri, Bundle paramBundle)
      {
        MediaSessionCompat.a.this.onPlayFromUri(paramUri, paramBundle);
      }
    }
    
    @K(24)
    private class d
      extends MediaSessionCompat.a.c
      implements Label
    {
      public d()
      {
        super();
      }
      
      public void a(String paramString, Bundle paramBundle)
      {
        connect(paramString, paramBundle);
      }
      
      public void b()
      {
        clear();
      }
      
      public void b(Uri paramUri, Bundle paramBundle)
      {
        remove(paramUri, paramBundle);
      }
      
      public void b(String paramString, Bundle paramBundle)
      {
        append(paramString, paramBundle);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract String a();
    
    public abstract Object getMediaSession();
    
    public abstract Object getRoot();
    
    public abstract MediaSessionCompat.Token getSessionToken();
    
    public abstract PlaybackStateCompat getStateWithUpdatedPosition();
    
    public abstract boolean isActive();
    
    public abstract void release();
    
    public abstract void sendEvent(String paramString, Bundle paramBundle);
    
    public abstract void sendQueue(int paramInt);
    
    public abstract void sendQueue(boolean paramBoolean);
    
    public abstract void sendState(int paramInt);
    
    public abstract void setActive(boolean paramBoolean);
    
    public abstract void setCallback(MediaSessionCompat.a paramA, Handler paramHandler);
    
    public abstract void setExtras(Bundle paramBundle);
    
    public abstract void setFlags(int paramInt);
    
    public abstract void setMediaButtonReceiver(PendingIntent paramPendingIntent);
    
    public abstract void setMetadata(MediaMetadataCompat paramMediaMetadataCompat);
    
    public abstract ea.b setPlaybackState();
    
    public abstract void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat);
    
    public abstract void setPlaybackToLocal(int paramInt);
    
    public abstract void setPlaybackToRemote(f paramF);
    
    public abstract void setQueue(CharSequence paramCharSequence);
    
    public abstract void setQueue(List paramList);
    
    public abstract void setRatingType(int paramInt);
    
    public abstract void setSessionActivity(PendingIntent paramPendingIntent);
    
    public abstract void setTileSource(ea.b paramB);
  }
  
  @K(18)
  public static class c
    extends MediaSessionCompat.g
  {
    public static boolean isFocused;
    
    public c(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
    {
      super(paramString, paramComponentName, paramPendingIntent);
    }
    
    public void focus(PendingIntent paramPendingIntent, ComponentName paramComponentName)
    {
      if (isFocused) {}
      try
      {
        mAudioManager.registerMediaButtonEventReceiver(paramPendingIntent);
      }
      catch (NullPointerException paramPendingIntent)
      {
        for (;;) {}
      }
      isFocused = false;
      if (!isFocused)
      {
        mAudioManager.registerMediaButtonEventReceiver(paramComponentName);
        return;
      }
    }
    
    public int getRccTransportControlFlagsFromActions(long paramLong)
    {
      int j = super.getRccTransportControlFlagsFromActions(paramLong);
      int i = j;
      if ((paramLong & 0x100) != 0L) {
        i = j | 0x100;
      }
      return i;
    }
    
    public void setCallback(MediaSessionCompat.a paramA, Handler paramHandler)
    {
      super.setCallback(paramA, paramHandler);
      if (paramA == null)
      {
        mRemoteControlClient.setPlaybackPositionUpdateListener(null);
        return;
      }
      paramA = new MediaSessionCompatApi18.OnPlaybackPositionUpdateListener(this);
      mRemoteControlClient.setPlaybackPositionUpdateListener(paramA);
    }
    
    public void setState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      long l3 = paramPlaybackStateCompat.getPosition();
      long l1 = l3;
      float f = paramPlaybackStateCompat.getPlaybackSpeed();
      long l5 = paramPlaybackStateCompat.getLastPositionUpdateTime();
      long l6 = SystemClock.elapsedRealtime();
      long l2 = l1;
      if (paramPlaybackStateCompat.getState() == 3)
      {
        long l4 = 0L;
        l2 = l1;
        if (l3 > 0L)
        {
          l1 = l4;
          if (l5 > 0L)
          {
            l2 = l6 - l5;
            l1 = l2;
            if (f > 0.0F)
            {
              l1 = l2;
              if (f != 1.0F) {
                l1 = ((float)l2 * f);
              }
            }
          }
          l2 = l3 + l1;
        }
      }
      mRemoteControlClient.setPlaybackState(getRccStateFromState(paramPlaybackStateCompat.getState()), l2, f);
    }
    
    public void unregisterMediaButtonEventReceiver(PendingIntent paramPendingIntent, ComponentName paramComponentName)
    {
      if (isFocused)
      {
        mAudioManager.unregisterMediaButtonEventReceiver(paramPendingIntent);
        return;
      }
      mAudioManager.unregisterMediaButtonEventReceiver(paramComponentName);
    }
  }
  
  @K(19)
  public static class d
    extends MediaSessionCompat.c
  {
    public d(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
    {
      super(paramString, paramComponentName, paramPendingIntent);
    }
    
    public RemoteControlClient.MetadataEditor buildOldMetadata(Bundle paramBundle)
    {
      RemoteControlClient.MetadataEditor localMetadataEditor = super.buildOldMetadata(paramBundle);
      PlaybackStateCompat localPlaybackStateCompat = mState;
      long l;
      if (localPlaybackStateCompat == null) {
        l = 0L;
      } else {
        l = localPlaybackStateCompat.getActions();
      }
      if ((l & 0x80) != 0L) {
        localMetadataEditor.addEditableKey(268435457);
      }
      if (paramBundle == null) {
        return localMetadataEditor;
      }
      if (paramBundle.containsKey("android.media.metadata.YEAR")) {
        localMetadataEditor.putLong(8, paramBundle.getLong("android.media.metadata.YEAR"));
      }
      if (paramBundle.containsKey("android.media.metadata.RATING")) {
        localMetadataEditor.putObject(101, paramBundle.getParcelable("android.media.metadata.RATING"));
      }
      if (paramBundle.containsKey("android.media.metadata.USER_RATING")) {
        localMetadataEditor.putObject(268435457, paramBundle.getParcelable("android.media.metadata.USER_RATING"));
      }
      return localMetadataEditor;
    }
    
    public int getRccTransportControlFlagsFromActions(long paramLong)
    {
      int j = super.getRccTransportControlFlagsFromActions(paramLong);
      int i = j;
      if ((paramLong & 0x80) != 0L) {
        i = j | 0x200;
      }
      return i;
    }
    
    public void setCallback(MediaSessionCompat.a paramA, Handler paramHandler)
    {
      super.setCallback(paramA, paramHandler);
      if (paramA == null)
      {
        mRemoteControlClient.setMetadataUpdateListener(null);
        return;
      }
      paramA = new MediaSessionCompatApi19.OnMetadataUpdateListener(this);
      mRemoteControlClient.setMetadataUpdateListener(paramA);
    }
  }
  
  @K(21)
  public static class e
    implements MediaSessionCompat.b
  {
    public boolean alert;
    public final RemoteCallbackList<a> mControllerCallbacks = new RemoteCallbackList();
    public boolean mIsActive = false;
    public MediaMetadataCompat mMetadata;
    public List<MediaSessionCompat.QueueItem> mQueue;
    public final Object mSessionObj;
    public PlaybackStateCompat mState;
    public final MediaSessionCompat.Token mToken;
    public int mViewTypeCount;
    public int rate;
    public int state;
    
    public e(Context paramContext, String paramString, Bundle paramBundle)
    {
      mSessionObj = MediaSessionCompatApi21.createSession(paramContext, paramString);
      mToken = new MediaSessionCompat.Token(MediaSessionCompatApi21.getSessionToken(mSessionObj), new a(), paramBundle);
    }
    
    public e(Object paramObject)
    {
      MediaSessionCompatApi21.verifySession(paramObject);
      mSessionObj = paramObject;
      mToken = new MediaSessionCompat.Token(MediaSessionCompatApi21.getSessionToken(mSessionObj), new a());
    }
    
    public String a()
    {
      if (Build.VERSION.SDK_INT < 24) {
        return null;
      }
      return d.a(mSessionObj);
    }
    
    public Object getMediaSession()
    {
      return mSessionObj;
    }
    
    public Object getRoot()
    {
      return null;
    }
    
    public MediaSessionCompat.Token getSessionToken()
    {
      return mToken;
    }
    
    public PlaybackStateCompat getStateWithUpdatedPosition()
    {
      return mState;
    }
    
    public boolean isActive()
    {
      return MediaSessionCompatApi21.isActive(mSessionObj);
    }
    
    public void release()
    {
      mIsActive = true;
      MediaSessionCompatApi21.release(mSessionObj);
    }
    
    public void sendEvent(String paramString, Bundle paramBundle)
    {
      int i;
      if (Build.VERSION.SDK_INT < 23) {
        i = mControllerCallbacks.beginBroadcast() - 1;
      }
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onEvent(paramString, paramBundle);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          MediaSessionCompatApi21.sendSessionEvent(mSessionObj, paramString, paramBundle);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    public void sendQueue(int paramInt)
    {
      if (state != paramInt)
      {
        state = paramInt;
        int i = mControllerCallbacks.beginBroadcast() - 1;
        for (;;)
        {
          IMediaControllerCallback localIMediaControllerCallback;
          if (i >= 0) {
            localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
          }
          try
          {
            localIMediaControllerCallback.next(paramInt);
            i -= 1;
            continue;
            mControllerCallbacks.finishBroadcast();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;) {}
          }
        }
      }
    }
    
    public void sendQueue(boolean paramBoolean)
    {
      if (alert != paramBoolean)
      {
        alert = paramBoolean;
        int i = mControllerCallbacks.beginBroadcast() - 1;
        for (;;)
        {
          IMediaControllerCallback localIMediaControllerCallback;
          if (i >= 0) {
            localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
          }
          try
          {
            localIMediaControllerCallback.next(paramBoolean);
            i -= 1;
            continue;
            mControllerCallbacks.finishBroadcast();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;) {}
          }
        }
      }
    }
    
    public void sendState(int paramInt)
    {
      if (rate != paramInt)
      {
        rate = paramInt;
        int i = mControllerCallbacks.beginBroadcast() - 1;
        for (;;)
        {
          IMediaControllerCallback localIMediaControllerCallback;
          if (i >= 0) {
            localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
          }
          try
          {
            localIMediaControllerCallback.onPlaybackStateChanged(paramInt);
            i -= 1;
            continue;
            mControllerCallbacks.finishBroadcast();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;) {}
          }
        }
      }
    }
    
    public void setActive(boolean paramBoolean)
    {
      MediaSessionCompatApi21.setActive(mSessionObj, paramBoolean);
    }
    
    public void setCallback(MediaSessionCompat.a paramA, Handler paramHandler)
    {
      Object localObject2 = mSessionObj;
      Object localObject1;
      if (paramA == null) {
        localObject1 = null;
      } else {
        localObject1 = mCallbackObj;
      }
      MediaSessionCompatApi21.setCallback(localObject2, localObject1, paramHandler);
      if (paramA != null) {
        paramA.enqueue(this, paramHandler);
      }
    }
    
    public void setExtras(Bundle paramBundle)
    {
      MediaSessionCompatApi21.setExtras(mSessionObj, paramBundle);
    }
    
    public void setFlags(int paramInt)
    {
      MediaSessionCompatApi21.setFlags(mSessionObj, paramInt);
    }
    
    public void setMediaButtonReceiver(PendingIntent paramPendingIntent)
    {
      MediaSessionCompatApi21.setMediaButtonReceiver(mSessionObj, paramPendingIntent);
    }
    
    public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
    {
      mMetadata = paramMediaMetadataCompat;
      Object localObject = mSessionObj;
      if (paramMediaMetadataCompat == null) {
        paramMediaMetadataCompat = null;
      } else {
        paramMediaMetadataCompat = paramMediaMetadataCompat.getMediaMetadata();
      }
      MediaSessionCompatApi21.setMetadata(localObject, paramMediaMetadataCompat);
    }
    
    public ea.b setPlaybackState()
    {
      return null;
    }
    
    public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      mState = paramPlaybackStateCompat;
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        Object localObject;
        if (i >= 0) {
          localObject = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          ((IMediaControllerCallback)localObject).onPlaybackStateChanged(paramPlaybackStateCompat);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          localObject = mSessionObj;
          if (paramPlaybackStateCompat == null) {
            paramPlaybackStateCompat = null;
          } else {
            paramPlaybackStateCompat = paramPlaybackStateCompat.getPlaybackState();
          }
          MediaSessionCompatApi21.setPlaybackState(localObject, paramPlaybackStateCompat);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    public void setPlaybackToLocal(int paramInt)
    {
      MediaSessionCompatApi21.setPlaybackToLocal(mSessionObj, paramInt);
    }
    
    public void setPlaybackToRemote(f paramF)
    {
      MediaSessionCompatApi21.setPlaybackToRemote(mSessionObj, paramF.a());
    }
    
    public void setQueue(CharSequence paramCharSequence)
    {
      MediaSessionCompatApi21.setQueueTitle(mSessionObj, paramCharSequence);
    }
    
    public void setQueue(List paramList)
    {
      mQueue = paramList;
      if (paramList != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          paramList = localArrayList;
          if (!localIterator.hasNext()) {
            break;
          }
          localArrayList.add(((MediaSessionCompat.QueueItem)localIterator.next()).getQueueItem());
        }
      }
      paramList = null;
      MediaSessionCompatApi21.setQueue(mSessionObj, paramList);
    }
    
    public void setRatingType(int paramInt)
    {
      if (Build.VERSION.SDK_INT < 22)
      {
        mViewTypeCount = paramInt;
        return;
      }
      ((MediaSession)mSessionObj).setRatingType(paramInt);
    }
    
    public void setSessionActivity(PendingIntent paramPendingIntent)
    {
      MediaSessionCompatApi21.setSessionActivity(mSessionObj, paramPendingIntent);
    }
    
    public void setTileSource(ea.b paramB) {}
    
    public class a
      extends IMediaSession.Stub
    {
      public a() {}
      
      public void adjustVolume(int paramInt1, int paramInt2, String paramString)
      {
        throw new AssertionError();
      }
      
      public void fastForward()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public Bundle getExtras()
      {
        throw new AssertionError();
      }
      
      public long getFlags()
      {
        throw new AssertionError();
      }
      
      public PendingIntent getLaunchPendingIntent()
      {
        throw new AssertionError();
      }
      
      public int getMaxAmplitude()
      {
        return state;
      }
      
      public MediaMetadataCompat getMetadata()
      {
        throw new AssertionError();
      }
      
      public String getPackageName()
      {
        throw new AssertionError();
      }
      
      public PlaybackStateCompat getPlaybackState()
      {
        MediaSessionCompat.e localE = MediaSessionCompat.e.this;
        return MediaSessionCompat.getStateWithUpdatedPosition(mState, mMetadata);
      }
      
      public List getQueue()
      {
        return null;
      }
      
      public CharSequence getQueueTitle()
      {
        throw new AssertionError();
      }
      
      public int getRatingType()
      {
        return mViewTypeCount;
      }
      
      public String getTag()
      {
        throw new AssertionError();
      }
      
      public ParcelableVolumeInfo getVolumeAttributes()
      {
        throw new AssertionError();
      }
      
      public void next()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void next(int paramInt)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void next(boolean paramBoolean)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void pause()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void pause(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public boolean play()
      {
        return alert;
      }
      
      public void playFromMediaId(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void playFromSearch(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void playFromUri(Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void previous()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public int rate()
      {
        return rate;
      }
      
      public void rate(MediaDescriptionCompat paramMediaDescriptionCompat)
      {
        throw new AssertionError();
      }
      
      public void rate(RatingCompat paramRatingCompat)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void rate(RatingCompat paramRatingCompat, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
      {
        Object localObject = MediaSessionCompat.e.this;
        if (!mIsActive)
        {
          String str = ((MediaSessionCompat.e)localObject).a();
          localObject = str;
          if (str == null) {
            localObject = "android.media.session.MediaController";
          }
          localObject = new ea.b((String)localObject, Binder.getCallingPid(), Binder.getCallingUid());
          mControllerCallbacks.register(paramIMediaControllerCallback, localObject);
        }
      }
      
      public void rewind()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void seekTo()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void seekTo(int paramInt)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void seekTo(long paramLong)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void seekTo(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
      {
        throw new AssertionError();
      }
      
      public void sendCommand(int paramInt)
      {
        throw new AssertionError();
      }
      
      public void sendCommand(Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat)
      {
        throw new AssertionError();
      }
      
      public void sendCommand(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper)
      {
        throw new AssertionError();
      }
      
      public void sendCommand(boolean paramBoolean)
        throws RemoteException
      {}
      
      public void sendCustomAction()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void sendCustomAction(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public boolean sendMediaButton()
      {
        return false;
      }
      
      public boolean sendMediaButton(KeyEvent paramKeyEvent)
      {
        throw new AssertionError();
      }
      
      public void setVolumeTo(int paramInt1, int paramInt2, String paramString)
      {
        throw new AssertionError();
      }
      
      public void skipToQueueItem(long paramLong)
      {
        throw new AssertionError();
      }
      
      public void stop()
        throws RemoteException
      {
        throw new AssertionError();
      }
      
      public void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
      {
        mControllerCallbacks.unregister(paramIMediaControllerCallback);
      }
      
      public boolean update()
      {
        throw new AssertionError();
      }
    }
  }
  
  @K(28)
  public static class f
    extends MediaSessionCompat.e
  {
    public f(Context paramContext, String paramString, Bundle paramBundle)
    {
      super(paramString, paramBundle);
    }
    
    public f(Object paramObject)
    {
      super();
    }
    
    public final ea.b setPlaybackState()
    {
      return new ea.b(((MediaSession)mSessionObj).getCurrentControllerInfo());
    }
    
    public void setTileSource(ea.b paramB) {}
  }
  
  public static class g
    implements MediaSessionCompat.b
  {
    public static final int TYPE_DIALOG = 0;
    public boolean alert;
    public CharSequence extendedInfo;
    public final AudioManager mAudioManager;
    public final ComponentName mComponentName;
    public PendingIntent mContentIntent;
    public final Context mContext;
    public final RemoteCallbackList<a> mControllerCallbacks = new RemoteCallbackList();
    public boolean mDestroyed = false;
    public Bundle mExtras;
    public int mFlags;
    public c mHandler;
    public boolean mIsActive = false;
    public boolean mIsMbrRegistered = false;
    public boolean mIsRccRegistered = false;
    public int mLocalStream;
    public final Object mLock = new Object();
    public final PendingIntent mMediaButtonEventReceiver;
    public MediaMetadataCompat mMetadata;
    public final String mPackageName;
    public int mRatingType;
    public final RemoteControlClient mRemoteControlClient;
    public PlaybackStateCompat mState;
    public final b mStub;
    public final String mTag;
    public ea.b mTileSource;
    public final MediaSessionCompat.Token mToken;
    public la.a mVolumeCallback = new MediaSessionCompat.MediaSessionImplBase(this);
    public f mVolumeProvider;
    public int mVolumeType;
    public List<MediaSessionCompat.QueueItem> queue;
    public int rate;
    public int state;
    public volatile MediaSessionCompat.a this$0;
    
    public g(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
    {
      if (paramComponentName != null)
      {
        mContext = paramContext;
        mPackageName = paramContext.getPackageName();
        mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
        mTag = paramString;
        mComponentName = paramComponentName;
        mMediaButtonEventReceiver = paramPendingIntent;
        mStub = new b();
        mToken = new MediaSessionCompat.Token(mStub);
        mRatingType = 0;
        mVolumeType = 1;
        mLocalStream = 3;
        mRemoteControlClient = new RemoteControlClient(paramPendingIntent);
        return;
      }
      throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
    }
    
    private void sendEvent(int paramInt)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.next(paramInt);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendEvent(Bundle paramBundle)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onEvent(paramBundle);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendEvent(boolean paramBoolean)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.next(paramBoolean);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendMetadata(int paramInt)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onPlaybackStateChanged(paramInt);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendMetadata(MediaMetadataCompat paramMediaMetadataCompat)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onMetadataChanged(paramMediaMetadataCompat);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendQueue(CharSequence paramCharSequence)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.send(paramCharSequence);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendQueue(List paramList)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.sendHit(paramList);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendSessionDestroyed()
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onSessionDestroyed();
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          mControllerCallbacks.kill();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onPlaybackStateChanged(paramPlaybackStateCompat);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    private void sendState(String paramString, Bundle paramBundle)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onEvent(paramString, paramBundle);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    public String a()
    {
      return null;
    }
    
    public void adjustVolume(int paramInt1, int paramInt2)
    {
      if (mVolumeType == 2)
      {
        f localF = mVolumeProvider;
        if (localF != null) {
          localF.clear(paramInt1);
        }
      }
      else
      {
        mAudioManager.adjustStreamVolume(mLocalStream, paramInt1, paramInt2);
      }
    }
    
    public RemoteControlClient.MetadataEditor buildOldMetadata(Bundle paramBundle)
    {
      RemoteControlClient.MetadataEditor localMetadataEditor = mRemoteControlClient.editMetadata(true);
      if (paramBundle == null) {
        return localMetadataEditor;
      }
      Bitmap localBitmap2;
      Bitmap localBitmap1;
      if (paramBundle.containsKey("android.media.metadata.ART"))
      {
        localBitmap2 = (Bitmap)paramBundle.getParcelable("android.media.metadata.ART");
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {
          localBitmap1 = localBitmap2.copy(localBitmap2.getConfig(), false);
        }
        localMetadataEditor.putBitmap(100, localBitmap1);
      }
      else if (paramBundle.containsKey("android.media.metadata.ALBUM_ART"))
      {
        localBitmap2 = (Bitmap)paramBundle.getParcelable("android.media.metadata.ALBUM_ART");
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null) {
          localBitmap1 = localBitmap2.copy(localBitmap2.getConfig(), false);
        }
        localMetadataEditor.putBitmap(100, localBitmap1);
      }
      if (paramBundle.containsKey("android.media.metadata.ALBUM")) {
        localMetadataEditor.putString(1, paramBundle.getString("android.media.metadata.ALBUM"));
      }
      if (paramBundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
        localMetadataEditor.putString(13, paramBundle.getString("android.media.metadata.ALBUM_ARTIST"));
      }
      if (paramBundle.containsKey("android.media.metadata.ARTIST")) {
        localMetadataEditor.putString(2, paramBundle.getString("android.media.metadata.ARTIST"));
      }
      if (paramBundle.containsKey("android.media.metadata.AUTHOR")) {
        localMetadataEditor.putString(3, paramBundle.getString("android.media.metadata.AUTHOR"));
      }
      if (paramBundle.containsKey("android.media.metadata.COMPILATION")) {
        localMetadataEditor.putString(15, paramBundle.getString("android.media.metadata.COMPILATION"));
      }
      if (paramBundle.containsKey("android.media.metadata.COMPOSER")) {
        localMetadataEditor.putString(4, paramBundle.getString("android.media.metadata.COMPOSER"));
      }
      if (paramBundle.containsKey("android.media.metadata.DATE")) {
        localMetadataEditor.putString(5, paramBundle.getString("android.media.metadata.DATE"));
      }
      if (paramBundle.containsKey("android.media.metadata.DISC_NUMBER")) {
        localMetadataEditor.putLong(14, paramBundle.getLong("android.media.metadata.DISC_NUMBER"));
      }
      if (paramBundle.containsKey("android.media.metadata.DURATION")) {
        localMetadataEditor.putLong(9, paramBundle.getLong("android.media.metadata.DURATION"));
      }
      if (paramBundle.containsKey("android.media.metadata.GENRE")) {
        localMetadataEditor.putString(6, paramBundle.getString("android.media.metadata.GENRE"));
      }
      if (paramBundle.containsKey("android.media.metadata.TITLE")) {
        localMetadataEditor.putString(7, paramBundle.getString("android.media.metadata.TITLE"));
      }
      if (paramBundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
        localMetadataEditor.putLong(0, paramBundle.getLong("android.media.metadata.TRACK_NUMBER"));
      }
      if (paramBundle.containsKey("android.media.metadata.WRITER")) {
        localMetadataEditor.putString(11, paramBundle.getString("android.media.metadata.WRITER"));
      }
      return localMetadataEditor;
    }
    
    public void execute(int paramInt1, int paramInt2)
    {
      if (mVolumeType == 2)
      {
        f localF = mVolumeProvider;
        if (localF != null) {
          localF.d(paramInt1);
        }
      }
      else
      {
        mAudioManager.setStreamVolume(mLocalStream, paramInt1, paramInt2);
      }
    }
    
    public void focus(PendingIntent paramPendingIntent, ComponentName paramComponentName)
    {
      mAudioManager.registerMediaButtonEventReceiver(paramComponentName);
    }
    
    public Object getMediaSession()
    {
      return null;
    }
    
    public int getRccStateFromState(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return -1;
      case 10: 
      case 11: 
        return 6;
      case 9: 
        return 7;
      case 7: 
        return 9;
      case 6: 
      case 8: 
        return 8;
      case 5: 
        return 5;
      case 4: 
        return 4;
      case 3: 
        return 3;
      case 2: 
        return 2;
      case 1: 
        return 1;
      }
      return 0;
    }
    
    public int getRccTransportControlFlagsFromActions(long paramLong)
    {
      if ((1L & paramLong) != 0L) {
        j = 32;
      } else {
        j = 0;
      }
      int i = j;
      if ((0x2 & paramLong) != 0L) {
        i = j | 0x10;
      }
      int j = i;
      if ((0x4 & paramLong) != 0L) {
        j = i | 0x4;
      }
      i = j;
      if ((0x8 & paramLong) != 0L) {
        i = j | 0x2;
      }
      j = i;
      if ((0x10 & paramLong) != 0L) {
        j = i | 0x1;
      }
      i = j;
      if ((0x20 & paramLong) != 0L) {
        i = j | 0x80;
      }
      j = i;
      if ((0x40 & paramLong) != 0L) {
        j = i | 0x40;
      }
      i = j;
      if ((paramLong & 0x200) != 0L) {
        i = j | 0x8;
      }
      return i;
    }
    
    public Object getRoot()
    {
      return null;
    }
    
    public MediaSessionCompat.Token getSessionToken()
    {
      return mToken;
    }
    
    public PlaybackStateCompat getStateWithUpdatedPosition()
    {
      Object localObject = mLock;
      try
      {
        PlaybackStateCompat localPlaybackStateCompat = mState;
        return localPlaybackStateCompat;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public boolean isActive()
    {
      return mIsActive;
    }
    
    public void release()
    {
      mIsActive = false;
      mDestroyed = true;
      update();
      sendSessionDestroyed();
    }
    
    public void sendEvent(String paramString, Bundle paramBundle)
    {
      sendState(paramString, paramBundle);
    }
    
    public void sendQueue(int paramInt)
    {
      if (state != paramInt)
      {
        state = paramInt;
        sendEvent(paramInt);
      }
    }
    
    public void sendQueue(boolean paramBoolean)
    {
      if (alert != paramBoolean)
      {
        alert = paramBoolean;
        sendEvent(paramBoolean);
      }
    }
    
    public void sendState(int paramInt)
    {
      if (rate != paramInt)
      {
        rate = paramInt;
        sendMetadata(paramInt);
      }
    }
    
    public void sendVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
    {
      int i = mControllerCallbacks.beginBroadcast() - 1;
      for (;;)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0) {
          localIMediaControllerCallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
        }
        try
        {
          localIMediaControllerCallback.onVolumeInfoChanged(paramParcelableVolumeInfo);
          i -= 1;
          continue;
          mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
      }
    }
    
    public void setActive(boolean paramBoolean)
    {
      if (paramBoolean == mIsActive) {
        return;
      }
      mIsActive = paramBoolean;
      if (update())
      {
        setMetadata(mMetadata);
        setPlaybackState(mState);
      }
    }
    
    public void setCallback(MediaSessionCompat.a paramA, Handler paramHandler)
    {
      this$0 = paramA;
      if (paramA != null)
      {
        paramA = paramHandler;
        if (paramHandler == null) {
          paramA = new Handler();
        }
        paramHandler = mLock;
        try
        {
          if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
          }
          mHandler = new c(paramA.getLooper());
          this$0.enqueue(this, paramA);
          return;
        }
        catch (Throwable paramA)
        {
          throw paramA;
        }
      }
    }
    
    public void setExtras(Bundle paramBundle)
    {
      mExtras = paramBundle;
      sendEvent(paramBundle);
    }
    
    public void setFlags(int paramInt)
    {
      Object localObject = mLock;
      try
      {
        mFlags = paramInt;
        update();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public void setMediaButtonReceiver(PendingIntent paramPendingIntent) {}
    
    public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
    {
      MediaMetadataCompat localMediaMetadataCompat = paramMediaMetadataCompat;
      if (paramMediaMetadataCompat != null) {
        localMediaMetadataCompat = new MediaMetadataCompat.b(paramMediaMetadataCompat, MediaSessionCompat.mState).cloneMetadataIfNeeded();
      }
      paramMediaMetadataCompat = mLock;
      try
      {
        mMetadata = localMediaMetadataCompat;
        sendMetadata(localMediaMetadataCompat);
        if (!mIsActive) {
          return;
        }
        if (localMediaMetadataCompat == null) {
          paramMediaMetadataCompat = null;
        } else {
          paramMediaMetadataCompat = localMediaMetadataCompat.getBundle();
        }
        buildOldMetadata(paramMediaMetadataCompat).apply();
        return;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public ea.b setPlaybackState()
    {
      Object localObject = mLock;
      try
      {
        ea.b localB = mTileSource;
        return localB;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    
    public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      Object localObject = mLock;
      try
      {
        mState = paramPlaybackStateCompat;
        sendState(paramPlaybackStateCompat);
        if (!mIsActive) {
          return;
        }
        if (paramPlaybackStateCompat == null)
        {
          mRemoteControlClient.setPlaybackState(0);
          mRemoteControlClient.setTransportControlFlags(0);
          return;
        }
        setState(paramPlaybackStateCompat);
        mRemoteControlClient.setTransportControlFlags(getRccTransportControlFlagsFromActions(paramPlaybackStateCompat.getActions()));
        return;
      }
      catch (Throwable paramPlaybackStateCompat)
      {
        throw paramPlaybackStateCompat;
      }
    }
    
    public void setPlaybackToLocal(int paramInt)
    {
      f localF = mVolumeProvider;
      if (localF != null) {
        localF.setCallback(null);
      }
      mLocalStream = paramInt;
      mVolumeType = 1;
      paramInt = mVolumeType;
      int i = mLocalStream;
      sendVolumeInfoChanged(new ParcelableVolumeInfo(paramInt, i, 2, mAudioManager.getStreamMaxVolume(i), mAudioManager.getStreamVolume(mLocalStream)));
    }
    
    public void setPlaybackToRemote(f paramF)
    {
      if (paramF != null)
      {
        f localF = mVolumeProvider;
        if (localF != null) {
          localF.setCallback(null);
        }
        mVolumeType = 2;
        mVolumeProvider = paramF;
        sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, mVolumeProvider.getCurrentVolume(), mVolumeProvider.getVolumeControl(), mVolumeProvider.getMaxVolume()));
        paramF.setCallback(mVolumeCallback);
        return;
      }
      throw new IllegalArgumentException("volumeProvider may not be null");
    }
    
    public void setQueue(CharSequence paramCharSequence)
    {
      extendedInfo = paramCharSequence;
      sendQueue(paramCharSequence);
    }
    
    public void setQueue(List paramList)
    {
      queue = paramList;
      sendQueue(paramList);
    }
    
    public void setRatingType(int paramInt)
    {
      mRatingType = paramInt;
    }
    
    public void setSessionActivity(PendingIntent paramPendingIntent)
    {
      Object localObject = mLock;
      try
      {
        mContentIntent = paramPendingIntent;
        return;
      }
      catch (Throwable paramPendingIntent)
      {
        throw paramPendingIntent;
      }
    }
    
    public void setState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      mRemoteControlClient.setPlaybackState(getRccStateFromState(paramPlaybackStateCompat.getState()));
    }
    
    public void setTileSource(ea.b paramB)
    {
      Object localObject = mLock;
      try
      {
        mTileSource = paramB;
        return;
      }
      catch (Throwable paramB)
      {
        throw paramB;
      }
    }
    
    public void unregisterMediaButtonEventReceiver(PendingIntent paramPendingIntent, ComponentName paramComponentName)
    {
      mAudioManager.unregisterMediaButtonEventReceiver(paramComponentName);
    }
    
    public boolean update()
    {
      if (mIsActive)
      {
        if ((!mIsRccRegistered) && ((mFlags & 0x1) != 0))
        {
          focus(mMediaButtonEventReceiver, mComponentName);
          mIsRccRegistered = true;
        }
        else if ((mIsRccRegistered) && ((mFlags & 0x1) == 0))
        {
          unregisterMediaButtonEventReceiver(mMediaButtonEventReceiver, mComponentName);
          mIsRccRegistered = false;
        }
        if ((!mIsMbrRegistered) && ((mFlags & 0x2) != 0))
        {
          mAudioManager.registerRemoteControlClient(mRemoteControlClient);
          mIsMbrRegistered = true;
          return true;
        }
        if ((mIsMbrRegistered) && ((mFlags & 0x2) == 0))
        {
          mRemoteControlClient.setPlaybackState(0);
          mAudioManager.unregisterRemoteControlClient(mRemoteControlClient);
          mIsMbrRegistered = false;
        }
      }
      else
      {
        if (mIsRccRegistered)
        {
          unregisterMediaButtonEventReceiver(mMediaButtonEventReceiver, mComponentName);
          mIsRccRegistered = false;
        }
        if (mIsMbrRegistered)
        {
          mRemoteControlClient.setPlaybackState(0);
          mAudioManager.unregisterRemoteControlClient(mRemoteControlClient);
          mIsMbrRegistered = false;
        }
      }
      return false;
    }
    
    public void write(int paramInt1, int paramInt2, int paramInt3, Object paramObject, Bundle paramBundle)
    {
      Object localObject = mLock;
      try
      {
        if (mHandler != null)
        {
          paramObject = mHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
          Bundle localBundle = new Bundle();
          localBundle.putString("data_calling_pkg", "android.media.session.MediaController");
          localBundle.putInt("data_calling_pid", Binder.getCallingPid());
          localBundle.putInt("data_calling_uid", Binder.getCallingUid());
          if (paramBundle != null) {
            localBundle.putBundle("data_extras", paramBundle);
          }
          paramObject.setData(localBundle);
          paramObject.sendToTarget();
        }
        return;
      }
      catch (Throwable paramObject)
      {
        throw paramObject;
      }
    }
    
    private static final class a
    {
      public final String count;
      public final ResultReceiver p;
      public final Bundle s;
      
      public a(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
      {
        count = paramString;
        s = paramBundle;
        p = paramResultReceiver;
      }
    }
    
    public class b
      extends IMediaSession.Stub
    {
      public b() {}
      
      public void adjustVolume(int paramInt1, int paramInt2, String paramString)
      {
        adjustVolume(paramInt1, paramInt2);
      }
      
      public void fastForward()
        throws RemoteException
      {
        post(16);
      }
      
      public Bundle getExtras()
      {
        Object localObject = mLock;
        try
        {
          Bundle localBundle = mExtras;
          return localBundle;
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public long getFlags()
      {
        Object localObject = mLock;
        try
        {
          long l = mFlags;
          return l;
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public PendingIntent getLaunchPendingIntent()
      {
        Object localObject = mLock;
        try
        {
          PendingIntent localPendingIntent = mContentIntent;
          return localPendingIntent;
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public int getMaxAmplitude()
      {
        return state;
      }
      
      public MediaMetadataCompat getMetadata()
      {
        return mMetadata;
      }
      
      public String getPackageName()
      {
        return mPackageName;
      }
      
      public PlaybackStateCompat getPlaybackState()
      {
        Object localObject = mLock;
        try
        {
          PlaybackStateCompat localPlaybackStateCompat = mState;
          MediaMetadataCompat localMediaMetadataCompat = mMetadata;
          return MediaSessionCompat.getStateWithUpdatedPosition(localPlaybackStateCompat, localMediaMetadataCompat);
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public List getQueue()
      {
        Object localObject = mLock;
        try
        {
          List localList = queue;
          return localList;
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public CharSequence getQueueTitle()
      {
        return extendedInfo;
      }
      
      public int getRatingType()
      {
        return mRatingType;
      }
      
      public String getTag()
      {
        return mTag;
      }
      
      public ParcelableVolumeInfo getVolumeAttributes()
      {
        Object localObject1 = mLock;
        try
        {
          int m = mVolumeType;
          int n = mLocalStream;
          Object localObject2 = mVolumeProvider;
          int i;
          int j;
          int k;
          if (m == 2)
          {
            i = ((f)localObject2).getCurrentVolume();
            j = ((f)localObject2).getVolumeControl();
            k = ((f)localObject2).getMaxVolume();
          }
          else
          {
            j = mAudioManager.getStreamMaxVolume(n);
            localObject2 = mAudioManager;
            k = ((AudioManager)localObject2).getStreamVolume(n);
            i = 2;
          }
          return new ParcelableVolumeInfo(m, n, i, j, k);
        }
        catch (Throwable localThrowable)
        {
          throw localThrowable;
        }
      }
      
      public void next()
        throws RemoteException
      {
        post(14);
      }
      
      public void next(int paramInt)
        throws RemoteException
      {
        sendCommand(30, paramInt);
      }
      
      public void next(int paramInt1, Object paramObject, int paramInt2)
      {
        write(paramInt1, paramInt2, 0, paramObject, null);
      }
      
      public void next(boolean paramBoolean)
        throws RemoteException
      {
        sendCommand(29, Boolean.valueOf(paramBoolean));
      }
      
      public void pause()
        throws RemoteException
      {
        post(12);
      }
      
      public void pause(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        post(5, paramString, paramBundle);
      }
      
      public boolean play()
      {
        return alert;
      }
      
      public void playFromMediaId(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        post(8, paramString, paramBundle);
      }
      
      public void playFromSearch(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        post(9, paramString, paramBundle);
      }
      
      public void playFromUri(Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        post(10, paramUri, paramBundle);
      }
      
      public void post(int paramInt)
      {
        write(paramInt, 0, 0, null, null);
      }
      
      public void post(int paramInt, Object paramObject, Bundle paramBundle)
      {
        write(paramInt, 0, 0, paramObject, paramBundle);
      }
      
      public void previous()
        throws RemoteException
      {
        post(15);
      }
      
      public int rate()
      {
        return rate;
      }
      
      public void rate(MediaDescriptionCompat paramMediaDescriptionCompat)
      {
        sendCommand(25, paramMediaDescriptionCompat);
      }
      
      public void rate(RatingCompat paramRatingCompat)
        throws RemoteException
      {
        sendCommand(19, paramRatingCompat);
      }
      
      public void rate(RatingCompat paramRatingCompat, Bundle paramBundle)
        throws RemoteException
      {
        post(31, paramRatingCompat, paramBundle);
      }
      
      public void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
      {
        if (mDestroyed) {}
        try
        {
          paramIMediaControllerCallback.onSessionDestroyed();
          return;
        }
        catch (Exception paramIMediaControllerCallback) {}
        ea.b localB = new ea.b("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid());
        mControllerCallbacks.register(paramIMediaControllerCallback, localB);
        return;
      }
      
      public void rewind()
        throws RemoteException
      {
        post(17);
      }
      
      public void seekTo()
        throws RemoteException
      {
        post(3);
      }
      
      public void seekTo(int paramInt)
        throws RemoteException
      {
        sendCommand(23, paramInt);
      }
      
      public void seekTo(long paramLong)
        throws RemoteException
      {
        sendCommand(18, Long.valueOf(paramLong));
      }
      
      public void seekTo(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
      {
        next(26, paramMediaDescriptionCompat, paramInt);
      }
      
      public void sendCommand(int paramInt)
      {
        sendCommand(28, paramInt);
      }
      
      public void sendCommand(int paramInt1, int paramInt2)
      {
        write(paramInt1, paramInt2, 0, null, null);
      }
      
      public void sendCommand(int paramInt, Object paramObject)
      {
        write(paramInt, 0, 0, paramObject, null);
      }
      
      public void sendCommand(Uri paramUri, Bundle paramBundle)
        throws RemoteException
      {
        post(6, paramUri, paramBundle);
      }
      
      public void sendCommand(MediaDescriptionCompat paramMediaDescriptionCompat)
      {
        sendCommand(27, paramMediaDescriptionCompat);
      }
      
      public void sendCommand(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        post(4, paramString, paramBundle);
      }
      
      public void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper)
      {
        sendCommand(1, new MediaSessionCompat.g.a(paramString, paramBundle, mResultReceiver));
      }
      
      public void sendCommand(boolean paramBoolean)
        throws RemoteException
      {}
      
      public void sendCustomAction()
        throws RemoteException
      {
        post(7);
      }
      
      public void sendCustomAction(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        post(20, paramString, paramBundle);
      }
      
      public boolean sendMediaButton()
      {
        return false;
      }
      
      public boolean sendMediaButton(KeyEvent paramKeyEvent)
      {
        int i = mFlags;
        boolean bool = true;
        if ((i & 0x1) == 0) {
          bool = false;
        }
        if (bool) {
          sendCommand(21, paramKeyEvent);
        }
        return bool;
      }
      
      public void setVolumeTo(int paramInt1, int paramInt2, String paramString)
      {
        execute(paramInt1, paramInt2);
      }
      
      public void skipToQueueItem(long paramLong)
      {
        sendCommand(11, Long.valueOf(paramLong));
      }
      
      public void stop()
        throws RemoteException
      {
        post(13);
      }
      
      public void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
      {
        mControllerCallbacks.unregister(paramIMediaControllerCallback);
      }
      
      public boolean update()
      {
        return (mFlags & 0x2) != 0;
      }
    }
    
    public class c
      extends Handler
    {
      public static final int BEFORE = 23;
      public static final int CONTEXT_MENU_DELETE_ID = 16;
      public static final int CV_IMWRITE_PNG_STRATEGY = 17;
      public static final int DELETE_CONTEXT = 8;
      public static final int DIALOG_CANCEL = 5;
      public static final int DIALOG_LOAD_FAILED = 21;
      public static final int DISK_CACHE_VERSION = 9;
      public static final int KEYCODE_A = 29;
      public static final int KEYCODE_B = 30;
      public static final int KEYCODE_C = 31;
      public static final int KEYCODE_CAMERA = 27;
      public static final int KEYCODE_CLEAR = 28;
      public static final int KEYCODE_MEDIA_PAUSE = 127;
      public static final int KEYCODE_MEDIA_PLAY = 126;
      public static final int KEYCODE_POUND = 18;
      public static final int KEYCODE_POWER = 26;
      public static final int MENU_GROUP_MUSIC_FOLDER = 10;
      public static final int MENU_SPIDER = 14;
      public static final int PRIORITY_MIDHIGH = 7;
      public static final int RB = 11;
      public static final int SCREEN_COUNT = 20;
      public static final int SELECT_FOLDER = 12;
      public static final int SMTP = 25;
      public static final int SORT_MENU_ITEM = 3;
      public static final int SUM = 22;
      public static final int TRANSACTION_getArtistId = 19;
      public static final int TRANSLATE = 15;
      public static final int TYPE_DIALOG = 2;
      public static final int TYPE_EXPANDED = 1;
      public static final int TYPE_WILDCARD = 13;
      public static final int UPDATE_CONTEXT = 6;
      public static final int VIEW_SERIEDETAILS_CONTEXT = 4;
      
      public c(Looper paramLooper)
      {
        super();
      }
      
      private void onMediaButtonEvent(KeyEvent paramKeyEvent, MediaSessionCompat.a paramA)
      {
        if (paramKeyEvent != null)
        {
          if (paramKeyEvent.getAction() != 0) {
            return;
          }
          PlaybackStateCompat localPlaybackStateCompat = mState;
          long l;
          if (localPlaybackStateCompat == null) {
            l = 0L;
          } else {
            l = localPlaybackStateCompat.getActions();
          }
          int i = paramKeyEvent.getKeyCode();
          if (i != 79)
          {
            if (i != 126) {
              if (i == 127) {}
            }
            switch (i)
            {
            default: 
              
            case 90: 
              if ((l & 0x40) != 0L)
              {
                paramA.onFastForward();
                return;
              }
              break;
            case 89: 
              if ((l & 0x8) != 0L)
              {
                paramA.onRewind();
                return;
              }
              break;
            case 88: 
              if ((l & 0x10) != 0L)
              {
                paramA.onSkipToPrevious();
                return;
              }
              break;
            case 87: 
              if ((l & 0x20) != 0L)
              {
                paramA.append();
                return;
              }
              break;
            case 86: 
              if ((l & 1L) != 0L)
              {
                paramA.onStop();
                return;
                if ((l & 0x2) != 0L)
                {
                  paramA.pause();
                  return;
                  if ((l & 0x4) != 0L) {
                    paramA.onPlay();
                  }
                }
              }
              break;
            }
          }
        }
      }
      
      public void handleMessage(Message paramMessage)
      {
        MediaSessionCompat.a localA = this$0;
        if (localA == null) {
          return;
        }
        Object localObject = paramMessage.getData();
        MediaSessionCompat.append((Bundle)localObject);
        setTileSource(new ea.b(((Bundle)localObject).getString("data_calling_pkg"), ((Bundle)localObject).getInt("data_calling_pid"), ((Bundle)localObject).getInt("data_calling_uid")));
        localObject = ((Bundle)localObject).getBundle("data_extras");
        MediaSessionCompat.append((Bundle)localObject);
        try
        {
          int i = what;
          switch (i)
          {
          default: 
            break;
          case 24: 
            break;
          case 31: 
            localA.onCustomAction((RatingCompat)obj, (Bundle)localObject);
            break;
          case 30: 
            localA.updateState(arg1);
            break;
          case 29: 
            localA.onRefreshComplete(((Boolean)obj).booleanValue());
            break;
          case 28: 
            localObject = queue;
            if (localObject == null) {
              break;
            }
            i = arg1;
            if (i >= 0)
            {
              int j = queue.size();
              if (i < j)
              {
                paramMessage = (MediaSessionCompat.QueueItem)queue.get(arg1);
                break label459;
              }
            }
            paramMessage = null;
            if (paramMessage == null) {
              break;
            }
            localA.log(paramMessage.getDescription());
            break;
          case 27: 
            localA.log((MediaDescriptionCompat)obj);
            break;
          case 26: 
            localA.updateState((MediaDescriptionCompat)obj, arg1);
            break;
          case 25: 
            localA.MotionCallback((MediaDescriptionCompat)obj);
            break;
          case 23: 
            localA.setProgress(arg1);
            break;
          case 22: 
            execute(arg1, 0);
            break;
          case 21: 
            paramMessage = (KeyEvent)obj;
            localObject = new Intent("android.intent.action.MEDIA_BUTTON");
            ((Intent)localObject).putExtra("android.intent.extra.KEY_EVENT", paramMessage);
            boolean bool = localA.update((Intent)localObject);
            if (bool) {
              break;
            }
            onMediaButtonEvent(paramMessage, localA);
            break;
          case 20: 
            localA.onCustomAction((String)obj, (Bundle)localObject);
            break;
          case 19: 
            localA.onSetRating((RatingCompat)obj);
            break;
          case 18: 
            localA.onSeekTo(((Long)obj).longValue());
            break;
          case 17: 
            localA.onRewind();
            break;
          case 16: 
            localA.onFastForward();
            break;
          case 15: 
            localA.onSkipToPrevious();
            break;
          case 14: 
            localA.append();
            break;
          case 13: 
            localA.onStop();
            break;
          case 12: 
            localA.pause();
            break;
          case 11: 
            localA.onSkipToQueueItem(((Long)obj).longValue());
            break;
          case 10: 
            localA.onPlayFromUri((Uri)obj, (Bundle)localObject);
            break;
          case 9: 
            localA.onCommand((String)obj, (Bundle)localObject);
            break;
          case 8: 
            localA.onPlayFromMediaId((String)obj, (Bundle)localObject);
            break;
          case 7: 
            localA.onPlay();
            break;
          case 6: 
            localA.remove((Uri)obj, (Bundle)localObject);
            break;
          case 5: 
            localA.append((String)obj, (Bundle)localObject);
            break;
          case 4: 
            localA.connect((String)obj, (Bundle)localObject);
            break;
          case 3: 
            localA.clear();
            break;
          case 2: 
            label459:
            adjustVolume(arg1, 0);
            break;
          }
          paramMessage = (MediaSessionCompat.g.a)obj;
          localA.remove(count, s, p);
          setTileSource(null);
          return;
        }
        catch (Throwable paramMessage)
        {
          setTileSource(null);
          throw paramMessage;
        }
      }
    }
  }
  
  public static abstract interface h
  {
    public abstract void destroyProxy();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface i {}
}
