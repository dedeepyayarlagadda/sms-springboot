package com.infinira.sms.model;
   
import java.sql.Date;
import java.sql.Timestamp;
import java.text.MessageFormat;
import com.infinira.sms.util.SMSUtil;

public class Department{
    
    private int deptId;
    private String deptName;
    private String deptHead;
    private String groupType;
    private int estYear;
    private Date created_time;
    private Date modified_time;
    
    public Department(String deptName){
        SMSUtil.validateString(deptName,"DepartmentName cannot be null or empty");
        this.deptName=deptName;
    }
    
    public void setId(int deptId){
		if(deptId == 0){
			throw new RuntimeException("DeptId cannot be null");
		}
        this.deptId=deptId;
    }
    
    public void setName(String deptName){
        SMSUtil.validateString(deptName,"DepartmentName cannot be null or empty");
        this.deptName=deptName;
    }
    
    public void setDeptHead(String deptHead){
        this.deptHead = deptHead;
    }
    
    public void setDeptGroupType(String groupType){
        this.groupType = groupType;
    }
    
    public void setEstYear(int Year){
        this.estYear = estYear;
    }
    
    public void setCreatedTime(Date createdTime){
        this.created_time=createdTime;
    }
    
    public void setModifiedTime(Date modifiedTime){
        this.modified_time=modified_time;
    }
    
    public int getId(){
        return deptId;
    }
    
    public String getName(){
        return deptName;
    }
    
    public String getDeptHead(){
        return deptHead;
    }
    
    public String getDeptGroupType(){
        return groupType;
    }
    
    public int getEstYear(){
        return estYear;
    }
     
    public Date getModifiedTime() {
        return modified_time;
    }
    
    public Date getCreatedTime() {
        return created_time;
    }
}