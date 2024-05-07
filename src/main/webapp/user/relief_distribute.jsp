<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relief Receive System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .input-group {
            margin-bottom: 20px;
            text-align: center;
        }
        .input-group input[type="text"] {
            width: calc(100% - 80px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px 0 0 5px;
            outline: none;
            font-size: 16px;
        }
        .input-group button {
            width: 80px;
            padding: 10px;
            border: none;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
            outline: none;
            font-size: 16px;
            margin-top: 10px;
            transition: background-color 0.3s;
        }
        .input-group button:hover {
            background-color: #0056b3;
        }
        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 18px;
        }
        .success {
            color: #28a745;
        }
        .error {
            color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Give your collection code</h1>
        <div class="input-group">
            <input type="text" id="codeInput" placeholder="Give me your code">
            <button onclick="checkCode()">Submit</button>
        </div>
        <div class="message" id="message"></div>
    </div>

    <script>
        function checkCode() {
            var codeInput = document.getElementById('codeInput').value;
            var presetCodes = ['100', '200', '300'];
            if (presetCodes.includes(codeInput)) {
                document.getElementById('message').innerText = 'This User is Eligble for 10 kg rice)';
                document.getElementById('message').classList.remove('error');
                document.getElementById('message').classList.add('success');
            } else {
                document.getElementById('message').innerText = 'This User is not Eligble!';
                document.getElementById('message').classList.remove('success');
                document.getElementById('message').classList.add('error');
            }
        }
    </script>
</body>
</html>