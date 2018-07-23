package com.hand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    public static final int COUNTRY_ID;
    public static final int CUSTOMER_ID;

    static {
        COUNTRY_ID = Integer.parseInt(System.getenv("country-id"));
        CUSTOMER_ID = Integer.parseInt(System.getenv("customer-id"));
    }

    public static void main(String[] args) {
        System.out.println("=======第一题====");
        selectByCountryID();
        System.out.println("======第二题=====");
        selectByCostumerID();
    }

    public final static void  selectByCountryID() {
        String sql1 = "SELECT * FROM country WHERE country.country_id = ?";
        String sql2 = "SELECT * FROM city WHERE city.country_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, COUNTRY_ID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String countryName = resultSet.getString("country");

            System.out.println("Country ID: " + COUNTRY_ID);
            System.out.println("Country `" + countryName + "` 的城市：");
            System.out.println("城市 ID \t| 城市名称");

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, COUNTRY_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("city_id"));
                System.out.print("  \t| ");
                System.out.println(resultSet.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public final static void selectByCostumerID() {

        String sql1 = "select * from customer where customer.customer_id = ?";
        String sql2 = "select f.*, r.rental_date from film f, rental r, inventory i where r.customer_id = ? and r.inventory_id = i.inventory_id and i.film_id = f.film_id order by r.rental_date DESC";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, CUSTOMER_ID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String customerName = resultSet.getString("first_name");

            System.out.println("Customer ID: " + CUSTOMER_ID);
            System.out.println("`" + customerName + "` 租用的Film：");
            System.out.println("Film ID    \t| Film名称 \t| 租用时间");

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, CUSTOMER_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("film_id"));
                System.out.print("  \t| ");
                System.out.print(resultSet.getString("title"));
                System.out.print("  \t| ");
                System.out.println(resultSet.getString("rental_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}