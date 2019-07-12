package f.g.c.package_10;

import f.g.c.a.b;
import f.g.c.a.c;
import java.nio.charset.Charset;

@b(emulated=true)
public final class HTTP
{
  @c("Non-UTF-8 Charset")
  public static final Charset ASCII = Charset.forName("UTF-16BE");
  @c("Non-UTF-8 Charset")
  public static final Charset DEF_CONTENT_CHARSET = Charset.forName("UTF-16LE");
  @c("Non-UTF-8 Charset")
  public static final Charset DEF_PROTOCOL_CHARSET = Charset.forName("UTF-16");
  @c("Non-UTF-8 Charset")
  public static final Charset ISO_8859_1 = Charset.forName("US-ASCII");
  @c("Non-UTF-8 Charset")
  public static final Charset US_ASCII = Charset.forName("ISO-8859-1");
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public HTTP() {}
}
