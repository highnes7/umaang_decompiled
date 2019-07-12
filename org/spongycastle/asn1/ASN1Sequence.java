package org.spongycastle.asn1;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays.Iterator;
import org.spongycastle.util.Iterable;

public abstract class ASN1Sequence
  extends ASN1Primitive
  implements Iterable<ASN1Encodable>
{
  public Vector seq = new Vector();
  
  public ASN1Sequence() {}
  
  public ASN1Sequence(ASN1Encodable paramASN1Encodable)
  {
    seq.addElement(paramASN1Encodable);
  }
  
  public ASN1Sequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    int i = 0;
    while (i != paramASN1EncodableVector.size())
    {
      seq.addElement(paramASN1EncodableVector.get(i));
      i += 1;
    }
  }
  
  public ASN1Sequence(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    int i = 0;
    while (i != paramArrayOfASN1Encodable.length)
    {
      seq.addElement(paramArrayOfASN1Encodable[i]);
      i += 1;
    }
  }
  
  public static ASN1Sequence getInstance(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      boolean bool = paramObject instanceof ASN1Sequence;
      if (bool)
      {
        localObject = paramObject;
      }
      else
      {
        if ((paramObject instanceof ASN1SequenceParser)) {
          return getInstance(((ASN1Encodable)paramObject).toASN1Primitive());
        }
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
            throw new IllegalArgumentException(StringBuilder.get(paramObject, StringBuilder.append("failed to construct sequence from byte[]: ")));
          }
        }
        if ((paramObject instanceof ASN1Encodable))
        {
          localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
          if ((localObject instanceof ASN1Sequence)) {
            return (ASN1Sequence)localObject;
          }
        }
        throw new IllegalArgumentException(StringBuilder.toString(paramObject, StringBuilder.append("unknown object in getInstance: ")));
      }
    }
    return (ASN1Sequence)localObject;
  }
  
  public static ASN1Sequence getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramASN1TaggedObject.isExplicit()) {
        return getInstance(paramASN1TaggedObject.getObject().toASN1Primitive());
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    if (paramASN1TaggedObject.isExplicit())
    {
      if ((paramASN1TaggedObject instanceof BERTaggedObject)) {
        return (ASN1Sequence)new BERSequence(paramASN1TaggedObject.getObject());
      }
      return (ASN1Sequence)new DLSequence(paramASN1TaggedObject.getObject());
    }
    if ((paramASN1TaggedObject.getObject() instanceof ASN1Sequence)) {
      return (ASN1Sequence)paramASN1TaggedObject.getObject();
    }
    throw new IllegalArgumentException(StringBuilder.toString(paramASN1TaggedObject, StringBuilder.append("unknown object in getInstance: ")));
  }
  
  private ASN1Encodable getNext(Enumeration paramEnumeration)
  {
    return (ASN1Encodable)paramEnumeration.nextElement();
  }
  
  public boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof ASN1Sequence)) {
      return false;
    }
    Object localObject1 = (ASN1Sequence)paramASN1Primitive;
    if (size() != ((ASN1Sequence)localObject1).size()) {
      return false;
    }
    paramASN1Primitive = getObjects();
    localObject1 = ((ASN1Sequence)localObject1).getObjects();
    while (paramASN1Primitive.hasMoreElements())
    {
      Object localObject3 = getNext(paramASN1Primitive);
      Object localObject2 = getNext((Enumeration)localObject1);
      localObject3 = ((ASN1Encodable)localObject3).toASN1Primitive();
      localObject2 = ((ASN1Encodable)localObject2).toASN1Primitive();
      if ((localObject3 != localObject2) && (!((ASN1Primitive)localObject3).equals(localObject2))) {
        return false;
      }
    }
    return true;
  }
  
  public abstract void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException;
  
  public ASN1Encodable getObjectAt(int paramInt)
  {
    return (ASN1Encodable)seq.elementAt(paramInt);
  }
  
  public Enumeration getObjects()
  {
    return seq.elements();
  }
  
  public int hashCode()
  {
    Enumeration localEnumeration = getObjects();
    for (int i = size(); localEnumeration.hasMoreElements(); i = i * 17 ^ getNext(localEnumeration).hashCode()) {}
    return i;
  }
  
  public boolean isConstructed()
  {
    return true;
  }
  
  public Iterator iterator()
  {
    return (Iterator)new Arrays.Iterator(toArray());
  }
  
  public ASN1SequenceParser parser()
  {
    return new ASN1Sequence.1(this, this);
  }
  
  public int size()
  {
    return seq.size();
  }
  
  public ASN1Encodable[] toArray()
  {
    ASN1Encodable[] arrayOfASN1Encodable = new ASN1Encodable[size()];
    int i = 0;
    while (i != size())
    {
      arrayOfASN1Encodable[i] = getObjectAt(i);
      i += 1;
    }
    return arrayOfASN1Encodable;
  }
  
  public ASN1Primitive toDERObject()
  {
    DERSequence localDERSequence = new DERSequence();
    seq = seq;
    return localDERSequence;
  }
  
  public ASN1Primitive toDLObject()
  {
    DLSequence localDLSequence = new DLSequence();
    Vector localVector = seq;
    seq = localVector;
    return (ASN1Primitive)localDLSequence;
  }
  
  public String toString()
  {
    return seq.toString();
  }
}
