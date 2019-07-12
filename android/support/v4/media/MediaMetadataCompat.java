package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import b.b.a.N;
import b.b.x.n.b;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import support.android.v4.asm.MediaMetadataCompatApi21;
import support.android.v4.asm.Point.1;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public final class MediaMetadataCompat
  implements Parcelable
{
  public static final String ACTION_SHOW_PLAYER = "android.media.metadata.DOWNLOAD_STATUS";
  public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Point.1();
  public static final String EVENTLOG_URL = "android.media.metadata.BT_FOLDER_TYPE";
  public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
  public static final String METADATA_KEY_ART = "android.media.metadata.ART";
  public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
  public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
  public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
  public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
  public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
  public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
  public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
  public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
  public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  public static final int METADATA_TYPE_BITMAP = 2;
  public static final int METADATA_TYPE_LONG = 0;
  public static final int METADATA_TYPE_RATING = 3;
  public static final int METADATA_TYPE_TEXT = 1;
  public static final String MODULE_PACKAGE = "android.media.metadata.MEDIA_URI";
  public static final String PAGE_KEY = "android.media.metadata.ADVERTISEMENT";
  public static final String[] PREFERRED_BITMAP_ORDER;
  public static final String[] PREFERRED_DESCRIPTION_ORDER;
  public static final String[] PREFERRED_URI_ORDER;
  public static final String TAG = "MediaMetadata";
  public static final b<String, Integer> this$0 = new ArrayMap();
  public final Bundle mBundle;
  public MediaDescriptionCompat mDescription;
  public Object mMetadataObj;
  
  static
  {
    Object localObject1 = this$0;
    Integer localInteger1 = Integer.valueOf(1);
    ((SimpleArrayMap)localObject1).put("android.media.metadata.TITLE", localInteger1);
    this$0.put("android.media.metadata.ARTIST", localInteger1);
    Object localObject2 = this$0;
    localObject1 = Integer.valueOf(0);
    ((SimpleArrayMap)localObject2).put("android.media.metadata.DURATION", localObject1);
    this$0.put("android.media.metadata.ALBUM", localInteger1);
    this$0.put("android.media.metadata.AUTHOR", localInteger1);
    this$0.put("android.media.metadata.WRITER", localInteger1);
    this$0.put("android.media.metadata.COMPOSER", localInteger1);
    this$0.put("android.media.metadata.COMPILATION", localInteger1);
    this$0.put("android.media.metadata.DATE", localInteger1);
    this$0.put("android.media.metadata.YEAR", localObject1);
    this$0.put("android.media.metadata.GENRE", localInteger1);
    this$0.put("android.media.metadata.TRACK_NUMBER", localObject1);
    this$0.put("android.media.metadata.NUM_TRACKS", localObject1);
    this$0.put("android.media.metadata.DISC_NUMBER", localObject1);
    this$0.put("android.media.metadata.ALBUM_ARTIST", localInteger1);
    ArrayMap localArrayMap = this$0;
    localObject2 = Integer.valueOf(2);
    localArrayMap.put("android.media.metadata.ART", localObject2);
    this$0.put("android.media.metadata.ART_URI", localInteger1);
    this$0.put("android.media.metadata.ALBUM_ART", localObject2);
    this$0.put("android.media.metadata.ALBUM_ART_URI", localInteger1);
    localArrayMap = this$0;
    Integer localInteger2 = Integer.valueOf(3);
    localArrayMap.put("android.media.metadata.USER_RATING", localInteger2);
    this$0.put("android.media.metadata.RATING", localInteger2);
    this$0.put("android.media.metadata.DISPLAY_TITLE", localInteger1);
    this$0.put("android.media.metadata.DISPLAY_SUBTITLE", localInteger1);
    this$0.put("android.media.metadata.DISPLAY_DESCRIPTION", localInteger1);
    this$0.put("android.media.metadata.DISPLAY_ICON", localObject2);
    this$0.put("android.media.metadata.DISPLAY_ICON_URI", localInteger1);
    this$0.put("android.media.metadata.MEDIA_ID", localInteger1);
    this$0.put("android.media.metadata.BT_FOLDER_TYPE", localObject1);
    this$0.put("android.media.metadata.MEDIA_URI", localInteger1);
    this$0.put("android.media.metadata.ADVERTISEMENT", localObject1);
    this$0.put("android.media.metadata.DOWNLOAD_STATUS", localObject1);
    PREFERRED_DESCRIPTION_ORDER = new String[] { "android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER" };
    PREFERRED_BITMAP_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART" };
    PREFERRED_URI_ORDER = new String[] { "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI" };
  }
  
  public MediaMetadataCompat(Bundle paramBundle)
  {
    mBundle = new Bundle(paramBundle);
    MediaSessionCompat.append(mBundle);
  }
  
  public MediaMetadataCompat(Parcel paramParcel)
  {
    mBundle = paramParcel.readBundle(MediaSessionCompat.class.getClassLoader());
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      ((MediaMetadata)paramObject).writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      MediaMetadataCompat localMediaMetadataCompat = (MediaMetadataCompat)CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      mMetadataObj = paramObject;
      return localMediaMetadataCompat;
    }
    return null;
  }
  
  public boolean containsKey(String paramString)
  {
    return mBundle.containsKey(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    Bundle localBundle = mBundle;
    try
    {
      paramString = localBundle.getParcelable(paramString);
      return (Bitmap)paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public Bundle getBundle()
  {
    return new Bundle(mBundle);
  }
  
  public MediaDescriptionCompat getDescription()
  {
    Object localObject1 = mDescription;
    if (localObject1 != null) {
      return localObject1;
    }
    String str = getString("android.media.metadata.MEDIA_ID");
    Object localObject5 = new CharSequence[3];
    localObject1 = getText("android.media.metadata.DISPLAY_TITLE");
    int j;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject5[0] = localObject1;
      localObject5[1] = getText("android.media.metadata.DISPLAY_SUBTITLE");
      localObject5[2] = getText("android.media.metadata.DISPLAY_DESCRIPTION");
    }
    else
    {
      j = 0;
      i = 0;
      while (j < localObject5.length)
      {
        localObject1 = PREFERRED_DESCRIPTION_ORDER;
        if (i >= localObject1.length) {
          break;
        }
        localObject1 = getText(localObject1[i]);
        int k = j;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject5[j] = localObject1;
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
    int i = 0;
    Object localObject4;
    for (;;)
    {
      localObject1 = PREFERRED_BITMAP_ORDER;
      j = localObject1.length;
      localObject4 = null;
      if (i >= j) {
        break;
      }
      localObject1 = getBitmap(localObject1[i]);
      if (localObject1 != null) {
        break label182;
      }
      i += 1;
    }
    localObject1 = null;
    label182:
    i = 0;
    for (;;)
    {
      localObject2 = PREFERRED_URI_ORDER;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = getString(localObject2[i]);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = Uri.parse((String)localObject2);
        break label234;
      }
      i += 1;
    }
    Object localObject2 = null;
    label234:
    Object localObject3 = getString("android.media.metadata.MEDIA_URI");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject3 = Uri.parse((String)localObject3);
    } else {
      localObject3 = null;
    }
    CharSequence localCharSequence1 = localObject5[0];
    CharSequence localCharSequence2 = localObject5[1];
    CharSequence localCharSequence3 = localObject5[2];
    localObject5 = new Bundle();
    if (mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
      ((Bundle)localObject5).putLong("android.media.extra.BT_FOLDER_TYPE", getLong("android.media.metadata.BT_FOLDER_TYPE"));
    }
    if (mBundle.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
      ((Bundle)localObject5).putLong("android.media.extra.DOWNLOAD_STATUS", getLong("android.media.metadata.DOWNLOAD_STATUS"));
    }
    if (!((Bundle)localObject5).isEmpty()) {
      localObject4 = localObject5;
    }
    mDescription = new MediaDescriptionCompat(str, localCharSequence1, localCharSequence2, localCharSequence3, (Bitmap)localObject1, (Uri)localObject2, localObject4, (Uri)localObject3);
    return mDescription;
  }
  
  public long getLong(String paramString)
  {
    return mBundle.getLong(paramString, 0L);
  }
  
  public Object getMediaMetadata()
  {
    if ((mMetadataObj == null) && (Build.VERSION.SDK_INT >= 21))
    {
      Parcel localParcel = Parcel.obtain();
      writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      mMetadataObj = MediaMetadataCompatApi21.createFromParcel(localParcel);
      localParcel.recycle();
    }
    return mMetadataObj;
  }
  
  public RatingCompat getRating(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    Bundle localBundle = mBundle;
    try
    {
      paramString = RatingCompat.fromRating(localBundle.getParcelable(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    paramString = mBundle.getCharSequence(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return null;
  }
  
  public CharSequence getText(String paramString)
  {
    return mBundle.getCharSequence(paramString);
  }
  
  public Set keySet()
  {
    return mBundle.keySet();
  }
  
  public int size()
  {
    return mBundle.size();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(mBundle);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface a {}
  
  public static final class b
  {
    public final Bundle mData;
    
    public b()
    {
      mData = new Bundle();
    }
    
    public b(MediaMetadataCompat paramMediaMetadataCompat)
    {
      mData = new Bundle(mBundle);
      MediaSessionCompat.append(mData);
    }
    
    public b(MediaMetadataCompat paramMediaMetadataCompat, int paramInt)
    {
      this(paramMediaMetadataCompat);
      paramMediaMetadataCompat = mData.keySet().iterator();
      while (paramMediaMetadataCompat.hasNext())
      {
        String str = (String)paramMediaMetadataCompat.next();
        Object localObject = mData.get(str);
        if ((localObject instanceof Bitmap))
        {
          localObject = (Bitmap)localObject;
          if ((((Bitmap)localObject).getHeight() > paramInt) || (((Bitmap)localObject).getWidth() > paramInt)) {
            put(str, getBitmap((Bitmap)localObject, paramInt));
          }
        }
      }
    }
    
    private Bitmap getBitmap(Bitmap paramBitmap, int paramInt)
    {
      float f = paramInt;
      f = Math.min(f / paramBitmap.getWidth(), f / paramBitmap.getHeight());
      paramInt = (int)(paramBitmap.getHeight() * f);
      return Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f), paramInt, true);
    }
    
    public MediaMetadataCompat cloneMetadataIfNeeded()
    {
      return new MediaMetadataCompat(mData);
    }
    
    public b put(String paramString, Bitmap paramBitmap)
    {
      if ((MediaMetadataCompat.this$0.containsKey(paramString)) && (((Integer)MediaMetadataCompat.this$0.get(paramString)).intValue() != 2)) {
        throw new IllegalArgumentException(StringBuilder.append("The ", paramString, " key cannot be used to put a Bitmap"));
      }
      mData.putParcelable(paramString, paramBitmap);
      return this;
    }
    
    public b putLong(String paramString, long paramLong)
    {
      if ((MediaMetadataCompat.this$0.containsKey(paramString)) && (((Integer)MediaMetadataCompat.this$0.get(paramString)).intValue() != 0)) {
        throw new IllegalArgumentException(StringBuilder.append("The ", paramString, " key cannot be used to put a long"));
      }
      mData.putLong(paramString, paramLong);
      return this;
    }
    
    public b putRating(String paramString, RatingCompat paramRatingCompat)
    {
      if ((MediaMetadataCompat.this$0.containsKey(paramString)) && (((Integer)MediaMetadataCompat.this$0.get(paramString)).intValue() != 3)) {
        throw new IllegalArgumentException(StringBuilder.append("The ", paramString, " key cannot be used to put a Rating"));
      }
      int i = Build.VERSION.SDK_INT;
      mData.putParcelable(paramString, (Parcelable)paramRatingCompat.getRating());
      return this;
    }
    
    public b putString(String paramString, CharSequence paramCharSequence)
    {
      if ((MediaMetadataCompat.this$0.containsKey(paramString)) && (((Integer)MediaMetadataCompat.this$0.get(paramString)).intValue() != 1)) {
        throw new IllegalArgumentException(StringBuilder.append("The ", paramString, " key cannot be used to put a CharSequence"));
      }
      mData.putCharSequence(paramString, paramCharSequence);
      return this;
    }
    
    public b putString(String paramString1, String paramString2)
    {
      if ((MediaMetadataCompat.this$0.containsKey(paramString1)) && (((Integer)MediaMetadataCompat.this$0.get(paramString1)).intValue() != 1)) {
        throw new IllegalArgumentException(StringBuilder.append("The ", paramString1, " key cannot be used to put a String"));
      }
      mData.putCharSequence(paramString1, paramString2);
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
}
