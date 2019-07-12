package org.spongycastle.asn1;

import java.io.IOException;

public class DERTaggedObject
  extends ASN1TaggedObject
{
  public static final byte[] ZERO_BYTES = new byte[0];
  
  public DERTaggedObject(int paramInt, ASN1Encodable paramASN1Encodable)
  {
    super(true, paramInt, paramASN1Encodable);
  }
  
  public DERTaggedObject(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    super(paramBoolean, paramInt, paramASN1Encodable);
  }
  
  public void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    boolean bool = empty;
    int i = 160;
    if (!bool)
    {
      ASN1Primitive localASN1Primitive = obj.toASN1Primitive().toDERObject();
      if (explicit)
      {
        paramASN1OutputStream.writeTag(160, tagNo);
        paramASN1OutputStream.writeLength(localASN1Primitive.encodedLength());
        paramASN1OutputStream.writeObject(localASN1Primitive);
        return;
      }
      if (!localASN1Primitive.isConstructed()) {
        i = 128;
      }
      paramASN1OutputStream.writeTag(i, tagNo);
      paramASN1OutputStream.writeImplicitObject(localASN1Primitive);
      return;
    }
    paramASN1OutputStream.writeEncoded(160, tagNo, ZERO_BYTES);
  }
  
  public int encodedLength()
    throws IOException
  {
    if (!empty)
    {
      int i = obj.toASN1Primitive().toDERObject().encodedLength();
      if (explicit)
      {
        int j = StreamUtil.calculateTagLength(tagNo);
        return StreamUtil.calculateBodyLength(i) + j + i;
      }
      return StreamUtil.calculateTagLength(tagNo) + (i - 1);
    }
    return StreamUtil.calculateTagLength(tagNo) + 1;
  }
  
  public boolean isConstructed()
  {
    if (!empty)
    {
      if (explicit) {
        return true;
      }
      return obj.toASN1Primitive().toDERObject().isConstructed();
    }
    return true;
  }
}
