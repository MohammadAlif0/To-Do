
package todo1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    // Add a new task
    public void addTask(String name, String description, String priority) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO tasks (name, description, priority) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setString(3, priority);
            stmt.executeUpdate();
            System.out.println("Task added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all tasks
    public List<Task> getTasks() {
        List<Task> taskList = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM tasks ORDER BY FIELD(priority, 'High', 'Medium', 'Low')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                taskList.add(new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("priority"),
                        rs.getBoolean("isCompleted")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    // Mark task as completed
    public void markTaskCompleted(int taskId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE tasks SET isCompleted = TRUE WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, taskId);
            stmt.executeUpdate();
            System.out.println("Task marked as completed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete task
    public void deleteTask(int taskId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM tasks WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, taskId);
            stmt.executeUpdate();
            System.out.println("Task deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

