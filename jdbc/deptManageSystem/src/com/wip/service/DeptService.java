package com.wip.service;
import java.util.List;
import com.wip.dao.*;

import com.wip.dao.DeptDao;
import com.wip.exception.DepartmentNotFoundException;
import com.wip.model.Dept;
public class DeptService {
	    DeptDao dao = new DeptDaoImp();

	    public void addDept(Dept dept) {
	        dao.addDept(dept);
	    }

	    public Dept getDeptById(int id) throws DepartmentNotFoundException {
	        Dept d = dao.getDeptById(id);
	        if (d == null)
	            throw new DepartmentNotFoundException("Department ID " + id + " not found.");
	        return d;
	    }

	    public List<Dept> getAllDepts() {
	        return dao.getAllDepts();
	    }

	    public void updateDept(Dept dept) throws DepartmentNotFoundException {
	        dao.updateDept(dept);
	    }

	    public void deleteDeptById(int id) throws DepartmentNotFoundException {
	        Dept d = dao.getDeptById(id);
	        if (d == null)
	            throw new DepartmentNotFoundException("Department ID " + id + " not found.");
	        dao.deleteDept(id);
	    }

	}

