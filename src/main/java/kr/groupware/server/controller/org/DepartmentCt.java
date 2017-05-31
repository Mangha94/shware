package kr.groupware.server.controller.org;

import kr.groupware.model.rank.department.DepartmentData;
import kr.groupware.model.rank.department.DepartmentSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/org/rank/")
public class DepartmentCt {
    @Autowired
    DepartmentSv departmentSv;

    @RequestMapping(value = "/departmentList.do",method = RequestMethod.GET)
    public ModelAndView departmentList(){
        ModelAndView mv=new ModelAndView("org/rank/departmentList");
        List<DepartmentData> departmentList=departmentSv.getDepartments();
        mv.addObject("departmentList",departmentList);
        return mv;
    }

    @RequestMapping(value = "/reloadDepartment.do",method = RequestMethod.GET)
    public ModelAndView reloadDepartment(){
        ModelAndView mv=new ModelAndView("org/rank/reloadDepartment");
        List<DepartmentData> departmentList=departmentSv.getDepartments();
        mv.addObject("departmentList",departmentList);
        return mv;
    }

    @RequestMapping(value = "/addDepartment.do",method = RequestMethod.POST)
    public ModelAndView addDepartment(
            DepartmentData departmentData
    ){
        departmentSv.addDepartment(departmentData);
        return new ModelAndView("redirect:/org/rank/departmentList.do");
    }

    @RequestMapping(value="/modifyDepartment.do",method = RequestMethod.POST)
    public ModelAndView modifyDepartment(
            DepartmentData departmentData
    ){
        departmentSv.modifyDepartment(departmentData);
        return new ModelAndView("redirect:/org/rank/departmentList.do");
    }

    @RequestMapping(value = "/deleteDepartment.do",method = RequestMethod.GET)
    public ModelAndView deleteDepartment(
            @RequestParam(value = "departmentNo",required = false)int departmentNo
    )
    {
        departmentSv.deleteDepartment(departmentNo);
        return new ModelAndView("redirect:/org/rank/departmentList.do");
    }
}
