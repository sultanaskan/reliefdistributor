<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Relief Distribution System</title>
    <link rel="stylesheet" href="styles.css">
    <style type="text/css">/* styles.css */
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

.navbar {
    background-color: #333;
    color: white;
    padding-left: 10px;
    padding-right: 10px;
    text-align: center;
    position: relative;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.menu-toggle {
    cursor: pointer;
}

.profile-btn {
    background: none;
    border: none;
    cursor: pointer;
}

.profile-btn img {
    border-radius: 50%;
}

.sidebar {
    background-color: #444;
    color: white;
    padding: 10px;
    width: 200px;
    height: 100vh;
    position: fixed;
    display: none; /* Initially hidden */
}

.sidebar ul {
    list-style: none;
    padding: 0;
}

.sidebar ul li {
    margin: 10px 0;
}

.sidebar ul li a {
    text-decoration: none;
    color: white;
}

.main-content {
    margin-left: 210px;
    padding: 20px;
}

.footer {
    background-color: #333;
    color: white;
    text-align: center;
    padding: 10px;
    position: absolute;
    bottom: 0;
    width: 100%;
}

@media (max-width: 600px) {
    .main-content {
        margin-left: 0; /* Reset margin when sidebar is hidden */
    }
}
    </style>
    
</head>
<body>
    <!-- Navigation bar -->
    <nav class="navbar">
        <div class="menu-toggle" onclick="toggleSidebar()">&#9776;</div>
        <h3>Relief Distribution System</h3>
        <button class="profile-btn" onclick="profileClick()">
            <img src="https://via.placeholder.com/30" alt="Profile Icon">
        </button>
    </nav>

    <!-- Sidebar -->
    <div class="sidebar" id="sidebar">
        <ul>
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Distribution</a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Settings</a></li>
        </ul>
    </div>

    <!-- Main content -->
    <div class="main-content" id="main-content">
        <h2>Welcome to the Relief Distribution System</h2>
        <p>This is the home page for the system. Use the sidebar to navigate through the features.</p>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <p>© 2024 Relief Distribution System. All rights reserved.</p>
    </footer>

    <!-- JavaScript -->
    <script>
    // Function to toggle the visibility of the sidebar
    function toggleSidebar() {
        var sidebar = document.getElementById("sidebar");
        if (sidebar.style.display === "block") {
            sidebar.style.display = "none";
        } else {
            sidebar.style.display = "block";
        }
    }

    // Function to hide the sidebar when clicking outside of it
    document.addEventListener("click", function(event) {
        var sidebar = document.getElementById("sidebar");
        var menuToggle = document.querySelector(".menu-toggle");
        var profileBtn = document.querySelector(".profile-btn");
        if (sidebar.style.display === "block" && !sidebar.contains(event.target) && !menuToggle.contains(event.target) && !profileBtn.contains(event.target)) {
            sidebar.style.display = "none";
        }
    });

    function profileClick() {
        alert("Profile button clicked");
    }
    </script>
</body>
</html>
