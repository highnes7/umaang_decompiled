package support.android.v4.content.res;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;

public class ByteVector
{
  public final h a = new h();
  
  public ByteVector(Context paramContext, String paramString)
  {
    h localH = a;
    c = paramContext;
    b = paramString;
  }
  
  public ByteVector a(Intent paramIntent)
  {
    return b(new Intent[] { paramIntent });
  }
  
  public ByteVector a(CharSequence paramCharSequence)
  {
    a.o = paramCharSequence;
    return this;
  }
  
  public h a()
  {
    if (!TextUtils.isEmpty(a.a))
    {
      h localH = a;
      Intent[] arrayOfIntent = f;
      if ((arrayOfIntent != null) && (arrayOfIntent.length != 0)) {
        return localH;
      }
      throw new IllegalArgumentException("Shortcut must have an intent");
    }
    throw new IllegalArgumentException("Shortcut must have a non-empty label");
  }
  
  public ByteVector b()
  {
    a.e = true;
    return this;
  }
  
  public ByteVector b(ComponentName paramComponentName)
  {
    a.g = paramComponentName;
    return this;
  }
  
  public ByteVector b(IconCompat paramIconCompat)
  {
    a.j = paramIconCompat;
    return this;
  }
  
  public ByteVector b(CharSequence paramCharSequence)
  {
    a.d = paramCharSequence;
    return this;
  }
  
  public ByteVector b(Intent[] paramArrayOfIntent)
  {
    a.f = paramArrayOfIntent;
    return this;
  }
  
  public ByteVector write(CharSequence paramCharSequence)
  {
    a.a = paramCharSequence;
    return this;
  }
}
