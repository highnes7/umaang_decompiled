package f.g.org.org.org.objectweb.deser;

import f.g.b.a.g.h;
import f.g.b.a.g.w;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.util.ClassInfo;
import f.g.org.org.util.FieldInfo;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.ObjectParser;
import f.g.org.org.util.Types;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;

@h
public final class JsonParser
  implements ObjectParser
{
  public static final JsonParser INSTANCE = new JsonParser();
  
  public JsonParser() {}
  
  public String getContentType()
  {
    return "text/plain";
  }
  
  public Object parse(HttpResponse paramHttpResponse, Class paramClass)
    throws IOException
  {
    paramHttpResponse.setContentLoggingLimit(0);
    paramHttpResponse = paramHttpResponse.getContent();
    try
    {
      paramClass = parseAndClose(paramHttpResponse, paramClass);
      paramHttpResponse.close();
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramHttpResponse.close();
      throw paramClass;
    }
  }
  
  public Object parseAndClose(InputStream paramInputStream, Class paramClass)
    throws IOException
  {
    ClassInfo localClassInfo = ClassInfo.of(paramClass);
    Object localObject1 = Types.newInstance(paramClass);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    for (;;)
    {
      paramInputStream = localBufferedReader.readLine();
      if (paramInputStream == null) {
        return localObject1;
      }
      int i = paramInputStream.indexOf('=');
      Object localObject2 = paramInputStream.substring(0, i);
      String str = paramInputStream.substring(i + 1);
      paramInputStream = str;
      Field localField = localClassInfo.getField((String)localObject2);
      if (localField != null)
      {
        localObject2 = localField.getType();
        if ((localObject2 == Boolean.TYPE) || (localObject2 == Boolean.class)) {
          paramInputStream = Boolean.valueOf(str);
        }
        FieldInfo.setFieldValue(localField, localObject1, paramInputStream);
      }
      else if (w.class.isAssignableFrom(paramClass))
      {
        ((GenericData)localObject1).clone((String)localObject2, str);
      }
      else if (Map.class.isAssignableFrom(paramClass))
      {
        ((Map)localObject1).put(localObject2, str);
      }
    }
  }
  
  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Class paramClass)
    throws IOException
  {
    return parseAndClose(new InputStreamReader(paramInputStream, paramCharset), paramClass);
  }
  
  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Type paramType)
  {
    throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
  }
  
  /* Error */
  public Object parseAndClose(Reader paramReader, Class paramClass)
    throws IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 54	f/g/org/org/util/ClassInfo:of	(Ljava/lang/Class;)Lf/g/org/org/util/ClassInfo;
    //   4: astore 7
    //   6: aload_2
    //   7: invokestatic 60	f/g/org/org/util/Types:newInstance	(Ljava/lang/Class;)Ljava/lang/Object;
    //   10: astore 8
    //   12: new 62	java/io/BufferedReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 70	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 9
    //   22: aload 9
    //   24: invokevirtual 73	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 5
    //   29: aload 5
    //   31: ifnonnull +10 -> 41
    //   34: aload_1
    //   35: invokevirtual 150	java/io/Reader:close	()V
    //   38: aload 8
    //   40: areturn
    //   41: aload 5
    //   43: bipush 61
    //   45: invokevirtual 79	java/lang/String:indexOf	(I)I
    //   48: istore_3
    //   49: aload 5
    //   51: iconst_0
    //   52: iload_3
    //   53: invokevirtual 83	java/lang/String:substring	(II)Ljava/lang/String;
    //   56: astore 11
    //   58: aload 5
    //   60: iload_3
    //   61: iconst_1
    //   62: iadd
    //   63: invokevirtual 86	java/lang/String:substring	(I)Ljava/lang/String;
    //   66: astore 6
    //   68: aload 6
    //   70: astore 5
    //   72: aload 7
    //   74: aload 11
    //   76: invokevirtual 90	f/g/org/org/util/ClassInfo:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   79: astore 10
    //   81: aload 10
    //   83: ifnull +48 -> 131
    //   86: aload 10
    //   88: invokevirtual 96	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   91: astore 11
    //   93: getstatic 102	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   96: astore 12
    //   98: aload 11
    //   100: aload 12
    //   102: if_acmpeq +10 -> 112
    //   105: aload 11
    //   107: ldc 98
    //   109: if_acmpne +10 -> 119
    //   112: aload 6
    //   114: invokestatic 106	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   117: astore 5
    //   119: aload 10
    //   121: aload 8
    //   123: aload 5
    //   125: invokestatic 112	f/g/org/org/util/FieldInfo:setFieldValue	(Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
    //   128: goto -106 -> 22
    //   131: ldc 114
    //   133: aload_2
    //   134: invokevirtual 120	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   137: istore 4
    //   139: iload 4
    //   141: ifeq +19 -> 160
    //   144: aload 8
    //   146: checkcast 122	f/g/org/org/util/GenericData
    //   149: aload 11
    //   151: aload 6
    //   153: invokevirtual 126	f/g/org/org/util/GenericData:clone	(Ljava/lang/String;Ljava/lang/Object;)Lf/g/org/org/util/GenericData;
    //   156: pop
    //   157: goto -135 -> 22
    //   160: ldc -128
    //   162: aload_2
    //   163: invokevirtual 120	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   166: istore 4
    //   168: iload 4
    //   170: ifeq -148 -> 22
    //   173: aload 8
    //   175: checkcast 128	java/util/Map
    //   178: aload 11
    //   180: aload 6
    //   182: invokeinterface 132 3 0
    //   187: pop
    //   188: goto -166 -> 22
    //   191: astore_2
    //   192: aload_1
    //   193: invokevirtual 150	java/io/Reader:close	()V
    //   196: goto +3 -> 199
    //   199: aload_2
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	JsonParser
    //   0	201	1	paramReader	Reader
    //   0	201	2	paramClass	Class
    //   48	15	3	i	int
    //   137	32	4	bool	boolean
    //   27	97	5	localObject1	Object
    //   66	115	6	str	String
    //   4	69	7	localClassInfo	ClassInfo
    //   10	164	8	localObject2	Object
    //   20	3	9	localBufferedReader	BufferedReader
    //   79	41	10	localField	Field
    //   56	123	11	localObject3	Object
    //   96	5	12	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   0	22	191	java/lang/Throwable
    //   22	29	191	java/lang/Throwable
    //   41	58	191	java/lang/Throwable
    //   58	68	191	java/lang/Throwable
    //   72	81	191	java/lang/Throwable
    //   86	98	191	java/lang/Throwable
    //   112	119	191	java/lang/Throwable
    //   119	128	191	java/lang/Throwable
    //   131	139	191	java/lang/Throwable
    //   144	157	191	java/lang/Throwable
    //   160	168	191	java/lang/Throwable
    //   173	188	191	java/lang/Throwable
  }
  
  public Object parseAndClose(Reader paramReader, Type paramType)
  {
    throw new UnsupportedOperationException("Type-based parsing is not yet supported -- use Class<T> instead");
  }
}
