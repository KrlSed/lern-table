INSERT INTO teachers (teacher_id, first_name, is_admin, second_name, group_id) VALUES
    ('0fd55bec-4579-475b-900c-347ec2425e65', 'Valeriy', TRUE, 'Tarkovsky', '6f9b81b3-1e78-4e51-8826-2d7e0d019e55'),
    ('5fd7b730-1baa-49b9-88fc-22508166776f', 'Kirill', FALSE, 'Bulgakov', '56efc886-b4f3-492c-aac5-a49c830728f2'),
    ('35301d93-b3c4-4c64-9f6a-51642fdff1fd', 'Nikita', TRUE, 'Durov', '140e9a5f-64b1-4016-bdba-ae278b73342f'),
    ('a9ca27f0-a699-49d7-8730-6c83590bd2ef', 'Kirill', TRUE, 'Aivazovsky', '1bbca5f5-15b8-49d5-b337-3cd066489cf2'),
    ('90d81dea-0f50-41eb-88c1-f104053d3f19', 'Anastasia', FALSE, 'Kuri', '195228ff-164e-4f7c-82fa-5e8e739eae6a');

INSERT INTO groups (group_id, name, teacher_id) VALUES
    ('6f9b81b3-1e78-4e51-8826-2d7e0d019e55', '0000001', '0fd55bec-4579-475b-900c-347ec2425e65'),
    ('56efc886-b4f3-492c-aac5-a49c830728f2', '0000002', '5fd7b730-1baa-49b9-88fc-22508166776f'),
    ('140e9a5f-64b1-4016-bdba-ae278b73342f', '0000003', '35301d93-b3c4-4c64-9f6a-51642fdff1fd'),
    ('1bbca5f5-15b8-49d5-b337-3cd066489cf2', '0000004', 'a9ca27f0-a699-49d7-8730-6c83590bd2ef'),
    ('195228ff-164e-4f7c-82fa-5e8e739eae6a', '0000005', '90d81dea-0f50-41eb-88c1-f104053d3f19');

INSERT INTO students (student_id, first_name, note, second_name, group_id) VALUES
    ('b3d5b53f-ae9a-4de4-85a2-d0c41cc8f343', 'Kirill', 9.5, 'Sedliarov', NULL),
    ('d2ad5452-49dc-4789-8b42-965f10d62cb2', 'Misha',  9.1, 'Karpeka', '6f9b81b3-1e78-4e51-8826-2d7e0d019e55'),
    ('0b0dd589-cea3-42da-bcc4-2a8e0930e4d5', 'Nikita', 8.7, 'Denkovsky', '6f9b81b3-1e78-4e51-8826-2d7e0d019e55'),
    ('40efc34b-efa2-4a56-b144-e961f4f7542f', 'Misha', 2.2, 'Gronsky', '140e9a5f-64b1-4016-bdba-ae278b73342f'),
    ('3b28b62f-779e-4c1d-a34e-fd0da640eff3', 'Anastasia', 5.4, 'Starostina', NULL);






