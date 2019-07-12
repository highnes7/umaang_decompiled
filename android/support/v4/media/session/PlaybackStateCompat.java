package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import support.android.v4.asm.session.AddressAndLabel.1;
import support.android.v4.asm.session.PlaybackStateCompatApi21.CustomAction;
import support.android.v4.asm.session.PlaybackStateCompatApi22;
import support.android.v4.asm.session.Point.1;

public final class PlaybackStateCompat
  implements Parcelable
{
  public static final int ACCOUNT_COLUMN = 1;
  public static final long ACTION_FAST_FORWARD = 64L;
  public static final int ACTION_PAUSE = 3;
  public static final int ACTION_PLAY = 2;
  public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
  public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
  public static final long ACTION_PLAY_FROM_URI = 8192L;
  public static final long ACTION_PLAY_PAUSE = 512L;
  public static final int ACTION_REWIND = 8;
  public static final long ACTION_SEEK_TO = 256L;
  public static final long ACTION_SET_RATING = 128L;
  public static final long ACTION_SKIP_TO_NEXT = 32L;
  public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
  public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4L;
  @Deprecated
  public static final long ACTION_STOP = 524288L;
  public static final int ALIGNMENT = 1;
  public static final long ARMTHUMB_FILTER_ID = 8L;
  public static final int BUTTON_WEEK_INDEX = 1;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final int CALENDARS_INDEX_COLOR = 3;
  public static final int COLORS_INDEX_COLOR = 0;
  public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Point.1();
  public static final int ConstructorId_fromCharCode = -1;
  public static final int DATE_ADDED = 11;
  public static final int DELETE_CONTEXT = 8;
  public static final long EMIT_BUFFER_SIZE = 16384L;
  public static final long EXTRA_GOTO_DATE = 1L;
  public static final long EXTRA_GOTO_TIME = 2L;
  public static final int HINT_CONTEXT_UNKNOWN = 0;
  public static final int HORIZONTAL_EM_WIDTH = 10;
  public static final int KEYBOARD_WARNING_DIALOG_OK = 2;
  public static final int KEYBOARD_WARNING_DIALOG_SHOWN = 0;
  public static final int KEYCODE_MEDIA_PAUSE = 127;
  public static final int KEYCODE_MEDIA_PLAY = 126;
  public static final long MAX_SIZE = 32768L;
  public static final int MAX_TILES_PER_ROW = 6;
  public static final long MB = 1048576L;
  public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
  public static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144L;
  public static final int RETRY_AFTER_IDX = 9;
  public static final int SDLK_D = 7;
  public static final long SPECIFIED_MARKER_START = 2097152L;
  public static final int STATE_BUFFERING = 6;
  public static final int STATE_CONNECTING = 2;
  public static final int STATE_ERROR = 7;
  public static final int STATE_FAST_FORWARDING = 4;
  public static final int STATE_NONE = -1;
  public static final int STATE_PAUSED = 3;
  public static final int STATE_PLAYING = 0;
  public static final int STATE_REWINDING = 5;
  public static final int STATE_SKIPPING_TO_NEXT = 10;
  public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
  public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
  public static final int STATE_STOPPED = 1;
  public static final int TOKEN_QUERY_CALENDARS = 2;
  public static final int TRANSACTION_getInfo = 5;
  public static final long _2_TO_16_ = 65536L;
  public static final long bufferSize = 131072L;
  public static final long maxBufferSize = 4096L;
  public final long mActions;
  public final long mActiveItemId;
  public final long mBufferedPosition;
  public List<CustomAction> mCustomActions;
  public final CharSequence mErrorMessage;
  public final Bundle mExtras;
  public final int mFlags;
  public final long mPosition;
  public final float mSpeed;
  public final int mState;
  public Object mStateObj;
  public final long mUpdateTime;
  
  public PlaybackStateCompat(int paramInt1, long paramLong1, long paramLong2, float paramFloat, long paramLong3, int paramInt2, CharSequence paramCharSequence, long paramLong4, List paramList, long paramLong5, Bundle paramBundle)
  {
    mState = paramInt1;
    mPosition = paramLong1;
    mBufferedPosition = paramLong2;
    mSpeed = paramFloat;
    mActions = paramLong3;
    mFlags = paramInt2;
    mErrorMessage = paramCharSequence;
    mUpdateTime = paramLong4;
    mCustomActions = new ArrayList(paramList);
    mActiveItemId = paramLong5;
    mExtras = paramBundle;
  }
  
  public PlaybackStateCompat(Parcel paramParcel)
  {
    mState = paramParcel.readInt();
    mPosition = paramParcel.readLong();
    mSpeed = paramParcel.readFloat();
    mUpdateTime = paramParcel.readLong();
    mBufferedPosition = paramParcel.readLong();
    mActions = paramParcel.readLong();
    mErrorMessage = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mCustomActions = paramParcel.createTypedArrayList(CustomAction.CREATOR);
    mActiveItemId = paramParcel.readLong();
    mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    mFlags = paramParcel.readInt();
  }
  
  public static PlaybackStateCompat fromPlaybackState(Object paramObject)
  {
    Bundle localBundle = null;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject2 = support.android.v4.asm.session.PlaybackStateCompat.getCustomActions(paramObject);
      if (localObject2 != null)
      {
        localObject1 = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(CustomAction.fromCustomAction(((Iterator)localObject2).next()));
        }
      }
      else
      {
        localObject1 = null;
      }
      if (Build.VERSION.SDK_INT >= 22) {
        localBundle = PlaybackStateCompatApi22.getExtras(paramObject);
      }
      Object localObject1 = new PlaybackStateCompat(support.android.v4.asm.session.PlaybackStateCompat.getState(paramObject), support.android.v4.asm.session.PlaybackStateCompat.getPosition(paramObject), support.android.v4.asm.session.PlaybackStateCompat.getBufferedPosition(paramObject), support.android.v4.asm.session.PlaybackStateCompat.getPlaybackSpeed(paramObject), support.android.v4.asm.session.PlaybackStateCompat.getActions(paramObject), 0, support.android.v4.asm.session.PlaybackStateCompat.getErrorMessage(paramObject), support.android.v4.asm.session.PlaybackStateCompat.getLastPositionUpdateTime(paramObject), (List)localObject1, support.android.v4.asm.session.PlaybackStateCompat.getActiveQueueItemId(paramObject), localBundle);
      mStateObj = paramObject;
      return localObject1;
    }
    return null;
  }
  
  public static int getToken(long paramLong)
  {
    if (paramLong == 4L) {
      return 126;
    }
    if (paramLong == 2L) {
      return 127;
    }
    if (paramLong == 32L) {
      return 87;
    }
    if (paramLong == 16L) {
      return 88;
    }
    if (paramLong == 1L) {
      return 86;
    }
    if (paramLong == 64L) {
      return 90;
    }
    if (paramLong == 8L) {
      return 89;
    }
    if (paramLong == 512L) {
      return 85;
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getActions()
  {
    return mActions;
  }
  
  public long getActiveQueueItemId()
  {
    return mActiveItemId;
  }
  
  public long getBufferedPosition()
  {
    return mBufferedPosition;
  }
  
  public List getCustomActions()
  {
    return mCustomActions;
  }
  
  public CharSequence getErrorMessage()
  {
    return mErrorMessage;
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public int getFlags()
  {
    return mFlags;
  }
  
  public long getLastPositionUpdateTime()
  {
    return mUpdateTime;
  }
  
  public float getPlaybackSpeed()
  {
    return mSpeed;
  }
  
  public Object getPlaybackState()
  {
    if ((mStateObj == null) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject1 = null;
      Object localObject2 = mCustomActions;
      if (localObject2 != null)
      {
        localObject2 = new ArrayList(((List)localObject2).size());
        Iterator localIterator = mCustomActions.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          ((List)localObject2).add(((CustomAction)localIterator.next()).getCustomAction());
        }
      }
      if (Build.VERSION.SDK_INT >= 22) {
        mStateObj = PlaybackStateCompatApi22.newInstance(mState, mPosition, mBufferedPosition, mSpeed, mActions, mErrorMessage, mUpdateTime, localObject1, mActiveItemId, mExtras);
      } else {
        mStateObj = support.android.v4.asm.session.PlaybackStateCompat.newInstance(mState, mPosition, mBufferedPosition, mSpeed, mActions, mErrorMessage, mUpdateTime, localObject1, mActiveItemId);
      }
    }
    return mStateObj;
  }
  
  public long getPosition()
  {
    return mPosition;
  }
  
  public long getPosition(Long paramLong)
  {
    long l2 = mPosition;
    float f = mSpeed;
    long l1;
    if (paramLong != null) {
      l1 = paramLong.longValue();
    } else {
      l1 = SystemClock.elapsedRealtime() - mUpdateTime;
    }
    return Math.max(0L, l2 + (f * (float)l1));
  }
  
  public int getState()
  {
    return mState;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PlaybackState {");
    localStringBuilder.append("state=");
    localStringBuilder.append(mState);
    localStringBuilder.append(", position=");
    localStringBuilder.append(mPosition);
    localStringBuilder.append(", buffered position=");
    localStringBuilder.append(mBufferedPosition);
    localStringBuilder.append(", speed=");
    localStringBuilder.append(mSpeed);
    localStringBuilder.append(", updated=");
    localStringBuilder.append(mUpdateTime);
    localStringBuilder.append(", actions=");
    localStringBuilder.append(mActions);
    localStringBuilder.append(", error code=");
    localStringBuilder.append(mFlags);
    localStringBuilder.append(", error message=");
    localStringBuilder.append(mErrorMessage);
    localStringBuilder.append(", custom actions=");
    localStringBuilder.append(mCustomActions);
    localStringBuilder.append(", active item id=");
    localStringBuilder.append(mActiveItemId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mState);
    paramParcel.writeLong(mPosition);
    paramParcel.writeFloat(mSpeed);
    paramParcel.writeLong(mUpdateTime);
    paramParcel.writeLong(mBufferedPosition);
    paramParcel.writeLong(mActions);
    TextUtils.writeToParcel(mErrorMessage, paramParcel, paramInt);
    paramParcel.writeTypedList(mCustomActions);
    paramParcel.writeLong(mActiveItemId);
    paramParcel.writeBundle(mExtras);
    paramParcel.writeInt(mFlags);
  }
  
  public static final class CustomAction
    implements Parcelable
  {
    public static final Parcelable.Creator<CustomAction> CREATOR = new AddressAndLabel.1();
    public final String mAction;
    public Object mCustomActionObj;
    public final Bundle mExtras;
    public final int mIcon;
    public final CharSequence mName;
    
    public CustomAction(Parcel paramParcel)
    {
      mAction = paramParcel.readString();
      mName = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      mIcon = paramParcel.readInt();
      mExtras = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
    
    public CustomAction(String paramString, CharSequence paramCharSequence, int paramInt, Bundle paramBundle)
    {
      mAction = paramString;
      mName = paramCharSequence;
      mIcon = paramInt;
      mExtras = paramBundle;
    }
    
    public static CustomAction fromCustomAction(Object paramObject)
    {
      if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
      {
        CustomAction localCustomAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(paramObject), PlaybackStateCompatApi21.CustomAction.getName(paramObject), PlaybackStateCompatApi21.CustomAction.getIcon(paramObject), PlaybackStateCompatApi21.CustomAction.getExtras(paramObject));
        mCustomActionObj = paramObject;
        return localCustomAction;
      }
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getAction()
    {
      return mAction;
    }
    
    public Object getCustomAction()
    {
      if ((mCustomActionObj == null) && (Build.VERSION.SDK_INT >= 21))
      {
        mCustomActionObj = PlaybackStateCompatApi21.CustomAction.newInstance(mAction, mName, mIcon, mExtras);
        return mCustomActionObj;
      }
      return mCustomActionObj;
    }
    
    public Bundle getExtras()
    {
      return mExtras;
    }
    
    public int getIcon()
    {
      return mIcon;
    }
    
    public CharSequence getName()
    {
      return mName;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Action:mName='");
      localStringBuilder.append(mName);
      localStringBuilder.append(", mIcon=");
      localStringBuilder.append(mIcon);
      localStringBuilder.append(", mExtras=");
      localStringBuilder.append(mExtras);
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(mAction);
      TextUtils.writeToParcel(mName, paramParcel, paramInt);
      paramParcel.writeInt(mIcon);
      paramParcel.writeBundle(mExtras);
    }
    
    public static final class a
    {
      public final int charset;
      public Bundle mValues;
      public final CharSequence params;
      public final String restUrl;
      
      public a(String paramString, CharSequence paramCharSequence, int paramInt)
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if (!TextUtils.isEmpty(paramCharSequence))
          {
            if (paramInt != 0)
            {
              restUrl = paramString;
              params = paramCharSequence;
              charset = paramInt;
              return;
            }
            throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
          }
          throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
        }
        throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
      }
      
      public PlaybackStateCompat.CustomAction build()
      {
        return new PlaybackStateCompat.CustomAction(restUrl, params, charset, mValues);
      }
      
      public a put(Bundle paramBundle)
      {
        mValues = paramBundle;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface a {}
  
  public static final class b
  {
    public int mActions;
    public long mActiveItemId = -1L;
    public long mBufferedPosition;
    public final List<PlaybackStateCompat.CustomAction> mCustomActions = new ArrayList();
    public CharSequence mErrorMessage;
    public Bundle mExtras;
    public long mPosition;
    public float mRate;
    public int mState;
    public long mUpdateTime;
    public long mWidth;
    
    public b() {}
    
    public b(PlaybackStateCompat paramPlaybackStateCompat)
    {
      mState = mState;
      mPosition = mPosition;
      mRate = mSpeed;
      mUpdateTime = mUpdateTime;
      mWidth = mBufferedPosition;
      mBufferedPosition = mActions;
      mActions = mFlags;
      mErrorMessage = mErrorMessage;
      List localList = mCustomActions;
      if (localList != null) {
        mCustomActions.addAll(localList);
      }
      mActiveItemId = mActiveItemId;
      mExtras = mExtras;
    }
    
    public b addAction(int paramInt, CharSequence paramCharSequence)
    {
      mActions = paramInt;
      mErrorMessage = paramCharSequence;
      return this;
    }
    
    public b addCustomAction(PlaybackStateCompat.CustomAction paramCustomAction)
    {
      if (paramCustomAction != null)
      {
        mCustomActions.add(paramCustomAction);
        return this;
      }
      throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
    }
    
    public b addCustomAction(String paramString1, String paramString2, int paramInt)
    {
      return addCustomAction(new PlaybackStateCompat.CustomAction(paramString1, paramString2, paramInt, null));
    }
    
    public PlaybackStateCompat build()
    {
      return new PlaybackStateCompat(mState, mPosition, mWidth, mRate, mBufferedPosition, mActions, mErrorMessage, mUpdateTime, mCustomActions, mActiveItemId, mExtras);
    }
    
    public b setActiveQueueItemId(long paramLong)
    {
      mActiveItemId = paramLong;
      return this;
    }
    
    public b setBufferedPosition(long paramLong)
    {
      mBufferedPosition = paramLong;
      return this;
    }
    
    public b setErrorMessage(CharSequence paramCharSequence)
    {
      mErrorMessage = paramCharSequence;
      return this;
    }
    
    public b setExtras(Bundle paramBundle)
    {
      mExtras = paramBundle;
      return this;
    }
    
    public b setResolution(long paramLong)
    {
      mWidth = paramLong;
      return this;
    }
    
    public b setState(int paramInt, long paramLong, float paramFloat)
    {
      return setState(paramInt, paramLong, paramFloat, SystemClock.elapsedRealtime());
    }
    
    public b setState(int paramInt, long paramLong1, float paramFloat, long paramLong2)
    {
      mState = paramInt;
      mPosition = paramLong1;
      mUpdateTime = paramLong2;
      mRate = paramFloat;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface c {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface d {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface e {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface f {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface g {}
}
