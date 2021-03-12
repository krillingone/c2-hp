select SNO from Choose
where CourseID='C1'
union distinct
select SNO from Choose
where CourseID='C3';

select distinct SNO from Choose
where CourseID='C1' or CourseID='C3';