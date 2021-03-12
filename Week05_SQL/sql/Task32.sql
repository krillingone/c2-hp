select SNO,Score from Choose
where CourseID='C1' and
Score<(
	select Score from Choose c,Student s
	where c.SNO=s.SNO and Name='张三' and CourseID='C1'
);