package f.g.org.org.http;

import f.g.b.a.g.w;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Throwables;
import f.g.org.org.util.ArrayValueMap;
import f.g.org.org.util.Charsets;
import f.g.org.org.util.ClassInfo;
import f.g.org.org.util.Data;
import f.g.org.org.util.FieldInfo;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.ObjectParser;
import f.g.org.org.util.Types;
import f.g.org.org.util.xml.CharEscapers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UrlEncodedParser
  implements ObjectParser
{
  public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
  public static final String MEDIA_TYPE = new HttpMediaType("application/x-www-form-urlencoded").setCharsetParameter(Charsets.UTF_8).build();
  
  public UrlEncodedParser() {}
  
  public static void parse(Reader paramReader, Object paramObject)
    throws IOException
  {
    Object localObject1 = paramObject.getClass();
    ClassInfo localClassInfo = ClassInfo.of((Class)localObject1);
    List localList = Arrays.asList(new Type[] { localObject1 });
    GenericData localGenericData;
    if (w.class.isAssignableFrom((Class)localObject1)) {
      localGenericData = (GenericData)paramObject;
    } else {
      localGenericData = null;
    }
    if (Map.class.isAssignableFrom((Class)localObject1)) {
      localObject1 = (Map)paramObject;
    } else {
      localObject1 = null;
    }
    ArrayValueMap localArrayValueMap = new ArrayValueMap(paramObject);
    Object localObject3 = new StringWriter();
    Object localObject2 = new StringWriter();
    int j;
    do
    {
      int i = 1;
      for (;;)
      {
        j = paramReader.read();
        if ((j == -1) || (j == 38)) {
          break;
        }
        if (j != 61)
        {
          if (i != 0) {
            ((StringWriter)localObject3).write(j);
          } else {
            ((StringWriter)localObject2).write(j);
          }
        }
        else {
          i = 0;
        }
      }
      Object localObject4 = CharEscapers.decodeUri(((StringWriter)localObject3).toString());
      if (((String)localObject4).length() != 0)
      {
        String str = CharEscapers.decodeUri(((StringWriter)localObject2).toString());
        FieldInfo localFieldInfo = localClassInfo.getFieldInfo((String)localObject4);
        if (localFieldInfo != null)
        {
          localObject4 = Data.resolveWildcardTypeOrTypeVariable(localList, localFieldInfo.getGenericType());
          if (Types.isArray((Type)localObject4))
          {
            localObject2 = Types.getRawArrayComponentType(localList, Types.getArrayComponentType((Type)localObject4));
            localArrayValueMap.put(localFieldInfo.getField(), (Class)localObject2, parseValue((Type)localObject2, localList, str));
          }
          else if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType(localList, (Type)localObject4), Iterable.class))
          {
            localObject3 = (Collection)localFieldInfo.getValue(paramObject);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject3 = Data.newCollectionInstance((Type)localObject4);
              localObject2 = localObject3;
              localFieldInfo.setValue(paramObject, localObject3);
            }
            if (localObject4 == Object.class) {
              localObject3 = null;
            } else {
              localObject3 = Types.getIterableParameter((Type)localObject4);
            }
            ((Collection)localObject2).add(parseValue((Type)localObject3, localList, str));
          }
          else
          {
            localFieldInfo.setValue(paramObject, parseValue((Type)localObject4, localList, str));
          }
        }
        else if (localObject1 != null)
        {
          localObject3 = (ArrayList)((Map)localObject1).get(localObject4);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            if (localGenericData != null) {
              localGenericData.clone((String)localObject4, localObject2);
            } else {
              ((Map)localObject1).put(localObject4, localObject2);
            }
          }
          ((ArrayList)localObject2).add(str);
        }
      }
      localObject3 = new StringWriter();
      localObject2 = new StringWriter();
    } while (j != -1);
    localArrayValueMap.setValues();
  }
  
  public static void parse(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      parse(new StringReader(paramString), paramObject);
      return;
    }
    catch (IOException paramString)
    {
      Throwables.propagate(paramString);
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public static Object parseValue(Type paramType, List paramList, String paramString)
  {
    return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(paramList, paramType), paramString);
  }
  
  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Class paramClass)
    throws IOException
  {
    return parseAndClose(new InputStreamReader(paramInputStream, paramCharset), paramClass);
  }
  
  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Type paramType)
    throws IOException
  {
    return parseAndClose(new InputStreamReader(paramInputStream, paramCharset), paramType);
  }
  
  public Object parseAndClose(Reader paramReader, Class paramClass)
    throws IOException
  {
    return parseAndClose(paramReader, paramClass);
  }
  
  public Object parseAndClose(Reader paramReader, Type paramType)
    throws IOException
  {
    Preconditions.checkArgument(paramType instanceof Class, "dataType has to be of type Class<?>");
    paramType = Types.newInstance((Class)paramType);
    parse(new BufferedReader(paramReader), paramType);
    return paramType;
  }
}
