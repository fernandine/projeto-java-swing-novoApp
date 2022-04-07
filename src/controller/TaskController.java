package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {

	public void save(Task task) {

		String sql = "INSERT INTO tasks (" 
				+ "id_project," 
				+ "name," 
				+ "description," 
				+ "completed," 
				+ "notes," 
				+ "deadline,"
				+ "createdAt," 
				+ "updatedAt) VALUES (?,?,?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, task.getId_project());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar tarefa" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);

		}
	}

	public void update(Task task) {

		String sql = "UPDATE tasks SET" 
				+ "idProject = ?, " 
				+ "name = ?, " 
				+ "notes = ?, " 
				+ "completed = ?, "
				+ "deadline = ?, " 
				+ "createdAt = ?, " 
				+ "updatedAt = ?, " 
				+ "WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// estabelecendo conexao com bd.
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, task.getId_project());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getId());
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar a tarefa" + e.getMessage(), e);
		}

	}

	public void removeById(int taskId) throws SQLException {

		String sql = "DELETE FROM task WHERE id = ?*";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// criação da conexão com bd.
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, taskId);
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar tarefa" + e.getMessage());

		} finally {

			ConnectionFactory.closeConnection(connection, statement);
		}

	}

	public List<Task> getAll(int id_project) {

		String sql = "SELECT * FROM taskes WHERE id_project = ?";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		// Lista de tarefas que será devolvida qdo a chamada do método acontecer.
		List<Task> tasks = new ArrayList<Task>();

		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id_project);

			result = statement.executeQuery();

			while (result.next()) {
				Task task = new Task();
				task.setId(result.getInt("id"));
				task.setId_project(result.getInt("id_project"));
				task.setName(result.getString("name"));
				task.setDescription(result.getString("description"));
				task.setNotes(result.getString("notes"));
				task.setCompleted(result.getBoolean("completed"));
				task.setDeadline(result.getDate("deadline"));
				task.setCreatedAt(result.getDate("createdAt"));
				task.setUpdateAt(result.getDate("UpdatedAt"));

				tasks.add(task);
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir tarefa" + e.getMessage());

		} finally {

			ConnectionFactory.closeConnection(connection, statement, result);
		}

		// lista de tarefas que foi carregada no bd.
		return tasks;

	}

}
