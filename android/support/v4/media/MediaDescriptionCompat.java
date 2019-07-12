package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import b.b.a.N;
import support.android.v4.asm.DiscreteSeekBar.CustomState.1;
import support.android.v4.asm.MediaDescriptionCompat.Builder;
import support.android.v4.asm.MediaDescriptionCompatApi21;
import support.android.v4.asm.aa.a;

public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final long CAT_DELAY = 1L;
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new DiscreteSeekBar.CustomState.1();
  @N({b.b.a.N.a.b})
  public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
  @N({b.b.a.N.a.b})
  public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
  public static final String EVENTLOG_URL = "android.media.extra.BT_FOLDER_TYPE";
  public static final long EXTRA_GOTO_DATE = 1L;
  public static final long EXTRA_GOTO_TIME = 2L;
  public static final long FILTER_ID = 3L;
  public static final long HINT_CONTEXT_CAR_HOME = 2L;
  public static final long IA64_FILTER_ID = 6L;
  public static final String PAGE_KEY = "android.media.extra.DOWNLOAD_STATUS";
  public static final long POWERPC_FILTER_ID = 5L;
  public static final long UNDO_DELAY = 0L;
  public static final long UPDATE_FREQUENCY = 0L;
  public static final long X86_FILTER_ID = 4L;
  public final CharSequence mDescription;
  public Object mDescriptionObj;
  public final Bundle mExtras;
  public final Bitmap mIcon;
  public final Uri mIconUri;
  public final String mMediaId;
  public final Uri mMediaUri;
  public final CharSequence mSubtitle;
  public final CharSequence mTitle;
  
  public MediaDescriptionCompat(Parcel paramParcel)
  {
    mMediaId = paramParcel.readString();
    mTitle = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mSubtitle = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mDescription = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = MediaDescriptionCompat.class.getClassLoader();
    mIcon = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    mIconUri = ((Uri)paramParcel.readParcelable(localClassLoader));
    mExtras = paramParcel.readBundle(localClassLoader);
    mMediaUri = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  public MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    mMediaId = paramString;
    mTitle = paramCharSequence1;
    mSubtitle = paramCharSequence2;
    mDescription = paramCharSequence3;
    mIcon = paramBitmap;
    mIconUri = paramUri1;
    mExtras = paramBundle;
    mMediaUri = paramUri2;
  }
  
  public static MediaDescriptionCompat fromMediaDescription(Object paramObject)
  {
    Object localObject2 = null;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      a localA = new a();
      localA.setMediaId(MediaDescriptionCompatApi21.getMediaId(paramObject));
      localA.setInfo(MediaDescriptionCompatApi21.getTitle(paramObject));
      localA.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(paramObject));
      localA.setDescription(MediaDescriptionCompatApi21.getDescription(paramObject));
      localA.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(paramObject));
      localA.setIconUri(MediaDescriptionCompatApi21.getIconUri(paramObject));
      Bundle localBundle = MediaDescriptionCompatApi21.getExtras(paramObject);
      if (localBundle != null)
      {
        MediaSessionCompat.append(localBundle);
        localObject1 = (Uri)localBundle.getParcelable("android.support.v4.media.description.MEDIA_URI");
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ((!localBundle.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) || (localBundle.size() != 2))
        {
          localBundle.remove("android.support.v4.media.description.MEDIA_URI");
          localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
      }
      else {
        localObject2 = localBundle;
      }
      localA.setExtras(localObject2);
      if (localObject1 != null) {
        localA.setMediaUri((Uri)localObject1);
      } else if (Build.VERSION.SDK_INT >= 23) {
        localA.setMediaUri(MediaDescriptionCompat.Builder.getMediaUri(paramObject));
      }
      Object localObject1 = localA.build();
      mDescriptionObj = paramObject;
      return localObject1;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CharSequence getDescription()
  {
    return mDescription;
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public Bitmap getIconBitmap()
  {
    return mIcon;
  }
  
  public Uri getIconUri()
  {
    return mIconUri;
  }
  
  public Object getMediaDescription()
  {
    if ((mDescriptionObj == null) && (Build.VERSION.SDK_INT >= 21))
    {
      MediaDescription.Builder localBuilder = new MediaDescription.Builder();
      localBuilder.setMediaId(mMediaId);
      localBuilder.setTitle(mTitle);
      localBuilder.setSubtitle(mSubtitle);
      localBuilder.setDescription(mDescription);
      localBuilder.setIconBitmap(mIcon);
      localBuilder.setIconUri(mIconUri);
      Bundle localBundle2 = mExtras;
      Bundle localBundle1 = localBundle2;
      if (Build.VERSION.SDK_INT < 23)
      {
        localBundle1 = localBundle2;
        if (mMediaUri != null)
        {
          localBundle1 = localBundle2;
          if (localBundle2 == null)
          {
            localBundle1 = new Bundle();
            localBundle1.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
          }
          localBundle1.putParcelable("android.support.v4.media.description.MEDIA_URI", mMediaUri);
        }
      }
      localBuilder.setExtras(localBundle1);
      if (Build.VERSION.SDK_INT >= 23) {
        localBuilder.setMediaUri(mMediaUri);
      }
      mDescriptionObj = aa.a.build(localBuilder);
      return mDescriptionObj;
    }
    return mDescriptionObj;
  }
  
  public String getMediaId()
  {
    return mMediaId;
  }
  
  public Uri getMediaUri()
  {
    return mMediaUri;
  }
  
  public CharSequence getSubtitle()
  {
    return mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return mTitle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mTitle);
    localStringBuilder.append(", ");
    localStringBuilder.append(mSubtitle);
    localStringBuilder.append(", ");
    localStringBuilder.append(mDescription);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(mMediaId);
      TextUtils.writeToParcel(mTitle, paramParcel, paramInt);
      TextUtils.writeToParcel(mSubtitle, paramParcel, paramInt);
      TextUtils.writeToParcel(mDescription, paramParcel, paramInt);
      paramParcel.writeParcelable(mIcon, paramInt);
      paramParcel.writeParcelable(mIconUri, paramInt);
      paramParcel.writeBundle(mExtras);
      paramParcel.writeParcelable(mMediaUri, paramInt);
      return;
    }
    ((MediaDescription)getMediaDescription()).writeToParcel(paramParcel, paramInt);
  }
  
  public static final class a
  {
    public CharSequence mDescription;
    public Bundle mExtras;
    public Bitmap mIcon;
    public Uri mIconUri;
    public String mMediaId;
    public Uri mMediaUri;
    public CharSequence mSubtitle;
    public CharSequence mTitle;
    
    public a() {}
    
    public MediaDescriptionCompat build()
    {
      return new MediaDescriptionCompat(mMediaId, mTitle, mSubtitle, mDescription, mIcon, mIconUri, mExtras, mMediaUri);
    }
    
    public a setDescription(CharSequence paramCharSequence)
    {
      mDescription = paramCharSequence;
      return this;
    }
    
    public a setExtras(Bundle paramBundle)
    {
      mExtras = paramBundle;
      return this;
    }
    
    public a setIconBitmap(Bitmap paramBitmap)
    {
      mIcon = paramBitmap;
      return this;
    }
    
    public a setIconUri(Uri paramUri)
    {
      mIconUri = paramUri;
      return this;
    }
    
    public a setInfo(CharSequence paramCharSequence)
    {
      mTitle = paramCharSequence;
      return this;
    }
    
    public a setMediaId(String paramString)
    {
      mMediaId = paramString;
      return this;
    }
    
    public a setMediaUri(Uri paramUri)
    {
      mMediaUri = paramUri;
      return this;
    }
    
    public a setSubtitle(CharSequence paramCharSequence)
    {
      mSubtitle = paramCharSequence;
      return this;
    }
  }
}
