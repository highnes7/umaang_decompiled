package org.spongycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultXMSSMTOid
  implements XMSSOid
{
  public static final Map<String, DefaultXMSSMTOid> oidLookupTable;
  public final int oid;
  public final String stringRepresentation;
  
  static
  {
    HashMap localHashMap = new HashMap();
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H20_D2", localHashMap, createKey("SHA-256", 32, 16, 67, 20, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H20_D4", localHashMap, createKey("SHA-256", 32, 16, 67, 20, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H40_D2", localHashMap, createKey("SHA-256", 32, 16, 67, 40, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H40_D4", localHashMap, createKey("SHA-256", 32, 16, 67, 40, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H40_D8", localHashMap, createKey("SHA-256", 32, 16, 67, 40, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H60_D3", localHashMap, createKey("SHA-256", 32, 16, 67, 60, 8));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H60_D6", localHashMap, createKey("SHA-256", 32, 16, 67, 60, 6));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-256_W16_H60_D12", localHashMap, createKey("SHA-256", 32, 16, 67, 60, 12));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H20_D2", localHashMap, createKey("SHA2-512", 64, 16, 131, 20, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H20_D4", localHashMap, createKey("SHA2-512", 64, 16, 131, 20, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H40_D2", localHashMap, createKey("SHA2-512", 64, 16, 131, 40, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H40_D4", localHashMap, createKey("SHA2-512", 64, 16, 131, 40, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H40_D8", localHashMap, createKey("SHA2-512", 64, 16, 131, 40, 8));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H60_D3", localHashMap, createKey("SHA2-512", 64, 16, 131, 60, 3));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H60_D6", localHashMap, createKey("SHA2-512", 64, 16, 131, 60, 6));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHA2-512_W16_H60_D12", localHashMap, createKey("SHA2-512", 64, 16, 131, 60, 12));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H20_D2", localHashMap, createKey("SHAKE128", 32, 16, 67, 20, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H20_D4", localHashMap, createKey("SHAKE128", 32, 16, 67, 20, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H40_D2", localHashMap, createKey("SHAKE128", 32, 16, 67, 40, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H40_D4", localHashMap, createKey("SHAKE128", 32, 16, 67, 40, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H40_D8", localHashMap, createKey("SHAKE128", 32, 16, 67, 40, 8));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H60_D3", localHashMap, createKey("SHAKE128", 32, 16, 67, 60, 3));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H60_D6", localHashMap, createKey("SHAKE128", 32, 16, 67, 60, 6));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE128_W16_H60_D12", localHashMap, createKey("SHAKE128", 32, 16, 67, 60, 12));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H20_D2", localHashMap, createKey("SHAKE256", 64, 16, 131, 20, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H20_D4", localHashMap, createKey("SHAKE256", 64, 16, 131, 20, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H40_D2", localHashMap, createKey("SHAKE256", 64, 16, 131, 40, 2));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H40_D4", localHashMap, createKey("SHAKE256", 64, 16, 131, 40, 4));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H40_D8", localHashMap, createKey("SHAKE256", 64, 16, 131, 40, 8));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H60_D3", localHashMap, createKey("SHAKE256", 64, 16, 131, 60, 3));
    f.sufficientlysecure.rootcommands.util.StringBuilder.put(16777217, "XMSSMT_SHAKE256_W16_H60_D6", localHashMap, createKey("SHAKE256", 64, 16, 131, 60, 6));
    localHashMap.put(createKey("SHAKE256", 64, 16, 131, 60, 12), new DefaultXMSSMTOid(16777217, "XMSSMT_SHAKE256_W16_H60_D12"));
    oidLookupTable = Collections.unmodifiableMap(localHashMap);
  }
  
  public DefaultXMSSMTOid(int paramInt, String paramString)
  {
    oid = paramInt;
    stringRepresentation = paramString;
  }
  
  public static String createKey(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt5);
      return localStringBuilder.toString();
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public static DefaultXMSSMTOid lookup(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramString != null) {
      return (DefaultXMSSMTOid)oidLookupTable.get(createKey(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
    }
    throw new NullPointerException("algorithmName == null");
  }
  
  public int getOid()
  {
    return oid;
  }
  
  public String toString()
  {
    return stringRepresentation;
  }
}
