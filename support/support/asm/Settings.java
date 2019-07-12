package support.support.asm;

public class Settings
{
  public static final String PREFERENCE_AUTOSTART = "android.arch.lifecycle.ViewModelProvider.DefaultKey";
  public final Line adapter;
  public final Type state;
  
  public Settings(CurrencyUnit paramCurrencyUnit, Type paramType)
  {
    this(paramCurrencyUnit.getViewModelStore(), paramType);
  }
  
  public Settings(Line paramLine, Type paramType)
  {
    state = paramType;
    adapter = paramLine;
  }
  
  public Track build(Class paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
      localStringBuilder.append(str);
      return get(localStringBuilder.toString(), paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  public Track get(String paramString, Class paramClass)
  {
    Track localTrack = adapter.init(paramString);
    if (paramClass.isInstance(localTrack)) {
      return localTrack;
    }
    paramClass = state.create(paramClass);
    adapter.init(paramString, paramClass);
    return paramClass;
  }
}
