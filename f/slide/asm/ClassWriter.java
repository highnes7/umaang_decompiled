package f.slide.asm;

import com.coremedia.iso.boxes.Box;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassWriter
  extends SPVBlockStore
{
  public static String[] s = new String[0];
  public Properties mProperties;
  public StringBuilder mText = new StringBuilder();
  public String name;
  public Pattern p = Pattern.compile("(.*)\\((.*?)\\)");
  public String[] path;
  
  public ClassWriter(Properties paramProperties)
  {
    mProperties = paramProperties;
  }
  
  /* Error */
  public ClassWriter(String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	f/slide/asm/SPVBlockStore:<init>	()V
    //   4: aload_0
    //   5: ldc 28
    //   7: invokestatic 34	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   10: putfield 36	f/slide/asm/ClassWriter:p	Ljava/util/regex/Pattern;
    //   13: aload_0
    //   14: new 38	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   21: putfield 41	f/slide/asm/ClassWriter:mText	Ljava/lang/StringBuilder;
    //   24: ldc 50
    //   26: ldc 52
    //   28: invokevirtual 58	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore 7
    //   33: aload_0
    //   34: new 60	java/util/Properties
    //   37: dup
    //   38: invokespecial 61	java/util/Properties:<init>	()V
    //   41: putfield 43	f/slide/asm/ClassWriter:mProperties	Ljava/util/Properties;
    //   44: aload_0
    //   45: getfield 43	f/slide/asm/ClassWriter:mProperties	Ljava/util/Properties;
    //   48: astore 5
    //   50: aload 5
    //   52: aload 7
    //   54: invokevirtual 65	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   57: invokestatic 71	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   60: invokevirtual 75	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   63: astore 6
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ifnonnull +8 -> 79
    //   74: invokestatic 80	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   77: astore 5
    //   79: aload 5
    //   81: ldc 82
    //   83: invokevirtual 86	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   86: astore 5
    //   88: aload 5
    //   90: invokeinterface 92 1 0
    //   95: istore 4
    //   97: iload 4
    //   99: ifne +57 -> 156
    //   102: aload_1
    //   103: arraylength
    //   104: istore_3
    //   105: iconst_0
    //   106: istore_2
    //   107: iload_2
    //   108: iload_3
    //   109: if_icmplt +15 -> 124
    //   112: aload 7
    //   114: invokevirtual 97	java/io/InputStream:close	()V
    //   117: return
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   123: return
    //   124: aload_1
    //   125: iload_2
    //   126: aaload
    //   127: astore 5
    //   129: aload_0
    //   130: getfield 43	f/slide/asm/ClassWriter:mProperties	Ljava/util/Properties;
    //   133: astore 6
    //   135: aload 6
    //   137: aload_0
    //   138: invokevirtual 106	java/lang/Object:getClass	()Ljava/lang/Class;
    //   141: aload 5
    //   143: invokevirtual 58	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   146: invokevirtual 65	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   149: iload_2
    //   150: iconst_1
    //   151: iadd
    //   152: istore_2
    //   153: goto -46 -> 107
    //   156: aload 5
    //   158: invokeinterface 110 1 0
    //   163: astore 6
    //   165: aload 6
    //   167: checkcast 112	java/net/URL
    //   170: astore 6
    //   172: aload 6
    //   174: invokevirtual 116	java/net/URL:openStream	()Ljava/io/InputStream;
    //   177: astore 6
    //   179: aload_0
    //   180: getfield 43	f/slide/asm/ClassWriter:mProperties	Ljava/util/Properties;
    //   183: aload 6
    //   185: invokevirtual 65	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   188: aload 6
    //   190: invokevirtual 97	java/io/InputStream:close	()V
    //   193: goto -105 -> 88
    //   196: astore_1
    //   197: aload 6
    //   199: invokevirtual 97	java/io/InputStream:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: new 118	java/lang/RuntimeException
    //   208: dup
    //   209: aload_1
    //   210: invokespecial 121	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   213: athrow
    //   214: astore_1
    //   215: aload 7
    //   217: invokevirtual 97	java/io/InputStream:close	()V
    //   220: goto +10 -> 230
    //   223: astore 5
    //   225: aload 5
    //   227: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   230: goto +3 -> 233
    //   233: aload_1
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	ClassWriter
    //   0	235	1	paramVarArgs	String[]
    //   106	47	2	i	int
    //   104	6	3	j	int
    //   95	3	4	bool	boolean
    //   48	109	5	localObject1	Object
    //   223	3	5	localIOException	java.io.IOException
    //   63	135	6	localObject2	Object
    //   31	185	7	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   112	117	118	java/io/IOException
    //   179	188	196	java/lang/Throwable
    //   50	65	204	java/io/IOException
    //   74	79	204	java/io/IOException
    //   79	88	204	java/io/IOException
    //   88	97	204	java/io/IOException
    //   135	149	204	java/io/IOException
    //   156	165	204	java/io/IOException
    //   172	179	204	java/io/IOException
    //   188	193	204	java/io/IOException
    //   197	204	204	java/io/IOException
    //   33	44	214	java/lang/Throwable
    //   50	65	214	java/lang/Throwable
    //   74	79	214	java/lang/Throwable
    //   79	88	214	java/lang/Throwable
    //   88	97	214	java/lang/Throwable
    //   102	105	214	java/lang/Throwable
    //   135	149	214	java/lang/Throwable
    //   156	165	214	java/lang/Throwable
    //   172	179	214	java/lang/Throwable
    //   188	193	214	java/lang/Throwable
    //   197	204	214	java/lang/Throwable
    //   205	214	214	java/lang/Throwable
    //   215	220	223	java/io/IOException
  }
  
  public Box get(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    init(paramString1, paramArrayOfByte, paramString2);
    Object localObject = name;
    try
    {
      localObject = Class.forName((String)localObject);
      if (path.length > 0)
      {
        Class[] arrayOfClass = new Class[path.length];
        Object[] arrayOfObject = new Object[path.length];
        int i = 0;
        for (;;)
        {
          if (i >= path.length)
          {
            paramString1 = ((Class)localObject).getConstructor(arrayOfClass).newInstance(arrayOfObject);
            return (Box)paramString1;
          }
          String str = path[i];
          boolean bool = "userType".equals(str);
          if (bool)
          {
            arrayOfObject[i] = paramArrayOfByte;
            arrayOfClass[i] = [B.class;
          }
          else
          {
            str = path[i];
            bool = "type".equals(str);
            if (bool)
            {
              arrayOfObject[i] = paramString1;
              arrayOfClass[i] = String.class;
            }
            else
            {
              str = path[i];
              bool = "parent".equals(str);
              if (!bool) {
                break;
              }
              arrayOfObject[i] = paramString2;
              arrayOfClass[i] = String.class;
            }
          }
          i += 1;
        }
        paramString1 = new StringBuilder("No such param: ");
        paramArrayOfByte = path[i];
        paramString1.append(paramArrayOfByte);
        paramString1 = new InternalError(paramString1.toString());
        throw paramString1;
      }
      paramString1 = ((Class)localObject).newInstance();
      return (Box)paramString1;
    }
    catch (NoSuchMethodException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (InvocationTargetException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (IllegalAccessException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (InstantiationException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1 = new RuntimeException(paramString1);
      throw paramString1;
    }
  }
  
  public void init(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject1;
    if (paramArrayOfByte != null)
    {
      if ("uuid".equals(paramString1))
      {
        localObject1 = mProperties;
        Object localObject2 = new StringBuilder("uuid[");
        ((StringBuilder)localObject2).append(Frame.a(paramArrayOfByte).toUpperCase());
        ((StringBuilder)localObject2).append("]");
        localObject2 = ((Properties)localObject1).getProperty(((StringBuilder)localObject2).toString());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = mProperties;
          paramString2 = new StringBuilder(String.valueOf(paramString2));
          paramString2.append("-uuid[");
          paramString2.append(Frame.a(paramArrayOfByte).toUpperCase());
          paramString2.append("]");
          localObject1 = ((Properties)localObject1).getProperty(paramString2.toString());
        }
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null) {
          paramArrayOfByte = mProperties.getProperty("uuid");
        }
      }
      else
      {
        throw new RuntimeException("we have a userType but no uuid box type. Something's wrong");
      }
    }
    else
    {
      localObject1 = mProperties.getProperty(paramString1);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null)
      {
        paramArrayOfByte = mText;
        paramArrayOfByte.append(paramString2);
        paramArrayOfByte.append('-');
        paramArrayOfByte.append(paramString1);
        paramArrayOfByte = paramArrayOfByte.toString();
        mText.setLength(0);
        paramArrayOfByte = mProperties.getProperty(paramArrayOfByte);
      }
    }
    paramString2 = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString2 = mProperties.getProperty("default");
    }
    if (paramString2 != null)
    {
      if (!paramString2.endsWith(")"))
      {
        path = s;
        name = paramString2;
        return;
      }
      paramString1 = p.matcher(paramString2);
      if (paramString1.matches())
      {
        name = paramString1.group(1);
        if (paramString1.group(2).length() == 0)
        {
          path = s;
          return;
        }
        if (paramString1.group(2).length() > 0) {
          paramString1 = paramString1.group(2).split(",");
        } else {
          paramString1 = new String[0];
        }
        path = paramString1;
        return;
      }
      paramString1 = new StringBuilder("Cannot work with that constructor: ");
      paramString1.append(paramString2);
      throw new RuntimeException(paramString1.toString());
    }
    paramArrayOfByte = new StringBuilder("No box object found for ");
    paramArrayOfByte.append(paramString1);
    throw new RuntimeException(paramArrayOfByte.toString());
  }
}
