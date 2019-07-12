package f.fasterxml.jackson.core.util;

import f.d.a.a.g.c;
import f.d.a.a.g.d;
import f.d.a.a.p;
import f.fasterxml.jackson.core.JsonGenerationException;
import f.fasterxml.jackson.core.JsonGenerator;
import f.fasterxml.jackson.core.SerializableString;
import f.fasterxml.jackson.core.impl.SerializedString;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class DefaultPrettyPrinter
  implements p, d<c>, Serializable
{
  public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
  public static final long serialVersionUID = -5512586643324525213L;
  public Indenter _arrayIndenter = FixedSpaceIndenter.instance;
  public transient int _nesting = 0;
  public Indenter _objectIndenter = Lf2SpacesIndenter.instance;
  public final SerializableString _rootSeparator;
  public boolean _spacesInObjectEntries = true;
  
  public DefaultPrettyPrinter()
  {
    this(DEFAULT_ROOT_VALUE_SEPARATOR);
  }
  
  public DefaultPrettyPrinter(SerializableString paramSerializableString)
  {
    _rootSeparator = paramSerializableString;
  }
  
  public DefaultPrettyPrinter(DefaultPrettyPrinter paramDefaultPrettyPrinter)
  {
    this(paramDefaultPrettyPrinter, _rootSeparator);
  }
  
  public DefaultPrettyPrinter(DefaultPrettyPrinter paramDefaultPrettyPrinter, SerializableString paramSerializableString)
  {
    _arrayIndenter = _arrayIndenter;
    _objectIndenter = _objectIndenter;
    _spacesInObjectEntries = _spacesInObjectEntries;
    _nesting = _nesting;
    _rootSeparator = paramSerializableString;
  }
  
  public DefaultPrettyPrinter(String paramString)
  {
    this(paramString);
  }
  
  public void beforeArrayValues(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void beforeObjectEntries(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void indentArraysWith(Indenter paramIndenter)
  {
    Object localObject = paramIndenter;
    if (paramIndenter == null) {
      localObject = NopIndenter.instance;
    }
    _arrayIndenter = ((Indenter)localObject);
  }
  
  public void indentObjectsWith(Indenter paramIndenter)
  {
    Object localObject = paramIndenter;
    if (paramIndenter == null) {
      localObject = NopIndenter.instance;
    }
    _objectIndenter = ((Indenter)localObject);
  }
  
  public void spacesInObjectEntries(boolean paramBoolean)
  {
    _spacesInObjectEntries = paramBoolean;
  }
  
  public DefaultPrettyPrinter withRootSeparator()
  {
    return new DefaultPrettyPrinter(this, _rootSeparator);
  }
  
  public DefaultPrettyPrinter withRootSeparator(SerializableString paramSerializableString)
  {
    SerializableString localSerializableString = _rootSeparator;
    if (localSerializableString != paramSerializableString)
    {
      if ((paramSerializableString != null) && (paramSerializableString.equals(localSerializableString))) {
        return this;
      }
      return new DefaultPrettyPrinter(this, paramSerializableString);
    }
    return this;
  }
  
  public void writeArrayValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
    _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting -= 1;
    }
    if (paramInt > 0) {
      _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
    } else {
      paramJsonGenerator.writeRaw(' ');
    }
    paramJsonGenerator.writeRaw(']');
  }
  
  public void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (!_objectIndenter.isInline()) {
      _nesting -= 1;
    }
    if (paramInt > 0) {
      _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
    } else {
      paramJsonGenerator.writeRaw(' ');
    }
    paramJsonGenerator.writeRaw('}');
  }
  
  public void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
    _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (_spacesInObjectEntries)
    {
      paramJsonGenerator.writeRaw(" : ");
      return;
    }
    paramJsonGenerator.writeRaw(':');
  }
  
  public void writeRootValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    SerializableString localSerializableString = _rootSeparator;
    if (localSerializableString != null) {
      paramJsonGenerator.writeRaw(localSerializableString);
    }
  }
  
  public void writeStartArray(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting += 1;
    }
    paramJsonGenerator.writeRaw('[');
  }
  
  public void writeStartObject(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw('{');
    if (!_objectIndenter.isInline()) {
      _nesting += 1;
    }
  }
  
  public class FixedSpaceIndenter
    implements DefaultPrettyPrinter.Indenter, Serializable
  {
    public static FixedSpaceIndenter instance = new FixedSpaceIndenter();
    public static final long serialVersionUID = 1L;
    
    public FixedSpaceIndenter() {}
    
    public boolean isInline()
    {
      return true;
    }
    
    public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public abstract interface Indenter
  {
    public abstract boolean isInline();
    
    public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException, JsonGenerationException;
  }
  
  public class Lf2SpacesIndenter
    implements DefaultPrettyPrinter.Indenter, Serializable
  {
    public static final char[] SPACES;
    public static final int SPACE_COUNT = 64;
    public static final String SYS_LF;
    public static Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
    public static final long serialVersionUID = 1L;
    
    static
    {
      try
      {
        str1 = System.getProperty("line.separator");
      }
      catch (Throwable localThrowable)
      {
        String str1;
        String str2;
        for (;;) {}
      }
      str1 = null;
      str2 = str1;
      if (str1 == null) {
        str2 = "\n";
      }
      SYS_LF = str2;
      SPACES = new char[64];
      Arrays.fill(SPACES, ' ');
    }
    
    public Lf2SpacesIndenter() {}
    
    public boolean isInline()
    {
      return false;
    }
    
    public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeRaw(SYS_LF);
      if (paramInt > 0)
      {
        paramInt += paramInt;
        while (paramInt > 64)
        {
          paramJsonGenerator.writeRaw(SPACES, 0, 64);
          paramInt -= SPACES.length;
        }
        paramJsonGenerator.writeRaw(SPACES, 0, paramInt);
      }
    }
  }
  
  public class NopIndenter
    implements DefaultPrettyPrinter.Indenter, Serializable
  {
    public static NopIndenter instance = new NopIndenter();
    public static final long serialVersionUID = 1L;
    
    public NopIndenter() {}
    
    public boolean isInline()
    {
      return true;
    }
    
    public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt) {}
  }
}
