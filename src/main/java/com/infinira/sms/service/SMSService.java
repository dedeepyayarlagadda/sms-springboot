package com.infinira.sms.service;

import com.infinira.sms.dao.StudentDAO;

import java.util.List;

import com.infinira.sms.dao.DepartmentDAO;
import com.infinira.sms.model.Student;
import com.infinira.sms.model.Department;

public class SMSService implements ISMSService{
    
    private volatile SMSService smsService;
    
    private SMSService(){
        
    }
    
    public SMSService getInstance(){
        if(smsService != null){
            synchronized(SMSService.class){
                if(smsService != null){
                    smsService = new SMSService();
                }
            }
        }
        return smsService;
    }
    
    public int createStudent(Student student){
        return StudentDAO.create(student);
    }
    
    public  int updateStudent(Student student){
        return StudentDAO.update(student);
    }
    
    public  int deleteStudent(int studentId){
        return StudentDAO.delete(studentId);
    } 
    
    public Student getStudent(int studentId){
        return StudentDAO.getStudent(studentId);
    }
    
    public List<Student> getAllStudents(){
        return StudentDAO.getAllStudents();
    }

	@Override
	public int createDept(Department dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDept(Department dept) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDept(int deptId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Department getDept(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return null;
	}
    
   // public int createDept(Department dept){
       // DepartmentDAO.create(dept);
    //}
}