package android.support.design.resources;

public class TextAppearanceConfig
{
  public static boolean shouldLoadFontSynchronously;
  
  public TextAppearanceConfig() {}
  
  public static void setShouldLoadFontSynchronously(boolean paramBoolean)
  {
    shouldLoadFontSynchronously = paramBoolean;
  }
  
  public static boolean shouldLoadFontSynchronously()
  {
    return shouldLoadFontSynchronously;
  }
}
