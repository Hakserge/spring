package com.learnspring.learnspring.services;

import com.learnspring.learnspring.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findByAllTeacher();
    void SaveTeacher(Teacher teacher);
   Teacher getTeacherById(Long id);
   void deleteTeacherById(Long id);

}
