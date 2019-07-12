package com.google.android.android.internal;

public final class zzexf
{
  public static String zzaq(zzeuk paramZzeuk)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramZzeuk.size());
    int i = 0;
    while (i < paramZzeuk.size())
    {
      int k = paramZzeuk.zzji(i);
      int j = k;
      String str;
      if (k != 34) {
        if (k != 39) {
          if (k != 92) {
            switch (k)
            {
            default: 
              if ((k < 32) || (k > 126))
              {
                localStringBuilder.append('\\');
                localStringBuilder.append((char)((k >>> 6 & 0x3) + 48));
                localStringBuilder.append((char)((k >>> 3 & 0x7) + 48));
                j = (k & 0x7) + 48;
              }
              localStringBuilder.append((char)j);
              break;
            case 13: 
              str = "\\r";
              break;
            case 12: 
              str = "\\f";
              break;
            case 11: 
              str = "\\v";
              break;
            case 10: 
              str = "\\n";
              break;
            case 9: 
              str = "\\t";
              break;
            case 8: 
              str = "\\b";
              break;
            case 7: 
              str = "\\a";
            }
          }
        }
      }
      for (;;)
      {
        localStringBuilder.append(str);
        break;
        str = "\\\\";
        continue;
        str = "\\'";
        continue;
        str = "\\\"";
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
