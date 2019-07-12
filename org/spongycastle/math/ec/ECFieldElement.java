package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.util.BigIntegers;

public abstract class ECFieldElement
  implements ECConstants
{
  public ECFieldElement() {}
  
  public abstract ECFieldElement add(ECFieldElement paramECFieldElement);
  
  public abstract ECFieldElement addOne();
  
  public int bitLength()
  {
    return toBigInteger().bitLength();
  }
  
  public abstract ECFieldElement divide(ECFieldElement paramECFieldElement);
  
  public byte[] getEncoded()
  {
    return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
  }
  
  public abstract String getFieldName();
  
  public abstract int getFieldSize();
  
  public abstract ECFieldElement invert();
  
  public boolean isOne()
  {
    return bitLength() == 1;
  }
  
  public boolean isZero()
  {
    return toBigInteger().signum() == 0;
  }
  
  public abstract ECFieldElement multiply(ECFieldElement paramECFieldElement);
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiply(paramECFieldElement1).subtract(paramECFieldElement2.multiply(paramECFieldElement3));
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiply(paramECFieldElement1).add(paramECFieldElement2.multiply(paramECFieldElement3));
  }
  
  public abstract ECFieldElement negate();
  
  public abstract ECFieldElement sqrt();
  
  public abstract ECFieldElement square();
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return square().subtract(paramECFieldElement1.multiply(paramECFieldElement2));
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return square().add(paramECFieldElement1.multiply(paramECFieldElement2));
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    int i = 0;
    ECFieldElement localECFieldElement = this;
    while (i < paramInt)
    {
      localECFieldElement = localECFieldElement.square();
      i += 1;
    }
    return localECFieldElement;
  }
  
  public abstract ECFieldElement subtract(ECFieldElement paramECFieldElement);
  
  public boolean testBitZero()
  {
    return toBigInteger().testBit(0);
  }
  
  public abstract BigInteger toBigInteger();
  
  public String toString()
  {
    return toBigInteger().toString(16);
  }
}
