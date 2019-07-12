package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class ASN1EncodableVector
{
  public final Vector v = new Vector();
  
  public ASN1EncodableVector() {}
  
  public void add(ASN1Encodable paramASN1Encodable)
  {
    v.addElement(paramASN1Encodable);
  }
  
  public void addAll(ASN1EncodableVector paramASN1EncodableVector)
  {
    paramASN1EncodableVector = v.elements();
    while (paramASN1EncodableVector.hasMoreElements()) {
      v.addElement(paramASN1EncodableVector.nextElement());
    }
  }
  
  public ASN1Encodable get(int paramInt)
  {
    return (ASN1Encodable)v.elementAt(paramInt);
  }
  
  public int size()
  {
    return v.size();
  }
}
