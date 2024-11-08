const express = require('express');
const sqlite3 = require('sqlite3').verbose();
const bodyParser = require('body-parser');

const app = express();
const db_user = new sqlite3.Database('./users.db');
const db_article = new sqlite3.Database('./article.db');

//db_article.run(`CREATE TABLE IF NOT EXISTS articles (
//    id INTEGER PRIMARY KEY AUTOINCREMENT,
//    title TEXT NOT NULL,
//    description TEXT,
//    content TEXT NOT NULL
//)`);

app.use(bodyParser.json());



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

app.post('/add-article', (req, res) => {
    const { title, description, content } = req.body;
    const query = `INSERT INTO articles (title, description, content) VALUES (?, ?, ?)`;

    db_article.run(query, [title, description, content], function (err) {
        if (err) {
            return res.status(500).json({ message: "Lỗi khi thêm bài báo" });
        }
        res.status(201).json({ message: "Thêm bài báo thành công", articleId: this.lastID });
    });
});

// Khởi động server
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server chạy tại http://localhost:${PORT}`);
});
