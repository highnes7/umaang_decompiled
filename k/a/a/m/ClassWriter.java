package k.a.a.m;

import android.content.Context;
import android.util.Base64;
import f.libs.asm.b;
import in.spicedigital.umang.application.MyApplication;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ClassWriter
{
  public byte[] a = null;
  public String b = null;
  public byte[] c = null;
  public String e = null;
  public f f;
  public byte[] h = null;
  public Context i;
  public Cipher p = null;
  public String q = null;
  public Key r = null;
  public String s = null;
  
  public ClassWriter(Context paramContext)
  {
    i = paramContext;
    f = new f(paramContext);
  }
  
  private Key a(String paramString)
    throws Exception
  {
    paramString = paramString.substring(0, 16);
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes(), "AES");
      r = paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
      Context localContext = i;
      try
      {
        Log.a(localContext, android.util.Log.getStackTraceString(paramString));
      }
      catch (Exception localException)
      {
        StringBuilder.append(localException);
      }
      try
      {
        b.d(paramString);
      }
      catch (Exception paramString)
      {
        StringBuilder.append(paramString);
      }
    }
    return r;
  }
  
  public String a(String paramString1, String paramString2)
    throws Exception
  {
    b = paramString1;
    try
    {
      paramString1 = a(paramString2);
      r = paramString1;
      paramString1 = Cipher.getInstance("AES");
      p = paramString1;
      paramString1 = p;
      paramString2 = r;
      paramString1.init(2, paramString2);
      int j = 0;
      while (j < 2)
      {
        paramString1 = b;
        paramString1 = Base64.decode(paramString1, 2);
        a = paramString1;
        paramString1 = p;
        paramString2 = a;
        paramString1 = paramString1.doFinal(paramString2);
        c = paramString1;
        paramString1 = c;
        paramString1 = new String(paramString1);
        paramString2 = MyApplication.s;
        paramString1 = paramString1.substring(paramString2.length());
        e = paramString1;
        b = e;
        j += 1;
      }
      p = null;
    }
    catch (Throwable paramString1) {}catch (Exception paramString1)
    {
      e = "";
      StringBuilder.append(paramString1);
      paramString2 = i;
      try
      {
        Log.a(paramString2, android.util.Log.getStackTraceString(paramString1));
      }
      catch (Exception paramString2)
      {
        StringBuilder.append(paramString2);
      }
      try
      {
        b.d(paramString1);
      }
      catch (Exception paramString1)
      {
        StringBuilder.append(paramString1);
      }
      p = null;
      a = null;
      c = null;
      b = null;
      r = null;
      return e;
    }
    a = null;
    c = null;
    b = null;
    r = null;
    throw paramString1;
  }
  
  public String init(String paramString1, String paramString2)
    throws Exception
  {
    q = paramString1;
    try
    {
      paramString1 = a(paramString2);
      r = paramString1;
      paramString1 = Cipher.getInstance("AES");
      p = paramString1;
      paramString1 = p;
      paramString2 = r;
      paramString1.init(1, paramString2);
      int j = 0;
      while (j < 2)
      {
        paramString1 = new java.lang.StringBuilder();
        paramString2 = MyApplication.s;
        paramString1.append(paramString2);
        paramString2 = q;
        paramString1.append(paramString2);
        paramString1 = paramString1.toString();
        s = paramString1;
        paramString1 = p;
        paramString2 = s;
        paramString1 = paramString1.doFinal(paramString2.getBytes());
        h = paramString1;
        paramString1 = h;
        paramString1 = Base64.encodeToString(paramString1, 2);
        q = paramString1;
        j += 1;
      }
      p = null;
    }
    catch (Throwable paramString1) {}catch (Exception paramString1)
    {
      q = "";
      StringBuilder.append(paramString1);
      paramString2 = i;
      try
      {
        Log.a(paramString2, android.util.Log.getStackTraceString(paramString1));
      }
      catch (Exception paramString2)
      {
        StringBuilder.append(paramString2);
      }
      try
      {
        b.d(paramString1);
      }
      catch (Exception paramString1)
      {
        StringBuilder.append(paramString1);
      }
      p = null;
      s = null;
      h = null;
      r = null;
      return q;
    }
    s = null;
    h = null;
    r = null;
    throw paramString1;
  }
}
