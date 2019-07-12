package android.support.v4.package_7;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v4.graphics.drawable.IconCompat;
import b.b.a.G;

public class Person
{
  public static final String ICON_KEY = "icon";
  public static final String IS_BOT_KEY = "isBot";
  public static final String IS_IMPORTANT_KEY = "isImportant";
  public static final String KEY_KEY = "key";
  public static final String NAME_KEY = "name";
  public static final String URI_KEY = "uri";
  @G
  public IconCompat mIcon;
  public boolean mIsBot;
  public boolean mIsImportant;
  @G
  public String mKey;
  @G
  public CharSequence mName;
  @G
  public String mUri;
  
  public Person(Builder paramBuilder)
  {
    mName = mName;
    mIcon = mIcon;
    mUri = mUri;
    mKey = mKey;
    mIsBot = mIsBot;
    mIsImportant = mIsImportant;
  }
  
  public static Person fromAndroidPerson(android.app.Person paramPerson)
  {
    Builder localBuilder = new Builder().setName(paramPerson.getName());
    IconCompat localIconCompat;
    if (paramPerson.getIcon() != null) {
      localIconCompat = IconCompat.c(paramPerson.getIcon());
    } else {
      localIconCompat = null;
    }
    return localBuilder.setIcon(localIconCompat).setUri(paramPerson.getUri()).setKey(paramPerson.getKey()).setBot(paramPerson.isBot()).setImportant(paramPerson.isImportant()).build();
  }
  
  public static Person fromBundle(Bundle paramBundle)
  {
    Object localObject = paramBundle.getBundle("icon");
    Builder localBuilder = new Builder().setName(paramBundle.getCharSequence("name"));
    if (localObject != null) {
      localObject = IconCompat.setValue((Bundle)localObject);
    } else {
      localObject = null;
    }
    return localBuilder.setIcon((IconCompat)localObject).setUri(paramBundle.getString("uri")).setKey(paramBundle.getString("key")).setBot(paramBundle.getBoolean("isBot")).setImportant(paramBundle.getBoolean("isImportant")).build();
  }
  
  public IconCompat getIcon()
  {
    return mIcon;
  }
  
  public String getKey()
  {
    return mKey;
  }
  
  public CharSequence getName()
  {
    return mName;
  }
  
  public String getUri()
  {
    return mUri;
  }
  
  public boolean isBot()
  {
    return mIsBot;
  }
  
  public boolean isImportant()
  {
    return mIsImportant;
  }
  
  public android.app.Person toAndroidPerson()
  {
    android.app.Person.Builder localBuilder = new android.app.Person.Builder().setName(getName());
    Icon localIcon;
    if (getIcon() != null) {
      localIcon = getIcon().remove();
    } else {
      localIcon = null;
    }
    return localBuilder.setIcon(localIcon).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
  }
  
  public Builder toBuilder()
  {
    return new Builder();
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putCharSequence("name", mName);
    Object localObject = mIcon;
    if (localObject != null) {
      localObject = ((IconCompat)localObject).toBundle();
    } else {
      localObject = null;
    }
    localBundle.putBundle("icon", (Bundle)localObject);
    localBundle.putString("uri", mUri);
    localBundle.putString("key", mKey);
    localBundle.putBoolean("isBot", mIsBot);
    localBundle.putBoolean("isImportant", mIsImportant);
    return localBundle;
  }
  
  public class Builder
  {
    @G
    public IconCompat mIcon;
    public boolean mIsBot;
    public boolean mIsImportant;
    @G
    public String mKey;
    @G
    public CharSequence mName;
    @G
    public String mUri;
    
    public Builder() {}
    
    public Builder()
    {
      mName = mName;
      mIcon = mIcon;
      mUri = mUri;
      mKey = mKey;
      mIsBot = mIsBot;
      mIsImportant = mIsImportant;
    }
    
    public Person build()
    {
      return new Person(this);
    }
    
    public Builder setBot(boolean paramBoolean)
    {
      mIsBot = paramBoolean;
      return this;
    }
    
    public Builder setIcon(IconCompat paramIconCompat)
    {
      mIcon = paramIconCompat;
      return this;
    }
    
    public Builder setImportant(boolean paramBoolean)
    {
      mIsImportant = paramBoolean;
      return this;
    }
    
    public Builder setKey(String paramString)
    {
      mKey = paramString;
      return this;
    }
    
    public Builder setName(CharSequence paramCharSequence)
    {
      mName = paramCharSequence;
      return this;
    }
    
    public Builder setUri(String paramString)
    {
      mUri = paramString;
      return this;
    }
  }
}
