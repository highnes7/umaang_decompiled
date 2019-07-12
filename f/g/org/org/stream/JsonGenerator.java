package f.g.org.org.stream;

import f.g.b.a.d.j;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.ClassInfo;
import f.g.org.org.util.Data;
import f.g.org.org.util.DateTime;
import f.g.org.org.util.FieldInfo;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class JsonGenerator
{
  public JsonGenerator() {}
  
  private void serialize(boolean paramBoolean, Object paramObject)
    throws IOException
  {
    if (paramObject == null) {
      return;
    }
    Object localObject1 = paramObject.getClass();
    if (Data.isNull(paramObject))
    {
      writeNull();
      return;
    }
    if ((paramObject instanceof String))
    {
      writeString((String)paramObject);
      return;
    }
    boolean bool3 = paramObject instanceof Number;
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool3)
    {
      if (paramBoolean)
      {
        writeString(paramObject.toString());
        return;
      }
      if ((paramObject instanceof BigDecimal))
      {
        writeNumber((BigDecimal)paramObject);
        return;
      }
      if ((paramObject instanceof BigInteger))
      {
        writeNumber((BigInteger)paramObject);
        return;
      }
      if ((paramObject instanceof Long))
      {
        writeNumber(((Long)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Float))
      {
        float f = ((Number)paramObject).floatValue();
        if ((!Float.isInfinite(f)) && (!Float.isNaN(f))) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
        Preconditions.append(paramBoolean);
        writeNumber(f);
        return;
      }
      if ((!(paramObject instanceof Integer)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Byte)))
      {
        double d = ((Number)paramObject).doubleValue();
        if ((!Double.isInfinite(d)) && (!Double.isNaN(d))) {
          paramBoolean = bool2;
        } else {
          paramBoolean = false;
        }
        Preconditions.append(paramBoolean);
        writeNumber(d);
        return;
      }
      writeNumber(((Number)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      writeBoolean(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof DateTime))
    {
      writeString(((DateTime)paramObject).toStringRfc3339());
      return;
    }
    if ((!(paramObject instanceof Iterable)) && (!((Class)localObject1).isArray()))
    {
      if (((Class)localObject1).isEnum())
      {
        paramObject = FieldInfo.of((Enum)paramObject).getName();
        if (paramObject == null)
        {
          writeNull();
          return;
        }
        writeString(paramObject);
        return;
      }
      writeStartObject();
      int i;
      if (((paramObject instanceof Map)) && (!(paramObject instanceof GenericData))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = null;
      } else {
        localObject1 = ClassInfo.of((Class)localObject1);
      }
      paramObject = Data.mapOf(paramObject).entrySet().iterator();
      while (paramObject.hasNext())
      {
        Object localObject3 = (Map.Entry)paramObject.next();
        Object localObject2 = ((Map.Entry)localObject3).getValue();
        if (localObject2 != null)
        {
          localObject3 = (String)((Map.Entry)localObject3).getKey();
          if (i != 0)
          {
            bool1 = paramBoolean;
          }
          else
          {
            Field localField = ((ClassInfo)localObject1).getField((String)localObject3);
            if ((localField != null) && (localField.getAnnotation(j.class) != null)) {
              bool1 = true;
            } else {
              bool1 = false;
            }
          }
          writeFieldName((String)localObject3);
          serialize(bool1, localObject2);
        }
      }
      writeEndObject();
      return;
    }
    writeStartArray();
    paramObject = Types.iterableOf(paramObject).iterator();
    while (paramObject.hasNext()) {
      serialize(paramBoolean, paramObject.next());
    }
    writeEndArray();
  }
  
  public abstract void close()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract JsonFactory getFactory();
  
  public final void serialize(Object paramObject)
    throws IOException
  {
    serialize(false, paramObject);
  }
  
  public abstract void writeBoolean(boolean paramBoolean)
    throws IOException;
  
  public abstract void writeEndArray()
    throws IOException;
  
  public abstract void writeEndObject()
    throws IOException;
  
  public void writeFieldName()
    throws IOException
  {}
  
  public abstract void writeFieldName(String paramString)
    throws IOException;
  
  public abstract void writeNull()
    throws IOException;
  
  public abstract void writeNumber(double paramDouble)
    throws IOException;
  
  public abstract void writeNumber(float paramFloat)
    throws IOException;
  
  public abstract void writeNumber(int paramInt)
    throws IOException;
  
  public abstract void writeNumber(long paramLong)
    throws IOException;
  
  public abstract void writeNumber(String paramString)
    throws IOException;
  
  public abstract void writeNumber(BigDecimal paramBigDecimal)
    throws IOException;
  
  public abstract void writeNumber(BigInteger paramBigInteger)
    throws IOException;
  
  public abstract void writeStartArray()
    throws IOException;
  
  public abstract void writeStartObject()
    throws IOException;
  
  public abstract void writeString(String paramString)
    throws IOException;
}
