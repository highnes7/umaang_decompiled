package k.a.a.m;

import android.content.Context;
import android.util.Base64;
import f.libs.asm.b;
import in.spicedigital.umang.application.MyApplication;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class d
{
  public Cipher a = null;
  public String b = null;
  public f c;
  public String e = null;
  public String f = null;
  public Context j;
  public byte[] k = null;
  public byte[] p = null;
  public byte[] r = null;
  public String w = null;
  public Key x = null;
  
  public d(Context paramContext)
  {
    j = paramContext;
    c = new f(paramContext);
  }
  
  private Key a()
    throws Exception
  {
    Object localObject = MyApplication.a;
    try
    {
      localObject = new SecretKeySpec(((String)localObject).getBytes(), "AES");
      x = ((Key)localObject);
    }
    catch (Exception localException1)
    {
      StringBuilder.append(localException1);
      Context localContext = j;
      try
      {
        Log.a(localContext, android.util.Log.getStackTraceString(localException1));
      }
      catch (Exception localException3)
      {
        StringBuilder.append(localException3);
      }
      try
      {
        b.d(localException1);
        java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
        localStringBuilder.append("generateKey u_k : ");
        String str = MyApplication.a;
        localStringBuilder.append(str);
        b.d(localStringBuilder.toString());
      }
      catch (Exception localException2)
      {
        StringBuilder.append(localException2);
      }
    }
    return x;
  }
  
  public String a(String paramString)
    throws Exception
  {
    e = paramString;
    try
    {
      Object localObject1 = a();
      x = ((Key)localObject1);
      localObject1 = Cipher.getInstance("AES");
      a = ((Cipher)localObject1);
      localObject1 = a;
      localObject2 = x;
      ((Cipher)localObject1).init(1, (Key)localObject2);
      int i = 0;
      while (i < 2)
      {
        localObject1 = new java.lang.StringBuilder();
        localObject2 = MyApplication.s;
        ((java.lang.StringBuilder)localObject1).append((String)localObject2);
        localObject2 = e;
        ((java.lang.StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((java.lang.StringBuilder)localObject1).toString();
        f = ((String)localObject1);
        localObject1 = a;
        localObject2 = f;
        localObject1 = ((Cipher)localObject1).doFinal(((String)localObject2).getBytes());
        k = ((byte[])localObject1);
        localObject1 = k;
        localObject1 = Base64.encodeToString((byte[])localObject1, 2);
        e = ((String)localObject1);
        i += 1;
      }
    }
    catch (Throwable paramString) {}catch (Exception localException1)
    {
      for (;;)
      {
        e = "";
        StringBuilder.append(localException1);
        Object localObject2 = j;
        try
        {
          Log.a((Context)localObject2, android.util.Log.getStackTraceString(localException1));
        }
        catch (Exception localException2)
        {
          StringBuilder.append(localException2);
        }
        try
        {
          b.d(localException1);
          java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
          localStringBuilder.append("encrypt u_s:");
          String str = MyApplication.s;
          localStringBuilder.append(str);
          localStringBuilder.append("------value to encrypt:");
          localStringBuilder.append(paramString);
          b.d(localStringBuilder.toString());
        }
        catch (Exception paramString)
        {
          StringBuilder.append(paramString);
        }
      }
    }
    a = null;
    f = null;
    k = null;
    x = null;
    return e;
    a = null;
    f = null;
    k = null;
    x = null;
    throw paramString;
  }
  
  public String init(String paramString)
    throws Exception
  {
    w = paramString;
    try
    {
      Object localObject1 = a();
      x = ((Key)localObject1);
      localObject1 = Cipher.getInstance("AES");
      a = ((Cipher)localObject1);
      localObject1 = a;
      localObject2 = x;
      ((Cipher)localObject1).init(2, (Key)localObject2);
      int i = 0;
      while (i < 2)
      {
        localObject1 = w;
        localObject1 = Base64.decode((String)localObject1, 2);
        p = ((byte[])localObject1);
        localObject1 = a;
        localObject2 = p;
        localObject1 = ((Cipher)localObject1).doFinal((byte[])localObject2);
        r = ((byte[])localObject1);
        localObject1 = r;
        localObject1 = new String((byte[])localObject1).substring(16);
        b = ((String)localObject1);
        w = b;
        i += 1;
      }
    }
    catch (Throwable paramString) {}catch (Exception localException1)
    {
      for (;;)
      {
        b = "";
        StringBuilder.append(localException1);
        Object localObject2 = j;
        try
        {
          Log.a((Context)localObject2, android.util.Log.getStackTraceString(localException1));
        }
        catch (Exception localException2)
        {
          StringBuilder.append(localException2);
        }
        try
        {
          b.d(localException1);
          java.lang.StringBuilder localStringBuilder = new java.lang.StringBuilder();
          localStringBuilder.append("value to decrypt:");
          localStringBuilder.append(paramString);
          b.d(localStringBuilder.toString());
        }
        catch (Exception paramString)
        {
          StringBuilder.append(paramString);
        }
      }
    }
    a = null;
    p = null;
    r = null;
    w = null;
    x = null;
    return b;
    a = null;
    p = null;
    r = null;
    w = null;
    x = null;
    throw paramString;
  }
}
