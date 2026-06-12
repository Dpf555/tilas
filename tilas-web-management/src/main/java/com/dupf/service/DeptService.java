package com.dupf.service;

import com.dupf.pojo.Dept;
import com.dupf.pojo.Result;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);
}
