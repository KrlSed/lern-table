CREATE TABLE students (
    student_id UUID NOT NULL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    second_name VARCHAR(50) NOT NULL,
    note FLOAT8
);


CREATE TABLE teachers (
    teacher_id UUID NOT NULL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    second_name VARCHAR(50) NOT NULL,
    is_admin BOOLEAN
);


CREATE TABLE groups (
    group_id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    teacher_id UUID NOT NULL,
    students_id UUID NOT NULL
);

ALTER TABLE IF EXISTS students ADD CONSTRAINT student_unique_first_and_second_name UNIQUE (first_name, second_name);
ALTER TABLE IF EXISTS teachers ADD CONSTRAINT teacher_unique_first_and_second_name UNIQUE (first_name, second_name);

ALTER TABLE IF EXISTS groups ADD CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id);
ALTER TABLE IF EXISTS groups ADD CONSTRAINT fk_students FOREIGN KEY (students_id) REFERENCES students(student_id);

