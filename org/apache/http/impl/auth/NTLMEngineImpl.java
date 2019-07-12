package org.apache.http.impl.auth;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.EncodingUtils;

@NotThreadSafe
public final class NTLMEngineImpl
  implements NTLMEngine
{
  public static final String DEFAULT_CHARSET = "ASCII";
  public static final int FLAG_DOMAIN_PRESENT = 4096;
  public static final int FLAG_REQUEST_128BIT_KEY_EXCH = 536870912;
  public static final int FLAG_REQUEST_56BIT_ENCRYPTION = Integer.MIN_VALUE;
  public static final int FLAG_REQUEST_ALWAYS_SIGN = 32768;
  public static final int FLAG_REQUEST_EXPLICIT_KEY_EXCH = 1073741824;
  public static final int FLAG_REQUEST_LAN_MANAGER_KEY = 128;
  public static final int FLAG_REQUEST_NTLM2_SESSION = 524288;
  public static final int FLAG_REQUEST_NTLMv1 = 512;
  public static final int FLAG_REQUEST_SEAL = 32;
  public static final int FLAG_REQUEST_SIGN = 16;
  public static final int FLAG_REQUEST_TARGET = 4;
  public static final int FLAG_REQUEST_UNICODE_ENCODING = 1;
  public static final int FLAG_REQUEST_VERSION = 33554432;
  public static final int FLAG_TARGETINFO_PRESENT = 8388608;
  public static final int FLAG_WORKSTATION_PRESENT = 8192;
  public static final SecureRandom RND_GEN;
  public static final byte[] SIGNATURE;
  public String credentialCharset = "ASCII";
  
  static
  {
    try
    {
      localObject = SecureRandom.getInstance("SHA1PRNG");
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = null;
    RND_GEN = (SecureRandom)localObject;
    localObject = EncodingUtils.getBytes("NTLMSSP", "ASCII");
    SIGNATURE = new byte[localObject.length + 1];
    System.arraycopy(localObject, 0, SIGNATURE, 0, localObject.length);
    SIGNATURE[localObject.length] = 0;
  }
  
  public NTLMEngineImpl() {}
  
  public static int F(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt2 & paramInt1;
  }
  
  public static int G(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 & paramInt3 | paramInt1 & paramInt2 | paramInt2 & paramInt3;
  }
  
  public static int H(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 ^ paramInt2 ^ paramInt3;
  }
  
  public static byte[] RC4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Cipher localCipher = Cipher.getInstance("RC4");
      localCipher.init(1, new SecretKeySpec(paramArrayOfByte2, "RC4"));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new NTLMEngineException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  public static String convertDomain(String paramString)
  {
    return stripDotSuffix(paramString);
  }
  
  public static String convertHost(String paramString)
  {
    return stripDotSuffix(paramString);
  }
  
  public static byte[] createBlob(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte1 = new byte[4];
    byte[] tmp7_5 = arrayOfByte1;
    tmp7_5[0] = 1;
    byte[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 1;
    byte[] tmp17_12 = tmp12_7;
    tmp17_12[2] = 0;
    byte[] tmp22_17 = tmp17_12;
    tmp22_17[3] = 0;
    tmp22_17;
    byte[] arrayOfByte2 = new byte[4];
    byte[] tmp35_33 = arrayOfByte2;
    tmp35_33[0] = 0;
    byte[] tmp40_35 = tmp35_33;
    tmp40_35[1] = 0;
    byte[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 0;
    byte[] tmp50_45 = tmp45_40;
    tmp50_45[3] = 0;
    tmp50_45;
    byte[] arrayOfByte3 = new byte[4];
    byte[] tmp63_61 = arrayOfByte3;
    tmp63_61[0] = 0;
    byte[] tmp68_63 = tmp63_61;
    tmp68_63[1] = 0;
    byte[] tmp73_68 = tmp68_63;
    tmp73_68[2] = 0;
    byte[] tmp78_73 = tmp73_68;
    tmp78_73[3] = 0;
    tmp78_73;
    byte[] arrayOfByte4 = new byte[4];
    byte[] tmp91_89 = arrayOfByte4;
    tmp91_89[0] = 0;
    byte[] tmp96_91 = tmp91_89;
    tmp96_91[1] = 0;
    byte[] tmp101_96 = tmp96_91;
    tmp101_96[2] = 0;
    byte[] tmp106_101 = tmp101_96;
    tmp106_101[3] = 0;
    tmp106_101;
    byte[] arrayOfByte5 = new byte[arrayOfByte1.length + arrayOfByte2.length + paramArrayOfByte3.length + 8 + arrayOfByte3.length + paramArrayOfByte2.length + arrayOfByte4.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, arrayOfByte1.length);
    int i = arrayOfByte1.length + 0;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, i, arrayOfByte2.length);
    i += arrayOfByte2.length;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte5, i, paramArrayOfByte3.length);
    i += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte5, i, 8);
    i += 8;
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte5, i, paramArrayOfByte2.length);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, i + paramArrayOfByte2.length, arrayOfByte4.length);
    return arrayOfByte5;
  }
  
  public static Key createDESKey(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[7];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 7);
    paramArrayOfByte = new byte[8];
    paramArrayOfByte[0] = arrayOfByte[0];
    paramArrayOfByte[1] = ((byte)(arrayOfByte[0] << 7 | (arrayOfByte[1] & 0xFF) >>> 1));
    paramArrayOfByte[2] = ((byte)(arrayOfByte[1] << 6 | (arrayOfByte[2] & 0xFF) >>> 2));
    paramArrayOfByte[3] = ((byte)(arrayOfByte[2] << 5 | (arrayOfByte[3] & 0xFF) >>> 3));
    paramArrayOfByte[4] = ((byte)(arrayOfByte[3] << 4 | (arrayOfByte[4] & 0xFF) >>> 4));
    paramArrayOfByte[5] = ((byte)(arrayOfByte[4] << 3 | (arrayOfByte[5] & 0xFF) >>> 5));
    paramArrayOfByte[6] = ((byte)(arrayOfByte[5] << 2 | (arrayOfByte[6] & 0xFF) >>> 6));
    paramArrayOfByte[7] = ((byte)(arrayOfByte[6] << 1));
    oddParity(paramArrayOfByte);
    return new SecretKeySpec(paramArrayOfByte, "DES");
  }
  
  public static byte[] hmacMD5(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte3 = new byte[64];
      byte[] arrayOfByte2 = new byte[64];
      int i = paramArrayOfByte2.length;
      int j = i;
      byte[] arrayOfByte1 = paramArrayOfByte2;
      if (i > 64)
      {
        localMessageDigest.update(paramArrayOfByte2);
        arrayOfByte1 = localMessageDigest.digest();
        paramArrayOfByte2 = arrayOfByte1;
        j = arrayOfByte1.length;
        arrayOfByte1 = paramArrayOfByte2;
      }
      i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (i >= j) {
          break;
        }
        arrayOfByte3[i] = ((byte)(0x36 ^ arrayOfByte1[i]));
        arrayOfByte2[i] = ((byte)(0x5C ^ arrayOfByte1[i]));
        i += 1;
      }
      while (k < 64)
      {
        arrayOfByte3[k] = 54;
        arrayOfByte2[k] = 92;
        k += 1;
      }
      localMessageDigest.reset();
      localMessageDigest.update(arrayOfByte3);
      localMessageDigest.update(paramArrayOfByte1);
      paramArrayOfByte1 = localMessageDigest.digest();
      localMessageDigest.update(arrayOfByte2);
      return localMessageDigest.digest(paramArrayOfByte1);
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1 = new NTLMEngineException(f.sufficientlysecure.rootcommands.util.StringBuilder.e(paramArrayOfByte1, f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error getting md5 message digest implementation: ")), paramArrayOfByte1);
      throw paramArrayOfByte1;
    }
  }
  
  public static byte[] lmHash(String paramString)
  {
    Object localObject = Locale.ENGLISH;
    try
    {
      paramString = paramString.toUpperCase((Locale)localObject).getBytes("US-ASCII");
      int i = paramString.length;
      i = Math.min(i, 14);
      localObject = new byte[14];
      System.arraycopy(paramString, 0, localObject, 0, i);
      paramString = createDESKey((byte[])localObject, 0);
      localObject = createDESKey((byte[])localObject, 7);
      byte[] arrayOfByte = "KGS!@#$%".getBytes("US-ASCII");
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(1, paramString);
      paramString = localCipher.doFinal(arrayOfByte);
      localCipher.init(1, (Key)localObject);
      localObject = localCipher.doFinal(arrayOfByte);
      arrayOfByte = new byte[16];
      System.arraycopy(paramString, 0, arrayOfByte, 0, 8);
      System.arraycopy(localObject, 0, arrayOfByte, 8, 8);
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      throw new NTLMEngineException(paramString.getMessage(), paramString);
    }
  }
  
  public static byte[] lmResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject2 = new byte[21];
    try
    {
      System.arraycopy(paramArrayOfByte1, 0, localObject2, 0, 16);
      paramArrayOfByte1 = createDESKey((byte[])localObject2, 0);
      Object localObject1 = createDESKey((byte[])localObject2, 7);
      localObject2 = createDESKey((byte[])localObject2, 14);
      Cipher localCipher = Cipher.getInstance("DES/ECB/NoPadding");
      localCipher.init(1, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2);
      localCipher.init(1, (Key)localObject1);
      localObject1 = localCipher.doFinal(paramArrayOfByte2);
      localCipher.init(1, (Key)localObject2);
      paramArrayOfByte2 = localCipher.doFinal(paramArrayOfByte2);
      localObject2 = new byte[24];
      System.arraycopy(paramArrayOfByte1, 0, localObject2, 0, 8);
      System.arraycopy(localObject1, 0, localObject2, 8, 8);
      System.arraycopy(paramArrayOfByte2, 0, localObject2, 16, 8);
      return localObject2;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new NTLMEngineException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  /* Error */
  public static byte[] lmv2Hash(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc -47
    //   2: invokestatic 214	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 7
    //   7: bipush 64
    //   9: newarray byte
    //   11: astore 9
    //   13: bipush 64
    //   15: newarray byte
    //   17: astore 8
    //   19: aload_2
    //   20: arraylength
    //   21: istore_3
    //   22: iload_3
    //   23: istore 4
    //   25: aload_2
    //   26: astore 6
    //   28: iload_3
    //   29: bipush 64
    //   31: if_icmple +27 -> 58
    //   34: aload 7
    //   36: aload_2
    //   37: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   40: aload 7
    //   42: invokevirtual 220	java/security/MessageDigest:digest	()[B
    //   45: astore 6
    //   47: aload 6
    //   49: astore_2
    //   50: aload 6
    //   52: arraylength
    //   53: istore 4
    //   55: aload_2
    //   56: astore 6
    //   58: iconst_0
    //   59: istore_3
    //   60: iload_3
    //   61: istore 5
    //   63: iload_3
    //   64: iload 4
    //   66: if_icmpge +34 -> 100
    //   69: aload 9
    //   71: iload_3
    //   72: bipush 54
    //   74: aload 6
    //   76: iload_3
    //   77: baload
    //   78: ixor
    //   79: i2b
    //   80: bastore
    //   81: aload 8
    //   83: iload_3
    //   84: bipush 92
    //   86: aload 6
    //   88: iload_3
    //   89: baload
    //   90: ixor
    //   91: i2b
    //   92: bastore
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -37 -> 60
    //   100: iload 5
    //   102: bipush 64
    //   104: if_icmpge +26 -> 130
    //   107: aload 9
    //   109: iload 5
    //   111: bipush 54
    //   113: bastore
    //   114: aload 8
    //   116: iload 5
    //   118: bipush 92
    //   120: bastore
    //   121: iload 5
    //   123: iconst_1
    //   124: iadd
    //   125: istore 5
    //   127: goto -27 -> 100
    //   130: aload 7
    //   132: invokevirtual 223	java/security/MessageDigest:reset	()V
    //   135: aload 7
    //   137: aload 9
    //   139: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   142: getstatic 243	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   145: astore_2
    //   146: aload 7
    //   148: aload_1
    //   149: aload_2
    //   150: invokevirtual 249	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   153: ldc_w 267
    //   156: invokevirtual 253	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   159: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   162: aload_0
    //   163: ifnull +23 -> 186
    //   166: getstatic 243	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   169: astore_1
    //   170: aload 7
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 249	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   177: ldc_w 267
    //   180: invokevirtual 253	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   183: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   186: aload 7
    //   188: invokevirtual 220	java/security/MessageDigest:digest	()[B
    //   191: astore_0
    //   192: aload 7
    //   194: aload 8
    //   196: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   199: aload 7
    //   201: aload_0
    //   202: invokevirtual 225	java/security/MessageDigest:digest	([B)[B
    //   205: astore_0
    //   206: aload_0
    //   207: areturn
    //   208: astore_0
    //   209: new 269	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   216: astore_1
    //   217: aload_1
    //   218: ldc -29
    //   220: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload_0
    //   226: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   229: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: new 124	org/apache/http/impl/auth/NTLMEngineException
    //   236: dup
    //   237: aload_1
    //   238: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload_0
    //   242: invokespecial 131	org/apache/http/impl/auth/NTLMEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: astore_0
    //   246: aload_0
    //   247: athrow
    //   248: astore_0
    //   249: ldc_w 276
    //   252: invokestatic 233	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: astore_1
    //   256: aload_1
    //   257: aload_0
    //   258: invokevirtual 277	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   261: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: new 124	org/apache/http/impl/auth/NTLMEngineException
    //   268: dup
    //   269: aload_1
    //   270: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: aload_0
    //   274: invokespecial 131	org/apache/http/impl/auth/NTLMEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: astore_0
    //   278: goto +3 -> 281
    //   281: aload_0
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramString1	String
    //   0	283	1	paramString2	String
    //   0	283	2	paramArrayOfByte	byte[]
    //   21	76	3	i	int
    //   23	44	4	j	int
    //   61	65	5	k	int
    //   26	61	6	arrayOfByte1	byte[]
    //   5	195	7	localMessageDigest	MessageDigest
    //   17	178	8	arrayOfByte2	byte[]
    //   11	127	9	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	7	208	java/lang/Exception
    //   34	47	248	java/io/UnsupportedEncodingException
    //   130	142	248	java/io/UnsupportedEncodingException
    //   146	162	248	java/io/UnsupportedEncodingException
    //   170	186	248	java/io/UnsupportedEncodingException
    //   186	206	248	java/io/UnsupportedEncodingException
    //   209	246	248	java/io/UnsupportedEncodingException
  }
  
  public static byte[] lmv2Response(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte3 = new byte[64];
      byte[] arrayOfByte2 = new byte[64];
      int i = paramArrayOfByte1.length;
      int j = i;
      byte[] arrayOfByte1 = paramArrayOfByte1;
      if (i > 64)
      {
        localMessageDigest.update(paramArrayOfByte1);
        arrayOfByte1 = localMessageDigest.digest();
        paramArrayOfByte1 = arrayOfByte1;
        j = arrayOfByte1.length;
        arrayOfByte1 = paramArrayOfByte1;
      }
      i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (i >= j) {
          break;
        }
        arrayOfByte3[i] = ((byte)(0x36 ^ arrayOfByte1[i]));
        arrayOfByte2[i] = ((byte)(0x5C ^ arrayOfByte1[i]));
        i += 1;
      }
      while (k < 64)
      {
        arrayOfByte3[k] = 54;
        arrayOfByte2[k] = 92;
        k += 1;
      }
      localMessageDigest.reset();
      localMessageDigest.update(arrayOfByte3);
      localMessageDigest.update(paramArrayOfByte2);
      localMessageDigest.update(paramArrayOfByte3);
      paramArrayOfByte1 = localMessageDigest.digest();
      localMessageDigest.update(arrayOfByte2);
      paramArrayOfByte1 = localMessageDigest.digest(paramArrayOfByte1);
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length + paramArrayOfByte3.length];
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte2, paramArrayOfByte1.length, paramArrayOfByte3.length);
      return paramArrayOfByte2;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1 = new NTLMEngineException(f.sufficientlysecure.rootcommands.util.StringBuilder.e(paramArrayOfByte1, f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error getting md5 message digest implementation: ")), paramArrayOfByte1);
      throw paramArrayOfByte1;
    }
  }
  
  public static byte[] makeRandomChallenge()
  {
    SecureRandom localSecureRandom = RND_GEN;
    if (localSecureRandom != null)
    {
      byte[] arrayOfByte = new byte[8];
      try
      {
        RND_GEN.nextBytes(arrayOfByte);
        return arrayOfByte;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    throw new NTLMEngineException("Random generator not available");
  }
  
  public static byte[] makeSecondaryKey()
  {
    SecureRandom localSecureRandom = RND_GEN;
    if (localSecureRandom != null)
    {
      byte[] arrayOfByte = new byte[16];
      try
      {
        RND_GEN.nextBytes(arrayOfByte);
        return arrayOfByte;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    throw new NTLMEngineException("Random generator not available");
  }
  
  public static byte[] ntlm2SessionResponse(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte2);
      localMessageDigest.update(paramArrayOfByte3);
      paramArrayOfByte2 = localMessageDigest.digest();
      paramArrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, 0, 8);
      paramArrayOfByte1 = lmResponse(paramArrayOfByte1, paramArrayOfByte3);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      if ((paramArrayOfByte1 instanceof NTLMEngineException)) {
        throw ((NTLMEngineException)paramArrayOfByte1);
      }
      throw new NTLMEngineException(paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  public static byte[] ntlmHash(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UnicodeLittleUnmarked");
      localObject = new NTLMEngineImpl.MD4();
      ((NTLMEngineImpl.MD4)localObject).update(paramString);
      paramString = ((NTLMEngineImpl.MD4)localObject).getOutput();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unicode not supported: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      throw new NTLMEngineException(((StringBuilder)localObject).toString(), paramString);
    }
  }
  
  /* Error */
  public static byte[] ntlmv2Hash(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc -47
    //   2: invokestatic 214	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 7
    //   7: bipush 64
    //   9: newarray byte
    //   11: astore 9
    //   13: bipush 64
    //   15: newarray byte
    //   17: astore 8
    //   19: aload_2
    //   20: arraylength
    //   21: istore_3
    //   22: iload_3
    //   23: istore 4
    //   25: aload_2
    //   26: astore 6
    //   28: iload_3
    //   29: bipush 64
    //   31: if_icmple +27 -> 58
    //   34: aload 7
    //   36: aload_2
    //   37: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   40: aload 7
    //   42: invokevirtual 220	java/security/MessageDigest:digest	()[B
    //   45: astore 6
    //   47: aload 6
    //   49: astore_2
    //   50: aload 6
    //   52: arraylength
    //   53: istore 4
    //   55: aload_2
    //   56: astore 6
    //   58: iconst_0
    //   59: istore_3
    //   60: iload_3
    //   61: istore 5
    //   63: iload_3
    //   64: iload 4
    //   66: if_icmpge +34 -> 100
    //   69: aload 9
    //   71: iload_3
    //   72: bipush 54
    //   74: aload 6
    //   76: iload_3
    //   77: baload
    //   78: ixor
    //   79: i2b
    //   80: bastore
    //   81: aload 8
    //   83: iload_3
    //   84: bipush 92
    //   86: aload 6
    //   88: iload_3
    //   89: baload
    //   90: ixor
    //   91: i2b
    //   92: bastore
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -37 -> 60
    //   100: iload 5
    //   102: bipush 64
    //   104: if_icmpge +26 -> 130
    //   107: aload 9
    //   109: iload 5
    //   111: bipush 54
    //   113: bastore
    //   114: aload 8
    //   116: iload 5
    //   118: bipush 92
    //   120: bastore
    //   121: iload 5
    //   123: iconst_1
    //   124: iadd
    //   125: istore 5
    //   127: goto -27 -> 100
    //   130: aload 7
    //   132: invokevirtual 223	java/security/MessageDigest:reset	()V
    //   135: aload 7
    //   137: aload 9
    //   139: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   142: getstatic 243	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   145: astore_2
    //   146: aload 7
    //   148: aload_1
    //   149: aload_2
    //   150: invokevirtual 249	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   153: ldc_w 267
    //   156: invokevirtual 253	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   159: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   162: aload_0
    //   163: ifnull +15 -> 178
    //   166: aload 7
    //   168: aload_0
    //   169: ldc_w 267
    //   172: invokevirtual 253	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   175: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   178: aload 7
    //   180: invokevirtual 220	java/security/MessageDigest:digest	()[B
    //   183: astore_0
    //   184: aload 7
    //   186: aload 8
    //   188: invokevirtual 217	java/security/MessageDigest:update	([B)V
    //   191: aload 7
    //   193: aload_0
    //   194: invokevirtual 225	java/security/MessageDigest:digest	([B)[B
    //   197: astore_0
    //   198: aload_0
    //   199: areturn
    //   200: astore_0
    //   201: new 269	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   208: astore_1
    //   209: aload_1
    //   210: ldc -29
    //   212: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: aload_0
    //   218: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: new 124	org/apache/http/impl/auth/NTLMEngineException
    //   228: dup
    //   229: aload_1
    //   230: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aload_0
    //   234: invokespecial 131	org/apache/http/impl/auth/NTLMEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: astore_0
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: ldc_w 276
    //   244: invokestatic 233	f/sufficientlysecure/rootcommands/util/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: astore_1
    //   248: aload_1
    //   249: aload_0
    //   250: invokevirtual 277	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: new 124	org/apache/http/impl/auth/NTLMEngineException
    //   260: dup
    //   261: aload_1
    //   262: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aload_0
    //   266: invokespecial 131	org/apache/http/impl/auth/NTLMEngineException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: astore_0
    //   270: goto +3 -> 273
    //   273: aload_0
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramString1	String
    //   0	275	1	paramString2	String
    //   0	275	2	paramArrayOfByte	byte[]
    //   21	76	3	i	int
    //   23	44	4	j	int
    //   61	65	5	k	int
    //   26	61	6	arrayOfByte1	byte[]
    //   5	187	7	localMessageDigest	MessageDigest
    //   17	170	8	arrayOfByte2	byte[]
    //   11	127	9	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	7	200	java/lang/Exception
    //   34	47	240	java/io/UnsupportedEncodingException
    //   130	142	240	java/io/UnsupportedEncodingException
    //   146	162	240	java/io/UnsupportedEncodingException
    //   166	178	240	java/io/UnsupportedEncodingException
    //   178	198	240	java/io/UnsupportedEncodingException
    //   201	238	240	java/io/UnsupportedEncodingException
  }
  
  public static void oddParity(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      if (((j >>> 1 ^ j >>> 7 ^ j >>> 6 ^ j >>> 5 ^ j >>> 4 ^ j >>> 3 ^ j >>> 2) & 0x1) == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] | 0x1));
      } else {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] & 0xFFFFFFFE));
      }
      i += 1;
    }
  }
  
  public static byte[] readSecurityBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = readUShort(paramArrayOfByte, paramInt);
    paramInt = readULong(paramArrayOfByte, paramInt + 4);
    if (paramArrayOfByte.length >= paramInt + i)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    throw new NTLMEngineException("NTLM authentication - buffer too small for data item");
  }
  
  public static int readULong(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length >= paramInt + 4)
    {
      int i = paramArrayOfByte[paramInt];
      int j = paramArrayOfByte[(paramInt + 1)];
      int k = paramArrayOfByte[(paramInt + 2)];
      return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
    }
    throw new NTLMEngineException("NTLM authentication - buffer too small for DWORD");
  }
  
  public static int readUShort(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length >= paramInt + 2)
    {
      int i = paramArrayOfByte[paramInt];
      return (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | i & 0xFF;
    }
    throw new NTLMEngineException("NTLM authentication - buffer too small for WORD");
  }
  
  public static int rotintlft(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> 32 - paramInt2 | paramInt1 << paramInt2;
  }
  
  public static String stripDotSuffix(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.indexOf(".");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static void writeULong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public String generateType1Msg(String paramString1, String paramString2)
  {
    return getType1Message(paramString2, paramString1);
  }
  
  public String generateType3Msg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString5 = new NTLMEngineImpl.Type2Message(paramString5);
    return getType3Message(paramString1, paramString2, paramString4, paramString3, paramString5.getChallenge(), paramString5.getFlags(), paramString5.getTarget(), paramString5.getTargetInfo());
  }
  
  public String getCredentialCharset()
  {
    return credentialCharset;
  }
  
  public final String getResponseFor(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramString1 != null) && (!paramString1.trim().equals("")))
    {
      paramString1 = new NTLMEngineImpl.Type2Message(paramString1);
      return getType3Message(paramString2, paramString3, paramString4, paramString5, paramString1.getChallenge(), paramString1.getFlags(), paramString1.getTarget(), paramString1.getTargetInfo());
    }
    return getType1Message(paramString4, paramString5);
  }
  
  public String getType1Message(String paramString1, String paramString2)
  {
    return new NTLMEngineImpl.Type1Message(paramString2, paramString1).getResponse();
  }
  
  public String getType3Message(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte1, int paramInt, String paramString5, byte[] paramArrayOfByte2)
  {
    return new NTLMEngineImpl.Type3Message(paramString4, paramString3, paramString1, paramString2, paramArrayOfByte1, paramInt, paramString5, paramArrayOfByte2).getResponse();
  }
  
  public void setCredentialCharset(String paramString)
  {
    credentialCharset = paramString;
  }
}
