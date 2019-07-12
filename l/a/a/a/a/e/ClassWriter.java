package l.a.a.a.a.e;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import l.a.a.a.Log;
import l.a.a.a.Logger;

public class ClassWriter
  implements LayoutManager
{
  public static final String SCHEME_HTTPS = "https";
  public boolean b;
  public TShortCollection c;
  public final Log d;
  public SSLSocketFactory f;
  
  public ClassWriter()
  {
    d = localLogger;
  }
  
  public ClassWriter(Log paramLog)
  {
    d = paramLog;
  }
  
  /* Error */
  private SSLSocketFactory a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 37	l/a/a/a/a/e/ClassWriter:b	Z
    //   7: aload_0
    //   8: getfield 39	l/a/a/a/a/e/ClassWriter:c	Ll/a/a/a/a/e/TShortCollection;
    //   11: astore_1
    //   12: aload_1
    //   13: invokestatic 44	l/a/a/a/a/e/p:a	(Ll/a/a/a/a/e/TShortCollection;)Ljavax/net/ssl/SSLSocketFactory;
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 27	l/a/a/a/a/e/ClassWriter:d	Ll/a/a/a/Log;
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 46
    //   25: ldc 48
    //   27: invokeinterface 53 3 0
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 27	l/a/a/a/a/e/ClassWriter:d	Ll/a/a/a/Log;
    //   41: ldc 46
    //   43: ldc 55
    //   45: aload_1
    //   46: invokeinterface 58 4 0
    //   51: aload_0
    //   52: monitorexit
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ClassWriter
    //   11	24	1	localObject	Object
    //   36	10	1	localException	Exception
    //   55	4	1	localThrowable	Throwable
    //   21	2	2	localLog	Log
    // Exception table:
    //   from	to	target	type
    //   12	17	36	java/lang/Exception
    //   22	32	36	java/lang/Exception
    //   2	12	55	java/lang/Throwable
    //   12	17	55	java/lang/Throwable
    //   22	32	55	java/lang/Throwable
    //   37	51	55	java/lang/Throwable
  }
  
  private void b()
  {
    try
    {
      b = false;
      f = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private SSLSocketFactory c()
  {
    try
    {
      if ((f == null) && (!b)) {
        f = a();
      }
      SSLSocketFactory localSSLSocketFactory = f;
      return localSSLSocketFactory;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private boolean get(String paramString)
  {
    return (paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("https"));
  }
  
  public Item a(MathArrays.OrderDirection paramOrderDirection, String paramString)
  {
    return a(paramOrderDirection, paramString, Collections.emptyMap());
  }
  
  public Item a(MathArrays.OrderDirection paramOrderDirection, String paramString, Map paramMap)
  {
    int i = paramOrderDirection.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            paramOrderDirection = Item.toString(paramString);
          } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
          }
        }
        else {
          paramOrderDirection = Item.b(paramString);
        }
      }
      else {
        paramOrderDirection = Item.toString(paramString, paramMap, true);
      }
    }
    else {
      paramOrderDirection = Item.read(paramString, paramMap, true);
    }
    if ((get(paramString)) && (c != null))
    {
      paramString = c();
      if (paramString != null) {
        ((HttpsURLConnection)paramOrderDirection.getConnection()).setSSLSocketFactory(paramString);
      }
    }
    return paramOrderDirection;
  }
  
  public void a(TShortCollection paramTShortCollection)
  {
    if (c != paramTShortCollection)
    {
      c = paramTShortCollection;
      b();
    }
  }
  
  public TShortCollection get()
  {
    return c;
  }
}
