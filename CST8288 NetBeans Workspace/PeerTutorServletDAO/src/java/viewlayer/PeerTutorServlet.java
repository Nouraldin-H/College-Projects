package viewlayer;

import businesslayer.PeerTutorBusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobject.PeerTutor;

public class PeerTutorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Peer Tutor Assignment</title>");
            out.println("</head>");
            out.println("<body bgcolor=\"#FDF5E6\">");
            out.println("<h2>Peer Tutor Assignment</h2>");

            // Retrieve input parameters from the request.
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String courseCode = request.getParameter("courseCode");

            // Instantiate a PeerTutor object and set its fields.
            PeerTutor peerTutor = new PeerTutor();
            peerTutor.setLastName(lastName);
            peerTutor.setFirstName(firstName);

            // Create a PeerTutorBusinessLogic object.
            PeerTutorBusinessLogic businessLogic = new PeerTutorBusinessLogic();

            // Add your case handling logic here.
            // Use if-else or switch statements to handle the different cases.
            // Display the appropriate information based on each case.
            int caseNumber = determineCase(peerTutor, courseCode, businessLogic);

            switch (caseNumber) {
                case 1:
                    // Case #1: The person is not registered as a peer tutor
                    // Display Course Code.
                    // Display Last Name and First Name.
                    out.println("Last Name: " + lastName + "<br>");
                    out.println("First Name: " + firstName);
                    out.println("<br><br><b>Error: This person is not registered as a peer tutor.</b>");
                    break;
                case 2:
                    // Case #2: The course is not valid
                    // Display Last Name and First Name.
                    out.println("Course Code: " + courseCode);
                    out.println("<br><br><b>Error: The course is not valid.</b>");
                    break;
                case 3:
                    // Case #3: The peer tutor has not taken the course
                    // Display Last Name, First Name, and Course Code.
                    out.println("Last Name: " + lastName + "<br>");
                    out.println("First Name: " + firstName + "<br>");
                    out.println("Course Code: " + courseCode);
                    out.println("<br><br><b>Error: The peer tutor has not taken the course.</b>");
                    break;
                case 4:
                    // Case #4: The letter grade obtained by the peer tutor for the course is not sufficient
                    // Display Last Name, First Name, and Course Code.
                    out.println("Last Name: " + lastName + "<br>");
                    out.println("First Name: " + firstName + "<br>");
                    out.println("Course Code: " + courseCode);
                    out.println("<br><br><b>Error: The letter grade obtained by the peer tutor for the course is not sufficient.</b>");
                    break;
                case 5:
                    // Case #5: The peer tutor is already assigned to the course
                    // Display Last Name, First Name, and Course Code.
                    out.println("Last Name: " + lastName + "<br>");
                    out.println("First Name: " + firstName + "<br>");
                    out.println("Course Code: " + courseCode);
                    out.println("<br><br><b>Error: The peer tutor is already assigned to the course.</b>");

                    break;
                case 6:
                    // Case #6: The course is assigned to the peer tutor
                    // Display the table of peer tutors assigned to the course.
                    businessLogic.assignCourseToPeerTutor(peerTutor, courseCode);
                    List<PeerTutor> assignedPeerTutors = businessLogic.getAllPeerTutorsForCourse(courseCode);
                    out.println("<table border=true>");
                    out.println("<br><br><b>" + courseCode + "</b>");
                    // Output the table rows for assigned peer tutors.
                    for (PeerTutor assignedTutor : assignedPeerTutors) {
                        out.println("<tr>");
                        out.println("<td>Tutor ID: " + assignedTutor.getPeerTutorID() + "</td>");
                        out.println("<td>Last Name: " + assignedTutor.getLastName() + "</td>");
                        out.println("<td>First Name: " + assignedTutor.getFirstName() + "</td>");
                        //out.println("<td>Course Code: " + courseCode + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    break;
                default:
                    out.println("<br><br><b>Processed incorrectly or a return is null (this message is for the developer).</b>");
                    break;
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    // Determine the appropriate case based on business logic.
    private int determineCase(PeerTutor peerTutor, String courseCode, PeerTutorBusinessLogic businessLogic) {
        int caseNumber = 0;  // Default case, you may need to change this.
        String grade = businessLogic.getPeerTutorLetterGradeForCourse(peerTutor, courseCode);

        // Implement your business logic to determine the case.
        // Use businessLogic methods to check conditions and return the case number.
        // Example:
        if (!businessLogic.isPeerTutorRegistered(peerTutor)) {
            caseNumber = 1;
        } else if (!businessLogic.isCourseValid(courseCode)) {
            caseNumber = 2;
        } else if (!businessLogic.hasPeerTutorTakenCourse(peerTutor, courseCode)) {
            caseNumber = 3;
        } else if (!grade.equals("A-") && !grade.equals("A") && !grade.equals("A+")) {
            caseNumber = 4;
        } else if (businessLogic.isCourseAlreadyAssignedToPeerTutor(peerTutor, courseCode)) {
            caseNumber = 5;
        }
        else { // TODO: Retrieve Peer Tutor ID somehow and set the 
            caseNumber = 6;
        }

        return caseNumber;
    }
}
