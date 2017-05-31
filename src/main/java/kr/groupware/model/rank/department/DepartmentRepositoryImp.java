package kr.groupware.model.rank.department;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImp extends SqlSessionDaoSupport implements DepartmentRepository{
    @Override
    public List<DepartmentData> getDepartments(){
        return getSqlSession().selectList("department.getDepartments");
    }

    @Override
    public DepartmentData getDepartment(int departmentNo){
        return getSqlSession().selectOne("department.getDepartment",departmentNo);
    }
    @Override
    public void addDepartment(DepartmentData departmentData){
        getSqlSession().insert("department.addDepartment",departmentData);
    }

    @Override
    public void modifyDepartment(DepartmentData departmentData){
        getSqlSession().update("department.modifyDepartment",departmentData);
    }

    @Override
    public void deleteDepartment(int departmentNo){
        getSqlSession().delete("department.deleteDepartment",departmentNo);
    }
}
