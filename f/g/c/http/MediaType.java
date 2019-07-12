package f.g.c.http;

import f.g.c.a.a;
import f.g.c.d.Ab;
import f.g.c.d.xb;
import f.g.c.package_10.Absent;
import f.g.c.package_10.ClassWriter;
import f.g.c.package_10.HTTP;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Joiner.MapJoiner;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Optional;
import f.g.c.package_10.Preconditions;
import f.g.c.package_8.Ab.a;
import f.g.c.package_8.EmptyImmutableListMultimap;
import f.g.c.package_8.ImmutableCollection;
import f.g.c.package_8.ImmutableListMultimap;
import f.g.c.package_8.ImmutableMap;
import f.g.c.package_8.ImmutableMultimap;
import f.g.c.package_8.ImmutableSet;
import f.g.c.package_8.Iterators;
import f.g.c.package_8.ListMultimap;
import f.g.c.package_8.Maps;
import f.g.c.package_8.Multimap;
import f.g.c.package_8.Multimaps;
import f.g.c.package_8.xb.a;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@a
@f.g.c.a.b
@m.a.a.b
public final class MediaType
{
  public static final MediaType ANY_APPLICATION_TYPE;
  public static final MediaType ANY_AUDIO_TYPE;
  public static final MediaType ANY_IMAGE_TYPE;
  public static final MediaType ANY_VIDEO_TYPE;
  public static final MediaType APPLICATION_BINARY;
  public static final String APPLICATION_TYPE = "application";
  public static final MediaType APPLICATION_XML_UTF_8;
  public static final MediaType ATOM_UTF_8;
  public static final String AUDIO_TYPE = "audio";
  public static final MediaType BMP;
  public static final MediaType BZIP2;
  public static final MediaType CACHE_MANIFEST_UTF_8;
  public static final MediaType CSS_UTF_8;
  public static final MediaType CSV_UTF_8;
  public static final MediaType FORM_DATA;
  public static final MediaType GIF;
  public static final MediaType GZIP;
  public static final MediaType HTML_UTF_8;
  public static final MediaType ICO;
  public static final String IMAGE_TYPE = "image";
  public static final MediaType I_CALENDAR_UTF_8;
  public static final MediaType JAVASCRIPT_UTF_8;
  public static final MediaType JPEG;
  public static final MediaType JSON_UTF_8;
  public static final MediaType KML;
  public static final MediaType KMZ;
  public static final Ab<f.g.c.i.h, f.g.c.i.h> KNOWN_TYPES;
  public static final MediaType MBOX;
  public static final MediaType MICROSOFT_EXCEL;
  public static final MediaType MICROSOFT_POWERPOINT;
  public static final MediaType MICROSOFT_WORD;
  public static final MediaType MP4_AUDIO;
  public static final MediaType MP4_VIDEO;
  public static final MediaType MPEG_AUDIO;
  public static final MediaType MPEG_VIDEO;
  public static final MediaType OCTET_STREAM;
  public static final MediaType OGG_AUDIO;
  public static final MediaType OGG_CONTAINER;
  public static final MediaType OGG_VIDEO;
  public static final MediaType OOXML_DOCUMENT;
  public static final MediaType OOXML_PRESENTATION;
  public static final MediaType OOXML_SHEET;
  public static final MediaType OPENDOCUMENT_GRAPHICS;
  public static final MediaType OPENDOCUMENT_PRESENTATION;
  public static final MediaType OPENDOCUMENT_SPREADSHEET;
  public static final MediaType OPENDOCUMENT_TEXT;
  public static final Joiner.MapJoiner PARAMETER_JOINER = new Joiner("; ").withKeyValueSeparator("=");
  public static final String PARAM_CHARSET = "charset";
  public static final MediaType PDF;
  public static final MediaType PLAIN_TEXT_UTF_8;
  public static final MediaType PNG;
  public static final MediaType POSTSCRIPT;
  public static final MediaType QUICKTIME;
  public static final MediaType RDF_XML_UTF_8;
  public static final MediaType RTF_UTF_8;
  public static final MediaType SHOCKWAVE_FLASH;
  public static final MediaType SKETCHUP;
  public static final MediaType SVG_UTF_8;
  public static final MediaType TAR;
  public static final MediaType TEXT_JAVASCRIPT_UTF_8;
  public static final String TEXT_TYPE = "text";
  public static final MediaType TIFF;
  public static final xb<String, String> UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of("charset", ClassWriter.toLowerCase(HTTP.UTF_8.name()));
  public static final String VIDEO_TYPE = "video";
  public static final MediaType WEBM_AUDIO;
  public static final MediaType WEBM_VIDEO;
  public static final MediaType WEBP;
  public static final String WILDCARD = "*";
  public static final MediaType WML_UTF_8;
  public static final MediaType WMV;
  public static final MediaType XHTML_UTF_8;
  public static final MediaType XML_UTF_8;
  public static final MediaType XRD_UTF_8;
  public static final f.g.c.package_10.h c = f.g.c.package_10.h.i.and(f.g.c.package_10.h.d.negate()).and(f.g.c.package_10.h.isNot(' ')).and(f.g.c.package_10.h.noneOf("()<>@,;:\\\"/[]?="));
  public static final f.g.c.package_10.h i = f.g.c.package_10.h.i.and(f.g.c.package_10.h.noneOf("\"\\\r"));
  public static final f.g.c.package_10.h r = f.g.c.package_10.h.anyOf(" \t\r\n");
  public final xb<String, String> parameters;
  public final String subtype;
  public final String type;
  
  static
  {
    QUICKTIME = createConstant("*", "*");
    WEBM_VIDEO = createConstant("text", "*");
    WMV = createConstant("image", "*");
    APPLICATION_XML_UTF_8 = createConstant("audio", "*");
    ATOM_UTF_8 = createConstant("video", "*");
    BZIP2 = createConstant("application", "*");
    FORM_DATA = createConstantUtf8("text", "cache-manifest");
    APPLICATION_BINARY = createConstantUtf8("text", "css");
    GZIP = createConstantUtf8("text", "csv");
    JAVASCRIPT_UTF_8 = createConstantUtf8("text", "html");
    JSON_UTF_8 = createConstantUtf8("text", "calendar");
    KML = createConstantUtf8("text", "plain");
    KMZ = createConstantUtf8("text", "javascript");
    MBOX = createConstantUtf8("text", "vcard");
    MICROSOFT_EXCEL = createConstantUtf8("text", "vnd.wap.wml");
    MICROSOFT_POWERPOINT = createConstantUtf8("text", "xml");
    MICROSOFT_WORD = createConstant("image", "bmp");
    OCTET_STREAM = createConstant("image", "gif");
    OGG_CONTAINER = createConstant("image", "vnd.microsoft.icon");
    OOXML_DOCUMENT = createConstant("image", "jpeg");
    OOXML_PRESENTATION = createConstant("image", "png");
    OOXML_SHEET = createConstantUtf8("image", "svg+xml");
    OPENDOCUMENT_GRAPHICS = createConstant("image", "tiff");
    OPENDOCUMENT_PRESENTATION = createConstant("image", "webp");
    OPENDOCUMENT_SPREADSHEET = createConstant("audio", "mp4");
    OPENDOCUMENT_TEXT = createConstant("audio", "mpeg");
    PDF = createConstant("audio", "ogg");
    POSTSCRIPT = createConstant("audio", "webm");
    RDF_XML_UTF_8 = createConstant("video", "mp4");
    RTF_UTF_8 = createConstant("video", "mpeg");
    SHOCKWAVE_FLASH = createConstant("video", "ogg");
    SKETCHUP = createConstant("video", "quicktime");
    TAR = createConstant("video", "webm");
    XHTML_UTF_8 = createConstant("video", "x-ms-wmv");
    XRD_UTF_8 = createConstantUtf8("application", "atom+xml");
    ANY_IMAGE_TYPE = createConstant("application", "x-bzip2");
    ANY_AUDIO_TYPE = createConstant("application", "x-www-form-urlencoded");
    ANY_VIDEO_TYPE = createConstant("application", "x-gzip");
    WML_UTF_8 = createConstantUtf8("application", "javascript");
    XML_UTF_8 = createConstantUtf8("application", "json");
    BMP = createConstant("application", "vnd.google-earth.kml+xml");
    GIF = createConstant("application", "vnd.google-earth.kmz");
    ICO = createConstant("application", "mbox");
    JPEG = createConstant("application", "vnd.ms-excel");
    PNG = createConstant("application", "vnd.ms-powerpoint");
    SVG_UTF_8 = createConstant("application", "msword");
    TIFF = createConstant("application", "octet-stream");
    WEBP = createConstant("application", "ogg");
    MP4_AUDIO = createConstant("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    MPEG_AUDIO = createConstant("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    OGG_AUDIO = createConstant("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    WEBM_AUDIO = createConstant("application", "vnd.oasis.opendocument.graphics");
    MP4_VIDEO = createConstant("application", "vnd.oasis.opendocument.presentation");
    MPEG_VIDEO = createConstant("application", "vnd.oasis.opendocument.spreadsheet");
    OGG_VIDEO = createConstant("application", "vnd.oasis.opendocument.text");
    ANY_APPLICATION_TYPE = createConstant("application", "pdf");
    CACHE_MANIFEST_UTF_8 = createConstant("application", "postscript");
    CSS_UTF_8 = createConstantUtf8("application", "rtf");
    CSV_UTF_8 = createConstant("application", "x-shockwave-flash");
    HTML_UTF_8 = createConstant("application", "vnd.sketchup.skp");
    I_CALENDAR_UTF_8 = createConstant("application", "x-tar");
    PLAIN_TEXT_UTF_8 = createConstantUtf8("application", "xhtml+xml");
    TEXT_JAVASCRIPT_UTF_8 = createConstant("application", "zip");
    Ab.a localA = new Ab.a();
    MediaType localMediaType = QUICKTIME;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = WEBM_VIDEO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = WMV;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = APPLICATION_XML_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = ATOM_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = BZIP2;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = FORM_DATA;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = APPLICATION_BINARY;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = GZIP;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = JAVASCRIPT_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = JSON_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = KML;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = KMZ;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MBOX;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MICROSOFT_EXCEL;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MICROSOFT_POWERPOINT;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MICROSOFT_WORD;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OCTET_STREAM;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OGG_CONTAINER;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OOXML_DOCUMENT;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OOXML_PRESENTATION;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OOXML_SHEET;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OPENDOCUMENT_GRAPHICS;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OPENDOCUMENT_PRESENTATION;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OPENDOCUMENT_SPREADSHEET;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OPENDOCUMENT_TEXT;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = PDF;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = POSTSCRIPT;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = RDF_XML_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = RTF_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = SHOCKWAVE_FLASH;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = SKETCHUP;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = TAR;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = XHTML_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = XRD_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = ANY_IMAGE_TYPE;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = ANY_AUDIO_TYPE;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = ANY_VIDEO_TYPE;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = WML_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = XML_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = BMP;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = GIF;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = ICO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = JPEG;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = PNG;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = SVG_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = TIFF;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = WEBP;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MP4_AUDIO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MPEG_AUDIO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OGG_AUDIO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = WEBM_AUDIO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MP4_VIDEO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = MPEG_VIDEO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = OGG_VIDEO;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = ANY_APPLICATION_TYPE;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = CACHE_MANIFEST_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = CSS_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = CSV_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = HTML_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = I_CALENDAR_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = PLAIN_TEXT_UTF_8;
    localA = localA.put(localMediaType, localMediaType);
    localMediaType = TEXT_JAVASCRIPT_UTF_8;
    KNOWN_TYPES = localA.put(localMediaType, localMediaType).build();
  }
  
  public MediaType(String paramString1, String paramString2, ImmutableListMultimap paramImmutableListMultimap)
  {
    type = paramString1;
    subtype = paramString2;
    parameters = paramImmutableListMultimap;
  }
  
  public static MediaType create(String paramString1, String paramString2)
  {
    return create(paramString1, paramString2, EmptyImmutableListMultimap.INSTANCE);
  }
  
  public static MediaType create(String paramString1, String paramString2, Multimap paramMultimap)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        if (paramMultimap != null)
        {
          paramString1 = normalizeToken(paramString1);
          paramString2 = normalizeToken(paramString2);
          boolean bool;
          if (("*".equals(paramString1)) && (!"*".equals(paramString2))) {
            bool = false;
          } else {
            bool = true;
          }
          Preconditions.checkArgument(bool, "A wildcard type cannot be used with a non-wildcard subtype");
          xb.a localA = new xb.a();
          paramMultimap = paramMultimap.entries().iterator();
          while (paramMultimap.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramMultimap.next();
            String str = normalizeToken((String)localEntry.getKey());
            localA.put(str, normalizeParameterValue(str, (String)localEntry.getValue()));
          }
          paramString1 = new MediaType(paramString1, paramString2, localA.build());
          return (MediaType)Objects.firstNonNull(KNOWN_TYPES.get(paramString1), paramString1);
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    paramString1 = new NullPointerException();
    throw paramString1;
  }
  
  public static MediaType createApplicationType(String paramString)
  {
    return create("application", paramString);
  }
  
  public static MediaType createAudioType(String paramString)
  {
    return create("audio", paramString);
  }
  
  public static MediaType createConstant(String paramString1, String paramString2)
  {
    return new MediaType(paramString1, paramString2, EmptyImmutableListMultimap.INSTANCE);
  }
  
  public static MediaType createConstantUtf8(String paramString1, String paramString2)
  {
    return new MediaType(paramString1, paramString2, UTF_8_CONSTANT_PARAMETERS);
  }
  
  public static MediaType createImageType(String paramString)
  {
    return create("image", paramString);
  }
  
  public static MediaType createTextType(String paramString)
  {
    return create("text", paramString);
  }
  
  public static MediaType createVideoType(String paramString)
  {
    return create("video", paramString);
  }
  
  public static String escapeAndQuote(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 16);
    localStringBuilder.append('"');
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int j = 0;
    while (j < k)
    {
      char c1 = paramString[j];
      if ((c1 == '\r') || (c1 == '\\') || (c1 == '"')) {
        localStringBuilder.append('\\');
      }
      localStringBuilder.append(c1);
      j += 1;
    }
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  public static String normalizeParameterValue(String paramString1, String paramString2)
  {
    if ("charset".equals(paramString1)) {
      return ClassWriter.toLowerCase(paramString2);
    }
    return paramString2;
  }
  
  public static String normalizeToken(String paramString)
  {
    Preconditions.checkArgument(c.put(paramString));
    return ClassWriter.toLowerCase(paramString);
  }
  
  private Map parametersAsMap()
  {
    return Maps.transformValues(parameters.asMap(), new MediaType.1(this));
  }
  
  public static MediaType parse(String paramString)
  {
    if (paramString != null)
    {
      ByteVector localByteVector = new ByteVector(paramString);
      paramString = c;
      try
      {
        String str1 = localByteVector.get(paramString);
        localByteVector.add('/');
        paramString = c;
        String str2 = localByteVector.get(paramString);
        xb.a localA = new xb.a();
        for (;;)
        {
          boolean bool = localByteVector.add();
          if (!bool) {
            break;
          }
          localByteVector.add(';');
          paramString = r;
          localByteVector.add(paramString);
          paramString = c;
          String str3 = localByteVector.get(paramString);
          localByteVector.add('=');
          int j = localByteVector.get();
          if (34 == j)
          {
            localByteVector.add('"');
            paramString = new StringBuilder();
            for (;;)
            {
              j = localByteVector.get();
              if (34 == j) {
                break;
              }
              j = localByteVector.get();
              f.g.c.package_10.h localH;
              if (92 == j)
              {
                localByteVector.add('\\');
                localH = f.g.c.package_10.h.i;
                paramString.append(localByteVector.read(localH));
              }
              else
              {
                localH = i;
                paramString.append(localByteVector.get(localH));
              }
            }
            paramString = paramString.toString();
            localByteVector.add('"');
          }
          else
          {
            paramString = c;
            paramString = localByteVector.get(paramString);
          }
          localA.put(str3, paramString);
        }
        paramString = create(str1, str2, localA.build());
        return paramString;
      }
      catch (IllegalStateException paramString)
      {
        throw new IllegalArgumentException(paramString);
      }
    }
    paramString = new NullPointerException();
    throw paramString;
  }
  
  public MediaType create(Charset paramCharset)
  {
    if (paramCharset != null) {
      return withParameter("charset", paramCharset.name());
    }
    throw new NullPointerException();
  }
  
  public Optional create()
  {
    ImmutableSet localImmutableSet = ImmutableSet.copyOf(parameters.get("charset"));
    int j = localImmutableSet.size();
    if (j != 0)
    {
      if (j == 1) {
        return Optional.of(Charset.forName((String)Iterators.getOnlyElement(localImmutableSet.iterator())));
      }
      throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Multiple charset values defined: ", localImmutableSet));
    }
    return Absent.INSTANCE;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof MediaType))
    {
      paramObject = (MediaType)paramObject;
      return (type.equals(type)) && (subtype.equals(subtype)) && (parametersAsMap().equals(paramObject.parametersAsMap()));
    }
    return false;
  }
  
  public boolean hasWildcard()
  {
    return ("*".equals(type)) || ("*".equals(subtype));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { type, subtype, parametersAsMap() });
  }
  
  public boolean is(MediaType paramMediaType)
  {
    return ((type.equals("*")) || (type.equals(type))) && ((subtype.equals("*")) || (subtype.equals(subtype))) && (parameters.entries().containsAll(parameters.entries()));
  }
  
  public ImmutableListMultimap parameters()
  {
    return parameters;
  }
  
  public String subtype()
  {
    return subtype;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(type);
    localStringBuilder.append('/');
    localStringBuilder.append(subtype);
    if (!parameters.isEmpty())
    {
      localStringBuilder.append("; ");
      ListMultimap localListMultimap = Multimaps.transformValues(parameters, new Annotations.3(this));
      PARAMETER_JOINER.appendTo(localStringBuilder, localListMultimap.entries());
    }
    return localStringBuilder.toString();
  }
  
  public String type()
  {
    return type;
  }
  
  public MediaType withParameter(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        paramString1 = normalizeToken(paramString1);
        xb.a localA = new xb.a();
        Iterator localIterator = parameters.entries().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          if (!paramString1.equals(str)) {
            localA.put(str, localEntry.getValue());
          }
        }
        localA.put(paramString1, normalizeParameterValue(paramString1, paramString2));
        paramString1 = new MediaType(type, subtype, localA.build());
        return (MediaType)Objects.firstNonNull(KNOWN_TYPES.get(paramString1), paramString1);
      }
      throw new NullPointerException();
    }
    paramString1 = new NullPointerException();
    throw paramString1;
  }
  
  public MediaType withParameters(Multimap paramMultimap)
  {
    return create(type, subtype, paramMultimap);
  }
  
  public MediaType withoutParameters()
  {
    if (parameters.isEmpty()) {
      return this;
    }
    return create(type, subtype);
  }
}
