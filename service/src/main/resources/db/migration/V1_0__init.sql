CREATE TABLE groups (
    group_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    teacher_id UUID,
    PRIMARY KEY (group_id)
);


CREATE TABLE students (
    student_id UUID NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    note FLOAT8,
    second_name VARCHAR(255) NOT NULL,
    group_id UUID,
    PRIMARY KEY (student_id)
);


CREATE TABLE teachers (
    teacher_id UUID NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    is_admin BOOLEAN NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    group_id UUID,
    PRIMARY KEY (teacher_id)
);


ALTER TABLE IF EXISTS groups ADD CONSTRAINT uk_group_name UNIQUE (name);
ALTER TABLE IF EXISTS students ADD CONSTRAINT UniqueFirstAndSecondName UNIQUE (first_name, second_name);
ALTER TABLE IF EXISTS teachers ADD CONSTRAINT TeacherUniqueFirstAndSecondName UNIQUE (first_name, second_name);

ALTER TABLE IF EXISTS groups ADD CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES teachers;
ALTER TABLE IF EXISTS students ADD CONSTRAINT fk_group_students FOREIGN KEY (group_id) REFERENCES groups;
