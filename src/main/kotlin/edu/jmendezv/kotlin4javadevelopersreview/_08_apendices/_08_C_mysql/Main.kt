package edu.jmendezv.kotlin4javadevelopersreview._08_apendices._08_C_mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

/*
* sudo mysqld_safe --skip-grant-tables
* mysql -u root
* UPDATE mysql.user SET authentication_string=PASSWORD("rootpass") WHERE User='root';
* FLUSH PRIVILEGES;
* */

/*
CREATE TABLE Persons (
    id int NOT NULL AUTO_INCREMENT,
    lastName varchar(255) NOT NULL,
    firstName varchar(255),
    age int,
    PRIMARY KEY (id)
);
*
* */

data class Person(val id: Int, val lastName: String, val firstName: String, var age: Int)

fun main() {
    val jdbcUrl: String = "jdbc:mysql://localhost:3306/kotlin4javaprogrammers"
    val connection: Connection = DriverManager
        .getConnection(jdbcUrl, "root", "admin")
    // println(connection.isValid(0))
    // the query is only prepared not executed
    val query: PreparedStatement = connection.prepareStatement("SELECT * FROM Persons")

    // the query is executed and results are fetched
    val result: ResultSet = query.executeQuery()

    // an empty list for holding the results
    val users: MutableList<Person> = mutableListOf<Person>()

    while(result.next()){

        // getting the value of the id column
        val id: Int = result.getInt("id")

        // getting the value of the name column
        val lastName: String = result.getString("lastName")
        val firstName: String = result.getString("firstName")
        val age: Int = result.getInt("age")

        // constructing a User object and putting data into the list

        users.add(Person(id, lastName, firstName, age))
    }

    users.forEach(::println)
}