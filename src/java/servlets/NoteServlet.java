
package servlets;


import domain.Note;
import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {    
            Note note = new Note();
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            // to read files
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String line = br.readLine();
            List<String> lines = new ArrayList<>();
            
            while(line != null){
                lines.add(line);
                line = br.readLine();
            }
            
            note.setTitle(lines.get(0));
            note.setContents(lines.get(1));
            request.setAttribute("note", note);          
        }        
        catch(IOException e){
            e.printStackTrace();
        }

        String edit = request.getParameter("edit");
        if (edit == null){ 
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title_input");
        String contents = request.getParameter("contents_input");
        
        Note note = new Note(title, contents);
        note.setTitle(title);
        note.setContents(contents);
        request.setAttribute("note", note);
        
        try {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path,false)));
  
            pw.println(title);
            pw.println(contents);

            pw.close();
                  
        }        
        catch(IOException e){
            e.printStackTrace();
        }
       
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
    }

   

}
