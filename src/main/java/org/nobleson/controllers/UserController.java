package org.nobleson.controllers;

import com.google.gson.Gson;
import org.nobleson.models.AppUsers;
import org.nobleson.repository.UserRepo;
import org.nobleson.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/api/users/*")
public class UserController extends HttpServlet {
   // private  UserService userService = new UserService();
    private Gson gson = new Gson();
    private UserRepo userRepo = new UserRepo();


    /**
     * GET API
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            List<AppUsers> users ;
            users = userRepo.getAllUsers();
            String json = gson.toJson(users);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }
        else {
            String[] splits = pathInfo.split("/");
            if (splits.length == 2) {
                int userId = Integer.parseInt(splits[1]);
                AppUsers user = userRepo.getUserByUserID(userId);
                if (user != null) {
                    String json = gson.toJson(user);
                    response.setContentType("application/json");
                    response.getWriter().write(json);

                }
                else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }

            }

            else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }

    /**
     * POST API
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        AppUsers user = gson.fromJson(request.getReader(), AppUsers.class);
        userRepo.addUser(user);
        response.setStatus(HttpServletResponse.SC_CREATED);
    } catch (SQLException e) {
       response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }
    }


    /**
     * POST API
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String pathInfo = req.getPathInfo();
       if (pathInfo == null || pathInfo.equals("/")) {
           resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
           return;
       }
       String[] splits = pathInfo.split("/");
       if (splits.length != 2) {
           resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
           return;
       }

       int userId = Integer.parseInt(splits[1]);
       try {
           AppUsers user = gson.fromJson(req.getReader(), AppUsers.class);
           user.setUserID(userId);
           userRepo.updateUser(user);
           resp.setStatus(HttpServletResponse.SC_OK);
       }
       catch (Exception e) {
           resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
       }

    }


    //DELETE API

    /**
     * DELETE API
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;

        }
        int userId = Integer.parseInt(splits[1]);
        try {
            userRepo.deleteUser(userId);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
