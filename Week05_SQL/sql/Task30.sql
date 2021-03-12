select stu.SNO,stu.Name,course.CourseName,choose.Score from
Student stu left join Choose choose
on stu.SNO = choose.SNO
left join Course course
on choose.CourseID=course.CourseID
order by stu.SNO;