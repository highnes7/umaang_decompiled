package f.fasterxml.jackson.core.util;

import f.fasterxml.jackson.core.Version;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.regex.Pattern;

public class VersionUtil
{
  public static final String VERSION_FILE = "VERSION.txt";
  public static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
  public final Version _version;
  
  public VersionUtil()
  {
    try
    {
      localObject1 = versionFor(getClass());
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      for (;;) {}
    }
    localObject1 = System.err;
    localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ERROR: Failed to load Version information for bundle (via ");
    ((StringBuilder)localObject2).append(getClass().getName());
    ((StringBuilder)localObject2).append(").");
    ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
    localObject1 = null;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Version.UNKNOWN_VERSION;
    }
    _version = ((Version)localObject2);
  }
  
  /* Error */
  public static Version mavenVersionFor(ClassLoader paramClassLoader, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 52	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5: astore_3
    //   6: aload_3
    //   7: aload_1
    //   8: ldc 89
    //   10: ldc 91
    //   12: invokevirtual 97	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: ldc 91
    //   22: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: ldc 99
    //   35: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_0
    //   40: aload_3
    //   41: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokevirtual 105	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +59 -> 108
    //   52: new 107	java/util/Properties
    //   55: dup
    //   56: invokespecial 108	java/util/Properties:<init>	()V
    //   59: astore_1
    //   60: aload_1
    //   61: aload_0
    //   62: invokevirtual 112	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   65: aload_1
    //   66: ldc 114
    //   68: invokevirtual 118	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_2
    //   72: aload_1
    //   73: ldc 120
    //   75: invokevirtual 118	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore_3
    //   79: aload_2
    //   80: aload_1
    //   81: ldc 122
    //   83: invokevirtual 118	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   86: aload_3
    //   87: invokestatic 126	f/fasterxml/jackson/core/util/VersionUtil:parseVersion	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lf/fasterxml/jackson/core/Version;
    //   90: astore_1
    //   91: aload_0
    //   92: invokevirtual 131	java/io/InputStream:close	()V
    //   95: aload_1
    //   96: areturn
    //   97: astore_1
    //   98: aload_0
    //   99: invokevirtual 131	java/io/InputStream:close	()V
    //   102: aload_1
    //   103: athrow
    //   104: aload_0
    //   105: invokevirtual 131	java/io/InputStream:close	()V
    //   108: getstatic 77	f/fasterxml/jackson/core/Version:UNKNOWN_VERSION	Lf/fasterxml/jackson/core/Version;
    //   111: areturn
    //   112: astore_1
    //   113: goto -9 -> 104
    //   116: astore_0
    //   117: aload_1
    //   118: areturn
    //   119: astore_0
    //   120: goto -18 -> 102
    //   123: astore_0
    //   124: goto -16 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramClassLoader	ClassLoader
    //   0	127	1	paramString1	String
    //   0	127	2	paramString2	String
    //   5	82	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	91	97	java/lang/Throwable
    //   52	91	112	java/io/IOException
    //   91	95	116	java/io/IOException
    //   98	102	119	java/io/IOException
    //   104	108	123	java/io/IOException
  }
  
  public static Version parseVersion(String paramString)
  {
    return parseVersion(paramString, null, null);
  }
  
  public static Version parseVersion(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    if (paramString1 == null) {
      return null;
    }
    paramString1 = paramString1.trim();
    if (paramString1.length() == 0) {
      return null;
    }
    String[] arrayOfString = VERSION_SEPARATOR.split(paramString1);
    int k = parseVersionPart(arrayOfString[0]);
    int i;
    if (arrayOfString.length > 1) {
      i = parseVersionPart(arrayOfString[1]);
    } else {
      i = 0;
    }
    int j;
    if (arrayOfString.length > 2) {
      j = parseVersionPart(arrayOfString[2]);
    } else {
      j = 0;
    }
    paramString1 = localObject;
    if (arrayOfString.length > 3) {
      paramString1 = arrayOfString[3];
    }
    return new Version(k, i, j, paramString1, paramString2, paramString3);
  }
  
  public static int parseVersionPart(String paramString)
  {
    paramString = paramString.toString();
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramString.charAt(i);
      if (m > 57) {
        break;
      }
      if (m < 48) {
        return j;
      }
      j = j * 10 + (m - 48);
      i += 1;
    }
    return j;
  }
  
  public static Version versionFor(Class paramClass)
  {
    localObject2 = null;
    try
    {
      InputStream localInputStream = paramClass.getResourceAsStream("VERSION.txt");
      paramClass = localObject2;
      if (localInputStream != null) {
        try
        {
          Object localObject3 = new BufferedReader(new InputStreamReader(localInputStream, "UTF-8"));
          String str2 = ((BufferedReader)localObject3).readLine();
          Object localObject1;
          if (str2 != null)
          {
            paramClass = ((BufferedReader)localObject3).readLine();
            localObject1 = paramClass;
            if (paramClass != null)
            {
              String str1 = paramClass.trim();
              localObject3 = ((BufferedReader)localObject3).readLine();
              paramClass = (Class)localObject3;
              localObject1 = str1;
              if (localObject3 != null)
              {
                paramClass = ((String)localObject3).trim();
                localObject1 = str1;
              }
            }
            else
            {
              paramClass = null;
            }
          }
          else
          {
            paramClass = null;
            localObject1 = null;
          }
          paramClass = parseVersion(str2, (String)localObject1, paramClass);
          try
          {
            localInputStream.close();
          }
          catch (IOException localIOException1) {}
          RuntimeException localRuntimeException;
          return Version.UNKNOWN_VERSION;
        }
        catch (Throwable paramClass)
        {
          try
          {
            localRuntimeException = new RuntimeException(localIOException1);
            throw localRuntimeException;
          }
          catch (IOException localIOException2)
          {
            for (;;) {}
          }
          paramClass = paramClass;
          try
          {
            localInputStream.close();
            if (paramClass != null) {}
          }
          catch (IOException paramClass)
          {
            try
            {
              throw paramClass;
            }
            catch (IOException paramClass)
            {
              for (;;)
              {
                paramClass = localObject2;
              }
            }
            paramClass = paramClass;
            paramClass = new RuntimeException(paramClass);
            throw paramClass;
          }
        }
      }
      return paramClass;
    }
    catch (IOException paramClass)
    {
      for (;;)
      {
        paramClass = localObject2;
      }
    }
  }
  
  public Version version()
  {
    return _version;
  }
}
