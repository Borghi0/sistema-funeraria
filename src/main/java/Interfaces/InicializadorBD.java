package Interfaces;

import java.sql.SQLException;


public interface InicializadorBD {
    void criarTabelas() throws SQLException, ClassNotFoundException;
}