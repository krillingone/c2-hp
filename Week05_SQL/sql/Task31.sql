select * from Student s1
where exists (
	select 1 from Student s2
	where s2.Name='张三' and s1.College=s2.College
);
