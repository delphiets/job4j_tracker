package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        Properties config = new Properties();
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.cn = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (this.cn != null) {
            this.cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement pr = this.cn.prepareStatement("insert into items(name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            pr.setString(1, item.getName());
            pr.execute();
            try (ResultSet resultSet = pr.getGeneratedKeys()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getString(1));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement pr = this.cn.prepareStatement("update items set name = ? where id = ?")) {
            pr.setString(1, item.getName());
            pr.setInt(2, Integer.parseInt(id));
            result = pr.executeUpdate() > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement pr = this.cn.prepareStatement("delete from items where id = ?")) {
            pr.setInt(1, Integer.parseInt(id));
            result = pr.executeUpdate() > 0;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pr = this.cn.prepareStatement("select * from items")) {
            try (ResultSet res = pr.executeQuery()) {
                while (res.next()) {
                    items.add(new Item(res.getString("id"), res.getString("name")));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pr = this.cn.prepareStatement("select * from items where name = ?")) {
            pr.setString(1, key);
            try (ResultSet res = pr.executeQuery()) {
                while (res.next()) {
                    items.add(new Item(res.getString("id"), res.getString("name")));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(String id) {
        Item item = new Item();
        try (PreparedStatement pr = this.cn.prepareStatement("select * from items where id = ?")) {
            pr.setInt(1, Integer.parseInt(id));
            try (ResultSet res = pr.executeQuery()) {
                if (res.next()) {
                    item = new Item(res.getString("id"));
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return item;
    }
}
