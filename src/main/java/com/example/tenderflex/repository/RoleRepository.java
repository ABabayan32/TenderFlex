package com.example.tenderflex.repository;

import com.example.tenderflex.model.Role;

import java.util.List;

public interface RoleRepository{
    Role getRoleById(Long id);
     List<Role > getAllRoles();
}
