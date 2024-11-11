package com.infinira.sms.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.MessageFormat;
import com.infinira.sms.util.SMSUtil;

public class Student{
    
    private int studentID;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String motherName;    
    private String gender;
    private Date dob;
    private String address;
    private String nationality;
    private String studentPhone;
    private String fatherPhone;
    private String bloodGroup;
    private String email;
    private String identityType;
    private String identityNumber;
    private String taxId;
    private long stipend;
    private String accountId;
    private String accountName;
    private String ifscCode;
    private Date doj;
    private int deptId;
    private Date created_time;
    private Date modified_time;
    
    public Student(String firstName, String lastName,String fatherName,String motherName,String gender,Date dob){
        setFirstName(firstName);
        setLastName(lastName);
        setFatherName(fatherName);
        setMotherName(motherName);
        setDob(dob);
    }
       

	public void setStudentID(int studentID){
        if(studentID == 0){
            throw new RuntimeException(SMS_MSG_1013);
        }
        this.studentID = studentID;
    }
    
     public void setFirstName(String firstName){
        validateString(firstName,SMS_MSG_1014);
        this.firstName=firstName;
    }
    
    public void setLastName(String lastName){
        validateString(lastName,SMS_MSG_1015);
        this.lastName=lastName;
    }
    
    public void setFatherName(String fatherName) {
        validateString(fatherName,SMS_MSG_1016);
        this.fatherName = fatherName;
    }
    public void setMotherName(String motherName) {
    	validateString(motherName,SMS_MSG_1017);
        this.motherName = motherName;
		
	}
    
    public void setDob(Date dob) {
        if (dob == null) {
            throw new RuntimeException(SMS_MSG_1018);
        }
        this.dob = dob;
    }

    public void setDoj(Date doj) {
        if (doj == null) {
            throw new RuntimeException(SMS_MSG_1019);
        }
        if (doj.before(dob)) {
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1020, doj, dob));
        }
        this.doj = doj;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setStudentPhone(String Phone) {
        validateString(Phone, SMS_MSG_1021);
        this.studentPhone = Phone;
    }

    public void setFatherPhone(String Phone) {
        this.fatherPhone = Phone;
    }

    public void setEmail(String email) {
        validateString(email, SMS_MSG_1022);
        this.email = email;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setIdentity(String identityType, String identityNumber) {
        validateString(identityType, SMS_MSG_1023);
        validateString(identityNumber, SMS_MSG_1024);

        if (identityNumber.length() != 12) {
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1025, identityNumber));
        }
        this.identityNumber = identityNumber;
        this.identityType = identityType;
    }

    public void setTaxId(String taxId) {
        validateString(taxId, SMS_MSG_1026);
        this.taxId = taxId;
    }

    public void setStipend(long stipend) {
        this.stipend = stipend;
    }

    public void setAccountInfo(String accountId, String ifscCode, String accountName) {
        validateString(accountId, SMS_MSG_1027);
        validateString(ifscCode, SMS_MSG_1028);
        validateString(accountName, SMS_MSG_1029);

        if (accountId.length() < 6) {
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1029, accountId));
        }
        if (ifscCode.length() != 11) {
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1030, ifscCode));
        }
        if (accountName.length() < 2) {
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1031, accountName));
        }

        this.accountId = accountId;
        this.accountName = accountName;
        this.ifscCode = ifscCode;
    }

    public void setDeptId(int deptId) {
        if (deptId == 0) {
            throw new RuntimeException(SMS_MSG_1032);
        }
        this.deptId = deptId;
    }

    public void setCreatedTime(Date createdTime){
        this.created_time=createdTime;
    }
    
    public void setModifiedTime(Date modifiedTime){
        this.modified_time=modified_time;
    }
    
     public int getStudentId() {
        return studentID;
    }
   
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFatherName() {
        return fatherName;
    }
    
    public String getMotherName(){
        return motherName;
    }
    public String getGender() {
        return gender;
    }
    
    public Date getDob() {
        return dob;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public String getStudentPhone() {
        return studentPhone;
    }
    
    public String getFatherPhone() {
        return fatherPhone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getBloodGroup(){
        return bloodGroup;
    }
    public String getIdentityNumber() {
        return identityNumber;
    }
    
    public String getIdentityType() {
        return identityType;
    }
    
    public String getTaxId() {
        return taxId;
    }
    
    public long getStipend() {
        return stipend;
    }
        
    public String getAccountId() {
        return accountId;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    public String getIfscCode() {
        return ifscCode;
    }
            
    public Date getDoj() {
        return doj;
    }
        
    public int getDeptId(){
        return deptId;
    }
    
    public Date getModifiedTime() {
        return modified_time;
    }
    
    public Date getCreatedTime() {
        return created_time;
    }
    
    public static void validateString(String value, String mes){
        if(value == null || value.isEmpty()){
            throw new RuntimeException(mes);
        }        
    }
    
    public static final String SMS_MSG_1013 = "StudentID cannot be null or empty";
    public static final String SMS_MSG_1014 = "FirstName cannot be null or empty";
    public static final String SMS_MSG_1015 = "LastName cannot be null or empty";
    public static final String SMS_MSG_1016 = "FatherName cannot be null or empty";
    public static final String SMS_MSG_1017 = "MotherName cannot be null or empty";
    public static final String SMS_MSG_1018 = "DOB cannot be null";
    public static final String SMS_MSG_1019 = "DOJ cannot be null or empty";
    public static final String SMS_MSG_1020 = "DOJ {0} cannot be before DOB {1}";
    public static final String SMS_MSG_1021 = "StudentPhone cannot be null or empty";
    public static final String SMS_MSG_1022 = "Email cannot be null or empty";
    public static final String SMS_MSG_1023 = "IdentityType cannot be null or empty";
    public static final String SMS_MSG_1024 = "IdentityNumber cannot be null or empty";
    public static final String SMS_MSG_1025 = "Invalid Identity number: {0}, length of identityNumber should be 12 digits";
    public static final String SMS_MSG_1026 = "TaxId cannot be null or empty";
    public static final String SMS_MSG_1027 = "AccountId cannot be null or empty";
    public static final String SMS_MSG_1028 = "IFSC Code cannot be null or empty";
    public static final String SMS_MSG_1029 = "Invalid accountId: {0}, length of accountId should not be less than 5 digits";
    public static final String SMS_MSG_1030 = "Invalid IFSC Code: {0}, should be 11 digits";
    public static final String SMS_MSG_1031 = "Invalid Account Name: {0}, it should have 3 characters";
    public static final String SMS_MSG_1032 = "DepartmentId cannot be Null";
}