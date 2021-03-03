def clients = ['user', 'pet']
def groups = ['smoke', 'regression']
properties([parameters([choice(choices: clients, description: 'Run on specific device', name: 'CLIENT'),
                        choice(choices: groups, description: 'Run specific group of tests', name: 'TEST_GROUP')]
                        )])


   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven"
   }
// main task
for(int i = 0; i < clients.size(); i++) {
    def client = clients[i]
        node {
             stage ("Execute tests for ${client}") {
                    bat "mvn clean test -Dclient=${client}\""


            }
            stage ("Aggregate reports for ${client}") {
                bat "allure generate allure-results --clean -o allure-report"
            }
            stage ("Publish HTML report for ${client}") {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true,
                             reportDir: 'build/reports/allure-report', reportFiles: 'index.html',
                             reportName: "TestReport_${client}", reportTitles: "Test report for ${client}"])
            }


    }
}

