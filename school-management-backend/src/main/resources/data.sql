-- Insert classes
INSERT INTO class (name) VALUES ('10A');
INSERT INTO class (name) VALUES ('10B');
INSERT INTO class (name) VALUES ('9A');

-- Insert teachers
INSERT INTO teacher (name) VALUES ('Mr. Smith');
INSERT INTO teacher (name) VALUES ('Ms. Johnson');
INSERT INTO teacher (name) VALUES ('Mr. Brown');
INSERT INTO teacher (name) VALUES ('Mrs. Davis');
INSERT INTO teacher (name) VALUES ('Ms. Miller');
INSERT INTO teacher (name) VALUES ('Mr. Taylor');
INSERT INTO teacher (name) VALUES ('Mrs. Anderson');
INSERT INTO teacher (name) VALUES ('Mr. Wilson');
INSERT INTO teacher (name) VALUES ('Ms. Garcia');
INSERT INTO teacher (name) VALUES ('Mr. Lee');

-- Insert teacher subjects (simplified, using a separate table for @ElementCollection)
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (1, 'Math');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (2, 'English');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (3, 'Science');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (4, 'History');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (4, 'Geography');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (5, 'Art');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (6, 'Physical Education');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (7, 'Music');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (8, 'Computer Science');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (9, 'Biology');
INSERT INTO teacher_subjects (teacher_id, subject) VALUES (10, 'Chemistry');

-- Insert timetable entries (simplified sample)
INSERT INTO timetable_entry (class_id, teacher_id, day_id, period, subject) VALUES (1, 1, 1, 1, 'Math');
INSERT INTO timetable_entry (class_id, teacher_id, day_id, period, subject) VALUES (1, 2, 1, 2, 'English');
INSERT INTO timetable_entry (class_id, teacher_id, day_id, period, subject) VALUES (1, 3, 1, 3, 'Science');
-- Add more as needed