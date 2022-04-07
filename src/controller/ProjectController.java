package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import model.Task;
import util.ConnectionFactory;

public class ProjectController {

	public void save(Project project) {

		String sql = "INSERT INTO projects (name," + "description," + "createdAt," + "updatedAt) VALUES (?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar tarefa" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);

		}
	}

	public void update(Task project) {

		String sql = "UPDATE projects SET" + "name = ?, " + "createdAt = ?, " + "updatedAt = ?, " + "WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// estabelecendo conexao com bd.
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar a tarefa" + e.getMessage(), e);
		}

	}

	public List<Task> getAll(int id_project) {

		String sql = "SELECT * FROM projects WHERE id_project = ?";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		// Lista de tarefas que será devolvida qdo a chamada do método acontecer.
		List<Task> projects = new ArrayList<Task>();

		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id_project);

			result = statement.executeQuery();

			while (result.next()) {

				Task project = new Task();

				project.setId(result.getInt("id"));
				project.setName(result.getString("name"));
				project.setDescription(result.getString("description"));
				project.setCreatedAt(result.getDate("createdAt"));
				project.setUpdateAt(result.getDate("updatedAt"));

				projects.add(project);
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir tarefa" + e.getMessage());

		} finally {

			ConnectionFactory.closeConnection(connection, statement, result);
		}

		// lista de tarefas que foi carregada no bd.
		return projects;

	}

	public void removeById(int projectId) throws SQLException {

		String sql = "DELETE FROM project WHERE id = ?*";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// criação da conexão com bd.
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, projectId);
			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar tarefa" + e.getMessage());

		} finally {

			ConnectionFactory.closeConnection(connection, statement);
		}

	}

}
