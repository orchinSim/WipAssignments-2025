package com.wip.dao;
import com.wip.model.*;
import com.wip.exception.*;
import com.wip.exception.DepartmentNotFoundException;
import com.wip.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImp implements DeptDao {
	@Override
    public void addDept(Dept dept) {
        String sql = "INSERT INTO department (deptId, deptName, email, location) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dept.getDeptId());
            ps.setString(2, dept.getDeptName());
            ps.setString(3, dept.getEmail());
            ps.setString(4, dept.getLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Dept getDeptById(int id) throws DepartmentNotFoundException {
        String sql = "SELECT * FROM department WHERE deptId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Dept(
                    rs.getInt("deptId"),
                    rs.getString("deptName"),
                    rs.getString("email"),
                    rs.getString("location")
                );
            } else {
            	throw new DepartmentNotFoundException ("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new DepartmentNotFoundException("Error fetching department: " + e.getMessage());
        }
    }

    @Override
    public List<Dept> getAllDepts() {
        List<Dept> list = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dept d = new Dept(
                    rs.getInt("deptId"),
                    rs.getString("deptName"),
                    rs.getString("email"),
                    rs.getString("location")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateDept(Dept dept) throws DepartmentNotFoundException 
{
        String sql = "UPDATE department SET deptName = ?, email = ?, location = ? WHERE deptId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
        	ps.setInt(1, dept.getDeptId());
        	ps.setString(2, dept.getDeptName());
        	ps.setString(3, dept.getEmail());
        	ps.setString(4, dept.getLocation());
        	
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DepartmentNotFoundException("Department with ID " + dept.getDeptId() + " not found.");
            }
        } catch (SQLException e) {
            throw new DepartmentNotFoundException("Error updating department: " + e.getMessage());
        }
    }

    @Override
    public void deleteDept(int id) throws DepartmentNotFoundException  {
        String sql = "DELETE FROM department WHERE deptId = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
            	throw new DepartmentNotFoundException  ("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new DepartmentNotFoundException("Error deleting department: " + e.getMessage());
        }
    }
}




