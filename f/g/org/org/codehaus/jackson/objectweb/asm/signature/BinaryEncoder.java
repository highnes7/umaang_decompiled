package f.g.org.org.codehaus.jackson.objectweb.asm.signature;

public abstract interface BinaryEncoder
  extends Encoder
{
  public abstract byte[] encode(byte[] paramArrayOfByte)
    throws Base64.EncoderException;
}
