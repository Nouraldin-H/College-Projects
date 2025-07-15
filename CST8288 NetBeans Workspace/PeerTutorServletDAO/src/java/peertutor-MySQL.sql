/* For CST8288 - Assignment 1 */
/* For MySQL */
DROP DATABASE IF EXISTS peertutor;

CREATE DATABASE peertutor;

USE peertutor;

CREATE TABLE Course(
    CourseCode VARCHAR(7) NOT NULL PRIMARY KEY,
    CourseName VARCHAR(45) NOT NULL,
    CourseDescription TEXT NOT NULL
);

CREATE TABLE Experience(
    ExperienceID INT NOT NULL PRIMARY KEY,
    Description TEXT NOT NULL
);

CREATE TABLE Student(
    StudentID INT NOT NULL PRIMARY KEY,
    LastName VARCHAR(45) NOT NULL,
    FirstName VARCHAR(45) NOT NULL,
    Email VARCHAR(45),
    PhoneNumber VARCHAR(45)
);

CREATE TABLE PeerTutor(
    PeerTutorID INT NOT NULL PRIMARY KEY,
    LastName VARCHAR(45) NOT NULL,
    FirstName VARCHAR(45) NOT NULL,
    Email VARCHAR(45),
    PhoneNumber VARCHAR(15),
    Status VARCHAR(45) NOT NULL,
    Experience_ExperienceID INT NOT NULL,
    FOREIGN KEY (Experience_ExperienceID) REFERENCES Experience(ExperienceID)
);

CREATE TABLE TutoringSession(
    DateKey DATE NOT NULL,
    TimeKey TIME NOT NULL,
    StudentLastName VARCHAR(45) NOT NULL,
    TutoringSessionStatus INT NOT NULL,
    TutoringSessionTopic TEXT NOT NULL,
    PeerTutor_PeerTutorID INT NOT NULL,
    Course_CourseCode VARCHAR(7) NOT NULL,
    Student_StudentID INT NOT NULL,
    PRIMARY KEY (DateKey, TimeKey, PeerTutor_PeerTutorID, Course_CourseCode, Student_StudentID),
    FOREIGN KEY (PeerTutor_PeerTutorID) REFERENCES PeerTutor(PeerTutorID),
    FOREIGN KEY (Course_CourseCode) REFERENCES Course(CourseCode),
    FOREIGN KEY (Student_StudentID) REFERENCES Student(StudentID)
);

CREATE TABLE PeerTutorCourse(
    PeerTutor_PeerTutorID INT NOT NULL,
    Course_CourseCode VARCHAR(7) NOT NULL,
    PRIMARY KEY (PeerTutor_PeerTutorID, Course_CourseCode),
    FOREIGN KEY (PeerTutor_PeerTutorID) REFERENCES PeerTutor(PeerTutorID),
    FOREIGN KEY (Course_CourseCode) REFERENCES Course(CourseCode)
);

CREATE TABLE Grade(
    Student_StudentID INT NOT NULL,
    Course_CourseCode VARCHAR(7) NOT NULL,
    GradeCode VARCHAR(2) NOT NULL,
    PRIMARY KEY (Student_StudentID, Course_CourseCode),
    FOREIGN KEY (Student_StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (Course_CourseCode) REFERENCES Course(CourseCode)
);

CREATE TABLE StudentCourse(
    Student_StudentID INT NOT NULL,
    Course_CourseCode VARCHAR(7) NOT NULL,
    PRIMARY KEY (Student_StudentID, Course_CourseCode),
    FOREIGN KEY (Student_StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (Course_CourseCode) REFERENCES Course(CourseCode)
);

/* ------------------------------------ */

INSERT INTO Course
VALUES('CST8101', 'Computer Essentials', 'The essentials of computer software, hardware, and laptop management form the foundation for building further technical programming skills');
INSERT INTO Course
VALUES('CST8110', 'Introduction to Computer Programming', 'Introduction to algorithms and Object-Oriented software development. Use the Java programming language to develop programs which contain in');
INSERT INTO Course
VALUES('CST8215', 'Database', 'Students learn the fundamentals of Relational Databases design using Entity Relation diagrams, and use SQL to create, modify and query a dat...');
INSERT INTO Course
VALUES('CST8300', 'Achieving Success in Changing Environments', 'Rapid changes in technology have created personal and employment choices that challenge each of us to find our place as contributing citizen...');
INSERT INTO Course
VALUES('ENL1813', 'Communications I', 'Communication remains an essential skill sought by employers, regardless of discipline or field of study. Using a practical, vocation-orient... ');
INSERT INTO Course
VALUES('MAT8001', 'Technical Mathematics for Computer Science', 'The study of algebraic and transcendental functions is an essential prerequisite to Calculus. Students manipulate algebraic expressions, sol..');

INSERT INTO Student
VALUES(9016001, 'Mouse', 'Mickey', 'mics123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016002, 'Mouse', 'Minnie', 'min123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016003, 'Duck', 'Donald', 'don123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016004, 'Duck', 'Daisy', 'dai123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016005, 'Cow', 'Clarabelle', 'cla123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016006, 'Rabbit', 'Oswald', 'osw123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016007, 'McDuck', 'Scrooge', 'src123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016008, 'Horsecollar', 'Horace', 'rit123@livealgonquin.com', '613-555-1212');
INSERT INTO Student
VALUES(9016009, 'Mouse', 'Mortimer', 'mor123@livealgonquin.com', '613-555-1212');

INSERT INTO StudentCourse
VALUES (9016001, 'CST8101');

INSERT INTO StudentCourse
VALUES (9016002, 'CST8101');

INSERT INTO StudentCourse
VALUES (9016003, 'CST8110');

INSERT INTO StudentCourse
VALUES (9016004, 'CST8110');

INSERT INTO StudentCourse
VALUES (9016005,'CST8215');

INSERT INTO StudentCourse
VALUES (9016005,'CST8101');

INSERT INTO StudentCourse
VALUES (9016006, 'CST8215');

INSERT INTO StudentCourse
VALUES (9016006, 'CST8101');

INSERT INTO StudentCourse
VALUES (9016007, 'CST8300');

INSERT INTO StudentCourse
VALUES (9016007, 'CST8101');

INSERT INTO StudentCourse
VALUES (9016008, 'CST8300');

INSERT INTO StudentCourse
VALUES (9016008, 'CST8101');

INSERT INTO StudentCourse
VALUES (9016001, 'ENL1813');

INSERT INTO StudentCourse
VALUES (9016002, 'ENL1813');

INSERT INTO StudentCourse
VALUES (9016001, 'MAT8001');

INSERT INTO StudentCourse
VALUES (9016002, 'MAT8001');

INSERT INTO Experience
VALUES (1, 'KNOW BASIC COMPUTER HARDWARE AND SOFTWARE ESSENTIALS');

INSERT INTO PeerTutor
VALUES(1001, 'Mouse', 'Minnie', 'min123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);
INSERT INTO PeerTutor
VALUES(1002, 'Duck', 'Daisy', 'dai123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);
INSERT INTO PeerTutor
VALUES(1003, 'McDuck', 'Scrooge', 'src123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);
INSERT INTO PeerTutor
VALUES(1004, 'Horsecollar', 'Horace', 'rit123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);
INSERT INTO PeerTutor
VALUES(1005, 'Yap', 'Teddy','yap123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);
INSERT INTO PeerTutor
VALUES(1006, 'Mouse', 'Mortimer', 'mor123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);
INSERT INTO PeerTutor
VALUES(1007, 'Rabbit', 'Oswald', 'osw123@livealgonquin.com', '613-555-1212', 'CURRENT', 1);

INSERT INTO Grade
VALUES (9016005, 'CST8101', 'C');

INSERT INTO Grade
VALUES (9016006, 'CST8101', 'B');

INSERT INTO Grade
VALUES (9016007, 'CST8101', 'A');

INSERT INTO Grade
VALUES (9016008, 'CST8101', 'A-');

INSERT INTO PeerTutorCourse
VALUES (1004, 'CST8101');

INSERT INTO PeerTutorCourse
VALUES (1005, 'CST8101');

# SELECTS down here. Run individual statements
# SELECT * FROM Experience;
#  SELECT * FROM PeerTutorCourse; # 1004 and 1005, both CST8101.
# SELECT * FROM PeerTutor; # 1004 Horace Horsecollar and 1005 Teddy Yap.
# SELECT * FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID;

# Case 1
# SELECT COUNT(*) FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID WHERE PT.FirstName = Daisy AND PT.LastName = Duck; # 1005 for example
# SELECT * FROM PeerTutor PT WHERE PT.FirstName = Daisy AND PT.LastName = Duck; # 1005 for example

#
# SELECT * FROM PeerTutorCourse; SELECT * FROM Course;
# SELECT COUNT(*) FROM Course WHERE CourseCode = 'CST8101'; # CST8101 for example
# SELECT * FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.Email = PTC.PeerTutor_Email; # JOIN THREE TABLES

# SELECT * FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID JOIN Course C ON PTC.Course_CourseCode = C.CourseCode; # WHERE PT.PeerTutorID = ? AND C.CourseCode = ?;
# SELECT * FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID JOIN Course C ON PTC.Course_CourseCode = C.CourseCode JOIN StudentCourse SC ON C.CourseCode = SC.Course_CourseCode WHERE PT.FirstName = "Oswald" AND PT.LastName = "Rabbit" AND C.CourseCode = "CST8101";

# SELECT G.GradeCode, PT.FirstName, PT.LastName FROM PeerTutor PT JOIN Student S ON PT.Email = S.Email JOIN Grade G ON S.StudentID = G.Student_StudentID WHERE PT.PeerTutorID = 1007 AND G.Course_CourseCode = "CST8101";
# SELECT G.GradeCode, PT.FirstName, PT.LastName FROM PeerTutor PT JOIN Student S ON PT.Email = S.Email JOIN Grade G ON S.StudentID = G.Student_StudentID WHERE PT.PeerTutorID = 1004 AND G.Course_CourseCode = "CST8101";
#  SELECT * FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID JOIN Course C ON PTC.Course_CourseCode = C.CourseCode; # WHERE PT.Email = ? AND C.CourseCode = ?";
# SELECT PT.LastName, PT.FirstName, SC.Course_CourseCode, G.GradeCode FROM PeerTutor PT JOIN Student S ON S.LastName = PT.LastName JOIN StudentCourse SC ON SC.Student_StudentID = S.StudentID JOIN Grade G ON S.StudentID = G.Student_StudentID WHERE PT.LastName = "Rabbit" AND PT.FirstName = "Oswald" AND SC.Course_CourseCode = "CST8101";

# Case 5
# SELECT PT.FirstName, PT.LastName, PTC.Course_CourseCode FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID WHERE PTC.Course_CourseCode = "CST8101" AND PT.FirstName = "Horace" AND PT.LastName = "Horsecollar";

# Case 6
# SELECT PT.PeerTutorID, PT.LastName, PT.FirstName, PT.Email, PT.PhoneNumber FROM PeerTutor PT JOIN StudentCourse SC ON Student.StudentID = SC.Student_StudentID JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID JOIN Course C ON PTC.Course_CourseCode = C.CourseCode WHERE C.CourseCode = "CST8101";
# SELECT PT.PeerTutorID, PT.LastName, PT.FirstName, PT.Email, PT.PhoneNumber FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID WHERE PTC.Course_CourseCode = "CST8101";