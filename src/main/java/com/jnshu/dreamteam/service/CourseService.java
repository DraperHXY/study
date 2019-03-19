package com.jnshu.dreamteam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.dreamteam.pojo.Course;

import java.util.List;

/**
 * 课程相关接口
 * @author yrx
 */
public interface CourseService {
    /**
     * 查询全部课程数据
     * @return 课程列表
     */
    List<Course> selectAllCourse();

    /**
     * 新增课程
     * @param course 新增课程信息
     * @return 返回值为新增课程的id
     */
    Long addCourse(Course course);

    /**
     * 根据id选择相应课程
     * @param id 课程id
     * @return 返回值为课程所有信息
     */
    Course selectCourseById(Long id);

    /**
     * 根据课程id 修改相应信息
     * @param course 修改的课程信息 id必须包含
     * @return 返回值为 true 修改成功 false 失败
     */
    Boolean updateCourse(Course course);


    /**
     * 模糊查询课程信息
     * @param iPage 分页相关对象
     * @param subjectName 科目名称
     * @param courseStatus 课程状态
     * @param courseName 课程名称
     * @return 返回值为符合模糊查询的分页数据
     */
    IPage<Course> selectCourseByFuzzy(IPage iPage,
                                     Integer subjectName,
                                     Integer courseStatus,
                                     String courseName);

}