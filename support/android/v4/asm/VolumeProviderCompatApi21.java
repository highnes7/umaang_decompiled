package support.android.v4.asm;

import android.media.VolumeProvider;
import b.b.a.K;

@K(21)
public class VolumeProviderCompatApi21
{
  public VolumeProviderCompatApi21() {}
  
  public static Object createVolumeProvider(int paramInt1, int paramInt2, int paramInt3, na.a paramA)
  {
    return new VolumeProviderCompatApi21.1(paramInt1, paramInt2, paramInt3, paramA);
  }
  
  public static void setCurrentVolume(Object paramObject, int paramInt)
  {
    ((VolumeProvider)paramObject).setCurrentVolume(paramInt);
  }
}
