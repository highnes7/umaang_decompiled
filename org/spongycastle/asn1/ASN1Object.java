package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.util.Encodable;

public abstract class ASN1Object
  implements ASN1Encodable, Encodable
{
  public ASN1Object() {}
  
  public static boolean hasEncodedTagValue(Object paramObject, int paramInt)
  {
    return ((paramObject instanceof byte[])) && (((byte[])paramObject)[0] == paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ASN1Encodable)) {
      return false;
    }
    paramObject = (ASN1Encodable)paramObject;
    return toASN1Primitive().equals(paramObject.toASN1Primitive());
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ASN1OutputStream(localByteArrayOutputStream).writeObject(this);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public byte[] getEncoded(String paramString)
    throws IOException
  {
    if (paramString.equals("DER"))
    {
      paramString = new ByteArrayOutputStream();
      new DEROutputStream(paramString).writeObject(this);
      return paramString.toByteArray();
    }
    if (paramString.equals("DL"))
    {
      paramString = new ByteArrayOutputStream();
      new DLOutputStream(paramString).writeObject(this);
      return paramString.toByteArray();
    }
    return getEncoded();
  }
  
  public int hashCode()
  {
    return toASN1Primitive().hashCode();
  }
  
  public ASN1Primitive toASN1Object()
  {
    return toASN1Primitive();
  }
  
  public abstract ASN1Primitive toASN1Primitive();
}
