package com.wip.dao;
import java.util.List;

import com.wip.exception.DepartmentNotFoundException;
import com.wip.model.Dept;
	public interface DeptDao {
	    void addDept(Dept dept);
	    Dept getDeptById(int id) throws DepartmentNotFoundException;
	    List<Dept> getAllDepts();
	    void updateDept(Dept dept) throws DepartmentNotFoundException;
	    void deleteDept(int id) throws DepartmentNotFoundException;
	}

