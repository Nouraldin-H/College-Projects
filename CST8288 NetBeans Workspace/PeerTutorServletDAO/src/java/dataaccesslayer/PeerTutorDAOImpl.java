package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobject.PeerTutor;

public class PeerTutorDAOImpl implements PeerTutorDAO {

    @Override
    public boolean isPeerTutorRegistered(PeerTutor peerTutor) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //boolean isRegistered = false;
        ArrayList<PeerTutor> peerTutors = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String sql = "SELECT * FROM PeerTutor WHERE FirstName = ? AND LastName = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, peerTutor.getFirstName());
            pstmt.setString(2, peerTutor.getLastName());

            rs = pstmt.executeQuery();

            if (rs.next()) {
//                int count = rs.getInt(1);
//                isRegistered = (count > 0);
                  return true;
            }
//            peerTutors = new ArrayList<PeerTutor>();
//            while (rs.next()) {
//                peerTutor.setPeerTutorID(rs.getInt("PeerTutorID"));
//                peerTutor.setFirstName(rs.getString("FirstName"));
//                peerTutor.setLastName(rs.getString("LastName"));
//                peerTutors.add(peerTutor);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean isCourseValid(String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isValid = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            String sql
                    = /*"SELECT * FROM PeerTutor ORDER BY PeerTutorID"*/ "SELECT * FROM Course WHERE CourseCode = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, courseCode);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                isValid = true;
            }
//            peerTutors = new ArrayList<PeerTutor>();
//            while (rs.next()) {
//                peerTutor.setPeerTutorID(rs.getInt("PeerTutorID"));
//                peerTutor.setFirstName(rs.getString("FirstName"));
//                peerTutor.setLastName(rs.getString("LastName"));
//                peerTutors.add(peerTutor);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return isValid;
    }

    @Override
    public boolean hasPeerTutorTakenCourse(PeerTutor peerTutor, String courseCode) {
        // TODO:  Add your code here.  Be sure to use try-catch-finally statement.
        //        Do not forget to close the resources used inside this method.
        // DO JOINS IN THREE TABLES IN THIS METHOD!
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean courseValid = isCourseValid(courseCode);
        //boolean hasTakenCourse = false;
        DataSource ds = new DataSource();

        if (!courseValid) {
            return false;
        } else {
            try {
                connection = ds.createConnection();
                String sql = "SELECT * FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID JOIN Course C ON PTC.Course_CourseCode = C.CourseCode WHERE PT.FirstName = ? AND PT.LastName = ? AND C.CourseCode = ?";
                String sql2 = "SELECT PT.LastName, PT.FirstName, SC.Course_CourseCode FROM PeerTutor PT JOIN Student S ON S.LastName = PT.LastName JOIN StudentCourse SC ON SC.Student_StudentID = S.StudentID WHERE PT.FirstName = ? AND PT.LastName = ? AND SC.Course_CourseCode = ?";
                statement = connection.prepareStatement(sql2);
                statement.setString(1, peerTutor.getFirstName()); // I couldn't use email since it's not declared in the program
                statement.setString(2, peerTutor.getLastName());
                statement.setString(3, courseCode);

                resultSet = statement.executeQuery();

                if (resultSet.next()) {
//                    int count = resultSet.getInt(1);
//                    hasTakenCourse = (count > 0);
                      return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            return false;
        }
    }

    @Override
    public String getPeerTutorLetterGradeForCourse(PeerTutor peerTutor, String courseCode) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String letterGrade = null;
        DataSource dataSource = new DataSource();

        try {
            connection = dataSource.createConnection();

            // SQL query with JOIN to get the letter grade for the specified peer tutor and course.
            String sql = "SELECT G.GradeCode FROM PeerTutor PT JOIN Student S ON PT.Email = S.Email JOIN Grade G ON S.StudentID = G.Student_StudentID WHERE PT.PeerTutorID = ? AND G.Course_CourseCode = ?";
            String sql2 = "SELECT PT.LastName, PT.FirstName, SC.Course_CourseCode, G.GradeCode FROM PeerTutor PT JOIN Student S ON S.LastName = PT.LastName JOIN StudentCourse SC ON SC.Student_StudentID = S.StudentID JOIN Grade G ON S.StudentID = G.Student_StudentID WHERE PT.LastName = ? AND PT.FirstName = ? AND SC.Course_CourseCode = ?";
            statement = connection.prepareStatement(sql2);
            statement.setString(1, peerTutor.getLastName());
            statement.setString(2, peerTutor.getFirstName());
            statement.setString(3, courseCode);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                letterGrade = resultSet.getString("GradeCode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return letterGrade;
    }

    @Override
    public boolean isCourseAlreadyAssignedToPeerTutor(PeerTutor peerTutor, String courseCode) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
//        boolean isAssigned = false;
        DataSource dataSource = new DataSource();

        try {
            connection = dataSource.createConnection();

            // SQL query with JOIN to check if the course is already assigned to the peer tutor.
            String sql = "SELECT PT.FirstName, PT.LastName, PTC.Course_CourseCode FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID WHERE PT.FirstName = ? AND PT.LastName = ? AND PTC.Course_CourseCode = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, peerTutor.getFirstName());
            statement.setString(2, peerTutor.getLastName());
            statement.setString(3, courseCode);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
//                int count = resultSet.getInt(1);
//                isAssigned = (count > 0);
                  return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return false;
    }

    @Override
    public void assignCourseToPeerTutor(PeerTutor peerTutor, String courseCode) {
        Connection connection = null;
        PreparedStatement statement = null;
        DataSource dataSource = new DataSource();
        ResultSet resultSet = null;

        try {
            connection = dataSource.createConnection();
            
            String sql2 = "SELECT * FROM PeerTutor WHERE FirstName = ? AND LastName = ?";
            statement = connection.prepareStatement(sql2);
            statement.setString(1, peerTutor.getFirstName());
            statement.setString(2, peerTutor.getLastName());

            resultSet = statement.executeQuery();
            int gatheredID = 0;

            if (resultSet.next()) {
//                int count = rs.getInt(1);
//                isRegistered = (count > 0);
                  gatheredID = resultSet.getInt("PeerTutorID");
            }
            
            // SQL query to insert a new entry into the PeerTutorCourse table to assign the course to the peer tutor.
            String sql = "INSERT INTO PeerTutorCourse (PeerTutor_PeerTutorID, Course_CourseCode) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, gatheredID);
            statement.setString(2, courseCode);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public List<PeerTutor> getAllPeerTutorsForCourse(String courseCode) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<PeerTutor> peerTutors = new ArrayList<>();
        DataSource dataSource = new DataSource();
        // Get all peer tutors by course ID
        // it's a list, get the list
        // then check if one peer tutor is within the list, loop through list.
        // then compare, either by name, by id (ideally), etc.

        try {
            connection = dataSource.createConnection();

            // SQL query with JOIN to get all peer tutors assigned to the specified course.
            String sql = "SELECT PT.PeerTutorID, PT.LastName, PT.FirstName, PT.Email, PT.PhoneNumber FROM PeerTutor PT JOIN PeerTutorCourse PTC ON PT.PeerTutorID = PTC.PeerTutor_PeerTutorID WHERE PTC.Course_CourseCode = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, courseCode);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PeerTutor peerTutor = new PeerTutor();
                peerTutor.setPeerTutorID(resultSet.getInt("PeerTutorID"));
                peerTutor.setLastName(resultSet.getString("LastName"));
                peerTutor.setFirstName(resultSet.getString("FirstName"));
                peerTutor.setEmail(resultSet.getString("Email"));
                //peerTutor.setPhoneNumber(resultSet.getString("PhoneNumber"));

                peerTutors.add(peerTutor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions here.
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return peerTutors;
    }
}
