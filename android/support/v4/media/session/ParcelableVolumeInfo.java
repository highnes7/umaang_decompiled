package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import support.android.v4.asm.session.PaymentIntent.Output.1;

public class ParcelableVolumeInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new PaymentIntent.Output.1();
  public int audioStream;
  public int controlType;
  public int currentVolume;
  public int maxVolume;
  public int volumeType;
  
  public ParcelableVolumeInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    volumeType = paramInt1;
    controlType = paramInt2;
    maxVolume = paramInt3;
    currentVolume = paramInt4;
    audioStream = paramInt5;
  }
  
  public ParcelableVolumeInfo(Parcel paramParcel)
  {
    volumeType = paramParcel.readInt();
    maxVolume = paramParcel.readInt();
    currentVolume = paramParcel.readInt();
    audioStream = paramParcel.readInt();
    controlType = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(volumeType);
    paramParcel.writeInt(maxVolume);
    paramParcel.writeInt(currentVolume);
    paramParcel.writeInt(audioStream);
    paramParcel.writeInt(controlType);
  }
}
