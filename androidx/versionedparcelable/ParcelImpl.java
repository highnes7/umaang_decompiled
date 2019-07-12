package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import b.b.a.N;
import de.asm.ByteVector;
import de.asm.VerticalProgressBar.SavedState.1;
import de.asm.f;
import de.asm.h;

@N({b.b.a.N.a.a})
public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new VerticalProgressBar.SavedState.1();
  public final h b;
  
  public ParcelImpl(Parcel paramParcel)
  {
    b = new f(paramParcel).d();
  }
  
  public ParcelImpl(h paramH)
  {
    b = paramH;
  }
  
  public h c()
  {
    return b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new f(paramParcel).b(b);
  }
}
