# IPL-Dashboard
Browse your favorite IPL teams and access their past games details, wins and losses ratios - accessible by team and tournament year.

# Technologies Used
<ul>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>HSQL DB / MySQL</li>
  <li>React JS</li>
</ul>

# How To Run locally
<ol>
  <li>Clone the repository.</li>
  <li>Move to `src/frontend/` from the root directory using the command:
  
      cd src/frontend
  </li>
  <li>Run the below command to install the dependencies.</li>
    
    npm install 
  <li>Run</li>
    
    npm build
  <li>Now move to `src/main/java/com/ipl/dashboard/` and run `DashboardApplication.java`.</li>
  <li>The application will run on:</li>
    
    http://localhost:8080/
  </ol>

Note:<br>
1. Do the above steps from 1 to 4 if and only if you are running this application on your local system for the first time; else, directly move to step 5.
2. Make sure the port: 8080 is available.
