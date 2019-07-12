package f.libs.asm.menu;

public class Item
{
  public static final Item g = new Item(null, null, null);
  public final String b;
  public final String c;
  public final String d;
  
  public Item()
  {
    this(null, null, null);
  }
  
  public Item(String paramString1, String paramString2, String paramString3)
  {
    c = paramString1;
    b = paramString2;
    d = paramString3;
  }
  
  public boolean a()
  {
    return (c == null) && (b == null) && (d == null);
  }
}
