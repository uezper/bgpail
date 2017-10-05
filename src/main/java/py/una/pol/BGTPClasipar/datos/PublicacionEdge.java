/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-10-05")
public class PublicacionEdge implements org.apache.thrift.TBase<PublicacionEdge, PublicacionEdge._Fields>, java.io.Serializable, Cloneable, Comparable<PublicacionEdge> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PublicacionEdge");

  private static final org.apache.thrift.protocol.TField ANUNCIO_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("anuncio_id", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("user_id", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PublicacionEdgeStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PublicacionEdgeTupleSchemeFactory();

  public AnuncioID anuncio_id; // required
  public UserID user_id; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ANUNCIO_ID((short)1, "anuncio_id"),
    USER_ID((short)2, "user_id");

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
        case 1: // ANUNCIO_ID
          return ANUNCIO_ID;
        case 2: // USER_ID
          return USER_ID;
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

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ANUNCIO_ID, new org.apache.thrift.meta_data.FieldMetaData("anuncio_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AnuncioID.class)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("user_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UserID.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PublicacionEdge.class, metaDataMap);
  }

  public PublicacionEdge() {
  }

  public PublicacionEdge(
    AnuncioID anuncio_id,
    UserID user_id)
  {
    this();
    this.anuncio_id = anuncio_id;
    this.user_id = user_id;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public PublicacionEdge(PublicacionEdge other) {
    if (other.isSetAnuncio_id()) {
      this.anuncio_id = new AnuncioID(other.anuncio_id);
    }
    if (other.isSetUser_id()) {
      this.user_id = new UserID(other.user_id);
    }
  }

  public PublicacionEdge deepCopy() {
    return new PublicacionEdge(this);
  }

  @Override
  public void clear() {
    this.anuncio_id = null;
    this.user_id = null;
  }

  public AnuncioID getAnuncio_id() {
    return this.anuncio_id;
  }

  public PublicacionEdge setAnuncio_id(AnuncioID anuncio_id) {
    this.anuncio_id = anuncio_id;
    return this;
  }

  public void unsetAnuncio_id() {
    this.anuncio_id = null;
  }

  /** Returns true if field anuncio_id is set (has been assigned a value) and false otherwise */
  public boolean isSetAnuncio_id() {
    return this.anuncio_id != null;
  }

  public void setAnuncio_idIsSet(boolean value) {
    if (!value) {
      this.anuncio_id = null;
    }
  }

  public UserID getUser_id() {
    return this.user_id;
  }

  public PublicacionEdge setUser_id(UserID user_id) {
    this.user_id = user_id;
    return this;
  }

  public void unsetUser_id() {
    this.user_id = null;
  }

  /** Returns true if field user_id is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_id() {
    return this.user_id != null;
  }

  public void setUser_idIsSet(boolean value) {
    if (!value) {
      this.user_id = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ANUNCIO_ID:
      if (value == null) {
        unsetAnuncio_id();
      } else {
        setAnuncio_id((AnuncioID)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUser_id();
      } else {
        setUser_id((UserID)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ANUNCIO_ID:
      return getAnuncio_id();

    case USER_ID:
      return getUser_id();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ANUNCIO_ID:
      return isSetAnuncio_id();
    case USER_ID:
      return isSetUser_id();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof PublicacionEdge)
      return this.equals((PublicacionEdge)that);
    return false;
  }

  public boolean equals(PublicacionEdge that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_anuncio_id = true && this.isSetAnuncio_id();
    boolean that_present_anuncio_id = true && that.isSetAnuncio_id();
    if (this_present_anuncio_id || that_present_anuncio_id) {
      if (!(this_present_anuncio_id && that_present_anuncio_id))
        return false;
      if (!this.anuncio_id.equals(that.anuncio_id))
        return false;
    }

    boolean this_present_user_id = true && this.isSetUser_id();
    boolean that_present_user_id = true && that.isSetUser_id();
    if (this_present_user_id || that_present_user_id) {
      if (!(this_present_user_id && that_present_user_id))
        return false;
      if (!this.user_id.equals(that.user_id))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetAnuncio_id()) ? 131071 : 524287);
    if (isSetAnuncio_id())
      hashCode = hashCode * 8191 + anuncio_id.hashCode();

    hashCode = hashCode * 8191 + ((isSetUser_id()) ? 131071 : 524287);
    if (isSetUser_id())
      hashCode = hashCode * 8191 + user_id.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(PublicacionEdge other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetAnuncio_id()).compareTo(other.isSetAnuncio_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAnuncio_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.anuncio_id, other.anuncio_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUser_id()).compareTo(other.isSetUser_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_id, other.user_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("PublicacionEdge(");
    boolean first = true;

    sb.append("anuncio_id:");
    if (this.anuncio_id == null) {
      sb.append("null");
    } else {
      sb.append(this.anuncio_id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("user_id:");
    if (this.user_id == null) {
      sb.append("null");
    } else {
      sb.append(this.user_id);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (anuncio_id == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'anuncio_id' was not present! Struct: " + toString());
    }
    if (user_id == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'user_id' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
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

  private static class PublicacionEdgeStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PublicacionEdgeStandardScheme getScheme() {
      return new PublicacionEdgeStandardScheme();
    }
  }

  private static class PublicacionEdgeStandardScheme extends org.apache.thrift.scheme.StandardScheme<PublicacionEdge> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, PublicacionEdge struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ANUNCIO_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.anuncio_id = new AnuncioID();
              struct.anuncio_id.read(iprot);
              struct.setAnuncio_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.user_id = new UserID();
              struct.user_id.read(iprot);
              struct.setUser_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, PublicacionEdge struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.anuncio_id != null) {
        oprot.writeFieldBegin(ANUNCIO_ID_FIELD_DESC);
        struct.anuncio_id.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.user_id != null) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        struct.user_id.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class PublicacionEdgeTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public PublicacionEdgeTupleScheme getScheme() {
      return new PublicacionEdgeTupleScheme();
    }
  }

  private static class PublicacionEdgeTupleScheme extends org.apache.thrift.scheme.TupleScheme<PublicacionEdge> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, PublicacionEdge struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.anuncio_id.write(oprot);
      struct.user_id.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, PublicacionEdge struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.anuncio_id = new AnuncioID();
      struct.anuncio_id.read(iprot);
      struct.setAnuncio_idIsSet(true);
      struct.user_id = new UserID();
      struct.user_id.read(iprot);
      struct.setUser_idIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

