select SNO from Choose
where CourseID='C1'
union all
select SNO from Choose
where CourseID='C3';

select SNO from Choose
where CourseID='C1' or CourseID='C3';