package f.g.org.org.codehaus.jackson.objectweb.asm.signature;

public abstract interface Decoder
{
  public abstract Object decode(Object paramObject)
    throws Base64.DecoderException;
}
