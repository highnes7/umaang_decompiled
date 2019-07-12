package f.g.c.hash;

import f.g.c.a.a;
import f.g.c.f.j;
import f.g.c.f.k.a;
import f.g.c.f.k.b;
import f.g.c.f.k.c;
import f.g.c.f.k.e;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.OutputStream;

@a
public final class Funnels
{
  public Funnels() {}
  
  public static OutputStream asOutputStream(PrimitiveSink paramPrimitiveSink)
  {
    return new SinkAsStream();
  }
  
  public static Funnel integerFunnel()
  {
    return IntegerFunnel.INSTANCE;
  }
  
  public static Funnel longFunnel()
  {
    return LongFunnel.INSTANCE;
  }
  
  public static Funnel stringFunnel()
  {
    return StringFunnel.INSTANCE;
  }
  
  public static Funnel unencodedCharsFunnel()
  {
    return UnencodedCharsFunnel.INSTANCE;
  }
  
  public enum IntegerFunnel
    implements j<CharSequence>
  {
    INSTANCE;
    
    public void funnel(CharSequence paramCharSequence, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putString(paramCharSequence);
    }
    
    public String toString()
    {
      return "Funnels.stringFunnel()";
    }
  }
  
  public enum LongFunnel
    implements j<byte[]>
  {
    INSTANCE;
    
    public void funnel(byte[] paramArrayOfByte, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putBytes(paramArrayOfByte);
    }
    
    public String toString()
    {
      return "Funnels.byteArrayFunnel()";
    }
  }
  
  public class SinkAsStream
    extends OutputStream
  {
    public SinkAsStream()
    {
      if (Funnels.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public String toString()
    {
      return StringBuilder.append(StringBuilder.append("Funnels.asOutputStream("), Funnels.this, ")");
    }
    
    public void write(int paramInt)
    {
      putByte((byte)paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
    {
      putBytes(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      putBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public enum StringFunnel
    implements j<Long>
  {
    INSTANCE;
    
    public void funnel(Long paramLong, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putLong(paramLong.longValue());
    }
    
    public String toString()
    {
      return "Funnels.longFunnel()";
    }
  }
  
  public enum UnencodedCharsFunnel
    implements j<Integer>
  {
    INSTANCE;
    
    public void funnel(Integer paramInteger, PrimitiveSink paramPrimitiveSink)
    {
      paramPrimitiveSink.putInt(paramInteger.intValue());
    }
    
    public String toString()
    {
      return "Funnels.integerFunnel()";
    }
  }
}
