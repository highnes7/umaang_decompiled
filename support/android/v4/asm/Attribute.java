package support.android.v4.asm;

import android.os.Bundle;
import android.support.v4.media.AudioAttributesCompat;
import java.util.Arrays;

public class Attribute
  implements h
{
  public int a = 0;
  public int b = 0;
  public int c = -1;
  public int type = 0;
  
  public Attribute() {}
  
  public Attribute(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    type = paramInt1;
    b = paramInt2;
    a = paramInt3;
    c = paramInt4;
  }
  
  public static h a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("android.support.v4.media.audio_attrs.USAGE", 0);
    return new Attribute(paramBundle.getInt("android.support.v4.media.audio_attrs.CONTENT_TYPE", 0), paramBundle.getInt("android.support.v4.media.audio_attrs.FLAGS", 0), i, paramBundle.getInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
  }
  
  public int a()
  {
    int i = c;
    if (i != -1) {
      return i;
    }
    return AudioAttributesCompat.a(false, b, a);
  }
  
  public Object b()
  {
    return null;
  }
  
  public int c()
  {
    return AudioAttributesCompat.a(true, b, a);
  }
  
  public int d()
  {
    return c;
  }
  
  public int e()
  {
    return a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Attribute)) {
      return false;
    }
    paramObject = (Attribute)paramObject;
    return (type == paramObject.getContentType()) && (b == paramObject.getFlags()) && (a == paramObject.e()) && (c == c);
  }
  
  public int getContentType()
  {
    return type;
  }
  
  public int getFlags()
  {
    int j = b;
    int k = a();
    int i;
    if (k == 6)
    {
      i = j | 0x4;
    }
    else
    {
      i = j;
      if (k == 7) {
        i = j | 0x1;
      }
    }
    return i & 0x111;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(type), Integer.valueOf(b), Integer.valueOf(a), Integer.valueOf(c) });
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("android.support.v4.media.audio_attrs.USAGE", a);
    localBundle.putInt("android.support.v4.media.audio_attrs.CONTENT_TYPE", type);
    localBundle.putInt("android.support.v4.media.audio_attrs.FLAGS", b);
    int i = c;
    if (i != -1) {
      localBundle.putInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", i);
    }
    return localBundle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (c != -1)
    {
      localStringBuilder.append(" stream=");
      localStringBuilder.append(c);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=");
    localStringBuilder.append(AudioAttributesCompat.evaluate(a));
    localStringBuilder.append(" content=");
    localStringBuilder.append(type);
    localStringBuilder.append(" flags=0x");
    localStringBuilder.append(Integer.toHexString(b).toUpperCase());
    return localStringBuilder.toString();
  }
}
