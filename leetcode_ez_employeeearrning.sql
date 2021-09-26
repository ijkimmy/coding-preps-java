CREATE TABLE Employee(
    Id int primary key,
    Name varchar(30),
    Salary int,
    ManagerId int references Id
);

SELECT a.Name AS 'Employee'
FROM Employee AS a, Employee AS b
WHERE a.ManagerId = b.Id AND a.Salary > b.Salary;

SELECT a.Name AS Employee
FROM Employee AS a JOIN Employee AS b
    ON a.ManagerId = b.Id AND a.Salary > b.Salary;