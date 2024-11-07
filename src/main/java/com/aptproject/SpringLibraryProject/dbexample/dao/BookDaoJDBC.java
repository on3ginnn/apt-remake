package com.aptproject.SpringLibraryProject.dbexample.dao;

import com.aptproject.SpringLibraryProject.dbexample.db.DBConnection;
import com.aptproject.SpringLibraryProject.dbexample.model.Book;

import java.sql.*;

public class BookDaoJDBC {
    public Book findBookById (Integer bookId) {
        try (Connection connection = DBConnection.INSTANCE.getConnection()) {
            if (connection != null) {
                System.out.println("Ура! Мы подключились к базе данных.");
            } else {
                System.out.println("БД недоступна.");
            }

            String select = "select * from books where id = ?";
            PreparedStatement selectQuery = connection.prepareStatement(select);
            selectQuery.setInt(1, bookId);
            ResultSet resultSet = selectQuery.executeQuery();

            while (resultSet.next()) {
               Book book = new Book();
               book.setId(resultSet.getInt("id"));
               book.setAuthor(resultSet.getString("author"));
               book.setTitle(resultSet.getString("title"));
               book.setDateAdded(resultSet.getDate("date_added"));
               System.out.println(book);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }
}
