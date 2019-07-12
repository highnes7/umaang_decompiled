package support.android.v4.asm;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.b.a.K;
import java.util.Set;

@K(21)
public class MediaMetadataCompatApi21
{
  public MediaMetadataCompatApi21() {}
  
  public static Object createFromParcel(Parcel paramParcel)
  {
    return MediaMetadata.CREATOR.createFromParcel(paramParcel);
  }
  
  public static Bitmap getBitmap(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getBitmap(paramString);
  }
  
  public static long getLong(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getLong(paramString);
  }
  
  public static Object getRating(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getRating(paramString);
  }
  
  public static CharSequence getText(Object paramObject, String paramString)
  {
    return ((MediaMetadata)paramObject).getText(paramString);
  }
  
  public static Set keySet(Object paramObject)
  {
    return ((MediaMetadata)paramObject).keySet();
  }
  
  public static void writeToParcel(Object paramObject, Parcel paramParcel, int paramInt)
  {
    ((MediaMetadata)paramObject).writeToParcel(paramParcel, paramInt);
  }
}
