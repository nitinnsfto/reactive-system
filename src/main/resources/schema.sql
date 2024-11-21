create table EMPLOYEE
(
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    name  varchar(50),
    salary decimal
);
