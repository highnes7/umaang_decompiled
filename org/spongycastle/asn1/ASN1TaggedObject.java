package org.spongycastle.asn1;

import java.io.IOException;

public abstract class ASN1TaggedObject
  extends ASN1Primitive
  implements ASN1TaggedObjectParser
{
  public boolean empty = false;
  public boolean explicit = true;
  public ASN1Encodable obj = null;
  public int tagNo;
  
  public ASN1TaggedObject(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable)
  {
    if ((paramASN1Encodable instanceof ASN1Choice)) {
      explicit = true;
    } else {
      explicit = paramBoolean;
    }
    tagNo = paramInt;
    if (explicit)
    {
      obj = paramASN1Encodable;
      return;
    }
    paramASN1Encodable.toASN1Primitive();
    obj = paramASN1Encodable;
  }
  
  public static ASN1TaggedObject getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1TaggedObject)))
    {
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = getInstance(ASN1Primitive.fromByteArray(paramObject));
          return paramObject;
        }
        catch (IOException paramObject)
        {
          throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramObject, f.sufficientlysecure.rootcommands.util.StringBuilder.append("failed to construct tagged object from byte[]: ")));
        }
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramObject, f.sufficientlysecure.rootcommands.util.StringBuilder.append("unknown object in getInstance: ")));
    }
    return (ASN1TaggedObject)paramObject;
  }
  
  public static ASN1TaggedObject getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (ASN1TaggedObject)paramASN1TaggedObject.getObject();
    }
    throw new IllegalArgumentException("implicitly tagged tagged object");
  }
  
  public boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1TaggedObject)) {
      return false;
    }
    paramASN1Primitive = (ASN1TaggedObject)paramASN1Primitive;
    if ((tagNo == tagNo) && (empty == empty))
    {
      if (explicit != explicit) {
        return false;
      }
      ASN1Encodable localASN1Encodable = obj;
      if (localASN1Encodable == null)
      {
        if (obj != null) {
          return false;
        }
      }
      else if (!localASN1Encodable.toASN1Primitive().equals(obj.toASN1Primitive())) {
        return false;
      }
      return true;
    }
    return false;
  }
  
  public abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public ASN1Primitive getLoadedObject()
  {
    return toASN1Primitive();
  }
  
  public ASN1Primitive getObject()
  {
    ASN1Encodable localASN1Encodable = obj;
    if (localASN1Encodable != null) {
      return localASN1Encodable.toASN1Primitive();
    }
    return null;
  }
  
  public ASN1Encodable getObjectParser(int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramInt != 4)
    {
      if (paramInt != 16)
      {
        if (paramInt != 17)
        {
          if (paramBoolean) {
            return getObject();
          }
          throw ((Throwable)new ASN1Exception(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("implicit tagging not implemented for tag: ", paramInt)));
        }
        return (ASN1Encodable)ASN1Set.getInstance(this, paramBoolean).parser();
      }
      return (ASN1Encodable)ASN1Sequence.getInstance(this, paramBoolean).parser();
    }
    return ASN1OctetString.getInstance(this, paramBoolean).parser();
  }
  
  public int getTagNo()
  {
    return tagNo;
  }
  
  public int hashCode()
  {
    int i = tagNo;
    ASN1Encodable localASN1Encodable = obj;
    if (localASN1Encodable != null) {
      return i ^ localASN1Encodable.hashCode();
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return empty;
  }
  
  public boolean isExplicit()
  {
    return explicit;
  }
  
  public ASN1Primitive toDERObject()
  {
    return new DERTaggedObject(explicit, tagNo, obj);
  }
  
  public ASN1Primitive toDLObject()
  {
    return (ASN1Primitive)new DLTaggedObject(explicit, tagNo, obj);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[");
    localStringBuilder.append(tagNo);
    localStringBuilder.append("]");
    localStringBuilder.append(obj);
    return localStringBuilder.toString();
  }
}
