package py.una.pol.BGTP.Clasipar.utils.datos;

/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
public class DataUnit extends org.apache.thrift.TUnion<DataUnit, DataUnit._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DataUnit");
  private static final org.apache.thrift.protocol.TField ANUNCIO_FIELD_DESC = new org.apache.thrift.protocol.TField("anuncio", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PUBLICACION_FIELD_DESC = new org.apache.thrift.protocol.TField("publicacion", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ANUNCIO((short)1, "anuncio"),
    PUBLICACION((short)2, "publicacion");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ANUNCIO
          return ANUNCIO;
        case 2: // PUBLICACION
          return PUBLICACION;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ANUNCIO, new org.apache.thrift.meta_data.FieldMetaData("anuncio", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AnuncioProperty.class)));
    tmpMap.put(_Fields.PUBLICACION, new org.apache.thrift.meta_data.FieldMetaData("publicacion", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PublicacionEdge.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DataUnit.class, metaDataMap);
  }

  public DataUnit() {
    super();
  }

  public DataUnit(_Fields setField, java.lang.Object value) {
    super(setField, value);
  }

  public DataUnit(DataUnit other) {
    super(other);
  }
  public DataUnit deepCopy() {
    return new DataUnit(this);
  }

  public static DataUnit anuncio(AnuncioProperty value) {
    DataUnit x = new DataUnit();
    x.setAnuncio(value);
    return x;
  }

  public static DataUnit publicacion(PublicacionEdge value) {
    DataUnit x = new DataUnit();
    x.setPublicacion(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
    switch (setField) {
      case ANUNCIO:
        if (value instanceof AnuncioProperty) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type AnuncioProperty for field 'anuncio', but got " + value.getClass().getSimpleName());
      case PUBLICACION:
        if (value instanceof PublicacionEdge) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type PublicacionEdge for field 'publicacion', but got " + value.getClass().getSimpleName());
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected java.lang.Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case ANUNCIO:
          if (field.type == ANUNCIO_FIELD_DESC.type) {
            AnuncioProperty anuncio;
            anuncio = new AnuncioProperty();
            anuncio.read(iprot);
            return anuncio;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case PUBLICACION:
          if (field.type == PUBLICACION_FIELD_DESC.type) {
            PublicacionEdge publicacion;
            publicacion = new PublicacionEdge();
            publicacion.read(iprot);
            return publicacion;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case ANUNCIO:
        AnuncioProperty anuncio = (AnuncioProperty)value_;
        anuncio.write(oprot);
        return;
      case PUBLICACION:
        PublicacionEdge publicacion = (PublicacionEdge)value_;
        publicacion.write(oprot);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected java.lang.Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case ANUNCIO:
          AnuncioProperty anuncio;
          anuncio = new AnuncioProperty();
          anuncio.read(iprot);
          return anuncio;
        case PUBLICACION:
          PublicacionEdge publicacion;
          publicacion = new PublicacionEdge();
          publicacion.read(iprot);
          return publicacion;
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new org.apache.thrift.protocol.TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case ANUNCIO:
        AnuncioProperty anuncio = (AnuncioProperty)value_;
        anuncio.write(oprot);
        return;
      case PUBLICACION:
        PublicacionEdge publicacion = (PublicacionEdge)value_;
        publicacion.write(oprot);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case ANUNCIO:
        return ANUNCIO_FIELD_DESC;
      case PUBLICACION:
        return PUBLICACION_FIELD_DESC;
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public AnuncioProperty getAnuncio() {
    if (getSetField() == _Fields.ANUNCIO) {
      return (AnuncioProperty)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'anuncio' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setAnuncio(AnuncioProperty value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.ANUNCIO;
    value_ = value;
  }

  public PublicacionEdge getPublicacion() {
    if (getSetField() == _Fields.PUBLICACION) {
      return (PublicacionEdge)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'publicacion' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setPublicacion(PublicacionEdge value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.PUBLICACION;
    value_ = value;
  }

  public boolean isSetAnuncio() {
    return setField_ == _Fields.ANUNCIO;
  }


  public boolean isSetPublicacion() {
    return setField_ == _Fields.PUBLICACION;
  }


  public boolean equals(java.lang.Object other) {
    if (other instanceof DataUnit) {
      return equals((DataUnit)other);
    } else {
      return false;
    }
  }

  public boolean equals(DataUnit other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(DataUnit other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    java.util.List<java.lang.Object> list = new java.util.ArrayList<java.lang.Object>();
    list.add(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      list.add(setField.getThriftFieldId());
      java.lang.Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        list.add(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        list.add(value);
      }
    }
    return list.hashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
