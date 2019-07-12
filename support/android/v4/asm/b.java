package support.android.v4.asm;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.AudioAttributesCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(21)
public class b
  implements h
{
  public static Method a;
  public static final String g = "AudioAttributesCompat21";
  public AudioAttributes b;
  public int c = -1;
  
  public b() {}
  
  public b(AudioAttributes paramAudioAttributes)
  {
    b = paramAudioAttributes;
    c = -1;
  }
  
  public b(AudioAttributes paramAudioAttributes, int paramInt)
  {
    b = paramAudioAttributes;
    c = paramInt;
  }
  
  public static h c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    AudioAttributes localAudioAttributes = (AudioAttributes)paramBundle.getParcelable("android.support.v4.media.audio_attrs.FRAMEWORKS");
    if (localAudioAttributes == null) {
      return null;
    }
    return new b(localAudioAttributes, paramBundle.getInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
  }
  
  public static Method close()
  {
    if (a == null) {}
    try
    {
      Method localMethod = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[] { AudioAttributes.class });
      a = localMethod;
      return a;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public int a()
  {
    int i = c;
    if (i != -1) {
      return i;
    }
    Object localObject = close();
    if (localObject == null)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("No AudioAttributes#toLegacyStreamType() on API: ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject).toString();
      return -1;
    }
    AudioAttributes localAudioAttributes = b;
    try
    {
      localObject = ((Method)localObject).invoke(null, new Object[] { localAudioAttributes });
      localObject = (Integer)localObject;
      i = ((Integer)localObject).intValue();
      return i;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("getLegacyStreamType() failed on API: ");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject).toString();
    return -1;
  }
  
  public Object b()
  {
    return b;
  }
  
  public int c()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return b.getVolumeControlStream();
    }
    return AudioAttributesCompat.a(true, getFlags(), e());
  }
  
  public int d()
  {
    return c;
  }
  
  public int e()
  {
    return b.getUsage();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    return b.equals(b);
  }
  
  public int getContentType()
  {
    return b.getContentType();
  }
  
  public int getFlags()
  {
    return b.getFlags();
  }
  
  public int hashCode()
  {
    return b.hashCode();
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("android.support.v4.media.audio_attrs.FRAMEWORKS", (Parcelable)b);
    int i = c;
    if (i != -1) {
      localBundle.putInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", i);
    }
    return localBundle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("AudioAttributesCompat: audioattributes=");
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
}
