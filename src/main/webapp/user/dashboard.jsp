<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relief Distribution Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .dashboard {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .stats {
            margin-bottom: 20px;
        }

        .stats p {
            margin: 5px 0;
        }

        #showListButton {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        #registeredIndividuals {
            margin-top: 20px;
        }

        .hidden {
            display: none;
        }
    </style>
</head>
<body>
    <div class="dashboard">
        <h1>Relief Distribution Dashboard</h1>
        <div class="stats">
            <p>Total relief: <span id="totalRelief">1000</span></p>
            <p>Relief distributed: <span id="distributedRelief">500</span></p>
            <p>Remaining relief: <span id="remainingRelief">500</span></p>
        </div>
        <button id="showListButton" onclick="showRegisteredIndividuals()">Show Registered Individuals</button>
        <a id="showListButton" href="relief_distribute.jsp">Distribute New </a>
        
        <div id="registeredIndividuals" class="hidden">
            <h2>Registered Individuals for Relief:</h2>
            <ul id="individualsList">
                
            </ul>
        </div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const totalRelief = document.getElementById('totalRelief');
            const distributedRelief = document.getElementById('distributedRelief');
            const remainingRelief = document.getElementById('remainingRelief');
            const registeredIndividuals = document.getElementById('registeredIndividuals');

            let reliefCount = 0;
            let distributionCount = 0;
            let remainingCount = 0;
            const individualsList = [];

            function updateDashboard() {
                totalRelief.textContent = reliefCount;
                distributedRelief.textContent = distributionCount;
                remainingRelief.textContent = remainingCount;
            }

            function showRegisteredIndividuals() {
                individualsList.forEach(individual => {
                    const li = document.createElement('li');
                    li.textContent = individual;
                    document.getElementById('individualsList').appendChild(li);
                });
                registeredIndividuals.classList.remove('hidden');
            }

            // Sample usage:
            // Distribute 100 relief items
            reliefCount += 100;
            remainingCount += 100;

            // Distribute relief to individuals
            function distributeToIndividual(individual) {
                if (remainingCount > 0) {
                    distributionCount++;
                    remainingCount--;
                    individualsList.push(individual);
                    console.log(Relief distributed to ${individual});
                }
            }

            distributeToIndividual("John");
            distributeToIndividual("Alice");

            updateDashboard();
        });
    </script>
</body>
</html>