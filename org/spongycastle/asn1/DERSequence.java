package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class DERSequence
  extends ASN1Sequence
{
  public int bodyLength = -1;
  
  public DERSequence() {}
  
  public DERSequence(ASN1Encodable paramASN1Encodable)
  {
    super(paramASN1Encodable);
  }
  
  public DERSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    super(paramASN1EncodableVector);
  }
  
  public DERSequence(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    super(paramArrayOfASN1Encodable);
  }
  
  private int getBodyLength()
    throws IOException
  {
    if (bodyLength < 0)
    {
      int i = 0;
      Enumeration localEnumeration = getObjects();
      while (localEnumeration.hasMoreElements()) {
        i += ((ASN1Encodable)localEnumeration.nextElement()).toASN1Primitive().toDERObject().encodedLength();
      }
      bodyLength = i;
    }
    return bodyLength;
  }
  
  public void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    ASN1OutputStream localASN1OutputStream = paramASN1OutputStream.getDERSubStream();
    int i = getBodyLength();
    paramASN1OutputStream.write(48);
    paramASN1OutputStream.writeLength(i);
    paramASN1OutputStream = getObjects();
    while (paramASN1OutputStream.hasMoreElements()) {
      localASN1OutputStream.writeObject((ASN1Encodable)paramASN1OutputStream.nextElement());
    }
  }
  
  public int encodedLength()
    throws IOException
  {
    int i = getBodyLength();
    return StreamUtil.calculateBodyLength(i) + 1 + i;
  }
}
