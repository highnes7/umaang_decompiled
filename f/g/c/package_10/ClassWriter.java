package f.g.c.package_10;

import f.g.c.a.b;

@b
public final class ClassWriter
{
  public static final byte A = 3;
  public static final byte ATTRIBUTE_DECL = 17;
  public static final byte BLOCKQUOTE = 26;
  public static final byte C = 31;
  public static final byte CLASS = 32;
  public static final byte CONNECTOR_PUNCTUATION = 23;
  public static final byte CONSTANT_InterfaceMethodref = 11;
  public static final byte CONSTANT_Long = 5;
  public static final byte CONSTANT_Methodref = 10;
  public static final byte CONSTANT_NameAndType = 12;
  public static final byte CONSTANT_String = 8;
  public static final byte DEFAULT_ZOOM_LEVEL_MAX = 22;
  public static final byte DOUBLE = 29;
  public static final byte E = 4;
  public static final byte FIELD = 2;
  public static final byte FLOAT = 127;
  public static final char I = '\000';
  public static final byte L = 0;
  public static final byte LONG = 1;
  public static final byte MISC_CHAN_1 = 20;
  public static final byte MODIFIER_SYMBOL = 27;
  public static final char O = '';
  public static final byte OTHER_PUNCTUATION = 24;
  public static final byte OTHER_SYMBOL = 28;
  public static final byte PRE = 30;
  public static final byte REOP_FLAT = 14;
  public static final byte REOP_FLAT1 = 15;
  public static final byte REOP_NONALNUM = 10;
  public static final byte SCRIPT = 19;
  public static final byte SECOND_OF_MINUTE = 21;
  public static final byte START_CDATA = 13;
  public static final byte SURROGATE = 19;
  public static final byte TYPE_MAX = 18;
  public static final byte f = 7;
  public static final byte g = 9;
  public static final byte n = 25;
  public static final byte s = 17;
  public static final byte version = 6;
  public static final byte x = 16;
  public static final byte y = 32;
  
  public ClassWriter() {}
  
  public static String a(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(get(paramString.charAt(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static char get(char paramChar)
  {
    char c = paramChar;
    if (isXMLLetter(paramChar)) {
      c = (char)(paramChar & 0x5F);
    }
    return c;
  }
  
  public static boolean isUpperCase(char paramChar)
  {
    return (paramChar >= 'A') && (paramChar <= 'Z');
  }
  
  public static boolean isXMLLetter(char paramChar)
  {
    return (paramChar >= 'a') && (paramChar <= 'z');
  }
  
  public static char toLowerCase(char paramChar)
  {
    char c = paramChar;
    if (isUpperCase(paramChar)) {
      c = (char)(paramChar ^ 0x20);
    }
    return c;
  }
  
  public static String toLowerCase(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(toLowerCase(paramString.charAt(i)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
