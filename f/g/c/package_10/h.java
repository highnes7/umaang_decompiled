package f.g.c.package_10;

import f.g.c.b.ca;
import java.util.Arrays;

@f.g.c.a.a
@f.g.c.a.b
public abstract class h
  implements ca<Character>
{
  public static final h A;
  public static final h ANY = new Frame("CharMatcher.ANY");
  public static final h C = anyOf("\t\n\013\f\r ??????").or(inRange('?', '?')).or(inRange('?', '?')).withToString("CharMatcher.BREAKING_WHITESPACE").a();
  public static final h NONE = new MethodWriter("CharMatcher.NONE");
  public static final h WHITESPACE = new Type("CharMatcher.WHITESPACE");
  public static final h a;
  public static final h b;
  public static final h c;
  public static final h d;
  public static final h e;
  public static final h g;
  public static final h i = new a("CharMatcher.ASCII", '\000', '');
  public static final h m;
  public static final h u;
  public final String s;
  
  static
  {
    h localH = inRange('0', '9');
    char[] arrayOfChar = "??????????????????????????????".toCharArray();
    int k = arrayOfChar.length;
    int j = 0;
    while (j < k)
    {
      char c1 = arrayOfChar[j];
      localH = localH.or(inRange(c1, (char)(c1 + '\t')));
      j += 1;
    }
    b = localH.withToString("CharMatcher.DIGIT").a();
    a = new e("CharMatcher.JAVA_DIGIT");
    A = new FlurryAdSize("CharMatcher.JAVA_LETTER");
    u = new RRuleSchema.23("CharMatcher.JAVA_LETTER_OR_DIGIT");
    g = new b("CharMatcher.JAVA_UPPER_CASE");
    e = new Daemon.15("CharMatcher.JAVA_LOWER_CASE");
    d = inRange('\000', '\037').or(inRange('', '?')).withToString("CharMatcher.JAVA_ISO_CONTROL");
    c = inRange('\000', ' ').or(inRange('', '?')).or(is('?')).or(inRange('?', '?')).or(anyOf("????")).or(inRange('?', '?')).or(inRange('?', '?')).or(inRange('?', '?')).or(inRange('?', '?')).or(is('?')).or(inRange(55296, 63743)).or(anyOf("????")).withToString("CharMatcher.INVISIBLE").a();
    m = inRange('\000', '?').or(is('?')).or(inRange('?', '?')).or(is('?')).or(is('?')).or(inRange('?', '?')).or(inRange('?', '?')).or(inRange('?', '?')).or(inRange('?', '?')).or(inRange('?', '?')).or(inRange(64336, 65023)).or(inRange(65136, 65279)).or(inRange(65377, 65500)).withToString("CharMatcher.SINGLE_WIDTH").a();
  }
  
  public h()
  {
    s = "UnknownCharMatcher";
  }
  
  public h(String paramString)
  {
    s = paramString;
  }
  
  public static h a(Predicate paramPredicate)
  {
    if (paramPredicate != null)
    {
      if ((paramPredicate instanceof h)) {
        return (h)paramPredicate;
      }
      StringBuilder localStringBuilder = new StringBuilder("CharMatcher.forPredicate(");
      localStringBuilder.append(paramPredicate);
      localStringBuilder.append(')');
      return new i(localStringBuilder.toString(), paramPredicate);
    }
    throw new NullPointerException();
  }
  
  public static h anyOf(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          paramCharSequence = paramCharSequence.toString().toCharArray();
          Arrays.sort(paramCharSequence);
          localStringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
          localStringBuilder.append(paramCharSequence);
          localStringBuilder.append("\")");
          return new CharMatcher.11(localStringBuilder.toString(), paramCharSequence);
        }
        char c1 = paramCharSequence.charAt(0);
        char c2 = paramCharSequence.charAt(1);
        StringBuilder localStringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
        localStringBuilder.append(paramCharSequence);
        localStringBuilder.append("\")");
        return new Item(localStringBuilder.toString(), c1, c2);
      }
      return is(paramCharSequence.charAt(0));
    }
    return NONE;
  }
  
  public static h c(char paramChar1, char paramChar2, String paramString)
  {
    return new a(paramString, paramChar1, paramChar2);
  }
  
  public static h inRange(char paramChar1, char paramChar2)
  {
    boolean bool;
    if (paramChar2 >= paramChar1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    StringBuilder localStringBuilder = new StringBuilder("CharMatcher.inRange(");
    localStringBuilder.append(Integer.toHexString(paramChar1));
    localStringBuilder.append(", ");
    localStringBuilder.append(Integer.toHexString(paramChar2));
    localStringBuilder.append(")");
    return new a(localStringBuilder.toString(), paramChar1, paramChar2);
  }
  
  public static h is(char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder("CharMatcher.is(");
    localStringBuilder.append(Integer.toHexString(paramChar));
    localStringBuilder.append(")");
    return new CharMatcher.9(localStringBuilder.toString(), paramChar);
  }
  
  public static h isNot(char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder("CharMatcher.isNot(");
    localStringBuilder.append(Integer.toHexString(paramChar));
    localStringBuilder.append(")");
    return new CharMatcher.10(localStringBuilder.toString(), paramChar);
  }
  
  public static h noneOf(CharSequence paramCharSequence)
  {
    return anyOf(paramCharSequence).negate();
  }
  
  public int a(CharSequence paramCharSequence, int paramInt)
  {
    int j = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, j, "index");
    while (paramInt < j)
    {
      if (a(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public h a()
  {
    return Platform.c(this);
  }
  
  public String a(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int j = 0;
    while ((j < k) && (a(paramCharSequence.charAt(j)))) {
      j += 1;
    }
    k -= 1;
    while ((k > j) && (a(paramCharSequence.charAt(k)))) {
      k -= 1;
    }
    return paramCharSequence.subSequence(j, k + 1).toString();
  }
  
  public String a(CharSequence paramCharSequence, char paramChar)
  {
    int j = d(paramCharSequence);
    if (j == -1) {
      return paramCharSequence.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length());
    localStringBuilder.append(paramCharSequence.subSequence(0, j));
    localStringBuilder.append(paramChar);
    int k = j + 1;
    for (int n = 1; k < paramCharSequence.length(); n = j)
    {
      char c1 = paramCharSequence.charAt(k);
      if (a(c1))
      {
        j = n;
        if (n == 0)
        {
          localStringBuilder.append(paramChar);
          j = 1;
        }
      }
      else
      {
        localStringBuilder.append(c1);
        j = 0;
      }
      k += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int k = paramCharSequence2.length();
    if (k == 0) {
      return c(paramCharSequence1);
    }
    int j = 0;
    if (k == 1) {
      return replaceFrom(paramCharSequence1, paramCharSequence2.charAt(0));
    }
    paramCharSequence1 = paramCharSequence1.toString();
    int n = d(paramCharSequence1);
    k = n;
    if (n == -1) {
      return paramCharSequence1;
    }
    int i2 = paramCharSequence1.length();
    StringBuilder localStringBuilder = new StringBuilder(i2 * 3 / 2 + 16);
    int i1;
    do
    {
      localStringBuilder.append(paramCharSequence1, j, k);
      localStringBuilder.append(paramCharSequence2);
      n = k + 1;
      i1 = a(paramCharSequence1, n);
      k = i1;
      j = n;
    } while (i1 != -1);
    localStringBuilder.append(paramCharSequence1, n, i2);
    return localStringBuilder.toString();
  }
  
  public void a(g paramG)
  {
    int k;
    for (int j = 0;; k = (char)(j + 1))
    {
      if (a(j)) {
        paramG.append(j);
      }
      if (j == 65535) {
        return;
      }
    }
  }
  
  public abstract boolean a(char paramChar);
  
  public boolean add(Character paramCharacter)
  {
    return a(paramCharacter.charValue());
  }
  
  public h and(h paramH)
  {
    if (paramH != null) {
      return new CharMatcher.And(this, paramH);
    }
    throw new NullPointerException();
  }
  
  public int b(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length() - 1;
    while (j >= 0)
    {
      if (a(paramCharSequence.charAt(j))) {
        return j;
      }
      j -= 1;
    }
    return -1;
  }
  
  public h c()
  {
    Object localObject = d();
    int j = localObject.length;
    if (j == 0) {
      return NONE;
    }
    if (j == 1) {
      return is(localObject[0]);
    }
    if (j < 63) {
      return d.a((char[])localObject, toString());
    }
    if (j < 1023) {
      return o.a((char[])localObject, toString());
    }
    localObject = new g();
    a((g)localObject);
    return new l(this, toString(), (g)localObject);
  }
  
  public String c(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    int k = d(paramCharSequence);
    int j = k;
    if (k == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    k = 1;
    j += 1;
    for (;;)
    {
      if (j == paramCharSequence.length) {
        return new String(paramCharSequence, 0, j - k);
      }
      if (a(paramCharSequence[j]))
      {
        k += 1;
        break;
      }
      paramCharSequence[(j - k)] = paramCharSequence[j];
      j += 1;
    }
  }
  
  public int d(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int j = 0;
    while (j < k)
    {
      if (a(paramCharSequence.charAt(j))) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  public char[] d()
  {
    char[] arrayOfChar1 = new char[65536];
    int j = 0;
    int n;
    for (int k = 0; j <= 65535; k = n)
    {
      char c1 = (char)j;
      n = k;
      if (a(c1))
      {
        arrayOfChar1[k] = c1;
        n = k + 1;
      }
      j += 1;
    }
    char[] arrayOfChar2 = new char[k];
    System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, k);
    return arrayOfChar2;
  }
  
  public String doInBackground(CharSequence paramCharSequence)
  {
    int k = paramCharSequence.length();
    int j = 0;
    while ((j < k) && (a(paramCharSequence.charAt(j)))) {
      j += 1;
    }
    return paramCharSequence.subSequence(j, k).toString();
  }
  
  public String draw(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length() - 1;
    while ((j >= 0) && (a(paramCharSequence.charAt(j)))) {
      j -= 1;
    }
    return paramCharSequence.subSequence(0, j + 1).toString();
  }
  
  public String f(CharSequence paramCharSequence)
  {
    return negate().c(paramCharSequence);
  }
  
  public boolean get(CharSequence paramCharSequence)
  {
    return d(paramCharSequence) == -1;
  }
  
  public boolean i(CharSequence paramCharSequence)
  {
    return get(paramCharSequence) ^ true;
  }
  
  public h negate()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(".negate()");
    return new ByteVector(this, localStringBuilder.toString(), this);
  }
  
  public h or(h paramH)
  {
    if (paramH != null) {
      return new CharMatcher.Or(this, paramH);
    }
    throw new NullPointerException();
  }
  
  public boolean put(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length() - 1;
    while (j >= 0)
    {
      if (!a(paramCharSequence.charAt(j))) {
        return false;
      }
      j -= 1;
    }
    return true;
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = paramCharSequence.toString();
    int k = d(paramCharSequence);
    int j = k;
    if (k == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    paramCharSequence[k] = paramChar;
    for (;;)
    {
      k = j + 1;
      if (k >= paramCharSequence.length) {
        break;
      }
      j = k;
      if (a(paramCharSequence[k]))
      {
        paramCharSequence[k] = paramChar;
        j = k;
      }
    }
    return new String(paramCharSequence);
  }
  
  public String toString()
  {
    return s;
  }
  
  public h withToString(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public int write(CharSequence paramCharSequence)
  {
    int j = 0;
    int n;
    for (int k = 0; j < paramCharSequence.length(); k = n)
    {
      n = k;
      if (a(paramCharSequence.charAt(j))) {
        n = k + 1;
      }
      j += 1;
    }
    return k;
  }
  
  public String write(CharSequence paramCharSequence, char paramChar)
  {
    int j = negate().d(paramCharSequence);
    int n = j;
    if (j == -1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length());
    j = 0;
    while (n < paramCharSequence.length())
    {
      char c1 = paramCharSequence.charAt(n);
      if (a(c1))
      {
        j = 1;
      }
      else
      {
        int k = j;
        if (j != 0)
        {
          localStringBuilder.append(paramChar);
          k = 0;
        }
        localStringBuilder.append(c1);
        j = k;
      }
      n += 1;
    }
    return localStringBuilder.toString();
  }
}
