node('master')
{
stage('git checkout')
{
git 'https://github.com/Mani9257/ING-BookLib-Java.git'
}
stage('java build')
{
sh '/opt/maven/bin/mvn clean package verify sonar:sonar -Dsonar.password=admin -Dsonar.login=admin'
}
   stage("build & SonarQube analysis") {
              withSonarQubeEnv(‘sonar') {
                 sh '/opt/maven/bin/mvn clean package sonar:sonar'
              }
          }
      stage("Quality Gate"){
          timeout(time: 30, unit: 'SECONDS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
  stage('Running java backend application')

{

sh 'export JENKINS_NODE_COOKIE=dontKillMe ;nohup java -jar $WORKSPACE/target/*.jar &'

}
}
