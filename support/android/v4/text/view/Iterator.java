package support.android.v4.text.view;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import b.b.x.m.a.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import support.android.v4.util.R.drawable;

public final class Iterator
{
  public static final Comparator<c.a> count = new Version.BuildAwareOrder();
  public static final String[] end = new String[0];
  
  public Iterator() {}
  
  public static void addLinks(TextView paramTextView, java.util.regex.Pattern paramPattern, String paramString)
  {
    if (start())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, null, null);
  }
  
  public static void addLinks(TextView paramTextView, java.util.regex.Pattern paramPattern, String paramString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (start())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  public static void addLinks(TextView paramTextView, java.util.regex.Pattern paramPattern, String paramString, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (start())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return;
    }
    SpannableString localSpannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter))
    {
      paramTextView.setText(localSpannableString);
      makeClickable(paramTextView);
    }
  }
  
  public static void addLinks(ArrayList paramArrayList, Spannable paramSpannable, java.util.regex.Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    paramPattern = paramPattern.matcher(paramSpannable);
    while (paramPattern.find())
    {
      int i = paramPattern.start();
      int j = paramPattern.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        Artist localArtist = new Artist();
        url = makeUrl(paramPattern.group(0), paramArrayOfString, paramPattern, paramTransformFilter);
        start = i;
        end = j;
        paramArrayList.add(localArtist);
      }
    }
  }
  
  public static boolean addLinks(Spannable paramSpannable, int paramInt)
  {
    if (start()) {
      return Linkify.addLinks(paramSpannable, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject1 = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int i = localObject1.length - 1;
    while (i >= 0)
    {
      paramSpannable.removeSpan(localObject1[i]);
      i -= 1;
    }
    if ((paramInt & 0x4) != 0) {
      Linkify.addLinks(paramSpannable, 4);
    }
    localObject1 = new ArrayList();
    Object localObject2;
    if ((paramInt & 0x1) != 0)
    {
      localObject2 = R.drawable.geo;
      Linkify.MatchFilter localMatchFilter = Linkify.sUrlMatchFilter;
      addLinks((ArrayList)localObject1, paramSpannable, (java.util.regex.Pattern)localObject2, new String[] { "http://", "https://", "rtsp://" }, localMatchFilter, null);
    }
    if ((paramInt & 0x2) != 0) {
      addLinks((ArrayList)localObject1, paramSpannable, R.drawable.bitcoin, new String[] { "mailto:" }, null, null);
    }
    if ((paramInt & 0x8) != 0) {
      parse((ArrayList)localObject1, paramSpannable);
    }
    next((ArrayList)localObject1, paramSpannable);
    if (((ArrayList)localObject1).size() == 0) {
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((java.util.Iterator)localObject1).hasNext())
    {
      localObject2 = (Artist)((java.util.Iterator)localObject1).next();
      if (next == null) {
        applyLink(url, start, end, paramSpannable);
      }
    }
    return true;
  }
  
  public static boolean addLinks(Spannable paramSpannable, java.util.regex.Pattern paramPattern, String paramString)
  {
    if (start()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, null, null);
  }
  
  public static boolean addLinks(Spannable paramSpannable, java.util.regex.Pattern paramPattern, String paramString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (start()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  public static boolean addLinks(Spannable paramSpannable, java.util.regex.Pattern paramPattern, String paramString, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    if (start()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramArrayOfString != null)
    {
      paramString = paramArrayOfString;
      if (paramArrayOfString.length >= 1) {}
    }
    else
    {
      paramString = end;
    }
    String[] arrayOfString = new String[paramString.length + 1];
    arrayOfString[0] = str.toLowerCase(Locale.ROOT);
    int i = 0;
    while (i < paramString.length)
    {
      paramArrayOfString = paramString[i];
      i += 1;
      if (paramArrayOfString == null) {
        paramArrayOfString = "";
      } else {
        paramArrayOfString = paramArrayOfString.toLowerCase(Locale.ROOT);
      }
      arrayOfString[i] = paramArrayOfString;
    }
    paramPattern = paramPattern.matcher(paramSpannable);
    boolean bool1 = false;
    while (paramPattern.find())
    {
      i = paramPattern.start();
      int j = paramPattern.end();
      boolean bool2;
      if (paramMatchFilter != null) {
        bool2 = paramMatchFilter.acceptMatch(paramSpannable, i, j);
      } else {
        bool2 = true;
      }
      if (bool2)
      {
        applyLink(makeUrl(paramPattern.group(0), arrayOfString, paramPattern, paramTransformFilter), i, j, paramSpannable);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean addLinks(TextView paramTextView, int paramInt)
  {
    if (start()) {
      return Linkify.addLinks(paramTextView, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject = paramTextView.getText();
    if ((localObject instanceof Spannable))
    {
      if (addLinks((Spannable)localObject, paramInt))
      {
        makeClickable(paramTextView);
        return true;
      }
      return false;
    }
    localObject = SpannableString.valueOf((CharSequence)localObject);
    if (addLinks((Spannable)localObject, paramInt))
    {
      makeClickable(paramTextView);
      paramTextView.setText((CharSequence)localObject);
      return true;
    }
    return false;
  }
  
  public static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  public static String get(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return WebView.findAddress(paramString);
    }
    return Pattern.format(paramString);
  }
  
  public static void makeClickable(TextView paramTextView)
  {
    MovementMethod localMovementMethod = paramTextView.getMovementMethod();
    if (((localMovementMethod == null) || (!(localMovementMethod instanceof LinkMovementMethod))) && (paramTextView.getLinksClickable())) {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static String makeUrl(String paramString, String[] paramArrayOfString, Matcher paramMatcher, Linkify.TransformFilter paramTransformFilter)
  {
    String str = paramString;
    if (paramTransformFilter != null) {
      str = paramTransformFilter.transformUrl(paramMatcher, paramString);
    }
    int i = 0;
    for (;;)
    {
      j = paramArrayOfString.length;
      int k = 1;
      if (i >= j) {
        break;
      }
      if (str.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
      {
        j = k;
        paramString = str;
        if (str.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          break label146;
        }
        paramString = new StringBuilder();
        paramString.append(paramArrayOfString[i]);
        paramString.append(str.substring(paramArrayOfString[i].length()));
        paramString = paramString.toString();
        j = k;
        break label146;
      }
      i += 1;
    }
    int j = 0;
    paramString = str;
    label146:
    paramMatcher = paramString;
    if (j == 0)
    {
      paramMatcher = paramString;
      if (paramArrayOfString.length > 0) {
        paramMatcher = f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), paramArrayOfString[0], paramString);
      }
    }
    return paramMatcher;
  }
  
  public static void next(ArrayList paramArrayList, Spannable paramSpannable)
  {
    int i = paramSpannable.length();
    int j = 0;
    Object localObject = (URLSpan[])paramSpannable.getSpans(0, i, URLSpan.class);
    i = 0;
    Artist localArtist;
    while (i < localObject.length)
    {
      localArtist = new Artist();
      next = localObject[i];
      start = paramSpannable.getSpanStart(localObject[i]);
      end = paramSpannable.getSpanEnd(localObject[i]);
      paramArrayList.add(localArtist);
      i += 1;
    }
    Collections.sort(paramArrayList, count);
    int k = paramArrayList.size();
    i = j;
    while (i < k - 1)
    {
      localObject = (Artist)paramArrayList.get(i);
      int m = i + 1;
      localArtist = (Artist)paramArrayList.get(m);
      j = start;
      int n = start;
      if (j <= n)
      {
        int i1 = end;
        if (i1 > n)
        {
          int i2 = end;
          if (i2 <= i1) {}
          while (i1 - j > i2 - n)
          {
            j = m;
            break;
          }
          if (i1 - j < i2 - n) {
            j = i;
          } else {
            j = -1;
          }
          if (j != -1)
          {
            localObject = getnext;
            if (localObject != null) {
              paramSpannable.removeSpan(localObject);
            }
            paramArrayList.remove(j);
            k -= 1;
            continue;
          }
        }
      }
      i = m;
    }
  }
  
  /* Error */
  public static void parse(ArrayList paramArrayList, Spannable paramSpannable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 309	java/lang/Object:toString	()Ljava/lang/String;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_1
    //   8: invokestatic 311	support/android/v4/text/view/Iterator:get	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 6
    //   13: aload 6
    //   15: ifnull +123 -> 138
    //   18: aload_1
    //   19: aload 6
    //   21: invokevirtual 315	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore_3
    //   25: iload_3
    //   26: ifge +4 -> 30
    //   29: return
    //   30: new 6	support/android/v4/text/view/Artist
    //   33: dup
    //   34: invokespecial 92	support/android/v4/text/view/Artist:<init>	()V
    //   37: astore 5
    //   39: aload 6
    //   41: invokevirtual 262	java/lang/String:length	()I
    //   44: istore 4
    //   46: iload 4
    //   48: iload_3
    //   49: iadd
    //   50: istore 4
    //   52: aload 5
    //   54: iload_3
    //   55: iload_2
    //   56: iadd
    //   57: putfield 107	support/android/v4/text/view/Artist:start	I
    //   60: iload_2
    //   61: iload 4
    //   63: iadd
    //   64: istore_2
    //   65: aload 5
    //   67: iload_2
    //   68: putfield 109	support/android/v4/text/view/Artist:end	I
    //   71: aload_1
    //   72: iload 4
    //   74: invokevirtual 276	java/lang/String:substring	(I)Ljava/lang/String;
    //   77: astore_1
    //   78: aload 6
    //   80: ldc_w 317
    //   83: invokestatic 323	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 6
    //   88: new 268	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   95: astore 7
    //   97: aload 7
    //   99: ldc_w 325
    //   102: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 7
    //   108: aload 6
    //   110: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 7
    //   116: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 6
    //   121: aload 5
    //   123: aload 6
    //   125: putfield 104	support/android/v4/text/view/Artist:url	Ljava/lang/String;
    //   128: aload_0
    //   129: aload 5
    //   131: invokevirtual 115	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   134: pop
    //   135: goto -128 -> 7
    //   138: return
    //   139: astore_0
    //   140: return
    //   141: astore 5
    //   143: goto -136 -> 7
    //   146: astore_0
    //   147: return
    //   148: astore_0
    //   149: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramArrayList	ArrayList
    //   0	150	1	paramSpannable	Spannable
    //   6	62	2	i	int
    //   24	33	3	j	int
    //   44	29	4	k	int
    //   37	93	5	localArtist	Artist
    //   141	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   11	113	6	str	String
    //   95	20	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	13	139	java/lang/UnsupportedOperationException
    //   18	25	139	java/lang/UnsupportedOperationException
    //   30	46	139	java/lang/UnsupportedOperationException
    //   71	78	139	java/lang/UnsupportedOperationException
    //   78	88	141	java/io/UnsupportedEncodingException
    //   78	88	146	java/lang/UnsupportedOperationException
    //   88	121	148	java/lang/UnsupportedOperationException
    //   128	135	148	java/lang/UnsupportedOperationException
  }
  
  public static boolean start()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
}
