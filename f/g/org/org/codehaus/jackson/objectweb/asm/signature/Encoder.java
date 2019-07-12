package f.g.org.org.codehaus.jackson.objectweb.asm.signature;

public abstract interface Encoder
{
  public abstract Object encode(Object paramObject)
    throws Base64.EncoderException;
}
