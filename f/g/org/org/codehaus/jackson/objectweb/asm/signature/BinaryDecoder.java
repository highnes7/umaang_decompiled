package f.g.org.org.codehaus.jackson.objectweb.asm.signature;

public abstract interface BinaryDecoder
  extends Decoder
{
  public abstract byte[] decode(byte[] paramArrayOfByte)
    throws Base64.DecoderException;
}
