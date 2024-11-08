const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bodyParser = require('body-parser');

const app = express();
const db = new sqlite3.Database('./users.db');

app.use(bodyParser.json());

// Tạo bảng nếu chưa có
//db.run(`CREATE TABLE IF NOT EXISTS users (
//    id INTEGER PRIMARY KEY AUTOINCREMENT,
//    username TEXT NOT NULL,
//    password TEXT NOT NULL
//)`);

// API đăng ký
app.post('/register', (req, res) => {
    const { username, password } = req.body;
    const query = `INSERT INTO users (username, password) VALUES (?, ?)`;

    db.run(query, [username, password], function (err) {
        if (err) {
            return res.status(500).json({ message: "Lỗi khi đăng ký" });
        }
        res.status(201).json({ message: "Đăng ký thành công", userId: this.lastID });
    });
});

// API đăng nhập
app.post('/login', (req, res) => {
    const { username, password } = req.body;
    const query = `SELECT * FROM users WHERE username = ? AND password = ?`;

    db.get(query, [username, password], (err, row) => {
        if (err) {
            return res.status(500).json({ message: "Lỗi khi đăng nhập" });
        }
        if (row) {
            res.json({ message: "Đăng nhập thành công", userId: row.id });
        } else {
            res.status(401).json({ message: "Sai tên đăng nhập hoặc mật khẩu" });
        }
    });
});

// Khởi động server
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server chạy tại http://localhost:${PORT}`);
});
