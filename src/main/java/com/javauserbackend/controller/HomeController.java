package com.javauserbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // 🏠 Root endpoint
    // Visiting https://your-app.onrender.com/
    // will display this HTML page.
    @GetMapping(value = "/", produces = "text/html")
    public String home() {

        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Java Spring Boot Backend</title>
                    <style>
                        body {
                            margin: 0;
                            min-height: 100vh;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            font-family: Arial, sans-serif;
                            background: linear-gradient(135deg, #0f172a, #1e3a8a);
                            color: white;
                        }

                        .card {
                            text-align: center;
                            padding: 40px;
                            border-radius: 20px;
                            background: rgba(255, 255, 255, 0.1);
                            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
                        }

                        h1 {
                            margin-bottom: 10px;
                        }

                        p {
                            color: #dbeafe;
                        }

                        .status {
                            display: inline-block;
                            margin-top: 15px;
                            padding: 10px 20px;
                            border-radius: 999px;
                            background: #16a34a;
                            font-weight: bold;
                        }
                    </style>
                </head>

                <body>
                    <div class="card">
                        <h1>🚀 Java Spring Boot Backend</h1>
                        <p>Backend is up and running successfully!</p>
                        <div class="status">🟢 LIVE</div>
                        <p>🐘 Database: Supabase PostgreSQL</p>
                        <p>☁️ Deployment: Render</p>
                    </div>
                </body>
                </html>
                """;
    }
}