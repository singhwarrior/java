// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: employees.proto

package org.demo.protobuf;

public final class DepartmentProto {
  private DepartmentProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Employee_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Employee_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Employee_PhoneNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Employee_PhoneNumber_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Department_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Department_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017employees.proto\"\311\001\n\010Employee\022\014\n\004name\030\001" +
      " \001(\t\022\n\n\002id\030\002 \001(\005\022\r\n\005email\030\003 \001(\t\022%\n\006phone" +
      "s\030\004 \003(\0132\025.Employee.PhoneNumber\032@\n\013PhoneN" +
      "umber\022\016\n\006number\030\001 \001(\t\022!\n\004type\030\002 \001(\0162\023.Em" +
      "ployee.PhoneType\"+\n\tPhoneType\022\n\n\006MOBILE\020" +
      "\000\022\010\n\004HOME\020\001\022\010\n\004WORK\020\002\"*\n\nDepartment\022\034\n\te" +
      "mployees\030\001 \003(\0132\t.EmployeeB&\n\021org.demo.pr" +
      "otobufB\017DepartmentProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Employee_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Employee_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Employee_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "Phones", });
    internal_static_Employee_PhoneNumber_descriptor =
      internal_static_Employee_descriptor.getNestedTypes().get(0);
    internal_static_Employee_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Employee_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", });
    internal_static_Department_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Department_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Department_descriptor,
        new java.lang.String[] { "Employees", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}