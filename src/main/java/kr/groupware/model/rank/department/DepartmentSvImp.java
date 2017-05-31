package kr.groupware.model.rank.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentSvImp implements DepartmentSv{
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentData> getDepartments(){
        return departmentRepository.getDepartments();
    }

    @Override
    public DepartmentData getDepartment(int departmentNo){
        return departmentRepository.getDepartment(departmentNo);
    }

    @Override
    public void addDepartment(DepartmentData departmentData){
        departmentRepository.addDepartment(departmentData);
    }

    @Override
    public void modifyDepartment(DepartmentData departmentData){
        departmentRepository.modifyDepartment(departmentData);
    }

    @Override
    public void deleteDepartment(int departmentNo){
        departmentRepository.deleteDepartment(departmentNo);
    }
}
