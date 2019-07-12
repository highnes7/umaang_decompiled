package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.spongycastle.util.Arrays;

public class PKCS12KeyWithParameters
  extends PKCS12Key
  implements PBEKey
{
  public final int iterationCount;
  public final byte[] salt;
  
  public PKCS12KeyWithParameters(char[] paramArrayOfChar, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, paramBoolean);
    salt = Arrays.clone(paramArrayOfByte);
    iterationCount = paramInt;
  }
  
  public PKCS12KeyWithParameters(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, false);
    salt = Arrays.clone(paramArrayOfByte);
    iterationCount = paramInt;
  }
  
  public int getIterationCount()
  {
    return iterationCount;
  }
  
  public byte[] getSalt()
  {
    return salt;
  }
}
