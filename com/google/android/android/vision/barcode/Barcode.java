package com.google.android.android.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;

public class Barcode
  extends zzbck
{
  public static final int ALL_FORMATS = 0;
  public static final int AZTEC = 4096;
  public static final int CALENDAR_EVENT = 11;
  public static final int CODABAR = 8;
  public static final int CODE128_UCC = 10;
  public static final int CODE_128 = 1;
  public static final int CODE_39 = 2;
  public static final int CODE_93 = 4;
  public static final int CONTACT_INFO = 1;
  public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode> CREATOR = new DiscreteSeekBar.CustomState.1();
  public static final int DATA_MATRIX = 16;
  public static final int DRIVER_LICENSE = 12;
  public static final int EAN_13 = 32;
  public static final int EAN_8 = 64;
  public static final int EMAIL = 2;
  public static final int ISBN = 3;
  public static final int PDF417 = 2048;
  public static final int PHONE = 4;
  public static final int PLANET = 8;
  public static final int PRODUCT = 5;
  public static final int QR_CODE = 256;
  public static final int SUPP5 = 6;
  public static final int TEXT = 7;
  public static final int UPCE = 128;
  public static final int UPC_A = 512;
  public static final int UPC_E = 1024;
  public static final int WIFI = 9;
  public CalendarEvent calendarEvent;
  public ContactInfo contactInfo;
  public Point[] cornerPoints;
  public UrlBookmark data;
  public String displayValue;
  public DriverLicense driverLicense;
  public Email email;
  public int format;
  public GeoPoint geoPoint;
  public Sms id;
  public Phone phone;
  public String rawValue;
  public int valueFormat;
  public WiFi wifi;
  
  public Barcode() {}
  
  public Barcode(int paramInt1, String paramString1, String paramString2, int paramInt2, Point[] paramArrayOfPoint, Email paramEmail, Phone paramPhone, Sms paramSms, WiFi paramWiFi, UrlBookmark paramUrlBookmark, GeoPoint paramGeoPoint, CalendarEvent paramCalendarEvent, ContactInfo paramContactInfo, DriverLicense paramDriverLicense)
  {
    format = paramInt1;
    rawValue = paramString1;
    displayValue = paramString2;
    valueFormat = paramInt2;
    cornerPoints = paramArrayOfPoint;
    email = paramEmail;
    phone = paramPhone;
    id = paramSms;
    wifi = paramWiFi;
    data = paramUrlBookmark;
    geoPoint = paramGeoPoint;
    calendarEvent = paramCalendarEvent;
    contactInfo = paramContactInfo;
    driverLicense = paramDriverLicense;
  }
  
  public Rect getBoundingBox()
  {
    int n = Integer.MAX_VALUE;
    int j = 0;
    int k = Integer.MAX_VALUE;
    int m = Integer.MIN_VALUE;
    int i = Integer.MIN_VALUE;
    for (;;)
    {
      Object localObject = cornerPoints;
      if (j >= localObject.length) {
        break;
      }
      localObject = localObject[j];
      n = Math.min(n, x);
      m = Math.max(m, x);
      k = Math.min(k, y);
      i = Math.max(i, y);
      j += 1;
    }
    return new Rect(n, k, m, i);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 2, format);
    zzbcn.append(paramParcel, 3, rawValue, false);
    zzbcn.append(paramParcel, 4, displayValue, false);
    zzbcn.setCustomVar(paramParcel, 5, valueFormat);
    zzbcn.writeHeader(paramParcel, 6, cornerPoints, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 7, email, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 8, phone, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 9, id, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 10, wifi, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 11, data, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 12, geoPoint, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 13, calendarEvent, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 14, contactInfo, paramInt, false);
    zzbcn.addMenuItem(paramParcel, 15, driverLicense, paramInt, false);
    zzbcn.zzah(paramParcel, i);
  }
  
  public class Address
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.Address> CREATOR = new PaymentIntent.Output.1();
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String[] addressLines;
    public int type;
    
    public Address() {}
    
    public Address(String[] paramArrayOfString)
    {
      type = this$1;
      addressLines = paramArrayOfString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.setCustomVar(paramParcel, 2, type);
      zzbcn.a(paramParcel, 3, addressLines, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class CalendarDateTime
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.CalendarDateTime> CREATOR = new DownloadProgressInfo.1();
    public int hours;
    public boolean isUtc;
    public int minutes;
    public int month;
    public String rawValue;
    public int seconds;
    public int weekday;
    public int year;
    
    public CalendarDateTime() {}
    
    public CalendarDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, String paramString)
    {
      year = this$1;
      month = paramInt1;
      weekday = paramInt2;
      hours = paramInt3;
      minutes = paramInt4;
      seconds = paramInt5;
      isUtc = paramBoolean;
      rawValue = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.setCustomVar(paramParcel, 2, year);
      zzbcn.setCustomVar(paramParcel, 3, month);
      zzbcn.setCustomVar(paramParcel, 4, weekday);
      zzbcn.setCustomVar(paramParcel, 5, hours);
      zzbcn.setCustomVar(paramParcel, 6, minutes);
      zzbcn.setCustomVar(paramParcel, 7, seconds);
      zzbcn.onAction(paramParcel, 8, isUtc);
      zzbcn.append(paramParcel, 9, rawValue, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class CalendarEvent
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.CalendarEvent> CREATOR = new Point.1();
    public String description;
    public Barcode.CalendarDateTime length;
    public String location;
    public String organizer;
    public Barcode.CalendarDateTime start;
    public String status;
    
    public CalendarEvent() {}
    
    public CalendarEvent(String paramString1, String paramString2, String paramString3, String paramString4, Barcode.CalendarDateTime paramCalendarDateTime1, Barcode.CalendarDateTime paramCalendarDateTime2)
    {
      description = paramString1;
      location = paramString2;
      organizer = paramString3;
      status = paramString4;
      start = paramCalendarDateTime1;
      length = paramCalendarDateTime2;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = zzbcn.writeValue(paramParcel);
      zzbcn.append(paramParcel, 2, Barcode.this, false);
      zzbcn.append(paramParcel, 3, description, false);
      zzbcn.append(paramParcel, 4, location, false);
      zzbcn.append(paramParcel, 5, organizer, false);
      zzbcn.append(paramParcel, 6, status, false);
      zzbcn.addMenuItem(paramParcel, 7, start, paramInt, false);
      zzbcn.addMenuItem(paramParcel, 8, length, paramInt, false);
      zzbcn.zzah(paramParcel, i);
    }
  }
  
  public class ContactInfo
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.ContactInfo> CREATOR = new AddressAndLabel.1();
    public Barcode.Address[] addresses;
    public Barcode.Email[] emails;
    public String organization;
    public Barcode.Phone[] phones;
    public String title;
    public String[] urls;
    
    public ContactInfo() {}
    
    public ContactInfo(String paramString1, String paramString2, Barcode.Phone[] paramArrayOfPhone, Barcode.Email[] paramArrayOfEmail, String[] paramArrayOfString, Barcode.Address[] paramArrayOfAddress)
    {
      organization = paramString1;
      title = paramString2;
      phones = paramArrayOfPhone;
      emails = paramArrayOfEmail;
      urls = paramArrayOfString;
      addresses = paramArrayOfAddress;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = zzbcn.writeValue(paramParcel);
      zzbcn.addMenuItem(paramParcel, 2, Barcode.this, paramInt, false);
      zzbcn.append(paramParcel, 3, organization, false);
      zzbcn.append(paramParcel, 4, title, false);
      zzbcn.writeHeader(paramParcel, 5, phones, paramInt, false);
      zzbcn.writeHeader(paramParcel, 6, emails, paramInt, false);
      zzbcn.a(paramParcel, 7, urls, false);
      zzbcn.writeHeader(paramParcel, 8, addresses, paramInt, false);
      zzbcn.zzah(paramParcel, i);
    }
  }
  
  public class DriverLicense
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.DriverLicense> CREATOR = new PaymentIntent.1();
    public String addressCity;
    public String addressState;
    public String addressStreet;
    public String addressZip;
    public String birthDate;
    public String expiryDate;
    public String firstName;
    public String gender;
    public String issueDate;
    public String issuingCountry;
    public String lastName;
    public String licenseNumber;
    public String middleName;
    
    public DriverLicense() {}
    
    public DriverLicense(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
    {
      firstName = paramString1;
      middleName = paramString2;
      lastName = paramString3;
      gender = paramString4;
      addressStreet = paramString5;
      addressCity = paramString6;
      addressState = paramString7;
      addressZip = paramString8;
      licenseNumber = paramString9;
      issueDate = paramString10;
      expiryDate = paramString11;
      birthDate = paramString12;
      issuingCountry = paramString13;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.append(paramParcel, 2, Barcode.this, false);
      zzbcn.append(paramParcel, 3, firstName, false);
      zzbcn.append(paramParcel, 4, middleName, false);
      zzbcn.append(paramParcel, 5, lastName, false);
      zzbcn.append(paramParcel, 6, gender, false);
      zzbcn.append(paramParcel, 7, addressStreet, false);
      zzbcn.append(paramParcel, 8, addressCity, false);
      zzbcn.append(paramParcel, 9, addressState, false);
      zzbcn.append(paramParcel, 10, addressZip, false);
      zzbcn.append(paramParcel, 11, licenseNumber, false);
      zzbcn.append(paramParcel, 12, issueDate, false);
      zzbcn.append(paramParcel, 13, expiryDate, false);
      zzbcn.append(paramParcel, 14, birthDate, false);
      zzbcn.append(paramParcel, 15, issuingCountry, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class Email
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.Email> CREATOR = new SpecialListsDueExistsProperty.1();
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String address;
    public String body;
    public String subject;
    public int type;
    
    public Email() {}
    
    public Email(String paramString1, String paramString2, String paramString3)
    {
      type = this$1;
      address = paramString1;
      subject = paramString2;
      body = paramString3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.setCustomVar(paramParcel, 2, type);
      zzbcn.append(paramParcel, 3, address, false);
      zzbcn.append(paramParcel, 4, subject, false);
      zzbcn.append(paramParcel, 5, body, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class GeoPoint
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.GeoPoint> CREATOR = new AccountMirakel.2();
    public double elevation;
    public double longitude;
    
    public GeoPoint() {}
    
    public GeoPoint(double paramDouble)
    {
      longitude = this$1;
      elevation = paramDouble;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.writeDouble(paramParcel, 2, longitude);
      zzbcn.writeDouble(paramParcel, 3, elevation);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class PersonName
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.PersonName> CREATOR = new SpecialListsProgressProperty.1();
    public String first;
    public String last;
    public String middle;
    public String prefix;
    public String pronunciation;
    public String suffix;
    
    public PersonName() {}
    
    public PersonName(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      pronunciation = paramString1;
      prefix = paramString2;
      first = paramString3;
      middle = paramString4;
      last = paramString5;
      suffix = paramString6;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.append(paramParcel, 2, Barcode.this, false);
      zzbcn.append(paramParcel, 3, pronunciation, false);
      zzbcn.append(paramParcel, 4, prefix, false);
      zzbcn.append(paramParcel, 5, first, false);
      zzbcn.append(paramParcel, 6, middle, false);
      zzbcn.append(paramParcel, 7, last, false);
      zzbcn.append(paramParcel, 8, suffix, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class Phone
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.Phone> CREATOR = new SpecialListsListNameProperty.1();
    public static final int HOME = 2;
    public static final int MOBILE = 4;
    public static final int SORT_MENU_ITEM = 3;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String number;
    public int type;
    
    public Phone() {}
    
    public Phone(String paramString)
    {
      type = this$1;
      number = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.setCustomVar(paramParcel, 2, type);
      zzbcn.append(paramParcel, 3, number, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class Sms
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.Sms> CREATOR = new SpecialListsPriorityProperty.1();
    public String phoneNumber;
    
    public Sms() {}
    
    public Sms(String paramString)
    {
      phoneNumber = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.append(paramParcel, 2, Barcode.this, false);
      zzbcn.append(paramParcel, 3, phoneNumber, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class UrlBookmark
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.UrlBookmark> CREATOR = new SpecialList.4();
    public String contentDescription;
    
    public UrlBookmark() {}
    
    public UrlBookmark(String paramString)
    {
      contentDescription = paramString;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.append(paramParcel, 2, Barcode.this, false);
      zzbcn.append(paramParcel, 3, contentDescription, false);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
  
  public class WiFi
    extends zzbck
  {
    public static final Parcelable.Creator<com.google.android.gms.vision.barcode.Barcode.WiFi> CREATOR = new VerticalProgressBar.SavedState.1();
    public static final int OPEN = 1;
    public static final int SORT_MENU_ITEM = 3;
    public static final int TYPE_DIALOG = 2;
    public int encryptionType;
    public String password;
    
    public WiFi() {}
    
    public WiFi(String paramString, int paramInt)
    {
      password = paramString;
      encryptionType = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = zzbcn.writeValue(paramParcel);
      zzbcn.append(paramParcel, 2, Barcode.this, false);
      zzbcn.append(paramParcel, 3, password, false);
      zzbcn.setCustomVar(paramParcel, 4, encryptionType);
      zzbcn.zzah(paramParcel, paramInt);
    }
  }
}
