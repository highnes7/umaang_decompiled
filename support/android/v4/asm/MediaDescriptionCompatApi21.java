package support.android.v4.asm;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.b.a.K;

@K(21)
public class MediaDescriptionCompatApi21
{
  public MediaDescriptionCompatApi21() {}
  
  public static Object fromParcel(Parcel paramParcel)
  {
    return MediaDescription.CREATOR.createFromParcel(paramParcel);
  }
  
  public static CharSequence getDescription(Object paramObject)
  {
    return ((MediaDescription)paramObject).getDescription();
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((MediaDescription)paramObject).getExtras();
  }
  
  public static Bitmap getIconBitmap(Object paramObject)
  {
    return ((MediaDescription)paramObject).getIconBitmap();
  }
  
  public static Uri getIconUri(Object paramObject)
  {
    return ((MediaDescription)paramObject).getIconUri();
  }
  
  public static String getMediaId(Object paramObject)
  {
    return ((MediaDescription)paramObject).getMediaId();
  }
  
  public static CharSequence getSubtitle(Object paramObject)
  {
    return ((MediaDescription)paramObject).getSubtitle();
  }
  
  public static CharSequence getTitle(Object paramObject)
  {
    return ((MediaDescription)paramObject).getTitle();
  }
  
  public static void writeToParcel(Object paramObject, Parcel paramParcel, int paramInt)
  {
    ((MediaDescription)paramObject).writeToParcel(paramParcel, paramInt);
  }
}
