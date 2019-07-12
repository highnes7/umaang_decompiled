package f.fasterxml.jackson.core.json;

import f.fasterxml.jackson.core.'annotation'.GeneratorBase;
import f.fasterxml.jackson.core.JsonGenerationException;
import f.fasterxml.jackson.core.JsonGenerator;
import f.fasterxml.jackson.core.JsonGenerator.Feature;
import f.fasterxml.jackson.core.ObjectCodec;
import f.fasterxml.jackson.core.SerializableString;
import f.fasterxml.jackson.core.Version;
import f.fasterxml.jackson.core.impl.CharacterEscapes;
import f.fasterxml.jackson.core.impl.IOContext;
import f.fasterxml.jackson.core.impl.Utf8StreamParser;
import f.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import f.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class JsonGeneratorImpl
  extends GeneratorBase
{
  public static final int[] sOutputEscapes = Utf8StreamParser.sOutputEscapes128;
  public CharacterEscapes _characterEscapes;
  public final IOContext _ioContext;
  public int _maximumNonEscapedChar;
  public int[] _outputEscapes = sOutputEscapes;
  public SerializableString _rootValueSeparator = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
  
  public JsonGeneratorImpl(IOContext paramIOContext, int paramInt, ObjectCodec paramObjectCodec)
  {
    super(paramInt, paramObjectCodec);
    _ioContext = paramIOContext;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
  }
  
  public CharacterEscapes getCharacterEscapes()
  {
    return _characterEscapes;
  }
  
  public int getHighestEscapedChar()
  {
    return _maximumNonEscapedChar;
  }
  
  public JsonGenerator setCharacterEscapes(CharacterEscapes paramCharacterEscapes)
  {
    _characterEscapes = paramCharacterEscapes;
    if (paramCharacterEscapes == null)
    {
      _outputEscapes = sOutputEscapes;
      return this;
    }
    _outputEscapes = paramCharacterEscapes.getEscapeCodesForAscii();
    return this;
  }
  
  public JsonGenerator setHighestNonEscapedChar(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    _maximumNonEscapedChar = i;
    return this;
  }
  
  public JsonGenerator setRootValueSeparator(SerializableString paramSerializableString)
  {
    _rootValueSeparator = paramSerializableString;
    return this;
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public final void writeStringField(String paramString1, String paramString2)
    throws IOException, JsonGenerationException
  {
    writeFieldName(paramString1);
    writeString(paramString2);
  }
}
